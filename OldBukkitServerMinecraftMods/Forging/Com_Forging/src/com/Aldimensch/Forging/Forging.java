package com.Aldimensch.Forging; //Your package

import java.util.logging.Logger;


import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.Aldimensch.Forging.Listener.PListener;


public class Forging extends JavaPlugin{

	
    private final PListener playerListener = new PListener(this);
    
	Logger log = Logger.getLogger("Minecraft");//Define your logger


	public void onDisable() {
		log.info("Forging is NOT Running");
	}

	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager(); 
		pm.registerEvents(playerListener, this);
		 log.info("Forging is Running");
	}
}