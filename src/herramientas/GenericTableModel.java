package herramientas;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fermani
 */
public abstract class GenericTableModel extends AbstractTableModel {

    private String[] titulos;
    
    public GenericTableModel(String[] titulos) {
        this.titulos = titulos;
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }
}
