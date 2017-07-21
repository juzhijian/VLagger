package com.mcml.space.optimize;

import org.bukkit.Bukkit;

import com.mcml.space.core.VLagger;

public class HeapShut
implements Runnable {

    @Override
    public void run() {
        if (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() > Runtime.getRuntime().maxMemory() / 100 * VLagger.HeapShutPercent) {
            if (VLagger.HeapShutenable == true) {
                if(VLagger.HeapShutWarnMessage.equalsIgnoreCase("none") == false){
                    Bukkit.broadcastMessage(VLagger.PluginPrefix + VLagger.HeapShutWarnMessage);
                }
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(VLagger.MainThis, new Runnable() {

                    @Override
                    public void run() {
                        Bukkit.shutdown();
                    }
                }, VLagger.HeapShutWaitingTime * 20);
            }
        }
    }
}
