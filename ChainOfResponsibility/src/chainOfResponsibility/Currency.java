package chainOfResponsibility;

/**
 * Clase que representa una cantidad de dinero en una transacción del cajero
 * automático.
 *
 *
 * @author Equipo Chain of Responability
 */
public class Currency {

    private int cantidad;

    /**
     * Constructor que inicializa el objeto Currency con una cantidad
     * específica.
     *
     * @param cantidad La cantidad de dinero a manejar en la transacción.
     */
    public Currency(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método para obtener la cantidad de dinero almacenada en este objeto.
     *
     * @return La cantidad de dinero.
     */
    public int getCantidad() {
        return cantidad;
    }

}
