package org.Liam7D.NoFastTravel.listeners;

import org.Liam7D.NoFastTravel.MainPlugin;
import org.Liam7D.NoFastTravel.utils.Utility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
    
    @EventHandler
    public void quit (PlayerQuitEvent e){
        Player p = e.getPlayer();
        if (MainPlugin.getRecallManagerList().stream().anyMatch(r -> r.getPlayer().getUniqueId().equals(p.getUniqueId()))){
            Utility.shiftOffline(p);
        }
    }
    
}
