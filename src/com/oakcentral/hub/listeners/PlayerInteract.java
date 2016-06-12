package com.oakcentral.hub.listeners;

import java.util.Arrays;
import java.util.List;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.oakcentral.hub.Main;

public class PlayerInteract implements Listener {

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
		if (event.getAction().equals(Action.RIGHT_CLICK_AIR)
				|| event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (p.getItemInHand().getType() == Material.COMPASS) {
				event.setCancelled(true);
				Main.createServerSelectorMenu(p, "Server Selector", 9);
			} else if (p.getItemInHand().getType() == Material.CHEST) {
				event.setCancelled(true);
				Main.createGadetsMenu(p, "Gadgets", 5);
			} else if (p.getItemInHand().getType() == Material.SKULL_ITEM) {
				event.setCancelled(true);
				Main.createSettingsMenu(p, "Settings", 14);
			} else if (p.getItemInHand().getType() == Material.APPLE) {
				event.setCancelled(true);
				Main.createHelix(p);
			}
		}
	}

	@EventHandler
	public void onHit(ProjectileHitEvent e) {
		Projectile proj = e.getEntity();
		if (proj instanceof Snowball) {
			Snowball s = (Snowball) proj;
			if (s.getShooter() instanceof Player) {
				Block block = s.getWorld().getBlockAt(
						s.getLocation().getBlockX(),
						s.getLocation().getBlockY(),
						s.getLocation().getBlockZ());
				//final BlockState before = block.getLocation().subtract(0, 1, 0)
						//.getBlock().getState();
				//if (before.getBlock().getType() == Material.STAINED_CLAY) {
					//return;
				//} else {
					//block.getLocation().getBlock().getRelative(BlockFace.DOWN)
							//.setType(Material.STAINED_CLAY);
					PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, block.getX(), block.getY(), block.getZ(), 0.40f, 0.40f, 0.40f, 100, 100);
			        ((CraftPlayer) s.getShooter()).getHandle().playerConnection.sendPacket(packet);

					//new BukkitRunnable() {
						//public void run() {
							//before.update(true);
						//}
					//}.runTaskLater(Main.getInstance(), 50L);
				//}
			}
		}
	}

}