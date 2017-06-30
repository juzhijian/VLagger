/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcml.space.optimize;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.mcml.space.core.VLagger;

/**
 *
 * @author Administrator
 */
public class AutoRespawn implements Listener{
    @EventHandler
    public void AutoRespawner(PlayerDeathEvent event){
        Player player = event.getEntity();
        if(VLagger.AutoRespawnenable == true){
            try{
                player.spigot().respawn();
            }catch(Throwable ex){
                VLagger.MainThis.getLogger().info("提示:您的服务器不是Spigot服务端？无法启用自动复活功能！");
            }
        }
    }
}
