package com.mcml.space.fix;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

import com.mcml.space.core.VLagger;

public class AntiInfRail
implements Listener {

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
            }
        }
    }
}
