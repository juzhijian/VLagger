package com.mcml.space.optimize;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

import com.mcml.space.config.ConfigOptimize;
import com.mcml.space.core.VLagger;

public class ChunkUnloaderofListener implements Listener {
    // TODO bad design
    @EventHandler
    public void onWorldLoad(WorldInitEvent event) {
        if (ConfigOptimize.ChunkUnloaderenable == true) {
            event.getWorld().setKeepSpawnInMemory(false);
            VLagger.MainThis.getLogger().info("已为世界 " + event.getWorld().getName() + " 设定不保留出生区块.");
        }
    }
}
