package chainOfResponsibility;

import java.util.Scanner;

/**
 *
 * @author Equipo Chain of Responability
 */
public class ATMDispenseChain {

    private DispenseChain cadena1;

    public ATMDispenseChain() {
        this.cadena1 = new Dollar50Dispenser();
        DispenseChain cadena2 = new Dollar20Dispenser();
        DispenseChain cadena3 = new Dollar10Dispenser();

        cadena1.setSiguienteCadena(cadena2);
        cadena2.setSiguienteCadena(cadena3);
    }

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
