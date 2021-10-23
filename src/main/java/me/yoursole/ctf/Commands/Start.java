package me.yoursole.ctf.Commands;

import me.yoursole.ctf.DataFiles.GameData;
import me.yoursole.ctf.DataFiles.Items.Flag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Start implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp()){
            Player player = Bukkit.getOnlinePlayers().stream().skip((int) (Bukkit.getOnlinePlayers().size() * Math.random())).findFirst().orElse(null);
            player.getInventory().addItem(Flag.flag);
            GameData.it=player;
            player.sendMessage(ChatColor.GREEN+"You got the flag to start!");
            return true;
        }else{
            sender.sendMessage("don't u dare ._.");
            return true;
        }

    }
}
