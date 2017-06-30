package com.mcml.space;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

public class ChunkUnloaderofListener
        implements Listener {

    @EventHandler
    public void onWorldLoad(WorldInitEvent event) {
        if (VLagger.ChunkUnloaderenable == true) {
            event.getWorld().setKeepSpawnInMemory(false);
        }
    }
}
