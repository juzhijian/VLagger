package com.mcml.space;

import org.bukkit.Bukkit;
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
import org.bukkit.inventory.ItemStack;

public class AntiInfItem
        implements Listener {

    @EventHandler
    public void InteractCheck(PlayerInteractEvent event) {
        if (VLagger.AntiInfItemenable == true) {
            Player player = event.getPlayer();
            if (event.getItem() != null) {
                if (event.getItem().getAmount() <= 0) {
                    ItemStack item = event.getItem();
                    event.setCancelled(true);
                    player.setItemInHand(null);
                    player.sendMessage("§a§l[VLagger]§c警告！不允许使用负数物品！");
                }
            }
        }
    }

    @EventHandler
    public void DispenseCheck(BlockDispenseEvent event) {
        if (VLagger.AntiInfItemenable == true) {
            Block block = event.getBlock();
            int i;
            if (block.getTypeId() == 23) {
                BlockState blockin = block.getState();
                Inventory Inventory = ((Dispenser) blockin).getInventory();
                for (i = 0; i < Inventory.getSize(); i++) {
                    if (Inventory.getItem(i) != null) {
                        if (Inventory.getItem(i).getAmount() < 0) {
                            Inventory.getItem(i).setType(Material.AIR);
                            event.setCancelled(true);
                            Bukkit.broadcastMessage("§a§l[VLagger]§c在 §b" + event.getBlock().getLocation().toString() + " §c发现一个负数物品的发射器！内部负数物品已经移除！");
                        }
                    }
                }
            } else if (block.getType() == Material.DROPPER||block.getType() == Material.DISPENSER) {
                BlockState blockin = block.getState();
                Inventory Inventory = ((Dropper) blockin).getInventory();
                for (i = 0; i < Inventory.getSize(); i++) {
                    if ((Inventory.getItem(i) != null) && (Inventory.getItem(i).getAmount() < 0)) {
                        Inventory.getItem(i).setType(Material.AIR);
                        event.setCancelled(true);
                        Bukkit.broadcastMessage("§a§l[VLagger]§c在 §b" + event.getBlock().getLocation().toString() + " §c发现一个负数物品的发射器！内部负数物品已经移除！");
                    }
                }
            }
        }
    }
}