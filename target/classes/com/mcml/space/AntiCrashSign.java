package com.mcml.space;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class AntiCrashSign
        implements Listener {

    @EventHandler
    public void SignCheckChange(SignChangeEvent event) {
        if (VLagger.AntiCrashSignenable == true) {
            for (int i = 0; i < 4; i++) {
                if (event.getLine(i).length() > 127) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage("§a§l[VLagger]§c您输入的内容太长了！");
                }
            }
        }
    }
}
