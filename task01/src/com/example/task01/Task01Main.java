package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        logger1.setLevel(Logger.Level.DEBUG);


        logger1.log(Logger.Level.INFO, "!", "please", "do", "something", 3.14);
        logger1.log(Logger.Level.WARNING, "!", "please", "do", "something", 3.14);
        logger1.log(Logger.Level.ERROR, "!", "please", "do", "something", 3.14);
    }
}
