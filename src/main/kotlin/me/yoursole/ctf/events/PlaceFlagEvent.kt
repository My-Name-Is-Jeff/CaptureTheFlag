package me.yoursole.ctf.events

import me.yoursole.ctf.data.GameData
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class PlaceFlagEvent : Listener {
    @EventHandler
    fun onPlaceFlag(e: BlockPlaceEvent) {
        if (GameData.it != null && e.blockPlaced.type == Material.BLUE_BANNER || e.blockPlaced.type == Material.BLUE_WALL_BANNER) {
            e.isCancelled = true
            e.player.sendMessage(ChatColor.RED.toString() + "You can not place this item")
        }
    }
}