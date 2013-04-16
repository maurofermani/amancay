package padron.familias;

/**
 *
 * @author fermani
 */
public class DialogFamilias extends javax.swing.JDialog {

    private PnlFamilias pnlFamilias;

    public DialogFamilias(java.awt.Frame parent, boolean modal, boolean modificar) {
        super(parent, modal);
        initComponents();
        pnlFamilias = new PnlFamilias(modificar);
        getContentPane().add(pnlFamilias, java.awt.BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogFamilias dialog = new DialogFamilias(new javax.swing.JFrame(), true, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
