package com.Aldimensch.ShiftClock; //Your package

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;




public class ShiftClock extends JavaPlugin{
	
    public File configFile;
    public FileConfiguration config;

	Logger log = Logger.getLogger("Minecraft");//Define your logger
    private final ClockInOut shiftClock = new ClockInOut(this);
    
	public void onDisable() {
		log.info("Forging is NOT Running");
	}

	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager(); 
		 log.info("StarterGodmode is Running");  
			try {
		           firstRun();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	}


	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		readCommand((Player) sender, commandLabel);
		return false; 
	}
	
	public void readCommand(Player player, String command){
		if(command.equalsIgnoreCase("clockin")){
			player.sendMessage(ChatColor.GOLD +"You are now Stupid!");
			ClockInOut.ClockIn(player);
		}
		
		if(command.equalsIgnoreCase("clockout")){
			player.sendMessage(ChatColor.GOLD +"This is a Test for a stupid Persone");
			ClockInOut.ClockOut(player);
		}
	
	}
	void firstRun() throws Exception {
		configFile = new File(getDataFolder(), "config.yml");
	    if(!configFile.exists()){
	    	configFile.getParentFile().mkdirs();
	        copy(getResource("config.yml"), configFile);
	    }
	}
	
	static void copy(InputStream in, File file) {
	    try {
	        OutputStream out = new FileOutputStream(file);
	        byte[] buf = new byte[1024];
	        int len;
	        while((len=in.read(buf))>0){
	            out.write(buf,0,len);
	        }
	        out.close();
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void saveYamls() {
	    try {
	        config.save(configFile);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void loadYamls() {
	    try {
	        config.load(configFile);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}