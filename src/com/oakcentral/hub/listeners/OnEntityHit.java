package com.oakcentral.hub.listeners;

import java.util.Random;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.oakcentral.hub.Main;

public class OnEntityHit implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onHit(ProjectileHitEvent e) {
		Projectile proj = e.getEntity();
		if (proj instanceof Snowball) {
			Snowball s = (Snowball) proj;
			if (s.getShooter() instanceof Player) {
				Location loc = proj.getLocation();
				Vector vec = proj.getVelocity();
				Location loc2 = new Location(loc.getWorld(), loc.getX()
						+ vec.getX(), loc.getY() + vec.getY(), loc.getZ()
						+ vec.getZ());
				Block block = s.getWorld().getBlockAt(
						s.getLocation().getBlockX(),
						s.getLocation().getBlockY(),
						s.getLocation().getBlockZ());
				ItemStack stained_clay1 = new ItemStack(Material.STAINED_CLAY,
						1, (short) 2);
				final BlockState before = loc2.getBlock().getState();
				if (before.getBlock().getType() == Material.STAINED_CLAY) {
					return;
				} else {
					Random random = new Random();
					int chance = random.nextInt(100);
					loc2.getBlock().setType(stained_clay1.getType());
					if (chance >= 100) {
						loc2.getBlock().setData((byte) 1);
					} else if (chance >= 90) {
						loc2.getBlock().setData((byte) 3);
					} else if (chance >= 80) {
						loc2.getBlock().setData((byte) 4);
					} else if (chance >= 70) {
						loc2.getBlock().setData((byte) 5);
					} else if (chance >= 60) {
						loc2.getBlock().setData((byte) 6);
					} else if (chance >= 50) {
						loc2.getBlock().setData((byte) 10);
					} else if (chance >= 40) {
						loc2.getBlock().setData((byte) 11);
					} else if (chance >= 30) {
						loc2.getBlock().setData((byte) 14);
					} else if (chance >= 20) {
						loc2.getBlock().setData((byte) 0);
					} else if (chance >= 10) {
						loc2.getBlock().setData((byte) 2);
					}
					PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
							EnumParticle.REDSTONE, true, block.getX(),
							block.getY(), block.getZ(), 0.40f, 0.40f, 0.40f,
							100, 100);
					((CraftPlayer) s.getShooter()).getHandle().playerConnection
							.sendPacket(packet);

					new BukkitRunnable() {
						public void run() {
							before.update(true);
						}
					}.runTaskLater(Main.getInstance(), 200L);
				}
			}
		}
	}
}
