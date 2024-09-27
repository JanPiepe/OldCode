package me.Aldimensch.AntiMobArea.Listener;

import me.Aldimensch.AntiMobArea.AntiMobArea;
import me.Aldimensch.AntiMobArea.Data;


import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class PListener implements Listener {
	
	public static double SX1, SX2, SY1, SY2, SZ1, SZ2;
	public static int ChunkX1, ChunkX2, ChunkZ1, ChunkZ2;
	public static Block block;
	
	public static AntiMobArea plugin;
	public PListener(AntiMobArea instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(!player.equals(null)){
			player.sendMessage(ChatColor.GREEN +"Du Betritts die Welt mit den Klötzen");
			player.sendMessage(ChatColor.GREEN +"Viel Spass wünscht dir"+ ChatColor.RED+"LEGO!");
			return;
		}
		return;
		
	}
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
    	block = event.getClickedBlock();
    	Player player = event.getPlayer();
        Action action = event.getAction();
        
        if(event.getClickedBlock() != null) {
        	
        	if(action == Action.RIGHT_CLICK_BLOCK && Data.playerCheck.contains(player)){
        		player.sendMessage(color() +"Der Block "+ block.getType()+" hat den Wert "+ block.getData());
        	}
        	
        	
        	if(action == Action.LEFT_CLICK_BLOCK && player == AntiMobArea.whoSelect && Data.select1() || Data.select2()){
	        	
	        	if(Data.select1()){               
	                SX1 = block.getX();
	                SY1 = block.getY();
	                SZ1 = block.getZ();
	                ChunkX1 = block.getChunk().getX();
	                ChunkZ1 = block.getChunk().getZ();
	                
	                player.sendMessage(ChatColor.GOLD +"Position 1 selected");
	                AntiMobArea.select1On = false;
	                event.setCancelled(true);
	        	}

	        	if(Data.select2()){
		            SX2 = block.getX();
		            SY2 = block.getY();
		            SZ2 = block.getZ();
	                ChunkX2 = block.getChunk().getX();
	                ChunkZ2 = block.getChunk().getZ();
		            
		            player.sendMessage(ChatColor.GOLD +"Position 2 selected");
		            AntiMobArea.select2On = false;
		            event.setCancelled(true);
	        	}   
        	}
        }
    }
	
	ChatColor color(){
		int R = (int)(Math.random()*9);
		
		switch (R){
		
		case 0:
			return ChatColor.AQUA;
		
		case 1:
			return ChatColor.BLUE;
			
		case 2:
			return ChatColor.GOLD;
		case 3:
			return ChatColor.GREEN;
		case 4:
			return ChatColor.RED;
		case 5:
			return ChatColor.LIGHT_PURPLE;
		case 6:
			return ChatColor.DARK_GREEN;
		case 7:
			return ChatColor.DARK_AQUA;
		case 8:
			return ChatColor.DARK_PURPLE;
		case 9:
			return ChatColor.YELLOW;
		default:
			return ChatColor.YELLOW;
		}
	}
}
