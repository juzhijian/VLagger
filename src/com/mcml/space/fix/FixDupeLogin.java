package com.mcml.space.fix;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import com.mcml.space.config.ConfigFixing;
import com.mcml.space.util.AzurePlayerList;

/**
 * @author Vlvxingze
 */
public class FixDupeLogin implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void CheckDoubleOnline(AsyncPlayerPreLoginEvent event) {
        if (ConfigFixing.fixDupeOnline) {
        	List<Player> onlinePlayers = AzurePlayerList.players();
        	int os = onlinePlayers.size();
        	for(int i = 0;i<os;i++){
        		Player player = onlinePlayers.get(i);
        		if(player.getName().equalsIgnoreCase(event.getName())){
        			event.setLoginResult(AsyncPlayerPreLoginEvent.Result.KICK_OTHER);
        			event.setKickMessage(ConfigFixing.messageKickDupeOnline);
        		}
        	}
        }
    }
    
}