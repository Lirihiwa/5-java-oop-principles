package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{

    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public void handleMessage(String message){
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
