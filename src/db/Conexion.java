package db;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author fermani
 */
public class Conexion {

    private Connection conexion;
    private Statement st;
    private static final Logger loggerSQL = Logger.getLogger(Conexion.class.getName());
    
    private final String SEPARADOR = "\n-------------------------------------------";

    public Conexion() {
        try {
            File file = new File(getClass().getResource("/log/").getPath() + "logSQL.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileHandler fh = new FileHandler(getClass().getResource("/log/logSQL.log").getFile(), true);
            loggerSQL.addHandler(fh);
            loggerSQL.setLevel(Level.ALL);
            //Para mostrar por consola el logger
            loggerSQL.setUseParentHandlers(true);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/amancay", "root", "");
            st = conexion.createStatement();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    public int execUpdate(String sql) throws SQLException {
        int rtdo = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        String log = sql + "\nRtdo: " + rtdo + SEPARADOR;
        loggerSQL.log(Level.INFO, log);
        return rtdo;
    }
    
    public ResultSet execSQLSelect(String sql) throws SQLException {
        ResultSet rs = st.executeQuery(sql);
        rs.last();
        String log = sql + "\nRtdo: " + rs.getRow() + SEPARADOR;
        loggerSQL.log(Level.INFO, log);
        rs.beforeFirst();
        return rs;
    }
    
    /**
     * Obtiene el id de la tabla del que se inserto
     * @return id en la tabla
     * @throws SQLException 
     */
    public int getSerial() throws SQLException {
        ResultSet rs = st.getGeneratedKeys();
        int id = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
    
    /**
     * Comienzo de una transaccion
     * @throws SQLException 
     */
    public void initTransaction() throws SQLException {
        conexion.setAutoCommit(false);
    }
    
    /**
     * Rolback de una transaccion
     * @throws SQLException 
     */
    public void rollback() throws SQLException {
        conexion.rollback();
        conexion.setAutoCommit(true);
    }

    /**
     * Fin de una transaccion
     * @throws SQLException 
     */
    public void endTransaction() throws SQLException {
        conexion.commit();
        conexion.setAutoCommit(true);
    }
}
