package org.Liam7D.NoFastTravel.utils.interfaces;

import org.Liam7D.NoFastTravel.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;

public interface IPlugin {
    
    PluginManager pm = Bukkit.getServer().getPluginManager();
    ConsoleCommandSender sender = Bukkit.getServer().getConsoleSender();
    
    void cmd(); // Where all commands are registered
    void tab(); // Where all tabcompletes are registered
    void listen(); // Where all listeners are registered
    default void init(){
    
    }
    default void sendStatus(String status){
        // This method detects the inputted status; if "enabled", then print in green text. Else, print in red text.
        sender.sendMessage("");
        if (status.equalsIgnoreCase("enabled")){
            sender.sendMessage(ChatColor.GREEN + getPlugin().getName() + " has been enabled!");
        } else if (status.equalsIgnoreCase("disabled")){
            sender.sendMessage(ChatColor.RED + getPlugin().getName() + " has been disabled!");
        } else {
            sender.sendMessage(ChatColor.DARK_PURPLE + getPlugin().getName() + " status: " + status);
        }
        sender.sendMessage("");
    }
    
    default void enablePlugin(){ // onEnable mother code
        init();
        cmd();
        tab();
        listen();
        sendStatus("enabled");
    }
    default void disablePlugin(){ // onDisable mother code
        sendStatus("disabled");
    }
    
    static MainPlugin getPlugin(){
        return MainPlugin.getPlugin(MainPlugin.class);
    }
    
}
