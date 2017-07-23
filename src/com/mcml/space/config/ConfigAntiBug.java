package com.mcml.space.config;

import com.mcml.space.util.Configurable;

public abstract class ConfigAntiBug extends Configurable {
    @Node(path = "AntiBoneBug.enable") // issue-fixer.bonemeal-inf-item
    public static boolean safetyBonemeal;
    
    @Locale
    @Node(path = "AntiBoneBug.WarnMessage") 
    public static String messageBonemeal = "§c严禁卡树苗催熟BUG！";
    
    @Locale
    @Node(path = "AntiFakeDeath.KickMessage")
    public static String messageFakedeath = "§c严禁卡假死BUG！";
    
    @Node(path = "AntiFakeDeath.enable")
    public static boolean noFakedeath;
    
    @Node(path = "NoDoubleOnline.enable")
    public static boolean NoDoubleOnlineenable;
    
    @Locale
    @Node(path = "NoDoubleOnline.KickMessage")
    public static String messageKickDupeOnline = "抱歉，服务器中您已经在线了。ԅ(¯ㅂ¯ԅ)";
    
    @Locale
    @Node(path = "AntiCheatBook.WarnMessage")
    public static String messageCheatBook = "§c严禁利用超级书Bug！";
    
    @Node(path = "AntiBedExplode.enable")
    public static boolean noBedExplore;
    
    @Node(path = "AntiBreakUseingChest.enable")
    public static boolean protectUsingChest;
    
    @Node(path = "AntiCheatBook.enable")
    public static boolean noCheatBook;
    
    @Node(path = "AntiCrashSign.enable")
    public static boolean fixCrashSign;
    
    @Node(path = "AntiDoorInfItem.enable")
    public static boolean fixDoorInfItem;
    
    @Node(path = "AntiDupeDropItem.enable")
    public static boolean fixDupeDropItem;
    
    @Node(path = "AntiInfItem.enable")
    public static boolean noInfItem;
    
    @Node(path = "AntiInfRail.enable")
    public static boolean fixInfRail;
    
    @Node(path = "AntiNetherHopperInfItem.enable")
    public static boolean fixNetherHopperInfItem;
    
    @Node(path = "AntiPortalInfItem.enable")
    public static boolean fixPortalInfItem;
    
    @Node(path = "AntiRPGITEM.enable")
    public static boolean fixRpgItemInfItem;
    
    @Node(path = "AntiSkullCrash.enable")
    public static boolean noSkullCrash;
    
    @Node(path = "AntiCrashChat.enable")
    public static boolean noCrashChat;
    
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
