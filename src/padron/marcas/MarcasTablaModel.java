package padron.marcas;

import herramientas.GenericTableModel;
import java.util.ArrayList;
import registros.MarcaReg;

/**
 *
 * @author fermani
 */
public class MarcasTablaModel extends GenericTableModel {

    private ArrayList<MarcaReg> datos;

    public MarcasTablaModel(ArrayList<MarcaReg> datos) {
        super(new String[]{"Descripcion"});
        this.datos = datos;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MarcaReg marca = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return marca.toString();
            default:
                return "Error";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }
    
    public MarcaReg getRow(int index) {
        return datos.get(index);
    }
}
