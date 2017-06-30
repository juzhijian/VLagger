package com.mcml.space;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class AntiRedstone
        implements Listener {

    private final static HashMap CheckList = new HashMap();
    private static boolean TipCooldown;

    public AntiRedstone() {
        Bukkit.getScheduler().runTaskTimer(VLagger.MainThis, new Runnable() {

            @Override
            public void run() {
                TipCooldown = false;
            }
        }, 7 * 20, 7 * 20);
    }

    private static boolean CheckFast(String bs) {
        if (CheckList.containsKey(bs)) {
            return (((Long) CheckList.get(bs)).longValue() + VLagger.AntiRedstoneInterval > System.currentTimeMillis());
        }
        return false;
    }

    @EventHandler
    public void LimitRedstonePeriod(BlockRedstoneEvent event) {
        if (VLagger.AntiRedstoneenable == true) {
            Block block = event.getBlock();
            String bs = block.toString();
            if (CheckFast(bs)) {
                if (block.getType() == Material.REDSTONE_WIRE|block.getType() == Material.DIODE_BLOCK_ON|block.getType() == Material.DIODE_BLOCK_OFF) {
                    block.setType(Material.AIR);
                    if (TipCooldown == false) {
                        VLagger.AntiRedstoneMessage = VLagger.AntiRedstoneMessage.replaceAll("%location%", bs);
                        Bukkit.broadcastMessage(VLagger.PluginPrefix + VLagger.AntiRedstoneMessage);
                        TipCooldown = true;
                    }
                }
            }
            CheckList.put(bs, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
