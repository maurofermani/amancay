package padron.cargaBatch;

import herramientas.GenericTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.JXComboBox;
import registros.padron.FamiliaReg;
import registros.padron.MarcaReg;
import registros.padron.PrecioReg;

/**
 *
 * @author fermani
 */
public class CargaArticulosTableModel extends GenericTableModel {

    private ArrayList<CargaArticuloReg> articulos;
    private final JXComboBox cboDescripcion;

    public CargaArticulosTableModel(JXComboBox cboDescripcion) {
        super(new String[]{"Marca", "Nro Serie", "Codigo", "Descripcion", "Talles", "Familia"});
        articulos = new ArrayList();
        this.cboDescripcion = cboDescripcion;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return MarcaReg.class;
        } else if (columnIndex == 4) {
            return FamiliaReg.class;
        } else {
            return super.getColumnClass(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 3) {
            cboDescripcion.setModel(new DefaultComboBoxModel(articulos.get(rowIndex).getArrDescripcion().toArray()));
            cboDescripcion.setSelectedItem(articulos.get(rowIndex).getDescripcion().replaceAll("^ \\* ", ""));
            return true;
        } else if (columnIndex == 2 || columnIndex == 4 || columnIndex == 5) {
            return false;
        } else {
            return true;
        }
    }

    public void setArticulos(HashMap<String, CargaArticuloReg> hm) {
        articulos = new ArrayList<>(hm.size());
        for (Map.Entry<String, CargaArticuloReg> entry : hm.entrySet()) {
            articulos.add(entry.getValue());
        }
        fireTableDataChanged();
    }

    public ArrayList<CargaArticuloReg> getArticulos() {
        return articulos;
    }

    public CargaArticuloReg getRow(int index) {
        return articulos.get(index);
    }

    @Override
    public int getRowCount() {
        return articulos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CargaArticuloReg art = articulos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return art.getMarcaReg();
            case 1:
                return art.getSerialNumber();
            case 2:
                return art.getCodigo();
            case 3:
                return art.getDescripcion();
            case 4:
                try {
                    return _precios(art.getPrecios());
                } catch (SQLException ex) {
                    return "";
                }
            case 5:
                return art.getFamiliaReg();
            default:
                throw new AssertionError();
        }
    }

    private Object _precios(ArrayList<PrecioReg> precios) {
        String rtdo = "[";
        for (Iterator<PrecioReg> it = precios.iterator(); it.hasNext();) {
            PrecioReg precioReg = it.next();
            rtdo += (precioReg.getTalleReg().getId() == 0 ? "*" : "")
                    + precioReg.getDescripcion() + ", ";
        }
        rtdo = rtdo.replaceAll(", $", "");
        return rtdo + "]";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        CargaArticuloReg art = articulos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                art.setMarcaReg((MarcaReg) aValue);
                break;
            case 1:
                art.setSerialNumber((String) aValue);
            case 3:
                art.setDescripcion(((String) aValue).replaceAll("^ \\* ", "").toUpperCase());
                break;
        }
    }
}
