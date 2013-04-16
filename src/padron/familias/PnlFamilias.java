package padron.familias;

import ex.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import javax.swing.tree.TreePath;
import registros.FamiliaReg;
import registros.ItemReg;

/**
 *
 * @author fermani
 */
public class PnlFamilias extends javax.swing.JPanel {

    public PnlFamilias(boolean modificar) {
        initComponents();
        tbr.setVisible(modificar);
        _inicializar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIngreso = new javax.swing.JPanel();
        txtIngreso = new javax.swing.JTextField();
        lblNombreFamilia = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        treePadron = new org.jdesktop.swingx.JXTree();
        tbr = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();

        txtIngreso.setPreferredSize(new java.awt.Dimension(70, 22));

        lblNombreFamilia.setText("Nombre de la nueva familia");

        javax.swing.GroupLayout pnlIngresoLayout = new javax.swing.GroupLayout(pnlIngreso);
        pnlIngreso.setLayout(pnlIngresoLayout);
        pnlIngresoLayout.setHorizontalGroup(
            pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(txtIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlIngresoLayout.setVerticalGroup(
            pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreFamilia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setPreferredSize(new java.awt.Dimension(400, 400));
        setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treePadron.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        scroll.setViewportView(treePadron);

        add(scroll, java.awt.BorderLayout.CENTER);

        tbr.setFloatable(false);
        tbr.setOrientation(javax.swing.SwingConstants.VERTICAL);
        tbr.setRollover(true);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/New/New_16x16.png"))); // NOI18N
        btnNew.setToolTipText("Nueva familia");
        btnNew.setBorderPainted(false);
        btnNew.setFocusable(false);
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setRolloverEnabled(false);
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        tbr.add(btnNew);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Edit/Edit_16x16.png"))); // NOI18N
        btnEditar.setToolTipText("Editar familia seleccionada");
        btnEditar.setBorderPainted(false);
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setRolloverEnabled(false);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        tbr.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Remove/Remove_16x16.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar familia seleccionada");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setRolloverEnabled(false);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        tbr.add(btnEliminar);

        add(tbr, java.awt.BorderLayout.LINE_END);

        jXHeader1.setDescription("Familias");
        add(jXHeader1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        TreePath path = treePadron.getSelectionPath();
        if (path == null) {
            utils.Msg.msgWarning(this, "Seleccione una familia");
        } else {
            txtIngreso.setText("");
            txtIngreso.requestFocus();
            if (utils.Msg.msgQuestion(this, pnlIngreso)) {
                try {
                    if (txtIngreso.getText().trim().isEmpty()) {
                        utils.Msg.msgWarning(this, "La familia no puede tener un nombre vacío.");
                    } else {
                        Nodo padre = (Nodo) path.getLastPathComponent();
                        Nodo nodo = new Nodo(TipoNodo.nodoFamilia());
                        FamiliaReg familiaReg = new FamiliaReg();
                        familiaReg.setIdPadre(padre.getItem().getId());
                        familiaReg.setDescripcion(txtIngreso.getText().trim());
                        familiaReg.insert();
                        nodo.setItem(familiaReg);
                        padre.add(nodo);
                        treePadron.expandPath(path);
                        treePadron.updateUI();
                    }
                } catch (SQLException ex) {
                    Logger.log(Level.WARNING, ex);
                    utils.Msg.msgError(this, "Error al guardar la familia");
                }
            }
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        TreePath path = treePadron.getSelectionPath();
        if (path == null) {
            utils.Msg.msgWarning(this, "Seleccione una familia");
        } else {
            Nodo nodo = (Nodo) path.getLastPathComponent();
            if (!nodo.isLeaf()) {
                utils.Msg.msgWarning(this, "La familia tiene subfamilias");
            } else {
                if (utils.Msg.msgQuestion(this, "Confirma dar de baja la familia " + nodo.getItem().getDescripcion() + "?")) {
                    try {
                        nodo.getItem().drop();
                        ((Nodo) nodo.getParent()).remove(nodo);
                        treePadron.updateUI();
                    } catch (SQLException ex) {
                        Logger.log(Level.SEVERE, ex);
                        utils.Msg.msgError(this, "Error al dar de baja la familia");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        TreePath path = treePadron.getSelectionPath();
        if (path == null) {
            utils.Msg.msgWarning(this, "Seleccione una familia");
        } else {
            Nodo nodo = (Nodo) path.getLastPathComponent();
            txtIngreso.setText(nodo.getItem().getDescripcion());
             if (utils.Msg.msgQuestion(this, pnlIngreso)) {
                    try {
                        ItemReg item = nodo.getItem();
                        item.setDescripcion(txtIngreso.getText().trim());
                        item.save();
                        _inicializar();
                    } catch (SQLException ex) {
                        Logger.log(Level.SEVERE, ex);
                        utils.Msg.msgError(this, "Error al dar de baja la familia");
                    }
                }
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNew;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    private javax.swing.JLabel lblNombreFamilia;
    private javax.swing.JPanel pnlIngreso;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JToolBar tbr;
    private org.jdesktop.swingx.JXTree treePadron;
    private javax.swing.JTextField txtIngreso;
    // End of variables declaration//GEN-END:variables

    /**
     * inicializa los datos de las familias
     */
    private void _inicializar() {
        try {
            Nodo root = new Nodo(TipoNodo.nodoRoot());
            FamiliaReg familiaReg = new FamiliaReg();
            familiaReg.setDescripcion("Padrón");
            root.setItem(familiaReg);

            ArrayList<FamiliaReg> familias = FamiliaReg.familias();
            HashMap<Long, ArrayList<FamiliaReg>> hash = _crearHashMap(familias);
            _armarArbol(0, root, hash);

            treePadron.setModel(new TreePadronModel(root));
            treePadron.expandAll();
            treePadron.setCellRenderer(new RendererNodo());
        } catch (SQLException ex) {
            Logger.log(Level.WARNING, ex);
            utils.Msg.msgError(this, "No se pudieron obtener las familias.");
        }

    }

    /* crea un hash donde padre_id => Hijos */
    private HashMap<Long, ArrayList<FamiliaReg>> _crearHashMap(ArrayList<FamiliaReg> familias) {
        HashMap<Long, ArrayList<FamiliaReg>> hash = new HashMap<>();
        for (Iterator<FamiliaReg> it = familias.iterator(); it.hasNext();) {
            FamiliaReg f = it.next();
            if (!hash.containsKey(f.getIdPadre())) {
                hash.put(f.getIdPadre(), new ArrayList<FamiliaReg>());
            }
            hash.get(f.getIdPadre()).add(f);
        }
        return hash;
    }

    /* Procedimiento recurcivo que crea el árbol */
    private void _armarArbol(long padre_id, Nodo nodo, HashMap<Long, ArrayList<FamiliaReg>> hash) {
        ArrayList<FamiliaReg> children = hash.get(padre_id);
        if (children != null) {
            for (Iterator<FamiliaReg> it = children.iterator(); it.hasNext();) {
                FamiliaReg f = it.next();
                Nodo child = new Nodo(TipoNodo.nodoFamilia());
                child.setItem(f);
                nodo.add(child);
                _armarArbol(f.getId(), child, hash);
            }
        }
    }

    /**
     * Devuelve la familia seleccionada
     *
     * @return familia seleccionada
     */
    public FamiliaReg getSelectedFamilia() {
        TreePath path = treePadron.getSelectionPath();
        if (path == null) {
            return null;
        } else {
            return (FamiliaReg) ((Nodo) path.getLastPathComponent()).getItem();
        }
    }
}
