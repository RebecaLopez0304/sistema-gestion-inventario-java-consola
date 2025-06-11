package main.java.com.inventario.utils;

import main.java.com.inventario.classes.Producto;

import java.util.ArrayList;
import java.util.Scanner;

public class InventarioUtils {

    // Método para mostrar el menú principal del sistema de gestión de inventario
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

    // Método para leer una opción del usuario y validar que sea un número entero
    public static int leerOpcion(Scanner scanner) {
        int opcion = -1; // Se hace un -1 para indicar que aún no se ha leído una opción válida
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Ingrese una opción válida.");
            scanner.nextLine();
        }
        return opcion;
    }

    // Métodos para leer diferentes tipos de datos y manejar errores
    // LeerEntero es para leer un número entero
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

    // LeerDouble es para leer un número decimal
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

    // Método para buscar un producto por su ID en el inventario
    public static Producto buscarProductoPorId(ArrayList<Producto> inventario, int id) {
        for (Producto prod : inventario) {
            // Compara el ID del producto con el ID proporcionado, recorriendo el inventario uno por uno
            if (prod.getId() == id) return prod; // Si encuentra el producto, lo devuelve
        }
        return null; // Si no encuentra el producto, devuelve null, osea que no existe
    }

    // Método para mostrar los detalles de un producto
    public static void mostrarProducto(Producto producto) {
        System.out.println("--------------------------------------------");
        System.out.println("ID: " + producto.getId()); // Obtiene el id del produco y lo muestra
        System.out.println("Nombre: " + producto.getNombreProducto()); // Obtiene el nombre del producto y lo muestra
        System.out.println("Cantidad: " + producto.getCantidadProducto()); // Obtiene la cantidad del producto y lo muestra
        System.out.println("Precio: " + producto.getPrecioProducto()); // Obtiene el precio del producto y lo muestra
        System.out.println("--------------------------------------------");
    }

    // Método para agregar un nuevo producto al inventario
    public static void agregarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Agregar un producto");
        System.out.println("Ingrese el nombre del producto:"); // Solicita al usuario que ingrese el nombre del producto
        String nombreProducto = scanner.nextLine().trim(); // Lee y elimina espacios al inicio y final
        if (nombreProducto.isEmpty()) {
            System.out.println("El nombre no puede estar vacío. Operación cancelada.");
            System.out.println(" ");
            return;
        }

        System.out.println("Ingrese la cantidad del producto:");
        int cantidad = leerEntero(scanner, "Cantidad no válida. Operación cancelada.");
        if (cantidad == Integer.MIN_VALUE || cantidad <= 0) {
            System.out.println(" ");
            return; // Si la cantidad no es válida o no es positiva, se cancela la operación
        }

        System.out.println("Ingrese el precio del producto:");
        double precio = leerDouble(scanner, "Precio no válido. Operación cancelada.");
        if (precio == Double.MIN_VALUE || precio <= 0) {
            System.out.println(" ");
            return; // Si el precio no es válido o no es positivo, se cancela la operación
        }

        Producto nuevo = new Producto(nombreProducto, cantidad, precio); // Crea un nuevo objeto Producto con los datos ingresados por el usuario
        inventario.add(nuevo); // Agrega el nuevo producto al inventario (ArrayList de productos)
        System.out.println("Producto agregado:");
        mostrarProducto(nuevo); // Muestra los detalles del producto recién agregado
    }

    // Método para ver el inventario actual
    public static void verInventario(ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Ver el inventario actual");
        if (inventario.isEmpty()) { // Verifica si el inventario está vacío
            System.out.println(" -------- El inventario está vacío. -------- "); // Si está vacío, muestra un mensaje indicando que no hay productos
            System.out.println("Por favor, agregue productos al inventario."); // Sugiere al usuario que agregue productos
            System.out.println(" ");
        } else { // Si hay productos en el inventario, los muestra
            System.out.println("-------- INVENTARIO ACTUAL --------");
            for (Producto p : inventario) { // Recorre cada producto en el inventario (ArrayList de productos)
                // Muestra los detalles de cada producto
                System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombreProducto() + " | Cantidad: " + p.getCantidadProducto() + " | Precio: " + p.getPrecioProducto());
            }
            System.out.println("-----------------------------------");
        }
    }

    // Método para actualizar un producto existente en el inventario
    public static void actualizarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Actualizar un producto");
        System.out.println("Ingrese el ID del producto que desea actualizar:");
        int id = leerEntero(scanner, "ID no válido. Operación cancelada.");
        if (id == Integer.MIN_VALUE) {
            System.out.println(" ");
            return;
        }

        Producto producto = buscarProductoPorId(inventario, id);
        if (producto == null) {
            System.out.println("No se encontró un producto con el ID proporcionado.");
            System.out.println("-------- -------- --------");
            System.out.println(" ");
            return;
        }

        System.out.println("--------Producto encontrado: --------");
        mostrarProducto(producto);

        System.out.println("Ingrese el nuevo nombre del producto:");
        String nuevoNombre = scanner.nextLine().trim();
        if (nuevoNombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío o solo contener espacios. Operación cancelada.");
            System.out.println(" ");
            return;
        }

        System.out.println("Ingrese la nueva cantidad del producto:");
        int nuevaCantidad = leerEntero(scanner, "-------- Cantidad no válida. Operación cancelada. --------");
        if (nuevaCantidad == Integer.MIN_VALUE) {
            System.out.println(" ");
            return;
        }
        if (nuevaCantidad <= 0) {
            System.out.println("La cantidad debe ser un número positivo mayor que cero. Operación cancelada.");
            System.out.println(" ");
            return;
        }

        System.out.println("Ingrese el nuevo precio del producto:");
        double nuevoPrecio = leerDouble(scanner, " -------- Precio no válido. Operación cancelada. --------");
        if (nuevoPrecio == Double.MIN_VALUE) {
            System.out.println(" ");
            return;
        }
        if (nuevoPrecio <= 0) {
            System.out.println("El precio debe ser un número positivo mayor que cero. Operación cancelada.");
            System.out.println(" ");
            return;
        }

        producto.setNombreProducto(nuevoNombre);
        producto.setCantidadProducto(nuevaCantidad);
        producto.setPrecioProducto(nuevoPrecio);
        System.out.println(" -------- Producto actualizado con éxito. -------- ");
        mostrarProducto(producto);
    }

    // Método para eliminar un producto del inventario
    public static void eliminarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Eliminar un producto");
        System.out.println("Ingrese el ID del producto que desea eliminar:"); // Solicita el ID del producto al usuario
        int id = leerEntero(scanner, " -------- ID no válido. Operación cancelada. -------- ");
        if (id == Integer.MIN_VALUE) {
            System.out.println(" ");
            return;
        }

        Producto producto = buscarProductoPorId(inventario, id);
        if (producto == null) {
            System.out.println(" -------- No se encontró un producto con el ID proporcionado. -------- ");
            System.out.println(" ");
        } else {
            inventario.remove(producto);
            System.out.println(" -------- Producto eliminado exitosamente. -------- ");
        }
    }
}
