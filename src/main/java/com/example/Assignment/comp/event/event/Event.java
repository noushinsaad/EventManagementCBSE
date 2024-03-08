package com.example.Assignment.comp.event.event;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Event extends Thread{
    protected final static int COUNT = 0;
    protected FileWriter fileWriter;
    private String destinationFile;

    public abstract void print() throws IOException;

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public String getDestinationFile() {
        return destinationFile;
    }

    public void setDestinationFile(String destinationFile) {
        this.destinationFile = destinationFile;
    }

    @Override
    public void run() {
        try{
            FileWriter fileWriter = new FileWriter(this.destinationFile);
            print();
            fileWriter.close();
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
