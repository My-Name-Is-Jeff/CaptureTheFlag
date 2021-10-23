package me.yoursole.ctf.events

import me.yoursole.ctf.data.GameData
import me.yoursole.ctf.data.items.Flag
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerRespawnEvent

class PlayerDeath : Listener {
    @EventHandler
    fun onPlayerDeath(e: PlayerDeathEvent) {
        if (GameData.it == null) return
        if (e.entity.uniqueId == GameData.it?.uniqueId) {
            e.entity.inventory.remove(Flag.flag)
            e.drops.clear()
            val killer = Bukkit.getOnlinePlayers().find {
                it != e.entity && e.deathMessage!!.contains(it.displayName)
            }
            if (killer != null) {
                killer.inventory.addItem(Flag.flag)
                killer.sendMessage("${ChatColor.GREEN}You received the flag through murder")
                for (p in Bukkit.getOnlinePlayers()) {
                    if (killer.displayName != p.displayName) {
                        p.sendMessage("${ChatColor.GREEN}${killer.displayName} has received the flag")
                    }
                }
                GameData.it = killer
            } else {
                if (Bukkit.getOnlinePlayers().size > 1) {
                    val chosen = Bukkit.getOnlinePlayers().filter { it.gameMode == GameMode.SURVIVAL && it != GameData.it }.random()
                    chosen!!.inventory.addItem(Flag.flag)
                    chosen.sendMessage("${ChatColor.GREEN}You got lucky and received the flag")
                    for (player in Bukkit.getOnlinePlayers()) {
                        if (chosen.displayName != player.displayName) {
                            player.sendMessage("${ChatColor.GREEN}${chosen.displayName} has received the flag")
                        }
                    }
                    GameData.it = chosen
                } else {
                    a = e.entity
                }
            }
        }
    }

    @EventHandler
    fun onRespawn(e: PlayerRespawnEvent) {
        if (e.player == a) {
            e.player.inventory.addItem(Flag.flag)
            e.player.sendMessage("${ChatColor.GREEN}You got lucky...you are the only person online so you get to keep the flag")
            a = null
        }
    }

    companion object {
        private var a: Player? = null
    }
}