package com.Aldimensch;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.Aldimensch.SpawnWithCart;

public class PListener implements Listener{
		
	public static SpawnWithCart plugin;
	public PListener(SpawnWithCart instance) {
		plugin = instance;
	}
	

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
    	ItemStack[] inventory = player.getInventory().getContents();
    	for(ItemStack x : inventory){
    		if(x != null && x.getTypeId() == 328){
    			player.sendMessage(ChatColor.AQUA +"You dont need a Minecart");
    			return;
    		}
    	}
		for(ItemStack x : inventory){
    		if(x == null){
    			player.sendMessage(ChatColor.AQUA +"You got a Minecart!");
    			player.getInventory().addItem(new ItemStack(Material.MINECART, 1));
    			player.updateInventory();
    			return;
    		}
		}
		player.sendMessage(ChatColor.AQUA +"You dont have Space for a Minecart!");
	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e){
		Player player = e.getPlayer();
    	ItemStack[] inventory = player.getInventory().getContents();
    	for(ItemStack x : inventory){
    		if(x != null && x.getTypeId() == 328){
    			player.sendMessage(ChatColor.AQUA +"You dont need a Minecart");
    			return;
    		}
    	}
		for(ItemStack x : inventory){
    		if(x == null){
    			player.sendMessage(ChatColor.AQUA +"You got a Minecart!");
    			player.getInventory().addItem(new ItemStack(Material.MINECART, 1));
    			player.updateInventory();
    			return;
    		}
		}
		player.sendMessage(ChatColor.AQUA +"You dont have Space for a Minecart!");
	}
}