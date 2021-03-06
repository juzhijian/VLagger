package com.mcml.space.fix;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

import com.mcml.space.config.ConfigFixing;

public class AntiInfRail implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void PhysicsCheck(BlockPhysicsEvent event) {
        if (ConfigFixing.fixInfRail == true) {
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
            }
        }
    }
}
// TODO confirm details