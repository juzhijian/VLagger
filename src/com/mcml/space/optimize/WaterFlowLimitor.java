package com.mcml.space.optimize;

import java.util.HashMap;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

import com.mcml.space.core.VLagger;

public class WaterFlowLimitor
        implements Listener {
	
	private final static HashMap<Chunk, Long> ChunkChecked = new HashMap<Chunk, Long>();

	@EventHandler
    public void WaterFowLimitor(BlockFromToEvent event) {
		if(VLagger.WaterFlowLimitorenable == true){
			Block block = event.getBlock();
	        if (block.getType() == Material.STATIONARY_WATER || block.getType() == Material.STATIONARY_LAVA) {
	            if(CheckFast(block.getChunk())){
	                event.setCancelled(true);
	            }else{
	                ChunkChecked.put(block.getChunk(), System.currentTimeMillis());
	            }
	        }
		}
    }
	
	private static boolean CheckFast(Chunk chunk) {
        if (ChunkChecked.containsKey(chunk)) {
            return (((Long) ChunkChecked.get(chunk)).longValue() + VLagger.WaterFlowLimitorPeriod > System.currentTimeMillis());
        }
        return false;
    }
}
