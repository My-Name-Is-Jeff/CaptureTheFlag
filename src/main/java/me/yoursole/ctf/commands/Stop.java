package me.yoursole.ctf.commands;

import me.yoursole.ctf.data.GameData;
import me.yoursole.ctf.data.items.Flag;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Stop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.getInventory().remove(Flag.flag);
            }
            GameData.it = null;
            sender.sendMessage("Game Stopped");
            return true;
        } else {
            sender.sendMessage("don't u dare ._.");
            return true;
        }

    }

}
