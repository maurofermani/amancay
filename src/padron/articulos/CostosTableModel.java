package padron.articulos;

import herramientas.GenericTableModel;
import java.util.ArrayList;
import registros.padron.CostoReg;

/**
 *
 * @author fermani
 */
public class CostosTableModel extends GenericTableModel {

    private ArrayList<CostoReg> datos;
    private ArrayList<Boolean> cambios;

    public CostosTableModel(ArrayList<CostoReg> datos, ArrayList<Boolean> cambios) {
        super(new String[]{"Talle", "Costo"});
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

    public void addRow(CostoReg costoReg) {
        datos.add(costoReg);
        fireTableDataChanged();
    }

    public CostoReg getRow(int row) {
        return datos.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return datos.get(rowIndex).getTalleReg().toString();
            case 1:
                return datos.get(rowIndex).getCosto();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 1 && aValue instanceof Double) {
            Double aDouble = (Double) aValue;
            if (aDouble != datos.get(rowIndex).getCosto()) {
                datos.get(rowIndex).setCosto((Double) aValue);
                cambios.set(rowIndex, Boolean.TRUE);
            }
        }
    }
}
