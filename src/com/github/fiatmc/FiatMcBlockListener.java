package com.github.fiatmc;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.entity.Player;
import java.util.List;

/**
 * FiatMc block listener
 */
public class FiatMcBlockListener implements Listener {
    private final FiatMcPlugin plugin;

    public FiatMcBlockListener(FiatMcPlugin instance) {
        plugin = instance;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled()) {
            return;
        }

        Block block = event.getBlock();
        Player player = event.getPlayer();
        Material type = block.getType();

        if (!plugin.isBlockProtectedPlayer(block, player)) {
            // plugin.getLogger().info("Block is unprotected or else you own it");
            return;
        }

        event.setCancelled(true);
        plugin.getLogger().info("Block is in protected chunk you don't own! Can't break");

        // if (type == Material.IRON_BLOCK) {
        // switch (block.getType()) {
        // case Material.SAND:
        // case Material.DIAMOND_BLOCK:
        // case Material.IRON_BLOCK:
        // case Material.GOLD_BLOCK:
        // case Material.EMERALD_BLOCK:
        // case Material.REDSTONE_BLOCK:
        // case Material.COAL_BLOCK:
        // case Material.NETHERITE_BLOCK:
        // case Material.POLISHED_GRANITE_BLOCK:
        // case Material.POLISHED_ANDESITE_BLOCK:
        // case Material.POLISHED_DIORITE_BLOCK:
            // If user breaking it is not in a protected chunk...
            // if (block.getChunk is in protected_chunks[player]) {
                // event.setCancelled(true);
            // }
        //     break;
        // default:
        //     break;
        // }
    }

    // @EventHandler
    // public void onBlockExplode(BlockExplodeEvent event) {
    //     plugin.getLogger().info("BlockExplodeEvent");
    //     if (event.isCancelled()) {
    //         plugin.getLogger().info("Canceled");
    //         return;
    //     }

    //     List<Block> block_list = event.blockList();

    //     for (Block block : block_list) {
    //         Material type = block.getType();
    //         if (type == Material.IRON_BLOCK) {
    //         // switch (block.getType()) {
    //         // case Material.SAND:
    //         // case Material.DIAMOND_BLOCK:
    //         // case Material.IRON_BLOCK:
    //         // case Material.GOLD_BLOCK:
    //         // case Material.EMERALD_BLOCK:
    //         // case Material.REDSTONE_BLOCK:
    //         // case Material.COAL_BLOCK:
    //         // case Material.NETHERITE_BLOCK:
    //         // case Material.POLISHED_GRANITE_BLOCK:
    //         // case Material.POLISHED_ANDESITE_BLOCK:
    //         // case Material.POLISHED_DIORITE_BLOCK:
    //             // If user breaking it is not in a protected chunk...
    //             // if (block.getChunk is in protected_chunks[player]) {
    //                 event.setCancelled(true);
    //                 plugin.getLogger().info("Canceling Explosion of block " +
    //                                         block.getType() +
    //                                         // "in protected chunk " +
    //                                         // protected_chunk +
    //                                         "!");
    //             // }
    //         //     break;
    //         // default:
    //         //     break;
    //         }
    //     }
    // }

}
