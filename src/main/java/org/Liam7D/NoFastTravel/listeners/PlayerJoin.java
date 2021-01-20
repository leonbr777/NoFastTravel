package org.Liam7D.NoFastTravel.listeners;

import org.Liam7D.NoFastTravel.MainPlugin;
import org.Liam7D.NoFastTravel.managers.OfflineRecallManager;
import org.Liam7D.NoFastTravel.utils.Utility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    
    @EventHandler
    public void join (PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (MainPlugin.getOfflineRecallManagerList().stream().anyMatch(r -> r.getOfflinePlayer().getUniqueId().equals(p.getUniqueId()))){
            Utility.shiftOnline(p);
        }
    }
    
}
