package chainOfResponsibility;

/**
 * Interfaz que define los métodos para implementar el patrón Chain of
 * Responsibility en un sistema de dispensación de dinero en cajeros automáticos
 * (ATM).
 *
 * @author Equipo Chain of Responability
 */
public interface DispenseChain {

    /**
     * Establece la siguiente cadena en la secuencia de dispensadores. Este
     * método se utiliza para conectar diferentes dispensadores en la cadena de
     * responsabilidad.
     *
     * @param siguienteCadena El siguiente eslabón (dispensador) en la cadena de
     * responsabilidad.
     */
    void setSiguienteCadena(DispenseChain siguienteCadena);

    /**
     * Método para manejar la dispensación de una cantidad específica de dinero.
     *
     * @param currency El objeto `Currency` que contiene la cantidad de dinero a
     * dispensar.
     */
    void dispense(Currency currency);
}
