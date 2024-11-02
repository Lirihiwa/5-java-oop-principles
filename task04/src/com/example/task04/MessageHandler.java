package com.example.task04;

@FunctionalInterface
public interface MessageHandler {
    void handleMessage(String message);
}
