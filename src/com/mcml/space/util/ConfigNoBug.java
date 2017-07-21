package com.mcml.space.util;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.bukkit.configuration.file.FileConfiguration;
import com.mcml.space.core.VLagger;

public abstract class ConfigNoBug extends Configurable {
    @Node(path = "AntiBoneBug.enable")
    public static boolean AntiBoneBugenable = true;
    
    @Node(path = "AntiBoneBug.WarnMessage")
    public static String AntiBoneBugWarnMessage = "§c严禁卡树苗催熟BUG！";
    
    @Node(path = "AntiFakeDeath.KickMessage")
    public static String AntiFakeDeathKickMessage = "§c严禁卡假死BUG！";
    
    @Node(path = "AntiFakeDeath.enable")
    public static boolean AntiFakeDeathenable = true;
    
    @Node(path = "ProtectFarm.enable")
    public static boolean ProtectFarmenable = true;
    
    @Node(path = "AntiCrashChat.enable")
    public static boolean AntiCrashChatenable = true;
    
    @Node(path = "AntiCrashChat.SpecialStringWarnMessage")
    public static String AntiCrashChatSpecialStringWarnMessage = "§c严禁使用崩服代码炸服！";
    
    @Node(path = "AntiCrashChat.ColorChatWarnMessage")
    public static String AntiCrashChatColorChatWarnMessage = "§c抱歉！为了防止服务器被破坏，服务器禁止使用颜色代码.";
    
    @Node(path = "AntiSpam.Dirty.WarnMessage")
    public static String AntiSpamDirtyWarnMessage = "§c啥事那么大搞得你想骂人啊~ _(:з」∠)_";
    
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    protected static @interface Node {
        String path();
    }
    
    public static void restoreNodes() throws IllegalArgumentException, IllegalAccessException, IOException {
        assert VLagger.MainThis != null;
        FileConfiguration config = VLagger.load(VLagger.NoBugConfigFile);
        
        for (Field field : ConfigNoBug.class.getDeclaredFields()) {
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
        
        config.save(VLagger.NoBugConfigFile);
    }
}
