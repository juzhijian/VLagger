package com.mcml.space.optimize;

import java.io.File;
import java.io.IOException;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

import com.mcml.space.core.VLagger;

public class WorldSpawnLimiter implements Listener {

    @EventHandler
    public void WorldSeterLimitor(WorldInitEvent event) {
        World world = event.getWorld();
        FileConfiguration config = load(VLagger.optimizeConfiguration);
        if (config.getBoolean("WorldSpawnLimitor." + world.getName() + ".enable")) {
            world.setMonsterSpawnLimit(config.getInt("WorldSpawnLimitor." + world.getName() + ".PerChunkMonsters"));
            world.setAnimalSpawnLimit(config.getInt("WorldSpawnLimitor." + world.getName() + ".PerChunkAnimals"));
            world.setAmbientSpawnLimit(config.getInt("WorldSpawnLimitor." + world.getName() + ".PerChunkAmbient"));
            VLagger.MainThis.getLogger().info("已为世界 " + world.getName() + " 设定了生物刷新速率~");
        }
    }

    private static FileConfiguration load(File file) {
        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }
        return YamlConfiguration.loadConfiguration(file);
    }
}
