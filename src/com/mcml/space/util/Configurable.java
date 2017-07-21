package com.mcml.space.util;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.bukkit.configuration.file.FileConfiguration;
import com.mcml.space.core.VLagger;

public abstract class Configurable {
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    protected static @interface Node {
        String path();
    }
    
    public static void restoreNodes(File file, Class<? extends Configurable> clazz) throws IllegalArgumentException, IllegalAccessException, IOException {
        assert VLagger.MainThis != null;
        FileConfiguration config = VLagger.load(file);
        
        for (Field field : clazz.getDeclaredFields()) {
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
        
        config.save(file);
    }
}
