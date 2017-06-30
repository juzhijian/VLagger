/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcml.space;

import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;

/**
 *
 * @author Administrator
 */
public class Utils {
    public static ArrayList<Player> getonlinePlayers() {
        ArrayList<Player> onlinePlayers = new ArrayList();
        List<World> worlds = Bukkit.getWorlds();
        for (int i = 0; i < worlds.size(); i++) {
            World world = worlds.get(i);
            List<Player> players = world.getPlayers();
            onlinePlayers.addAll(players);
        }
        return onlinePlayers;
    }
	public static ArrayList<Chunk> getShouldUseChunk(final Chunk chunk){
		ArrayList<Chunk> chunks = new ArrayList();
		int svd = Bukkit.getViewDistance()/2;
		World world = chunk.getWorld();
		for(int x = chunk.getX()-svd;x<chunk.getX()+svd;x++){
			for(int z = chunk.getZ()- svd;z<chunk.getZ()+svd;z++){
				Chunk shouldchunk = world.getChunkAt(x,z);
				chunks.add(shouldchunk);
			}
		}
		return chunks;
	}
}
