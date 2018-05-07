package ru.sm1le.snippets;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(e.getFrom().equals(e.getTo())) {
			//TODO
		}
	}
}
