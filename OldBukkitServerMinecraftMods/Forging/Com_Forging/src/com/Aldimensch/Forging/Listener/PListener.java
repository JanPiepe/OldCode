package com.Aldimensch.Forging.Listener;



import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.Aldimensch.Forging.Forging;
import com.Aldimensch.Forging.Repair;


public class PListener implements Listener{
		
	public static Forging plugin;
	public PListener(Forging instance) {
		plugin = instance;
	}
	

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){

		Player player = event.getPlayer();
		ItemStack is = player.getItemInHand();
		
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(event.getClickedBlock().getTypeId() == 42 && (Repair.isTools(player.getItemInHand()) || Repair.isArmor(player.getItemInHand())))
					{
						Repair.repairCheck(is,player);
						is = null;
					}
		}
	}
}