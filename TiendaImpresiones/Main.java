import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto p1 = new Producto(1, "Impresión 10x15", 1.50, 100);
        Producto p2 = new Producto(2, "Marco Decorativo", 25.00, 10);

        // Crear clientes (nombres consistentes)
        Cliente cliente1 = new Cliente("1002345678", "Ana Pérez", "3001234567", "Calle 123 #45-67");
        Cliente cliente2 = new Cliente("1098765432", "Luis Gómez", "3017654321", "Carrera 10 #20-30");

        // Listas para mostrar "uno tras otro"
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(p1);
        productos.add(p2);

        // Mostrar clientes uno tras otro (formato vertical)
        System.out.println("=== CLIENTES ===");
        for (Cliente c : clientes) {
            c.mostrarResumen();
            System.out.println();
        }

        // Mostrar productos uno tras otro
        System.out.println("=== PRODUCTOS DISPONIBLES ===");
        for (Producto p : productos) {
            p.mostrarResumen();
            System.out.println();
        }

        // Construir pedido usando Builder: asignar cliente1 (asegúrate de usar cliente1, no cliente)
        System.out.println("=== CREANDO PEDIDO ===");
        Pedido pedido = null;
        try {
            pedido = new Pedido.Builder()
                        .asignarCliente(cliente1)  // <-- usa cliente1 aquí
                        .agregarProducto(p1, 3)
                        .agregarProducto(p2, 1)
                        .establecerFecha(new Date())
                        .build(); // valida, calcula y reduce stock

            // Mostrar resumen del pedido y total
            pedido.mostrarResumen();
            System.out.printf("Total: $%.2f%n", pedido.getTotal());
        } catch (Exception ex) {
            System.out.println("Error al crear pedido: " + ex.getMessage());
        }

        // Guardar y actualizar el pedido (simulado)
        if (pedido != null) {
            System.out.println("\n=== OPERACIONES SOBRE EL PEDIDO ===");
            pedido.guardarRegistro();
            pedido.actualizarDatos();
        }

        // Mostrar estado de stock tras confirmación
        System.out.println("\n=== STOCK ACTUALIZADO ===");
        p1.mostrarResumen();
        System.out.println();
        p2.mostrarResumen();
    }
}
