package com.github.fiatmc;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;

/**
 * FiatMc block listener
 */
public class FiatMcEntityListener implements Listener {
    private final FiatMcPlugin plugin;

    public FiatMcEntityListener(FiatMcPlugin instance) {
        plugin = instance;
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if (event.isCancelled()) {
            return;
        }

        List<Block> block_list = event.blockList();

        for (Block block : block_list) {
            if (plugin.isBlockProtected(block)) {
                plugin.getLogger().info("Canceling Explosion of block ");
                event.setCancelled(true);
                return;
            }

            // Cancel explosion of specific block type?
            // Material type = block.getType();
            // if (type == Material.IRON_BLOCK) {
            //         event.setCancelled(true);
            //         plugin.getLogger().info("Canceling Explosion of block " +
            //                                 block.getType() +
            //                                 "!");
            // }
        }
        // plugin.getLogger().info("Explosion is not in protected chunk. Allowing");
    }

}
