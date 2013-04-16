package registros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fermani
 */
public class FamiliaReg extends ItemReg {

    private long id;
    private long padre_id;
    private String descripcion;
    private short estado_id;

    /**
     * Constructor del registro
     */
    public FamiliaReg() {
        this(0);
    }

    /**
     *
     * @param id
     */
    public FamiliaReg(long id) {
        this.id = id;
    }

    public long getIdPadre() {
        return padre_id;
    }

    public void setIdPadre(long padre_id) {
        this.padre_id = padre_id;
    }

    @Override
    public void insert() throws SQLException {
        String qry = ""
                + "insert into pdr_familias (descripcion, padre_id) values ("
                + "'" + getDescripcion() + "',"
                + getIdPadre() + ");";
        db.Session.getConexion().execUpdate(qry);
        setId(db.Session.getConexion().getSerial());
    }

    @Override
    public void update() throws SQLException {
        String qry = ""
                + "update pdr_familias set"
                + "     descripcion = '" + getDescripcion() + "', "
                + "     padre_id = " + getIdPadre() + " "
                + "where "
                + "     id = " + getId() + ";"; 
        db.Session.getConexion().execUpdate(qry);
        
    }
    
    @Override
    public void drop() throws SQLException {
        String qry = ""
                + "update pdr_familias set"
                + "     estado_id = " + BAJA + " "
                + "where "
                + "     id = " + getId() + ";";
        db.Session.getConexion().execUpdate(qry);
    }

    /**
     * Trae todas las familas activas
     *
     * @return ArrayList<FamiliaReg> Arreglo de registros FamiliaReg
     * @throws SQLException
     */
    public static ArrayList<FamiliaReg> familias() throws SQLException {
        return familias(ACTIVA);
    }

    /**
     * Trae todas las familas en el estado pasado por parametro
     *
     * @param estado estado de las familas a traer
     * @return ArrayList<FamiliaReg> Arreglo de registros FamiliaReg
     * @throws SQLException
     */
    public static ArrayList<FamiliaReg> familias(short estado) throws SQLException {
        String qry = ""
                + "select "
                + "     id, "
                + "     descripcion,"
                + "     estado_id,"
                + "     padre_id "
                + "from"
                + "     pdr_familias "
                + "where "
                + "     estado_id = " + estado + " "
                + "order by padre_id, descripcion;";
        ResultSet rs = db.Session.getConexion().execSQLSelect(qry);
        ArrayList<FamiliaReg> rtdo = new ArrayList();
        while (rs.next()) {
            FamiliaReg familia = new FamiliaReg();

            familia.setId(rs.getLong("id"));
            familia.setDescripcion(rs.getString("descripcion"));
            familia.setEstado(rs.getShort("estado_id"));
            familia.setIdPadre(rs.getLong("padre_id"));

            rtdo.add(familia);
        }
        return rtdo;
    }
}
