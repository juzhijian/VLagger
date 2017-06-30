package com.mcml.space;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class AntiRPGITEM
        implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void pickup(PlayerPickupItemEvent event) {
        if (VLagger.AntiRPGITEMenable == true) {
            int count = event.getRemaining();
            if (count <= 0) {
                event.getItem().remove();
            }
        }
    }
}
