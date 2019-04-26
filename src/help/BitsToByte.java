import java.util.*;

/**
 * Convertitore da bit a byte.
 *
 * @author giuliobosco
 * @author jarinaeser
 * @version 1.0 (2019-04-26 - 2019-04-26)
 */
public class BitsToByte {

    /**
     * Converti 8 bit in un byte.
     *
     * @param bits 8 bit da convertire.
     * @return 8 bit convertiti in un byte.
     */
    private static byte getByte(boolean[] bits) {
        if (bits.length == 8) {
            int bitesSum = 0;
            for (int i = bits.length - 1; i >= 0; i--) {
                bitesSum += Math.pow(2,(bits.length - i - 1)) * (bits[i]?1:0);
            }
            return (byte) bitesSum;
        } else {
            throw new IllegalArgumentException("Bits must have at least 8 elements.");
        }
    }

    /**
     * Converti una matrice di bit (il cui numero totale di celle &egrave; multiplo di 8), in un
     * array di byte.
     *
     * @param matrix Matrice da convertire in bytes.
     * @return Bytes della matrice.
     */
    private static byte[] getBytes(boolean[][] matrix) {
        if (matrix.length > 0) {
            int bytesCounter = 0;
            byte[] bytes = new byte[matrix.length * matrix[0].length / 8];

            int bitsCounter = 0;
            boolean[] bits = new boolean[8];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    bits[bitsCounter] = matrix[i][j];
                    bitsCounter++;
                    if (bitsCounter == bits.length) {
                        bytes[bytesCounter] = getByte(bits);
                        bitsCounter = 0;
                        bytesCounter++;
                    }
                }
            }

            return bytes;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Metodo main della classe usato per testare i metodi.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {

		// test del metodo getByte(bits)
        // risultato apettato: -127
        boolean[] bits = {true, false, false, false, false, false, false, false};
        System.out.println(new BitsToByte().getByte(bits));

        System.out.println();

        // test del metodo getBytes(matrix)
        // risultato aspettato 1, 2, 3
        boolean[][] matrix = {
                {false, false, false, false, false, false, false, true, false, false, false, false},
                {false, false, true, false, false, false, false, false, false, false, true, true}
        };
        byte[] bytes = new BitsToByte().getBytes(matrix);
        for (byte b : bytes) {
            System.out.println(b);
        }
    }
}


