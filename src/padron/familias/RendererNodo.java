package padron.familias;

import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeCellRenderer;



/**
 *
 * @author fermani
 */
public class RendererNodo extends DefaultTreeCellRenderer {

    public RendererNodo() {
//        leafIcon
        closedIcon = new ImageIcon(RendererNodo.class.getResource("/icons/gnome/16x16/places/folder.png"));
        openIcon = new ImageIcon(RendererNodo.class.getResource("/icons/gnome/16x16/status/folder-open.png"));
        leafIcon = closedIcon;
    }

//    
//    @Override
//    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
//        Component c = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
//        
//        Nodo nodo = (Nodo) value;
//        if (nodo.getTipo().esArticulo()) {
//            this.setIcon(articulo);
//        } else if (nodo.getTipo().esFamilia()) {
//            this.setIcon(familia);
//        } else if (nodo.getTipo().esRoot()) {
//            this.setIcon(root);
//        }
//        
//        return c;
//    }
    
    
    
}
