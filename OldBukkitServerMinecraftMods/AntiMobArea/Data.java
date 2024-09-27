package me.Aldimensch.AntiMobArea;

import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.Aldimensch.AntiMobArea.Listener.PListener;


public class Data {
	
	public static ArrayList monsters = new ArrayList();
	public static ArrayList blocks = new ArrayList();
	public static ArrayList playerCheck = new ArrayList();
	
	
	public static void loadData(){
	monsters.add("Spider");
	monsters.add("Zombie");
	monsters.add("Skeleton");
	monsters.add("Creeper");
	monsters.add("Endermaen");
	
	blocks.add(1);
	blocks.add(2);
	blocks.add(3);
	blocks.add(4);
	blocks.add(5);
	blocks.add(12);
	blocks.add(13);
	blocks.add(20);
	blocks.add(24);
	blocks.add(45);
	blocks.add(47);
	blocks.add(45);
	blocks.add(45);
	blocks.add(85);
	

	}

	public static int sChunkX1() {
		return PListener.ChunkX1;
	}
	public static int sChunkX2() {
		return PListener.ChunkX2;
	}
	public static int sChunkZ1() {
		return PListener.ChunkZ1;
	}
	public static int sChunkZ2() {
		return PListener.ChunkZ2;
	}
	
	public static double SelectX1() {
		return PListener.SX1;
	}
	
	public static double SelectX2() {
		return PListener.SX2;
	}
	
	public static double SelectY1() {
		return PListener.SY1;
	}
	
	public static double SelectY2() {
		return PListener.SY2;
	}
	
	public static double SelectZ2() {
		return PListener.SZ2;
	}
	
	public static double SelectZ1() {
		return PListener.SZ1;
	}

	public static boolean select1() {
		return AntiMobArea.select1On;
	}

	public static boolean select2() {
		return AntiMobArea.select2On;
	}




}
