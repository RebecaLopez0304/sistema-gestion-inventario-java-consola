package main.java.com.inventario;

import main.java.com.inventario.classes.Producto;
import main.java.com.inventario.utils.InventarioUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerNuevo = new Scanner(System.in); // Scanner para leer la entrada del usuario en la consola
        ArrayList<Producto> inventario = new ArrayList<>(); // Lista para almacenar los productos del inventario (ArrayList es una colección que permite almacenar objetos dinámicamente)

        while (true) { // Bucle infinito para mostrar el menú y permitir al usuario interactuar con el sistema
            InventarioUtils.mostrarMenu(); // Método para mostrar el menú de opciones al usuario
            int opcion = InventarioUtils.leerOpcion(scannerNuevo); // Método para leer la opción seleccionada por el usuario

            switch (opcion) {
                case 1: // Opción para agregar un nuevo producto al inventario
                    InventarioUtils.agregarProducto(scannerNuevo, inventario);
                    break;
                case 2: // Opción para ver el inventario actual
                    InventarioUtils.verInventario(inventario);
                    break;
                case 3: // Opción para actualizar un producto existente en el inventario
                    InventarioUtils.actualizarProducto(scannerNuevo, inventario);
                    break;
                case 4: // Opción para eliminar un producto del inventario
                    InventarioUtils.eliminarProducto(scannerNuevo, inventario);
                    break;
                case 5: // Opción para salir del sistema
                    System.out.println("Gracias por usar el sistema de gestión de inventario.");
                    return;
                default: // Opción no válida
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
}
