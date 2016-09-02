package com.oakcentral.hub.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import com.oakcentral.hub.Main;

public class PlayerMove {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerMove(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if (Main.pet.containsKey(p.getUniqueId())) {
			LivingEntity pet = Main.pet.get(p.getUniqueId());
			World w = pet.getLocation().getWorld();
			double x = pet.getLocation().getX();
			double y = pet.getLocation().getY();
			double z = pet.getLocation().getZ();
			Location loc = new Location(w, x, y, z);
			if (p.getLocation().distance(loc) > 15) {
				if (p.isOnGround()) {
					pet.teleport(p);
				}
			}
		}
	}
}
