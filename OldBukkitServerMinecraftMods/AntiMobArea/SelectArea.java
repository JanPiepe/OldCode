package me.Aldimensch.AntiMobArea;


import java.util.ArrayList;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SelectArea {

	

	public static void setBlocksSafe(Player player) {
		int x1 = (int) Data.SelectX1(), x2 = (int) Data.SelectX2(),
		    y1 = (int) Data.SelectY1(), y2 = (int) Data.SelectY2(),
		    z1 = (int) Data.SelectZ1(), z2 = (int) Data.SelectZ2(), tmp = 0;
		int a = 0;
		double V = 0;
		World world = player.getWorld();
		
		if(x2 > x1){ tmp = x2; x2 = x1; x1 = tmp; }
		if(y2 > y1){ tmp = y2; y2 = y1; y1 = tmp; }
		if(z2 > z1){ tmp = z2; z2 = z1; z1 = tmp; }
		
		double sx = (x1 - x2);
		double sy = (y1 - y2);
		double sz = (z1 - z2);

		player.sendMessage(sx +" sx| "+ sy +" sy| "+ sz +" sz");

		
		for (int x = 0; x <= sx; x++){
			for (int y = 0; y <= sy; y++){
				for (int z = 0; z <= sz; z++){
					Block block = world.getBlockAt((x+x2), (y+y2), (z+z2));

					if(Data.blocks.contains(block.getTypeId())){
						block.setData((byte) 5);
						a++;		
					}
				}
			}	
		}
		V = (sx+1)*(sy+1)*(1+sz);
		player.sendMessage(a +"Bl�cke ver�ndert von "+ V);
	}
}

