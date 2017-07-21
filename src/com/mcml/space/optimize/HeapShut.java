package com.mcml.space.optimize;

import org.bukkit.Bukkit;

import com.mcml.space.core.VLagger;
import com.mcml.space.util.ConfigClearLag;

public class HeapShut implements Runnable {

    @Override
    public void run() {
        if (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() > Runtime.getRuntime().maxMemory() / 100 * ConfigClearLag.HeapShutPercent) {
            if (ConfigClearLag.HeapShutenable == true) {
                if(ConfigClearLag.HeapShutWarnMessage.equalsIgnoreCase("none") == false){
                    Bukkit.broadcastMessage(VLagger.PluginPrefix + ConfigClearLag.HeapShutWarnMessage);
                }
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(VLagger.MainThis, new Runnable() {

                    @Override
                    public void run() {
                        Bukkit.shutdown();
                    }
                }, ConfigClearLag.HeapShutWaitingTime * 20);
            }
        }
    }
}
