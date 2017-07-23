package com.mcml.space.config;

import java.util.ArrayList;
import java.util.List;

import com.mcml.space.util.Configurable;

public abstract class ConfigDoEvent extends Configurable {
    @Node(path = "AntiSpam.enable")
    public static boolean AntiSpamenable;
    
    @Node(path = "AntiSpam.Period.Period")
    public static long AntiSpamPeriodPeriod;
    
    @Node(path = "AntiSpam.Period.WarnMessage")
    public static String AntiSpamPeriodWarnMessage;
    
    @Node(path = "AntiSpam.Dirty.List")
    public static List<String> AntiSpamDirtyList;
    
    @Node(path = "NoEggChangeSpawner.enable")
    public static boolean NoEggChangeSpawnerenable;
    
    @Node(path = "NoEggChangeSpawner.TipMessage")
    public static String NoEggChangeSpawnerTipMessage;
    
    public static List<String[]> AntiSpamDirtyListStrings(){
    	List<String[]> DirtyListStrings = new ArrayList<String[]>();
    	List<String> DirtyList = ConfigDoEvent.AntiSpamDirtyList;
        int ds = DirtyList.size();
        for(int i=0;i<ds;i++){
        	String thisdirty = DirtyList.get(i);
        	int tdl = thisdirty.length();
        	String[] thisdirtystrings = new String[tdl + 1];
        	for(int ii = 0;ii<tdl;ii++){
        		thisdirtystrings[ii] = thisdirty.substring(ii,ii+1);
        	}
        	DirtyListStrings.add(thisdirtystrings);
        }
        return DirtyListStrings;
    }
    
    @Node(path ="BlockCommander.enable")
    public static boolean BlockCommanderenable;
    
    @Node(path = "ProtectFarm.enable")
    public static boolean ProtectFarmenable;
    
    @Node(path = "AntiSpam.Dirty.WarnMessage")
    public static String AntiSpamDirtyWarnMessage = "§c什么事情激动得你都想骂人啦？";
    
    @Node(path = "AutoRespawn.enable")
    public static boolean AutoRespawnenable;
    
    @Node(path = "AutoRespawn.RespawnTitle.enable")
    public static boolean AutoRespawnRespawnTitleenable;
    
    @Node(path = "AutoRespawn.RespawnTitle.MainMessage")
    public static String AutoRespawnRespawnTitleMainMessage;
    
    @Node(path = "AutoRespawn.RespawnTitle.MiniMessage")
    public static String AutoRespawnRespawnTitleMiniMessage;
}
