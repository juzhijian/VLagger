package com.mcml.space;

import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;

public class AntiNetherHopperInfItem
        implements Listener {

    @EventHandler
    public void onHopper(InventoryMoveItemEvent event) {
        if (VLagger.AntiNetherHopperInfItemenable == true) {
            if ((event.getInitiator().getHolder() instanceof Hopper)) {
                Hopper hopper = (Hopper) event.getInitiator().getHolder();
                if (hopper.getWorld().getEnvironment() == World.Environment.NETHER) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
