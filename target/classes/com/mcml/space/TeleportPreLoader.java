package com.mcml.space;

import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class TeleportPreLoader implements Listener {

    @EventHandler
    public void TeleportPreLoader(PlayerTeleportEvent e) {
        if (VLagger.TeleportPreLoaderenable == true) {
            e.setCancelled(true);
            final Location toLoc = e.getTo();
            final Player p = e.getPlayer();
            final ArrayList<Chunk> chunks = Utils.getShouldUseChunk(toLoc.getChunk());
            final int three = chunks.size() / 3;
            final int six = chunks.size() / 3 * 2;
            final int nine = chunks.size();
            Bukkit.getScheduler().scheduleSyncDelayedTask(VLagger.MainThis, new Runnable() {

                public void run() {
                    for (int i = 0; i < three; i++) {
                        Chunk chunk = chunks.get(i);
                        if (chunk.isLoaded() == false) {
                            chunk.load();
                        }
                    }
                }
            }, 3);
            Bukkit.getScheduler().scheduleSyncDelayedTask(VLagger.MainThis, new Runnable() {

                public void run() {
                    for (int i = three; i < six; i++) {
                        Chunk chunk = chunks.get(i);
                        if (chunk.isLoaded() == false) {
                            chunk.load();
                        }
                    }
                }
            }, 6);
            Bukkit.getScheduler().scheduleSyncDelayedTask(VLagger.MainThis, new Runnable() {

                public void run() {
                    for (int i = six; i < nine; i++) {
                        Chunk chunk = chunks.get(i);
                        if (chunk.isLoaded() == false) {
                            chunk.load();
                        }
                    }
                }
            }, 9);
            Bukkit.getScheduler().scheduleSyncDelayedTask(VLagger.MainThis, new Runnable() {

                public void run() {
                    p.teleport(toLoc);
                }
            }, 10);
        }
    }
}
