package com.mcml.space.optimize;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.mcml.space.core.VLagger;

public class QueueLinePlayerLogin implements Listener{
	
	private static long LastLoginChecked = System.currentTimeMillis();
	
	@EventHandler
	public void JoinQueue(AsyncPlayerChatEvent event) throws InterruptedException{
		if(VLagger.QueueLinePlayerLoginenable == true){
			if(CheckFast() == true){
				Thread.sleep(1500L);
			}else{
				LastLoginChecked = System.currentTimeMillis();
			}
		}
	}
	
	private static boolean CheckFast() {
		return (LastLoginChecked + VLagger.QueueLinePlayerLoginPeriod > System.currentTimeMillis());
	}
}
