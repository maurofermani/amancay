package registros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fermani
 */
public class MarcaReg extends ItemReg {
    
    String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    /**
     * Retorna el string que representa al numero de la marca
     * @return 
     */
    public String nroMarca() {
        return String.format("%03d", getId());
    }
    
    @Override
    public void insert() throws SQLException {
        String qry = ""
                + "insert into pdr_marcas (descripcion, alias) values ("
                + "'" + getDescripcion() + "',"
                + "UPPER('" + getAlias() + "'));";
        db.Session.getConexion().execUpdate(qry);
        setId(db.Session.getConexion().getSerial());
    }
    
    @Override
    public void update() throws SQLException {
        String qry = ""
                + "update pdr_marcas set"
                + "     descripcion = '" + getDescripcion() + "',"
                + "     alias = UPPER('" + getAlias() + "') "
                + "where "
                + "     id = " + getId() + ";";
        db.Session.getConexion().execUpdate(qry);
    }

    @Override
    public void drop() throws SQLException {
        String qry = ""
                + "update pdr_marcas set"
                + "     estado_id = " + BAJA + " "
                + "where"
                + "     id = " + getId() + ";";
        db.Session.getConexion().execUpdate(qry);
    }

    /**
     * Trae todas las marcas activas
     *
     * @return ArrayList<MarcaReg> Arreglo de registros MarcaReg
     * @throws SQLException
     */
    public static ArrayList<MarcaReg> marcas() throws SQLException {
        return marcas(ACTIVA);
    }
    
    /**
     * Trae todas las marcas en el estado pasado por parametro
     *
     * @param estado estado de las marcas a traer
     * @return ArrayList<MarcaReg> Arreglo de registros MarcaReg
     * @throws SQLException
     */
    public static ArrayList<MarcaReg> marcas(short estado) throws SQLException {
        String qry = ""
                + "select "
                + "     id, "
                + "     descripcion,"
                + "     alias,"
                + "     estado_id "
                + "from"
                + "     pdr_marcas "
                + "where "
                + "     estado_id = " + estado + " "
                + "order by descripcion;";
        ResultSet rs = db.Session.getConexion().execSQLSelect(qry);
        ArrayList<MarcaReg> rtdo = new ArrayList<>();
        while (rs.next()) {
            MarcaReg marca = new MarcaReg();

            marca.setId(rs.getLong("id"));
            marca.setDescripcion(rs.getString("descripcion"));
            marca.setAlias(rs.getString("alias"));
            marca.setEstado(rs.getShort("estado_id"));

            rtdo.add(marca);
        }
        return rtdo;
    }
}
