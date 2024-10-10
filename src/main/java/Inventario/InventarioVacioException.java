package Inventario;

public class InventarioVacioException extends Exception {

    // Constructor con un mensaje personalizado
    public InventarioVacioException(String message) {
        super(message);
    }

    // Constructor sin parámetros
    public InventarioVacioException() {
        super("El inventario está vacío");
    }
}
