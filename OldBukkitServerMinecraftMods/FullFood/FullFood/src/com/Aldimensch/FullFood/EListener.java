package com.Aldimensch.FullFood;


import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;



public class EListener implements Listener{
		
	public static FullFood plugin;
	public EListener(FullFood instance) {
		plugin = instance;
	}
	

	@EventHandler
	public void onFoodLevelChangeEvent(FoodLevelChangeEvent event){
		Player player = (Player)event.getEntity();
		PermissionUser user = PermissionsEx.getUser(player);
		
		if(user.has("FullFood.ForEverFull") || player.isOp()){
			if(player.getFoodLevel() < 20){
				player.setFoodLevel(20);
			}
			event.setCancelled(true);	
		}
		return;
	}
}