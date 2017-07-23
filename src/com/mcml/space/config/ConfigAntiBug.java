package com.mcml.space.config;

import com.mcml.space.util.Configurable;

public abstract class ConfigAntiBug extends Configurable {
    @Node(path = "AntiBoneBug.enable") // issue-fixer.bonemeal-inf-item
    public static boolean safetyBonemeal;
    
    @Locale
    @Node(path = "AntiBoneBug.WarnMessage") 
    public static String AntiBoneBugWarnMessage = "§c严禁卡树苗催熟BUG！";
    
    @Locale
    @Node(path = "AntiFakeDeath.KickMessage")
    public static String AntiFakeDeathKickMessage = "§c严禁卡假死BUG！";
    
    @Node(path = "AntiFakeDeath.enable")
    public static boolean AntiFakeDeathenable;
    
    @Node(path = "NoDoubleOnline.enable")
    public static boolean NoDoubleOnlineenable;
    
    @Locale
    @Node(path = "NoDoubleOnline.KickMessage")
    public static String NoDoubleOnlineKickMessage = "抱歉，服务器中您已经在线了。ԅ(¯ㅂ¯ԅ)";
    
    @Locale
    @Node(path = "AntiCheatBook.WarnMessage")
    public static String AntiCheatBookWarnMessage = "§c严禁利用超级书Bug！";
    
    @Node(path = "AntiBedExplode.enable")
    public static boolean AntiBedExplodeenable;
    
    @Node(path = "AntiBreakUseingChest.enable")
    public static boolean AntiBreakUseingChestenable;
    
    @Node(path = "AntiCheatBook.enable")
    public static boolean AntiCheatBookenable;
    
    @Node(path = "AntiCrashSign.enable")
    public static boolean AntiCrashSignenable;
    
    @Node(path = "AntiDoorInfItem.enable")
    public static boolean AntiDoorInfItemenable;
    
    @Node(path = "AntiDupeDropItem.enable")
    public static boolean AntiDupeDropItemenable;
    
    @Node(path = "AntiInfItem.enable")
    public static boolean AntiInfItemenable;
    
    @Node(path = "AntiInfRail.enable")
    public static boolean AntiInfRailenable;
    
    @Node(path = "AntiNetherHopperInfItem.enable")
    public static boolean AntiNetherHopperInfItemenable;
    
    @Node(path = "AntiPortalInfItem.enable")
    public static boolean AntiPortalInfItemenable;
    
    @Node(path = "AntiRPGITEM.enable")
    public static boolean AntiRPGITEMenable;
    
    @Node(path = "AntiSkullCrash.enable")
    public static boolean AntiSkullCrashenable;
    
    @Node(path = "AntiCrashChat.enable")
    public static boolean AntiCrashChatenable;
    
    @Locale
    @Node(path = "AntiCrashChat.SpecialStringWarnMessage")
    public static String AntiCrashChatSpecialStringWarnMessage = "§c严禁使用崩服代码炸服！";
    
    @Locale
    @Node(path = "AntiCrashChat.ColorChatWarnMessage")
    public static String AntiCrashChatColorChatWarnMessage = "§c抱歉！为了防止服务器被破坏，服务器禁止使用颜色代码.";
    
    @Locale
    @Node(path = "AntiBreakUseingChest.WarnMessage")
    public static String AntiBreakUsingChestWarnMessage = "§c抱歉！您不可以破坏一个正在被使用的容器";
    
    @Locale
    @Node(path = "AntiBedExplode.TipMessage")
    public static String AntiBedExplodeTipMessage = "§r你不能在这里睡觉";
    
    @Locale
    @Node(path = "AntiCrashSign.WarnMessage")
    public static String AntiCrashSignWarnMessage = "§c您输入的内容太长了！";
    
    @Locale
    @Node(path = "AntiPortalInfItem.WarnMessage")
    public static String AntiPortalInfItemWarnMessage = "§c抱歉！禁止矿车通过地狱门防止作弊！";
    
    @Locale
    @Node(path = "AntiInfItem.ClickcWarnMessage")
    public static String AntiInfItemClickcWarnMessage = "§c警告！不允许使用负数物品！";
    
}
