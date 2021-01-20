package org.Liam7D.NoFastTravel.utils;

import org.Liam7D.NoFastTravel.MainPlugin;
import org.Liam7D.NoFastTravel.managers.OfflineRecallManager;
import org.Liam7D.NoFastTravel.managers.RecallManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.stream.Collectors;

public class Utility {
    
    public static boolean isOnNetherRoof(Player p){
        return p.getWorld().equals(Bukkit.getWorld("world_nether")) && p.getLocation().getY() >= 127.5;
    }
    
    public static void shiftOffline(Player p){
        if (MainPlugin.getRecallManagerList().stream().anyMatch(r -> r.getPlayer().getUniqueId().equals(p.getUniqueId()))){
            RecallManager r = MainPlugin.getRecallManagerList().stream().filter(rc -> rc.getPlayer().getUniqueId().equals(p.getUniqueId())).findFirst().get();
            OfflineRecallManager offlineRecallManager = new OfflineRecallManager(r, p.getLocation());
            MainPlugin.getRecallManagerList().remove(r);
            MainPlugin.getOfflineRecallManagerList().add(offlineRecallManager);
        }
    }
    
    public static void shiftOnline(Player p){
        if (MainPlugin.getOfflineRecallManagerList().stream().anyMatch(r -> r.getOfflinePlayer().getUniqueId().equals(p.getUniqueId()))){
            OfflineRecallManager offlineRecallManager = MainPlugin.getOfflineRecallManagerList().stream().filter(orm ->
                    orm.getOfflinePlayer().getUniqueId().equals(p.getUniqueId())).findFirst().get();
            RecallManager recallManager = new RecallManager(p, offlineRecallManager.getOriginal());
            MainPlugin.getOfflineRecallManagerList().remove(offlineRecallManager);
            MainPlugin.getRecallManagerList().add(recallManager);
        }
    }
    
}
