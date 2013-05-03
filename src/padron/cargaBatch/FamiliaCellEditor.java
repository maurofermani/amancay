package padron.cargaBatch;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.TableCellEditor;
import javax.swing.tree.TreeCellEditor;
import padron.familias.PnlFamilias;
import registros.padron.FamiliaReg;

/**
 *
 * @author fermani
 */
public class FamiliaCellEditor extends AbstractCellEditor
    implements TableCellEditor {
    
    FamiliaReg familiaSeleccionada;

    @Override
    public Object getCellEditorValue() {
        return familiaSeleccionada;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        familiaSeleccionada = (FamiliaReg) value;
        FamiliaReg familia = PnlFamilias.seleccionarFamilia();
        if (familia != null && familia.getId() != 0) {
            familiaSeleccionada = familia;
        }
        return null;
    }    
}
