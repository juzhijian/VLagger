package com.mcml.space.optimize;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import com.google.common.collect.Sets;
import com.mcml.space.core.VLagger;
import com.mcml.space.util.AzureAPI;
import com.mcml.space.util.AzureAPI.Coord2D;

public class TeleportPreloader implements Listener {
    protected static TeleportPreloader instance;
    protected final static Logger logger = AzureAPI
            .createLogger(AzureAPI.setPrefix(ChatColor.DARK_AQUA + "TeleportPreloader" + ChatColor.RESET + " > "));
    protected volatile static boolean pending;

    @EventHandler(priority = EventPriority.LOWEST)
    public void onTeleport(PlayerTeleportEvent evt) {
        if (evt.isCancelled() || evt.isAsynchronous() || pending||VLagger.TeleportPreLoaderenable != true)
            return;

        Location from = evt.getFrom();
        final Location to = evt.getTo();
        final Player player = evt.getPlayer();
        if (from.equals(to)) {
            evt.setCancelled(true);
            return;
        }
        if (!canPreload(from, to, player))
            return;
        evt.setCancelled(true);

        final World world = player.getWorld();
        Set<Coord2D> chunks = collectPreloadChunks(to, player);
        final int preChunks = chunks.size() / 3;
        final Iterator<Coord2D> it = chunks.iterator();

        Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable(){
            @Override
            public void run(){
                Coord2D coord;
                for (int i = 0; it.hasNext() && i <= preChunks; i++) {
                    coord = it.next();
                    world.getChunkAt(coord.getX(), coord.getZ());
                    it.remove();
                }
            }
        }, 1L);
        Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable(){
            @Override
            public void run(){
                Coord2D coord;
                for (int i = 0; it.hasNext() && i <= preChunks; i++) {
                    coord = it.next();
                    world.getChunkAt(coord.getX(), coord.getZ());
                    it.remove();
                }
            }
        }, 3L);
        Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable() {
            @Override
            public void run(){
                Coord2D coord;
                while (it.hasNext()) {
                    coord = it.next();
                    world.getChunkAt(coord.getX(), coord.getZ());
                }
            }
        }, 5L);
        Bukkit.getScheduler().runTaskLater(VLagger.MainThis, new Runnable() {
            @Override
            public void run(){
                pending = true;
                player.teleport(to);
                pending = false;
            }
        }, 7L);
    }

    public static boolean canPreload(Location from, Location to, Player player) {
        if (from.getWorld() != to.getWorld())
            return true;
        if (equals2D(from, to) || from.distance(to) < AzureAPI.viewDistanceBlock(player)) {
            return false;
        }

        return true;
    }

    public static boolean equals2D(Location from, Location to) {
        return from.getBlockX() == to.getBlockX() && from.getBlockZ() == to.getBlockZ();
    }

    public static Set<Coord2D> collectPreloadChunks(Location loc, Player player) {
        int view = AzureAPI.viewDistanceBlock(player);
        int bX, bZ;
        bX = loc.getBlockX();
        bZ = loc.getBlockZ();
        int minX, minZ, maxX, maxZ;
        minX = bX - view;
        minZ = bZ - view;
        maxX = bX + view;
        maxZ = bZ + view;

        Set<Coord2D> chunks = Sets.newHashSetWithExpectedSize((view << 1) ^ 2 + 1); // (view
        // *
        // 2)
        // ^
        // 2
        // +
        // 1
        int cx, cz;
        for (cx = minX; cx <= maxX; cx += 16) {
            for (cz = minZ; cz <= maxZ; cz += 16) {
                chunks.add(AzureAPI.wrapCoord2D(cx, cz));
            }
        }

        return chunks;
    }

}
/**
@author SotrForgotten
此部分代码为 SotrForgotten 重制，并已授权使用！
QWQ，感谢支持！
 */