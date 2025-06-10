package main.java.com.inventario.classes;

public class Producto {
    private static int nextId = 1; // Variable estática para generar IDs únicos
    private int id; // ID único del producto
    private String nombreProducto; // Nombre del producto
    private int cantidadProducto; // Cantidad del producto en inventario
    private double precioProducto; // Precio del producto

    /**
     * Constructor de la clase Producto.
     * (un constructor es un método especial que se llama cuando se crea una instancia de la clase)
     * (una instancia es un objeto creado a partir de una clase)
     *
     * @param nombreProducto
     * @param cantidadProducto
     * @param precioProducto
     */
    public Producto(String nombreProducto, int cantidadProducto, double precioProducto) {
        this.id = nextId++; // Asignar ID único y luego incrementar para el siguiente producto
        this.nombreProducto = nombreProducto; // Nombre del producto
        this.cantidadProducto = cantidadProducto; // Cantidad del producto
        this.precioProducto = precioProducto; // Precio del producto
    }

    // Metodo Get para obtener los valores de los atributos

    /**
     * Los métodos Get y Set son utilizados para acceder y modificar los atributos de la clase.
     * <p>
     * Los Getters son métodos que permiten obtener el valor de un atributo,
     * mientras que los Setters son métodos que permiten establecer un nuevo valor para un atributo.
     */

    // Metodo Get para obtener el ID del producto
    public int getId() {
        return id;
    }

    // Metodos Get para obtener los valores de los atributos
    public String getNombreProducto() {
        return nombreProducto;
    }

    // Metodo Get para obtener la cantidad del producto
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    // Metodo Get para obtener el precio del producto
    public double getPrecioProducto() {
        return precioProducto;
    }

    // Metodos Set para establecer los valores de los atributos

    // Metodo Set para establecer el nombre del producto
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    // Metodo Set para establecer la cantidad del producto
    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    // Metodo Set para establecer el precio del producto
    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}
