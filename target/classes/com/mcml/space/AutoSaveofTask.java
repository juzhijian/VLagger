package com.mcml.space;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;

public class AutoSaveofTask
        implements Runnable {
    
    public void run() {
        if (VLagger.AutoSaveenable == true) {
            Bukkit.savePlayers();
        }
    }
}
