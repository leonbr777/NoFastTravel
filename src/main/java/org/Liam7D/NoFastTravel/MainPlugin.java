package org.Liam7D.NoFastTravel;

import lombok.Getter;
import org.Liam7D.NoFastTravel.managers.RecallManager;
import org.Liam7D.NoFastTravel.tasks.FastTravelChecker;
import org.Liam7D.NoFastTravel.utils.interfaces.IPlugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MainPlugin extends JavaPlugin implements IPlugin {
    
    @Getter protected static List<RecallManager> recallManagerList;
    @Getter protected static HashMap<UUID, RecallManager> recallManagerMap;
    
    @Override
    public void onEnable() {
        enablePlugin();
        new FastTravelChecker().runTaskTimer(IPlugin.getPlugin(), 0, 20);
    }
    
    @Override
    public void onDisable() {
        disablePlugin();
    }
    
    @Override
    public void init() {
        recallManagerList = new ArrayList<>();
        recallManagerMap = new HashMap<>();
    }
    
    @Override
    public void cmd() {
    
    }
    
    @Override
    public void tab() {
    
    }
    
    @Override
    public void listen() {
    
    }
    
}
