package com.Aldimensch.FullFood; //Your package

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;




public class StarterDodmode extends JavaPlugin{
	

	Logger log = Logger.getLogger("Minecraft");//Define your logger
    private final EListener entityListener = new EListener(this);
    private final PListener playerListener = new PListener(this);
    
	public void onDisable() {
		log.info("Forging is NOT Running");
	}

	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager(); 
		pm.registerEvents(entityListener, this);
		pm.registerEvents(playerListener, this);
		 log.info("StarterGodmode is Running");  
	}
}