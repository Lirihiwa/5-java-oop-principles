package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("test");
        logger.addHandler(new MemoryHandler(new ConsoleHandler(), 5));

        logger.addHandler(new FileHandler("C:\\Users\\Lirihiwa\\Desktop\\Log.txt"));


        logger.log(Logger.Level.WARNING, "This is a warning");
        logger.log(Logger.Level.WARNING, "This is a warning");
        logger.log(Logger.Level.WARNING, "This is a warning");
        logger.log(Logger.Level.WARNING, "This is a warning");

    }
}
