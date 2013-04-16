package utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author fermani
 */
public class Msg {

    public static void msgPlain(Component componentParent, Object message) {
        msgError(componentParent, message, "");
    }

    public static void msgPlain(Component componentParent, Object message, String title) {
        JOptionPane.showInternalMessageDialog(componentParent, message, title, JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void msgInfo(Component componentParent, Object message) {
        msgError(componentParent, message, "Información");
    }

    public static void msgInfo(Component componentParent, Object message, String title) {
        JOptionPane.showInternalMessageDialog(componentParent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void msgError(Component componentParent, Object message) {
        msgError(componentParent, message, "Error");
    }

    public static void msgError(Component componentParent, Object message, String title) {
        JOptionPane.showInternalMessageDialog(componentParent, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void msgWarning(Component componentParent, Object message) {
        msgError(componentParent, message, "Error");
    }

    public static void msgWarning(Component componentParent, Object message, String title) {
        JOptionPane.showInternalMessageDialog(componentParent, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static boolean msgQuestion(Component componentParent, Object message) {
        return msgQuestion(componentParent, message, "Confirmación.");
    }
    
    public static boolean msgQuestion(Component componentParent, Object message, String title) {
        return JOptionPane.showInternalConfirmDialog(componentParent, message, title, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION;
    }
}
