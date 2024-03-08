package com.example.Assignment.services.util;

import com.example.Assignment.comp.event.event.EventType;

import java.util.*;

public class CommonService{
    public static List<EventType> generateEventTypeList(){
        return new ArrayList<>(Arrays.asList(EventType.values()));
    }
}