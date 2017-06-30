package com.mcml.space;

import org.bukkit.Bukkit;

public class AutoSaveofTask
        implements Runnable {
    
    public void run() {
        if (VLagger.AutoSaveenable == true) {
            Bukkit.savePlayers();
        }
    }
}
