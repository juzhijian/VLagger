package com.mcml.space.fix;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import com.mcml.space.core.VLagger;
import com.mcml.space.util.Utils;

public class AntiFakeDeath implements Runnable{

	@Override
	public void run() {
		if(VLagger.AntiFakeDeathenable == true){
			ArrayList<Player> players = Utils.getonlinePlayers();
			int ps = players.size();
			for(int i = 0;i<ps;i++){
				Player player = players.get(i);	
				if(player.getHealth() <= 0){
					player.setHealth(0.0);
					player.kickPlayer(VLagger.AntiFakeDeathKickMessage);
				}
			}
		}
	}
}
