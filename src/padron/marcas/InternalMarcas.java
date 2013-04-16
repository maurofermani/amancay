package padron.marcas;

import amancay.InternalFrame;

/**
 *
 * @author fermani
 */
public class InternalMarcas extends InternalFrame {

    private PnlMarcas pnlMarcas;

    public InternalMarcas() {
        setLayout(new java.awt.BorderLayout());
        pnlMarcas = new PnlMarcas();
        getContentPane().add(pnlMarcas, java.awt.BorderLayout.CENTER);
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
