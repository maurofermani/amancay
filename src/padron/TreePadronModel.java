package padron;

import javax.swing.tree.TreeNode;

/**
 *
 * @author fermani
 */
public class TreePadronModel extends javax.swing.tree.DefaultTreeModel {

    public TreePadronModel(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
    }

    public TreePadronModel(TreeNode root) {
        super(root);
    }
    
}
