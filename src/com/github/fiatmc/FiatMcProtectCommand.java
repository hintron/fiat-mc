package com.github.fiatmc;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Chunk;

public class FiatMcProtectCommand implements CommandExecutor {
    private final FiatMcPlugin plugin;

    public FiatMcProtectCommand(FiatMcPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        Location location = player.getLocation();
        Chunk chunk = location.getChunk();

        if (plugin.addProtectedChunk(player, chunk)) {
            player.sendMessage("You protected chunk " + chunk);
        } else {
            player.sendMessage("ERROR: You were unable to protect chunk " + chunk);
        }

        return true;
    }
}
