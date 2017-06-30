package com.mcml.space;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.Material;

public class NoEggChangeSpawner
        implements Listener {

    @EventHandler
    public void NoChangeLimit(PlayerInteractEvent e) {
        if (e.getItem() == null) {
            return;
        }
        if (e.getClickedBlock() == null) {
            return;
        }
        if (e.getPlayer().hasPermission("VLagger.admin")) {
            return;
        }
        if (VLagger.NoEggChangeSpawnerenable == true) {
            if (e.getItem().getType() == Material.MONSTER_EGG | e.getItem().getType() == Material.MONSTER_EGGS) {
                if (e.getClickedBlock().getType() == Material.MOB_SPAWNER) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage("§a§l[VLagger]§c抱歉，禁止使用刷怪蛋修改刷怪笼");
                }
            }
        }
    }
}
