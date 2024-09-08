package chainOfResponsibility;

/**
 *
 * @author Equipo Chain of Responability
 */
public class Dollar20Dispenser implements DispenseChain {

    private DispenseChain cadena;

    @Override
    public void setSiguienteCadena(DispenseChain siguienteCadena) {
        this.cadena = siguienteCadena;
    }

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
