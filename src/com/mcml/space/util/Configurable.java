package com.mcml.space.util;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.bukkit.configuration.file.FileConfiguration;
import com.mcml.space.core.VLagger;

public abstract class Configurable {
    @Node(path = "HeapShut.enable", def = "true")
    public static boolean HeapShutenable;
    
    @Node(path = "HeapShut.Percent", def = "90")
    public static int HeapShutPercent;
    
    @Node(path = "HeapShut.WarnMessage", def = "服务器会在15秒后重启，请玩家不要游戏，耐心等待！ ╮(╯_╰)╭")
    public static String HeapShutWarnMessage;
    
    @Node(path = "HeapShut.WaitingTime", def = "15")
    public static int HeapShutWaitingTime;
    
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    protected static @interface Node {
        String path();
        String def();
    }
    
    public static void restoreNodes() throws IllegalArgumentException, IllegalAccessException, IOException {
        assert VLagger.MainThis != null;
        FileConfiguration config = VLagger.load(VLagger.ClearLagConfigFile);
        
        for (Field field : Configurable.class.getDeclaredFields()) {
            Node node = field.getAnnotation(Node.class);
            if (node == null) continue;
            
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) && !Modifier.isFinal(mod)) {
                String path = node.path();
                
                Object value = config.get(path);
                if (value == null) {
                    config.set(path, value = parseType(field, node.def()));
                }
                field.set(null, value);
            }
        }
        
        config.save(VLagger.ClearLagConfigFile);
    }
    
    public static Object parseType(Field t, String value) {
        Class<?> type = t.getType();
        if (type.isAssignableFrom(Integer.class) || type.isAssignableFrom(int.class)) {
            return Integer.valueOf(value);
        }
        
        if (type.isAssignableFrom(Boolean.class) || type.isAssignableFrom(boolean.class)) {
            return Boolean.valueOf(value);
        }
        
        if (type.isAssignableFrom(Float.class) || type.isAssignableFrom(float.class)) {
            return Float.valueOf(value);
        }
        
        if (type.isAssignableFrom(Double.class) || type.isAssignableFrom(double.class)) {
            return Double.valueOf(value);
        }
        
        if (type.isAssignableFrom(Long.class) || type.isAssignableFrom(long.class)) {
            return Long.valueOf(value);
        }
        
        if (type.isAssignableFrom(String.class)) {
            return String.valueOf(value);
        }
        
        throw new UnsupportedOperationException();
    }
}
