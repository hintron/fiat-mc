package com.github.fiatmc;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Handle events for all Player related events
 */
public class FiatMcPlayerListener implements Listener {
    private final FiatMcPlugin plugin;

    public FiatMcPlayerListener(FiatMcPlugin instance) {
        plugin = instance;
    }

    // @EventHandler
    // public void onPlayerMove(PlayerMoveEvent event) {
    // }
}
