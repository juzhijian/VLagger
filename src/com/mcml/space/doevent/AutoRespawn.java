/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcml.space.doevent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.mcml.space.core.VLagger;

/**
 *
 * @author Administrator
 */
public class AutoRespawn implements Listener {
	@EventHandler
	public void AutoRespawner(PlayerDeathEvent event) {
		if (VLagger.AutoRespawnenable == true) {
			final Player player = event.getEntity();
			Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable() {
				@SuppressWarnings("deprecation")
				public void run() {
					try {
						player.spigot().respawn();
						if(VLagger.AutoRespawnRespawnTitleenable == true){
							player.sendTitle(VLagger.AutoRespawnRespawnTitleMainMessage, VLagger.AutoRespawnRespawnTitleMiniMessage);
						}
					} catch (Throwable ex) {
					}
				}
			}, 1);
		}
	}
}
