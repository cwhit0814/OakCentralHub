package com.oakcentral.hub.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class OnJoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.setAllowFlight(true);
		p.getInventory().clear();
		p.teleport(new Location(p.getWorld(), 139, 134, 635));

		// Server Selector
		ItemStack serverSelector = new ItemStack(Material.COMPASS, 1);
		ItemMeta im1 = serverSelector.getItemMeta();
		im1.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD
				+ "Server Selector " + ChatColor.RESET + "" + ChatColor.GRAY
				+ "" + ChatColor.ITALIC + "(Right Click)");
		serverSelector.setItemMeta(im1);

		// Gadgets
		ItemStack gadgets = new ItemStack(Material.CHEST, 1);
		ItemMeta im2 = gadgets.getItemMeta();
		im2.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Gadgets "
				+ ChatColor.RESET + "" + ChatColor.GRAY + "" + ChatColor.ITALIC
				+ "(Right Click)");
		gadgets.setItemMeta(im2);

		// Player Settings
		ItemStack settings = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta im3 = (SkullMeta) settings.getItemMeta();
		im3.setOwner(e.getPlayer().getName());
		im3.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD
				+ "Player Settings " + ChatColor.RESET + "" + ChatColor.GRAY
				+ "" + ChatColor.ITALIC + "(Right Click)");
		settings.setItemMeta(im3);

		p.getInventory().setItem(0, serverSelector);
		p.getInventory().setItem(4, gadgets);
		p.getInventory().setItem(8, settings);
	}
}
