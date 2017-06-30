package com.mcml.space;

import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPreLoginEvent;

public class NoDoubleOnline
        implements Listener {

    @EventHandler
    public void CheckDoubleOnline(PlayerPreLoginEvent event) {
        if (VLagger.NoDoubleOnlineenanle == true) {
            ArrayList<Player> onlinePlayers = Utils.getonlinePlayers();
            String pn = event.getName();
            for (int i = 0; i < onlinePlayers.size(); i++) {
                String Ingamepn = onlinePlayers.get(i).getName();
                if (Ingamepn.equalsIgnoreCase(pn) & Ingamepn.equals(pn) == false) {
                    event.setResult(PlayerPreLoginEvent.Result.KICK_BANNED);
                    event.setKickMessage(VLagger.PluginPrefix + VLagger.NoDoubleOnlineKickMessage);
                }
            }
        }
    }
}
