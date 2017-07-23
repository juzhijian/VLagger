package com.mcml.space.doevent;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.mcml.space.config.ConfigDoEvent;
import com.mcml.space.config.ConfigPluginMain;

public class AntiSpam implements Listener {

    private final static HashMap<String, Long> CheckList = new HashMap<String, Long>();

    private static boolean CheckFast(String bs) {
        if (CheckList.containsKey(bs)) {
            return (CheckList.get(bs).longValue() + ConfigDoEvent.AntiSpamPeriodPeriod * 1000 > System.currentTimeMillis());
        }
        return false;
    }

    @EventHandler
    public void SpamChecker(AsyncPlayerChatEvent event) {
        if (ConfigDoEvent.AntiSpamenable == true) {
            Player p = event.getPlayer();
            if (p.hasPermission("VLagger.bypass.Spam")) {
                return;
            }
            String pn = p.getName();
            if (CheckFast(pn)) {
                event.setCancelled(true);
                if(ConfigDoEvent.AntiSpamPeriodWarnMessage.equalsIgnoreCase("none") == false){
                    p.sendMessage(ConfigPluginMain.PluginPrefix + ConfigDoEvent.AntiSpamPeriodWarnMessage);
                }
            }else{
                CheckList.put(pn, System.currentTimeMillis());
            }
        }
    }

    @EventHandler
    public void AntiDirty(AsyncPlayerChatEvent event) {
        if (ConfigDoEvent.AntiSpamenable == true) {
            Player p = event.getPlayer();
            String message = event.getMessage();
            if (p.hasPermission("VLagger.bypass.Spam")) {
                return;
            }
            List<String[]> DirtyListStrings = ConfigDoEvent.AntiSpamDirtyListStrings();
            int dlsl = DirtyListStrings.size();
            for(int i = 0;i<dlsl;i++){
            	String[] thisdirty = DirtyListStrings.get(i);
            	int DirtyTimes = 0;
            	int tdl = thisdirty.length;
            	for(int ii = 0;ii + 1<tdl;ii++){
            		System.out.println("字节检查" + thisdirty[ii]);
            		if(message.contains(thisdirty[ii])){
            			DirtyTimes++;
            		}
            	}
            	if(DirtyTimes >= tdl){
            		event.setCancelled(true);
                    if(ConfigDoEvent.AntiSpamDirtyWarnMessage.equalsIgnoreCase("none") == false){
                        p.sendMessage(ConfigPluginMain.PluginPrefix + ConfigDoEvent.AntiSpamDirtyWarnMessage);
                    }
            	}
            }
        }
    }
}
