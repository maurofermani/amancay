package registros.padron;

import java.sql.SQLException;

/**
 *
 * @author fermani
 */
public class PrecioReg extends ItemReg {

    protected ArticuloReg articuloReg;
    protected TalleReg talleReg;
    protected double precio;

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
            if (articuloReg != null) {
                descripcion += articuloReg.getDescripcion();
            }
            descripcion += " - ";
            if (talleReg != null) {
                descripcion += talleReg.getDescripcion();
            }
        }
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public void insert() throws SQLException {
        String qry = ""
                + "insert into pdr_precios (articulo_id, talle_id, precio) values ("
                + getArticuloReg().getId() + ", "
                + getTalleReg().getId() + ", "
                + getPrecio() + ");";
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
                + "update pdr_precios set "
                + " precio = " + getPrecio() + " "
                + "where ";
        if (getId() != 0) {
            qry += " id = " + getId() + ";";
        } else if (getArticuloReg() != null && getArticuloReg().getId() != 0
                && getTalleReg() != null && getTalleReg().getId() != 0) {
            qry += " articulo_id = " + getArticuloReg().getId() + " "
                    + " talle_id = " + getTalleReg().getId() + ";";
        } else {
            throw new SQLException("Error al actualizar el precio. No existe la clave");
        }
        db.Session.getConexion().execUpdate(qry);
    }

    @Override
    public void drop() throws SQLException {
        String qry = ""
                + "update pdr_precios set"
                + "     estado_id = " + BAJA + " "
                + "where "
                + "     id = " + getId() + ";";
        db.Session.getConexion().execUpdate(qry);
    }
}
