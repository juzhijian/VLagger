package com.mcml.space;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiSpam
        implements Listener {

    private final static HashMap CheckList = new HashMap();

    private static boolean CheckFast(String bs) {
        if (CheckList.containsKey(bs)) {
            return (((Long) CheckList.get(bs)).longValue() + VLagger.AntiSpamPeriod * 1000 > System.currentTimeMillis());
        }
        return false;
    }

    @EventHandler
    public void SpamChecker(AsyncPlayerChatEvent event) {
        if (VLagger.AntiSpamenable == true) {
            Player p = event.getPlayer();
            if (p.hasPermission("VLagger.bypass.Spam")) {
                return;
            }
            String pn = p.getName();
            if (CheckFast(pn)) {
                event.setCancelled(true);
                p.sendMessage(VLagger.PluginPrefix + VLagger.AntiSpamWarnMessage);
            }
            CheckList.put(pn, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
