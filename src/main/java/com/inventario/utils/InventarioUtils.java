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
        System.out.println("Ingrese el nombre del producto:"); // Solicita el nombre del producto al usuario
        String nombreProducto = scanner.nextLine(); // Lee el nombre del producto ingresado por el usuario

        System.out.println("Ingrese la cantidad del producto:");
        int cantidad = leerEntero(scanner, "Cantidad no válida. Operación cancelada.");// Solicita la cantidad del producto al usuario
        if (cantidad == Integer.MIN_VALUE)
            return; // Si la cantidad no es válida, se cancela la operación (Integer.MIN_VALUE es un valor de error)

        System.out.println("Ingrese el precio del producto:"); // Solicita el precio del producto al usuario
        double precio = leerDouble(scanner, "Precio no válido. Operación cancelada."); // Lee el precio del producto ingresado por el usuario
        if (precio == Double.MIN_VALUE)
            return; // Si el precio no es válido, se cancela la operación (Double.MIN_VALUE es un valor de error)

        Producto nuevo = new Producto(nombreProducto, cantidad, precio); // Crea un nuevo objeto Producto con los datos ingresados por el usuario
        inventario.add(nuevo); // Agrega el nuevo producto al inventario (ArrayList de productos)
        System.out.println("Producto agregado:");
        mostrarProducto(nuevo); // Muestra los detalles del producto recién agregado
    }

    // Método para ver el inventario actual
    public static void verInventario(ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Ver el inventario actual");
        if (inventario.isEmpty()) { // Verifica si el inventario está vacío
            System.out.println("El inventario está vacío."); // Si está vacío, muestra un mensaje indicando que no hay productos
        } else { // Si hay productos en el inventario, los muestra
            for (Producto p : inventario) { // Recorre cada producto en el inventario (ArrayList de productos)
                // Muestra los detalles de cada producto
                System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombreProducto() + " | Cantidad: " + p.getCantidadProducto() + " | Precio: " + p.getPrecioProducto());
            }
        }
    }

    // Método para actualizar un producto existente en el inventario
    public static void actualizarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Actualizar un producto");
        System.out.println("Ingrese el ID del producto que desea actualizar:"); // Solicita el ID del producto al usuario
        int id = leerEntero(scanner, "ID no válido. Operación cancelada."); // Lee el ID del producto ingresado por el usuario
        if (id == Integer.MIN_VALUE)
            return; // Si el ID no es válido, se cancela la operación (Integer.MIN_VALUE es un valor de error)

        Producto producto = buscarProductoPorId(inventario, id); // Busca el producto en el inventario utilizando el ID proporcionado
        if (producto == null) {
            System.out.println("No se encontró un producto con el ID proporcionado."); // Si no se encuentra el producto, muestra un mensaje indicando que no existe
            return; // Termina la operación si el producto no se encuentra
        }

        System.out.println("Producto encontrado:");  // Si se encuentra el producto, muestra sus detalles
        mostrarProducto(producto);

        System.out.println("Ingrese el nuevo nombre del producto:"); // Solicita el nuevo nombre del producto al usuario
        String nuevoNombre = scanner.nextLine(); // Lee el nuevo nombre del producto ingresado por el usuario

        System.out.println("Ingrese la nueva cantidad del producto:"); // Solicita la nueva cantidad del producto al usuario
        int nuevaCantidad = leerEntero(scanner, "Cantidad no válida. Operación cancelada."); // Lee la nueva cantidad del producto ingresada por el usuario
        if (nuevaCantidad == Integer.MIN_VALUE)
            return; // Si la nueva cantidad no es válida, se cancela la operación (Integer.MIN_VALUE es un valor de error)

        System.out.println("Ingrese el nuevo precio del producto:"); // Solicita el nuevo precio del producto al usuario
        double nuevoPrecio = leerDouble(scanner, "Precio no válido. Operación cancelada."); // Lee el nuevo precio del producto ingresado por el usuario
        if (nuevoPrecio == Double.MIN_VALUE)
            return; // Si el nuevo precio no es válido, se cancela la operación (Double.MIN_VALUE es un valor de error)

        producto.setNombreProducto(nuevoNombre); // Actualiza el nombre del producto con el nuevo nombre ingresado por el usuario
        producto.setCantidadProducto(nuevaCantidad); // Actualiza la cantidad del producto con la nueva cantidad ingresada por el usuario
        producto.setPrecioProducto(nuevoPrecio); // Actualiza el precio del producto con el nuevo precio ingresado por el usuario
        System.out.println("Producto actualizado con éxito.");
        mostrarProducto(producto); // Muestra los detalles del producto actualizado
    }

    // Método para eliminar un producto del inventario
    public static void eliminarProducto(Scanner scanner, ArrayList<Producto> inventario) {
        System.out.println("Opción seleccionada: Eliminar un producto");
        System.out.println("Ingrese el ID del producto que desea eliminar:"); // Solicita el ID del producto al usuario
        int id = leerEntero(scanner, "ID no válido. Operación cancelada."); // Lee el ID del producto ingresado por el usuario
        if (id == Integer.MIN_VALUE)
            return; // Si el ID no es válido, se cancela la operación (Integer.MIN_VALUE es un valor de error)

        Producto producto = buscarProductoPorId(inventario, id); // Busca el producto en el inventario utilizando el ID proporcionado
        if (producto == null) { // Si no se encuentra el producto, muestra un mensaje indicando que no existe
            System.out.println("No se encontró un producto con el ID proporcionado.");
        } else { // Si se encuentra el producto, lo elimina del inventario
            inventario.remove(producto); // Se elimina el producto del inventario ocupand el método remove de ArrayList
            System.out.println("Producto eliminado exitosamente."); // Muestra un mensaje indicando que el producto se ha eliminado correctamente
        }
    }
}
