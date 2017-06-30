package com.mcml.space.optimize;

import org.bukkit.Bukkit;

import com.mcml.space.core.VLagger;
import com.mcml.space.util.Utils;

public class NoOneRestart
        implements Runnable {

    public void run() {
        if (Utils.getonlinePlayers().isEmpty() & VLagger.NooneRestartenable == true) {
            Bukkit.shutdown();
        }
    }
}
