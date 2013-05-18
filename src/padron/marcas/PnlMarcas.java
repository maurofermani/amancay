package padron.marcas;

import ex.ConsistenciaException;
import ex.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import registros.padron.MarcaReg;

/**
 *
 * @author fermani
 */
public class PnlMarcas extends javax.swing.JPanel {

    private static final short MODO_SELECCION = 0;
    private static final short MODO_ALTA = 1;
    private static final short MODO_BAJA = 2;
    private static final short MODO_EDICION = 3;
    private MarcaReg marcaSelected;
    private short modo = MODO_SELECCION;

    public PnlMarcas() {
        initComponents();
        tblMarcas.setHorizontalScrollEnabled(true);
        tblMarcas.setColumnControlVisible(true);
        tblMarcas.packAll();
        tblMarcas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                MarcasTablaModel model = (MarcasTablaModel) tblMarcas.getModel();
                int pos = tblMarcas.getSelectedRow();
                if (pos != -1) {
                    pos = tblMarcas.convertRowIndexToModel(pos);
                }
                if (pos == -1) {
                    _setRegistro(null);
                } else {
                    MarcaReg marca = model.getRow(pos);
                    _setRegistro(marca);
                }
            }
        });
        _inicializar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hdrTituto = new org.jdesktop.swingx.JXHeader();
        split = new javax.swing.JSplitPane();
        pnlMarca = new javax.swing.JPanel();
        tbrBotones = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlDatos = new javax.swing.JPanel();
        lblDescipcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblNro = new javax.swing.JLabel();
        txtNro = new javax.swing.JTextField();
        lblAlias = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();
        scrollTabla = new javax.swing.JScrollPane();
        tblMarcas = new org.jdesktop.swingx.JXTable();
        tbrEstado = new javax.swing.JToolBar();
        lblInfoBarra = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        hdrTituto.setDescription("Marcas");
        add(hdrTituto, java.awt.BorderLayout.PAGE_START);

        split.setDividerLocation(150);

        pnlMarca.setLayout(new java.awt.BorderLayout());

        tbrBotones.setFloatable(false);
        tbrBotones.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/32x32/actions/bookmark-new.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setMaximumSize(new java.awt.Dimension(75, 75));
        btnNuevo.setMinimumSize(new java.awt.Dimension(65, 65));
        btnNuevo.setPreferredSize(new java.awt.Dimension(65, 65));
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        tbrBotones.add(btnNuevo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/32x32/apps/accessories-text-editor.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setMaximumSize(new java.awt.Dimension(75, 75));
        btnEditar.setMinimumSize(new java.awt.Dimension(65, 65));
        btnEditar.setPreferredSize(new java.awt.Dimension(65, 65));
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        tbrBotones.add(btnEditar);

        btnBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/32x32/actions/editdelete.png"))); // NOI18N
        btnBaja.setText("Baja");
        btnBaja.setFocusable(false);
        btnBaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBaja.setMaximumSize(new java.awt.Dimension(75, 75));
        btnBaja.setMinimumSize(new java.awt.Dimension(65, 65));
        btnBaja.setPreferredSize(new java.awt.Dimension(65, 65));
        btnBaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });
        tbrBotones.add(btnBaja);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/32x32/actions/gtk-cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setMaximumSize(new java.awt.Dimension(75, 75));
        btnCancelar.setMinimumSize(new java.awt.Dimension(65, 65));
        btnCancelar.setPreferredSize(new java.awt.Dimension(65, 65));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        tbrBotones.add(btnCancelar);

        pnlMarca.add(tbrBotones, java.awt.BorderLayout.PAGE_START);

        lblDescipcion.setText("Descripcion");
        lblDescipcion.setPreferredSize(new java.awt.Dimension(82, 22));

        txtDescripcion.setPreferredSize(new java.awt.Dimension(70, 22));

        lblNro.setText("Nro");
        lblNro.setPreferredSize(new java.awt.Dimension(82, 22));

        txtNro.setEditable(false);
        txtNro.setPreferredSize(new java.awt.Dimension(70, 22));

        lblAlias.setText("Alias");
        lblAlias.setPreferredSize(new java.awt.Dimension(82, 22));

        txtAlias.setPreferredSize(new java.awt.Dimension(70, 22));
        txtAlias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAliasFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(lblDescipcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(lblNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(lblAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescipcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        pnlMarca.add(pnlDatos, java.awt.BorderLayout.CENTER);

        split.setRightComponent(pnlMarca);

        tblMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollTabla.setViewportView(tblMarcas);

        split.setLeftComponent(scrollTabla);

        add(split, java.awt.BorderLayout.CENTER);

        tbrEstado.setFloatable(false);
        tbrEstado.setRollover(true);

        lblInfoBarra.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblInfoBarra.setText("<html><font color='red'>Info</font></html>");
        lblInfoBarra.setPreferredSize(new java.awt.Dimension(19, 15));
        tbrEstado.add(lblInfoBarra);

        add(tbrEstado, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (modo == MODO_SELECCION) {
            _setRegistro(new MarcaReg());
            _setModo(MODO_ALTA);
        } else if (modo == MODO_ALTA) {
            try {
                _consistencia();
                _guardar();
                long idMarca = marcaSelected.getId();
                _inicializar();
                _setRegistro(idMarca);
            } catch (ConsistenciaException ex) {
                utils.Msg.msgWarning(this, ex.getMessage(), "Consistencia");
                ex.getError().requestFocus();
            } catch (SQLException ex) {
                utils.Msg.msgException(this, ex, "No se pudieron guardar los datos.");
            }
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (marcaSelected == null) {
            utils.Msg.msgWarning(this, "Seleccione una marca a editar.");
        } else if (modo == MODO_SELECCION) {
            _setRegistro(marcaSelected);
            _setModo(MODO_EDICION);
        } else if (modo == MODO_EDICION) {
            try {
                _consistencia();
                _guardar();
                long idMarca = marcaSelected.getId();
                _inicializar();
                _setRegistro(idMarca);
            } catch (ConsistenciaException ex) {
                utils.Msg.msgWarning(this, ex.getMessage(), "Consistencia");
                ex.getError().requestFocus();
            } catch (SQLException ex) {
                utils.Msg.msgException(this, ex, "No se pudieron guardar los datos.");
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (modo == MODO_ALTA) {
            MarcasTablaModel model = (MarcasTablaModel) tblMarcas.getModel();
            int pos = tblMarcas.getSelectedRow();
            if (pos != -1) {
                pos = tblMarcas.convertRowIndexToModel(pos);
            }
            if (pos == -1) {
                _setRegistro(null);
            } else {
                MarcaReg marca = model.getRow(pos);
                _setRegistro(marca);
            }
        } else {
            _setRegistro(marcaSelected);
        }
        _setModo(MODO_SELECCION);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtAliasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAliasFocusLost
        String str = txtAlias.getText().trim();
        if (str.length() > 3) {
            str = str.substring(0, 3).toUpperCase();
        } else {
            str = String.format("%1$-3s", str).replace(' ', '_').toUpperCase();
        }
        txtAlias.setText(str);
    }//GEN-LAST:event_txtAliasFocusLost

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        if (marcaSelected == null) {
            utils.Msg.msgWarning(this, "Seleccione una marca a editar.");
        } else {
            if (utils.Msg.msgQuestion(this, "Dar de baja la marca '" + marcaSelected.getDescripcion() + "'?")) {
                try {
                    marcaSelected.drop();
                    _inicializar();
                } catch (SQLException ex) {
                    utils.Msg.msgException(this, ex, "No se pudo dar de baja la marca.");
                }
            }
        }
    }//GEN-LAST:event_btnBajaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private org.jdesktop.swingx.JXHeader hdrTituto;
    private javax.swing.JLabel lblAlias;
    private javax.swing.JLabel lblDescipcion;
    private javax.swing.JLabel lblInfoBarra;
    private javax.swing.JLabel lblNro;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlMarca;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JSplitPane split;
    private org.jdesktop.swingx.JXTable tblMarcas;
    private javax.swing.JToolBar tbrBotones;
    private javax.swing.JToolBar tbrEstado;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNro;
    // End of variables declaration//GEN-END:variables

    private void _inicializar() {
        _setModo(MODO_SELECCION);
        try {
            ArrayList<MarcaReg> marcas = MarcaReg.marcas();
            tblMarcas.setModel(new MarcasTablaModel(marcas));
            lblInfoBarra.setText("Cantidad de registros: " + marcas.size());
            tblMarcas.packAll();
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, ex);
            utils.Msg.msgError(this, "No se pudieron obtener las marcas.");
        }
    }

    private void _setModo(short modo) {
        this.modo = modo;
        switch (modo) {
            case MODO_SELECCION:
                txtDescripcion.setEditable(false);
                txtAlias.setEditable(false);
                btnBaja.setEnabled(true);
                btnEditar.setEnabled(true);
                btnNuevo.setEnabled(true);
                tblMarcas.setEnabled(true);
                btnCancelar.setEnabled(false);
                btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/32x32/actions/bookmark-new.png")));
                btnNuevo.setText("Nuevo");
                btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/32x32/apps/accessories-text-editor.png")));
                btnEditar.setText("Editar");
                lblInfoBarra.setText("Modo selección.");
                break;
            case MODO_BAJA:
                txtDescripcion.setEditable(false);
                txtAlias.setEditable(false);
                btnBaja.setEnabled(false);
                btnEditar.setEnabled(false);
                btnNuevo.setEnabled(false);
                tblMarcas.setEnabled(false);
                btnCancelar.setEnabled(true);
                lblInfoBarra.setText("<html><font color='red'>Modo baja.</font></html>");
                break;
            case MODO_ALTA:
                txtDescripcion.setEditable(true);
                txtAlias.setEditable(true);
                btnBaja.setEnabled(false);
                btnEditar.setEnabled(false);
                btnNuevo.setEnabled(true);
                btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/32x32/apps/accessories-text-editor.png")));
                btnNuevo.setText("Cuardar");
                tblMarcas.setEnabled(false);
                btnCancelar.setEnabled(true);
                lblInfoBarra.setText("<html><font color='green'>Modo alta.</font></html>");
                break;
            case MODO_EDICION:
                txtDescripcion.setEditable(true);
                txtAlias.setEditable(true);
                btnBaja.setEnabled(false);
                btnEditar.setEnabled(true);
                btnNuevo.setEnabled(false);
                btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/32x32/apps/accessories-text-editor.png")));
                btnEditar.setText("Cuardar");
                tblMarcas.setEnabled(false);
                btnCancelar.setEnabled(true);
                lblInfoBarra.setText("<html><font color='green'>Modo edición.</font></html>");
                break;
            default:
                throw new AssertionError("Modo inexistente");
        }
    }

    private void _setRegistro(MarcaReg marca) {
        this.marcaSelected = marca;
        if (marca == null) {
            txtDescripcion.setText("");
            txtAlias.setText("");
            txtNro.setText("");
        } else {
            txtDescripcion.setText(marca.getDescripcion());
            txtAlias.setText(marca.getAlias());
            txtNro.setText(marca.nroMarca());
        }
    }

    private void _setRegistro(long idMarca) {
        MarcasTablaModel model = (MarcasTablaModel) tblMarcas.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            MarcaReg marca = model.getRow(i);
            if (marca.getId() == idMarca) {
                _setRegistro(marca);
                tblMarcas.setRowSelectionInterval(i, i);
            }
        }
    }

    private void _guardar() throws SQLException {
        marcaSelected.setDescripcion(txtDescripcion.getText().trim());
        marcaSelected.setAlias(txtAlias.getText().toString());
        marcaSelected.save();
    }

    private void _consistencia() throws ConsistenciaException {
        if (txtDescripcion.getText().trim().isEmpty()) {
            throw new ConsistenciaException("Ingrese una descripcion.", txtDescripcion);
        } else if (txtAlias.getText().length() != 3 || _caracterInvalido(txtAlias.getText())) {
            throw new ConsistenciaException("El alias debe ser de exatamente 3 letras.", txtAlias);
        }
    }

    private boolean _caracterInvalido(String text) {
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (!Character.isLetter(ch) && !Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}
