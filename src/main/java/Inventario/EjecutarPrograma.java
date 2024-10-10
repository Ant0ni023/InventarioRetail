package Inventario;

import java.util.Scanner;

public class EjecutarPrograma {

    private GestorInventario gestorInventario;
    private Scanner sc;

    public EjecutarPrograma() {
        this.gestorInventario = new GestorInventario();
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Inventario ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Modificar Producto");
            System.out.println("4. Consultar Producto");
            System.out.println("5. Aplicar Descuento");
            System.out.println("6. Calcular Valor Total del Inventario");
            System.out.println("7. Mostrar Inventario");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        gestorInventario.agregarProducto();
                        break;
                    case 2:
                        System.out.print("Ingrese el ID del producto a eliminar: ");
                        int idEliminar = sc.nextInt();
                        gestorInventario.eliminarProducto(idEliminar);
                        break;
                    case 3:
                        System.out.print("Ingrese el ID del producto a modificar: ");
                        int idModificar = sc.nextInt();
                        gestorInventario.modificarProducto(idModificar);
                        break;
                    case 4:
                        System.out.print("Ingrese el ID del producto a consultar: ");
                        int idConsultar = sc.nextInt();
                        Producto productoConsultar = gestorInventario.consultarProducto(idConsultar);
                        System.out.println("Producto encontrado: " + productoConsultar.getNombre());
                        break;
                    case 5:
                        System.out.print("Ingrese el ID del producto para aplicar descuento: ");
                        int idDescuento = sc.nextInt();
                        System.out.print("Ingrese el porcentaje de descuento: ");
                        double descuento = sc.nextDouble();
                        gestorInventario.aplicarDescuento(idDescuento, descuento);
                        break;
                    case 6:
                        double total = gestorInventario.calcularTotal();
                        System.out.println("El total del inventario es: " + total);
                        break;
                    case 7:
                        gestorInventario.mostrarInventario();
                        break;
                    case 8:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 8);
    }

    public static void main(String[] args) {
        EjecutarPrograma programa = new EjecutarPrograma();
        programa.mostrarMenu();
    }
}