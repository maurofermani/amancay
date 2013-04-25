package ex;

/**
 *
 * @author fermani
 */
public class GTIN13Exception extends Exception {

    public GTIN13Exception(long codigo) {
        super("El código de validación es incorrecto.\n"
                + "Código almacenado/cargado: " + codigo);
    }

    public GTIN13Exception(String sCodigo) {
        super("El código de validación es incorrecto.\n"
                + "Código almacenado/cargado: " + sCodigo);
    }

}
