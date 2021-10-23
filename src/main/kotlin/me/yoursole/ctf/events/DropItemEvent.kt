package me.yoursole.ctf.events

import me.yoursole.ctf.data.items.Flag
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent

class DropItemEvent : Listener {
    @EventHandler
    fun onItemDrop(e: PlayerDropItemEvent) {
        if (e.itemDrop.itemStack.isSimilar(Flag.flag)) {
            e.isCancelled = true
            e.player.sendMessage(ChatColor.RED.toString() + "You can not get rid of this")
        }
    }
}