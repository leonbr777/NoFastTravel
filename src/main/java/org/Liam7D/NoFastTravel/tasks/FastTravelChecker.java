package org.Liam7D.NoFastTravel.tasks;

import org.Liam7D.NoFastTravel.MainPlugin;
import org.Liam7D.NoFastTravel.managers.RecallManager;
import org.Liam7D.NoFastTravel.utils.ChatUtil;
import org.Liam7D.NoFastTravel.utils.Utility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class FastTravelChecker extends BukkitRunnable { // runs every second
    
    public void run(){
        
        if (!Bukkit.getOnlinePlayers().isEmpty()){
            for (Player p : Bukkit.getOnlinePlayers()){
                if (Utility.isOnNetherRoof(p) && MainPlugin.getRecallManagerList().stream().noneMatch(m -> m.getPlayer().getUniqueId().equals(p.getUniqueId()))){
                    RecallManager recallManager = new RecallManager(p); // automatically adds itself to MainPlugin list in constructor
                    MainPlugin.getRecallManagerList().add(recallManager); // Adds manager to list
                    //MainPlugin.getRecallManagerMap().put(p.getUniqueId(), recallManager);
                    
                    /*recallManager.getPlayer().sendMessage(ChatUtil.colorize("&a&lYou have entered the Nether roof."));
                    recallManager.getPlayer().sendMessage(ChatUtil.colorize("&2&lCorner One: " +
                            (int) recallManager.getCornerOne().getX() + ", " +
                            (int) recallManager.getCornerOne().getY() + ", " +
                            (int) recallManager.getCornerOne().getZ()));
                    recallManager.getPlayer().sendMessage(ChatUtil.colorize("&3&lCorner Two: " +
                            (int) recallManager.getCornerTwo().getX() + ", " +
                            (int) recallManager.getCornerTwo().getY() + ", " +
                            (int) recallManager.getCornerTwo().getZ()));*/
                    
                }
            }
        } else return;
        
        if (!MainPlugin.getRecallManagerList().isEmpty()){
            for (int i = 0; i < MainPlugin.getRecallManagerList().size(); i++){
                RecallManager recallManager = MainPlugin.getRecallManagerList().get(i);
                if (!Utility.isOnNetherRoof(recallManager.getPlayer())) { // If not on nether roof
                    //recallManager.getPlayer().sendMessage(ChatUtil.colorize("&c&lYou have left the Nether roof."));
                    MainPlugin.getRecallManagerList().remove(recallManager);
                    if (i != MainPlugin.getRecallManagerList().size()) i--; // Modify i to fix index of next manager
                } else if (recallManager.isFastTraveling()) {
                    recallManager.rollbackLocation();
                    recallManager.getPlayer().sendMessage(ChatUtil.colorize("&c&lYou have exceeded the 128-block limit on the Nether roof!"));
                }
            }
            
        }
        
       /*if (!MainPlugin.getRecallManagerMap().isEmpty()){
           for (int i = 0; i < MainPlugin.getRecallManagerMap().size(); i++){
               RecallManager recallManager = (RecallManager) MainPlugin.getRecallManagerMap().values().toArray()[i];
               if (!Utility.isOnNetherRoof(recallManager.getPlayer())){
                   recallManager.getPlayer().sendMessage(ChatUtil.colorize("&c&lYou have left the Nether roof."));
                   MainPlugin.getRecallManagerMap().remove(recallManager.getPlayer().getUniqueId());
                   if (i < MainPlugin.getRecallManagerMap().size()) i--;
               } else if (recallManager.isFastTraveling()){
                   recallManager.rollbackLocation();
                   recallManager.getPlayer().sendMessage(ChatUtil.colorize("&c&lYou have exceeded the 128-block limit on the Nether roof!"));
               }
           }
       }*/
       
    }
    
}
