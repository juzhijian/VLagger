package com.mcml.space.fix;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import com.mcml.space.core.VLagger;
import com.mcml.space.util.ConfigNoBug;

public class AntiBoneBug implements Listener {

    @EventHandler
    public void TreeGrowChecker(StructureGrowEvent event) {
        if (ConfigNoBug.AntiBoneBugenable == true) {
            Location loc = event.getLocation();
            Block block = loc.getBlock();
            if (block.getRelative(BlockFace.UP).getType() != Material.AIR) {
                event.setCancelled(true);
                if (event.getPlayer() != null) {
                	if(ConfigNoBug.AntiBoneBugWarnMessage.equalsIgnoreCase("none") == false){
                		event.getPlayer().sendMessage(ConfigNoBug.AntiBoneBugWarnMessage);
                	}
                }
            }
        }
    }

    @EventHandler
    public void BoneGrowBlocker(StructureGrowEvent event) {
        if(ConfigNoBug.AntiBoneBugenable == true){
            if (event.isFromBonemeal()) {
                event.setCancelled(true);
                if (event.getPlayer() != null) {
                    if(ConfigNoBug.AntiBoneBugWarnMessage.equalsIgnoreCase("none") == false){
                        event.getPlayer().sendMessage(ConfigNoBug.AntiBoneBugWarnMessage);
                    }
                }
            }
        }
    }
}
