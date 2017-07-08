package com.mcml.space.optimize;

import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

import com.mcml.space.core.VLagger;

public class NoExplodeofBlock
        implements Listener {
    
    public static void RegisterEvents(){
        try {
            Class<?> myclass = Class.forName("org.bukkit.event.block.BlockExplodeEvent");
            if(myclass == null){
            	return;
            }
            VLagger.MainThis.getServer().getPluginManager().registerEvents(new NoExplodeofBlock(), VLagger.MainThis);
        } catch (ClassNotFoundException ex) {
        }
    }
    
    @EventHandler
    public void AntiBlockExplode(BlockExplodeEvent event) {
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
