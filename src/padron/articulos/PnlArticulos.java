package padron.articulos;

import ex.ConsistenciaException;
import ex.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import padron.familias.PnlFamilias;
import registros.padron.ArticuloReg;
import registros.padron.FamiliaReg;
import registros.padron.MarcaReg;

/**
 *
 * @author fermani
 */
public class PnlArticulos extends javax.swing.JPanel {

    private static final short MODO_SELECCION = 0;
    private static final short MODO_ALTA = 1;
    private static final short MODO_BAJA = 2;
    private static final short MODO_EDICION = 3;
    private ArticuloReg artSeleccionado;
    private short modo = MODO_SELECCION;
    private FamiliaReg familiaSel;

    public PnlArticulos() {
        try {
            initComponents();
            tblArticulos.setHorizontalScrollEnabled(true);
            tblArticulos.setColumnControlVisible(true);
            tblArticulos.packAll();
            tblArticulos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        ArticulosTableModel model = (ArticulosTableModel) tblArticulos.getModel();
                        int pos = tblArticulos.getSelectedRow();
                        if (pos != -1) {
                            pos = tblArticulos.convertRowIndexToModel(pos);
                        }
                        if (pos == -1) {
                            _setRegistro(null);
                        } else {
                            ArticuloReg articuloReg = model.getRow(pos);
                            _setRegistro(articuloReg);
                        }
                    }
                }
            });
            _inicializar();
        } catch (SQLException ex) {
            utils.Msg.msgException(this, ex, "Error al traer las marcas.");
        }
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
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNroSerie = new javax.swing.JLabel();
        txtNroSerie = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        cboMarca = new javax.swing.JComboBox();
        lblFamilia = new javax.swing.JLabel();
        txtFamilia = new javax.swing.JTextField();
        pnlStock = new padron.articulos.PnlPrecios();
        pnlSeleccion = new javax.swing.JPanel();
        scrollTabla = new javax.swing.JScrollPane();
        tblArticulos = new org.jdesktop.swingx.JXTable();
        pnlFiltro = new javax.swing.JPanel();
        btnFiltroFamilia = new javax.swing.JButton();
        tbrEstado = new javax.swing.JToolBar();
        lblInfoBarra = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        hdrTituto.setDescription("Articulos");
        add(hdrTituto, java.awt.BorderLayout.PAGE_START);

        split.setDividerLocation(300);

        pnlMarca.setLayout(new java.awt.BorderLayout());

        tbrBotones.setFloatable(false);
        tbrBotones.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/New/New_24x24.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setMaximumSize(new java.awt.Dimension(75, 56));
        btnNuevo.setMinimumSize(new java.awt.Dimension(56, 56));
        btnNuevo.setPreferredSize(new java.awt.Dimension(60, 56));
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        tbrBotones.add(btnNuevo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Edit/Edit_24x24.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setMaximumSize(new java.awt.Dimension(75, 56));
        btnEditar.setMinimumSize(new java.awt.Dimension(56, 56));
        btnEditar.setPreferredSize(new java.awt.Dimension(60, 56));
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        tbrBotones.add(btnEditar);

        btnBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Delete/Delete_24x24.png"))); // NOI18N
        btnBaja.setText("Baja");
        btnBaja.setFocusable(false);
        btnBaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBaja.setMaximumSize(new java.awt.Dimension(75, 56));
        btnBaja.setMinimumSize(new java.awt.Dimension(56, 56));
        btnBaja.setPreferredSize(new java.awt.Dimension(60, 56));
        btnBaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });
        tbrBotones.add(btnBaja);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancel/Cancel_24x24.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setMaximumSize(new java.awt.Dimension(75, 56));
        btnCancelar.setMinimumSize(new java.awt.Dimension(56, 56));
        btnCancelar.setPreferredSize(new java.awt.Dimension(60, 56));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        tbrBotones.add(btnCancelar);

        pnlMarca.add(tbrBotones, java.awt.BorderLayout.PAGE_START);

        lblDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDescripcion.setText("Descripción");

        txtDescripcion.setEditable(false);
        txtDescripcion.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        txtDescripcion.setPreferredSize(new java.awt.Dimension(118, 23));

        lblCodigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCodigo.setText("Código");
        lblCodigo.setPreferredSize(new java.awt.Dimension(132, 17));
        lblCodigo.setRequestFocusEnabled(false);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtCodigo.setText("MMMM-AAAAAAAAD");
        txtCodigo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));

        lblNroSerie.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNroSerie.setText("Número de serie");

        txtNroSerie.setEditable(false);
        txtNroSerie.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtNroSerie.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        txtNroSerie.setPreferredSize(new java.awt.Dimension(118, 23));

        lblMarca.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarca.setText("Marca");

        cboMarca.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        cboMarca.setForeground(new java.awt.Color(52, 52, 52));
        cboMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMarcaItemStateChanged(evt);
            }
        });

        lblFamilia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFamilia.setText("Familia");

        txtFamilia.setEditable(false);
        txtFamilia.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtFamilia.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        txtFamilia.setPreferredSize(new java.awt.Dimension(118, 23));

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNroSerie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMarca, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNroSerie)
                    .addComponent(txtNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFamilia))
                .addGap(18, 18, 18)
                .addComponent(pnlStock, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMarca.add(pnlDatos, java.awt.BorderLayout.CENTER);

        split.setRightComponent(pnlMarca);

        pnlSeleccion.setLayout(new java.awt.BorderLayout());

        tblArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollTabla.setViewportView(tblArticulos);

        pnlSeleccion.add(scrollTabla, java.awt.BorderLayout.CENTER);

        btnFiltroFamilia.setFont(new java.awt.Font("Monospaced", 2, 12)); // NOI18N
        btnFiltroFamilia.setText("<Seleccione una familia>");
        btnFiltroFamilia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFiltroFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroFamiliaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFiltroFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFiltroFamilia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSeleccion.add(pnlFiltro, java.awt.BorderLayout.PAGE_START);

        split.setLeftComponent(pnlSeleccion);

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
            if (familiaSel == null) {
                utils.Msg.msgWarning(this, "Seleccione una familia");
            } else {
                _setRegistro(new ArticuloReg());
                _setModo(MODO_ALTA);
            }
        } else if (modo == MODO_ALTA) {
            try {
                _consistencia();
                _guardar();
                long idArticulo = artSeleccionado.getId();
                _inicializar();
                _setRegistro(idArticulo);
            } catch (ConsistenciaException ex) {
                utils.Msg.msgWarning(this, ex.getMessage(), "Consistencia");
                ex.getError().requestFocus();
            } catch (SQLException ex) {
                utils.Msg.msgException(this, ex, "No se pudieron guardar los datos.");
            }
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (artSeleccionado == null) {
            utils.Msg.msgWarning(this, "Seleccione un artículo a editar.");
        } else if (modo == MODO_SELECCION) {
            _setRegistro(artSeleccionado);
            _setModo(MODO_EDICION);
        } else if (modo == MODO_EDICION) {
            try {
                _consistencia();
                _guardar();
                long idArticulo = artSeleccionado.getId();
                _inicializar();
                _setRegistro(idArticulo);
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
            ArticulosTableModel model = (ArticulosTableModel) tblArticulos.getModel();
            int pos = tblArticulos.getSelectedRow();
            if (pos != -1) {
                pos = tblArticulos.convertRowIndexToModel(pos);
            }
            if (pos == -1) {
                _setRegistro(null);
            } else {
                ArticuloReg articuloReg = model.getRow(pos);
                _setRegistro(articuloReg);
            }
        } else {
            _setRegistro(artSeleccionado);
        }
        _setModo(MODO_SELECCION);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        if (artSeleccionado == null) {
            utils.Msg.msgWarning(this, "Seleccione el artículo a editar.");
        } else {
            boolean op = utils.Msg.msgQuestion(this, "Dar de baja el artículo '" + artSeleccionado.getDescripcion() + "'?");
            if (op) {
                try {
                    artSeleccionado.drop();
                    _inicializar();
                } catch (SQLException ex) {
                    Logger.log(Level.SEVERE, ex);
                    utils.Msg.msgError(this, "No se pudo dar de baja el artículo.");
                }
            }
        }
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnFiltroFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroFamiliaActionPerformed
        familiaSel = PnlFamilias.seleccionarFamilia();
        _cargarArticulos();
    }//GEN-LAST:event_btnFiltroFamiliaActionPerformed

    private void cboMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMarcaItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            MarcaReg marcaReg = (MarcaReg) cboMarca.getSelectedItem();
            String remplace;
            if (marcaReg.getId() == 0) {
                remplace = "MMMM-";
            } else {
                remplace = marcaReg.nroMarca() + "-";
            }
            txtCodigo.setText(txtCodigo.getText().replaceAll(".*-", remplace));
        }
    }//GEN-LAST:event_cboMarcaItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFiltroFamilia;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cboMarca;
    private org.jdesktop.swingx.JXHeader hdrTituto;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFamilia;
    private javax.swing.JLabel lblInfoBarra;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNroSerie;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JPanel pnlMarca;
    private javax.swing.JPanel pnlSeleccion;
    private padron.articulos.PnlPrecios pnlStock;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JSplitPane split;
    private org.jdesktop.swingx.JXTable tblArticulos;
    private javax.swing.JToolBar tbrBotones;
    private javax.swing.JToolBar tbrEstado;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFamilia;
    private javax.swing.JTextField txtNroSerie;
    // End of variables declaration//GEN-END:variables

    private void _inicializar() throws SQLException {
        ArrayList<MarcaReg> marcas = MarcaReg.marcas();
        MarcaReg marcaReg = new MarcaReg(0);
        marcaReg.setDescripcion("<Seleccione una familia>");
        marcas.add(0, marcaReg);
        cboMarca.setModel(new DefaultComboBoxModel(marcas.toArray()));
        _cargarArticulos();
        _setModo(MODO_SELECCION);
    }

    private void _setModo(short modo) {
        this.modo = modo;
        switch (modo) {
            case MODO_SELECCION:
                txtDescripcion.setEditable(false);
                txtNroSerie.setEditable(false);
                cboMarca.setEnabled(false);
                pnlStock.setEnabled(false);
                btnBaja.setEnabled(true);
                btnEditar.setEnabled(true);
                btnNuevo.setEnabled(true);
                tblArticulos.setEnabled(true);
                btnFiltroFamilia.setEnabled(true);
                btnCancelar.setEnabled(false);
                btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/New/New_24x24.png")));
                btnNuevo.setText("Nuevo");
                btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Edit/Edit_24x24.png")));
                btnEditar.setText("Editar");
                lblInfoBarra.setText("Modo selección.");
                break;
            case MODO_BAJA:
                txtDescripcion.setEditable(false);
                txtNroSerie.setEditable(false);
                cboMarca.setEnabled(false);
                pnlStock.setEnabled(false);
                btnBaja.setEnabled(false);
                btnEditar.setEnabled(false);
                btnNuevo.setEnabled(false);
                tblArticulos.setEnabled(false);
                btnFiltroFamilia.setEnabled(false);
                btnCancelar.setEnabled(true);
                lblInfoBarra.setText("<html><font color='red'>Modo baja.</font></html>");
                break;
            case MODO_ALTA:
                txtDescripcion.setEditable(true);
                txtNroSerie.setEditable(true);
                cboMarca.setEnabled(true);
                pnlStock.setEnabled(true);
                btnBaja.setEnabled(false);
                btnEditar.setEnabled(false);
                btnNuevo.setEnabled(true);
                btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Save/Save_24x24.png")));
                btnNuevo.setText("Cuardar");
                tblArticulos.setEnabled(false);
                btnFiltroFamilia.setEnabled(false);
                btnCancelar.setEnabled(true);
                lblInfoBarra.setText("<html><font color='green'>Modo alta.</font></html>");
                break;
            case MODO_EDICION:
                txtDescripcion.setEditable(true);
                txtNroSerie.setEditable(true);
                cboMarca.setEnabled(false);
                pnlStock.setEnabled(true);
                btnBaja.setEnabled(false);
                btnEditar.setEnabled(true);
                btnNuevo.setEnabled(false);
                btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Save/Save_24x24.png")));
                btnEditar.setText("Cuardar");
                tblArticulos.setEnabled(false);
                btnFiltroFamilia.setEnabled(false);
                btnCancelar.setEnabled(true);
                lblInfoBarra.setText("<html><font color='green'>Modo edición.</font></html>");
                break;
            default:
                throw new AssertionError("Modo inexistente");
        }
    }

    private void _setRegistro(ArticuloReg articululoReg) {
        this.artSeleccionado = articululoReg;
        if (articululoReg == null || articululoReg.getId() == 0) {
            txtDescripcion.setText("");
            cboMarca.setSelectedIndex(0);
            txtNroSerie.setText("");
            txtCodigo.setText("MMMM-AAAAAAAAD");
            txtFamilia.setText("");
            pnlStock.setArticulo(null);
        } else {
            txtDescripcion.setText(articululoReg.getDescripcion());
            cboMarca.setSelectedItem(artSeleccionado.getMarcaReg());
            txtNroSerie.setText(articululoReg.getSerialNumber());
            txtCodigo.setText(articululoReg.getCodigo().toString());
            txtFamilia.setText(articululoReg.getFamiliaReg().sPath());
            pnlStock.setArticulo(articululoReg);
        }
    }

    private void _setRegistro(long idRegistro) {
        ArticulosTableModel model = (ArticulosTableModel) tblArticulos.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            ArticuloReg articuloReg = model.getRow(i);
            if (articuloReg.getId() == idRegistro) {
                _setRegistro(articuloReg);
                tblArticulos.setRowSelectionInterval(i, i);
            }
        }
    }

    private void _guardar() throws SQLException {
        db.Session.getConexion().initTransaction();
        try {
            artSeleccionado.setDescripcion(txtDescripcion.getText().trim());
            artSeleccionado.setMarcaReg((MarcaReg) cboMarca.getSelectedItem());
            artSeleccionado.setSerialNumber(txtNroSerie.getText().trim().toUpperCase());
            artSeleccionado.setFamiliaReg(familiaSel);
            artSeleccionado.save();
            pnlStock.guardar();
            db.Session.getConexion().endTransaction();
        } catch (Exception ex) {
            db.Session.getConexion().rollback();
            throw ex;
        }
    }

    private void _consistencia() throws ConsistenciaException {
        if (txtDescripcion.getText().trim().isEmpty()) {
            throw new ConsistenciaException("La descripción no puede ser vacía.", txtDescripcion);
        }

        MarcaReg marcaReg = (MarcaReg) cboMarca.getSelectedItem();
        if (marcaReg == null || marcaReg.getId() == 0) {
            throw new ConsistenciaException("La marca no es correcta", cboMarca);
        }

        //Controlar la unicidad del serial numbre
    }

    private void _limpiarTabla() {
        tblArticulos.setModel(new ArticulosTableModel(new ArrayList<ArticuloReg>()));
        tblArticulos.packAll();
    }

    private void _cargarArticulos() {
        if (familiaSel != null) {
            try {
                btnFiltroFamilia.setText(familiaSel.toString());
                ArrayList<ArticuloReg> articulos = ArticuloReg.articulos(familiaSel);
                //Si es el padrón entero no dejo seleccionada la familia
                if (familiaSel.getId() == 0) {
                    familiaSel = null;
                }
                tblArticulos.setModel(new ArticulosTableModel(articulos));
                tblArticulos.packAll();
            } catch (SQLException ex) {
                utils.Msg.msgException(this, ex, "Error al buscar los artículos.");
            } finally {
                btnFiltroFamilia.setFont(this.getFont());
            }
        } else {
            _limpiarTabla();
            btnFiltroFamilia.setFont(new java.awt.Font("Monospaced", 2, 12));
            btnFiltroFamilia.setText("<Seleccione una familia>");
        }
    }
}
