package com.Aldimensch.FullFood;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;



public class PListener implements Listener{
		
	public static StarterDodmode plugin;
	public PListener(StarterDodmode instance) {
		plugin = instance;
	}
	

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event){
		Player player = event.getPlayer();
		PermissionUser user = PermissionsEx.getUser(player);
		if(!user.has("StarterGodmode.isOver")){
			int timeNow = (int)(System.currentTimeMillis()/1000);
			player.setMetadata("Godmode", new FixedMetadataValue(plugin, timeNow));
			user.addPermission("StarterGodmode.isOver");
			player.sendMessage(ChatColor.AQUA+ "You have godmode for 20 minutes, Gear up!"); //here you can Change the Message dont forget "TEXT"
			return;
		}
		return;
	}
}