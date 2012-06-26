package padron;

/**
 *
 * @author fermani
 */
public class TipoNodo {

    public static final byte TIPO_ROOT = 0;
    public static final byte TIPO_FAMILIA = 1;
    public static final byte TIPO_ARTICULO = 2;
    private final int idTipo;

    public TipoNodo(int tipo) {
        this.idTipo = tipo;
    }

    public boolean esFamilia() {
        return idTipo == TIPO_FAMILIA;
    }

    public boolean esArticulo() {
        return idTipo == TIPO_ARTICULO;
    }

    boolean esRoot() {
        return idTipo == TIPO_ROOT;
    }

    public static TipoNodo nodoFamilia() {
        return new TipoNodo(TIPO_FAMILIA);
    }

    public static TipoNodo nodoArticulo() {
        return new TipoNodo(TIPO_ARTICULO);
    }

    public static TipoNodo nodoRoot() {
        return new TipoNodo(TIPO_ROOT);
    }
}
