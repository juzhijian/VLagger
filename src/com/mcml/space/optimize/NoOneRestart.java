package com.mcml.space.optimize;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.mcml.space.core.VLagger;
import com.mcml.space.util.ConfigClearLag;
import com.mcml.space.util.Utils;

public class NoOneRestart
implements Listener {

    private int TaskId;

    @EventHandler
    public void CheckQuit(PlayerQuitEvent event){
        if(Utils.getonlinePlayers().isEmpty() && ConfigClearLag.NooneRestartenable == true){
            TaskId = Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable(){
                @Override
                public void run(){
                    Bukkit.shutdown();
                }
            }, VLagger.NooneRestartTimeLong * 20).getTaskId();
        }
    }

    @EventHandler
    public void CheckJoin(PlayerJoinEvent event){
        if(ConfigClearLag.NooneRestartenable == true){
            Bukkit.getScheduler().cancelTask(TaskId);
        }
    }
}