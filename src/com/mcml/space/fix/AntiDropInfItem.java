package com.mcml.space.fix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import com.mcml.space.core.VLagger;

public class AntiDropInfItem
        implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void CheckDropNoBugInfItem(PlayerDropItemEvent e) {
		if(VLagger.AntiDropInfItemenable == true){
			if (e.getPlayer() == null || e.getPlayer().isOnline()==false) {
				e.setCancelled(true);
			}
		}
    }
}
/**
@author jiongjionger
部分源码来自 https://github.com/jiongjionger/NeverLag
*/