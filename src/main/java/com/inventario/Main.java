package main.java.com.inventario;

import main.java.com.inventario.classes.Producto;
import main.java.com.inventario.utils.InventarioUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerNuevo = new Scanner(System.in);
        ArrayList<Producto> inventario = new ArrayList<>();

        while (true) {
            InventarioUtils.mostrarMenu();
            int opcion = InventarioUtils.leerOpcion(scannerNuevo);

            switch (opcion) {
                case 1:
                    InventarioUtils.agregarProducto(scannerNuevo, inventario);
                    break;
                case 2:
                    InventarioUtils.verInventario(inventario);
                    break;
                case 3:
                    InventarioUtils.actualizarProducto(scannerNuevo, inventario);
                    break;
                case 4:
                    InventarioUtils.eliminarProducto(scannerNuevo, inventario);
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema de gestión de inventario.");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
}
