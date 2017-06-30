package com.mcml.space;

import java.io.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class VLagger extends JavaPlugin
        implements Listener {

    public static boolean HeapShutenable;
    public static int HeapShutPercent;
    public static String HeapShutWarnMessage;
    public static int HeapShutWaitingTime;
    public static boolean TPSSleepenable;
    public static long TPSSleepPeriod;
    private static boolean AutoSetenable;
    public static boolean AutoSaveenable;
    public static boolean ClearItemenable;
    public static boolean NooneRestartenable;
    public static boolean ChunkKeeperenable;
    public static boolean ChunkUnloaderenable;
    private static int NooneRestartCheckInterval;
    public static int AutoSaveInterval;
    public static boolean AntiInfItemenable;
    public static boolean AntiPortalInfItemenable;
    public static boolean AntiNetherHopperInfItemenable;
    public static Object AntiRPGITEMenable;
    public static boolean NoCrowdedEntityenable;
    public static int NoCrowdedEntityPerChunkLimit;
    public static boolean TilesClearenable;
    private static int TilesClearInterval;
    public static boolean AntiCrashSignenable;
    public static boolean NoExplodeenable;
    public static String NoExplodeType;
    public static boolean AntiRedstoneenable;
    public static long AntiRedstoneInterval;
    public static String AntiRedstoneMessage;
    public static String TilesClearMessage;
    private static int ChunkUnloaderInterval;
    public static String PluginPrefix;
    public static boolean AntiInfRailenable;
    public static boolean AutoRespawnenable;
    File file;
    public static VLagger MainThis;
    public FileConfiguration config;
    private static File ClearLagConfigFile;
    private static File NoBugConfigFile;
    private static File MainConfigFile;
    public static File EventConfigFile;
    public static boolean AntiSpamenable;
    public static long AntiSpamPeriod;
    public static String AntiSpamWarnMessage;
    public static boolean AntiSkullCrashenable;
    public static boolean NoDoubleOnlineenanle;
    public static String NoDoubleOnlineKickMessage;
    public static boolean AntiDropInfItemenable;
    public static boolean NoEggChangeSpawnerenable;
    public static boolean AntiDoorInfItemenable;
    public static boolean HeapClearenable;
    private static int HeapClearPeriod;
    public static String HeapClearMessage;
    public static boolean AntiCheatBookenable;
    public static String AntiCheatBookWarnMessage;
    public static ArrayList<EntityType> NoCrowdedEntityTypeList = new ArrayList();
    public static boolean TeleportPreLoaderenable;
    public static boolean AntiBedExplodeenable;
    public static boolean AntiBreakUseingChestenable;
    public static boolean BlockCommanderenable;
    public static File PluginFile;

    @Override
    public void onEnable() {
        ClearLagConfigFile = new File(this.getDataFolder(), "ClearLagConfig.yml");
        NoBugConfigFile = new File(this.getDataFolder(), "NoBugConfig.yml");
        MainConfigFile = new File(this.getDataFolder(), "MainConfig.yml");
        EventConfigFile = new File(this.getDataFolder(), "EventConfig.yml");
        PluginFile = this.getFile();
        MainThis = this;
        VLagger.LoadConfig();
        getLogger().info("VLagger —— 新一代的优化/稳定插件");
        getLogger().info("~(@^_^@)~ 玩的开心！~");
        getLogger().info("清理内存模块...");
        getLogger().info("濒临重启模块...");
        getLogger().info("TPS停顿模块...");
        getLogger().info("区块保持者模块...");
        getLogger().info("自动配端模块...");
        getLogger().info("自动储存模块...");
        getLogger().info("自动清理掉落物模块...");
        getLogger().info("无人重启模块...");
        getLogger().info("修复游戏Bug模块...");
        getLogger().info("反密集实体模块...");
        getLogger().info("禁止高频红石模块...");
        getLogger().info("区块清理者模块...");
        getLogger().info("高级反爆炸模块...");
        getLogger().info("Tiles内存处理模块...");
        getLogger().info("区块卸载者模块...");
        getLogger().info("反玩家刷屏机器模块...");
        getLogger().info("限制刷怪蛋修改刷怪笼模块...");
        getLogger().info("显性内存清理模块...");
        getLogger().info("计划传送模块...");
        getLogger().info("命令拦截模块...");
        getLogger().info("自动重生模块...");
        getLogger().info("------加载完毕------");
        getLogger().info("乐乐感谢您的使用——有Bug务必反馈，QQ1207223090");
        getLogger().info("|||Vlvxingze/VLagger PluginCD小组作品.|||");
        if (AutoSetenable == true) {
            VLagger.AutoSetServer();
        }

        Bukkit.getPluginManager().registerEvents(new AntiInfItem(), this);
        Bukkit.getPluginManager().registerEvents(new AntiPortalInfItem(), this);
        Bukkit.getPluginManager().registerEvents(new AntiNetherHopperInfItem(), this);
        Bukkit.getPluginManager().registerEvents(new AntiRPGITEM(), this);
        Bukkit.getPluginManager().registerEvents(new ChunkKeeper(), this);
        Bukkit.getPluginManager().registerEvents(new NoCrowdEntity(), this);
        Bukkit.getPluginManager().registerEvents(new AntiCrashSign(), this);
        Bukkit.getPluginManager().registerEvents(new AntiSpam(), this);
        Bukkit.getPluginManager().registerEvents(new NoExplodeofEntity(), this);
        Bukkit.getPluginManager().registerEvents(new AntiRedstone(), this);
        Bukkit.getPluginManager().registerEvents(new ItemClear(), this);
        Bukkit.getPluginManager().registerEvents(new ChunkUnloaderofListener(), this);
        Bukkit.getPluginManager().registerEvents(new AntiInfRail(), this);
        Bukkit.getPluginManager().registerEvents(new AutoSaveOfListener(), this);
        Bukkit.getPluginManager().registerEvents(new AntiSkullCrash(), this);
        Bukkit.getPluginManager().registerEvents(new NoDoubleOnline(), this);
        Bukkit.getPluginManager().registerEvents(new NoEggChangeSpawner(), this);
        Bukkit.getPluginManager().registerEvents(new AntiDropInfItem(), this);
        Bukkit.getPluginManager().registerEvents(new AntiDoorInfItem(), this);
        Bukkit.getPluginManager().registerEvents(new TeleportPreLoader(), this);
        Bukkit.getPluginManager().registerEvents(new AntiBedExplode(), this);
        Bukkit.getPluginManager().registerEvents(new BlockCommander(), this);
        Bukkit.getPluginManager().registerEvents(new AutoRespawn(), this);
        NoExplodeofBlock.RegisterEvents();

        ChunkKeeper.ChunkKeeperofTask();
        Bukkit.getScheduler().runTaskTimer(this, new TilesClear(), TilesClearInterval * 20, TilesClearInterval * 20);
        getServer().getScheduler().runTaskTimer(this, new ChunkUnloader(), 0, ChunkUnloaderInterval * 20);
        getServer().getScheduler().runTaskTimer(this, new AutoSaveofTask(), 240 * 20, 240 * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new NoOneRestart(), NooneRestartCheckInterval * 20, NooneRestartCheckInterval * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new HeapShut(), 1 * 60 * 20, 1 * 60 * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new TPSSleep(), 1, 1);
        Bukkit.getScheduler().runTaskTimer(this, new HeapClear(), HeapClearPeriod * 20, HeapClearPeriod * 20);
        Bukkit.getScheduler().runTaskAsynchronously(this, new NetWorker());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("vlg")) {
            sender.sendMessage("§b------§a§lVLagger§b------");
            if (sender.hasPermission("VLagger.admin")) {
                if (args.length == 0) {
                    sender.sendMessage("§c请输入/vlg help 来获取帮助");
                    return true;
                }
                if (args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage("§e/vlg reload 重载插件");
                    sender.sendMessage("§e/vlg chunkkeeper 查看关于区块保持者的帮助");
                    sender.sendMessage("§e/vlg heap 查阅关于内存清理和分配的内容");
                    sender.sendMessage("§e/vlg autosave 查阅关于自动储存的内容");
                    sender.sendMessage("§e/vlg tpssleep 查阅关于主线程停顿");
                    sender.sendMessage("§e/vlg autoset 查阅关于自动配端");
                    sender.sendMessage("§e/vlg noonerestart 查阅关于无人重启");
                }
                if(args[0].equalsIgnoreCase("noonerestart")){
                    if(args.length == 1){
                        sender.sendMessage("§a后置参数:");
                        sender.sendMessage("§enow 立即执行一次无人重启");
                    }
                    if(args[1].equalsIgnoreCase("now")){
                        Bukkit.getScheduler().runTask(this, new NoOneRestart());
                        sender.sendMessage("§e操作已经执行完毕！");
                    }
                }
                if(args[0].equalsIgnoreCase("autoset")){
                    if(args.length == 1){
                        sender.sendMessage("§a后置参数:");
                        sender.sendMessage("§eset 执行一次配端操作");
                    }
                    if(args[1].equalsIgnoreCase("set")){
                        VLagger.AutoSetServer();
                        sender.sendMessage("§a配端完成！重启服务器即可生效！");
                    }
                }
                if (args[0].equalsIgnoreCase("chunkkeeper")) {
                    if (args.length == 1) {
                        sender.sendMessage("§a后置参数:");
                        sender.sendMessage("§elist 查阅以及被保持的区块列表");
                        sender.sendMessage("§eaddthis 将你所处区块加入保持列表");
                        sender.sendMessage("§eremovethis 将你所处区块删除报错列表");
                        sender.sendMessage("§eclear 清空所有区块保持列表");
                        return true;
                    }
                    if (args[1].equalsIgnoreCase("list")) {
                        sender.sendMessage("§e目前以及被保存的区块列表:ChunkKeeper.ShouldKeepList");
                    }
                    if (args[1].equalsIgnoreCase("addthis")) {
                        Player p = (Player) sender;
                        Chunk chunk = p.getLocation().getChunk();
                        ChunkKeeper.ShouldKeepList.add(chunk);
                        sender.sendMessage("§e成功将你所在区块加入保持列表");
                    }
                    if (args[1].equalsIgnoreCase("removethis")) {
                        Player p = (Player) sender;
                        Chunk chunk = p.getLocation().getChunk();
                        if (ChunkKeeper.ShouldKeepList.contains(chunk)) {
                            ChunkKeeper.ShouldKeepList.remove(chunk);
                            sender.sendMessage("§e成功将所在区块从保持列表中删除");
                        } else {
                            sender.sendMessage("§e失败将所在区块从保持列表中删除，因为该区块不在保持列表中。");
                        }
                    }
                    if (args[1].equalsIgnoreCase("clear")) {
                        ChunkKeeper.ShouldKeepList.clear();
                        sender.sendMessage("§e已经清空所有在保持列表的区块。");
                    }
                }
                if (args[0].equalsIgnoreCase("heap")) {
                    if (args.length == 1) {
                        sender.sendMessage("§a后置参数:");
                        sender.sendMessage("§elook 查阅内存使用情况");
                        sender.sendMessage("§eclearheap 强制用java回收内存");
                        sender.sendMessage("§ecleartiles 执行一次清理无用tiles");
                        sender.sendMessage("§eclearchunk 执行一次检测清理区块");
                        sender.sendMessage("§echunkunloadlog 查阅区块卸载计数器");
                        return true;
                    }
                    if (args[1].equalsIgnoreCase("look")) {
                        sender.sendMessage("§e最大内存 §a" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "MB");
                        sender.sendMessage("§e剩余内存 §b" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "MB");
                        sender.sendMessage("§e分配内存 §c" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "MB");
                    }
                    if (args[1].equalsIgnoreCase("clearheap")) {
                        System.gc();
                        System.runFinalization();
                        sender.sendMessage("§6内存清理完毕！");
                    }
                    if (args[1].equalsIgnoreCase("cleartiles")) {
                        getServer().getScheduler().runTask(this, new TilesClear());
                        sender.sendMessage("§6Tiles清理完毕！");
                    }
                    if (args[1].equalsIgnoreCase("clearchunk")) {
                        getServer().getScheduler().runTask(this, new ChunkUnloader());
                        sender.sendMessage("§6区块清理完毕！");
                    }
                    if (args[1].equalsIgnoreCase("chunkunloadlog")) {
                        sender.sendMessage("§a截止到目前，插件已经卸载了" + ChunkUnloader.ChunkUnloaderTimes + "个无用区块");
                    }
                }
                if (args[0].equalsIgnoreCase("autosave")) {
                    if (args.length == 1) {
                        sender.sendMessage("§a后置参数:");
                        sender.sendMessage("§esave 立即存储所有玩家数据");
                        sender.sendMessage("§esavethis 将自己所在区块存储");
                        return true;
                    }
                    if (args[1].equalsIgnoreCase("save")) {
                        Bukkit.getScheduler().runTask(this, new AutoSaveofTask());
                        sender.sendMessage("§e成功储存了所有玩家的游戏数据");
                    }
                    if (args[1].equalsIgnoreCase("savethis")) {
                        Player p = (Player) sender;
                        p.getLocation().getChunk().unload(true);
                        p.getLocation().getChunk().load();
                        sender.sendMessage("§e已经尝试储存区块，该操作不安全!");
                    }
                }
                if (args[0].equalsIgnoreCase("tpssleep")) {
                    if (args.length == 1) {
                        sender.sendMessage("§a后置参数:");
                        sender.sendMessage("§esleep <ms> 停顿主线程毫秒");
                        return true;
                    }
                    if (args[1].equalsIgnoreCase("sleep")) {
                        sender.sendMessage("§e成功强制停顿了线程" + args[2] + "毫秒");
                        try {
                            Thread.sleep(Long.parseLong(args[2]));
                        } catch (Exception ex) {
                            sender.sendMessage("§c警告，出现错误!" + ex.toString());
                        }
                    }
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    VLagger.LoadConfig();
                    sender.sendMessage("§a§l[VLagger]配置已经成功重载！");
                    return true;
                }
            } else {
                sender.sendMessage("§a§l[VLagger]§4抱歉！您没有足够的权限！");
            }
            return true;
        }
        return false;
    }

    private static void LoadConfig() {
        FileConfiguration MainConfig = load(MainConfigFile);
        if (MainConfig.getInt("Version") != AllSet.Version) {
            MainConfig.set("Version", AllSet.Version);
            MainConfig.set("PluginPrefix", "§a§l[Vlagger]");
            try {
                MainConfig.save(MainConfigFile);
            } catch (IOException ex) {
            }
        }
        PluginPrefix = MainConfig.getString("PluginPrefix");

        FileConfiguration ClearLagConfig = load(ClearLagConfigFile);
        if (ClearLagConfig.getInt("Version") != AllSet.Version) {
            ClearLagConfig.set("Version", AllSet.Version);
            ClearLagConfig.set("HeapShut.enable", true);
            ClearLagConfig.set("HeapShut.Percent", 90);
            ClearLagConfig.set("HeapShut.WarnMessage", "服务器会在15秒后重启，请玩家不要游戏，耐心等待！ ╮(╯_╰)╭");
            ClearLagConfig.set("HeapShut.WaitingTime", 15);
            ClearLagConfig.set("TPSSleep.enable", false);
            ClearLagConfig.set("TPSSleep.Period", 10);
            ClearLagConfig.set("AutoSet.enable", true);
            ClearLagConfig.set("AutoSave.enable", true);
            ClearLagConfig.set("AutoSave.Interval", 15);
            ClearLagConfig.set("ClearItem.enable", true);
            ClearLagConfig.set("NooneRestart.enable", true);
            ClearLagConfig.set("NooneRestart.CheckInterval", 6000);
            ClearLagConfig.set("ChunkKeeper.enable", true);
            ClearLagConfig.set("ChunkUnloader.enable", true);
            ClearLagConfig.set("NoCrowdedEntity.enable", true);
            ClearLagConfig.set("NoCrowdedEntity.PerChunkLimit", 30);
            List<String> entt = new ArrayList();
            entt.add("ZOMBIE");
            entt.add("SKELETON");
            entt.add("SPIDER");
            entt.add("CREEPER");
            entt.add("SHEEP");
            entt.add("PIG");
            entt.add("CHICKEN");
            ClearLagConfig.set("NoCrowdedEntity.TypeList", entt);
            ClearLagConfig.set("TilesClear.enable", true);
            ClearLagConfig.set("TilesClear.Interval", 360);
            ClearLagConfig.set("NoExplode.enable", true);
            ClearLagConfig.set("NoExplode.Type", "NoBlockBreak");
            ClearLagConfig.set("AntiRedstone.enable", true);
            ClearLagConfig.set("AntiRedstone.Interval", 500);
            ClearLagConfig.set("AntiRedstone.Message", "§c检测到高频红石在 %location% ，插件已经将其清除，不许玩了！ (╰_╯)#");
            ClearLagConfig.set("TilesClear.Message", "§e服务器清理Tiles完毕 ~(@^_^@)~");
            ClearLagConfig.set("ChunkUnloader.Interval", 30);
            ClearLagConfig.set("HeapClear.enable", false);
            ClearLagConfig.set("HeapClear.Period", 600);
            ClearLagConfig.set("HeapClear.Message", "§e服务器清理内存中... ԅ(¯ㅂ¯ԅ)");
            ClearLagConfig.set("TeleportPreLoader.enable", true);
            try {
                ClearLagConfig.save(ClearLagConfigFile);
            } catch (IOException ex) {
            }
        }
        HeapShutenable = ClearLagConfig.getBoolean("HeapShut.enable");
        HeapShutPercent = ClearLagConfig.getInt("HeapShut.Percent");
        HeapShutWarnMessage = ClearLagConfig.getString("HeapShut.WarnMessage");
        HeapShutWaitingTime = ClearLagConfig.getInt("HeapShut.WaitingTime");
        TPSSleepenable = ClearLagConfig.getBoolean("TPSSleep.enable");
        TPSSleepPeriod = ClearLagConfig.getLong("TPSSleep.Period");
        AutoSetenable = ClearLagConfig.getBoolean("AutoSet.enable");
        AutoSaveenable = ClearLagConfig.getBoolean("AutoSave.enable");
        AutoSaveInterval = ClearLagConfig.getInt("AutoSave.Interval");
        ClearItemenable = ClearLagConfig.getBoolean("ClearItem.enable");
        NooneRestartenable = ClearLagConfig.getBoolean("NooneRestart.enable");
        NooneRestartCheckInterval = ClearLagConfig.getInt("NooneRestart.CheckInterval");
        ChunkKeeperenable = ClearLagConfig.getBoolean("ChunkKeeper.enable");
        ChunkUnloaderenable = ClearLagConfig.getBoolean("ChunkUnloader.enable");
        NoCrowdedEntityenable = ClearLagConfig.getBoolean("NoCrowdedEntity.enable");
        NoCrowdedEntityPerChunkLimit = ClearLagConfig.getInt("NoCrowdedEntity.PerChunkLimit");
        List<String> NoCrowdedEntityTypeStringList = ClearLagConfig.getStringList("NoCrowdedEntity.TypeList");
        for (int i = 0; i < NoCrowdedEntityTypeStringList.size(); i++) {
            EntityType et = EntityType.fromName(NoCrowdedEntityTypeStringList.get(i));
            NoCrowdedEntityTypeList.add(et);
        }
        TilesClearenable = ClearLagConfig.getBoolean("TilesClear.enable");
        TilesClearInterval = ClearLagConfig.getInt("TilesClear.Interval");
        NoExplodeenable = ClearLagConfig.getBoolean("NoExplode.enable");
        NoExplodeType = ClearLagConfig.getString("NoExplode.Type");
        AntiRedstoneenable = ClearLagConfig.getBoolean("AntiRedstone.enable");
        AntiRedstoneInterval = ClearLagConfig.getLong("AntiRedstone.Interval");
        AntiRedstoneMessage = ClearLagConfig.getString("AntiRedstone.Message");
        TilesClearMessage = ClearLagConfig.getString("TilesClear.Message");
        ChunkUnloaderInterval = ClearLagConfig.getInt("ChunkUnloader.Interval");
        HeapClearenable = ClearLagConfig.getBoolean("HeapClear.enable");
        HeapClearPeriod = ClearLagConfig.getInt("HeapClear.Period");
        HeapClearMessage = ClearLagConfig.getString("HeapClear.Message");
        TeleportPreLoaderenable = ClearLagConfig.getBoolean("TeleportPreLoader");

        FileConfiguration NoBugConfig = load(NoBugConfigFile);
        if (NoBugConfig.getInt("Version") != AllSet.Version) {
            NoBugConfig.set("Version", AllSet.Version);
            NoBugConfig.set("AntiInfItem.enable", true);
            NoBugConfig.set("AntiPortalInfItem.enable", true);
            NoBugConfig.set("AntiNetherHopperInfItem.enable", true);
            NoBugConfig.set("AntiRPGITEM.enable", true);
            NoBugConfig.set("AntiCrashSign.enable", true);
            NoBugConfig.set("AntiSkullCrash.enable", true);
            NoBugConfig.set("NoDoubleOnline.enable", true);
            NoBugConfig.set("NoDoubleOnline.KickMessage", "抱歉，服务器中您已经在线了。ԅ(¯ㅂ¯ԅ)");
            NoBugConfig.set("AntiDropInfItem.enable", true);
            NoBugConfig.set("AntiDoorInfItem.enable", true);
            NoBugConfig.set("AntiCheatBook.enable", true);
            NoBugConfig.set("AntiCheatBook.WarnMessage", "§c严禁利用超级书Bug！");
            NoBugConfig.set("AntiBedExplode.enable", true);
            NoBugConfig.set("AntiBreakUseingChest.enable", true);
            NoBugConfig.set("AntiInfRail.enable", true);
            try {
                NoBugConfig.save(NoBugConfigFile);
            } catch (IOException ex) {
            }
        }
        AntiInfItemenable = NoBugConfig.getBoolean("AntiInfItem.enable");
        AntiPortalInfItemenable = NoBugConfig.getBoolean("AntiPortalInfItem.enable");
        AntiNetherHopperInfItemenable = NoBugConfig.getBoolean("AntiNetherHopperInfItem.enable");
        AntiRPGITEMenable = NoBugConfig.get("AntiRPGITEM.enable");
        AntiCrashSignenable = NoBugConfig.getBoolean("AntiCrashSign.enable");
        AntiSkullCrashenable = NoBugConfig.getBoolean("AntiSkullCrash.enable");
        NoDoubleOnlineenanle = NoBugConfig.getBoolean("NoDoubleOnline.enable");
        NoDoubleOnlineKickMessage = NoBugConfig.getString("NoDoubleOnline.KickMessage");
        AntiDropInfItemenable = NoBugConfig.getBoolean("AntiDropInfItem.enable");
        AntiDoorInfItemenable = NoBugConfig.getBoolean("AntiDoorInfItem.enable");
        AntiCheatBookenable = NoBugConfig.getBoolean("AntiCheatBook.enable");
        AntiCheatBookWarnMessage = NoBugConfig.getString("AntiCheatBookWarnMessage");
        AntiBedExplodeenable = NoBugConfig.getBoolean("AntiBedExplode.enable");
        AntiBreakUseingChestenable = NoBugConfig.getBoolean("AntiBreakUseingChest.enable");
        AntiInfRailenable = NoBugConfig.getBoolean("AntiInfRail.enable");

        FileConfiguration EventConfig = load(EventConfigFile);
        if (EventConfig.getInt("Version") != AllSet.Version) {
            EventConfig.set("Version", AllSet.Version);
            EventConfig.set("AntiSpam.enable", true);
            EventConfig.set("AntiSpam.Period", 2F);
            EventConfig.set("AntiSpam.WarnMessage", "§c请慢点说话，别激动嘛！ _(:з」∠)_");
            EventConfig.set("NoEggChangeSpawner.enable", true);
            EventConfig.set("BlockCommander.enable", true);
            EventConfig.set("BlockCommander.List.NoSpawnWorld./spawn", true);
            EventConfig.set("BlockCommander.List.NoSpawnWorld./spawn.Message", "想在这个世界回城？没门！");
            EventConfig.set("BlockCommander.List.worldname./back", true);
            EventConfig.set("BlockCommander.List.worldname./back.Message", "不好使，不可以用back!");
            EventConfig.set("BlockCommander.List.worldname./tpa", true);
            EventConfig.set("BlockCommander.List.worldname./tpa.Message", "WIFI没信号，不能传送。");
            EventConfig.set("AutoRespawn.enable", true);
            try {
                EventConfig.save(EventConfigFile);
            } catch (IOException ex) {
            }
        }
        AntiSpamenable = EventConfig.getBoolean("AntiSpam.enable");
        AntiSpamPeriod = EventConfig.getLong("AntiSpam.Period");
        AntiSpamWarnMessage = EventConfig.getString("AntiSpam.WarnMessage");
        NoEggChangeSpawnerenable = EventConfig.getBoolean("NoEggChangeSpawner");
        BlockCommanderenable = EventConfig.getBoolean("BlockCommander.enable");
        AutoRespawnenable = EventConfig.getBoolean("AutoRespawn.enable");
    }

    private static void AutoSetServer() {
        File BukkitFile = new File("bukkit.yml");
        FileConfiguration bukkit = load(BukkitFile);
        bukkit.set("chunk-gc.period-in-ticks", 300);
        bukkit.set("chunk-gc.load-threshold", 400);
        bukkit.set("ticks-per.autosave", 0);
        bukkit.set("ticks-per.monster-spawns", 3);
        bukkit.set("VLagger.Changed", "如果Config的AutoSet开启，该参数会被改变。");
        File SpigotFile = new File("spigot.yml");
        FileConfiguration spigot = load(SpigotFile);
        spigot.set("settings.user-cache-size", 5000);
        spigot.set("settings.save-user-cache-on-stop-only", true);
        spigot.set("world-settings.default.view-distance", 4);
        spigot.set("world-settings.default.chunks-per-tick", 350);
        spigot.set("world-settings.default.max-tick-time.tile", 10);
        spigot.set("world-settings.default.max-tick-time.entity", 20);
        spigot.set("world-settings.default.entity-activation-range.animals", 12);
        spigot.set("world-settings.default.entity-activation-range.monsters", 24);
        spigot.set("world-settings.default.entity-activation-range.misc", 2);
        spigot.set("world-settings.default.entity-tracking-range.other", 48);
        spigot.set("world-settings.default.random-light-updates", false);
        spigot.set("world-settings.default.save-structure-info", false);
        spigot.set("world-settings.default.max-entity-collisions", 2);
        spigot.set("world-settings.default.max-tnt-per-tick", 20);
        spigot.set("VLagger.Changed", "如果Config的AutoSet开启，该参数会被改变。");
        try {
            bukkit.save(BukkitFile);
            spigot.save(SpigotFile);
        } catch (IOException ex) {
        }
        if (bukkit.getInt("VLagger.SetStep") == 1) {
            bukkit.set("VLagger.SetStep", 2);
            try {
                bukkit.save(BukkitFile);
            } catch (IOException ex) {
            }
        }
        if (bukkit.getInt("VLagger.SetStep") == 0) {
            bukkit.set("VLagger.SetStep", 1);
            try {
                bukkit.save(BukkitFile);
            } catch (IOException ex) {
            }
            MainThis.getLogger().info("成功改动服务器配端，正在重启来启用它.");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            Bukkit.shutdown();
        }
    }

    private static void SetServerBack() {
        File BukkitFile = new File("bukkit.yml");
        FileConfiguration bukkit = load(BukkitFile);
        bukkit.set("chunk-gc.period-in-ticks", 650);
        bukkit.set("chunk-gc.load-threshold", 0);
        bukkit.set("ticks-per.autosave", 6000);
        bukkit.set("ticks-per.monster-spawns", 1);
        bukkit.set("VLagger.Changed", "如果Config的AutoSet开启，该参数会被改变。");
        bukkit.set("VLagger.SetStep", 0);
        File SpigotFile = new File("spigot.yml");
        FileConfiguration spigot = load(SpigotFile);
        spigot.set("settings.user-cache-size", 1000);
        spigot.set("settings.save-user-cache-on-stop-only", false);
        spigot.set("world-settings.default.view-distance", 10);
        spigot.set("world-settings.default.chunks-per-tick", 650);
        spigot.set("world-settings.default.max-tick-time.tile", 50);
        spigot.set("world-settings.default.max-tick-time.entity", 50);
        spigot.set("world-settings.default.entity-activation-range.animals", 48);
        spigot.set("world-settings.default.entity-activation-range.monsters", 48);
        spigot.set("world-settings.default.entity-activation-range.misc", 48);
        spigot.set("world-settings.default.entity-tracking-range.other", 64);
        spigot.set("world-settings.default.random-light-updates", true);
        spigot.set("world-settings.default.save-structure-info", true);
        spigot.set("world-settings.default.max-entity-collisions", 10);
        spigot.set("world-settings.default.max-tnt-per-tick", 100);
        spigot.set("VLagger.Changed", "如果Config的AutoSet开启，该参数会被改变。");
        try {
            bukkit.save(BukkitFile);
            spigot.save(SpigotFile);
        } catch (IOException ex) {
        }
    }

    private static FileConfiguration load(File file) {
        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public void onDisable() {
        getLogger().info("VLagger —— 已经被停止使用");
        getLogger().info("感谢您的使用——乐乐");
    }
}
