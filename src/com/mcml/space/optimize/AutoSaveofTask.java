package com.mcml.space.optimize;

import org.bukkit.Bukkit;

import com.mcml.space.core.VLagger;

public class AutoSaveofTask
        implements Runnable {
    
    public void run() {
        if (VLagger.AutoSaveenable == true) {
            Bukkit.savePlayers();
        }
    }
}
