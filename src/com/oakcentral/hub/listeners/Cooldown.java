package com.oakcentral.hub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import com.oakcentral.hub.Main;

public class Cooldown extends BukkitRunnable {

	public static Main plugin = Main.getInstance();

	private static int timer;
	public static boolean canDoubleJump = false;

	@Override
	public void run() {
		if (timer == 0) {
			canDoubleJump = true;
			return;
		} else {
			canDoubleJump = false;
		}
	}

	
	@SuppressWarnings("deprecation")
	public static void startCooldown() {
		timer = 3;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Cooldown(),
				20L, 20L);
	}

	public static int getTimer() {
		return timer;
	}
}
