import java.util.ArrayList;
import java.util.Date;

/**
 * Clase Pedido: compone Cliente y lista de Producto.
 * 4 atributos y 4 métodos.
 */
public class Pedido {
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private String fecha;
    private double total;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.fecha = new Date().toString();
        this.total = 0.0;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        System.out.println("Producto agregado: " + p.resumen());
    }

    public double calcularTotal() {
        total = 0.0;
        for (Producto p : productos) total += p.getPrecio();
        return total;
    }

    public void procesar() {
        double t = calcularTotal();
        System.out.println("Procesando pedido. Total: $" + t);
        if (cliente.pagar(t)) {
            for (Producto p : productos) p.entregar();
            System.out.println("✅ Pedido procesado. Fecha: " + fecha);
        } else {
            System.out.println("🚫 Pedido cancelado por falta de pago.");
        }
    }

    public void mostrarResumen() {
        System.out.println("Pedido de: " + cliente.resumen() + " | Fecha: " + fecha + " | Total estimado: $" + calcularTotal());
    }
}
