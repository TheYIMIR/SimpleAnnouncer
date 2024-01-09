package de.sesosas.simpleproject.simpleannouncer.classes;

import de.sesosas.simpleproject.simpleannouncer.SimpleAnnouncer;
import de.sesosas.simpleproject.simpleannouncer.objects.AnnouncementObject;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AnnouncementHandler {

    private List<AnnouncementObject> announcementObjectList;

    public AnnouncementHandler(List<AnnouncementObject> announcementObjectList){
        this.announcementObjectList = announcementObjectList;
    }

    public void ExecuteAnnouncements(){
        for(AnnouncementObject obj : announcementObjectList){
            obj.Start();
        }
    }

    public void StopAnnouncements(){
        for(AnnouncementObject obj : announcementObjectList){
            obj.Stop();
        }
    }

    public List<AnnouncementObject> GetAnnouncementObjectList(){
        return this.announcementObjectList;
    }

    public void SetAnnouncementObjectList(List<AnnouncementObject> announcementObjectList){
        this.announcementObjectList = announcementObjectList;
    }
}
