package com.mcml.space.doevent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.mcml.space.config.ConfigDoEvent;
import com.mcml.space.core.VLagger;
import com.mcml.space.util.VersionLevel;

public class AutoRespawn implements Listener {
	@EventHandler
	public void AutoRespawner(PlayerDeathEvent event) {
		if (ConfigDoEvent.AutoRespawnenable == true) {
			final Player player = event.getEntity();
			Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable() {
				@Override
				@SuppressWarnings("deprecation")
				public void run() {
					if (VersionLevel.isSpigot()) {
						player.spigot().respawn();
						if (ConfigDoEvent.AutoRespawnRespawnTitleenable) {
							player.sendTitle(ConfigDoEvent.AutoRespawnRespawnTitleMainMessage,
									ConfigDoEvent.AutoRespawnRespawnTitleMiniMessage);
						}
					}
				}
			}, 1);
		}
	}
}
