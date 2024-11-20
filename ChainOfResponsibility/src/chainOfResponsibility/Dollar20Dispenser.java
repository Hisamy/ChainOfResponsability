package chainOfResponsibility;

/**
 * Clase que implementa el dispensador de billetes de $20 en el patrón Chain of
 * Responsibility. Esta clase maneja la dispensación de billetes de $20 y pasa
 * cualquier cantidad restante al siguiente dispensador en la cadena, si
 * corresponde.
 *
 * @author Equipo Chain of Responability
 */
public class Dollar20Dispenser implements DispenseChain {

    private DispenseChain cadena;

    /**
     * Establece el siguiente eslabón (dispensador) en la cadena de
     * responsabilidad.
     *
     * @param siguienteCadena El próximo dispensador en la cadena.
     */
    @Override
    public void setSiguienteCadena(DispenseChain siguienteCadena) {
        this.cadena = siguienteCadena;
    }

    /**
     * Método para dispensar billetes de $20. Si la cantidad de dinero es mayor
     * o igual a $20, se dispensan billetes de $20 y se calcula el sobrante. Si
     * hay una cantidad restante, se pasa al siguiente dispensador. Si la
     * cantidad es menor a $20, se pasa directamente al siguiente dispensador.
     *
     * @param currency El objeto `Currency` que contiene la cantidad de dinero a
     * dispensar.
     */
    @Override
    public void dispense(Currency currency) {
        if (currency.getCantidad() >= 20) {
            int num = currency.getCantidad() / 20;
            int sobrante = currency.getCantidad() % 20;
            System.out.println("Dispensando " + num + " billetes de 20$");
            if (sobrante != 0) {
                this.cadena.dispense(new Currency(sobrante));
            }
        } else {
            this.cadena.dispense(currency);
        }
    }
}
