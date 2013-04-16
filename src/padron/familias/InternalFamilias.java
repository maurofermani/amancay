package padron.familias;

import amancay.InternalFrame;

/**
 *
 * @author fermani
 */
public class InternalFamilias extends InternalFrame {

    private PnlFamilias pnlFamilias;

    public InternalFamilias() {
        setLayout(new java.awt.BorderLayout());
        pnlFamilias = new PnlFamilias(true);
        getContentPane().add(pnlFamilias, java.awt.BorderLayout.CENTER);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setIconifiable(true);
        setTitle("Familas");
        getContentPane().setLayout(new java.awt.BorderLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
