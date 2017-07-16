package com.mcml.space.util;

import org.bukkit.Bukkit;

public class VersionLevel {
    private final static Version level = check();
    private static boolean viewDistanceApi; 
    
    public static final Version get() {
        return level;
    }
    
    private static Version check() {
        final String version = Bukkit.getServer().getVersion();
        if (version.contains("1.12")) {
            if (isPaper(version)) return Version.MINECRAFT_1_12_R1_PAPER;
            return Version.MINECRAFT_1_12_R1_SPIGOT;
        }
        
        if (version.contains("1.11")) {
            if (isPaper(version)) return Version.MINECRAFT_1_11_R1_PAPER;
            return Version.MINECRAFT_1_11_R1_SPIGOT;
        }
        
        if (version.contains("1.10")) {
            if (isPaper(version)) return Version.MINECRAFT_1_10_R1_PAPER;
            return Version.MINECRAFT_1_10_R1_SPIGOT;
        }
        
        if (version.contains("1.9.4")) {
            if (isPaper(version)) return Version.MINECRAFT_1_9_R2_PAPER;
            return Version.MINECRAFT_1_9_R2_SPIGOT;
        }
        
        if (version.contains("1.9")) {
            if (isPaper(version)) return Version.MINECRAFT_1_9_R1_PAPER;
            return Version.MINECRAFT_1_9_R1_SPIGOT;
        }
        
        if (version.contains("1.8.8")) {
            if (isPaper(version)) return Version.MINECRAFT_1_8_R3_PAPER;
            return Version.MINECRAFT_1_8_R3_SPIGOT;
        }
        
        if (version.contains("1.8.3")) {
            return Version.MINECRAFT_1_8_R2;
        }
        
        if (version.contains("1.8")) {
            return Version.MINECRAFT_1_8_R1;
        }
        
        if (version.contains("1.7.10")) {
            return Version.MINECRAFT_1_7_R4;
        }
        
        if (version.contains("1.7.9")) {
            return Version.MINECRAFT_1_7_R3;
        }
        
        if (version.contains("1.7.5")) {
            return Version.MINECRAFT_1_7_R2;
        }
        
        if (version.contains("1.7")) {
            return Version.MINECRAFT_1_7_R1;
        }
        
        if (version.contains("1.6.4")) {
            return Version.MINECRAFT_1_6_R3;
        }
        
        if (version.contains("1.6.2")) {
            return Version.MINECRAFT_1_6_R2;
        }
        
        if (version.contains("1.6.1")) {
            return Version.MINECRAFT_1_6_R1;
        }
        
        if (version.contains("1.5.2")) {
            return Version.MINECRAFT_1_5_R3;
        }
        
        if (version.contains("1.5.1")) {
            return Version.MINECRAFT_1_5_R2;
        }
        
        if (version.contains("1.5")) {
            return Version.MINECRAFT_1_5_R1;
        }
        
        if (version.contains("1.4.7")) {
            return Version.MINECRAFT_1_4_R1;
        }
        
        if (version.contains("1.4.6")) {
            return Version.MINECRAFT_1_4_6;
        }
        
        AzureAPI.log("Cannot capture server version (unsupport?)");
        return Version.UNKNOWN;
    }
    
    public static boolean isPaper(String bukkitVersion) {
        boolean paper = bukkitVersion.contains("Paper") || bukkitVersion.contains("Taco") || bukkitVersion.contains("Torch");
        if (paper) viewDistanceApi = true;
        return paper;
    }
    
    public enum Version {
        MINECRAFT_1_12_R1_SPIGOT,
        MINECRAFT_1_12_R1_PAPER,
        
        MINECRAFT_1_11_R1_SPIGOT,
        MINECRAFT_1_11_R1_PAPER,
        
        MINECRAFT_1_10_R1_SPIGOT,
        MINECRAFT_1_10_R1_PAPER,
        
        MINECRAFT_1_9_R2_SPIGOT,
        MINECRAFT_1_9_R2_PAPER,
        
        MINECRAFT_1_9_R1_SPIGOT,
        MINECRAFT_1_9_R1_PAPER,
        
        MINECRAFT_1_8_R3_SPIGOT,
        MINECRAFT_1_8_R3_PAPER,
        
        MINECRAFT_1_8_R2,
        MINECRAFT_1_8_R1,
        MINECRAFT_1_7_R4,
        MINECRAFT_1_7_R3,
        MINECRAFT_1_7_R2,
        MINECRAFT_1_7_R1,
        MINECRAFT_1_6_R3,
        MINECRAFT_1_6_R2,
        MINECRAFT_1_6_R1,
        MINECRAFT_1_5_R3,
        MINECRAFT_1_5_R2,
        MINECRAFT_1_5_R1,
        MINECRAFT_1_4_R1,
        
        MINECRAFT_1_4_6,
        
        UNKNOWN
    }
    
    public static boolean hasViewDistanceApi() {
        return viewDistanceApi;
    }
}

/**
@author SotrForgotten
此部分代码为 SotrForgotten 重制，并已授权使用！
QWQ，感谢支持！
*/