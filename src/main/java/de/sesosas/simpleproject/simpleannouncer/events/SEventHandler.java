package de.sesosas.simpleproject.simpleannouncer.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SEventHandler implements Listener {

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event){
        Thread thread = new Thread(){
            public void run(){

            }
        };
        thread.start();
    }

    @EventHandler
    public void OnPlayerQuit(PlayerQuitEvent event){
        Thread thread = new Thread(){
            public void run(){

            }
        };
        thread.start();
    }

}
