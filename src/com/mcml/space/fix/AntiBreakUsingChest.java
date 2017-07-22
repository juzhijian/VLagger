package com.mcml.space.fix;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.InventoryHolder;

import com.mcml.space.config.ConfigAntiBug;
import com.mcml.space.core.VLagger;

/**
 * @author jiongjionger
 */
public class AntiBreakUsingChest implements Listener {

    @EventHandler
    public void CheckNoBreakChest(BlockBreakEvent e) {
        if (VLagger.AntiBreakUseingChestenable == true) {
            Player p = e.getPlayer();
            if (e.getBlock().getState() instanceof InventoryHolder) {
                InventoryHolder ih = (InventoryHolder) e.getBlock().getState();
                if (ih.getInventory().getViewers().isEmpty() == false) {
                    e.setCancelled(true);
                    if(ConfigAntiBug.AntiBreakUsingChestWarnMessage.equalsIgnoreCase("none") == false){
                        p.sendMessage(VLagger.PluginPrefix + ConfigAntiBug.AntiBreakUsingChestWarnMessage);
                    }
                }
            }
        }
    }
}
