package com.mcml.space.fix;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.mcml.space.core.VLagger;

import org.bukkit.event.player.*;

public class AntiDropInfItem
        implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void CheckDropNoBugInfItem(PlayerDropItemEvent e) {
    	Bukkit.broadcastMessage("丢出监听器被触发");
		if(VLagger.AntiDropInfItemenable == true){
			if (e.getPlayer() == null || e.getPlayer().isOnline()==false || e.getPlayer().isValid()==false) {
				e.setCancelled(true);
			}
		}
    }
}
