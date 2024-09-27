package me.Aldimensch.AntiMobArea; //Your package

import java.util.logging.Logger;

import me.Aldimensch.AntiMobArea.Listener.EListener;
import me.Aldimensch.AntiMobArea.Listener.PListener;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class AntiMobArea extends JavaPlugin {

    //ClassListeners
        private final PListener playerListener = new PListener(this);
        private final EListener spawnListener = new EListener(this);


    //ClassListeners
        public static boolean select1On, select2On = false;
        public static Player whoSelect = null;
        
	public static Logger log = Logger.getLogger("Minecraft");//Define your logger


	public void onDisable() {
		log.info("****AntiMobArea is not Runing****");
	}

	public void onEnable() {
		
        PluginManager pm = this.getServer().getPluginManager(); 
        Data.loadData();

        pm.registerEvents(playerListener, this);
        pm.registerEvents(spawnListener, this);
        log.info("AntiMobArea is Runing");
	}
	
	

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		readCommand((Player) sender, commandLabel);
		return false; 
	}

	public void readCommand(Player player, String command){
		if(command.equalsIgnoreCase("ama.select1")){
			player.sendMessage(ChatColor.GOLD +"Select position 1");
			player.sendMessage(ChatColor.GOLD +"Left click on the Target!");
			select1On = true;
			whoSelect = player;
		}
		
		if(command.equalsIgnoreCase("ama.select2"))	{
			player.sendMessage(ChatColor.GOLD +"Select position 2");
			player.sendMessage(ChatColor.GOLD +"Left click on the Target!");
			select2On = true;
			whoSelect = player;
		}
		
		if(command.equalsIgnoreCase("ama.setsafe"))	{
			SelectArea.setBlocksSafe(player);
		}
		
		if(command.equalsIgnoreCase("ama.check.on"))	{
			Data.playerCheck.add(player);
		}
		
		if(command.equalsIgnoreCase("ama.check.off"))	{
			Data.playerCheck.remove(Data.playerCheck.indexOf(player));
		}
	}
}
