package com.mcml.space.config;

import java.util.ArrayList;
import java.util.List;

import com.mcml.space.util.AzureAPI;
import com.mcml.space.util.Configurable;

public abstract class ConfigFunction extends Configurable {
    
    @Node(path = "AntiSpam.enable")
    public static boolean AntiSpamenable = true;
    
    @Node(path = "AntiSpam.Period.Period")
    public static long AntiSpamPeriodPeriod = 2;
    
    @Locale
    @Node(path = "AntiSpam.Period.WarnMessage")
    public static String AntiSpamPeriodWarnMessage = "§c请慢点说话，别激动嘛！ _(:з」∠)_";
    
    @Node(path = "AntiSpam.Dirty.List")
    public static List<String> AntiSpamDirtyList = AzureAPI.newChainStringList().to("傻逼").to("智障").to("SB");
    
    @Node(path = "NoEggChangeSpawner.enable")
    public static boolean NoEggChangeSpawnerenable = true;
    
    @Locale
    @Node(path = "NoEggChangeSpawner.TipMessage")
    public static String NoEggChangeSpawnerTipMessage = "&c抱歉，禁止使用刷怪蛋修改刷怪笼";
    
    public static List<String[]> AntiSpamDirtyListStrings(){
    	List<String[]> DirtyListStrings = new ArrayList<String[]>();
    	List<String> DirtyList = ConfigFunction.AntiSpamDirtyList;
        int ds = DirtyList.size();
        for(int i=0;i<ds;i++){
        	String thisdirty = DirtyList.get(i);
        	int tdl = thisdirty.length();
        	String[] thisdirtystrings = new String[tdl];
        	for(int ii = 0;ii<tdl;ii++){
        		thisdirtystrings[ii] = thisdirty.substring(ii,ii+1);
        	}
        	DirtyListStrings.add(thisdirtystrings);
        }
        return DirtyListStrings;
    }
    
    @Node(path ="BlockCommander.enable")
    public static boolean BlockCommanderenable = true;
    
    @Node(path = "ProtectFarm.enable")
    public static boolean ProtectFarmenable = true;
    
    @Locale
    @Node(path = "AntiSpam.Dirty.WarnMessage")
    public static String AntiSpamDirtyWarnMessage = "§c什么事情激动得你都想骂人啦？";
    
    @Node(path = "AutoRespawn.enable")
    public static boolean canAutoRespawn = false;
    
    @Node(path = "AutoRespawn.RespawnTitle.enable")
    public static boolean sendTitleOnRespawn = false;
    
    @Locale
    @Node(path = "AutoRespawn.RespawnTitle.MainMessage")
    public static String AutoRespawnRespawnTitleMainMessage = "§e你死了！";
    
    @Locale
    @Node(path = "AutoRespawn.RespawnTitle.MiniMessage")
    public static String AutoRespawnRespawnTitleMiniMessage = "§c已为您自动复活！";
    
    @Node(path = "NoExplode.enable")
    public static boolean controlExplode = true;
    
    @Node(path = "NoExplode.Type")
    public static String explodeControlType = "NoBlockBreak";
}
