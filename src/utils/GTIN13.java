package utils;

import ex.GTIN13Exception;
import padron.articulos.Codigo;

/**
 *
 * @author fermani
 */
public class GTIN13 {

    /**
     * Genera el digito verificador del long de 13 dígitos
     *
     * @param number Codigo sin el dígito verificador
     * @return Dígito verificador
     */
    public static int digito(long number) {
        char[] chNumber = String.format("%1$12s", number).replace(' ', '0').toCharArray();
        if (chNumber.length != 12) {
            return -1;
        } else {
            int acumulado = 0;
            int[] factores = new int[]{1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3};
            for (int i = 11; i >= 0; i--) {
                int ch = Character.getNumericValue(chNumber[i]);
                acumulado += ch * factores[i];
            }
            int decena;
            if (acumulado % 10 != 0) {
                //busco la decena más próxima
                decena = acumulado / 10;
                decena++;
                decena *= 10;
            } else {
                decena = acumulado;
            }
            int digito = decena - acumulado;
            return digito;
        }
    }

    /**
     * Verifica si el código está bien generado según algoritmo de GTIN13
     *
     * @param number Código a verificar
     * @return Verdadero es es correcto
     */
    public static boolean verificar(long number) {
        return digito(number / 10) == number % 10;
    }

    public static void main(String[] argv) throws GTIN13Exception {
        //Ejemplo correcto
        long n1 = 1000000236L;
        System.out.println(String.format("%1$12s", n1 / 10).replace(' ', '0') + " - " + digito(n1 / 10));
        System.out.println(GTIN13.verificar(n1));

        //Ejemplo mal
        n1 = 1000000014L;
        System.out.println(String.format("%1$12s", n1 / 10).replace(' ', '0') + " - " + digito(n1 / 10));
        System.out.println(GTIN13.verificar(n1));
        
        System.out.println(new Codigo("1-298"));
        
        System.out.println(new Codigo());
        
        
        System.exit(0);
    }
}
