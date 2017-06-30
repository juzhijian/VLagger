package com.mcml.space;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class AntiInfRail
        implements Listener {

    private boolean TipCooldown;

    public AntiInfRail() {
        Bukkit.getScheduler().runTaskTimer(VLagger.MainThis, new Runnable() {

            @Override
            public void run() {
                TipCooldown = false;
            }
        }, 7 * 20, 7 * 20);
    }

    @EventHandler
    public void PhysicsCheck(BlockPhysicsEvent event) {
        if (VLagger.AntiInfRailenable == true) {
            int checkedtimes = 0;
            if (event.getChangedType() == Material.RAILS) {
                checkedtimes = checkedtimes + 1;
            }
            if (event.getChangedType() == Material.DETECTOR_RAIL) {
                checkedtimes = checkedtimes + 1;
            }
            if (event.getChangedType() == Material.POWERED_RAIL) {
                checkedtimes = checkedtimes + 1;
            }
            if (event.getChangedType() == Material.ACTIVATOR_RAIL) {
                checkedtimes = checkedtimes + 1;
            }
            if (checkedtimes >= 2) {
                event.setCancelled(true);
                if (TipCooldown == false) {
                    Bukkit.broadcastMessage("§a§l[VLagger]§c请不要尝试刷铁轨Bug.");
                }
            }
        }
    }
}
