package padron;

import javax.swing.tree.DefaultMutableTreeNode;
import registros.Item;

/**
 *
 * @author fermani
 */
public class Nodo extends DefaultMutableTreeNode {

    public TipoNodo tipo;
    public Item item;

    public Nodo(TipoNodo tipo) {
        this.tipo = tipo;
        
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
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
            return getItem().getDescripcion();
        }
    }
   
}
