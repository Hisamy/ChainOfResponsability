package chainOfResponsibility;

/**
 * Clase que implementa el dispensador de billetes de $10 en el patrón Chain of
 * Responsibility. Esta clase maneja la dispensación de billetes de $10 y pasa
 * cualquier cantidad restante al siguiente dispensador en la cadena, si
 * corresponde.
 *
 * @author Equipo Chain of Responability
 */
public class Dollar10Dispenser implements DispenseChain {

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
     * Método para dispensar billetes de $10. Si la cantidad de dinero es mayor
     * o igual a $10, se dispensan billetes de $10 y se calcula el sobrante. Si
     * hay una cantidad restante, se verifica si hay un siguiente dispensador.
     * Si no hay otro dispensador, se notifica que el sobrante no puede ser
     * dispensado.
     *
     * @param currency El objeto `Currency` que contiene la cantidad de dinero a
     * dispensar.
     */
    @Override
    public void dispense(Currency currency) {
        if (currency.getCantidad() >= 10) {
            int num = currency.getCantidad() / 10;
            int sobrante = currency.getCantidad() % 10;
            System.out.println("Dispensando " + num + " billetes de 10$");
            if (sobrante != 0) {
                this.cadena.dispense(new Currency(sobrante));
            }
        } else {
            this.cadena.dispense(currency);
        }
    }
}
