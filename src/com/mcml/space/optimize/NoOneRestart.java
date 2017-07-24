package com.mcml.space.optimize;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.mcml.space.config.ConfigOptimize;
import com.mcml.space.core.VLagger;
import com.mcml.space.util.AzurePlayerList;

public class NoOneRestart
implements Listener {
    // TODO shutdown = restart?
    // TODO main thread sleep is better than this
    private int TaskId;

    @EventHandler
    public void CheckQuit(PlayerQuitEvent event){
        if(AzurePlayerList.isEmpty() && ConfigOptimize.NooneRestartenable){
            TaskId = Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable(){
                @Override
                public void run(){
                    Bukkit.shutdown();
                }
            }, ConfigOptimize.NooneRestartTimeLong * 20).getTaskId();
        }
    }

    @EventHandler
    public void CheckJoin(PlayerJoinEvent event){
        if(ConfigOptimize.NooneRestartenable == true){
            Bukkit.getScheduler().cancelTask(TaskId);
        }
    }
}