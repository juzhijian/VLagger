package com.mcml.space.fix;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Dropper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import com.mcml.space.config.ConfigAntiBug;
import com.mcml.space.config.ConfigPluginMain;

public class AntiInfItem implements Listener {

    @EventHandler
    @SuppressWarnings("deprecation")
    public void InteractCheck(PlayerInteractEvent event) {
        if (ConfigAntiBug.noInfItem == true) {
            Player player = event.getPlayer();
            if (event.getItem() != null) {
                if (event.getItem().getAmount() <= 0) {
                    event.setCancelled(true);
                    player.setItemInHand(null);
                    if(ConfigAntiBug.AntiInfItemClickcWarnMessage.equalsIgnoreCase("none") == false){
                        player.sendMessage(ConfigPluginMain.PluginPrefix + ConfigAntiBug.AntiInfItemClickcWarnMessage);
                    }
                }
            }
        }
    }

    @EventHandler
    public void DispenseCheck(BlockDispenseEvent event) {
        if (ConfigAntiBug.noInfItem == true) {
            Block block = event.getBlock();
            int i;
            if (block.getType() == Material.DISPENSER) {
                BlockState blockin = block.getState();
                Inventory Inventory = ((Dispenser) blockin).getInventory();
                int invs = Inventory.getSize();
                for (i = 0; i < invs; i++) {
                    if (Inventory.getItem(i) != null) {
                        if (Inventory.getItem(i).getAmount() <= 0) {
                            Inventory.getItem(i).setType(Material.AIR);
                            event.setCancelled(true);
                        }
                    }
                }
            } else if (block.getType() == Material.DROPPER) {
                BlockState blockin = block.getState();
                Inventory Inventory = ((Dropper) blockin).getInventory();
                int invs = Inventory.getSize();
                for (i = 0; i < invs; i++) {
                    if(Inventory.getItem(i) != null){
                        if (Inventory.getItem(i).getAmount() <= 0) {
                            Inventory.getItem(i).setType(Material.AIR);
                            event.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}