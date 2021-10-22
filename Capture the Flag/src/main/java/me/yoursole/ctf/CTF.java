package me.yoursole.ctf;

import me.yoursole.ctf.Commands.Start;
import me.yoursole.ctf.Commands.Stop;
import me.yoursole.ctf.Events.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CTF extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MoveItemEvent(), this);
        getServer().getPluginManager().registerEvents(new DropItemEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new GetCompass(), this);
        getServer().getPluginManager().registerEvents(new PlaceFlagEvent(), this);
        Objects.requireNonNull(this.getCommand("start")).setExecutor(new Start());
        Objects.requireNonNull(this.getCommand("stop")).setExecutor(new Stop());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
