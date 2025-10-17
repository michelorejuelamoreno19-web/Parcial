/**
 * Demo de uso: crea cliente, fabrica productos usando Factory (Factory Method),
 * arma pedido, añade fotos a impresión y procesa pedido.
 */
public class Main {
    public static void main(String[] args) {
        // Crear cliente
        Cliente cliente = new Cliente("Ana Perez", "100200300", 200.0, "ana@mail.com");
        System.out.println("Cliente creado: " + cliente.resumen());

        // Mostrar tipos y crear productos con la fábrica
        Factory.mostrarTipos();
        Producto cam = Factory.crearProducto("camara");
        Producto imp = Factory.crearProducto("impresion");

        // Ensamblar y verificar
        if (cam != null) {
            cam.ensamblar();
            cam.verificar();
        }
        if (imp != null) {
            imp.ensamblar();
            imp.verificar();
        }

        // Si la impresion es la instancia concreta, agregar fotos (composición)
        if (imp instanceof Impresion) {
            Impresion impObj = (Impresion) imp;
            Foto f1 = new Foto(10, "Retrato", 0.5, 10);
            Foto f2 = new Foto(11, "Paisaje", 0.7, 5);
            f1.ensamblar();
            f2.ensamblar();
            impObj.agregarFoto(f1);
            impObj.agregarFoto(f2);
        }

        // Crear pedido
        Pedido pedido = new Pedido(cliente);
        if (cam != null) pedido.agregarProducto(cam);
        if (imp != null) pedido.agregarProducto(imp);

        pedido.mostrarResumen();

        // Intentar procesar (pagar). Si saldo insuficiente, prueba cargar saldo.
        pedido.procesar();

        // Si pago falló, cargar saldo y volver a procesar (demostración)
        if (cliente.getSaldo() < pedido.calcularTotal()) {
            cliente.cargarSaldo(200.0);
            pedido.procesar();
        }
    }
}
