package padron.articulos;

import herramientas.GenericTableModel;
import java.util.ArrayList;
import registros.padron.ArticuloReg;

/**
 *
 * @author fermani
 */
public class ArticulosTableModel extends GenericTableModel {
    
    private final ArrayList<ArticuloReg> datos;

    public ArticulosTableModel(ArrayList<ArticuloReg> datos) {
        super(new String[] {"Descripción", "Marca", "Familia"});
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return datos.get(rowIndex).getDescripcion();
            case 1:
                return datos.get(rowIndex).getMarcaReg().getDescripcion();
            case 2:
                return datos.get(rowIndex).getFamiliaReg().getDescripcion();
            default:
                throw new AssertionError();
        }
    }
    
    public ArticuloReg getRow(int index) {
        return datos.get(index);
    }
    
}
