package me.yoursole.ctf

import me.yoursole.ctf.commands.Start
import me.yoursole.ctf.commands.Stop
import me.yoursole.ctf.events.*
import org.bukkit.plugin.java.JavaPlugin

class CTF : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(MoveItemEvent(), this)
        server.pluginManager.registerEvents(DropItemEvent(), this)
        server.pluginManager.registerEvents(PlayerDeath(), this)
        server.pluginManager.registerEvents(GetCompass(), this)
        server.pluginManager.registerEvents(PlaceFlagEvent(), this)
        getCommand("start")!!.setExecutor(Start())
        getCommand("stop")!!.setExecutor(Stop())
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}