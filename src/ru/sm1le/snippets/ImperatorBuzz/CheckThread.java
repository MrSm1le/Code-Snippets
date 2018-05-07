package ru.sm1le.snippets.ImperatorBuzz;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CheckThread extends Thread {
	
	private volatile boolean isRunning = false;
	private Material checkMat;
	private Plugin plugin;

	public CheckThread(Material checkMat, Plugin plugin) {
		super();
		this.checkMat = checkMat;
		this.plugin = plugin;
	}
	
	public void start() {
		isRunning = true;
		super.start();
	}
	
	public void stopThread() {
		isRunning = false;
	}
	
	@Override
	public void run() {
		while(isRunning) {
			for(Player current : Bukkit.getOnlinePlayers()) {
				if(current.getLocation().clone().add(0, -1, 0).getBlock().getType() == checkMat) {
					Bukkit.getScheduler().runTask(plugin, new Runnable() {
						
						@Override
						public void run() {
							current.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 2));
						}
						
					});
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
