package padron.cargaBatch;

import amancay.InternalFrame;
import ex.DuplicateException;
import ex.Logger;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.swingx.JXComboBox;
import org.jdesktop.swingx.autocomplete.ComboBoxCellEditor;
import padron.familias.PnlFamilias;
import registros.padron.FamiliaReg;
import registros.padron.MarcaReg;
import registros.padron.PrecioReg;
import registros.padron.TalleReg;

/**
 *
 * @author fermani
 */
public class CargaBatch extends InternalFrame {

    private int iRow;
    private String sLog;
    private ArrayList<MarcaReg> marcas;
    private HashMap<String, CargaArticuloReg> articulos;

    public CargaBatch() {
        super();
        try {
            initComponents();
            tblArticulos = new org.jdesktop.swingx.JXTable() {
                Color selMal = new Color(217, 108, 120);

                @Override
                public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                    Component component = super.prepareRenderer(renderer, row, column);
                    int index = tblArticulos.convertRowIndexToModel(row);
                    CargaArticuloReg ca = ((CargaArticulosTableModel) tblArticulos.getModel()).getRow(index);
                    if (error(ca) && tblArticulos.isRowSelected(row)) {
                        component.setBackground(selMal);
                    } else if (error(ca)) {
                        component.setBackground(Color.red);
                    } else if (tblArticulos.isRowSelected(row)) {
                        component.setBackground(selectionBackground);
                    } else {
                        component.setBackground(Color.white);
                    }
                    return component;
                }

                private boolean error(CargaArticuloReg ca) {
                    return ca.getMarcaReg() == null || ca.getFamiliaReg() == null;
                }
            };
            tblArticulos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        int rowIndex = tblArticulos.rowAtPoint(e.getPoint());
                        if (rowIndex != -1) {
                            int row = tblArticulos.convertRowIndexToModel(rowIndex);
                            int column = tblArticulos.columnAtPoint(e.getPoint());
                            CargaArticuloReg ca = ((CargaArticulosTableModel) tblArticulos.getModel()).getRow(row);
                            if (column == 5) {
                                _seleccionarFamilia(ca);
                            } else if (column == 4) {
                                pnlPrecios.setArticulo(ca);
                                utils.Msg.msgDialog(pnlPrecios);
                                ((CargaArticulosTableModel) tblArticulos.getModel()).fireTableDataChanged();
                                tblArticulos.packAll();
                            }
                        }
                    }
                }
            });
            JXComboBox cboDescripcion = new JXComboBox();
            cboDescripcion.setEditable(true);
            tblArticulos.setModel(new CargaArticulosTableModel(cboDescripcion));
            marcas = MarcaReg.marcas();
            JXComboBox cboMarcas = new JXComboBox(new DefaultComboBoxModel(marcas.toArray()));
            tblArticulos.setDefaultEditor(MarcaReg.class, new ComboBoxCellEditor(cboMarcas));
            tblArticulos.getColumnExt("Descripcion").setCellEditor(new ComboBoxCellEditor(cboDescripcion) {

                @Override
                public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                    return super.getTableCellEditorComponent(table, value.toString().replaceAll("^\\* ", "").replaceAll("  ", ""), isSelected, row, column);
                }
                
            });
            tblArticulos.setDefaultEditor(FamiliaReg.class, new FamiliaCellEditor());
            scroll.setViewportView(tblArticulos);
            tblArticulos.packAll();
            tblArticulos.setHorizontalScrollEnabled(true);
            lblInfoBarra.setToolTipText("Clic para ver los errores");
                lblInfoBarra.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblInfoBarra.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        txtLog.setText(sLog);
                        utils.Msg.msgPlain(scroll, scrollLog, "Detalles de la carga");
                    }
                });
        } catch (SQLException ex) {
            Logger.log(Level.SEVERE, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollLog = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextPane();
        pnlPrecios = new padron.articulos.PnlPrecios();
        hdrTituto = new org.jdesktop.swingx.JXHeader();
        tbrEstado = new javax.swing.JToolBar();
        lblInfoBarra = new javax.swing.JLabel();
        pnlCentral = new javax.swing.JPanel();
        pnlCarga = new javax.swing.JPanel();
        txtFile = new javax.swing.JTextField();
        btnFile = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        tblArticulos = new org.jdesktop.swingx.JXTable();

        scrollLog.setMaximumSize(new java.awt.Dimension(500, 400));
        scrollLog.setMinimumSize(new java.awt.Dimension(500, 400));
        scrollLog.setPreferredSize(new java.awt.Dimension(500, 400));

        txtLog.setEditable(false);
        scrollLog.setViewportView(txtLog);

        pnlPrecios.setMaximumSize(new java.awt.Dimension(350, 260));
        pnlPrecios.setMinimumSize(new java.awt.Dimension(350, 260));
        pnlPrecios.setPreferredSize(new java.awt.Dimension(350, 260));

        hdrTituto.setDescription("Carga de árticulos");
        getContentPane().add(hdrTituto, java.awt.BorderLayout.PAGE_START);

        tbrEstado.setFloatable(false);
        tbrEstado.setRollover(true);

        lblInfoBarra.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblInfoBarra.setText("<html><font color='red'>Info</font></html>");
        lblInfoBarra.setPreferredSize(new java.awt.Dimension(19, 15));
        tbrEstado.add(lblInfoBarra);

        getContentPane().add(tbrEstado, java.awt.BorderLayout.PAGE_END);

        pnlCentral.setLayout(new java.awt.BorderLayout());

        pnlCarga.setPreferredSize(new java.awt.Dimension(568, 50));

        txtFile.setEditable(false);
        txtFile.setPreferredSize(new java.awt.Dimension(300, 25));

        btnFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/16x16/actions/stock_search.png"))); // NOI18N
        btnFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCargaLayout = new javax.swing.GroupLayout(pnlCarga);
        pnlCarga.setLayout(pnlCargaLayout);
        pnlCargaLayout.setHorizontalGroup(
            pnlCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCargaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(btnProcesar)
                .addContainerGap())
        );
        pnlCargaLayout.setVerticalGroup(
            pnlCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCargaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFile))
                    .addComponent(btnProcesar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCentral.add(pnlCarga, java.awt.BorderLayout.PAGE_START);

        tblArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblArticulos.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        scroll.setViewportView(tblArticulos);

        pnlCentral.add(scroll, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        File file = utils.Msg.getFile(this);
        iRow = 0;
        sLog = "";
        if (file != null) {
            articulos = new HashMap<>();
            BufferedReader entrada = null;
            try {
                txtFile.setText(file.getPath());
                entrada = new BufferedReader(new FileReader(file));
                String linea;
                while (entrada.ready()) {
                    iRow++;
                    linea = entrada.readLine();
                    _procesarLinea(linea);
                }
            } catch (FileNotFoundException ex) {
                Logger.log(Level.SEVERE, ex);
            } catch (IOException ex) {
                Logger.log(Level.SEVERE, ex);
            } finally {
                try {
                    entrada.close();
                } catch (IOException ex) {
                    Logger.log(Level.SEVERE, ex);
                }
            }
            ((CargaArticulosTableModel) tblArticulos.getModel()).setArticulos(articulos);
            tblArticulos.packAll();
            lblInfoBarra.setText("<html><font color='green'>Líneas procesadas: " + iRow 
                    + " - Articulos cargados: " + tblArticulos.getRowCount() + "</font></html>");
        }
    }//GEN-LAST:event_btnFileActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        ArrayList<CargaArticuloReg> datos = ((CargaArticulosTableModel) tblArticulos.getModel()).getArticulos();
        for (Iterator<CargaArticuloReg> it = datos.iterator(); it.hasNext();) {
            CargaArticuloReg ca = it.next();
            if (ca.consistencia()) {
                try {
                    ca.save();
                } catch (SQLException ex) {
                    utils.Msg.msgException(this, ex);
                }
            }
        }
    }//GEN-LAST:event_btnProcesarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnProcesar;
    private org.jdesktop.swingx.JXHeader hdrTituto;
    private javax.swing.JLabel lblInfoBarra;
    private javax.swing.JPanel pnlCarga;
    private javax.swing.JPanel pnlCentral;
    private padron.articulos.PnlPrecios pnlPrecios;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scrollLog;
    private org.jdesktop.swingx.JXTable tblArticulos;
    private javax.swing.JToolBar tbrEstado;
    private javax.swing.JTextField txtFile;
    private javax.swing.JTextPane txtLog;
    // End of variables declaration//GEN-END:variables

    private void _procesarLinea(String linea) {
        String[] split = linea.split("\\|");
        if (split.length != 5) {
            sLog += "[" + iRow + " Error] Cantidad de parámetros.\n";
        } else {
            String alias = split[0];
            String nroSerie = split[1];
            String descripcion = split[2].toUpperCase();
            String talle = split[3];
            talle = (talle.isEmpty() ? "TU" : talle);
            double precio;
            try {
                precio = Double.parseDouble(split[4].replace(',', '.'));
            } catch (NumberFormatException ex) {
                precio = -1;
            }
            CargaArticuloReg articuloReg;
            if (articulos.containsKey(alias + nroSerie)) {
                articuloReg = articulos.get(alias + nroSerie);
            } else {
                articuloReg = new CargaArticuloReg();
                articuloReg.setSerialNumber(nroSerie);
                articulos.put(alias + nroSerie, articuloReg);
            }
            articuloReg.setMarcaReg(_buscarMarca(alias));
            articuloReg.setDescripcion(descripcion);
            PrecioReg precioReg = new PrecioReg();
            TalleReg talleReg;
            try {
                talleReg = TalleReg.findDescripcion(talle);
                if (talleReg == null) {
                    sLog += "[" + iRow + " Advertencia] Nuevo talle " + talle + ".\n";
                    talleReg = new TalleReg();
                    talleReg.setDescripcion(talle);
                }
                precioReg.setTalleReg(talleReg);
                precioReg.setArticuloReg(articuloReg);
                precioReg.setPrecio(precio);
                articuloReg.getPrecios().add(precioReg);
            } catch (DuplicateException ex) {
                sLog += "[" + iRow + " Error] En la base de datos existen dos filas para el talle " + talle + ".\n";
            } catch (SQLException ex) {
                sLog += "[" + iRow + " Error] Consulta para obtener el talle " + talle + ".\n";
            }
        }
    }

    private MarcaReg _buscarMarca(String alias) {
        if (alias.length() != 3) {
            sLog += "[Error] Marca de la linea " + iRow + ": " + alias + ".\n";
            return null;
        } else {
            Iterator<MarcaReg> it = marcas.iterator();
            while (it.hasNext()) {
                MarcaReg marcaReg = it.next();
                if (marcaReg.getAlias().equals(alias)) {
                    return marcaReg;
                }
            }
            return null;
        }
    }

    private void _seleccionarFamilia(CargaArticuloReg art) {
        FamiliaReg familia = PnlFamilias.seleccionarFamilia();
        if (familia != null && familia.getId() != 0) {
            art.setFamiliaReg(familia);
            tblArticulos.packAll();
        }
    }
}
