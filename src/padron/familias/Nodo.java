package padron.familias;

import javax.swing.tree.DefaultMutableTreeNode;
import registros.padron.ItemReg;

/**
 *
 * @author fermani
 */
public class Nodo extends DefaultMutableTreeNode {

    private TipoNodo tipo;
    private ItemReg item;

    public Nodo(TipoNodo tipo) {
        super();
        this.tipo = tipo;
    }
    
    public Nodo(TipoNodo tipo, Nodo padre) {
        this(tipo);
        setParent(padre);
    }

    public ItemReg getItem() {
        return item;
    }

    public void setItem(ItemReg item) {
        this.item = item;
    }

    public TipoNodo getTipo() {
        return tipo;
    }

    public void setTipo(TipoNodo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        if (getItem() == null) {
            return "";
        } else {
            return getItem().toString();
        }
    }
   
}
