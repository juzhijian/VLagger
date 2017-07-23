package com.mcml.space.fix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import com.mcml.space.config.ConfigAntiBug;
import com.mcml.space.core.VLagger;

public class AntiRPGITEM implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void pickup(PlayerPickupItemEvent event) {
        if (ConfigAntiBug.AntiRPGITEMenable == true) {
            if (event.getRemaining() <= 0) {
                event.getItem().remove();
            }
        }
    }
}
