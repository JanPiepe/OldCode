package me.Aldimensch.CountBlocks; //Your package

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.logging.Logger;

import me.Aldimensch.CountBlocks.Listener.PListener;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class CountBlocks extends JavaPlugin {

    private final PListener playerListener = new PListener(this);

    public File configFile;
    public FileConfiguration config;
    public static boolean select1On, select2On = false;
    public static Player whoSelect = null;

        
	public static Logger log = Logger.getLogger("Minecraft");//Define your logger


	public void onDisable() {
		log.info("****CountNumber is NOT Runing****");
	}

	public void onEnable() {
		configFile = new File(this.getDataFolder(), "config.yml");
        PluginManager pm = this.getServer().getPluginManager(); 
        try {
           firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
        pm.registerEvents(playerListener, this);
        log.info("CountNumber is Runing");
	}
	

	void firstRun() throws Exception {
		configFile = new File(getDataFolder(), "config.yml");
	    if(!configFile.exists()){
	    	configFile.getParentFile().mkdirs();
	        copy(getResource("config.yml"), configFile);
	    }
	}
	

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		readCommand((Player) sender, commandLabel);
		return false; 
	}

	public void readCommand(Player player, String command){
		if(command.equalsIgnoreCase("cb")){
			if(!player.hasPermission("CheckCB.check")) {
				player.sendMessage(ChatColor.RED +"You dont have Permissons");
				return;
			}
			
			select1On = true;
			select2On = false;
			whoSelect = player;
			
			if(getConfig().getBoolean("Messages.MessagesForSelect.isShowing") == true){
    			String selectMessage1 = getConfig().getString("Messages.MessagesForSelect.Message1");
    			
    			player.sendMessage(ChatColor.GOLD +""+ selectMessage1);
        	}
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

