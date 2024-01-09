package de.sesosas.simpleproject.simpleannouncer.helper;

import org.bukkit.Bukkit;

public class PluginHandler {
    public static boolean CheckPluginInstalled(String pluginName){
        if(Bukkit.getPluginManager().getPlugin(pluginName) != null) return true;
        return false;
    }
}
