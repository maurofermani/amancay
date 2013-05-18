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
        super.setDescripcion(descripcion);
        if (arrDesc.indexOf(descripcion) == -1) {
            arrDesc.add(descripcion);
        }
    }

    @Override
    public String getDescripcion() {
        if (guardar) {
            return super.getDescripcion();
        } else if (arrDesc.size() != 1) {
            return "* " + super.getDescripcion();
        } else {
            return "  " + super.getDescripcion();
        }
    }
    
    public ArrayList<String> getArrDescripcion() {
        return arrDesc;
    }    

    boolean consistencia() {
        return getMarcaReg() != null && getFamiliaReg() != null;
    }
}
