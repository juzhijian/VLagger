package com.mcml.space.fix;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.InventoryHolder;

import com.mcml.space.core.VLagger;

public class AntiBreakUseingChest implements Listener {

    @EventHandler
    public void CheckNoBreakChest(BlockBreakEvent e) {
        if (VLagger.AntiBreakUseingChestenable == true) {
            Player p = e.getPlayer();
            if (e.getBlock().getState() instanceof InventoryHolder) {
                InventoryHolder ih = (InventoryHolder) e.getBlock().getState();
                if (ih.getInventory().getViewers().isEmpty() == true) {
                    e.setCancelled(true);
                    p.sendMessage("§a[VLagger]§c抱歉！您不可以破坏一个正在被使用的容器");
                }
            }
        }
    }
}
/**
@author jiongjionger
部分源码来自 https://github.com/jiongjionger/NeverLag
*/
