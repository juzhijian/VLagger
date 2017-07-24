package com.mcml.space.optimize;

import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import com.mcml.space.config.ConfigOptimize;

public class NoCrowdEntity implements Listener {
    // TODO bad design
    @EventHandler
    public void CheckCrowd(ChunkLoadEvent event) {
        if (ConfigOptimize.NoCrowdedEntityenable == true) {
            Chunk chunk = event.getChunk();
            Entity[] entities = chunk.getEntities();
            for (int i = 0; i < entities.length; i++) {
                Entity ent = entities[i];
                int entcount = 0;
                if (ConfigOptimize.NoCrowdedEntityTypeList.contains(ent.getType())) {
                    entcount++;
                    if (entcount > ConfigOptimize.NoCrowdedEntityPerChunkLimit & ent.getType() != EntityType.PLAYER) {
                        ent.remove();
                    }
                }
            }
        }
    }
}
