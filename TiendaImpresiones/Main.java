import java.util.*;

/**
 * Main interactivo
 *
 * Permite ingresar los datos del cliente y los productos desde consola,
 * construir el pedido con el patrón Builder y mostrar el resumen final.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== SISTEMA DE PEDIDOS DE IMPRESIÓN =====\n");

        // === INGRESAR DATOS DEL CLIENTE ===
        System.out.print("Ingrese cédula del cliente: ");
        String cedula = sc.nextLine();

        System.out.print("Ingrese nombre del cliente: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese teléfono del cliente: ");
        String telefono = sc.nextLine();

        System.out.print("Ingrese dirección del cliente: ");
        String direccion = sc.nextLine();

        Cliente cliente = new Cliente(cedula, nombre, telefono, direccion);

        System.out.println("\nCliente registrado:");
        cliente.mostrarResumen();

        // === INGRESAR PRODUCTOS ===
        System.out.print("\n¿Cuántos productos desea registrar? ");
        int numProductos = Integer.parseInt(sc.nextLine());

        List<Producto> productos = new ArrayList<>();

        for (int i = 0; i < numProductos; i++) {
            System.out.println("\n--- Producto #" + (i + 1) + " ---");
            System.out.print("Nombre del producto: ");
            String nombreProd = sc.nextLine();

            System.out.print("Precio unitario: ");
            double precio = Double.parseDouble(sc.nextLine());

            System.out.print("Cantidad en stock: ");
            int stock = Integer.parseInt(sc.nextLine());

            Producto p = new Producto(i + 1, nombreProd, precio, stock);
            productos.add(p);
        }

        System.out.println("\nProductos registrados:");
        for (Producto p : productos) {
            p.mostrarResumen();
        }

        // === CONSTRUCCIÓN DEL PEDIDO CON BUILDER ===
        Pedido pedido = null;
        try {
            Pedido.Builder builder = new Pedido.Builder()
                    .asignarCliente(cliente)
                    .establecerFecha(new Date());

            System.out.println("\nSeleccione los productos para el pedido:");

            for (Producto p : productos) {
                System.out.printf("¿Cuántas unidades de '%s' desea agregar? (Stock: %d) ", p.getNombre(), stockSafe(p));
                int cantidad = Integer.parseInt(sc.nextLine());
                if (cantidad > 0) {
                    builder.agregarProducto(p, cantidad);
                }
            }

            pedido = builder.build(); // valida y reduce stock

            System.out.println("\n=== PEDIDO CONFIRMADO ===");
            pedido.mostrarResumen();
            System.out.printf("Total: $%.2f%n", pedido.getTotal());

        } catch (Exception ex) {
            System.out.println("Error al crear pedido: " + ex.getMessage());
        }

        // === GUARDAR Y ACTUALIZAR ===
        if (pedido != null) {
            System.out.println("\n=== OPERACIONES SOBRE EL PEDIDO ===");
            pedido.guardarRegistro();
            pedido.actualizarDatos();
        }

        // === MOSTRAR STOCK ACTUAL ===
        System.out.println("\n=== STOCK ACTUALIZADO ===");
        for (Producto p : productos) {
            p.mostrarResumen();
        }

        System.out.println("\nGracias por usar el sistema.");
        sc.close();
    }

    // Método auxiliar para evitar errores de stock nulo
    private static int stockSafe(Producto p) {
        try {
            return (int) p.getClass().getDeclaredField("existencias").get(p);
        } catch (Exception e) {
            return 0;
        }
    }
}
