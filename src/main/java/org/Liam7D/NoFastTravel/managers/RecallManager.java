package org.Liam7D.NoFastTravel.managers;

import lombok.Getter;
import org.Liam7D.NoFastTravel.utils.Utility;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RecallManager { // Recalls players who are trying to fast-travel on the nether-roof back to their original location

    @Getter private final Player player;
    @Getter private final Location original; // Center point relative to cornerOne and cornerTwo.
    @Getter private final Location cornerOne;
    @Getter private final Location cornerTwo;
    
    public RecallManager(Player player){
        this.player = player;
        this.original = player.getLocation().clone();
        this.cornerOne = original.clone().subtract(128, 0, 128);
        this.cornerTwo = original.clone().add(128, 0, 128); // the added Y-level reaches build-limit, in the event of a player building to build-limit.
        cornerOne.setY(128);
        cornerTwo.setY(256);
    }
    
    public boolean isInRange(){
        Location l = player.getLocation().clone();
        return (l.getX() >= cornerOne.getX() && l.getX() <= cornerTwo.getX())
                && (l.getY() >= cornerOne.getY() && l.getY() <= cornerTwo.getY())
                && (l.getZ() >= cornerOne.getZ() && l.getZ() <= cornerTwo.getZ());
                
    }
    
    public boolean isFastTraveling(){
        return Utility.isOnNetherRoof(player) && !isInRange() && !player.isOp();
    }
    
    public void rollbackLocation(){
        player.teleport(original);
    }
    
}
