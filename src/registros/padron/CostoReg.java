package registros.padron;

import java.sql.SQLException;

/**
 *
 * @author fermani
 */
public class CostoReg extends ItemReg {

    protected ArticuloReg articuloReg;
    protected TalleReg talleReg;
    protected double costo;

    public ArticuloReg getArticuloReg() {
        return articuloReg;
    }

    public void setArticuloReg(ArticuloReg articuloReg) {
        this.articuloReg = articuloReg;
    }

    public TalleReg getTalleReg() {
        return talleReg;
    }

    public void setTalleReg(TalleReg talleReg) {
        this.talleReg = talleReg;
    }

    @Override
    public String getDescripcion() {
        if (super.getDescripcion().isEmpty()) {
            descripcion = "";
            if (talleReg != null) {
                descripcion += talleReg.getDescripcion();
            }
            descripcion += "-> " + getCosto();
        }
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
        this.descripcion = null;
    }

    @Override
    public void insert() throws SQLException {
        String qry = ""
                + "insert into pdr_costos (articulo_id, talle_id, costo) values ("
                + getArticuloReg().getId() + ", "
                + getTalleReg().getId() + ", "
                + getCosto() + ");";
        db.Session.getConexion().execUpdate(qry);
        setId(db.Session.getConexion().getSerial());
    }

    /**
     * Actualiza el registro en la base de datos con la clave de id, y si no
     * tiene el id declarado lo trata de hacer mediante el articulo_id y el
     * talle_id
     *
     * @throws SQLException
     */
    @Override
    public void update() throws SQLException {
        String qry = ""
                + "update pdr_costos set "
                + " costo = " + getCosto() + " "
                + "where ";
        if (getId() != 0) {
            qry += " id = " + getId() + ";";
        } else if (getArticuloReg() != null && getArticuloReg().getId() != 0
                && getTalleReg() != null && getTalleReg().getId() != 0) {
            qry += " articulo_id = " + getArticuloReg().getId() + " "
                    + " talle_id = " + getTalleReg().getId() + ";";
        } else {
            throw new SQLException("Error al actualizar el costo. No existe la clave");
        }
        db.Session.getConexion().execUpdate(qry);
    }

    @Override
    public void drop() throws SQLException {
        String qry = ""
                + "update pdr_costos set"
                + "     estado_id = " + BAJA + " "
                + "where "
                + "     id = " + getId() + ";";
        db.Session.getConexion().execUpdate(qry);
    }
}
