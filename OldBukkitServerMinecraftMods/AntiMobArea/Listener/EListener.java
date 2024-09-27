package me.Aldimensch.AntiMobArea.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.Aldimensch.AntiMobArea.AntiMobArea;
import me.Aldimensch.AntiMobArea.Data;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class EListener implements Listener {
	
	public static AntiMobArea plugin;
	public EListener(AntiMobArea instance) {
		plugin = instance;
	}
	boolean isMonster, isAMA, isChunk;


	@EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
		Location spawnLoc = event.getLocation();
		int x = 1;

        if (event.equals(null) || event.getLocation().getWorld().equals(null)){
            return;
        }
        
        if (!spawnLoc.getWorld().getEnvironment().equals(World.Environment.NORMAL)){
        	return;
        }
        
        Block block = event.getLocation().getBlock();
        World world = block.getWorld();
        Block checkBlock = world.getBlockAt(block.getX(), block.getY()-x, block.getZ());
       
        
        if(checkBlock.getData() == 5){
	        if(isMonster = Data.monsters.contains(event.getCreatureType().getName())){
    			event.setCancelled(true);
    			return;
    		}
    	}
        x = 2;
        if(checkBlock.getData() == 5){
	        if(isMonster = Data.monsters.contains(event.getCreatureType().getName())){
    			event.setCancelled(true);
    			return;
    		}
    	}
        x = 3;
        if(checkBlock.getData() == 5){
	        if(isMonster = Data.monsters.contains(event.getCreatureType().getName())){
    			event.setCancelled(true);
    			return;
    		}
    	}
        return;
        
	 }
}
