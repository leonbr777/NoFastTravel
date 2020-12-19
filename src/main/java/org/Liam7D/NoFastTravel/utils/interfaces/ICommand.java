package org.Liam7D.NoFastTravel.utils.interfaces;

import org.Liam7D.NoFastTravel.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public interface ICommand {
    
    default void givePlayer(Player p, ItemStack item){ p.getInventory().addItem(item); }
    
    default void sendUsage(CommandSender sender, String usage){
        ChatUtil.sendColor(sender, "&cUsage: " + usage);
    }
    
    default boolean isPlayer(Entity e){ return e instanceof Player; }
    default boolean isPlayer(CommandSender sender){ return sender instanceof Player; }
    
    default String getBase(Command cmd){ return cmd.getName(); }
    default String getArgument(String[] args, int index){ return args[index]; }
    
    default boolean argEquals(String commandToMatch, String[] args, int index){ return args[index].equalsIgnoreCase(commandToMatch); }
    
    default Player playerFrom(CommandSender sender){ return (Player) sender; }
    default Player playerFrom(Entity e){ return (Player) e; }
    
    default List<String> autofix(List<String> tabs, String[] args, int index){
        List<String> result = new ArrayList<>();
        for (String tab : tabs){
            if (tab.toLowerCase().startsWith(args[index].toLowerCase())){
                result.add(tab);
            }
        }
        return result;
    }

}
