package com.mcml.space.doevent;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.mcml.space.util.ConfigNoBug;

public class FarmProtecter implements Listener{

    @EventHandler
    public void EntityFarmChecker(EntityInteractEvent event){
        if(ConfigNoBug.ProtectFarmenable == true){
            if(event.getEntityType() == EntityType.PLAYER == false){
                Block block = event.getBlock();
                if(block.getType() == Material.SOIL||block.getType() == Material.CROPS){
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void PlayerFarmChecker(PlayerInteractEvent event){
        if(ConfigNoBug.ProtectFarmenable == true){
            if(event.getAction() == Action.PHYSICAL){
                Block block = event.getClickedBlock();
                if(block.getType() == Material.SOIL||block.getType() == Material.CROPS){
                    event.setCancelled(true);
                }
            }
        }
    }
}
