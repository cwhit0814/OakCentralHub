package com.oakcentral.hub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.oakcentral.hub.listeners.OnEntityHit;
import com.oakcentral.hub.listeners.OnFly;
import com.oakcentral.hub.listeners.OnJoin;
import com.oakcentral.hub.listeners.PlayerInteract;
import com.oakcentral.hub.pets.PetMaker;

public class Main extends JavaPlugin implements Listener {

	private static Main instance;

	public static Main getInstance() {
		return instance;
	}

	public static HashMap<UUID, UUID> pets = new HashMap<UUID, UUID>();
	public static HashMap<LivingEntity, Player> pet = new HashMap<LivingEntity, Player>();

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
		Bukkit.getPluginManager().registerEvents(new OnEntityHit(), this);
		Bukkit.getPluginManager().registerEvents(new OnFly(), this);
	}

	public void onDisable() {
		Bukkit.getServer().getLogger().info(name + " has been disabled!");
		instance = null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Pig pig = player.getWorld().spawn(player.getLocation(), Pig.class);
			if (cmd.getName().equalsIgnoreCase("pet")) {
				pig.setCustomName(ChatColor.GOLD + player.getName() + "s Pet");
				pig.setCustomNameVisible(true);
				PetMaker.makePet(pig, player.getUniqueId());
				pets.put(pig.getUniqueId(), player.getUniqueId());
				pet.put(pig, player);
			}
			if (cmd.getName().equalsIgnoreCase("petremove")) {}
		}
		return true;
	}

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

	public static void createHelix(Player player) {
		Location loc = player.getLocation();
		int radius = 2;
		for (double y = 0; y <= 50; y += 0.05) {
			double x = radius * Math.cos(y);
			double z = radius * Math.sin(y);
			PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
					randParticle(), true, (float) (loc.getX() + x),
					(float) (loc.getY() + y), (float) (loc.getZ() + z), 0, 0,
					0, 0, 1, 1000);
			for (Player online : Bukkit.getOnlinePlayers()) {
				((CraftPlayer) online).getHandle().playerConnection
						.sendPacket(packet);
			}
		}
	}

	public static EnumParticle randParticle() {
		Random r = new Random();
		int rNumb = r.nextInt(5) + 1;
		if (rNumb == 1)
			return EnumParticle.FIREWORKS_SPARK;
		else if (rNumb == 2)
			return EnumParticle.VILLAGER_HAPPY;
		else if (rNumb == 3)
			return EnumParticle.SPELL_WITCH;
		else if (rNumb == 4)
			return EnumParticle.FLAME;
		else if (rNumb == 5) {
			return EnumParticle.BLOCK_CRACK;
		}
		return null;
	}

}
