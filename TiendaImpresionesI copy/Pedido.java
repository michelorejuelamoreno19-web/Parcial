// Pedido.java
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Cliente cliente;    // opcional (puede ser null)
    private List<Producto> items;

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        items.add(p);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : items) total += p.getPrecio();
        return total;
    }

    public void mostrarPedido() {
        System.out.println("Pedido #" + idPedido + (cliente != null ? " - Cliente: " + cliente.getNombre() : ""));
        for (Producto p : items) {
            System.out.printf("- %s -> $%.2f%n", p.getDescripcion(), p.getPrecio());
        }
        System.out.printf("Total: $%.2f%n", calcularTotal());
    }
}
