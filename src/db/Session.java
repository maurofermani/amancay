package db;

import amancay.Amancay;
import ex.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.JInternalFrame;

/**
 *
 * @author fermani
 */
public class Session {

    public static String V_PADRON = "Padrón";
    private static Properties properties;
    private static final Conexion CONEXION = new Conexion();
    private static final java.util.HashMap<String, amancay.InternalFrame> ventanas = new java.util.HashMap<>();
    private static amancay.Amancay app;

    /**
     * Retorna la aplicacion principal
     *
     * @return
     */
    public static Amancay getApp() {
        return app;
    }

    public static void setApp(Amancay app) {
        Session.app = app;
    }

    /**
     * Retorna el InternalFame seleccionado
     *
     * @return
     */
    public static JInternalFrame frameSelected() {
        return app.getDesktop().getSelectedFrame();
    }

    /**
     * Retorna la conexion a la base de datos
     *
     * @return Conexion a base de datos
     */
    public static Conexion getConexion() {
        return CONEXION;
    }

    /**
     * Retorna las propiedades en el archivo de configuracion ubicado en
     * /config/db.properties
     *
     * @param key clave de la propiedad
     * @return String valor de la propiedad
     * @throws IOException
     */
    public static String getPropertie(String key) throws IOException {
        if (properties == null) {
            try {
                properties = new Properties();
                properties.load(new FileInputStream("config/db.properties"));
            } catch (IOException ex) {
                Logger.log(Level.SEVERE, ex);
                throw ex;
            }
        }
        return properties.getProperty(key);
    }

    public static boolean infoDevel() {
        try {
            String atrr = getPropertie("devel.info");
            return atrr != null && (atrr.equals("yes") || atrr.equals("si"));
        } catch (IOException ex) {
            Logger.log(Level.SEVERE, ex);
            return false;
        }
    }
}
