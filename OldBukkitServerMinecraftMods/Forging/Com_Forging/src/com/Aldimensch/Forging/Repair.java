package com.Aldimensch.Forging;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Repair {
	
	
	private static void DoRepair(ItemStack is, Player player) {
		short x = 0;
		if(isSword(is)){
			is.setDurability(x);
			player.sendMessage("Your "+ player.getItemInHand().getType().name() +" was repaired!");
			return;
		}
		player.getItemInHand().setDurability(x);
		player.sendMessage("Your "+ player.getItemInHand().getType().name() +" was repaired!");
		
		
	}
	
	public static void repairCheck(ItemStack is,Player player){
		if(is.getDurability() == 0){
			player.sendMessage("It is repaired!");
			return;
		}
		
			if(isStoneTools(player.getItemInHand())){
				if(removeItem(player, 4)){
					DoRepair(is, player);
					return;
				}else{
					player.sendMessage("You dont have Stones");
					return;
				}
			}
			if(isIronArmor(player.getItemInHand())){
				if(removeItem(player, 265)){
					DoRepair(is, player);
					return;
				}else{
					player.sendMessage("You dont have Iron");
					return;
				}
			}	
			if(isIronTools(player.getItemInHand())){
				if(removeItem(player, 265)){
					DoRepair(is, player);
					return;
				}else{
					player.sendMessage("You dont have Iron");
					return;
				}
			}	
			if(isWoodTools(player.getItemInHand())){
				if(removeItem(player, 5)){
					DoRepair(is, player);
					return;
				}else{
					player.sendMessage("You dont have Wooden Planks");
					return;
				}
			}	
			if(isDiamondTools(player.getItemInHand())){
				if(removeItem(player, 264)){
					DoRepair(is, player);
					return;
				}else{
					player.sendMessage("You dont have Diamonds");
					return;
				}
			}	
			if(isDiamondArmor(player.getItemInHand())){
				if(removeItem(player, 264)){
					DoRepair(is, player);
					return;
				}else{
					player.sendMessage("You dont have Diamonds");
					return;
				}
			}	
			if(isGoldTools(player.getItemInHand())){
				if(removeItem(player, 266)){
					DoRepair(is, player);
					return;
				}else{
					player.sendMessage("You dont have Gold");
					return;
				}
			}
		}
	


	public static boolean isSword(ItemStack is){
    	return is.getTypeId() == 268 || is.getTypeId() == 272 || is.getTypeId() == 267 || 
    			is.getTypeId() == 283 ||is.getTypeId() == 276; 
    			}
	
	public static boolean isArmor(ItemStack is){
    	return is.getTypeId() == 306 || is.getTypeId() == 307 ||is.getTypeId() == 308 ||is.getTypeId() == 309 ||
    			is.getTypeId() == 310 ||is.getTypeId() == 311 ||is.getTypeId() == 312 ||is.getTypeId() == 313 ||
    			is.getTypeId() == 314 || is.getTypeId() == 315 || is.getTypeId() == 316 || is.getTypeId() == 317;
    }
	public static boolean isGoldArmor(ItemStack is){
		return is.getTypeId() == 314 || is.getTypeId() == 315 || is.getTypeId() == 316 || is.getTypeId() == 317;
	}
    public static boolean isIronArmor(ItemStack is){
    	return is.getTypeId() == 306 || is.getTypeId() == 307 || is.getTypeId() == 308 || is.getTypeId() == 309;
    }
    public static boolean isDiamondArmor(ItemStack is){
    	return is.getTypeId() == 310 || is.getTypeId() == 311 || is.getTypeId() == 312 || is.getTypeId() == 313;
    }
    public static boolean isTools(ItemStack is)
    {
    	return is.getTypeId() == 359 || is.getTypeId() == 256 || is.getTypeId() == 257 || is.getTypeId() == 258 || is.getTypeId() == 267 || is.getTypeId() == 292 || //IRON
    			is.getTypeId() == 276 || is.getTypeId() == 277 || is.getTypeId() == 278 || is.getTypeId() == 279 || is.getTypeId() == 293 || //DIAMOND
    			is.getTypeId() == 283 || is.getTypeId() == 285 || is.getTypeId() == 286 || is.getTypeId() == 284 || //GOLD
    			is.getTypeId() == 268 || is.getTypeId() == 269 || is.getTypeId() == 270 || is.getTypeId() == 271 || is.getTypeId() == 290 ||//WOOD
    			is.getTypeId() == 272 || is.getTypeId() == 273 || is.getTypeId() == 274 || is.getTypeId() == 275|| is.getTypeId() == 291;  //STONE
    }
    public static boolean isStoneTools(ItemStack is){
    	return is.getTypeId() == 272 || is.getTypeId() == 273 || is.getTypeId() == 274 || is.getTypeId() == 275 || is.getTypeId() == 291;
    }
    public static boolean isWoodTools(ItemStack is){
    	return is.getTypeId() == 268 || is.getTypeId() == 270 || is.getTypeId() == 269 || is.getTypeId() == 270 || is.getTypeId() == 271 || is.getTypeId() == 290;
    }
    public static boolean isGoldTools(ItemStack is){
    	return is.getTypeId() == 283 || is.getTypeId() == 285 || is.getTypeId() == 286 || is.getTypeId() == 284 || is.getTypeId() == 294;
    }
    public static boolean isIronTools(ItemStack is){
    	return is.getTypeId() == 267 || is.getTypeId() == 359 || is.getTypeId() == 256 || is.getTypeId() == 257 || is.getTypeId() == 258 || is.getTypeId() == 292;
    }
    
    public static boolean isDiamondTools(ItemStack is){
    	if(is.getTypeId() == 276 || is.getTypeId() == 277 || is.getTypeId() == 278 || is.getTypeId() == 279 || is.getTypeId() == 293)
    	{
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public static boolean removeItem(Player player, int typeid)
    {
    	boolean isPayed = false;
    	ItemStack[] inventory = player.getInventory().getContents();
    	for(ItemStack x : inventory){
    		if(x != null && x.getTypeId() == typeid){
    			if(x.getAmount() == 1){
    				x.setTypeId(0);
    				x.setAmount(0);
    				player.getInventory().setContents(inventory);
    				player.updateInventory();
	    			isPayed = true;
    				return isPayed;
    			} else{
	    			x.setAmount(x.getAmount() - 1);
	    			player.getInventory().setContents(inventory); 
	    			player.updateInventory();
	    			isPayed = true;
	    			return isPayed;
    			}
    		}
    	}
		return isPayed;
    }
    
    
    public static void doChange(Player player)
    {
    	int Q = player.getItemInHand().getTypeId();
    	ItemStack[] inventory = player.getInventory().getContents();
    	for(ItemStack x : inventory){
    		if(x != null && x.getTypeId() == player.getItemInHand().getTypeId() && x.getDurability() == player.getItemInHand().getDurability()){
    			
    				x.setTypeId(0);
    				x.setAmount(0);
    				player.getInventory().setContents(inventory);
    				player.updateInventory();
    				doChange2(player, Q);
    		}
    	}
    }
    
    public static void doChange2(Player player, int Q){
    	int a = 0;
    	ItemStack[] inventory = player.getInventory().getContents();
    	for(ItemStack z : inventory){
    		a++;
    		if(z == null && a >= 10 && a <= 36){
    			
    				z.setTypeId(Q);
    				z.setAmount(1);
    				player.getInventory().setContents(inventory);
    				player.updateInventory();
    		}
    	}
    }
    
}
