package com.mcml.space.config;

import java.util.List;

import com.google.common.collect.Lists;
import com.mcml.space.util.Configurable;

public abstract class ConfigClearLag extends Configurable {
    @Node(path = "HeapShut.enable")
    public static boolean HeapShutenable;
    
    @Node(path = "ChunkUnloader.Interval")
    public static long ChunkUnloaderInterval = 30;
    
    @Node(path = "WaterFlowLimitor.enable")
    public static boolean WaterFlowLimitorenable;
    
    @Node(path = "WaterFlowLimitor.Period")
    public static long WaterFlowLimitorPeriod = 200L;
    
    @Node(path = "AntiRedstone.enable")
    public static boolean AntiRedstoneenable;
    
    @Node(path = "NoExplode.enable")
    public static boolean NoExplodeenable;
    
    @Node(path = "NoExplode.Type")
    public static String NoExplodeType = "NoBlockBreak";
    
    @Node(path = "AntiRedstone.Interval")
    public static long AntiRedstoneInterval = 500L;
    
    @Node(path = "FireLimitor.enable")
    public static boolean FireLimitorenable;
    
    @Node(path = "FireLimitor.Period")
    public static long FireLimitorPeriod = 3000L;
    
    @Node(path = "HeapClear.enable")
    public static boolean HeapClearenable = false;
    
    @Node(path = "TeleportPreLoader.enable")
    public static boolean TeleportPreLoaderenable;
    
    @Locale
    @Node(path = "HeapClear.Message")
    public static String HeapClearMessage = "§e服务器清理内存中... ԅ(¯ㅂ¯ԅ)";
    
    @Node(path = "HeapClear.Period")
    public static long HeapClearPeriod = 600;
    
    @Node(path = "ClearItem.NoClearItemType")
    public static List<String> ClearItemNoClearItemType = Lists.newArrayList();

    @Node(path = "ClearItem.NoCleatDeath")
    public static boolean ClearItemNoCleatDeath;
    
    @Node(path = "ClearItem.NoClearTeleport")
    public static boolean ClearItemNoClearTeleport;
    
    @Node(path = "NoCrowdedEntity.enable")
    public static boolean NoCrowdedEntityenable;
    
    @Node(path = "NoCrowdedEntity.TypeList")
    public static List<String> NoCrowdedEntityTypeList = Default.NoCrowdedEntityTypeList;
    
    @Node(path = "NoCrowdedEntity.PerChunkLimit")
    public static int NoCrowdedEntityPerChunkLimit = 30;
    
    @Locale
    @Node(path = "AntiRedstone.Message")
    public static String AntiRedstoneMessage = "§c检测到高频红石在 %location% ，插件已经将其清除，不许玩了！ (╰_╯)#";
    
    @Node(path = "HeapShut.Percent")
    public static int HeapShutPercent = 90;
    
    @Node(path = "AntiRedstone.RemoveBlockList")
    public static List<String> AntiRedstoneRemoveBlockList = Default.AntiRedstoneRemoveBlockList;
    
    @Node(path = "AutoSave.Interval")
    public static long AutoSaveInterval = 15;
    
    @Locale
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
    
    @Node(path = "NooneRestart.TimeLong")
    public static int NooneRestartTimeLong = 1200;
}
