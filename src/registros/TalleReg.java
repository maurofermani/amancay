package registros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author fermani
 */
public class TalleReg extends ItemReg {

    @Override
    public void insert() throws SQLException {
        String qry = ""
                + "insert into pdr_talles (descripcion) values ("
                + "UPPER('" + getDescripcion() + "'));";
        db.Session.getConexion().execUpdate(qry);
        setId(db.Session.getConexion().getSerial());
    }

    @Override
    public void update() throws SQLException {
        String qry = ""
                + "update pdr_talles set"
                + "     descripcion = UPPER('" + getDescripcion() + "') "
                + "where "
                + "     id = " + getId() + ";";
        db.Session.getConexion().execUpdate(qry);
    }
    
    @Override
    public void drop() throws SQLException {
        String qry = ""
                + "update pdr_talles set"
                + "     estado_id = " + BAJA + " "
                + "where "
                + "     id = " + getId() + ";";
        db.Session.getConexion().execUpdate(qry);
    }

    public static ArrayList<TalleReg> talles() throws SQLException {
        return talles(ACTIVA);
    }

    private static ArrayList<TalleReg> talles(short estado) throws SQLException {
        String qry = ""
                + "select "
                + "     id, "
                + "     descripcion,"
                + "     estado_id "
                + "from"
                + "     pdr_talles "
                + "where "
                + "     estado_id = " + estado + " "
                + "order by descripcion;";
        ResultSet rs = db.Session.getConexion().execSQLSelect(qry);
        ArrayList<TalleReg> rtdo = new ArrayList<>();
        while (rs.next()) {
            TalleReg talle = new TalleReg();

            talle.setId(rs.getLong("id"));
            talle.setDescripcion(rs.getString("descripcion"));
            talle.setEstado(rs.getShort("estado_id"));

            rtdo.add(talle);
        }
        return rtdo;
    }
    
    /**
     * Da de baja transaccionalmente los registros
     * @param talles Registros a dar de baja
     * @throws SQLException 
     */
    public static void bajas(ArrayList<TalleReg> talles) throws SQLException  {
        try {
            db.Session.getConexion().initTransaction();
            for (Iterator<TalleReg> it = talles.iterator(); it.hasNext();) {
                TalleReg talleReg = it.next();
                talleReg.drop();
            }
            db.Session.getConexion().endTransaction();
        } catch (SQLException ex) {
            db.Session.getConexion().rollback();
            throw ex;
        }
    }
}
