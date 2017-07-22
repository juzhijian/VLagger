package com.mcml.space.fix;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

import com.mcml.space.core.VLagger;

/**
 * @author jiongjionger
 */
public class AntiSkullCrash implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void NoSkullCrash(BlockFromToEvent evt) {
        if (VLagger.AntiSkullCrashenable) {
            if (evt.getToBlock().getType() == Material.SKULL) {
                evt.setCancelled(true);
            }
        }
    }
}
