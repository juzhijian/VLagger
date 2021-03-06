package com.mcml.space.function;

import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import com.mcml.space.config.ConfigFunction;
import com.mcml.space.core.VLagger;
import com.mcml.space.util.AzureAPI;

public class BlockCommander implements Listener {

    @EventHandler
    public void CommanderBlocker(PlayerCommandPreprocessEvent event) {
        if (ConfigFunction.BlockCommanderenable == true) {
            Player p = event.getPlayer();
            FileConfiguration config = load(VLagger.functionConfiguation); // TODO bad
            if (p.hasPermission("VLagger.admin") == true) {
                return;
            }
            if (config.getBoolean("BlockCommander.List." + p.getWorld().getName() + "." + event.getMessage())) {
                event.setCancelled(true);
                AzureAPI.log(p, config.getString("BlockCommander.List." + p.getWorld().getName() + "." + event.getMessage() + ".Message"));
            }
        }
    }

    private static FileConfiguration load(File file) { // TODO move to api
        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }
        return YamlConfiguration.loadConfiguration(file);
    }
}
