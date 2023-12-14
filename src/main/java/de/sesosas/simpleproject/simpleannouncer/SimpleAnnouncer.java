package de.sesosas.simpleproject.simpleannouncer;

import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleAnnouncer extends JavaPlugin {

    public static SimpleAnnouncer plugin;

    public static SimpleAnnouncer getPlugin(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

    }
}
