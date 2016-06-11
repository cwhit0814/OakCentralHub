package com.oakcentral.hub;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.oakcentral.hub.listeners.OnJoin;
import com.oakcentral.hub.listeners.PlayerInteract;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	public static Main getInstance() {
		return instance;
		}

	public final String name = "OakCentralHub";

	public static Inventory serverSelector = Bukkit.createInventory(null, 54,
			"Server Selector");
	// public static Inventory lobbySelector = Bukkit.createInventory(null, 54,
	// "Lobby Selector");
	public static Inventory gadgets = Bukkit.createInventory(null, 54,
			"Gadgets");
	public static Inventory settings = Bukkit.createInventory(null, 54,
			"Player Settings");

	public void onEnable() {
		Bukkit.getServer().getLogger().info(name + " has been enabled!");
		instance = this;
		Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
	}

	public void onDisable() {
		Bukkit.getServer().getLogger().info(name + " has been disabled!");
		instance = null;
	}

	public static void createServerSelectorMenu(Player player, String name, int colorValue) {
		Inventory inv = Bukkit.getServer().createInventory(null, 27, name);

		ItemStack panes = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) colorValue);
		ItemMeta panesMeta = panes.getItemMeta();
		panesMeta.setDisplayName(" ");
		panes.setItemMeta(panesMeta);
		inv.setItem(0, panes);
		inv.setItem(1, panes);
		inv.setItem(2, panes);
		inv.setItem(3, panes);
		inv.setItem(4, panes);
		inv.setItem(5, panes);
		inv.setItem(6, panes);
		inv.setItem(7, panes);
		inv.setItem(8, panes);
		inv.setItem(17, panes);
		inv.setItem(26, panes);
		inv.setItem(25, panes);
		inv.setItem(24, panes);
		inv.setItem(23, panes);
		inv.setItem(22, panes);
		inv.setItem(21, panes);
		inv.setItem(20, panes);
		inv.setItem(19, panes);
		inv.setItem(18, panes);
		inv.setItem(9, panes);

		player.openInventory(inv);
	}
	
	public static void createGadetsMenu(Player player, String name, int colorValue) {
		Inventory inv = Bukkit.getServer().createInventory(null, 54, name);

		ItemStack panes = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) colorValue);
		ItemMeta panesMeta = panes.getItemMeta();
		panesMeta.setDisplayName(" ");
		panes.setItemMeta(panesMeta);
		inv.setItem(0, panes);
		inv.setItem(1, panes);
		inv.setItem(2, panes);
		inv.setItem(3, panes);
		inv.setItem(4, panes);
		inv.setItem(5, panes);
		inv.setItem(6, panes);
		inv.setItem(7, panes);
		inv.setItem(8, panes);
		inv.setItem(17, panes);
		inv.setItem(26, panes);
		inv.setItem(35, panes);
		inv.setItem(44, panes);
		inv.setItem(53, panes);
		inv.setItem(52, panes);
		inv.setItem(51, panes);
		inv.setItem(50, panes);
		inv.setItem(49, panes);
		inv.setItem(48, panes);
		inv.setItem(47, panes);
		inv.setItem(46, panes);
		inv.setItem(45, panes);
		inv.setItem(36, panes);
		inv.setItem(27, panes);
		inv.setItem(18, panes);
		inv.setItem(9, panes);

		player.openInventory(inv);
	}
	
	public static void createSettingsMenu(Player player, String name, int colorValue) {
		Inventory inv = Bukkit.getServer().createInventory(null, 27, name);

		ItemStack panes = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) colorValue);
		ItemMeta panesMeta = panes.getItemMeta();
		panesMeta.setDisplayName(" ");
		panes.setItemMeta(panesMeta);
		inv.setItem(0, panes);
		inv.setItem(1, panes);
		inv.setItem(2, panes);
		inv.setItem(3, panes);
		inv.setItem(4, panes);
		inv.setItem(5, panes);
		inv.setItem(6, panes);
		inv.setItem(7, panes);
		inv.setItem(8, panes);
		inv.setItem(17, panes);
		inv.setItem(26, panes);
		inv.setItem(25, panes);
		inv.setItem(24, panes);
		inv.setItem(23, panes);
		inv.setItem(22, panes);
		inv.setItem(21, panes);
		inv.setItem(20, panes);
		inv.setItem(19, panes);
		inv.setItem(18, panes);
		inv.setItem(9, panes);

		player.openInventory(inv);
	}
}
