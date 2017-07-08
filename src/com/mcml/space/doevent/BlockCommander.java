package com.mcml.space.doevent;

import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import com.mcml.space.core.VLagger;

public class BlockCommander implements Listener {

    @EventHandler
    public void CommanderBlocker(PlayerCommandPreprocessEvent event) {
        if (VLagger.BlockCommanderenable == true) {
            Player p = event.getPlayer();
            FileConfiguration config = load(VLagger.EventConfigFile);
            if (p.hasPermission("VLagger.admin") == true) {
                return;
            }
            if (event.getMessage().contains(":")) {
                event.setCancelled(true);
                p.sendMessage("抱歉，您不能使用冒号代插件来输入命令");
            }
            if (config.getBoolean("BlockCommander.List." + p.getWorld().getName() + "." + event.getMessage()) == true) {
                event.setCancelled(true);
                p.sendMessage(VLagger.PluginPrefix + config.getString("BlockCommander.List." + p.getWorld().getName() + "." + event.getMessage() + ".Message"));
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
