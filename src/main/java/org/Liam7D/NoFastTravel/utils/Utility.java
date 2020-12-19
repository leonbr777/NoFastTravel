package org.Liam7D.NoFastTravel.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utility {
    
    public static boolean isOnNetherRoof(Player p){
        return p.getWorld().equals(Bukkit.getWorld("world_nether")) && p.getLocation().getY() >= 127.5;
    }
    
}
