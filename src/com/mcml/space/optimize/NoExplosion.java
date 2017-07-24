package com.mcml.space.optimize;

import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

import com.mcml.space.config.ConfigOptimize;

public class NoExplosion implements Listener {
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void AntiBlockExplode(BlockExplodeEvent evt) {
        if (ConfigOptimize.NoExplodeenable) {
            if (ConfigOptimize.NoExplodeType.equals("NoBlockBreak")) {
                List<Block> blockList = evt.blockList();
                blockList.clear();
            }
            if (ConfigOptimize.NoExplodeType.equals("NoExplode")) {
                evt.setCancelled(true);
            }
        }
    }
}
