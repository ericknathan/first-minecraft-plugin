package br.com.ericknathan.test;

import br.com.ericknathan.test.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("§aWoohoo! My plugin has started!");

        setupConfig();
        registerEvents();
        registerCommands();
    }

    void setupConfig() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }

    void registerCommands() {
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("test").setExecutor(new TestCommand());
        getCommand("console").setExecutor(new ConsoleCommand());
        getCommand("config").setExecutor(new ConfigCommand(this));
        getCommand("restricted").setExecutor(new RestrictedCommand());
    }
}
