/**
 * Programa principal: demuestra el patrón Factory Method
 * con dos clientes: uno con saldo suficiente y otro sin saldo.
 * Se muestra todo el proceso de compra, pago y entrega.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("\n====================================");
        System.out.println("  DEMOSTRACIÓN PATRÓN FACTORY METHOD");
        System.out.println("====================================");

        // 1️⃣ Crear dos clientes
        Cliente cliente1 = new Cliente("Michell Orejuela", "10154588", 5000.0, "michell@mail.com");
        Cliente cliente2 = new Cliente("Juan Pérez", "10154477", 100.0, "juanperez@mail.com");

        System.out.println("\n=== CLIENTES CREADOS ===");
        System.out.println("Cliente 1: " + cliente1.resumen());
        System.out.println("Cliente 2: " + cliente2.resumen());

        // 2️⃣ Mostrar los tipos de productos disponibles
        System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
        Factory.mostrarTipos();

        // 3️⃣ Crear productos usando el patrón Factory Method
        Producto camara = Factory.crearProducto("camara");
        Producto impresion = Factory.crearProducto("impresion");

        // 4️⃣ Ensamblar y verificar los productos antes de la venta
        System.out.println("\n=== ENSAMBLAJE Y VERIFICACIÓN ===");
        camara.ensamblar();
        camara.verificar();
        impresion.ensamblar();
        impresion.verificar();

        // 5️⃣ Crear pedidos para cada cliente
        Pedido pedido1 = new Pedido(cliente1);
        Pedido pedido2 = new Pedido(cliente2);

        pedido1.agregarProducto(camara);
        pedido1.agregarProducto(impresion);

        pedido2.agregarProducto(camara);
        pedido2.agregarProducto(impresion);

        // 6️⃣ Mostrar los resúmenes de ambos pedidos
        System.out.println("\n=== RESUMEN DE PEDIDOS ===");
        System.out.println("\n--- Pedido Cliente 1 ---");
        pedido1.mostrarResumen();
        System.out.println("\n--- Pedido Cliente 2 ---");
        pedido2.mostrarResumen();

        // 7️⃣ Procesar ambos pedidos
        System.out.println("\n=== PROCESANDO PEDIDOS ===");

        System.out.println("\n--- Pedido Cliente 1 (saldo suficiente) ---");
        pedido1.procesar();  // Pago exitoso ✅

        System.out.println("\n--- Pedido Cliente 2 (saldo insuficiente) ---");
        pedido2.procesar();  // Pago rechazado ❌

        // 8️⃣ Mostrar el saldo final de ambos clientes
        System.out.println("\n=== SALDOS FINALES ===");
        System.out.println(cliente1.resumen());
        System.out.println(cliente2.resumen());
    }
}
