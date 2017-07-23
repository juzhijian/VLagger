package com.mcml.space.fix;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

import com.mcml.space.config.ConfigAntiBug;

/**
 * @author jiongjionger
 */
public class AntiSkullCrash implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void NoSkullCrash(BlockFromToEvent evt) {
        if (ConfigAntiBug.noSkullCrash) {
            if (evt.getToBlock().getType() == Material.SKULL) {
                evt.setCancelled(true);
            }
        }
    }
}
