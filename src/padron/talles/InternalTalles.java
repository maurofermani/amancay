package padron.talles;

import amancay.InternalFrame;

/**
 *
 * @author fermani
 */
public class InternalTalles extends InternalFrame {

    private PnlTalles pnlTalles;

    public InternalTalles() {
        setLayout(new java.awt.BorderLayout());
        pnlTalles = new PnlTalles();
        getContentPane().add(pnlTalles, java.awt.BorderLayout.CENTER);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setIconifiable(true);
        setTitle("Marcas");
        getContentPane().setLayout(new java.awt.BorderLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
