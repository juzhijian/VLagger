package com.mcml.space;

import org.bukkit.*;
import org.bukkit.enchantments.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;
import org.bukkit.event.player.*;

public class AntiCheatBook implements Listener {

    @EventHandler
    public void ClickItemCheck(InventoryClickEvent e) {
        if (VLagger.AntiCheatBookenable == true) {
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
                p.sendMessage(VLagger.PluginPrefix + VLagger.AntiCheatBookWarnMessage);
            }
        }
    }

    @EventHandler
    public void InteractCheck(PlayerInteractEvent e) {
        if (VLagger.AntiCheatBookenable == true) {
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
                p.sendMessage(VLagger.PluginPrefix + VLagger.AntiCheatBookWarnMessage);
            }
        }
    }
}
