package org.example.creational.singleton;

public class Logger {
    /*
    * Eager initialisation consumes memory even if singleton class is not required
     */
//    private static Logger logger = new Logger();

    /*
    * Lazy initialisation saves memory until singleton class object is required;
     */
    private static Logger logger;

    private Logger() {
        System.out.println("Logger Instance created");
    }

    /*
    * Synchronized makes sure that the object creation is sync among threads.
    * But getInstance getting called by many threads may decrease performance
    * by the factor of number of threads using it.
    * */
//    public static synchronized Logger getInstance() {
//        if(logger == null) {
//            logger = new Logger();
//        };
//        return logger;
//    }

    /*
    * Double-Checked locking. Instead of synchronising the whole function,
    * we are only synchronising the creation of the logger
    * */
    public static Logger getInstance() {
        if(logger == null) {
            synchronized(Logger.class) {
                if(logger == null)
                    logger = new Logger();
            }
        };
        return logger;
    }
}