package com.mcml.space.fix;

import org.bukkit.*;
import org.bukkit.enchantments.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;

import com.mcml.space.config.ConfigAntiBug;
import com.mcml.space.core.VLagger;

import org.bukkit.event.player.*;

public class AntiCheatBook implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler
    public void ClickItemCheck(InventoryClickEvent e) {
        if (ConfigAntiBug.AntiCheatBookenable == true) {
            ItemStack item = e.getCurrentItem();
            if (e.getWhoClicked().getType() != EntityType.PLAYER) {
                return;
            }
            Player p = (Player) e.getWhoClicked();
            if (item == null) {
                return;
            }
            if (item.getType() == Material.WRITTEN_BOOK & item.getItemMeta().hasEnchants() == true) {
                for (int i = 0; Enchantment.getById(i) != null; i++) {
                    Enchantment ench = Enchantment.getById(i);
                    item.removeEnchantment(ench);
                }
                if(ConfigAntiBug.AntiCheatBookWarnMessage.equalsIgnoreCase("none") == false){
                    p.sendMessage(VLagger.PluginPrefix + ConfigAntiBug.AntiCheatBookWarnMessage);
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void InteractCheck(PlayerInteractEvent e) {
        if (ConfigAntiBug.AntiCheatBookenable == true) {
            ItemStack item = e.getItem();
            Player p = e.getPlayer();
            if (item == null) {
                return;
            }
            if (item.getType() == Material.WRITTEN_BOOK & item.getItemMeta().hasEnchants() == true) {
                for (int i = 0; Enchantment.getById(i) != null; i++) {
                    Enchantment ench = Enchantment.getById(i);
                    item.removeEnchantment(ench);
                }
                if(ConfigAntiBug.AntiCheatBookWarnMessage.equalsIgnoreCase("none") == false){
                    p.sendMessage(VLagger.PluginPrefix + ConfigAntiBug.AntiCheatBookWarnMessage);
                }
            }
        }
    }
}