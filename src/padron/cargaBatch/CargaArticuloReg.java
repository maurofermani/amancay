package padron.cargaBatch;

import java.util.ArrayList;
import registros.padron.ArticuloReg;

/**
 *
 * @author fermani
 */
public class CargaArticuloReg extends ArticuloReg {

    private ArrayList<String> arrDesc = new ArrayList<>();

    @Override
    public void setDescripcion(String descripcion) {
        super.setDescripcion(descripcion);
        if (arrDesc.indexOf(descripcion) == -1) {
            arrDesc.add(descripcion);
        }
    }

    @Override
    public String getDescripcion() {
        if (arrDesc.size() != 1) {
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
