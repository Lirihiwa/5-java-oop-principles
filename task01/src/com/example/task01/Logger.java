package com.example.task01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private final String name;
    private Level level = Level.DEBUG;
    private static final Map<String, Logger> loggers = new HashMap<>();

    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    private static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HH:mm:ss");

    private Logger(String name) {
        this.name = name;
    }

    public static Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, Logger::new);
    }

    public String getName() {
        return name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void log(Level logLevel, String message) {
        if (logLevel.ordinal() >= level.ordinal()) {
            String formattedMessage = messageFormat(logLevel, message);
            System.out.println(formattedMessage);
        }
    }

    public void log(Level logLevel, String messageTemp, Object... args) {
        if (logLevel.ordinal() >= level.ordinal()) {
            StringBuilder message = new StringBuilder();

            message.append(messageTemp);

            for (Object arg : args) {
                message.append(" ");
                message.append(arg);
            }

            log(logLevel, message.toString());
        }
    }

    private String messageFormat(Level logLevel, String message) {
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(DATE);
        String time = now.format(TIME);
        return String.format("[%s] %s %s %s - %s", logLevel, date, time, name, message);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String messageTemplate, Object... args) {
        log(Level.DEBUG, messageTemplate, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String messageTemplate, Object... args) {
        log(Level.INFO, messageTemplate, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String messageTemplate, Object... args) {
        log(Level.WARNING, messageTemplate, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String messageTemplate, Object... args) {
        log(Level.ERROR, messageTemplate, args);
    }

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
}