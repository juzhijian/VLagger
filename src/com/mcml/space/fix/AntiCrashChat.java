package com.mcml.space.fix;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import com.mcml.space.config.ConfigAntiBug;
import com.mcml.space.config.ConfigPluginMain;

public class AntiCrashChat implements Listener{
    private boolean HasEss;

    public AntiCrashChat(){
        Plugin ess = Bukkit.getPluginManager().getPlugin("Essentials");
        if(ess != null){
            HasEss = true;
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void ChatCheckCrash(AsyncPlayerChatEvent event){
        if (!ConfigAntiBug.noCrashChat) return;
        
        Player player = event.getPlayer();
        String message = event.getMessage();
        if(message.contains("İ")){
            event.setCancelled(true);
            if(ConfigAntiBug.AntiCrashChatSpecialStringWarnMessage.equalsIgnoreCase("none") == false){
                player.sendMessage(ConfigPluginMain.PluginPrefix + ConfigAntiBug.AntiCrashChatSpecialStringWarnMessage);
            }
        }
        if(HasEss == true){
            if(message.contains("&")){
                event.setCancelled(true);
                if(ConfigAntiBug.AntiCrashChatSpecialStringWarnMessage.equalsIgnoreCase("none") == false){
                    player.sendMessage(ConfigPluginMain.PluginPrefix + ConfigAntiBug.AntiCrashChatSpecialStringWarnMessage);
                }
            }
        }
    }
}
