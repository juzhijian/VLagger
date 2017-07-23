package com.mcml.space.config;

import java.util.ArrayList;
import java.util.List;

public class Default {
	
	public static List<String> NoCrowdedEntityTypeList = new ArrayList<String>();
	public static List<String> AntiRedstoneRemoveBlockList = new ArrayList<String>();
	public static List<String> AntiSpamDirtyList = new ArrayList<String>();
	
	public static void Do(){
		NoCrowdedEntityTypeList.add("ZOMBIE");
		NoCrowdedEntityTypeList.add("SKELETON");
		NoCrowdedEntityTypeList.add("SPIDER");
		NoCrowdedEntityTypeList.add("CREEPER");
		NoCrowdedEntityTypeList.add("SHEEP");
		NoCrowdedEntityTypeList.add("PIG");
		NoCrowdedEntityTypeList.add("CHICKEN");
		
        AntiRedstoneRemoveBlockList.add("REDSTONE_WIRE");
        AntiRedstoneRemoveBlockList.add("DIODE_BLOCK_ON");
        AntiRedstoneRemoveBlockList.add("DIODE_BLOCK_OFF");
        AntiRedstoneRemoveBlockList.add("REDSTONE_TORCH_ON");
        AntiRedstoneRemoveBlockList.add("REDSTONE_TORCH_OFF");
        AntiRedstoneRemoveBlockList.add("REDSTONE_BLOCK");
        
        AntiSpamDirtyList.add("操你妈");
        AntiSpamDirtyList.add("妈逼");
        AntiSpamDirtyList.add("SB");
        AntiSpamDirtyList.add("弱智");
        AntiSpamDirtyList.add("智障");
        AntiSpamDirtyList.add("杂种");
        AntiSpamDirtyList.add("狗娘");
	}

}
