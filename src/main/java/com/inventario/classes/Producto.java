package main.java.com.inventario.classes;

public class Producto {
    private static int nextId = 1;
    private int id;
    private String nombreProducto;
    private int cantidadProducto;
    private double precioProducto;

    public Producto(String nombreProducto, int cantidadProducto, double precioProducto) {
        this.id = nextId++;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
    }

    public int getId() {
        return id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}
