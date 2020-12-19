package org.Liam7D.NoFastTravel.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatUtil {
    
    public static String colorize(String str){
        return ChatColor.translateAlternateColorCodes('&', str);
    }
    
    public static void sendColor(CommandSender sender, String message){
        sender.sendMessage(colorize(message));
    }

}
