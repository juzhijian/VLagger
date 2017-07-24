package com.mcml.space.fix;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

import com.mcml.space.config.ConfigFixing;

/**
 * @author jiongjionger
 */
public class AntiSkullCrash implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void NoSkullCrash(BlockFromToEvent evt) {
        if (ConfigFixing.noSkullCrash) {
            if (evt.getToBlock().getType() == Material.SKULL) {
                evt.setCancelled(true);
            }
        }
    }
}
