package com.oakcentral.hub.listeners;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.oakcentral.hub.Main;

public class PlayerInteract implements Listener {

	// ServerInfo target = ProxyServer.getInstance().getServerInfo("Hub");

	List<Material> banned = Arrays.asList(new Material[] { Material.AIR,
			Material.BEDROCK, Material.SOIL, Material.WALL_SIGN,
			Material.WOOD_DOOR, Material.IRON_DOOR, Material.IRON_DOOR_BLOCK,
			Material.WOODEN_DOOR, Material.WOODEN_DOOR, Material.SIGN_POST,
			Material.BURNING_FURNACE, Material.FURNACE, Material.CHEST,
			Material.DISPENSER, Material.HOPPER, Material.MINECART,
			Material.EXPLOSIVE_MINECART, Material.HOPPER_MINECART,
			Material.POWERED_MINECART, Material.STORAGE_MINECART,
			Material.JUKEBOX, Material.DROPPER, Material.BED,
			Material.BED_BLOCK, Material.POTATO, Material.CARROT,
			Material.PUMPKIN_STEM, Material.MELON_STEM, Material.PUMPKIN,
			Material.NETHER_WARTS, Material.CAKE, Material.SUGAR_CANE,
			Material.SUGAR_CANE_BLOCK, Material.WHEAT, Material.CROPS,
			Material.COCOA, Material.BOAT, Material.ITEM_FRAME });

	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) throws Exception {
		Player p = event.getPlayer();
		World world = p.getWorld();
		if (event.getAction().equals(Action.RIGHT_CLICK_AIR)
				|| event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (p.getItemInHand().getType() == Material.COMPASS) {
				event.setCancelled(true);
				Main.createServerSelectorMenu(p, "Server Selector", 9);
			} else if (p.getItemInHand().getType() == Material.CHEST) {
				event.setCancelled(true);
				Main.createGadgetsMenu(p, "Gadgets", 5);
			} else if (p.getItemInHand().getType() == Material.SKULL_ITEM) {
				event.setCancelled(true);
				Main.createSettingsMenu(p, "Settings", 14);
			} else if (p.getItemInHand().getType() == Material.APPLE) {
				event.setCancelled(true);
				Main.createHelix(p);
			} else if (p.getItemInHand().getType() == Material.GOLD_BARDING) {
				Location loc = p
						.getEyeLocation()
						.toVector()
						.add(p.getLocation().getDirection().multiply(2))
						.toLocation(p.getWorld(), p.getLocation().getYaw(),
								p.getLocation().getPitch());
				Snowball snow = p.getWorld().spawn(loc, Snowball.class);
				snow.setShooter(p);
				snow.setVelocity(p.getEyeLocation().getDirection().multiply(2));
				world.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 10);
			}
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (!ChatColor.stripColor(event.getInventory().getName())
				.equalsIgnoreCase("Server Selector")) {
			return;
		}

		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);

		if (event.getCurrentItem() == null
				|| event.getCurrentItem().getType() == Material.AIR) {
			player.closeInventory();
			return;
		}

		ConsoleCommandSender console = Bukkit.getConsoleSender();
		switch (event.getCurrentItem().getType()) {
		case GOLD_CHESTPLATE:
			player.sendMessage(ChatColor.GOLD
					+ "Sending you to the Towny server.");
			player.closeInventory();
			Bukkit.dispatchCommand(console, "server towny");
			// ((ProxiedPlayer) player).connect(target);
			break;
		case DIAMOND_SWORD:
			player.sendMessage(ChatColor.GOLD
					+ "Sending you to the KitPvP server.");
			player.closeInventory();
			Bukkit.dispatchCommand(console, "server kitpvp");
			break;
		case GRASS:
			player.sendMessage(ChatColor.GOLD
					+ "Sending you to the Skyblock server.");
			player.closeInventory();
			Bukkit.dispatchCommand(console, "server skyblock");
			break;
		default:
			player.sendMessage(ChatColor.RED + "That is not a server!");
			player.closeInventory();
			break;
		}
	}
}