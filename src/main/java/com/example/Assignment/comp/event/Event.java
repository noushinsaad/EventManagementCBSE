package com.example.Assignment.comp.event;

import com.example.Assignment.comp.event.event.*;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Event implements ProvideInterFaceEvent {
    private static final String RESOURCE_DIRECTORY = "resources/event-data-file/";
    private static final String EXTENSION = ".txt";
    private static final String DELIMITER = "-";
    private Boolean status = false;
    private String name;
    private EventType eventType;
    private com.example.Assignment.comp.event.event.Event event;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public com.example.Assignment.comp.event.event.Event getEvent() {
        return event;
    }

    public void setevent() {
        switch(this.eventType){
            case WEDDING:
                this.event = new WeddingEvent();
                break;
            case BIRTHDAY:
                this.event = new BirthdayEvent();
                break;
            default:
                this.event = new EidEvent();
                break;
        }
    }

    @Override
    public void start() {
        this.status = true;
        this.event.setDestinationFile(RESOURCE_DIRECTORY + this.name + DELIMITER + UUID.fromString(this.name) + EXTENSION);
        System.out.println("Starting Event: " + this.name);
        this.event.start();
    }

    @Override
    public void stop() {
        this.status = false;
    }
}
