package com.oakcentral.hub;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
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
	
	Entity villager = Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getServer().getWorld("world"), -10,4,-81), EntityType.VILLAGER);

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
		noAI(villager, "Villager Selector");
	}

	public void onDisable() {
		Bukkit.getServer().getLogger().info(name + " has been disabled!");
		instance = null;
		villager.remove();
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
	
	public void noAI(Entity bukkitEntity, String customName) {
	    net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity) bukkitEntity).getHandle();
	    NBTTagCompound tag = nmsEntity.getNBTTag();
	    if (tag == null) {
	        tag = new NBTTagCompound();
	    }
	    nmsEntity.c(tag);
	    tag.setInt("NoAI", 1);
	    tag.setInt("Invulnerable", 1);
	    nmsEntity.f(tag);
	    nmsEntity.getBukkitEntity().setCustomName(customName);
	    nmsEntity.getBukkitEntity().setCustomNameVisible(true);
	}

}
