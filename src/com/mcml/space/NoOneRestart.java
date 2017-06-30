package com.mcml.space;

import org.bukkit.Bukkit;

public class NoOneRestart
        implements Runnable {

    public void run() {
        if (Utils.getonlinePlayers().isEmpty() & VLagger.NooneRestartenable == true) {
            Bukkit.shutdown();
        }
    }
}
