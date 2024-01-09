package de.sesosas.simpleproject.simpleannouncer.helper;

import de.sesosas.simpleproject.simpleannouncer.SimpleAnnouncer;

import java.util.List;

public class CurrentConfig {
    public static String getString(String name){
        return SimpleAnnouncer.getPlugin().config.getString(name);
    }

    public static Boolean getBoolean(String name){
        return SimpleAnnouncer.getPlugin().config.getBoolean(name);
    }

    public static List<?> getList(String name){
        return SimpleAnnouncer.getPlugin().config.getList(name);
    }

    public static Integer getInt(String name){
        return SimpleAnnouncer.getPlugin().config.getInt(name);
    }

    public static List<Float> getFloat(String name){
        return SimpleAnnouncer.getPlugin().config.getFloatList(name);
    }

    public static Object get(String name){
        return SimpleAnnouncer.getPlugin().config.get(name);
    }
}