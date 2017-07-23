package com.mcml.space.optimize;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

import com.mcml.space.config.ConfigClearLag;
import com.mcml.space.core.VLagger;

public class ItemClear implements Listener {

    public static ArrayList<Chunk> DeathChunk = new ArrayList<Chunk>();

    public ItemClear() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(VLagger.MainThis, new Runnable() {

            @Override
            public void run() {
                DeathChunk.clear();
            }
        }, 60 * 20, 60 * 20);
    }

    @EventHandler
    public void ChunkUnloadClear(ChunkUnloadEvent event) {
        Chunk chunk = event.getChunk();
        if (DeathChunk.contains(chunk) == false) {
            Entity[] entities = chunk.getEntities();
            for (int i = 0; i < entities.length; i++) {
                Entity ent = entities[i];
                if (ent.getType() == EntityType.DROPPED_ITEM) {
                    if(ConfigClearLag.ClearItemNoClearItemType.contains(ent.getType().name()) == false){
                        ent.remove();
                    }
                }
            }
        }
    }

    @EventHandler
    public void DeathNoClear(PlayerDeathEvent event) {
        if(ConfigClearLag.ClearItemNoCleatDeath != true){
            return;
        }
        Player player = event.getEntity();
        Chunk chunk = player.getLocation().getChunk();
        DeathChunk.add(chunk);
    }

    @EventHandler
    public void TeleportNoClear(PlayerTeleportEvent event){
        if(ConfigClearLag.ClearItemNoClearTeleport != true){
            return;
        }
        Player player = event.getPlayer();
        Chunk chunk = player.getLocation().getChunk();
        DeathChunk.add(chunk);
    }
}
