package com.mcml.space.util;

import static com.mcml.space.util.VersionLevel.hasViewDistanceApi;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AzureAPI {
    private static String prefix;
    private static int bukkitVDBlock = Bukkit.getViewDistance() << 4; // *16

    private static final class LazyAPI {
        private static final AzureAPI api = new AzureAPI();
    }

    private AzureAPI() {
        assert Bukkit.getServer() != null;
        assert LazyAPI.api == null;
    }

    public static final AzureAPI getAPI() {
        return LazyAPI.api;
    }

    public static int viewDistance(final Player player) {
        return Bukkit.getViewDistance();
    }

    public static int viewDistanceBlock(final Player player) {
        if (hasViewDistanceApi())
            return Bukkit.getViewDistance() << 4;
        return bukkitVDBlock;
    }

    public static String setPrefix(final String prefix) {
        AzureAPI.prefix = prefix;
        return prefix;
    }

    public static void resetPrefix() {
        AzureAPI.prefix = null;
    }

    public static void log(final String prefix, final String context) {
        Bukkit.getConsoleSender().sendMessage(prefix + context);
    }

    public static void log(final String context) {
        Bukkit.getConsoleSender().sendMessage(AzureAPI.prefix == null ? context : AzureAPI.prefix + context);
    }

    public static void log(final CommandSender sender, final String context) {
        sender.sendMessage(AzureAPI.prefix == null ? context : AzureAPI.prefix + context);
    }

    public static void log(final CommandSender sender, final String prefix, final String msg) {
        sender.sendMessage(prefix + msg);
    }

    public static long toTicks(TimeUnit unit, long duration) {
        return unit.toSeconds(duration) * 20;
    }

    public static Logger createLogger(final String prefix) {
        assert prefix != null;
        return new PrefixedLogger(prefix);
    }

    protected static class PrefixedLogger extends Logger {
        protected final String prefix;

        protected PrefixedLogger(final String prefix) {
            super(prefix, null);
            this.prefix = prefix;
            setParent(Logger.getGlobal());
            setLevel(Level.INFO);
        }

        @Override
        public void log(final LogRecord logRecord) {
            if (this.isLoggable(logRecord.getLevel()))
                Bukkit.getConsoleSender().sendMessage(prefix + logRecord.getMessage());
        }
    }

    public static Coord2D wrapCoord2D(int x, int z) {
        return new Coord2D(x, z);
    }

    public static class Coord2D {
        final int x;
        final int z;

        public Coord2D(int x2d, int z2d) {
            x = x2d;
            z = z2d;
        }

        public int getX() {
            return x;
        }

        public int getZ() {
            return z;
        }
    }
}
/**
@author SotrForgotten
此部分代码为 SotrForgotten 重制，并已授权使用！
QWQ，感谢支持！
 */
