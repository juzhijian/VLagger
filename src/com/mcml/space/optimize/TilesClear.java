package com.mcml.space.optimize;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.BlockState;

import com.mcml.space.core.VLagger;

public class TilesClear
        implements Runnable {

    public void run() {
        if (VLagger.TilesClearenable == true) {
            List<World> worlds = Bukkit.getWorlds();
            int ws = worlds.size();
            for (int i = 0; i < ws; i++) {
                World world = worlds.get(i);
                Chunk[] loadedChunks = world.getLoadedChunks();
                int lcl = loadedChunks.length;
                for (int ii = 0; ii < lcl; ii++) {
                    Chunk chunk = loadedChunks[ii];
                    BlockState[] tiles = chunk.getTileEntities();
                    int tl = tiles.length;
                    for (int iii = 0; iii < tl; iii++) {
                        BlockState tile = tiles[iii];
                        try {
                            if (tile.isPlaced() == false) {
                                tile.update();
                            }
                        } catch (Throwable ex) {
                        }
                    }
                }
            }
            Bukkit.broadcastMessage(VLagger.PluginPrefix + VLagger.TilesClearMessage);
        }
    }
}
