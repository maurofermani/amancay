package padron.talles;

import ex.Logger;
import herramientas.GenericTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import registros.padron.TalleReg;

/**
 *
 * @author fermani
 */
public class TallesTablaModel extends GenericTableModel {

    private ArrayList<TalleReg> datos;

    public TallesTablaModel(ArrayList<TalleReg> datos) {
        super(new String[]{"Descripcion"});
        this.datos = datos;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TalleReg talle = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return talle.toString();
            default:
                return "Error";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }
    
    public TalleReg getRow(int index) {
        return datos.get(index);
    }

    public boolean addRow(TalleReg talleReg) {
        boolean add = datos.add(talleReg);
        fireTableDataChanged();
        return add;
    }
}
