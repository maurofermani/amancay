package db;

import ex.Logger;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author fermani
 */
public class Conexion {

    private Connection conexion;
    private Statement st;
    private static final java.util.logging.Logger loggerSQL = java.util.logging.Logger.getLogger(Conexion.class.getName());
    private final String SEPARADOR = "\n-------------------------------------------";

    public Conexion() {
        try {
            File file = new File(Conexion.class.getResource("/log/").getPath() + "logSQL.log");
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

            String host = Session.getPropertie("db.host");
            String name = Session.getPropertie("db.name");
            String user = Session.getPropertie("db.user");
            String pass = Session.getPropertie("db.pass");
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + "/" + name, user, pass);
            st = conexion.createStatement();
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.log(Level.SEVERE, ex);
            System.exit(1);
        }
    }

    public int execUpdate(String sql) throws SQLException {
        try {
            int rtdo = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            String log = sql + "\nRtdo: " + rtdo + SEPARADOR;
            loggerSQL.log(Level.INFO, log);
            return rtdo;
        } catch (SQLException ex) {
            String log = sql + SEPARADOR;
            loggerSQL.log(Level.WARNING, log);
            throw ex;
        }
    }

    public ResultSet execSQLSelect(String sql) throws SQLException {
        try {
            ResultSet rs = st.executeQuery(sql);
            rs.last();
            String log = sql + "\nRtdo: " + rs.getRow() + SEPARADOR;
            loggerSQL.log(Level.INFO, log);
            rs.beforeFirst();
            return rs;
        } catch (SQLException ex) {
            String log = sql + SEPARADOR;
            loggerSQL.log(Level.WARNING, log);
            throw ex;
        }
    }

    /**
     * Obtiene el id de la tabla del que se inserto
     *
     * @return id en la tabla
     * @throws SQLException
     */
    public long getSerial() throws SQLException {
        ResultSet rs = st.getGeneratedKeys();
        long id = 0;
        while (rs.next()) {
            id = rs.getLong(1);
        }
        return id;
    }

    /**
     * Comienzo de una transaccion
     *
     * @throws SQLException
     */
    public void initTransaction() throws SQLException {
        conexion.setAutoCommit(false);
        String log = "\nInicio transaccion." + SEPARADOR;
        loggerSQL.log(Level.INFO, log);
    }

    /**
     * Rolback de una transaccion
     *
     * @throws SQLException
     */
    public void rollback() throws SQLException {
        conexion.rollback();
        conexion.setAutoCommit(true);
        String log = "\nRollback transaccion." + SEPARADOR;
        loggerSQL.log(Level.INFO, log);
    }

    /**
     * Fin de una transaccion
     *
     * @throws SQLException
     */
    public void endTransaction() throws SQLException {
        conexion.commit();
        conexion.setAutoCommit(true);
        String log = "\nFin transaccion." + SEPARADOR;
        loggerSQL.log(Level.INFO, log);
    }
}
