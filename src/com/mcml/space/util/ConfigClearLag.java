package com.mcml.space.util;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.bukkit.configuration.file.FileConfiguration;
import com.mcml.space.core.VLagger;

public abstract class ConfigClearLag {
    @Node(path = "HeapShut.enable")
    public static boolean HeapShutenable = true;
    
    @Node(path = "HeapShut.Percent")
    public static int HeapShutPercent = 90;
    
    @Node(path = "HeapShut.WarnMessage")
    public static String HeapShutWarnMessage = "服务器会在15秒后重启，请玩家不要游戏，耐心等待！ ╮(╯_╰)╭";
    
    @Node(path = "HeapShut.WaitingTime")
    public static int HeapShutWaitingTime = 15;
    
    @Node(path = "AutoSet.enable")
    public static boolean AutoSetenable;
    
    @Node(path = "AutoSave.enable")
    public static boolean AutoSaveenable;
    
    @Node(path = "ClearItem.enable")
    public static boolean ClearItemenable;
    
    @Node(path = "NooneRestart.enable")
    public static boolean NooneRestartenable;
    
    @Node(path = "ChunkKeeper.enable")
    public static boolean ChunkKeeperenable;
    
    @Node(path = "ChunkUnloader.enable")
    public static boolean ChunkUnloaderenable;
    
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    protected static @interface Node {
        String path();
    }
    
    public static void restoreNodes() throws IllegalArgumentException, IllegalAccessException, IOException {
        assert VLagger.MainThis != null;
        FileConfiguration config = VLagger.load(VLagger.ClearLagConfigFile);
        
        for (Field field : ConfigClearLag.class.getDeclaredFields()) {
            Node node = field.getAnnotation(Node.class);
            if (node == null) continue;
            
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) && !Modifier.isFinal(mod)) {
                String path = node.path();
                
                Object value = config.get(path);
                if (value == null) {
                    config.set(path, field.get(null));
                } else {
                    field.set(null, value);
                }
            }
        }
        
        config.save(VLagger.ClearLagConfigFile);
    }
}
