package com.Aldimensch.FullFood;



import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;




public class EListener implements Listener{
		
	public static StarterDodmode plugin;
	public EListener(StarterDodmode instance) {
		plugin = instance;
	}
	

	@EventHandler
	public void onEntityDamageEvent(EntityDamageEvent event){
		
		if (event.getEntity() instanceof Player) {
			Player player = (Player)event.getEntity();
			if(player.hasMetadata("Godmode")){
				int timeNow = (int)(System.currentTimeMillis()/1000);
				int metaTime = player.getMetadata("Godmode").get(0).asInt();
				if(timeNow < (metaTime+60)){ // here you can change the Time in sec
					
					event.setCancelled(true);
					return;
				}
			}
			if(player.getLastDamageCause().getEntity().hasMetadata("Godmode")){
				event.setCancelled(true);
			}
		}
		return;
	}
}