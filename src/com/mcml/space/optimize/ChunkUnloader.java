package com.mcml.space.optimize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.mcml.space.core.VLagger;

public class ChunkUnloader
        implements Runnable {

    public static int ChunkUnloaderTimes;

    public void run() {
        if (VLagger.ChunkUnloaderenable == true) {
            List<World> worlds = Bukkit.getWorlds();
            for (int i = 0; i < worlds.size(); i++) {
                World world = worlds.get(i);
				Chunk[] loadedChunks = world.getLoadedChunks();
				int lcl = loadedChunks.length;
				for(int ii=0;ii<lcl;ii++){
					Chunk chunk = loadedChunks[ii];
					if(world.isChunkInUse(chunk.getX(),chunk.getZ())==false){
						if(chunk.isLoaded() == true & ChunkKeeper.ShouldKeepList.contains(chunk)==false){
							chunk.unload();
							ChunkUnloaderTimes++;
						}
					}
				}
            }
        }
    }
}
