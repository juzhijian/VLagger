package com.mcml.space.fix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import com.mcml.space.config.ConfigFixing;

public class AntiRPGITEM implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void pickup(PlayerPickupItemEvent event) {
        if (ConfigFixing.fixRpgItemInfItem) {
            if (event.getRemaining() <= 0) {
                event.getItem().remove();
            }
        }
    }
}