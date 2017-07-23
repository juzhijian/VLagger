package com.mcml.space.optimize;

import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import com.mcml.space.config.ConfigClearLag;

public class NoCrowdEntity implements Listener {

    @EventHandler
    public void CheckCrowd(ChunkLoadEvent event) {
        if (ConfigClearLag.NoCrowdedEntityenable == true) {
            Chunk chunk = event.getChunk();
            Entity[] entities = chunk.getEntities();
            for (int i = 0; i < entities.length; i++) {
                Entity ent = entities[i];
                int entcount = 0;
                if (ConfigClearLag.NoCrowdedEntityTypeList.contains(ent.getType())) {
                    entcount++;
                    if (entcount > ConfigClearLag.NoCrowdedEntityPerChunkLimit & ent.getType() != EntityType.PLAYER) {
                        ent.remove();
                    }
                }
            }
        }
    }
}
