package ru.sm1le.snippets.ImperatorBuzz.serialize;

import java.util.Map;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class FakeLocation {
    
    private Location loc;
    
    public FakeLocation(Location loc) {
        this.loc = loc;
    }
    
    public static Location deserialize(ConfigurationSection section) {
        Map<String, Object> map = section.getValues(true);
        Location loc = Location.deserialize(map);
        return loc;
    }
    
    public void serialize(String path, FileConfiguration config) {
    	Map<String, Object> map = loc.serialize();
    	config.set(path, map);
    }
}
