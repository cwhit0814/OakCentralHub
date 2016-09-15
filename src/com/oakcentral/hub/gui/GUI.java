package com.oakcentral.hub.gui;

import java.util.Arrays;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {

	public static void createServerSelectorMenu(Player player, String name,
			int colorValue) {
		Inventory inv = Bukkit.getServer().createInventory(null, 27, name);

		ItemStack panes = new ItemStack(Material.STAINED_GLASS_PANE, 1,
				(short) colorValue);
		ItemStack chestplate = new ItemStack(Material.GOLD_CHESTPLATE);
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		ItemStack grass = new ItemStack(Material.GRASS);
		ItemMeta panesMeta = panes.getItemMeta();
		panesMeta.setDisplayName(" ");
		panes.setItemMeta(panesMeta);
		ItemMeta swordMeta = sword.getItemMeta();
		swordMeta.setDisplayName("KitPvP");
		swordMeta.setLore(Arrays.asList(ChatColor.BLUE
				+ "Fight to the death with kits that you unlock."));
		sword.setItemMeta(swordMeta);
		ItemMeta chestplateMeta = chestplate.getItemMeta();
		chestplateMeta.setDisplayName("Towny");
		chestplateMeta.setLore(Arrays.asList(ChatColor.GOLD
				+ "Build towns and nations with friends... ",
				"or random strangers."));
		chestplate.setItemMeta(chestplateMeta);
		ItemMeta grassMeta = grass.getItemMeta();
		grassMeta.setDisplayName("Skyblock");
		grassMeta.setLore(Arrays.asList(ChatColor.GREEN
				+ "Start on a small floating island and try to ",
				"survive while you expand your island."));
		grass.setItemMeta(grassMeta);
		inv.setItem(0, panes);
		inv.setItem(1, panes);
		inv.setItem(2, panes);
		inv.setItem(3, panes);
		inv.setItem(4, panes);
		inv.setItem(5, panes);
		inv.setItem(6, panes);
		inv.setItem(7, panes);
		inv.setItem(8, panes);
		inv.setItem(11, chestplate);
		inv.setItem(13, sword);
		inv.setItem(15, grass);
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

	public static void createGadgetsMenu(Player player, String name,
			int colorValue) {
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

	public static void createSettingsMenu(Player player, String name,
			int colorValue) {
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
	
	public static void createSettingsMenu(Player player, String name) {
		Inventory inv = Bukkit.getServer().createInventory(null, 27, name);
		
		player.openInventory(inv);
	}

}
