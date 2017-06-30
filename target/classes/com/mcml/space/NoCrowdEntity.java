package com.mcml.space;

import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class NoCrowdEntity
        implements Listener {

    @EventHandler
    public void CheckCrowd(ChunkLoadEvent event) {
        if (VLagger.NoCrowdedEntityenable == true) {
            Chunk chunk = event.getChunk();
            Entity[] entities = chunk.getEntities();
            for (int i = 0; i < entities.length; i++) {
                Entity ent = entities[i];
                int entcount = 0;
                if (VLagger.NoCrowdedEntityTypeList.contains(ent.getType())) {
                    entcount++;
                    if (entcount > VLagger.NoCrowdedEntityPerChunkLimit & ent.getType() != EntityType.PLAYER) {
                        ent.remove();
                    }
                }
            }
        }
    }
}
