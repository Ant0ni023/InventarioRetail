package Inventario;

public class Producto {

    private String nombre;
    private int id;
    private int cantidad;
    private double precio;

    public Producto(int id, String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Métodos consultores (Getters)
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    // Métodos modificadores (Setters)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}