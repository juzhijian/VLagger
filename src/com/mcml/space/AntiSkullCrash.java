package com.mcml.space;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

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
