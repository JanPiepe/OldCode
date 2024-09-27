package me.Aldimensch.CountBlocks.Listener;

import me.Aldimensch.CountBlocks.CountBlocks;
import me.Aldimensch.CountBlocks.Data;
import me.Aldimensch.CountBlocks.SelectArea;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class PListener implements Listener {
	public static double SX1, SX2, SY1, SY2, SZ1, SZ2;
	public static Block block;
	public static CountBlocks plugin;
	public PListener(CountBlocks instance) {
		plugin = instance;
	}
	
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
    	block = event.getClickedBlock();
    	Player player = event.getPlayer();
        Action action = event.getAction();
        
        if(event.getClickedBlock() != null) {
        	        	
        	
        	if(action == Action.LEFT_CLICK_BLOCK && player == CountBlocks.whoSelect && Data.select1() || Data.select2()){
	        	
	        	if(Data.select1()){               
	                SX1 = block.getX();
	                SY1 = block.getY();
	                SZ1 = block.getZ();
	                
	                CountBlocks.select1On = false;
	                CountBlocks.select2On = true;
	                event.setCancelled(true);
	                if(plugin.getConfig().getBoolean("Messages.MessagesForSelect.isShowing") == true){
		    			String selectMessage2 = plugin.getConfig().getString("Messages.MessagesForSelect.Message2");
		    			
		    			player.sendMessage(ChatColor.GOLD +""+ selectMessage2);
		        	}
	                return;
	        	}

	        	if(Data.select2()){
		            SX2 = block.getX();
		            SY2 = block.getY();
		            SZ2 = block.getZ();
		            
		            CountBlocks.select2On = false;
		            event.setCancelled(true);
		            SelectArea.countBlocks(player);
		            
		    		
		    		if(plugin.getConfig().getBoolean("Messages.MessagesForBlocks.isShowing") == true){
		    			String blockMessage1 = plugin.getConfig().getString("Messages.MessagesForBlocks.Message1");
		    			String blockMessage2 = plugin.getConfig().getString("Messages.MessagesForBlocks.Message2");
		    			
		    			player.sendMessage(ChatColor.GOLD +""+ blockMessage1 +" "+ SelectArea.blocks +" "+ blockMessage2);
		        	}
	        	}
	        }
	    }
	}
}
