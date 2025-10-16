import java.util.Date;

/**
 * Main
 *
 * Programa de ejemplo que muestra la creación de productos, cliente y
 * la construcción de un pedido mediante el patrón Builder.
 */
public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto p1 = new Producto(1, "Impresión 10x15", 1.50, 100);
        Producto p2 = new Producto(2, "Marco Decorativo", 25.00, 10);

        // Crear cliente
        Cliente cliente = new Cliente("1002345678", "Ana Pérez", "3001234567", "Calle 123 #45-67");

        // Mostrar datos iniciales
        System.out.println("=== CLIENTE ===");
        cliente.mostrarResumen();

        System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
        p1.mostrarResumen();
        p2.mostrarResumen();

        // Construir pedido usando Builder: asignar cliente, agregar productos y confirmar
        System.out.println("\n=== CREANDO PEDIDO ===");
        Pedido pedido = null;
        try {
            pedido = new PedidoBuilder()
                        .asignarCliente(cliente)
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
        p2.mostrarResumen();
    }
}
