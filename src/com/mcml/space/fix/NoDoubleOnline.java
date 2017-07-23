package com.mcml.space.fix;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPreLoginEvent;

import com.mcml.space.config.ConfigAntiBug;
import com.mcml.space.core.VLagger;
import com.mcml.space.util.Utils;

@SuppressWarnings("deprecation")
public class NoDoubleOnline implements Listener {

    @EventHandler
    public void CheckDoubleOnline(PlayerPreLoginEvent event) {
        if (ConfigAntiBug.NoDoubleOnlineenable == true) {
            List<Player> onlinePlayers = Utils.getonlinePlayers();
            String pn = event.getName();
            for (int i = 0; i < onlinePlayers.size(); i++) {
                String Ingamepn = onlinePlayers.get(i).getName();
                if (Ingamepn.equalsIgnoreCase(pn) & Ingamepn.equals(pn) == false) {
                    event.setResult(PlayerPreLoginEvent.Result.KICK_BANNED);
                    event.setKickMessage(VLagger.PluginPrefix + ConfigAntiBug.NoDoubleOnlineKickMessage);
                }
            }
        }
    }
}
