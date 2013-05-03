package utils;

import ex.PnlExceptions;
import java.awt.Component;
import java.io.File;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author fermani
 */
public class Msg {

    private static PnlExceptions msgException = new PnlExceptions();
    private static JFileChooser fileChooser;
    /**
     * Used for error messages.
     */
    public static final int ERROR_MESSAGE = JOptionPane.ERROR_MESSAGE;
    /**
     * Used for information messages.
     */
    public static final int INFORMATION_MESSAGE = JOptionPane.INFORMATION_MESSAGE;
    /**
     * Used for warning messages.
     */
    public static final int WARNING_MESSAGE = JOptionPane.WARNING_MESSAGE;
    /**
     * Used for questions.
     */
    public static final int QUESTION_MESSAGE = JOptionPane.QUESTION_MESSAGE;
    /**
     * No icon is used.
     */
    public static final int PLAIN_MESSAGE = JOptionPane.PLAIN_MESSAGE;

    public static void msgPlain(Component componentParent, Object message) {
        msgError(componentParent, message, "");
    }

    public static void msgPlain(Component componentParent, Object message, String title) {
        JOptionPane.showInternalMessageDialog(componentParent, message, title, Msg.PLAIN_MESSAGE);
    }

    public static void msgInfo(Component componentParent, Object message) {
        msgError(componentParent, message, "Información");
    }

    public static void msgInfo(Component componentParent, Object message, String title) {
        JOptionPane.showInternalMessageDialog(componentParent, message, title, Msg.INFORMATION_MESSAGE);
    }

    public static void msgError(Component componentParent, Object message) {
        msgError(componentParent, message, "Error");
    }

    public static void msgError(Component componentParent, Object message, String title) {
        JOptionPane.showInternalMessageDialog(componentParent, message, title, Msg.ERROR_MESSAGE);
    }

    public static void msgWarning(Component componentParent, Object message) {
        msgWarning(componentParent, message, "Advertencia");
    }

    public static void msgWarning(Component componentParent, Object message, String title) {
        JOptionPane.showInternalMessageDialog(componentParent, message, title, Msg.WARNING_MESSAGE);
    }

    public static boolean msgQuestion(Component componentParent, Object message) {
        return msgQuestion(componentParent, message, "Confirmación.");
    }

    public static boolean msgQuestion(Component componentParent, Object message, String title) {
        return JOptionPane.showInternalConfirmDialog(componentParent, message, title, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION;
    }

    public static boolean msgQuestion(Component componentParent, Object message, String title, int messageType) {
        return JOptionPane.showInternalConfirmDialog(componentParent, message, title, JOptionPane.OK_CANCEL_OPTION, messageType) == JOptionPane.OK_OPTION;
    }

    public static void msgException(Component componentParent, Exception exception) {
        Msg.msgException(componentParent, exception, "Error");
    }

    public static void msgException(Component componentParent, Exception exception, String title) {
        ex.Logger.log(Level.SEVERE, exception);
        msgException.exception(exception);
        JOptionPane.showMessageDialog(componentParent, msgException, title, Msg.PLAIN_MESSAGE);
    }

    public static File getFile(Component comp) {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }
        fileChooser.setMultiSelectionEnabled(false);
        if (fileChooser.showOpenDialog(comp) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    public static File[] getFiles(Component comp) {
        if (fileChooser != null) {
            fileChooser = new JFileChooser();
        }
        fileChooser.setMultiSelectionEnabled(true);
        if (fileChooser.showOpenDialog(comp) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFiles();
        } else {
            return null;
        }
    }
}
