package ex;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author fermani
 */
public class ConsistenciaException extends Exception {

    private JComponent error;

    public ConsistenciaException(String message, JComponent error) {
        super(message);
        this.error = error;
    }

    public JComponent getError() {
        return error;
    }
}
