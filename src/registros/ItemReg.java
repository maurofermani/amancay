package registros;

import java.sql.SQLException;

/**
 *
 * @author fermani
 */
public abstract class ItemReg {

    public static final short ACTIVA = 0;
    public static final short BAJA = 1;
    private String descripcion;
    private long id;
    private short estado_id;

    public String getDescripcion() {
        return descripcion == null ? "" : descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public short getEstado() {
        return estado_id;
    }

    public void setEstado(short estado) {
        this.estado_id = estado;
    }

    /**
     * Guarda el registro en la base de datos. Si el id es 0 lo inserta, sino lo
     * guarda.
     *
     * @throws SQLException
     */
    public void save() throws SQLException {
        if (getId() == 0) {
            insert();
        } else {
            update();
        }
    }

    /**
     * Inserta el registro en la base de datos
     *
     * @throws SQLException
     */
    public abstract void insert() throws SQLException;

    /**
     * Actualiza el registro en la base de datos
     *
     * @throws SQLException
     */
    public abstract void update() throws SQLException;

    /**
     * Da de baja el registro en la base de datos.
     *
     * @throws SQLException
     */
    public abstract void drop() throws SQLException;

    @Override
    public String toString() {
        if (db.Session.infoDevel()) {
            return "[" + getId() + "] " + getDescripcion();
        } else {
            return getDescripcion();
        }
    }
}
