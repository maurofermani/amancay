package registros.padron;

import ex.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;

/**
 *
 * @author fermani
 */
public class FamiliaReg extends ItemReg {

    private long padre_id;
    private FamiliaReg padre;
    private ArrayList<FamiliaReg> children;
    private ArrayList<FamiliaReg> path;

    /**
     * Constructor del registro
     */
    public FamiliaReg() {
        this(0);
    }

    /**
     * ID de la familia
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

    public FamiliaReg getPadre() throws SQLException {
        if (padre == null) {
            if (getIdPadre() == 0) {
                padre = new FamiliaReg(0);
                padre.setDescripcion("");
                padre.setIdPadre(0);
            } else {
                String qry = ""
                        + "select "
                        + "     id, "
                        + "     descripcion,"
                        + "     estado_id,"
                        + "     padre_id "
                        + "from"
                        + "     pdr_familias "
                        + "where "
                        + "     id = " + getIdPadre() + "; ";
                ResultSet rs = db.Session.getConexion().execSQLSelect(qry);
                if (rs.next()) {
                    padre = new FamiliaReg(rs.getLong("id"));
                    padre.setDescripcion(rs.getString("descripcion"));
                    padre.setEstado(rs.getShort("estado_id"));
                    padre.setIdPadre(rs.getLong("padre_id"));
                } else {
                    padre = new FamiliaReg(0);
                    padre.setDescripcion("");
                    padre.setIdPadre(0);
                }
            }
        }
        return padre;
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
     * Retorna los higos de una familia
     *
     * @return ArrayList: Arreglo de familias
     * @throws SQLException
     */
    public ArrayList<FamiliaReg> children() throws SQLException {
        if (children == null) {
            children = _children();
        }
        return children;
    }

    /**
     * Retorna los higos de una familia
     *
     * @return ArrayList: Arreglo de familias
     * @throws SQLException
     */
    private ArrayList<FamiliaReg> _children() throws SQLException {
        String qry = ""
                + "select "
                + "     id, "
                + "     descripcion,"
                + "     estado_id,"
                + "     padre_id "
                + "from"
                + "     pdr_familias "
                + "where "
                + "     estado_id = " + ACTIVA + " "
                + "     and padre_id = " + getId() + " "
                + "order by padre_id, descripcion;";
        ResultSet rs = db.Session.getConexion().execSQLSelect(qry);
        return FamiliaReg.llenarArray(rs);
    }

    /**
     * Devuelve un arreglo de los ids de las familias que incluye
     *
     * @return Arreglo de ids de familias
     */
    public HashSet<Long> idsFamilias() throws SQLException {
        HashSet<Long> idsFamilias = new HashSet<>();
        idsFamilias.add(getId());
        for (FamiliaReg chield : children()) {
            idsFamilias.add(id);
            idsFamilias.addAll(chield.idsFamilias());
        }
        return idsFamilias;
    }

    public ArrayList<FamiliaReg> path() throws SQLException {
        try {
            if (path == null) {
                FamiliaReg p = getPadre();
                path = new ArrayList<>();
                if (p != null && p.getId() != 0) {
                    path.addAll(this.getPadre().path());
                }
                path.add(this);
            }
        } catch (SQLException ex) {
            path = null;
        }
        return path;
    }

    public String sPath() {
        String sPath = "";
        try {
            ArrayList<FamiliaReg> camino = path();
            for (FamiliaReg familiaReg : camino) {
                sPath += familiaReg.getDescripcion() + " -> ";
            }
            sPath = sPath.replaceAll(" -> $", "");
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, ex);
            sPath = "Error al obtener el camino de la familia";
        }
        return sPath;
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
        return FamiliaReg.llenarArray(rs);
    }

    /**
     * Crea un arreglo de FamiliaReg a partir del ResultSet de una consulta
     *
     * @param rs ResultSet
     * @return ArrayList<FamiliaReg>: Arreglo de familias
     * @throws SQLException
     */
    private static ArrayList<FamiliaReg> llenarArray(ResultSet rs) throws SQLException {
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
