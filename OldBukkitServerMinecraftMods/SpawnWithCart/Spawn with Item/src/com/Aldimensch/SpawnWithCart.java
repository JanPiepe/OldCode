package com.Aldimensch; //Your package

import java.util.logging.Logger;


import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.Aldimensch.PListener;

public class SpawnWithCart extends JavaPlugin{

	
    private final PListener playerListener = new PListener(this);
    
	Logger log = Logger.getLogger("Minecraft");//Define your logger


	public void onDisable() {
		log.info("****SpawnWithCart NOT is Running*****");
	}

	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager(); 
		pm.registerEvents(playerListener, this);
		 log.info("SpawnWithCart is Running");
	}
}