package com.mcml.space.doevent;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.mcml.space.core.VLagger;

public class AntiSpam
        implements Listener {

    private final static HashMap<String, Long> CheckList = new HashMap<String, Long>();

    private static boolean CheckFast(String bs) {
        if (CheckList.containsKey(bs)) {
            return (((Long) CheckList.get(bs)).longValue() + VLagger.AntiSpamPeriodPeriod * 1000 > System.currentTimeMillis());
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
                p.sendMessage(VLagger.PluginPrefix + VLagger.AntiSpamPeriodWarnMessage);
            }else{
            	CheckList.put(pn, System.currentTimeMillis());
            }
        }
    }
    
    @EventHandler
    public void AntiDirty(AsyncPlayerChatEvent event) {
        if (VLagger.AntiSpamenable == true) {
            Player p = event.getPlayer();
            if (p.hasPermission("VLagger.bypass.Spam")) {
                return;
            }
            List<String> strings = VLagger.AntiSpamDirtyList;
            int ss = strings.size();
            for(int i = 0;i < ss;i++){
            	String string = strings.get(i);
            	if(event.getMessage().contains(string)){
            		event.setCancelled(true);
            		p.sendMessage(VLagger.PluginPrefix + VLagger.AntiSpamDirtyWarnMessage);
            	}
            }
        }
    }
}
