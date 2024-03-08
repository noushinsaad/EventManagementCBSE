package com.example.Assignment.comp.event.event;

import java.io.IOException;

public class WeddingEvent extends Event{
    @Override
    public void print() throws IOException{
        int count = COUNT;
        while(true){
            fileWriter.write(Integer.toBinaryString(count) + "\n");
            count++;
        }
    }
}