// Cliente.java
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nombre;
    private String telefono;
    private List<Pedido> pedidos;

    public Cliente(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }

    public String getNombre() { return nombre; }
    public int getId() { return id; }

    public void mostrarPedidos() {
        System.out.println("Pedidos de " + nombre + ":");
        for (Pedido p : pedidos) {
            p.mostrarPedido();
            System.out.println("-----");
        }
    }
}
