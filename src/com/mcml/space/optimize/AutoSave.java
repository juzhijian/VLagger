package com.mcml.space.optimize;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.mcml.space.config.ConfigOptimize;
import com.mcml.space.core.VLagger;

public class AutoSave implements Listener {
    // TODO benchmark!
    private HashMap<Player, Integer> TaskId = new HashMap<Player, Integer>();
    private static HashMap<Player, Chunk> PlayerInChunkMap = new HashMap<Player, Chunk>();
    private static HashMap<Player, Chunk> PlayerClickedMap = new HashMap<Player, Chunk>();

    public AutoSave() {
        String ver = Bukkit.getVersion();
        VLagger.MainThis.getLogger().info("您的服务器版本为:" + ver);
        boolean isCannotSave = false;
        File BukkitFile = new File("bukkit.yml");
        YamlConfiguration bukkit = YamlConfiguration.loadConfiguration(BukkitFile);
        if (ver.contains("1.7.10")) {
            isCannotSave = false;//测试：在1.7.10开启自动保存
        }
        if (isCannotSave != true) {
            if (BukkitFile.exists()) {
                bukkit.set("ticks-per.autosave", 0);
            }
        } else {
            VLagger.MainThis.getLogger().info("警告！您的服务器版本为一个不支持自动储存的版本，为您恢复为默认存储方式！");
            bukkit.set("ticks-per.autosave", 6000);
        }
        try {
            bukkit.save(BukkitFile);
        } catch (IOException e) {
        }
    }

    @EventHandler
    public void JoinTaskGiver(PlayerJoinEvent e) {
        if (ConfigOptimize.AutoSaveenable == false) {
            return;
        }
        final Player p = e.getPlayer();
        TaskId.put(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(VLagger.MainThis, new Runnable() {

            @Override
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
                    World world = LastChunk.getWorld();
                    if (LastChunk.isLoaded() == true) {
                    	world.unloadChunk(LastChunk.getX(), LastChunk.getZ(), true);
                        LastChunk.load();
                    } else {
                        LastChunk.load();
                        world.unloadChunk(LastChunk.getX(), LastChunk.getZ(), true);
                    }
                }
                PlayerInChunkMap.put(p, chunk);
                p.saveData();
            }
        }, ConfigOptimize.AutoSaveInterval * 20, ConfigOptimize.AutoSaveInterval * 20));
    }

    @EventHandler
    public void ClickBypassList(PlayerInteractEvent e) {
        if (e.getClickedBlock() == null) {
            return;
        }
        if (ConfigOptimize.AutoSaveenable == false) {
            return;
        }
        Player p = e.getPlayer();
        PlayerClickedMap.put(p, e.getClickedBlock().getChunk());
    }

    @EventHandler
    public void QuitCancelled(PlayerQuitEvent e) {
        if (ConfigOptimize.AutoSaveenable == false) {
            return;
        }
        Player p = e.getPlayer();
        if (TaskId.get(p) != null) {
            Bukkit.getScheduler().cancelTask(TaskId.get(p));
            TaskId.remove(p);
        }
    }
}
