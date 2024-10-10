package Inventario;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorInventario {

    public ArrayList<Producto> inventario;
    private Scanner sc;

    public GestorInventario() {
        this.inventario = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    // El método hace una tarea que es agregar un producto al inventario.
    public void agregarProducto() {
        System.out.println("Ingrese el id del producto: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la cantidad del producto: ");
        int cantidad = sc.nextInt();
        System.out.println("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        Producto nuevoProducto = new Producto(id, nombre, cantidad, precio);
        inventario.add(nuevoProducto);
        System.out.println("Producto agregado exitosamente.");
    }

    // Método para eliminar un producto del inventario
    public void eliminarProducto(int id) throws ProductoNoEncontradoException, InventarioVacioException {
        if (inventario.isEmpty()) {
            throw new InventarioVacioException("El inventario está vacío. No se puede eliminar un producto.");
        }
        Producto productoAEliminar = consultarProducto(id);
        inventario.remove(productoAEliminar);
        System.out.println("Producto con ID " + id + " eliminado exitosamente.");
    }

    // Método para modificar un producto existente
    public void modificarProducto(int id) throws ProductoNoEncontradoException {
        Producto productoModificar = consultarProducto(id);
        System.out.println("Ingrese el nuevo nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la nueva cantidad del producto: ");
        int cantidad = sc.nextInt();
        System.out.println("Ingrese el nuevo precio del producto: ");
        double precio = sc.nextDouble();
        productoModificar.setNombre(nombre);
        productoModificar.setCantidad(cantidad);
        productoModificar.setPrecio(precio);
        System.out.println("Producto con ID " + id + " modificado exitosamente.");
    }

    // Método para consultar un producto por ID
    public Producto consultarProducto(int id) throws ProductoNoEncontradoException {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        throw new ProductoNoEncontradoException("Producto con ID " + id + " no encontrado.");
    }

    // Método para aplicar descuento a un producto
    public void aplicarDescuento(int id, double descuento) throws ProductoNoEncontradoException {
        Producto producto = consultarProducto(id);
        double nuevoPrecio = producto.getPrecio() * (1 - descuento / 100);
        producto.setPrecio(nuevoPrecio);
        System.out.println("Descuento aplicado. El nuevo precio del producto con ID " + id + " es: " + nuevoPrecio);
    }

    // Método para calcular el valor total del inventario
    public double calcularTotal() throws InventarioVacioException {
        if (inventario.isEmpty()) {
            throw new InventarioVacioException("No se puede calcular el total porque el inventario está vacío.");
        }
        double total = 0;
        for (Producto producto : inventario) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }

    // Método para mostrar el inventario
    public void mostrarInventario() throws InventarioVacioException {
        if (inventario.isEmpty()) {
            throw new InventarioVacioException("El inventario está vacío.");
        }
        System.out.println("Inventario:");
        for (Producto producto : inventario) {
            System.out.println("ID: " + producto.getId() + " Nombre: " + producto.getNombre() + " Cantidad: " + producto.getCantidad() + " Precio: " + producto.getPrecio());
        }
    }
}
