package padron.talles;

import ex.ConsistenciaException;
import ex.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import registros.padron.TalleReg;

/**
 *
 * @author fermani
 */
public class PnlTalles extends javax.swing.JPanel {

    public PnlTalles() {
        initComponents();
        tblTalles.setHorizontalScrollEnabled(true);
        tblTalles.setColumnControlVisible(true);
        _inicializar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIngreso = new javax.swing.JPanel();
        txtIngreso = new javax.swing.JTextField();
        lblNombreFamilia = new javax.swing.JLabel();
        hdrTituto = new org.jdesktop.swingx.JXHeader();
        tbrEstado = new javax.swing.JToolBar();
        lblInfoBarra = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tblTalles = new org.jdesktop.swingx.JXTable();
        tbrBotones = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();

        txtIngreso.setPreferredSize(new java.awt.Dimension(70, 22));

        lblNombreFamilia.setText("Talle");

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

        setLayout(new java.awt.BorderLayout());

        hdrTituto.setDescription("Talles");
        add(hdrTituto, java.awt.BorderLayout.PAGE_START);

        tbrEstado.setFloatable(false);
        tbrEstado.setRollover(true);

        lblInfoBarra.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblInfoBarra.setText("<html><font color='red'>Info</font></html>");
        lblInfoBarra.setPreferredSize(new java.awt.Dimension(19, 15));
        tbrEstado.add(lblInfoBarra);

        add(tbrEstado, java.awt.BorderLayout.PAGE_END);

        tblTalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTalles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblTallesKeyReleased(evt);
            }
        });
        scroll.setViewportView(tblTalles);

        add(scroll, java.awt.BorderLayout.CENTER);

        tbrBotones.setFloatable(false);
        tbrBotones.setOrientation(javax.swing.SwingConstants.VERTICAL);
        tbrBotones.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/New/New_16x16.png"))); // NOI18N
        btnNuevo.setBorderPainted(false);
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        tbrBotones.add(btnNuevo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Edit/Edit_16x16.png"))); // NOI18N
        btnEditar.setToolTipText("Editar registro seleccionado");
        btnEditar.setBorderPainted(false);
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        tbrBotones.add(btnEditar);

        btnBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Delete/Delete_16x16.png"))); // NOI18N
        btnBaja.setToolTipText("Dar de bajas los registros seleccionados");
        btnBaja.setBorderPainted(false);
        btnBaja.setFocusable(false);
        btnBaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });
        tbrBotones.add(btnBaja);

        add(tbrBotones, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void tblTallesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTallesKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_DELETE) {
            int op = JOptionPane.showInternalConfirmDialog(this, "Confirma dar de baja el talle seleccionado?", "Confirmación.", JOptionPane.OK_CANCEL_OPTION);

        }
    }//GEN-LAST:event_tblTallesKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtIngreso.setText("");
        txtIngreso.requestFocus();
        int op = JOptionPane.showInternalConfirmDialog(this, pnlIngreso, "Ingreso", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            if (txtIngreso.getText().trim().isEmpty()) {
                JOptionPane.showInternalMessageDialog(this, "No", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String sTalle = txtIngreso.getText().trim().toUpperCase();
            if (sTalle.isEmpty()) {
                JOptionPane.showInternalMessageDialog(this, "Descripcion nula", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    TalleReg talle = new TalleReg();
                    talle.setDescripcion(sTalle);
                    talle.save();
                    _inicializar();
                } catch (SQLException ex) {
                    Logger.log(Level.SEVERE, ex);
                    JOptionPane.showInternalMessageDialog(this, "No se pudo guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblTalles.getSelectedRow() == -1 || tblTalles.convertRowIndexToModel(tblTalles.getSelectedRow()) == -1) {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un talle.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            TallesTablaModel model = (TallesTablaModel) tblTalles.getModel();
            TalleReg talle = model.getRow(tblTalles.convertRowIndexToModel(tblTalles.getSelectedRow()));
            String descAnterior = talle.getDescripcion();
            txtIngreso.setText(talle.getDescripcion());
            txtIngreso.requestFocus();
            int op = JOptionPane.showInternalConfirmDialog(this, pnlIngreso, "Ingreso", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                if (txtIngreso.getText().trim().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(this, "No", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String sTalle = txtIngreso.getText().trim().toUpperCase();
                if (sTalle.isEmpty()) {
                    JOptionPane.showInternalMessageDialog(this, "Descripcion nula", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        talle.setDescripcion(sTalle);
                        talle.save();
                        model.fireTableDataChanged();
                    } catch (SQLException ex) {
                        Logger.log(Level.SEVERE, ex);
                        talle.setDescripcion(descAnterior);
                        JOptionPane.showInternalMessageDialog(this, "No se pudo guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        if (tblTalles.getSelectedRow() == -1 || tblTalles.convertRowIndexToModel(tblTalles.getSelectedRow()) == -1) {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un talle.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int[] rows = tblTalles.getSelectedRows();
            ArrayList<TalleReg> bajas = new ArrayList<>(tblTalles.getSelectedRowCount());
            TallesTablaModel model = (TallesTablaModel) tblTalles.getModel();
            for (int i = 0; i < rows.length; i++) {
                int pos = tblTalles.convertRowIndexToModel(rows[i]);
                bajas.add(model.getRow(pos));
            }
            int op = JOptionPane.showInternalConfirmDialog(this, "Confirma dar de baja " + tblTalles.getSelectedRowCount() + " registro/s?", "Confirmación.", JOptionPane.OK_CANCEL_OPTION);
            if (op == JOptionPane.OK_OPTION) {
                try {
                    TalleReg.bajas(bajas);
                    _inicializar();
                } catch (SQLException ex) {
                    Logger.log(Level.SEVERE, ex);
                    JOptionPane.showInternalMessageDialog(this, "No se pudieron dar de baja el/los registro/s.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        }
    }//GEN-LAST:event_btnBajaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private org.jdesktop.swingx.JXHeader hdrTituto;
    private javax.swing.JLabel lblInfoBarra;
    private javax.swing.JLabel lblNombreFamilia;
    private javax.swing.JPanel pnlIngreso;
    private javax.swing.JScrollPane scroll;
    private org.jdesktop.swingx.JXTable tblTalles;
    private javax.swing.JToolBar tbrBotones;
    private javax.swing.JToolBar tbrEstado;
    private javax.swing.JTextField txtIngreso;
    // End of variables declaration//GEN-END:variables

    private void _inicializar() {
        try {
            ArrayList<TalleReg> talles = TalleReg.talles();
            tblTalles.setModel(new TallesTablaModel(talles));
            tblTalles.updateUI();
            lblInfoBarra.setText("Cantidad de registros: " + talles.size());
        } catch (SQLException ex) {
            Logger.log(Level.WARNING, ex);
            JOptionPane.showInternalMessageDialog(this, "No se pudieron obtener las marcas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void _consistencia() throws ConsistenciaException {
    }
}
