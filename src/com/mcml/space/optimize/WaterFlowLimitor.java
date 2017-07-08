package com.mcml.space.optimize;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class WaterFlowLimitor
        implements Listener {

    @EventHandler
    public void onMove(BlockFromToEvent event) {
    	Block block = event.getBlock();
    	if(block.getType() == Material.STATIONARY_WATER || block.getType() == Material.STATIONARY_LAVA){
    		Bukkit.broadcastMessage("水源流淌了");
    		event.setCancelled(true);
    	}
    }
}
