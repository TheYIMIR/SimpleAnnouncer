package de.sesosas.simpleproject.simpleannouncer.objects;

import de.sesosas.simpleproject.simpleannouncer.SimpleAnnouncer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

public class AnnouncementObject {
    private String section;
    private List<String> messages;
    private long time;
    private boolean enabled;
    private boolean isRunning;
    private BukkitTask task;

    public AnnouncementObject(String section, boolean enabled, List<String> messages, long time){
        this.section = section;
        this.enabled = enabled;
        this.messages = messages;
        this.time = time;
        this.isRunning = false;
    }

    List<String> GetMessages(){
        return this.messages;
    }

    String GetSection(){
        return this.section;
    }

    Long GetTime(){
        return this.time;
    }

    boolean isEnabled(){
        return this.enabled;
    }

    private class SendMessage {
        void Send(List<String> msg){
            for(Player player : Bukkit.getOnlinePlayers()) {
                for(String m : msg){
                    player.sendMessage(m);
                }
            }
        }
    }

    public void Start() {
        if (!isRunning && this.enabled) {
            isRunning = true;
            task = SimpleAnnouncer.getPlugin().getServer().getScheduler().runTaskTimer(SimpleAnnouncer.getPlugin(), () -> {
                if (isRunning) {
                    SendMessage msg = new SendMessage();
                    if(GetMessages().isEmpty()){
                        Bukkit.getLogger().warning("Your desired message at '" + GetSection() + "' seems to be empty.");
                    }
                    else{
                        msg.Send(GetMessages());
                    }
                }
            }, 0, GetTime() * 20L);
        }
    }

    public void Stop() {
        isRunning = false;
        task.cancel();
    }
}
