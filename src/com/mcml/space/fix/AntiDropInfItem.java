package com.mcml.space.fix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import com.mcml.space.core.VLagger;

/**
 * @author jiongjionger
 */
public class AntiDropInfItem implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void CheckDropNoBugInfItem(PlayerDropItemEvent e) {
        if(VLagger.AntiDropInfItemenable == true){
            if (e.getPlayer() == null || e.getPlayer().isOnline()==false) {
                e.setCancelled(true);
            }
        }
    }
}
