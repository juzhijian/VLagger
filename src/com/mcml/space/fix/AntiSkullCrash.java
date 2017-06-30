package com.mcml.space.fix;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

import com.mcml.space.core.VLagger;

public class AntiSkullCrash
        implements Listener {

    @EventHandler
    public void NoSkullCrash(BlockFromToEvent e) {
        if (VLagger.AntiSkullCrashenable == true) {
            if (e.getToBlock().getType() == Material.SKULL) {
                e.setCancelled(true);
                e.getToBlock().setType(Material.AIR);
            }
        }
    }
}
