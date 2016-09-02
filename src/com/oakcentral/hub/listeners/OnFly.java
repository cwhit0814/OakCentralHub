package com.oakcentral.hub.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class OnFly implements Listener {

	@EventHandler
	public void onPlayerToggleFlight(PlayerToggleFlightEvent e) {
		Player player = e.getPlayer();
		if (player.getGameMode() == GameMode.CREATIVE) {
			return;
		}
		if (Cooldown.canDoubleJump == true) {
			if (player.getGameMode() == GameMode.SURVIVAL) {
				player.setAllowFlight(true);
				player.setFlying(false);
				player.setVelocity(player.getLocation().getDirection()
						.multiply(1.6D).setY(1.0D));
				Cooldown.startCooldown();
			}
		} else {
			player.sendMessage(ChatColor.RED
					+ "Wait till the timer is up! You have "
					+ Cooldown.getTimer() + " seconds left.");
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if ((player.getGameMode() != GameMode.CREATIVE)
				&& (player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR)
				&& !player.isFlying()) {
			player.setAllowFlight(true);
		}
	}
}
