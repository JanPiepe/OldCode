package com.Aldimensch.FullFood; //Your package

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;




public class FullFood extends JavaPlugin{
	

	Logger log = Logger.getLogger("Minecraft");//Define your logger
    private final EListener playerListener = new EListener(this);
    
	public void onDisable() {
		log.info("FullFood is NOT Running"); //If could not start. This will write
	}

	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager(); 
		pm.registerEvents(playerListener, this);
		 log.info("FullFood is Running"); //Write it in a CommandBox and in the Log
	}
}