package com.mcml.space.fix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.mcml.space.core.VLagger;

import org.bukkit.event.player.*;

public class AntiDropInfItem
        implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void CheckDropNoBugInfItem(PlayerDropItemEvent e) {
		if(VLagger.AntiDropInfItemenable == true){
			if(e.getPlayer() == null){
				return;
			}
			if (e.getPlayer() == null | e.getPlayer().isOnline()==false | e.getPlayer().isValid()==false) {
				e.setCancelled(true);
			}
		}
    }
}
