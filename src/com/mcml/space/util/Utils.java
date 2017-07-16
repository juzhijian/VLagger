/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcml.space.util;

import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author Administrator
 */
public class Utils implements Listener{
	private static ArrayList<Player> onlinePlayers = new ArrayList<Player>();
	
	public Utils(){
		ArrayList<Player> onlinePlayers = new ArrayList<Player>();
        List<World> worlds = Bukkit.getWorlds();
        for (int i = 0; i < worlds.size(); i++) {
            World world = worlds.get(i);
            List<Player> players = world.getPlayers();
            onlinePlayers.addAll(players);
        }
	}
	
	@EventHandler
	public void JoinAdder(PlayerJoinEvent event){
		onlinePlayers.add(event.getPlayer());
	}
	
	@EventHandler
	public void QuitRemover(PlayerQuitEvent event){
		onlinePlayers.remove(event.getPlayer());
	}
	
    public static ArrayList<Player> getonlinePlayers() {
        return onlinePlayers;
    }
}
