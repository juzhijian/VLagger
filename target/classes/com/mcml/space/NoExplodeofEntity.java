package com.mcml.space;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoExplodeofEntity
        implements Listener {
    
    @EventHandler
    public void AntiEntityExplode(EntityExplodeEvent event) {
        if (VLagger.NoExplodeenable == true) {
            if (event.isCancelled() == false) {
                if (VLagger.NoExplodeType.equals("NoBlockBreak")) {
                    List<Block> blockList = event.blockList();
                    blockList.clear();
                }
                if (VLagger.NoExplodeType.equals("NoExplode")) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
