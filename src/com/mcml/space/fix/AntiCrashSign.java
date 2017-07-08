package com.mcml.space.fix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import com.mcml.space.core.VLagger;

public class AntiCrashSign
        implements Listener {

    @EventHandler
    public void SignCheckChange(SignChangeEvent event) {
        if (VLagger.AntiCrashSignenable == true) {
            for (int i = 0; i < 4; i++) {
                if (event.getLine(i).length() > 100) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage("§a§l[VLagger]§c您输入的内容太长了！");
                }
            }
        }
    }
}
/**
@author jiongjionger
部分源码来自 https://github.com/jiongjionger/NeverLag
*/