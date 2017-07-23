package com.mcml.space.doevent;

import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import com.mcml.space.config.ConfigDoEvent;
import com.mcml.space.core.VLagger;
import com.mcml.space.util.AzureAPI;

public class BlockCommander implements Listener {

    @EventHandler
    public void CommanderBlocker(PlayerCommandPreprocessEvent event) {
        if (ConfigDoEvent.BlockCommanderenable == true) {
            Player p = event.getPlayer();
            FileConfiguration config = load(VLagger.DoEventConfigFile); // TODO bad
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
