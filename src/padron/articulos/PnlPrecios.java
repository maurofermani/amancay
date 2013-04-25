package padron.articulos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import registros.padron.ArticuloReg;
import registros.padron.PrecioReg;
import registros.padron.TalleReg;

/**
 *
 * @author fermani
 */
public class PnlPrecios extends javax.swing.JPanel {

    private ArticuloReg articulo;
    private ArrayList<PrecioReg> precios;
    private ArrayList<Boolean> cambios;

    public PnlPrecios() {
        initComponents();
    }

    public void setArticulo(ArticuloReg articulo) {
        if (articulo != null) {
            try {
                this.articulo = articulo;
                precios = articulo.precios();
                cambios = new ArrayList<>(precios.size());
                for (int i = 0; i < precios.size(); i++) {
                    cambios.add(Boolean.FALSE);
                }
                tblStock.setModel(new PreciosTableModel(precios, cambios));
                tblStock.packAll();
            } catch (SQLException ex) {
                utils.Msg.msgException(this, ex);
            }
        } else {
            tblStock.setModel(new PreciosTableModel(new ArrayList<PrecioReg>(), new ArrayList<Boolean>()));
            tblStock.packAll();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIngreso = new javax.swing.JPanel();
        lblTalle = new javax.swing.JLabel();
        cboTalles = new javax.swing.JComboBox();
        lblPrecio = new javax.swing.JLabel();
        spnPrecio = new javax.swing.JSpinner();
        scrollStock = new javax.swing.JScrollPane();
        tblStock = new org.jdesktop.swingx.JXTable();
        tbr = new javax.swing.JToolBar();
        btnNuevoTalle = new javax.swing.JButton();
        btnBajaTalle = new javax.swing.JButton();

        lblTalle.setText("Talle");
        lblTalle.setPreferredSize(new java.awt.Dimension(60, 25));

        lblPrecio.setText("Precio");
        lblPrecio.setPreferredSize(new java.awt.Dimension(60, 25));

        spnPrecio.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        spnPrecio.setPreferredSize(new java.awt.Dimension(28, 24));

        javax.swing.GroupLayout pnlIngresoLayout = new javax.swing.GroupLayout(pnlIngreso);
        pnlIngreso.setLayout(pnlIngresoLayout);
        pnlIngresoLayout.setHorizontalGroup(
            pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoLayout.createSequentialGroup()
                .addGroup(pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTalles, 0, 136, Short.MAX_VALUE)
                    .addComponent(spnPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlIngresoLayout.setVerticalGroup(
            pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoLayout.createSequentialGroup()
                .addGroup(pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTalles, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setLayout(new java.awt.BorderLayout());

        scrollStock.setBorder(javax.swing.BorderFactory.createTitledBorder("Talles"));

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollStock.setViewportView(tblStock);

        add(scrollStock, java.awt.BorderLayout.CENTER);

        tbr.setFloatable(false);
        tbr.setOrientation(javax.swing.SwingConstants.VERTICAL);
        tbr.setRollover(true);

        btnNuevoTalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/New/New_16x16.png"))); // NOI18N
        btnNuevoTalle.setToolTipText("Nueva familia");
        btnNuevoTalle.setBorderPainted(false);
        btnNuevoTalle.setFocusable(false);
        btnNuevoTalle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoTalle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoTalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTalleActionPerformed(evt);
            }
        });
        tbr.add(btnNuevoTalle);

        btnBajaTalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Remove/Remove_16x16.png"))); // NOI18N
        btnBajaTalle.setToolTipText("Eliminar familia seleccionada");
        btnBajaTalle.setBorderPainted(false);
        btnBajaTalle.setFocusable(false);
        btnBajaTalle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBajaTalle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBajaTalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaTalleActionPerformed(evt);
            }
        });
        tbr.add(btnBajaTalle);

        add(tbr, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoTalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTalleActionPerformed
        if (articulo == null) {
            utils.Msg.msgWarning(this, "Seleccione un artículo");
        } else {
            try {
                cboTalles.setModel(new DefaultComboBoxModel(articulo.tallesLibres().toArray()));
                if (utils.Msg.msgQuestion(db.Session.frameSelected(), pnlIngreso, "Nuevo talle", utils.Msg.PLAIN_MESSAGE)) {
                    TalleReg talleReg = (TalleReg) cboTalles.getSelectedItem();
                    PrecioReg precioReg = new PrecioReg();
                    precioReg.setArticuloReg(articulo);
                    precioReg.setTalleReg(talleReg);
                    precioReg.setPrecio((Double) spnPrecio.getValue());
                    precios.add(precioReg);
                    ((PreciosTableModel) tblStock.getModel()).fireTableDataChanged();
                    cambios.add(Boolean.TRUE);
                    tblStock.packAll();
                }
            } catch (SQLException ex) {
                utils.Msg.msgException(this, ex);
            }
        }
    }//GEN-LAST:event_btnNuevoTalleActionPerformed

    private void btnBajaTalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaTalleActionPerformed
        if (articulo == null) {
            utils.Msg.msgWarning(this, "Seleccione un artículo");
        } else {
            //dar de baja un talle seleccionado
        }
    }//GEN-LAST:event_btnBajaTalleActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBajaTalle;
    private javax.swing.JButton btnNuevoTalle;
    private javax.swing.JComboBox cboTalles;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTalle;
    private javax.swing.JPanel pnlIngreso;
    private javax.swing.JScrollPane scrollStock;
    private javax.swing.JSpinner spnPrecio;
    private org.jdesktop.swingx.JXTable tblStock;
    private javax.swing.JToolBar tbr;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        btnBajaTalle.setEnabled(enabled);
        btnNuevoTalle.setEnabled(enabled);
        tblStock.setEditable(enabled);
    }

    public void guardar() throws SQLException {
        int i = 0;
        for (Iterator<Boolean> it = cambios.iterator(); it.hasNext();) {
            if (it.next()) {
                precios.get(i).save();
                i++;
            }
        }
    }
}
