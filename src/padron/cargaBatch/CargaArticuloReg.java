package padron.cargaBatch;

import java.sql.SQLException;
import java.util.ArrayList;
import registros.padron.ArticuloReg;

/**
 *
 * @author fermani
 */
public class CargaArticuloReg extends ArticuloReg {

    private ArrayList<String> arrDesc = new ArrayList<>();
    private boolean guardar = false;

    @Override
    public void save() throws SQLException {
        guardar = true;
        super.save();
    }

    @Override
    public void setDescripcion(String descripcion) {
        if (!descripcion.trim().isEmpty()) {
            super.setDescripcion(descripcion);
            if (arrDesc.indexOf(descripcion) == -1) {
                arrDesc.add(descripcion);
            }
        }
    }

    @Override
    public String getDescripcion() {
        if (guardar) {
            return super.getDescripcion();
        } else if (arrDesc.size() > 1) {
            return "* " + super.getDescripcion();
        } else {
            return "  " + super.getDescripcion();
        }
    }

    public ArrayList<String> getArrDescripcion() {
        return arrDesc;
    }

    public boolean consistencia() {
        return marcaReg != null
                && familiaReg != null
                && (descripcion != null && !descripcion.trim().isEmpty());
    }

    public boolean isEmpty() {
        return arrDesc.isEmpty()
                && marcaReg == null
                && familiaReg == null
                && serialNumber == null
                && costos.isEmpty();
    }
}
