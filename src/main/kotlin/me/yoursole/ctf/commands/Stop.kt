package me.yoursole.ctf.commands

import me.yoursole.ctf.data.GameData
import me.yoursole.ctf.data.items.Flag
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class Stop : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        return if (sender.isOp) {
            for (player in Bukkit.getOnlinePlayers()) {
                player.inventory.remove(Flag.flag)
            }
            GameData.it = null
            sender.sendMessage("Game Stopped")
            true
        } else {
            sender.sendMessage("don't u dare ._.")
            true
        }
    }
}