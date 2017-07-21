package com.mcml.space.util;

import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.google.common.collect.Lists;

/**
 * @author Vlvxingze
 */
public class Utils implements Listener {
    private final static List<Player> onlinePlayers = Lists.newArrayListWithExpectedSize(Bukkit.getMaxPlayers());

    public Utils() {
        for (World world : Bukkit.getWorlds()) {
            onlinePlayers.addAll(world.getPlayers());
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void JoinAdder(PlayerJoinEvent event){
        onlinePlayers.add(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void QuitRemover(PlayerQuitEvent event){
        onlinePlayers.remove(event.getPlayer());
    }

    public static List<Player> getonlinePlayers() {
        return onlinePlayers;
    }
}
