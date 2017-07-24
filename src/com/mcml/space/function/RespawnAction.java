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

public class RespawnAction implements Listener {
	@EventHandler(priority = EventPriority.MONITOR)
	public void autoRespawn(PlayerDeathEvent evt) {
		if (ConfigFunction.canAutoRespawn) {
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
