package com.example.Assignment.comp.dataCollector;

import com.example.Assignment.comp.event.Event;
import com.example.Assignment.comp.event.event.EventType;

import java.util.List;

public interface ProvideInterFaceDataCollector {
    public abstract void createEvent(Event event);
    public abstract void removeEvent(Event event);
    public abstract List<Event> listAll();
    public abstract void startEvent(Event event);
    abstract void stopEvent(Event event);
    public abstract void initializeEvent(Event event, String data, Boolean status, EventType eventType);
    public abstract String report(Event event);
}
