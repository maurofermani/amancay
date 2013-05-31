package ex;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author fermani
 */
public class Logger {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    private static void crearLog() {
        try {
            File file = new File("log/logClient.log");
            System.out.println(file.getAbsoluteFile());
            if (!file.exists()) {
                file.createNewFile();
            }
            FileHandler fh;
            fh = new FileHandler("log/logClient.log", true);
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
            //Para mostrar por consola el logger
            logger.setUseParentHandlers(true);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
    
    public static void log(Level level, Exception ex) {
        if (logger.getHandlers().length == 0) {
            Logger.crearLog();
        }
        logger.log(level, ex.getMessage(), ex);
    }
    
}
