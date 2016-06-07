package com.oakcentral.hub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public final String name = "OakCentralHub";
	
	public static Inventory serverSelector = Bukkit.createInventory(null, 54, ChatColor.AQUA + "Server Selector");

	public void onEnable() {
		Bukkit.getServer().getLogger().info(name + " has been enabled!");
	}

	public void onDisable() {
		Bukkit.getServer().getLogger().info(name + " has been disabled!");
	}

}
