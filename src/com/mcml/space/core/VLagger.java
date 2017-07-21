package com.mcml.space.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.mcml.space.doevent.AntiSpam;
import com.mcml.space.doevent.AutoRespawn;
import com.mcml.space.doevent.AutoUpdateCheck;
import com.mcml.space.doevent.BlockCommander;
import com.mcml.space.doevent.FarmProtecter;
import com.mcml.space.doevent.NoEggChangeSpawner;
import com.mcml.space.fix.AntiBedExplode;
import com.mcml.space.fix.AntiBoneBug;
import com.mcml.space.fix.AntiCrashSign;
import com.mcml.space.fix.AntiDoorInfItem;
import com.mcml.space.fix.AntiDropInfItem;
import com.mcml.space.fix.AntiFakeDeath;
import com.mcml.space.fix.AntiInfItem;
import com.mcml.space.fix.AntiInfRail;
import com.mcml.space.fix.AntiNetherHopperInfItem;
import com.mcml.space.fix.AntiPortalInfItem;
import com.mcml.space.fix.AntiRPGITEM;
import com.mcml.space.fix.AntiSkullCrash;
import com.mcml.space.optimize.AntiRedstone;
import com.mcml.space.optimize.AutoSave;
import com.mcml.space.optimize.ChunkKeeper;
import com.mcml.space.optimize.ChunkUnloader;
import com.mcml.space.optimize.ChunkUnloaderofListener;
import com.mcml.space.optimize.FireLimitor;
import com.mcml.space.optimize.HeapClear;
import com.mcml.space.optimize.HeapShut;
import com.mcml.space.optimize.ItemClear;
import com.mcml.space.optimize.NoCrowdEntity;
import com.mcml.space.optimize.NoDoubleOnline;
import com.mcml.space.optimize.NoExplodeofBlock;
import com.mcml.space.optimize.NoExplodeofEntity;
import com.mcml.space.optimize.NoOneRestart;
import com.mcml.space.optimize.TeleportPreloader;
import com.mcml.space.optimize.TilesClear;
import com.mcml.space.optimize.WaterFlowLimitor;
import com.mcml.space.util.NetWorker;
import com.mcml.space.util.Utils;

public class VLagger extends JavaPlugin implements Listener {

    public static boolean HeapShutenable;
    public static int HeapShutPercent;
    public static String HeapShutWarnMessage;
    public static int HeapShutWaitingTime;
    private static boolean AutoSetenable;
    public static boolean AutoSaveenable;
    public static boolean ClearItemenable;
    public static boolean NooneRestartenable;
    public static boolean ChunkKeeperenable;
    public static boolean ChunkUnloaderenable;
    public static int NooneRestartTimeLong;
    public static int AutoSaveInterval;
    public static boolean AntiInfItemenable;
    public static boolean AntiPortalInfItemenable;
    public static boolean AntiNetherHopperInfItemenable;
    public static boolean AntiRPGITEMenable;
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
    public static VLagger MainThis;
    public FileConfiguration config;
    public static List<String> AntiRedstoneRemoveBlockList;
    public static boolean AntiBoneBugenable;
    public static String AntiBoneBugWarnMessage;
    public static String AntiFakeDeathKickMessage;
    public static boolean AntiFakeDeathenable;
    public static boolean ProtectFarmenable;
    public static boolean AntiCrashChatenable;
    public static String AntiCrashChatSpecialStringWarnMessage;
    public static String AntiCrashChatColorChatWarnMessage;
    public static String AntiSpamDirtyWarnMessage;
    public static List<String> AntiSpamDirtyList;
    public static List<String> ClearItemNoClearItemType;
    public static boolean ClearItemNoCleatDeath;
    public static boolean ClearItemNoClearTeleport;
    public static String NoEggChangeSpawnerTipMessage;
    public static String AntiBreakUseingChestWarnMessage;
    public static String AntiBedExplodeTipMessage;
    public static String AntiCrashSignWarnMessage;
    public static String AntiPortalInfItemWarnMessage;
    public static String AntiInfItemClickcWarnMessage;
    public static String AntiInfItemBlockcWarnMessage;
    public static String BlockCommanderNoColonTip;
    public static boolean FireLimitorenable;
    public static long FireLimitorPeriod;
    public static boolean WaterFlowLimitorenable;
    public static long WaterFlowLimitorPeriod;
    public static String AutoRespawnRespawnTitleMainMessage;
    public static boolean AutoRespawnRespawnTitleenable;
    public static String AutoRespawnRespawnTitleMiniMessage;
    public static File ClearLagConfigFile;
    private static File NoBugConfigFile;
    private static File MainConfigFile;
    public static File EventConfigFile;
    public static boolean AntiSpamenable;
    public static long AntiSpamPeriodPeriod;
    public static String AntiSpamPeriodWarnMessage;
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
    public static ArrayList<EntityType> NoCrowdedEntityTypeList = new ArrayList<EntityType>();
    public static boolean TeleportPreLoaderenable;
    public static boolean AntiBedExplodeenable;
    public static boolean AntiBreakUseingChestenable;
    public static boolean BlockCommanderenable;
    public static File PluginFile;
    public static boolean AutoUpdate;

    @Override
    public void onEnable() {
        ClearLagConfigFile = new File(this.getDataFolder(), "ClearLagConfig.yml");
        NoBugConfigFile = new File(this.getDataFolder(), "NoBugConfig.yml");
        MainConfigFile = new File(this.getDataFolder(), "MainConfig.yml");
        EventConfigFile = new File(this.getDataFolder(), "EventConfig.yml");
        PluginFile = this.getFile();
        MainThis = this;
        LoadConfig();
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
        getLogger().info("计划预加载传送模块...");
        getLogger().info("命令拦截模块...");
        getLogger().info("自动重生模块...");
        getLogger().info("流水限制模块...");
        getLogger().info("火焰限制模块...");
        getLogger().info("队列登入游戏模块...");
        getLogger().info("生成限制模块...");
        getLogger().info("脏话屏蔽模块...");
        getLogger().info("耕地保护模块...");
        getLogger().info("------加载完毕------");
        getLogger().info("乐乐感谢您的使用——有建议务必反馈，QQ1207223090");
        getLogger().info("您可以在插件根目录找到本插件的说明文档 说明文档.txt");
        getLogger().info("|||Vlvxingze/VLagger PluginCD小组作品.|||");
        Bukkit.getConsoleSender().sendMessage("§a您正在使用VLagger构建号  %BUILD_NUMBER%");
        if (AutoSetenable == true) {
            try {
                VLagger.AutoSetServer();
            } catch (IOException | InterruptedException e) {
            }
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
        Bukkit.getPluginManager().registerEvents(new AutoSave(), this);
        Bukkit.getPluginManager().registerEvents(new AntiSkullCrash(), this);
        Bukkit.getPluginManager().registerEvents(new NoDoubleOnline(), this);
        Bukkit.getPluginManager().registerEvents(new NoEggChangeSpawner(), this);
        Bukkit.getPluginManager().registerEvents(new AntiDropInfItem(), this);
        Bukkit.getPluginManager().registerEvents(new AntiDoorInfItem(), this);
        Bukkit.getPluginManager().registerEvents(new TeleportPreloader(), this);
        Bukkit.getPluginManager().registerEvents(new AntiBedExplode(), this);
        Bukkit.getPluginManager().registerEvents(new BlockCommander(), this);
        Bukkit.getPluginManager().registerEvents(new AutoRespawn(), this);
        Bukkit.getPluginManager().registerEvents(new WaterFlowLimitor(), this);
        Bukkit.getPluginManager().registerEvents(new FireLimitor(), this);
        Bukkit.getPluginManager().registerEvents(new AutoUpdateCheck(), this);
        Bukkit.getPluginManager().registerEvents(new NoOneRestart(), this);
        Bukkit.getPluginManager().registerEvents(new FarmProtecter(), this);
        Bukkit.getPluginManager().registerEvents(new Utils(), this);
        Bukkit.getPluginManager().registerEvents(new AntiBoneBug(), this);
        NoExplodeofBlock.RegisterEvents();

        ChunkKeeper.ChunkKeeperofTask();
        Bukkit.getScheduler().runTaskTimer(this, new TilesClear(), TilesClearInterval * 20, TilesClearInterval * 20);
        getServer().getScheduler().runTaskTimer(this, new ChunkUnloader(), 0, ChunkUnloaderInterval * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new HeapShut(), 1 * 60 * 20, 1 * 60 * 20);
        Bukkit.getScheduler().runTaskTimer(this, new HeapClear(), HeapClearPeriod * 20, HeapClearPeriod * 20);
        Bukkit.getScheduler().runTaskAsynchronously(this, new NetWorker());
        Bukkit.getScheduler().runTaskTimer(this, new AntiFakeDeath(), 7 * 20, 7 * 20);
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
                if (args[0].equalsIgnoreCase("updateon")) {
                    FileConfiguration MainConfig = load(MainConfigFile);
                    MainConfig.set("AutoUpdate", true);
                    try {
                        MainConfig.save(MainConfigFile);
                    } catch (IOException ex) {
                    }
                    AutoUpdate = true;
                    sender.sendMessage("§a§l[VLagger]§b已经成功开启自动更新！");
                }
                if (args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage("§e/vlg reload 重载插件");
                    sender.sendMessage("§e/vlg chunkkeeper 查看关于区块保持者的帮助");
                    sender.sendMessage("§e/vlg heap 查阅关于内存清理和分配的内容");
                    sender.sendMessage("§e/vlg autosave 查阅关于自动储存的内容");
                    sender.sendMessage("§e/vlg tpssleep 查阅关于主线程停顿");
                    sender.sendMessage("§e/vlg autoset 查阅关于自动配端");
                    sender.sendMessage("§e/vlg antiattack 查阅关于反压测模块");
                }
                if (args[0].equalsIgnoreCase("antiattack")) {
                    if (args.length == 1) {
                        sender.sendMessage("§a后置参数:");
                        sender.sendMessage("§edownload 下载反压测模块");
                        return true;
                    }
                    if (args[1].equalsIgnoreCase("download")) {
                        sender.sendMessage("§e操作开始执行中...");
                        Bukkit.getScheduler().runTaskAsynchronously(this, new Runnable() {
                            @Override
                            public void run() {
                                NetWorker.DownloadAntiAttack();
                            }
                        });
                    }
                }
                if (args[0].equalsIgnoreCase("autoset")) {
                    if (args.length == 1) {
                        sender.sendMessage("§a后置参数:");
                        sender.sendMessage("§eset 执行一次配端操作");
                        return true;
                    }
                    if (args[1].equalsIgnoreCase("set")) {
                        try {
                            VLagger.AutoSetServer();
                        } catch (IOException | InterruptedException e) {
                        }
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
                        sender.sendMessage("§eheapshut 执行一次濒临崩溃内存检测");
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
                    if (args[1].equalsIgnoreCase("heapshut")) {
                        getServer().getScheduler().runTask(this, new HeapShut());
                        sender.sendMessage("§6成功检测一次内存濒临重启！");
                    }
                    if (args[1].equalsIgnoreCase("chunkunloadlog")) {
                        sender.sendMessage("§a截止到目前，插件已经卸载了" + ChunkUnloader.ChunkUnloaderTimes + "个无用区块");
                    }
                }
                if (args[0].equalsIgnoreCase("autosave")) {
                    if (args.length == 1) {
                        sender.sendMessage("§a后置参数:");
                        sender.sendMessage("§esavethis 将自己所在区块存储");
                        return true;
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
                    LoadConfig();
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

    private void LoadConfig() {
        this.saveResource("说明文档.txt", true);
        FileConfiguration MainConfig = load(MainConfigFile);
        if (MainConfig.getInt("Version") < 272) {
            MainConfig.set("Version", 272);
            MainConfig.set("PluginPrefix", "§a§l[Vlagger]");
            MainConfig.set("AutoUpdate", false);
        }
        PluginPrefix = MainConfig.getString("PluginPrefix");
        AutoUpdate = MainConfig.getBoolean("AutoUpdate");
        try {
            MainConfig.save(MainConfigFile);
        } catch (IOException ex) {
        }

        FileConfiguration ClearLagConfig = load(ClearLagConfigFile);
        if (ClearLagConfig.getInt("Version") < 272) {
            ClearLagConfig.set("Version", 272);
            ClearLagConfig.set("HeapShut.enable", true);
            ClearLagConfig.set("HeapShut.Percent", 90);
            ClearLagConfig.set("HeapShut.WarnMessage", "服务器会在15秒后重启，请玩家不要游戏，耐心等待！ ╮(╯_╰)╭");
            ClearLagConfig.set("HeapShut.WaitingTime", 15);
            ClearLagConfig.set("AutoSet.enable", true);
            ClearLagConfig.set("AutoSave.enable", true);
            ClearLagConfig.set("AutoSave.Interval", 15);
            ClearLagConfig.set("ClearItem.enable", true);
            ClearLagConfig.set("ClearItem.NoCleatDeath", true);
            ClearLagConfig.set("ClearItem.NoClearTeleport", true);
            List<String> MeterialList = new ArrayList<String>();
            MeterialList.add("DIAMOND");
            MeterialList.add("DIAMOND_SWORD");
            ClearLagConfig.set("ClearItem.NoClearItemType", MeterialList);
            ClearLagConfig.set("NooneRestart.enable", true);
            ClearLagConfig.set("NooneRestart.TimeLong", 1200);
            ClearLagConfig.set("ChunkKeeper.enable", true);
            ClearLagConfig.set("ChunkUnloader.enable", true);
            ClearLagConfig.set("NoCrowdedEntity.enable", true);
            ClearLagConfig.set("NoCrowdedEntity.PerChunkLimit", 30);
            List<String> entt = new ArrayList<String>();
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
            ClearLagConfig.set("WaterFlowLimitor.enable", true);
            ClearLagConfig.set("WaterFlowLimitor.Period", 200L);
            ClearLagConfig.set("FireLimitor.enable", true);
            ClearLagConfig.set("FireLimitor.Period", 3000L);
            ClearLagConfig.set("WorldSpawnLimitor.worldname.enable", true);
            ClearLagConfig.set("WorldSpawnLimitor.worldname.PerChunkMonsters", 3);
            ClearLagConfig.set("WorldSpawnLimitor.worldname.PerChunkAnimals", 3);
            ClearLagConfig.set("WorldSpawnLimitor.worldname.PerChunkAmbient", 10);
        }
        if(ClearLagConfig.getInt("Version") < 278){
            ClearLagConfig.set("Version", 278);
            List<String> mas = new ArrayList<String>();
            mas.add("REDSTONE_WIRE");
            mas.add("DIODE_BLOCK_ON");
            mas.add("DIODE_BLOCK_OFF");
            mas.add("REDSTONE_TORCH_ON");
            mas.add("REDSTONE_TORCH_OFF");
            mas.add("REDSTONE_BLOCK");
            ClearLagConfig.set("AntiRedstone.RemoveBlockList", mas);
        }
        AntiRedstoneRemoveBlockList = ClearLagConfig.getStringList("AntiRedstone.RemoveBlockList");
        ClearItemNoClearItemType = ClearLagConfig.getStringList("ClearItem.NoClearItemTypeClearItem.NoClearItemType");
        ClearItemNoCleatDeath = ClearLagConfig.getBoolean("ClearItem.NoCleatDeath");
        ClearItemNoClearTeleport = ClearLagConfig.getBoolean("ClearItem.NoClearTeleport");
        HeapShutenable = ClearLagConfig.getBoolean("HeapShut.enable");
        HeapShutPercent = ClearLagConfig.getInt("HeapShut.Percent");
        HeapShutWarnMessage = ClearLagConfig.getString("HeapShut.WarnMessage");
        HeapShutWaitingTime = ClearLagConfig.getInt("HeapShut.WaitingTime");
        AutoSetenable = ClearLagConfig.getBoolean("AutoSet.enable");
        AutoSaveenable = ClearLagConfig.getBoolean("AutoSave.enable");
        AutoSaveInterval = ClearLagConfig.getInt("AutoSave.Interval");
        ClearItemenable = ClearLagConfig.getBoolean("ClearItem.enable");
        NooneRestartenable = ClearLagConfig.getBoolean("NooneRestart.enable");
        NooneRestartTimeLong = ClearLagConfig.getInt("NooneRestart.TimeLong");
        ChunkKeeperenable = ClearLagConfig.getBoolean("ChunkKeeper.enable");
        ChunkUnloaderenable = ClearLagConfig.getBoolean("ChunkUnloader.enable");
        NoCrowdedEntityenable = ClearLagConfig.getBoolean("NoCrowdedEntity.enable");
        NoCrowdedEntityPerChunkLimit = ClearLagConfig.getInt("NoCrowdedEntity.PerChunkLimit");
        List<String> NoCrowdedEntityTypeStringList = ClearLagConfig.getStringList("NoCrowdedEntity.TypeList");
        for (int i = 0; i < NoCrowdedEntityTypeStringList.size(); i++) {
            @SuppressWarnings("deprecation")
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
        WaterFlowLimitorenable = ClearLagConfig.getBoolean("WaterFlowLimitor.enable");
        WaterFlowLimitorPeriod = ClearLagConfig.getLong("WaterFlowLimitor.Period");
        FireLimitorenable = ClearLagConfig.getBoolean("FireLimitor.enable");
        FireLimitorPeriod = ClearLagConfig.getLong("FireLimitor.Period");
        try {
            ClearLagConfig.save(ClearLagConfigFile);
        } catch (IOException ex) {
        }

        FileConfiguration NoBugConfig = load(NoBugConfigFile);
        if (NoBugConfig.getInt("Version") < 272) {
            NoBugConfig.set("Version", 272);
            NoBugConfig.set("AntiInfItem.enable", true);
            NoBugConfig.set("AntiInfItem.ClickcWarnMessage", "§c警告！不允许使用负数物品！");
            NoBugConfig.set("AntiInfItem.BlockcWarnMessage", "§c在  §b%block% §c发现一个负数物品的发射器！内部负数物品已经移除！");
            NoBugConfig.set("AntiPortalInfItem.enable", true);
            NoBugConfig.set("AntiPortalInfItem.WarnMessage", "§c抱歉！禁止矿车通过地狱门防止作弊！");
            NoBugConfig.set("AntiNetherHopperInfItem.enable", true);
            NoBugConfig.set("AntiRPGITEM.enable", true);
            NoBugConfig.set("AntiCrashSign.enable", true);
            NoBugConfig.set("AntiCrashSign.WarnMessage", "§c您输入的内容太长了！");
            NoBugConfig.set("AntiSkullCrash.enable", true);
            NoBugConfig.set("NoDoubleOnline.enable", true);
            NoBugConfig.set("NoDoubleOnline.KickMessage", "抱歉，服务器中您已经在线了。ԅ(¯ㅂ¯ԅ)");
            NoBugConfig.set("AntiDropInfItem.enable", true);
            NoBugConfig.set("AntiDoorInfItem.enable", true);
            NoBugConfig.set("AntiCheatBook.enable", true);
            NoBugConfig.set("AntiCheatBook.WarnMessage", "§c严禁利用超级书Bug！");
            NoBugConfig.set("AntiBedExplode.enable", true);
            NoBugConfig.set("AntiBedExplode.TipMessage", "§r你不能在这里睡觉");
            NoBugConfig.set("AntiBreakUseingChest.enable", true);
            NoBugConfig.set("AntiBreakUseingChest.WarnMessage", "§c抱歉！您不可以破坏一个正在被使用的容器");
            NoBugConfig.set("AntiInfRail.enable", true);
            NoBugConfig.set("AntiCrashChat.enable", true);
            NoBugConfig.set("AntiCrashChat.SpecialStringWarnMessage", "§c严禁使用崩服代码炸服！");
            NoBugConfig.set("AntiCrashChat.ColorChatWarnMessage", "§c抱歉！为了防止服务器被破坏，服务器禁止使用颜色代码.");
            NoBugConfig.set("AntiFakeDeath.enable", true);
            NoBugConfig.set("AntiFakeDeath.KickMessage", "§c严禁卡假死BUG！");
        }
        if(NoBugConfig.getInt("Version") < 277){
            NoBugConfig.set("Version", 277);
            NoBugConfig.set("AntiBoneBug.enable", true);
            NoBugConfig.set("AntiBoneBug.WarnMessage", "§c严禁卡树苗催熟BUG！");
        }
        AntiBoneBugenable = NoBugConfig.getBoolean("AntiBoneBug.enable");
        AntiBoneBugWarnMessage = NoBugConfig.getString("AntiBoneBug.WarnMessage");
        AntiFakeDeathenable = NoBugConfig.getBoolean("AntiFakeDeath.enable");
        AntiFakeDeathKickMessage = NoBugConfig.getString("AntiFakeDeath.KickMessage");
        AntiCrashChatenable = NoBugConfig.getBoolean("AntiCrashChat.enable");
        AntiCrashChatSpecialStringWarnMessage = NoBugConfig.getString("AntiCrashChat.SpecialStringWarnMessage");
        AntiCrashChatColorChatWarnMessage = NoBugConfig.getString("AntiCrashChat.ColorChatWarnMessage");
        AntiBreakUseingChestWarnMessage = NoBugConfig.getString("AntiBreakUseingChest.WarnMessage");
        AntiBedExplodeTipMessage = NoBugConfig.getString("AntiBedExplode.TipMessage");
        AntiCrashSignWarnMessage = NoBugConfig.getString("AntiCrashSign.WarnMessage");
        AntiPortalInfItemWarnMessage = NoBugConfig.getString("AntiPortalInfItem.WarnMessage");
        AntiInfItemClickcWarnMessage = NoBugConfig.getString("AntiInfItem.ClickcWarnMessage");
        AntiInfItemBlockcWarnMessage = NoBugConfig.getString("AntiInfItem.BlockcWarnMessage");
        AntiInfItemenable = NoBugConfig.getBoolean("AntiInfItem.enable");
        AntiPortalInfItemenable = NoBugConfig.getBoolean("AntiPortalInfItem.enable");
        AntiNetherHopperInfItemenable = NoBugConfig.getBoolean("AntiNetherHopperInfItem.enable");
        AntiRPGITEMenable = NoBugConfig.getBoolean("AntiRPGITEM.enable");
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
        try {
            NoBugConfig.save(NoBugConfigFile);
        } catch (IOException ex) {
        }

        FileConfiguration EventConfig = load(EventConfigFile);
        if (EventConfig.getInt("Version") < 272) {
            EventConfig.set("Version", 272);
            EventConfig.set("AntiSpam.enable", true);
            EventConfig.set("AntiSpam.Period.Period", 2F);
            EventConfig.set("AntiSpam.Period.WarnMessage", "§c请慢点说话，别激动嘛！ _(:з」∠)_");
            List<String> dirty = new ArrayList<String>();
            dirty.add("操你妈");
            dirty.add("妈逼");
            dirty.add("SB");
            dirty.add("弱智");
            dirty.add("智障");
            dirty.add("杂种");
            dirty.add("狗娘");
            EventConfig.set("AntiSpam.Dirty.List", dirty);
            EventConfig.set("AntiSpam.Dirty.WarnMessage", "§c啥事那么大搞得你想骂人啊~ _(:з」∠)_");
            EventConfig.set("NoEggChangeSpawner.enable", true);
            EventConfig.set("NoEggChangeSpawner.TipMessage", "§c抱歉，禁止使用刷怪蛋修改刷怪笼");
            EventConfig.set("BlockCommander.enable", false);
            EventConfig.set("BlockCommander.NoColonTip", "§r您不可以用冒号代替插件来执行指令！");
            EventConfig.set("BlockCommander.List.NoSpawnWorld./spawn", true);
            EventConfig.set("BlockCommander.List.NoSpawnWorld./spawn.Message", "想在这个世界回城？没门！");
            EventConfig.set("BlockCommander.List.worldname./back", true);
            EventConfig.set("BlockCommander.List.worldname./back.Message", "不好使，不可以用back!");
            EventConfig.set("BlockCommander.List.worldname./tpa", true);
            EventConfig.set("BlockCommander.List.worldname./tpa.Message", "WIFI没信号，不能传送。");
            EventConfig.set("AutoRespawn.enable", true);
            EventConfig.set("AutoRespawn.RespawnTitle.enable", true);
            EventConfig.set("AutoRespawn.RespawnTitle.MainMessage", "§e你死了！");
            EventConfig.set("AutoRespawn.RespawnTitle.MiniMessage", "§c已为您自动复活！");
            EventConfig.set("ProtectFarm.enable", true);
        }
        ProtectFarmenable = EventConfig.getBoolean("ProtectFarm.enable");
        AntiSpamDirtyWarnMessage = EventConfig.getString("AntiSpam.Dirty.WarnMessage");
        AntiSpamDirtyList = EventConfig.getStringList("AntiSpam.Dirty.List");
        NoEggChangeSpawnerTipMessage = EventConfig.getString("NoEggChangeSpawner.TipMessage");
        BlockCommanderNoColonTip = EventConfig.getString("BlockCommander.NoColonTip");
        AntiSpamenable = EventConfig.getBoolean("AntiSpam.enable");
        AntiSpamPeriodPeriod = EventConfig.getLong("AntiSpam.Period.Period");
        AntiSpamPeriodWarnMessage = EventConfig.getString("AntiSpam.Period.WarnMessage");
        NoEggChangeSpawnerenable = EventConfig.getBoolean("NoEggChangeSpawner");
        BlockCommanderenable = EventConfig.getBoolean("BlockCommander.enable");
        AutoRespawnenable = EventConfig.getBoolean("AutoRespawn.enable");
        AutoRespawnRespawnTitleenable = EventConfig.getBoolean("AutoRespawn.RespawnTitle.enable");
        AutoRespawnRespawnTitleMainMessage = EventConfig.getString("AutoRespawn.RespawnTitle.MainMessage");
        AutoRespawnRespawnTitleMiniMessage = EventConfig.getString("AutoRespawn.RespawnTitle.MiniMessage");
        try {
            EventConfig.save(EventConfigFile);
        } catch (IOException ex) {
        }
    }

    private static void AutoSetServer() throws IOException, InterruptedException {
        long heapmb = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        File BukkitFile = new File("bukkit.yml");
        if (BukkitFile.exists()) {
            FileConfiguration bukkit = load(BukkitFile);
            File backupBukkitFile = new File("backup_bukkit.yml");
            if (backupBukkitFile.exists() == false) {
                backupBukkitFile.createNewFile();
                bukkit.save(backupBukkitFile);
            }
            if (heapmb <= 6000) {
                bukkit.set("chunk-gc.period-in-ticks", 300);
            } else {
                bukkit.set("chunk-gc.period-in-ticks", 500);
            }
            bukkit.set("chunk-gc.load-threshold", 400);
            if (heapmb <= 6000) {
                bukkit.set("ticks-per.monster-spawns", 3);
            }
            bukkit.set("VLagger.Changed", "如果Config的AutoSet开启，该参数会被改变。");
            bukkit.save(BukkitFile);
        }
        File SpigotFile = new File("spigot.yml");
        if (SpigotFile.exists()) {
            FileConfiguration spigot = load(SpigotFile);
            File backupSpigotFile = new File("backup_spigot.yml");
            if (backupSpigotFile.exists() == false) {
                backupSpigotFile.createNewFile();
                spigot.save(backupSpigotFile);
            }
            if (heapmb <= 2000) {
                spigot.set("settings.save-user-cache-on-stop-only", true);
            }
            if (heapmb >= 6000) {
                spigot.set("settings.user-cache-size", 5000);
            }
            if (heapmb >= 10000) {
                spigot.set("world-settings.default.view-distance", 4);
            } else if (heapmb >= 6000) {
                spigot.set("world-settings.default.view-distance", 3);
            } else {
                spigot.set("world-settings.default.view-distance", 2);
            }
            if (heapmb <= 4000) {
                spigot.set("world-settings.default.chunks-per-tick", 150);
            } else {
                spigot.set("world-settings.default.chunks-per-tick", 350);
            }
            if (heapmb <= 4000) {
                spigot.set("world-settings.default.max-tick-time.tile", 10);
                spigot.set("world-settings.default.max-tick-time.entity", 20);
            } else {
                spigot.set("world-settings.default.max-tick-time.tile", 20);
                spigot.set("world-settings.default.max-tick-time.entity", 30);
            }
            spigot.set("world-settings.default.entity-activation-range.animals", 12);
            spigot.set("world-settings.default.entity-activation-range.monsters", 24);
            spigot.set("world-settings.default.entity-activation-range.misc", 2);
            spigot.set("world-settings.default.entity-tracking-range.other", 48);
            spigot.set("world-settings.default.random-light-updates", false);
            if (heapmb <= 4000) {
                spigot.set("world-settings.default.save-structure-info", false);
            }
            spigot.set("world-settings.default.max-entity-collisions", 2);
            spigot.set("world-settings.default.max-tnt-per-tick", 20);
            spigot.set("VLagger.Changed", "如果Config的AutoSet开启，该参数会被改变。");
            spigot.save(SpigotFile);
        }
        File PaperFile = new File("paper.yml");
        if (PaperFile.exists()) {
            FileConfiguration paper = load(PaperFile);
            File backupPaperFile = new File("backup_paper.yml");
            if (backupPaperFile.exists() == false) {
                backupPaperFile.createNewFile();
                paper.save(backupPaperFile);
            }
            paper.set("world-settings.default.keep-spawn-loaded", false);
            paper.set("world-settings.default.optimize-explosions", true);
            paper.set("world-settings.default.fast-drain.lava", true);
            paper.set("world-settings.default.fast-drain.water", true);
            paper.set("world-settings.default.use-async-lighting", true);
            if (heapmb <= 6000) {
                paper.set("world-settings.default.tick-next-tick-list-cap", 8000);
            }
            paper.set("world-settings.default.tick-next-tick-list-cap-ignores-redstone", true);
            paper.save(PaperFile);
        }
        if (BukkitFile.exists()) {
            FileConfiguration bukkit = load(BukkitFile);
            if (bukkit.getInt("VLagger.SetStep") == 1) {
                bukkit.set("VLagger.SetStep", 2);
                try {
                    bukkit.save(BukkitFile);
                } catch (IOException ex) {
                }
            }
            if (bukkit.getInt("VLagger.SetStep") == 0) {
                bukkit.set("VLagger.SetStep", 1);
                bukkit.save(BukkitFile);
                MainThis.getLogger().info("成功改动服务器配端，正在重启来启用它.");
                Thread.sleep(4000);
                Bukkit.shutdown();
            }
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
        getLogger().info("VLagger —— 已经停止使用");
        getLogger().info("感谢您的使用——乐乐");
    }
}
