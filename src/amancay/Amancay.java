package amancay;

import ex.Logger;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import padron.articulos.InternalArticulos;
import padron.familias.InternalFamilias;
import padron.marcas.InternalMarcas;
import padron.talles.InternalTalles;
import utils.Msg;

/**
 *
 * @author fermani
 */
public class Amancay extends javax.swing.JFrame {

    public static class ExceptionHandler
            implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread thread, Throwable thrown) {
            if (thrown instanceof Exception) {
                Msg.msgException(null, (Exception) thrown);
            } else {
                Msg.msgException(null, new Exception(thrown));
            }

        }


    }

    public Amancay() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        menuPrincipal = new javax.swing.JMenuBar();
        menuPadron = new javax.swing.JMenu();
        menuInternalFamilias = new javax.swing.JMenuItem();
        menuInternalMarcas = new javax.swing.JMenuItem();
        menuInternalTalles = new javax.swing.JMenuItem();
        menuInternalArticulos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        menuPadron.setText("Padrón");

        menuInternalFamilias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/HardDisk/HardDisk_16x16.png"))); // NOI18N
        menuInternalFamilias.setText("Familias");
        menuInternalFamilias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInternalFamiliasActionPerformed(evt);
            }
        });
        menuPadron.add(menuInternalFamilias);

        menuInternalMarcas.setText("Marcas");
        menuInternalMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInternalMarcasActionPerformed(evt);
            }
        });
        menuPadron.add(menuInternalMarcas);

        menuInternalTalles.setText("Talles");
        menuInternalTalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInternalTallesActionPerformed(evt);
            }
        });
        menuPadron.add(menuInternalTalles);

        menuInternalArticulos.setText("Artículos");
        menuInternalArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInternalArticulosActionPerformed(evt);
            }
        });
        menuPadron.add(menuInternalArticulos);

        menuPrincipal.add(menuPadron);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuInternalFamiliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInternalFamiliasActionPerformed
        InternalFamilias familias = null;
        JInternalFrame[] frames = desktop.getAllFrames();
        for (int i = 0; i < frames.length; i++) {
            JInternalFrame frame = frames[i];
            if (frame instanceof InternalFamilias) {
                familias = (InternalFamilias) frame;
                desktop.setSelectedFrame(familias);
                break;
            }
        }
        if (familias == null) {
            try {
                familias = new InternalFamilias();
                desktop.add(familias);
                familias.setVisible(true);
                familias.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.log(Level.WARNING, ex);
            }
        }
    }//GEN-LAST:event_menuInternalFamiliasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        db.Session.setApp(this);
    }//GEN-LAST:event_formWindowOpened

    private void menuInternalMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInternalMarcasActionPerformed
        InternalMarcas marcas = null;
        JInternalFrame[] frames = desktop.getAllFrames();
        for (int i = 0; i < frames.length; i++) {
            JInternalFrame frame = frames[i];
            if (frame instanceof InternalMarcas) {
                marcas = (InternalMarcas) frame;
                desktop.setSelectedFrame(marcas);
                break;
            }
        }
        if (marcas == null) {
            try {
                marcas = new InternalMarcas();
                desktop.add(marcas);
                marcas.setVisible(true);
                marcas.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.log(Level.WARNING, ex);
            }
        }
    }//GEN-LAST:event_menuInternalMarcasActionPerformed

    private void menuInternalTallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInternalTallesActionPerformed
        InternalTalles talles = null;
        JInternalFrame[] frames = desktop.getAllFrames();
        for (int i = 0; i < frames.length; i++) {
            JInternalFrame frame = frames[i];
            if (frame instanceof InternalTalles) {
                talles = (InternalTalles) frame;
                desktop.setSelectedFrame(talles);
                break;
            }
        }
        if (talles == null) {
            try {
                talles = new InternalTalles();
                desktop.add(talles);
                talles.setVisible(true);
                talles.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.log(Level.WARNING, ex);
            }
        }
    }//GEN-LAST:event_menuInternalTallesActionPerformed

    private void menuInternalArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInternalArticulosActionPerformed
        InternalArticulos articulos = null;
        JInternalFrame[] frames = desktop.getAllFrames();
        for (int i = 0; i < frames.length; i++) {
            JInternalFrame frame = frames[i];
            if (frame instanceof InternalArticulos) {
                articulos = (InternalArticulos) frame;
                desktop.setSelectedFrame(articulos);
                break;
            }
        }
        if (articulos == null) {
            try {
                articulos = new InternalArticulos();
                desktop.add(articulos);
                articulos.setVisible(true);
                articulos.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.log(Level.WARNING, ex);
            }
        }
    }//GEN-LAST:event_menuInternalArticulosActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *
         try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
         System.out.println(info.getName());
         if ("Nimbus".equals(info.getName())) {
         javax.swing.UIManager.setLookAndFeel(info.getClassName());
         break;
         }
         }
         } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Amancay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Amancay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Amancay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Amancay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }*/
        //</editor-fold>

        /**
         * Para un manejo de exepciones total
         */
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        System.setProperty("sun.awt.exception.handler",
                ExceptionHandler.class.getName());

        javax.swing.UIManager.put("ComboBox.disabledForeground", new java.awt.Color(51, 51, 51));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Amancay amancay = new Amancay();
                    amancay.setLocationRelativeTo(null);
                    amancay.setVisible(true);
                } catch (Exception ex) {
                    Msg.msgException(db.Session.getApp(), ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem menuInternalArticulos;
    private javax.swing.JMenuItem menuInternalFamilias;
    private javax.swing.JMenuItem menuInternalMarcas;
    private javax.swing.JMenuItem menuInternalTalles;
    private javax.swing.JMenu menuPadron;
    private javax.swing.JMenuBar menuPrincipal;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getDesktop() {
        return desktop;
    }
}
