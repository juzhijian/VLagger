package com.mcml.space;

import org.bukkit.Bukkit;
public class HeapClear
        implements Runnable {

    public void run() {
		if(VLagger.HeapClearenable==true){
			Bukkit.broadcastMessage(VLagger.PluginPrefix + VLagger.HeapClearMessage);
			System.gc();
			System.runFinalization();
		}
    }
}
