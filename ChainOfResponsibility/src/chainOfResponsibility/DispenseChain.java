package chainOfResponsibility;

/**
 *
 * @author Equipo Chain of Responability
 */
public interface DispenseChain {
    void setSiguienteCadena(DispenseChain siguienteCadena);
    void dispense(Currency currency);
}
