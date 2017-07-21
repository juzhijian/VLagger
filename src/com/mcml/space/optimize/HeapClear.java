package com.mcml.space.optimize;

import org.bukkit.Bukkit;

import com.mcml.space.core.VLagger;
public class HeapClear implements Runnable {

    @Override
    public void run() {
        if(VLagger.HeapClearenable==true){
            if(VLagger.HeapClearMessage.equalsIgnoreCase("none") == false){
                Bukkit.broadcastMessage(VLagger.PluginPrefix + VLagger.HeapClearMessage);
            }
            System.gc();
            System.runFinalization();
        }
    }
}
