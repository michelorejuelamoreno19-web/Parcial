import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Pedido
 *
 * Representa un pedido de productos y (opcionalmente) servicios de impresión.
 * Implementa InterfazDeImpresion y contiene un Builder interno para construir
 * el pedido de forma segura y validada.
 */
public class Pedido implements InterfazDeImpresion {
    public enum Estado { NUEVO, PAGADO, EN_PROCESO, ENVIADO, ENTREGADO, CANCELADO }

    private static int CONTADOR = 1;

    private int id;
    private Cliente cliente;
    private Map<Producto, Integer> carrito = new HashMap<>();
    private double total;
    private Date fecha;
    private Estado estado;

    private Pedido() {
        this.id = CONTADOR++;
        this.fecha = new Date();
        this.total = 0.0;
        this.estado = Estado.NUEVO;
    }

    /**
     * Comprueba que el pedido tiene cliente y al menos un producto en el carrito.
     * @return true si el pedido es válido para construir.
     */
    @Override
    public boolean esValido() {
        return cliente != null && !carrito.isEmpty();
    }

    /**
     * Muestra el resumen completo del pedido con lista de productos y total.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Pedido{id=" + id + ", fecha=" + fecha + ", total=$" + String.format("%.2f", total) + ", estado=" + estado + "}");
        if (cliente != null) System.out.println("  Cliente: " + cliente);
        for (Map.Entry<Producto, Integer> e : carrito.entrySet()) {
            System.out.println("  - " + e.getKey().getNombre() + " x" + e.getValue() + " -> $" + String.format("%.2f", e.getKey().getPrecio() * e.getValue()));
        }
    }

    /**
     * Simula persistencia del pedido.
     */
    @Override
    public void guardarRegistro() {
        System.out.println("[DB] Pedido " + id + " guardado (simulado).");
    }

    /**
     * Recalcula total y simula actualización.
     */
    @Override
    public void actualizarDatos() {
        System.out.println("[Pedido] Actualizando datos (recalculando total) para #" + id);
        calcularMonto();
    }

    /* Métodos auxiliares privados */

    /**
     * Calcula el monto total sumando precio*cantidad por cada producto.
     */
    private void calcularMonto() {
        double suma = 0.0;
        Set<Producto> productos = carrito.keySet();
        for (Producto p : productos) {
            int cantidad = carrito.getOrDefault(p, 0);
            suma += p.getPrecio() * cantidad;
        }
        this.total = suma;
    }

    /** Devuelve el total calculado del pedido. */
    public double getTotal() { return total; }

    /**
     * Builder para crear instancias de Pedido de forma controlada.
     */
    public static class Builder {
        private Pedido p;

        /** Inicia un nuevo builder con un Pedido vacío. */
        public Builder() { p = new Pedido(); }

        /**
         * Asigna el cliente al pedido.
         * @param c cliente a asociar.
         * @return el propio Builder para encadenar llamadas.
         */
        public Builder asignarCliente(Cliente c) {
            p.cliente = c;
            return this;
        }

        /**
         * Agrega un producto y cantidad al carrito. Si el producto ya existe, suma cantidades.
         * @param producto producto a añadir.
         * @param cantidad unidades a agregar.
         * @return Builder (encadenable).
         * @throws IllegalArgumentException si producto nulo o cantidad <= 0.
         */
        public Builder agregarProducto(Producto producto, int cantidad) {
            if (producto == null) throw new IllegalArgumentException("Producto nulo");
            if (cantidad <= 0) throw new IllegalArgumentException("Cantidad debe ser > 0");
            int actual = p.carrito.getOrDefault(producto, 0);
            p.carrito.put(producto, actual + cantidad);
            return this;
        }

        /**
         * Permite establecer manualmente la fecha del pedido.
         * @param fecha fecha a fijar.
         * @return Builder.
         */
        public Builder establecerFecha(Date fecha) {
            if (fecha != null) p.fecha = fecha;
            return this;
        }

        /**
         * Valida el pedido antes de construirlo.
         * @return true si p.esValido()
         */
        public boolean validarAntesBuild() {
            return p.esValido();
        }

        /**
         * Construye y confirma el pedido:
         * - Valida integridad del pedido.
         * - Calcula monto total.
         * - Valida stock y reduce existencias (efecto de confirmación).
         * - Cambia estado a PAGADO (simulación).
         * @return Pedido confirmado.
         * @throws IllegalStateException si faltan datos o hay stock insuficiente.
         */
        public Pedido build() {
            if (!validarAntesBuild()) throw new IllegalStateException("Pedido inválido: falta cliente o productos");
            p.calcularMonto();
            for (Map.Entry<Producto, Integer> e : p.carrito.entrySet()) {
                Producto prod = e.getKey();
                int cantidad = e.getValue();
                if (!prod.hayStock(cantidad)) {
                    throw new IllegalStateException("Stock insuficiente para: " + prod.getNombre());
                }
                prod.reducirStock(cantidad);
            }
            p.estado = Estado.PAGADO;
            return p;
        }

        /**
         * Construye un borrador del pedido sin efectos colaterales (no reduce stock).
         * @return Pedido en estado borrador.
         */
        public Pedido buildDraft() {
            p.calcularMonto();
            return p;
        }

        /**
         * Reinicia el Builder para crear un nuevo Pedido.
         * @return Builder reiniciado.
         */
        public Builder clear() { p = new Pedido(); return this; }
    }
}
