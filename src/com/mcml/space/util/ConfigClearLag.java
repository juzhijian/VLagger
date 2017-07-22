package com.mcml.space.util;

public abstract class ConfigClearLag extends Configurable {
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
    
    @Node(path = "NooneRestart.TimeLong")
    public static int NooneRestartTimeLong = 1200;
}
