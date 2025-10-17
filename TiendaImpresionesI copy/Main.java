// Main.java
public class Main {
    public static void main(String[] args) {
        // Crear cliente
        Cliente cliente = new Cliente(1, "Michell Orejuela", "310-555-1234");

        // Productos base
        Camara camara = new Camara(100, "Camara X100", 250.0, "X100", "Digital");
        Foto foto = new Foto(1, "Foto de vacaciones", 5.0, "10x15", camara);
        Impresion impresion = new Impresion(2, "Poster evento", 12.0, "brillo", "20x30");

        // Mostrar base
        System.out.println("Productos base:");
        System.out.println(foto.getDescripcion() + " -> $" + foto.getPrecio());
        System.out.println(camara.getDescripcion() + " -> $" + camara.getPrecio());
        System.out.println(impresion.getDescripcion() + " -> $" + impresion.getPrecio());
        System.out.println();

        // Aplicar decoradores (dinámicamente)
        Producto fotoDecorada = new Marco(foto, 3.0);                 // foto + marco
        fotoDecorada = new AcabadoPremium(fotoDecorada, 2.5);         // + acabado premium
        fotoDecorada = new EnvoltorioRegalo(fotoDecorada, 1.0);       // + envoltorio regalo

        Producto impresionDecorada = new AcabadoPremium(impresion, 4.0); // impresión premium

        // Crear pedido y agregar items
        Pedido pedido = new Pedido(5001, cliente);
        pedido.agregarProducto(camara);            // vendemos la cámara
        pedido.agregarProducto(fotoDecorada);      // foto con varios extras
        pedido.agregarProducto(impresionDecorada); // impresión con acabado

        // Asociar pedido al cliente y mostrar
        cliente.agregarPedido(pedido);

        System.out.println("--- Resumen pedido ---");
        pedido.mostrarPedido();

        System.out.println();
        System.out.println("--- Pedidos del cliente ---");
        cliente.mostrarPedidos();
    }
}
