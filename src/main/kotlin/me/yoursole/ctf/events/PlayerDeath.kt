package me.yoursole.ctf.events

import me.yoursole.ctf.data.GameData
import me.yoursole.ctf.data.items.Flag
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerRespawnEvent

class PlayerDeath : Listener {
    @EventHandler
    fun onPlayerDeath(e: PlayerDeathEvent) {
        if (GameData.it == null) return
        if (e.entity.player?.uniqueId == GameData.it?.uniqueId) {
            e.entity.inventory.remove(Flag.flag)
            e.drops.clear()
            var found = false
            for (player in Bukkit.getOnlinePlayers()) {
                if (player != e.entity.player) {
                    if (e.deathMessage!!.contains(player.displayName)) {
                        found = true
                        player.inventory.addItem(Flag.flag)
                        player.sendMessage(ChatColor.GREEN.toString() + "You received the flag through murder")
                        for (playera in Bukkit.getOnlinePlayers()) {
                            if (player.displayName != playera.displayName) {
                                playera.sendMessage(ChatColor.GREEN.toString() + player.displayName + " has received the flag")
                            }
                        }
                        GameData.it = player
                        break
                    }
                }
            }
            if (!found) {
                if (Bukkit.getOnlinePlayers().size > 1) {
                    val chosen = Bukkit.getOnlinePlayers().filter { it != GameData.it }.random()
                    chosen!!.inventory.addItem(Flag.flag)
                    chosen.sendMessage(ChatColor.GREEN.toString() + "You got lucky and received the flag")
                    for (player in Bukkit.getOnlinePlayers()) {
                        if (chosen.displayName != player.displayName) {
                            player.sendMessage(ChatColor.GREEN.toString() + chosen.displayName + " has received the flag")
                        }
                    }
                    GameData.it = chosen
                } else {
                    a = e.entity.player
                }
            }
        }
    }

    @EventHandler
    fun onRespawn(e: PlayerRespawnEvent) {
        if (e.player == a) {
            e.player.inventory.addItem(Flag.flag)
            e.player.sendMessage(ChatColor.GREEN.toString() + "You got lucky...you are the only person online so you get to keep the flag")
            a = null
        }
    }

    companion object {
        private var a: Player? = null
    }
}