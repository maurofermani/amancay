package padron.articulos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import registros.padron.ArticuloReg;
import registros.padron.CostoReg;
import registros.padron.TalleReg;

/**
 *
 * @author fermani
 */
public class PnlCostos extends javax.swing.JPanel {

    private ArticuloReg articulo;
    private ArrayList<CostoReg> costos;
    private ArrayList<Boolean> cambios;
    private ArrayList<Double> bck;

    public PnlCostos() {
        initComponents();
    }

    public void setArticulo(ArticuloReg articulo) {
        if (articulo != null) {
            try {
                this.articulo = articulo;
                costos = articulo.getCostos();
                cambios = new ArrayList<>(costos.size());
                bck = new ArrayList<>(costos.size());
//                for (int i = 0; i < costos.size(); i++) {
//                    cambios.add(Boolean.FALSE);
//                    bck.add(costos);
//                }
                for (Iterator<CostoReg> it = costos.iterator(); it.hasNext();) {
                    bck.add(it.next().getCosto());
                    cambios.add(Boolean.FALSE);
                }
                tblCostos.setModel(new CostosTableModel(costos, cambios));
                tblCostos.packAll();
            } catch (SQLException ex) {
                utils.Msg.msgException(this, ex);
            }
        } else {
            tblCostos.setModel(new CostosTableModel(new ArrayList<CostoReg>(), new ArrayList<Boolean>()));
            tblCostos.packAll();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIngreso = new javax.swing.JPanel();
        lblTalle = new javax.swing.JLabel();
        cboTalles = new javax.swing.JComboBox();
        lblCosto = new javax.swing.JLabel();
        spnCosto = new javax.swing.JSpinner();
        scrollCostos = new javax.swing.JScrollPane();
        tblCostos = new org.jdesktop.swingx.JXTable();
        tbr = new javax.swing.JToolBar();
        btnNuevoCosto = new javax.swing.JButton();
        btnBajaCosto = new javax.swing.JButton();

        lblTalle.setText("Talle");
        lblTalle.setPreferredSize(new java.awt.Dimension(60, 25));

        lblCosto.setText("Costo");
        lblCosto.setPreferredSize(new java.awt.Dimension(60, 25));

        spnCosto.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        spnCosto.setPreferredSize(new java.awt.Dimension(28, 24));

        javax.swing.GroupLayout pnlIngresoLayout = new javax.swing.GroupLayout(pnlIngreso);
        pnlIngreso.setLayout(pnlIngresoLayout);
        pnlIngresoLayout.setHorizontalGroup(
            pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoLayout.createSequentialGroup()
                .addGroup(pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTalles, 0, 136, Short.MAX_VALUE)
                    .addComponent(spnCosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlIngresoLayout.setVerticalGroup(
            pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoLayout.createSequentialGroup()
                .addGroup(pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTalles, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setLayout(new java.awt.BorderLayout());

        scrollCostos.setBorder(javax.swing.BorderFactory.createTitledBorder("Talles"));

        tblCostos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollCostos.setViewportView(tblCostos);

        add(scrollCostos, java.awt.BorderLayout.CENTER);

        tbr.setFloatable(false);
        tbr.setOrientation(javax.swing.SwingConstants.VERTICAL);
        tbr.setRollover(true);

        btnNuevoCosto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/22x22/actions/filenew.png"))); // NOI18N
        btnNuevoCosto.setToolTipText("Nueva familia");
        btnNuevoCosto.setBorderPainted(false);
        btnNuevoCosto.setFocusable(false);
        btnNuevoCosto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoCosto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCostoActionPerformed(evt);
            }
        });
        tbr.add(btnNuevoCosto);

        btnBajaCosto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/22x22/actions/editdelete.png"))); // NOI18N
        btnBajaCosto.setToolTipText("Eliminar familia seleccionada");
        btnBajaCosto.setBorderPainted(false);
        btnBajaCosto.setFocusable(false);
        btnBajaCosto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBajaCosto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBajaCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaCostoActionPerformed(evt);
            }
        });
        tbr.add(btnBajaCosto);

        add(tbr, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCostoActionPerformed
        if (articulo == null) {
            utils.Msg.msgWarning(this, "Seleccione un artículo");
        } else {
            try {
                cboTalles.setModel(new DefaultComboBoxModel(articulo.tallesLibres().toArray()));
                if (utils.Msg.msgQuestion(db.Session.frameSelected(), pnlIngreso, "Nuevo talle", utils.Msg.PLAIN_MESSAGE)) {
                    TalleReg talleReg = (TalleReg) cboTalles.getSelectedItem();
                    CostoReg costoReg = new CostoReg();
                    costoReg.setArticuloReg(articulo);
                    costoReg.setTalleReg(talleReg);
                    costoReg.setCosto((Double) spnCosto.getValue());
                    costos.add(costoReg);
                    ((CostosTableModel) tblCostos.getModel()).fireTableDataChanged();
                    cambios.add(Boolean.TRUE);
                    tblCostos.packAll();
                }
            } catch (SQLException ex) {
                utils.Msg.msgException(this, ex);
            }
        }
    }//GEN-LAST:event_btnNuevoCostoActionPerformed

    private void btnBajaCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaCostoActionPerformed
        if (articulo == null) {
            utils.Msg.msgWarning(this, "Seleccione un artículo");
        } else {
            int row = tblCostos.getSelectedRow();
            if (row != -1 && tblCostos.convertRowIndexToModel(row) != -1) {
                row = tblCostos.convertRowIndexToModel(row);
                //dar de baja el costo seleccionado
                CostosTableModel model = (CostosTableModel) tblCostos.getModel();
                CostoReg costo = model.getRow(row);
                if (!costo.isNew()) {
                    try {
                        costo.drop();
                        costos.remove(costo);
                    } catch (SQLException ex) {
                        utils.Msg.msgException(this, ex);
                    }
                } else {
                    costos.remove(costo);
                }
                ((CostosTableModel) tblCostos.getModel()).fireTableDataChanged();
                tblCostos.packAll();
            } else {
                utils.Msg.msgWarning(this, "Seleccione el costo a borrar");
            }
        }
    }//GEN-LAST:event_btnBajaCostoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBajaCosto;
    private javax.swing.JButton btnNuevoCosto;
    private javax.swing.JComboBox cboTalles;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblTalle;
    private javax.swing.JPanel pnlIngreso;
    private javax.swing.JScrollPane scrollCostos;
    private javax.swing.JSpinner spnCosto;
    private org.jdesktop.swingx.JXTable tblCostos;
    private javax.swing.JToolBar tbr;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        btnBajaCosto.setEnabled(enabled);
        btnNuevoCosto.setEnabled(enabled);
        tblCostos.setEditable(enabled);
    }

    public void guardar() throws SQLException {
        int i = 0;
        for (Iterator<Boolean> it = cambios.iterator(); it.hasNext();) {
            if (it.next()) {
                costos.get(i).save();
            }
            i++;
        }
    }
    
    public void cancelar() {
        int i = 0;
        for (Iterator<Boolean> it = cambios.iterator(); it.hasNext();) {
            if (it.next()) {
                costos.get(i).setCosto(bck.get(i));
            }
            i++;
        }
        ((CostosTableModel) tblCostos.getModel()).fireTableDataChanged();
        tblCostos.packAll();
    }
}
