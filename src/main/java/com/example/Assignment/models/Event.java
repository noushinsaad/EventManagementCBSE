package com.example.Assignment.models;

import com.example.Assignment.comp.event.event.EventType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="events")
public class Event {
    @Id
    private String name;
    private Boolean status;
    private EventType eventType;
    private String destinationFile;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Boolean getStatus(){
        return status;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

    public EventType getEventType(){
        return eventType;
    }

    public void setEventType(EventType eventType){
        this.eventType = eventType;
    }

    public String getDestinationFile(){
        return destinationFile;
    }

    public void setDestinationFile(String destinationFile){
        this.destinationFile = destinationFile;
    }
}
