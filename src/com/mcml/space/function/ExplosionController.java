package com.mcml.space.function;

import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import static com.mcml.space.config.ConfigFunction.controlExplode;
import static com.mcml.space.config.ConfigFunction.explodeControlType;

/**
 * @author Vlvxingze, SotrForgotten
 */
public class ExplosionController implements Listener {
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onExplode(BlockExplodeEvent evt) {
        handleExplode(evt, evt.blockList());
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onExplode(EntityExplodeEvent evt) {
        handleExplode(evt, evt.blockList());
    }
    
    private static void handleExplode(Cancellable evt, List<Block> blocks) {
        if (!controlExplode) return;
        
        if (explodeControlType.equalsIgnoreCase("NoBlockBreak")) {
            blocks.clear();
        }
        if (explodeControlType.equalsIgnoreCase("NoExplode")) {
            evt.setCancelled(true);
        }
    }
}
