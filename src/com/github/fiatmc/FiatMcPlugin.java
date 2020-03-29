package com.github.fiatmc;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import org.bukkit.entity.Player;
import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Fiat-MC Plugin
 */
public class FiatMcPlugin extends JavaPlugin {
    private final FiatMcPlayerListener playerListener = new FiatMcPlayerListener(this);
    private final FiatMcBlockListener blockListener = new FiatMcBlockListener(this);
    private final FiatMcEntityListener entityListener = new FiatMcEntityListener(this);
    private final HashMap<Player, List<Chunk>> players_protected_chunks = new HashMap<Player, List<Chunk>>();
    private final HashMap<Chunk, Player> claimed_chunks = new HashMap<Chunk, Player>();

    @Override
    public void onDisable() {
        // NOTE: All registered events are automatically unregistered when a plugin is disabled
        getLogger().info("Goodbye, world from Fiat-MC!");
    }

    @Override
    public void onEnable() {
        // Register events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
        pm.registerEvents(blockListener, this);
        pm.registerEvents(entityListener, this);

        // Register commands
        getCommand("protect").setExecutor(new FiatMcProtectCommand(this));

        // Other
        getLogger().info("Hello, world from Fiat-MC!");

        PluginDescriptionFile pdf_file = this.getDescription();
        getLogger().info(pdf_file.getName() + " version " +
                         pdf_file.getVersion() + " is enabled!");
        getLogger().info("Author is " + pdf_file.getAuthors());
    }

    public boolean addProtectedChunk(final Player player, Chunk chunk) {
        if (!players_protected_chunks.containsKey(player)) {
            // Initialize list
            List<Chunk> empty_list = new LinkedList<Chunk>();
            players_protected_chunks.put(player, empty_list);
        }

        // If someone else already claimed the chunk, this player can't
        if (claimed_chunks.containsKey(chunk) &&
            (claimed_chunks.get(chunk) != player)) {
            getLogger().info("Tried to protect chunk that is already protected (a)" );
            return false;
        }

        // TODO: Only allow one person to protect a chunk
        // TODO: Only allow a person 10 chunks
        // TODO: Make the chunks only get protected 5 minutes out in the future
        // to rate limit

        List<Chunk> chunks = players_protected_chunks.get(player);
        if (chunks.contains(chunk)) {
            // Already contains chunk
            getLogger().info("Tried to protect chunk that is already protected (b)");
            return false;
        }

        getLogger().info("Protecting chunk " + chunk + " for player " + player);
        chunks.add(chunk);
        claimed_chunks.put(chunk, player);
        return true;
    }

    // TODO:
    // public boolean removeProtectedChunk(final Player player) {
    // }

    public boolean isBlockProtected(final Block block) {
        for (HashMap.Entry<Chunk,Player> entry : claimed_chunks.entrySet()) {
            // Check if chunk contains the block
            if (block.getChunk() == entry.getKey()) {
                return true;
            }
        }
        return false;
    }

    public boolean isBlockProtectedPlayer(final Block block,
                                          final Player player) {
        for (HashMap.Entry<Chunk,Player> entry : claimed_chunks.entrySet()) {
            // Check if chunk contains the block and if player is NOT allowed
            // to break it
            if (block.getChunk() == entry.getKey()) {
                if (player == entry.getValue()) {
                    getLogger().info("Player can destroy block");
                    return false;
                } else {
                    getLogger().info("Player can't destroy block");
                    return true;
                }
            }
        }
        return false;
    }
}