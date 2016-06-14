package com.oakcentral.hub.listeners;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class OnEntityHit implements Listener {

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
				// final BlockState before = block.getLocation().subtract(0, 1,
				// 0)
				// .getBlock().getState();
				// if (before.getBlock().getType() == Material.STAINED_CLAY) {
				// return;
				// } else {
				// block.getLocation().getBlock().getRelative(BlockFace.DOWN)
				// .setType(Material.STAINED_CLAY);
				PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
						EnumParticle.REDSTONE, true, block.getX(),
						block.getY(), block.getZ(), 0.40f, 0.40f, 0.40f, 100,
						100);
				((CraftPlayer) s.getShooter()).getHandle().playerConnection
						.sendPacket(packet);

				// new BukkitRunnable() {
				// public void run() {
				// before.update(true);
				// }
				// }.runTaskLater(Main.getInstance(), 50L);
				// }
			}
		}
	}

}
