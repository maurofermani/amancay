package padron.familias;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;



/**
 *
 * @author fermani
 */
public class RendererNodo extends DefaultTreeCellRenderer {

    private static final ImageIcon familia = new ImageIcon(RendererNodo.class.getResource("/imagenes/Archive/Archive_16x16.png"));
    private static final ImageIcon articulo = new ImageIcon(RendererNodo.class.getResource("/imagenes/Picture/Picture_16x16.png"));
    private static final ImageIcon root = new ImageIcon(RendererNodo.class.getResource("/imagenes/HardDisk/HardDisk_16x16.png"));
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component c = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        
        Nodo nodo = (Nodo) value;
        if (nodo.getTipo().esArticulo()) {
            this.setIcon(articulo);
        } else if (nodo.getTipo().esFamilia()) {
            this.setIcon(familia);
        } else if (nodo.getTipo().esRoot()) {
            this.setIcon(root);
        }
        
        return c;
    }
    
    
    
}
