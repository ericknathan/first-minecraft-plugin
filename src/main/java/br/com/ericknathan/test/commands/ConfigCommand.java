package br.com.ericknathan.test.commands;

import br.com.ericknathan.test.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ConfigCommand implements CommandExecutor {
    private Main main;

    public ConfigCommand(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage("The word is: " + main.getConfig().getString("Word"));
                player.sendMessage("The number is: " + main.getConfig().getInt("Number"));
                if(main.getConfig().getBoolean("Boolean")) {
                    player.sendMessage("This feature is enabled!");
                }
                for(String string : main.getConfig().getStringList("String-list")) {
                    player.sendMessage("- " + string);
                }
            } else {
                if(args[0].equalsIgnoreCase("set")) {
                    if(args.length == 3) {
                        if(args[1].equalsIgnoreCase("String-list")) {
                            List<String> list = main.getConfig().getStringList("String-list");
                            for(String string : args[2].split(",")) {
                                list.add(string);
                            }
                            main.getConfig().set("String-list", list);

                        } else {
                            main.getConfig().set(args[1], args[2]);
                        }

                        main.saveConfig();
                        player.sendMessage(ChatColor.GREEN + "Config updated!");
                    } else player.sendMessage(ChatColor.RED + "Usage: /config set <key> <value>");
                }
            }
        }
        return false;
    }
}
