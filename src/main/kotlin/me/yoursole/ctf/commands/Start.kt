package me.yoursole.ctf.commands

import me.yoursole.ctf.data.GameData
import me.yoursole.ctf.data.items.Flag
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class Start : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        return if (sender.isOp) {
            val player = Bukkit.getOnlinePlayers().filter { it.gameMode == GameMode.SURVIVAL }.random()
            player.inventory.addItem(Flag.flag)
            GameData.it = player
            player.sendMessage("${ChatColor.GREEN}You got the flag to start!")
            true
        } else {
            sender.sendMessage("don't u dare ._.")
            true
        }
    }
}