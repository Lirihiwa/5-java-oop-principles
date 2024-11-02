package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler{
    private final List<String> messageBuffer = new ArrayList<>();
    private final int bufferSize;
    private final MessageHandler proxiedHandler;

    public MemoryHandler(MessageHandler proxiedHandler, int bufferSize) {
        this.proxiedHandler = proxiedHandler;
        this.bufferSize = bufferSize;
    }

    public void push() {
        for (String msg : messageBuffer) {
            proxiedHandler.handleMessage(msg);
        }
        messageBuffer.clear();
    }
    @Override
    public void handleMessage(String message) {
        messageBuffer.add(message);
        if (messageBuffer.size() >= bufferSize) {
            push();
        }
    }
}
