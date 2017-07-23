package com.mcml.space.config;

import com.mcml.space.util.Configurable;

public abstract class ConfigPluginMain extends Configurable {
    @Node(path = "PluginPrefix")
    public static String PluginPrefix = "§a§l[Vlagger]";
    
    @Node(path = "AutoUpdate")
    public static boolean AutoUpdate;
    
    @Node(path = "internal-version")
    public static int internalVersion = Integer.valueOf("%BUILD_NUMBER%");
    
}
