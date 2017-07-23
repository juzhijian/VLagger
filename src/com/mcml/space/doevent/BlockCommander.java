package com.mcml.space.doevent;

import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import com.mcml.space.config.ConfigDoEvent;
import com.mcml.space.config.ConfigPluginMain;
import com.mcml.space.core.VLagger;

public class BlockCommander implements Listener {

    @EventHandler
    public void CommanderBlocker(PlayerCommandPreprocessEvent event) {
        if (ConfigDoEvent.BlockCommanderenable == true) {
            Player p = event.getPlayer();
            FileConfiguration config = load(VLagger.DoEventConfigFile);
            if (p.hasPermission("VLagger.admin") == true) {
                return;
            }
            if (config.getBoolean("BlockCommander.List." + p.getWorld().getName() + "." + event.getMessage()) == true) {
                event.setCancelled(true);
                if(config.getString("BlockCommander.List." + p.getWorld().getName() + "." + event.getMessage() + ".Message").equalsIgnoreCase("none") == false){
                    p.sendMessage(ConfigPluginMain.PluginPrefix + config.getString("BlockCommander.List." + p.getWorld().getName() + "." + event.getMessage() + ".Message"));
                }
            }
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
