package com.mcml.space.doevent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.mcml.space.config.ConfigDoEvent;
import com.mcml.space.core.VLagger;

public class AutoRespawn implements Listener {
    @EventHandler
    public void AutoRespawner(PlayerDeathEvent event) {
        if (ConfigDoEvent.AutoRespawnenable == true) {
            final Player player = event.getEntity();
            Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable() {
                @Override
                @SuppressWarnings("deprecation")
                public void run() {
                    try {
                        player.spigot().respawn();
                        if(ConfigDoEvent.AutoRespawnRespawnTitleenable == true){
                            player.sendTitle(ConfigDoEvent.AutoRespawnRespawnTitleMainMessage, ConfigDoEvent.AutoRespawnRespawnTitleMiniMessage);
                        }
                    } catch (Throwable ex) {
                    }
                }
            }, 1);
        }
    }
}
