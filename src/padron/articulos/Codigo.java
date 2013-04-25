package padron.articulos;

import ex.GTIN13Exception;
import utils.GTIN13;

/**
 * Formato de un codigo de articulo MMMM-AAAAAAAAD Donde: <ul> <li>MMMM es el
 * codigo de la marca</li> <li>AAAAAAAA es el número asignado a la
 * marca</li><li>D es el dígito verificador</li></ul>
 *
 * @author fermani
 */
public class Codigo {

    private final long codigo;
    private final boolean ok;

    /**
     * Constructor vacío
     */
    public Codigo() {
        this.codigo = 0;
        ok = false;
    }

    /**
     * Constructor a partir de un entero
     *
     * @param codigo
     */
    public Codigo(long codigo) throws GTIN13Exception {
        this.codigo = codigo;
        if (GTIN13.verificar(codigo)) {
            ok = true;
        } else {
            ok = false;
            throw new GTIN13Exception(codigo);
        }
    }

    /**
     * Constructor a partir de un string
     *
     * @param sCodigo El formato debe respertar .1M-.9A El número 1-236 sera
     * 0001-000000236
     */
    public Codigo(String sCodigo) throws GTIN13Exception {
        String[] split = sCodigo.split("-");
        if (split.length != 2) {
            throw new GTIN13Exception(sCodigo);
        } else {
            long marca = Long.parseLong(split[0]);
            long nro = Long.parseLong(split[1]);
            this.codigo = marca * 1000000000L + Long.parseLong(String.format("%1$9s", nro).replace(' ', '0'));
            if (GTIN13.verificar(codigo)) {
                ok = true;
            } else {
                ok = false;
                throw new GTIN13Exception(codigo);
            }
        }
    }

    public long getCodigo() {
        return codigo;
    }

    /**
     * Formato de un codigo de articulo MMMM-AAAAAAAAD Donde: <ul> <li>MMMM es
     * el codigo de la marca</li> <li>AAAAAAAA es el número asignado a la
     * marca</li><li>D es el dígito verificador</li></ul>
     *
     * @return
     */
    @Override
    public String toString() {
        if (codigo == 0) {
            return "MMMM-AAAAAAAAD";
        } else {
            return String.format("%1$4s", codigo / 1000000000).replace(' ', '0') + "-"
                    + String.format("%1$9s", codigo % 1000000000).replace(' ', '0');
        }
    }

    /**
     * Devuelve el codigo de 12 dígitos (sin el dígito verificador) para la
     * generación del código
     *
     * @param sCodigo
     * @return
     * @throws GTIN13Exception
     */
    public static long getCodigoSinDigito(String sCodigo) throws GTIN13Exception {
        String[] split = sCodigo.split("-");
        long lCodigo;
        if (split.length != 2) {
            throw new GTIN13Exception(sCodigo);
        } else {
            long marca = Long.parseLong(split[0]);
            long nro = Long.parseLong(split[1]);
            lCodigo = marca * 100000000L + nro;
            return lCodigo;
        }
    }
}
