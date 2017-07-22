package com.mcml.space.fix;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import com.mcml.space.config.ConfigAntiBug;
import com.mcml.space.core.VLagger;

public class AntiBoneBug implements Listener {

    @EventHandler
    public void TreeGrowChecker(StructureGrowEvent event) {
        if (ConfigAntiBug.AntiBoneBugenable == true) {
            Location loc = event.getLocation();
            Block block = loc.getBlock();
            if (block.getRelative(BlockFace.UP).getType() != Material.AIR) {
                event.setCancelled(true);
                if (event.getPlayer() != null) {
                	if(ConfigAntiBug.AntiBoneBugWarnMessage.equalsIgnoreCase("none") == false){
                		event.getPlayer().sendMessage(ConfigAntiBug.AntiBoneBugWarnMessage);
                	}
                }
            }
        }
    }

    @EventHandler
    public void BoneGrowBlocker(StructureGrowEvent event) {
        if(ConfigAntiBug.AntiBoneBugenable == true){
            if (event.isFromBonemeal()) {
                event.setCancelled(true);
                if (event.getPlayer() != null) {
                    if(ConfigAntiBug.AntiBoneBugWarnMessage.equalsIgnoreCase("none") == false){
                        event.getPlayer().sendMessage(ConfigAntiBug.AntiBoneBugWarnMessage);
                    }
                }
            }
        }
    }
}
