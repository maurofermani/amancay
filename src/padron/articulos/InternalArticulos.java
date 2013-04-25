package padron.articulos;

import amancay.InternalFrame;

/**
 *
 * @author fermani
 */
public class InternalArticulos extends InternalFrame {

    private PnlArticulos pnlArticulos;

    public InternalArticulos() {
        setLayout(new java.awt.BorderLayout());
        pnlArticulos = new PnlArticulos();
        getContentPane().add(pnlArticulos, java.awt.BorderLayout.CENTER);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setIconifiable(true);
        setTitle("Articulos");
        getContentPane().setLayout(new java.awt.BorderLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
