package Inventario;

public class ProductoNoEncontradoException extends Exception {

    // Constructor con un mensaje personalizado
    public ProductoNoEncontradoException(String message) {
        super(message);
    }

    // Constructor sin parámetros
    public ProductoNoEncontradoException() {
        super("Producto no encontrado");
    }
}
