package ru.sm1le.snippets.ImperatorBuzz;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class VaultTestPlugin extends JavaPlugin {
    
    private static Economy econ = null;

    @Override
    public void onEnable() {
        econ = getServer().getServicesManager().getRegistration(Economy.class).getProvider();
    }
}
