package com.oakcentral.hub.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.oakcentral.hub.Main;

public class PlayerInteract implements Listener {

	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
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
			}
		}
	}

	@SuppressWarnings("deprecation")
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
				final BlockState before = block.getLocation().subtract(0, 1, 0)
						.getBlock().getState();
				if (before.getBlock().getType() == Material.STAINED_CLAY) {
					return;
				} else {
				block.setData((byte) 3);
				block.getLocation().subtract(0, 1, 0).getBlock()
						.setType(Material.STAINED_CLAY);
				block.getState().update(true);

				new BukkitRunnable() {
					public void run() {
						before.update(true);
					}
				}.runTaskLater(Main.getInstance(), 50L);
				}
			}
		}
	}

}