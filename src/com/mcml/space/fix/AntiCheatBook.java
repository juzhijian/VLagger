package com.mcml.space.fix;

import java.util.Map.Entry;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.BookMeta.Generation;

import com.mcml.space.config.ConfigAntiBug;
import com.mcml.space.util.AzureAPI;

public class AntiCheatBook implements Listener {
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBookEdit(PlayerEditBookEvent evt) {
        BookMeta prev = evt.getPreviousBookMeta();
        BookMeta meta = evt.getNewBookMeta();
        if (prev.equals(meta)) return;
        
        // Illegally modify lore
        if (prev.hasLore()) {
            if (!meta.hasLore() || !prev.getLore().equals(meta.getLore())) {
                meta.setLore(prev.getLore());
            }
        } else if (meta.hasLore()) {
            meta.setLore(null);
        }
        
        // Illegally modify enchants
        if (prev.hasEnchants()) {
            if (!meta.hasEnchants()) {
                addEnchantFrom(prev, meta);
            } else if (!prev.getLore().equals(meta.getLore())) {
                clearEnchant(meta);
                addEnchantFrom(prev, meta);
            }
        } else if (meta.hasEnchants()) {
            clearEnchant(meta);
        }
        
        // They cannot change title by edit it!
        String title = prev.getTitle();
        if (!title.equals(meta.getTitle())) {
            meta.setTitle(title);
        }
        
        // Book and quill doesn't has a generation!
        if (meta.getGeneration() != null) meta.setGeneration(null);
        
        // Book and quill doesn't has an author!
        if (meta.getAuthor() != null) meta.setAuthor(null);
        
        evt.setNewBookMeta(meta);
        
        if(!ConfigAntiBug.AntiCheatBookWarnMessage.equalsIgnoreCase("none")){
            AzureAPI.log(evt.getPlayer(), ConfigAntiBug.AntiCheatBookWarnMessage);
        }
    }
    
    public static BookMeta clearEnchant(BookMeta meta) {
        for (Enchantment e : meta.getEnchants().keySet()) {
            meta.removeEnchant(e);
        }
        return meta;
    }
    
    public static BookMeta addEnchantFrom(BookMeta source, BookMeta meta) {
        for (Entry<Enchantment, Integer> e : source.getEnchants().entrySet()) {
            meta.addEnchant(e.getKey(), e.getValue(), true);
        }
        return meta;
    }
}