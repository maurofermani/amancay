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
    private ArrayList<Double> bck;

    public PnlPrecios() {
        initComponents();
    }

    public void setArticulo(ArticuloReg articulo) {
        if (articulo != null) {
            try {
                this.articulo = articulo;
                precios = articulo.getPrecios();
                cambios = new ArrayList<>(precios.size());
                bck = new ArrayList<>(precios.size());
//                for (int i = 0; i < precios.size(); i++) {
//                    cambios.add(Boolean.FALSE);
//                    bck.add(precios);
//                }
                for (Iterator<PrecioReg> it = precios.iterator(); it.hasNext();) {
                    bck.add(it.next().getPrecio());
                    cambios.add(Boolean.FALSE);
                }
                tblPrecios.setModel(new PreciosTableModel(precios, cambios));
                tblPrecios.packAll();
            } catch (SQLException ex) {
                utils.Msg.msgException(this, ex);
            }
        } else {
            tblPrecios.setModel(new PreciosTableModel(new ArrayList<PrecioReg>(), new ArrayList<Boolean>()));
            tblPrecios.packAll();
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
        scrollPrecios = new javax.swing.JScrollPane();
        tblPrecios = new org.jdesktop.swingx.JXTable();
        tbr = new javax.swing.JToolBar();
        btnNuevoPrecio = new javax.swing.JButton();
        btnBajaPrecio = new javax.swing.JButton();

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

        scrollPrecios.setBorder(javax.swing.BorderFactory.createTitledBorder("Talles"));

        tblPrecios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPrecios.setViewportView(tblPrecios);

        add(scrollPrecios, java.awt.BorderLayout.CENTER);

        tbr.setFloatable(false);
        tbr.setOrientation(javax.swing.SwingConstants.VERTICAL);
        tbr.setRollover(true);

        btnNuevoPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/22x22/actions/filenew.png"))); // NOI18N
        btnNuevoPrecio.setToolTipText("Nueva familia");
        btnNuevoPrecio.setBorderPainted(false);
        btnNuevoPrecio.setFocusable(false);
        btnNuevoPrecio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoPrecio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPrecioActionPerformed(evt);
            }
        });
        tbr.add(btnNuevoPrecio);

        btnBajaPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/22x22/actions/editdelete.png"))); // NOI18N
        btnBajaPrecio.setToolTipText("Eliminar familia seleccionada");
        btnBajaPrecio.setBorderPainted(false);
        btnBajaPrecio.setFocusable(false);
        btnBajaPrecio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBajaPrecio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBajaPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaPrecioActionPerformed(evt);
            }
        });
        tbr.add(btnBajaPrecio);

        add(tbr, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPrecioActionPerformed
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
                    ((PreciosTableModel) tblPrecios.getModel()).fireTableDataChanged();
                    cambios.add(Boolean.TRUE);
                    tblPrecios.packAll();
                }
            } catch (SQLException ex) {
                utils.Msg.msgException(this, ex);
            }
        }
    }//GEN-LAST:event_btnNuevoPrecioActionPerformed

    private void btnBajaPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaPrecioActionPerformed
        if (articulo == null) {
            utils.Msg.msgWarning(this, "Seleccione un artículo");
        } else {
            int row = tblPrecios.getSelectedRow();
            if (row != -1 && tblPrecios.convertRowIndexToModel(row) != -1) {
                row = tblPrecios.convertRowIndexToModel(row);
                //dar de baja un precio seleccionado
                PreciosTableModel model = (PreciosTableModel) tblPrecios.getModel();
                PrecioReg precio = model.getRow(row);
                if (!precio.isNew()) {
                    try {
                        precio.drop();
                        precios.remove(precio);
                    } catch (SQLException ex) {
                        utils.Msg.msgException(this, ex);
                    }
                } else {
                    precios.remove(precio);
                }
            } else {
                utils.Msg.msgWarning(this, "Seleccione un precio a borrar");
            }
        }
    }//GEN-LAST:event_btnBajaPrecioActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBajaPrecio;
    private javax.swing.JButton btnNuevoPrecio;
    private javax.swing.JComboBox cboTalles;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTalle;
    private javax.swing.JPanel pnlIngreso;
    private javax.swing.JScrollPane scrollPrecios;
    private javax.swing.JSpinner spnPrecio;
    private org.jdesktop.swingx.JXTable tblPrecios;
    private javax.swing.JToolBar tbr;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        btnBajaPrecio.setEnabled(enabled);
        btnNuevoPrecio.setEnabled(enabled);
        tblPrecios.setEditable(enabled);
    }

    public void guardar() throws SQLException {
        int i = 0;
        for (Iterator<Boolean> it = cambios.iterator(); it.hasNext();) {
            if (it.next()) {
                precios.get(i).save();
            }
            i++;
        }
    }
    
    public void cancelar() {
        int i = 0;
        for (Iterator<Boolean> it = cambios.iterator(); it.hasNext();) {
            if (it.next()) {
                precios.get(i).setPrecio(bck.get(i));
            }
            i++;
        }
        ((PreciosTableModel) tblPrecios.getModel()).fireTableDataChanged();
        tblPrecios.packAll();
    }
}
