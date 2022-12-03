package br.com.ericknathan.test;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class Events implements Listener {
    @EventHandler
    public void onPLayerEggThrow(PlayerEggThrowEvent e) {
        e.getPlayer().sendMessage(ChatColor.YELLOW + "You just threw an egg!");
    }
}
