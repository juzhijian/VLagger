package com.mcml.space.optimize;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.mcml.space.core.VLagger;

public class AutoSaveOfListener
        implements Listener {

    private HashMap<Player, Integer> TaskId = new HashMap<Player, Integer>();
    private static HashMap<Player, Chunk> PlayerInChunkMap = new HashMap<Player, Chunk>();
    private static HashMap<Player, Chunk> PlayerClickedMap = new HashMap<Player, Chunk>();
    
    public AutoSaveOfListener(){
    	if(VLagger.AutoSaveenable == true){
    		List<World> worlds = Bukkit.getWorlds();
        	int ws = worlds.size();
        	for(int i = 0;i < ws;i++){
        		worlds.get(i).setAutoSave(false);
        	}
    	}
    }
    
    
    @EventHandler
    public void JoinTaskGiver(PlayerJoinEvent e) {
        if (VLagger.AutoSaveenable == false) {
            return;
        }
        final Player p = e.getPlayer();
        TaskId.put(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(VLagger.MainThis, new Runnable() {

            public void run() {
                Chunk chunk = p.getLocation().getChunk();
                Chunk LastChunk = PlayerInChunkMap.get(p);
                if (LastChunk != chunk) {
                    if (LastChunk == null) {
                        PlayerInChunkMap.put(p, chunk);
                        return;
                    }
                    if (PlayerClickedMap.containsValue(LastChunk)) {
                        return;
                    }
                    if (LastChunk.isLoaded() == true) {
                        LastChunk.unload(true);
                        LastChunk.load();
                    }
                    if (LastChunk.isLoaded() == false) {
                        LastChunk.load();
                        LastChunk.unload(true);
                    }
                }
                PlayerInChunkMap.put(p, chunk);
            }
        }, VLagger.AutoSaveInterval * 20, VLagger.AutoSaveInterval * 20));
    }

    @EventHandler
    public void ClickBypassList(PlayerInteractEvent e) {
        if (e.getClickedBlock() == null) {
            return;
        }
        if (VLagger.AutoSaveenable == false) {
            return;
        }
        Player p = e.getPlayer();
        PlayerClickedMap.put(p, e.getClickedBlock().getChunk());
    }

    @EventHandler
    public void QuitCancelled(PlayerQuitEvent e) {
        if (VLagger.AutoSaveenable == false) {
            return;
        }
        Player p = e.getPlayer();
        if (TaskId.get(p) != null) {
            Bukkit.getScheduler().cancelTask(TaskId.get(p));
            TaskId.remove(p);
        }
    }
}
