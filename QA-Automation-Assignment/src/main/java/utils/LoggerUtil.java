package utils;

import java.util.logging.*;
import java.io.IOException;

public class LoggerUtil {
    private static Logger logger;
    private static FileHandler fileHandler;
    private static ConsoleHandler consoleHandler;
    
    static {
        try {
            // Create logger
            logger = Logger.getLogger("QAAutomation");
            logger.setLevel(Level.INFO);
            
            // Create file handler
            fileHandler = new FileHandler("test-execution.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter() {
                @Override
                public String format(LogRecord record) {
                    return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS [%2$s] %3$s: %4$s%n",
                            record.getMillis(),
                            record.getLevel(),
                            record.getLoggerName(),
                            record.getMessage());
                }
            });
            
            // Create console handler
            consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            consoleHandler.setFormatter(new SimpleFormatter() {
                @Override
                public String format(LogRecord record) {
                    return String.format("[%1$s] %2$s: %3$s%n",
                            record.getLevel(),
                            record.getLoggerName(),
                            record.getMessage());
                }
            });
            
            // Add handlers to logger
            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);
            
            // Prevent logging to parent handlers
            logger.setUseParentHandlers(false);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void info(String message) {
        logger.info(message);
    }
    
    public static void warning(String message) {
        logger.warning(message);
    }
    
    public static void severe(String message) {
        logger.severe(message);
    }
    
    public static void fine(String message) {
        logger.fine(message);
    }
    
    public static Logger getLogger() {
        return logger;
    }
    
    public static void closeHandlers() {
        if (fileHandler != null) {
            fileHandler.close();
        }
        if (consoleHandler != null) {
            consoleHandler.close();
        }
    }
} 