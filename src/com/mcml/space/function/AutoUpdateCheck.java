package com.mcml.space.function;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.mcml.space.config.ConfigMain;

public class AutoUpdateCheck implements Listener{

    @EventHandler
    public void JoinChecker(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.hasPermission("VLagger.admin")){
            if(ConfigMain.AutoUpdate == false){
                player.sendMessage("§a§l[VLagger]§e提示:§b输入/vlg updateon 来开启自动更新，永远保持你的服务器运行高效！"); // TODO better way?
            }
        }
    }
}
