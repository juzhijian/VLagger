package com.mcml.space.function;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.mcml.space.config.ConfigFunction;
import com.mcml.space.core.VLagger;

import lombok.val;

import static com.mcml.space.config.ConfigFunction.canAutoRespawn;

/**
 * @author Vlvxingze, SotrForgotten
 */
public class RespawnAction implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void autoRespawn(PlayerDeathEvent evt) {
        if (canAutoRespawn) {
            val player = evt.getEntity();
            Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable() {
                @Override
                public void run() {
                    player.spigot().respawn();
                }
            }, 1);
        }
    }

    @SuppressWarnings("all")
    @EventHandler(priority = EventPriority.LOWEST)
    public void title(PlayerRespawnEvent evt) {
        if (ConfigFunction.sendTitleOnRespawn) {
            evt.getPlayer().sendTitle(ConfigFunction.AutoRespawnRespawnTitleMainMessage, ConfigFunction.AutoRespawnRespawnTitleMiniMessage);
        }
    }
}
