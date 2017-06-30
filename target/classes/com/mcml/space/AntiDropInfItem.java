package com.mcml.space;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
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
