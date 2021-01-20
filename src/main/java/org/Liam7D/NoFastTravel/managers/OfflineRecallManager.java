package org.Liam7D.NoFastTravel.managers;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class OfflineRecallManager {
    
    @Getter private final OfflinePlayer offlinePlayer;
    @Getter private final Location original; // Center point relative to cornerOne and cornerTwo.
    @Getter private final Location current;
    @Getter private final Location cornerOne;
    @Getter private final Location cornerTwo;
    
    public OfflineRecallManager(RecallManager recallManager, Location current){
        this.offlinePlayer = recallManager.getPlayer();
        this.original = recallManager.getOriginal();
        this.current = current;
        this.cornerOne = original.clone().subtract(128, 0, 128);
        this.cornerTwo = original.clone().add(128, 0, 128); // the added Y-level reaches build-limit, in the event of a player building to build-limit.
        cornerOne.setY(128);
        cornerTwo.setY(256);
    }
    
}
