package com.mcml.space.function;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.mcml.space.config.ConfigFunction;
import com.mcml.space.core.VLagger;
import com.mcml.space.util.VersionLevel;

public class AutoRespawn implements Listener {
	@EventHandler
	public void AutoRespawner(PlayerDeathEvent event) {
		if (ConfigFunction.AutoRespawnenable == true) {
			final Player player = event.getEntity();
			Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable() {
				@Override
				@SuppressWarnings("deprecation")
				public void run() {
					if (VersionLevel.isSpigot()) {
						player.spigot().respawn();
						if (ConfigFunction.AutoRespawnRespawnTitleenable) {
							player.sendTitle(ConfigFunction.AutoRespawnRespawnTitleMainMessage,
									ConfigFunction.AutoRespawnRespawnTitleMiniMessage);
						}
					}
				}
			}, 1);
		}
	}
}
