public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto miFoto = new Foto();
        Producto miImpresion = new Impresion();

        // Decorar productos
        miFoto = new Marco(miFoto);             // Foto con marco
        miFoto = new AcabadoPremium(miFoto);    // Foto con marco y acabado premium

        miImpresion = new AcabadoPremium(miImpresion); // Impresión con acabado premium

        // Mostrar resultados
        System.out.println(miFoto.getDescripcion() + " -> $" + miFoto.getPrecio());
        System.out.println(miImpresion.getDescripcion() + " -> $" + miImpresion.getPrecio());

        // Se podría agregar al pedido
        Pedido pedido = new Pedido();
        pedido.agregarProducto(miFoto);
        pedido.agregarProducto(miImpresion);
        pedido.mostrarPedido();
    }
}
