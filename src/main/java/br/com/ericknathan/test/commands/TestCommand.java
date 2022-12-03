package br.com.ericknathan.test.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player && args.length == 1) {
            if(args[0].equalsIgnoreCase("hello")) {
                sender.sendMessage(ChatColor.GREEN + "Hello my friend ;)");
            }
        }
        return false;
    }
}
