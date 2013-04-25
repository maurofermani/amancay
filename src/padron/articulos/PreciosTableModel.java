package padron.articulos;

import herramientas.GenericTableModel;
import java.util.ArrayList;
import registros.padron.PrecioReg;

/**
 *
 * @author fermani
 */
public class PreciosTableModel extends GenericTableModel {

    private ArrayList<PrecioReg> datos;
    private ArrayList<Boolean> cambios;

    public PreciosTableModel(ArrayList<PrecioReg> datos, ArrayList<Boolean> cambios) {
        super(new String[]{"Talle", "Precio"});
        this.datos = datos;
        this.cambios = cambios;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return Double.class;
        } else {
            return super.getColumnClass(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    void addRow(PrecioReg precioReg) {
        datos.add(precioReg);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return datos.get(rowIndex).getTalleReg().toString();
            case 1:
                return datos.get(rowIndex).getPrecio();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 1 && aValue instanceof Double) {
            Double aDouble = (Double) aValue;
            if (aDouble != datos.get(rowIndex).getPrecio()) {
                datos.get(rowIndex).setPrecio((Double) aValue);
                cambios.set(rowIndex, Boolean.TRUE);
            }
        }
    }
}
