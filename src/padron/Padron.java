package padron;

import javax.swing.JOptionPane;
import javax.swing.tree.TreePath;
import registros.FamiliaReg;

/**
 *
 * @author fermani
 */
public class Padron extends javax.swing.JDialog {

    public Padron() {
        initComponents();
        setLocationRelativeTo(null);
        _inicializar();
    }

    public Padron(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        _inicializar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIngreso = new javax.swing.JPanel();
        txtIngreso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        treePadron = new org.jdesktop.swingx.JXTree();
        tbr = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();

        txtIngreso.setPreferredSize(new java.awt.Dimension(70, 22));

        jLabel1.setText("Nombre de la nueva familia");

        javax.swing.GroupLayout pnlIngresoLayout = new javax.swing.GroupLayout(pnlIngreso);
        pnlIngreso.setLayout(pnlIngresoLayout);
        pnlIngresoLayout.setHorizontalGroup(
            pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(txtIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlIngresoLayout.setVerticalGroup(
            pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treePadron.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        scroll.setViewportView(treePadron);

        getContentPane().add(scroll, java.awt.BorderLayout.CENTER);

        tbr.setFloatable(false);
        tbr.setOrientation(javax.swing.SwingConstants.VERTICAL);
        tbr.setRollover(true);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/New/New_16x16.png"))); // NOI18N
        btnNew.setFocusable(false);
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        tbr.add(btnNew);

        getContentPane().add(tbr, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        TreePath path = treePadron.getSelectionPath();
        if (path == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una familia", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        txtIngreso.setText("");
        txtIngreso.requestFocus();
        int op = JOptionPane.showConfirmDialog(this, pnlIngreso, "Ingreso", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            Nodo nodo = new Nodo(TipoNodo.nodoFamilia());
            FamiliaReg familiaReg = new FamiliaReg();
            familiaReg.setDescripcion(txtIngreso.getText());
            nodo.setItem(familiaReg);
            ((Nodo) path.getLastPathComponent()).add(nodo);
            treePadron.expandPath(path);
            treePadron.updateUI();
        }
    }//GEN-LAST:event_btnNewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Padron padron = new Padron(null, false);
                padron.setLocationRelativeTo(null);
                padron.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlIngreso;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JToolBar tbr;
    private org.jdesktop.swingx.JXTree treePadron;
    private javax.swing.JTextField txtIngreso;
    // End of variables declaration//GEN-END:variables

    private void _inicializar() {
        Nodo root = new Nodo(TipoNodo.nodoRoot());
        FamiliaReg familiaReg = new FamiliaReg();
        familiaReg.setDescripcion("Padrón");
        root.setItem(familiaReg);
        treePadron.setModel(new TreePadronModel(root));
        treePadron.expandAll();
        treePadron.setCellRenderer(new RendererNodo());
        System.out.println(treePadron.getCellRenderer().getClass().getName());
    }
}
