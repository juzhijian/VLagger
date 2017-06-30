package com.mcml.space.fix;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;

import com.mcml.space.core.VLagger;

public class AntiPortalInfItem
        implements Listener {

    @EventHandler
    public void onEntityPortal(EntityPortalEvent event) {
        if (VLagger.AntiPortalInfItemenable == true) {
            if (event.getEntityType() == EntityType.MINECART_CHEST || event.getEntityType() == EntityType.MINECART_FURNACE || event.getEntityType() == EntityType.MINECART_HOPPER) {
                event.setCancelled(true);
                event.getEntity().remove();
                Bukkit.broadcastMessage("§a§l[VLagger]§c抱歉！禁止矿车通过地狱门防止作弊！");
            }
        }
    }
}