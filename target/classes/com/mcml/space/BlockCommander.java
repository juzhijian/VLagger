package com.mcml.space;

import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class BlockCommander implements Listener {

    @EventHandler
    public void BlockCommander(PlayerCommandPreprocessEvent e) {
        if (VLagger.BlockCommanderenable == true) {
            Player p = e.getPlayer();
            FileConfiguration config = load(VLagger.EventConfigFile);
            if (p.hasPermission("VLagger.admin") == true) {
                return;
            }
            if (e.getMessage().contains(":")) {
                e.setCancelled(true);
                p.sendMessage("抱歉，您不能使用冒号代插件来输入命令");
            }
            if (config.getBoolean("BlockCommander.List." + p.getWorld().getName() + "." + e.getMessage()) == true) {
                e.setCancelled(true);
                p.sendMessage(VLagger.PluginPrefix + config.getString("BlockCommander.List." + p.getWorld().getName() + "." + e.getMessage() + ".Message"));
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
