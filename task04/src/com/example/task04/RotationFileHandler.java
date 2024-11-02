package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private String filePath;
    private ChronoUnit rotationUnit;
    private LocalDateTime lastRotation;
    private FileWriter writer;

    public RotationFileHandler(String filePath, ChronoUnit rotationUnit) throws IOException {
        this.filePath = filePath;
        this.rotationUnit = rotationUnit;
        this.lastRotation = LocalDateTime.now();
        rotateFile();
    }

    private void rotateFile() throws IOException {
        if (writer != null) {
            writer.close();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        String rotatedFilePath = filePath + "_" + lastRotation.format(formatter);
        writer = new FileWriter(rotatedFilePath, true);
    }
    @Override
    public void handleMessage(String message) {
        try {
            if (LocalDateTime.now().isAfter(lastRotation.plus(1, rotationUnit))) {
                lastRotation = LocalDateTime.now();
                rotateFile();
            }
            writer.write(message + System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
