package com.mcml.space.fix;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import com.mcml.space.config.ConfigAntiBug;
import com.mcml.space.config.ConfigPluginMain;

public class AntiCrashSign implements Listener {

    @EventHandler
    public void SignCheckChange(SignChangeEvent event) {
        if (ConfigAntiBug.fixCrashSign) {
            Player player = event.getPlayer();
            String[] lines =event.getLines();
            int ll = lines.length;
            for(int i = 0;i<ll;i++){
                String line = lines[i];
                if(line.length() >= 127){
                    event.setCancelled(true);
                    if(ConfigAntiBug.AntiCrashSignWarnMessage.equalsIgnoreCase("none") == false){
                        player.sendMessage(ConfigPluginMain.PluginPrefix + ConfigAntiBug.AntiCrashSignWarnMessage);
                    }
                }
            }
        }
    }
}