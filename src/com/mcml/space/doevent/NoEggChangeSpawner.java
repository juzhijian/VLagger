package com.mcml.space.doevent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

import com.mcml.space.core.VLagger;

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
            if (e.getItem().getType() == Material.MONSTER_EGG || e.getItem().getType() == Material.MONSTER_EGGS) {
                if (e.getClickedBlock().getType() == Material.MOB_SPAWNER) {
                    e.setCancelled(true);
                    if(VLagger.NoEggChangeSpawnerTipMessage.equalsIgnoreCase("none") == false){
                        e.getPlayer().sendMessage(VLagger.PluginPrefix + VLagger.NoEggChangeSpawnerTipMessage);
                    }
                }
            }
        }
    }
}
