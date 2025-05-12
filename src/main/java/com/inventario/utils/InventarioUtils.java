package main.java.com.inventario.utils;

import main.java.com.inventario.classes.Producto;

import java.util.ArrayList;
import java.util.Scanner;

public class InventarioUtils {

    public static void mostrarMenu() {
        System.out.println("Bienvenido al sistema de gestión de inventario");
        System.out.println("Seleccione una opción: (ingrese el número de la opción)");
        System.out.println("------------------------------------------------");
        System.out.println("1. Agregar un producto");
        System.out.println("2. Ver el inventario actual");
        System.out.println("3. Actualizar un producto");
        System.out.println("4. Eliminar un producto");
        System.out.println("5. Salir");
        System.out.println("------------------------------------------------");
    }

    public static int leerOpcion(Scanner scanner) {
        int opcion = -1;
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Ingrese una opción válida.");
            scanner.nextLine();
        }
        return opcion;
    }

    public static int leerEntero(Scanner scanner, String mensajeError) {
        if (scanner.hasNextInt()) {
            int valor = scanner.nextInt();
            scanner.nextLine();
            return valor;
        } else {
            System.out.println(mensajeError);
            scanner.nextLine();
            return Integer.MIN_VALUE;
        }
    }

    public static double leerDouble(Scanner scanner, String mensajeError) {
        if (scanner.hasNextDouble()) {
            double valor = scanner.nextDouble();
            scanner.nextLine();
            return valor;
        } else {
            System.out.println(mensajeError);
            scanner.nextLine();
            return Double.MIN_VALUE;
        }
    }

    public static Producto buscarProductoPorId(ArrayList<Producto> inventario, int id) {
        for (Producto prod : inventario) {
            if (prod.getId() == id) return prod;
        }
        return null;
    }

    public static void mostrarProducto(Producto producto) {
        System.out.println("--------------------------------------------");
        System.out.println("ID: " + producto.getId());
        System.out.println("Nombre: " + producto.getNombreProducto());
        System.out.println("Cantidad: " + producto.getCantidadProducto());
        System.out.println("Precio: " + producto.getPrecioProducto());
        System.out.println("--------------------------------------------");
    }

    public static void agregarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Agregar un producto");
        System.out.println("Ingrese el nombre del producto:");
        String nombreProducto = scanner.nextLine();

        System.out.println("Ingrese la cantidad del producto:");
        int cantidad = leerEntero(scanner, "Cantidad no válida. Operación cancelada.");
        if (cantidad == Integer.MIN_VALUE) return;

        System.out.println("Ingrese el precio del producto:");
        double precio = leerDouble(scanner, "Precio no válido. Operación cancelada.");
        if (precio == Double.MIN_VALUE) return;

        Producto nuevo = new Producto(nombreProducto, cantidad, precio);
        inventario.add(nuevo);
        System.out.println("Producto agregado:");
        mostrarProducto(nuevo);
    }

    public static void verInventario(ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Ver el inventario actual");
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto p : inventario) {
                System.out.println("ID: " + p.getId() +
                        " | Nombre: " + p.getNombreProducto() +
                        " | Cantidad: " + p.getCantidadProducto() +
                        " | Precio: " + p.getPrecioProducto());
            }
        }
    }

    public static void actualizarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Actualizar un producto");
        System.out.println("Ingrese el ID del producto que desea actualizar:");
        int id = leerEntero(scanner, "ID no válido. Operación cancelada.");
        if (id == Integer.MIN_VALUE) return;

        Producto producto = buscarProductoPorId(inventario, id);
        if (producto == null) {
            System.out.println("No se encontró un producto con el ID proporcionado.");
            return;
        }

        System.out.println("Producto encontrado:");
        mostrarProducto(producto);

        System.out.println("Ingrese el nuevo nombre del producto:");
        String nuevoNombre = scanner.nextLine();

        System.out.println("Ingrese la nueva cantidad del producto:");
        int nuevaCantidad = leerEntero(scanner, "Cantidad no válida. Operación cancelada.");
        if (nuevaCantidad == Integer.MIN_VALUE) return;

        System.out.println("Ingrese el nuevo precio del producto:");
        double nuevoPrecio = leerDouble(scanner, "Precio no válido. Operación cancelada.");
        if (nuevoPrecio == Double.MIN_VALUE) return;

        producto.setNombreProducto(nuevoNombre);
        producto.setCantidadProducto(nuevaCantidad);
        producto.setPrecioProducto(nuevoPrecio);
        System.out.println("Producto actualizado con éxito.");
        mostrarProducto(producto);
    }

    public static void eliminarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Eliminar un producto");
        System.out.println("Ingrese el ID del producto que desea eliminar:");
        int id = leerEntero(scanner, "ID no válido. Operación cancelada.");
        if (id == Integer.MIN_VALUE) return;

        Producto producto = buscarProductoPorId(inventario, id);
        if (producto == null) {
            System.out.println("No se encontró un producto con el ID proporcionado.");
        } else {
            inventario.remove(producto);
            System.out.println("Producto eliminado exitosamente.");
        }
    }
}
