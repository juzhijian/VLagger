package com.mcml.space.optimize;

import org.bukkit.Bukkit;

import com.mcml.space.core.VLagger;
import com.mcml.space.util.Configurable;

public class HeapShut implements Runnable {

    @Override
    public void run() {
        if (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() > Runtime.getRuntime().maxMemory() / 100 * Configurable.HeapShutPercent) {
            if (Configurable.HeapShutenable == true) {
                if(Configurable.HeapShutWarnMessage.equalsIgnoreCase("none") == false){
                    Bukkit.broadcastMessage(VLagger.PluginPrefix + Configurable.HeapShutWarnMessage);
                }
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(VLagger.MainThis, new Runnable() {

                    @Override
                    public void run() {
                        Bukkit.shutdown();
                    }
                }, Configurable.HeapShutWaitingTime * 20);
            }
        }
    }
}
