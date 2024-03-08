package com.example.Assignment.comp.event.event;

public enum EventType {
    BIRTHDAY("Birthday Event"),
    EID("Eid Event"),
    WEDDING("Wedding Event");


    public final String label;
    private EventType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    }