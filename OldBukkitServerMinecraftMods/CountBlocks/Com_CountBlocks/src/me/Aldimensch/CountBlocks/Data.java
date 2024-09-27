package me.Aldimensch.CountBlocks;

import java.util.ArrayList;
import org.bukkit.block.Block;

import me.Aldimensch.CountBlocks.Listener.PListener;


public class Data{
	
	public static double SX1, SX2, SY1, SY2, SZ1, SZ2;
	public static Block block;

	public static ArrayList playerCheck = new ArrayList();

	
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
		return CountBlocks.select1On;
	}

	public static boolean select2() {
		return CountBlocks.select2On;
	}
}