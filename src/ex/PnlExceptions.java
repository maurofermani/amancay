package ex;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Stack;

/**
 *
 * @author fermani
 */
public class PnlExceptions extends javax.swing.JPanel {

    private Stack<Throwable> exceptions = new Stack();

    /**
     * Creates new form MsgException
     */
    public PnlExceptions() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        lblMensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtThrow = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(520, 400));
        setLayout(new java.awt.BorderLayout());

        lblMensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gnome/32x32/status/dialog-error.png"))); // NOI18N
        lblMensaje.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lblMensaje.setIconTextGap(20);
        tab.addTab("Mensaje", lblMensaje);

        txtThrow.setEditable(false);
        txtThrow.setColumns(20);
        txtThrow.setRows(5);
        jScrollPane1.setViewportView(txtThrow);

        tab.addTab("Throw", jScrollPane1);

        add(tab, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTextArea txtThrow;
    // End of variables declaration//GEN-END:variables

    public void exception(Throwable ex) {
        exceptions.add(ex);
        lblMensaje.setText("<html>" + ex.getMessage() + "</html>");
        txtThrow.setText(getStackTrace(ex));
    }

    public String getStackTrace(Throwable aThrowable) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        return result.toString();
    }
}
