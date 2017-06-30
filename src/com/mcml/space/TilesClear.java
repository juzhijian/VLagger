package com.mcml.space;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.BlockState;

public class TilesClear
        implements Runnable {

    public void run() {
        if (VLagger.TilesClearenable == true) {
            List<World> worlds = Bukkit.getWorlds();
            for (int i = 0; i < worlds.size(); i++) {
                World world = worlds.get(i);
                Chunk[] loadedChunks = world.getLoadedChunks();
                for (int ii = 0; ii < loadedChunks.length; ii++) {
                    Chunk chunk = loadedChunks[ii];
                    BlockState[] tiles = chunk.getTileEntities();
                    for (int iii = 0; iii < tiles.length; iii++) {
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
