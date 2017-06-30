package com.mcml.space;

import org.bukkit.Bukkit;

public class HeapShut
        implements Runnable {

    public void run() {
        if (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() > Runtime.getRuntime().maxMemory() / 100 * VLagger.HeapShutPercent) {
            if (VLagger.HeapShutenable == true) {
                Bukkit.broadcastMessage(VLagger.PluginPrefix + VLagger.HeapShutWarnMessage);
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
