package ru.sm1le.snippets.ImperatorBuzz;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CheckThread extends Thread {
	
	private volatile boolean isRunning = false;
	private Material checkMat;

	public CheckThread(Material checkMat) {
		super();
		this.checkMat = checkMat;
	}
	
	public void start() {
		isRunning = true;
		this.start();
	}
	
	public void stopThread() {
		isRunning = false;
	}
	
	@Override
	public void run() {
		while(isRunning) {
			for(Player current : Bukkit.getOnlinePlayers()) {
				if(current.getLocation().clone().add(0, -1, 0).getBlock().getType() == checkMat) {
					current.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 2));
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
