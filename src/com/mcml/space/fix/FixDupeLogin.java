package com.mcml.space.fix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import com.mcml.space.config.ConfigFixing;
import com.mcml.space.util.AzurePlayerList;

/**
 * @author Vlvxingze, SotrForgotten
 */
public class FixDupeLogin implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onLogin(AsyncPlayerPreLoginEvent evt) {
        if (ConfigFixing.fixDupeOnline) {
            if (AzurePlayerList.contains(evt.getName())) {
                evt.setLoginResult(AsyncPlayerPreLoginEvent.Result.KICK_OTHER);
                evt.setKickMessage(ConfigFixing.messageKickDupeOnline);
            }
        }
    }
    
}
