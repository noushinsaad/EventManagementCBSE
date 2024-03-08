package com.example.Assignment.comp.dataCollector;

import com.example.Assignment.comp.event.event.EventType;
import com.example.Assignment.comp.event.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataCollector implements RequiredInterFaceDataCollector, ProvideInterFaceDataCollector{
    private List<Event> eventList = new ArrayList<>();

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public void createEvent(Event event) {
        this.eventList.add(event);
    }

    @Override
    public void removeEvent(Event event) {
        this.eventList.remove(event);
    }

    @Override
    public List<Event> listAll() {
        return this.eventList;
    }

    @Override
    public void startEvent(Event event) {
        event.start();
    }

    @Override
    public void stopEvent(Event event) {
        event.stop();
    }

    @Override
    public void initializeEvent(Event event, String data, Boolean status, EventType eventType) {
        event.setStatus(status);
        event.setEventType(eventType);
    }

    @Override
    public String report(Event event) {
        return event.getEvent().getDestinationFile();
    }

    @Override
    public void eventManagement(Event event) {

    }

    @Override
    public String eventData(Event event) {
        return null;
    }
}
