package registros.padron;

import db.Conexion;
import ex.GTIN13Exception;
import ex.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.logging.Level;
import padron.articulos.Codigo;

/**
 *
 * @author fermani
 */
public class ArticuloReg extends ItemReg {

    public static final short DISCONTINUADO = 3;
    private FamiliaReg familiaReg;
    private MarcaReg marcaReg;
    private String serialNumber;
    private Codigo codigo;
    private ArrayList<PrecioReg> precios;

    public FamiliaReg getFamiliaReg() {
        return familiaReg;
    }

    public void setFamiliaReg(FamiliaReg familiaReg) {
        this.familiaReg = familiaReg;
    }

    public MarcaReg getMarcaReg() {
        return marcaReg;
    }

    public void setMarcaReg(MarcaReg marcaReg) {
        this.marcaReg = marcaReg;
    }

    public ArrayList<PrecioReg> getPrecios() throws SQLException {
        if (precios == null) {
            precios = precios();
        }
        return precios;
    }

    public void setPrecios(ArrayList<PrecioReg> precios) {
        this.precios = precios;
    }

    /**
     * Serial number del articulo
     *
     * @return
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Codigo interno generado según GTIN13
     *
     * @return
     */
    public Codigo getCodigo() {
        return codigo;
    }

    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.estado_id);
        hash = 67 * hash + Objects.hashCode(this.descripcion);
        hash = 67 * hash + Objects.hashCode(this.familiaReg);
        hash = 67 * hash + Objects.hashCode(this.marcaReg);
        hash = 67 * hash + Objects.hashCode(this.serialNumber);
        hash = 67 * hash + Objects.hashCode(this.codigo);
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
        final ArticuloReg other = (ArticuloReg) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Genera el codigo interno e inserta el artículo
     *
     * @throws SQLException
     */
    @Override
    public void insert() throws SQLException {
        Conexion conexion = db.Session.getConexion();
        try {
            conexion.initTransaction();
            long nroArt = marcaReg.nextNumber();
            String sCodigo = marcaReg.getId() + "-" + nroArt;
            long lCodigo = Codigo.getCodigoSinDigito(sCodigo);
            lCodigo = lCodigo * 10 + utils.GTIN13.digito(lCodigo);
            codigo = new Codigo(lCodigo);

            String qry = ""
                    + "insert into pdr_articulos (descripcion, familia_id, marca_id, serial_number, code) values ("
                    + "'" + getDescripcion() + "',"
                    + getFamiliaReg().getId() + ","
                    + getMarcaReg().getId() + ","
                    + "'" + getSerialNumber() + "',"
                    + getCodigo().getCodigo() + ");";
            conexion.execUpdate(qry);
            setId(conexion.getSerial());
            
            for (Iterator<PrecioReg> it = precios.iterator(); it.hasNext();) {
                PrecioReg precioReg = it.next();
                if (precioReg.getTalleReg().isNew()) {
                    precioReg.getTalleReg().save();
                }
                precioReg.save();
            }

            conexion.endTransaction();
        } catch (GTIN13Exception ex) {
            conexion.rollback();
            throw new SQLException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            conexion.rollback();
            throw ex;
        }
    }

    /**
     * Actualiza la descripción y el número de serie
     *
     * @throws SQLException
     */
    @Override
    public void update() throws SQLException {
        String qry = ""
                + "update pdr_articulos set"
                + "     descripcion = '" + getDescripcion() + "',"
                + "     serial_number = '" + getSerialNumber() + "' "
                + "where "
                + "     id = " + getId() + ";";
        db.Session.getConexion().execUpdate(qry);
    }

    /**
     * Si el artículo tiene stock se marca como discontinuado
     *
     * @throws SQLException
     */
    @Override
    public void drop() throws SQLException {
        String qry = ""
                + "update pdr_articulos set"
                + "     estado_id = " + BAJA + " "
                + "where"
                + "     id = " + getId() + ";";
        db.Session.getConexion().execUpdate(qry);
    }

    public static ArrayList<ArticuloReg> articulos(FamiliaReg familiaReg) throws SQLException {
        HashSet<Long> idsFamilias = familiaReg.idsFamilias();
        String sFamilia = idsFamilias.toString().replace('[', '(').replace(']', ')');

        String qry = ""
                + "select "
                + "    a.id, "
                + "    a.descripcion, "
                + "    a.estado_id, "
                + "    a.serial_number, "
                + "    a.code, "
                + "    a.marca_id, "
                + "    m.alias, "
                + "    m.descripcion desc_marca, "
                + "    a.familia_id, "
                + "    f.descripcion desc_familia, "
                + "    f.padre_id "
                + "from "
                + "    pdr_articulos a "
                + "        join pdr_marcas m on (a.marca_id = m.id) "
                + "            join pdr_familias f on (a.familia_id = f.id) "
                + "where "
                + "    familia_id in " + sFamilia + " "
                + "    and a.estado_id not in (" + BAJA + "," + DISCONTINUADO + ") "
                + "order by a.descripcion;";
        ResultSet rs = db.Session.getConexion().execSQLSelect(qry);
        return ArticuloReg.llenarArray(rs);
    }

    /**
     * Devuelve todos los talles activos junto al precio de articulo
     *
     * @return
     * @throws SQLException
     */
    private ArrayList<PrecioReg> precios() throws SQLException {
        String qry = ""
                + " select "
                + "     p.id, "
                + "     p.estado_id, "
                + "     p.precio, "
                + "     p.talle_id, "
                + "     t.descripcion desc_talle, "
                + "     t.estado_id est_talle "
                + " from "
                + "     pdr_precios p "
                + "         join pdr_talles t on (p.talle_id = t.id) "
                + " where "
                + "     p.estado_id != " + BAJA + " "
                + "     and t.estado_id != " + TalleReg.BAJA + " "
                + "     and p.articulo_id = " + getId() + ";";
        ResultSet rs = db.Session.getConexion().execSQLSelect(qry);
        precios = new ArrayList<>();
        PrecioReg precioReg;
        TalleReg talleReg;
        while (rs.next()) {
            precioReg = new PrecioReg();
            precioReg.setArticuloReg(this);
            precioReg.setId(rs.getLong("id"));
            precioReg.setEstado(rs.getShort("estado_id"));
            precioReg.setPrecio(rs.getDouble("precio"));

            talleReg = new TalleReg();
            talleReg.setId(rs.getLong("talle_id"));
            talleReg.setDescripcion(rs.getString("desc_talle"));
            talleReg.setEstado(rs.getShort("est_talle"));
            precioReg.setTalleReg(talleReg);

            precios.add(precioReg);
        }
        return precios;
    }

    public ArrayList<TalleReg> tallesLibres() throws SQLException {
        String qry = ""
                + "select "
                + "     id, "
                + "     descripcion,"
                + "     estado_id "
                + "from"
                + "     pdr_talles "
                + "where "
                + "     estado_id = " + ACTIVA + " "
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
     * Crea un arreglo de FamiliaReg a partir del ResultSet de una consulta
     *
     * @param rs ResultSet
     * @return ArrayList<FamiliaReg>: Arreglo de familias
     * @throws SQLException
     */
    private static ArrayList<ArticuloReg> llenarArray(ResultSet rs) throws SQLException {
        ArrayList<ArticuloReg> rtdo = new ArrayList();
        while (rs.next()) {
            ArticuloReg articulo = new ArticuloReg();

            articulo.setId(rs.getLong("id"));
            articulo.setDescripcion(rs.getString("descripcion"));
            articulo.setEstado(rs.getShort("estado_id"));
            articulo.setSerialNumber(rs.getString("serial_number"));
            try {
                articulo.setCodigo(new Codigo(rs.getLong("code")));
            } catch (GTIN13Exception ex) {
                Logger.log(Level.WARNING, ex);
                articulo.setCodigo(new Codigo());
            }

            FamiliaReg familiaReg = new FamiliaReg(rs.getLong("familia_id"));
            familiaReg.setDescripcion(rs.getString("desc_familia"));
            familiaReg.setIdPadre(rs.getLong("padre_id"));
            articulo.setFamiliaReg(familiaReg);

            MarcaReg marcaReg = new MarcaReg(rs.getLong("marca_id"));
            marcaReg.setAlias(rs.getString("alias"));
            marcaReg.setDescripcion(rs.getString("desc_marca"));
            articulo.setMarcaReg(marcaReg);

            rtdo.add(articulo);
        }
        return rtdo;
    }
}
