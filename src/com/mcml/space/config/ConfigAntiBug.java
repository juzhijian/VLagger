package com.mcml.space.config;

import com.mcml.space.util.Configurable;

public abstract class ConfigAntiBug extends Configurable {
    @Node(path = "AntiBoneBug.enable") // issue-fixer.bonemeal-inf-item
    public static boolean safetyBonemeal;
    
    @Node(path = "AntiBoneBug.WarnMessage") 
    public static String AntiBoneBugWarnMessage = "§c严禁卡树苗催熟BUG！";
    
    @Node(path = "AntiFakeDeath.KickMessage")
    public static String AntiFakeDeathKickMessage = "§c严禁卡假死BUG！";
    
    @Node(path = "AntiFakeDeath.enable")
    public static boolean AntiFakeDeathenable = true;
    
    @Node(path = "NoDoubleOnline.enable")
    public static boolean NoDoubleOnlineenable = true;
    
    @Node(path = "NoDoubleOnline.KickMessage")
    public static String NoDoubleOnlineKickMessage = "抱歉，服务器中您已经在线了。ԅ(¯ㅂ¯ԅ)";
    
    @Node(path = "AntiCheatBook.WarnMessage")
    public static String AntiCheatBookWarnMessage = "§c严禁利用超级书Bug！";
    
    @Node(path = "AntiBedExplode.enable")
    public static boolean AntiBedExplodeenable = true;
    
    @Node(path = "AntiBreakUseingChest.enable")
    public static boolean AntiBreakUseingChestenable = true;
    
    @Node(path = "AntiCheatBook.enable")
    public static boolean AntiCheatBookenable = true;
    
    @Node(path = "AntiCrashSign.enable")
    public static boolean AntiCrashSignenable = true;
    
    @Node(path = "AntiDoorInfItem.enable")
    public static boolean AntiDoorInfItemenable = true;
    
    @Node(path = "AntiDupeDropItem.enable")
    public static boolean AntiDupeDropItemenable = true;
    
    @Node(path = "AntiInfItem.enable")
    public static boolean AntiInfItemenable = true;
    
    @Node(path = "AntiInfRail.enable")
    public static boolean AntiInfRailenable = true;
    
    @Node(path = "AntiNetherHopperInfItem.enable")
    public static boolean AntiNetherHopperInfItemenable = true;
    
    @Node(path = "AntiPortalInfItem.enable")
    public static boolean AntiPortalInfItemenable = true;
    
    @Node(path = "AntiRPGITEM.enable")
    public static boolean AntiRPGITEMenable = true;
    
    @Node(path = "AntiSkullCrash.enable")
    public static boolean AntiSkullCrashenable = true;
    
    @Node(path = "AntiCrashChat.enable")
    public static boolean AntiCrashChatenable = true;
    
    @Node(path = "AntiCrashChat.SpecialStringWarnMessage")
    public static String AntiCrashChatSpecialStringWarnMessage = "§c严禁使用崩服代码炸服！";
    
    @Node(path = "AntiCrashChat.ColorChatWarnMessage")
    public static String AntiCrashChatColorChatWarnMessage = "§c抱歉！为了防止服务器被破坏，服务器禁止使用颜色代码.";
    
    @Node(path = "AntiSpam.Dirty.WarnMessage")
    public static String AntiSpamDirtyWarnMessage = "§c啥事那么大搞得你想骂人啊~ _(:з」∠)_";
    
    @Node(path = "AntiBreakUseingChest.WarnMessage")
    public static String AntiBreakUsingChestWarnMessage = "§c抱歉！您不可以破坏一个正在被使用的容器";
    
    @Node(path = "AntiBedExplode.TipMessage")
    public static String AntiBedExplodeTipMessage = "§r你不能在这里睡觉";
    
    @Node(path = "AntiCrashSign.WarnMessage")
    public static String AntiCrashSignWarnMessage = "§c您输入的内容太长了！";
    
    @Node(path = "AntiPortalInfItem.WarnMessage")
    public static String AntiPortalInfItemWarnMessage = "§c抱歉！禁止矿车通过地狱门防止作弊！";
    
    @Node(path = "AntiInfItem.ClickcWarnMessage")
    public static String AntiInfItemClickcWarnMessage = "§c警告！不允许使用负数物品！";
    
}
