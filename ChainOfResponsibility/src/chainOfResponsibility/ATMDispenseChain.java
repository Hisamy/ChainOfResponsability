package chainOfResponsibility;

import java.util.Scanner;

/**
 * Clase principal que implementa el patrón Chain of Responsibility para un
 * cajero automático (ATM). El cajero dispensará billetes en denominaciones de
 * $50, $20, y $10, según la cantidad solicitada. La cadena de responsabilidad
 * permite que cada dispensador maneje la parte de la cantidad que le
 * corresponde, y pase el resto al siguiente dispensador en la cadena.
 *
 * @author Equipo Chain of Responability
 */
public class ATMDispenseChain {

    private DispenseChain cadena1;

    /**
     * Constructor que inicializa la cadena de dispensadores del cajero.
     * Configura la cadena de responsabilidad con dispensadores de $50, $20, y
     * $10.
     */
    public ATMDispenseChain() {
        this.cadena1 = new Dollar50Dispenser();
        DispenseChain cadena2 = new Dollar20Dispenser();
        DispenseChain cadena3 = new Dollar10Dispenser();

        cadena1.setSiguienteCadena(cadena2);
        cadena2.setSiguienteCadena(cadena3);
    }

    /**
     * Método principal que simula la interacción del usuario con el cajero
     * automático. Solicita al usuario que ingrese la cantidad a dispensar y se
     * asegura de que sea un múltiplo de 10. La cantidad ingresada es procesada
     * por la cadena de dispensadores.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este
     * caso).
     */
    public static void main(String[] args) {
        ATMDispenseChain atmDispensador = new ATMDispenseChain();
        while (true) {
            int cantidad = 0;
            System.out.println("Ingrese la cantidad a dispensar: ");
            Scanner input = new Scanner(System.in);
            cantidad = input.nextInt();
            if (cantidad % 10 != 0) {
                System.out.println("La cantidad debe ser múltiplo de 10");
                return;
            }
            atmDispensador.cadena1.dispense(new Currency(cantidad));
        }
    }
}
