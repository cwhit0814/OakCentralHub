package com.oakcentral.hub.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.oakcentral.hub.Main;

public class PlayerInteract implements Listener {

	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
	    Player p = event.getPlayer();
	 
	    if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
	        if(p.getItemInHand().getType() == Material.COMPASS) {
	        	event.setCancelled(true);
	        	Main.createServerSelectorMenu(p, "Server Selector", 9);
	        } else if(p.getItemInHand().getType() == Material.CHEST) {
	        	event.setCancelled(true);
	        	Main.createGadetsMenu(p, "Gadgets", 5);
	        } else if(p.getItemInHand().getType() == Material.SKULL_ITEM) {
	        	event.setCancelled(true);
	        	Main.createSettingsMenu(p, "Settings", 14);
	        }
	    }
	}
}