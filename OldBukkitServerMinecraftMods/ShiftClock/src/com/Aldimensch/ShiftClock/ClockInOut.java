package com.Aldimensch.ShiftClock;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;


public class ClockInOut {
	
	public static ShiftClock plugin;
	public ClockInOut(ShiftClock instance) {
		plugin = instance;
	}
	
	
	public static void ClockIn(Player player) {
		if(!player.hasMetadata("SCheck")){
			player.setMetadata("SCheck", new FixedMetadataValue(plugin, (System.currentTimeMillis()/1000/60)));
		}
	}
	
	public static void ClockOut(Player player) {
		if(player.hasMetadata("SCheck")){
			int timeIn = player.getMetadata("SCheck").get(0).asInt();
			int timeOut = ((int)(System.currentTimeMillis()/1000/60));
			int timeTotal = (timeOut - timeIn);
			
			player.sendMessage("You was "+ timeTotal +" min. Checked In!");
		}
	}
	
}
