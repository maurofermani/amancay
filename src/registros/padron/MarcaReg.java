package registros.padron;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author fermani
 */
public class MarcaReg extends ItemReg {

    String alias;

    public MarcaReg() {
        this(0);
    }

    public MarcaReg(long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Retorna el string que representa al numero de la marca
     *
     * @return
     */
    public String nroMarca() {
        return String.format("%04d", getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.alias);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MarcaReg other = (MarcaReg) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
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
     * Devuelve el próximo número de la marca y lo incrementa Usado para la
     * generación de códigos
     *
     * @return Long
     * @throws SQLException
     */
    public long nextNumber() throws SQLException {
        String qry = ""
                + "update pdr_marcas set"
                + "     ultimo_nro_art = ultimo_nro_art + 1 "
                + "where "
                + "     id = " + getId() + ";";
        db.Session.getConexion().execUpdate(qry);
        qry = ""
                + "select "
                + "     ultimo_nro_art "
                + "from "
                + "     pdr_marcas "
                + "where "
                + "     id = " + getId() + ";";
        long nro = 0;
        ResultSet rs = db.Session.getConexion().execSQLSelect(qry);
        if (rs.next()) {
            nro = (Long) rs.getLong("ultimo_nro_art");
        } else {
            throw new SQLException("Número para la marca no encontrado (" + getAlias() + " - " + getDescripcion() + ")");
        }
        return nro;
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
