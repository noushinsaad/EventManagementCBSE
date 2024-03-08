package com.example.Assignment.comp.dataCollector;

import com.example.Assignment.comp.event.Event;

public interface RequiredInterFaceDataCollector {
    public abstract void eventManagement(Event event);
    public abstract String eventData(Event event);
}