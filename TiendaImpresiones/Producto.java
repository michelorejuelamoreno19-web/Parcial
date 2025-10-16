/**
 * Producto
 *
 * Representa un producto del catálogo (ej. impresión, marco, álbum).
 * Implementa InterfazDeImpresion y define métodos auxiliares para gestión
 * de stock y consulta de precio.
 */
public class Producto implements InterfazDeImpresion {
    private int codigo;
    private String nombre;
    private double precio;
    private int existencias;

    /**
     * Crea un producto con los atributos base.
     * @param codigo Identificador numérico.
     * @param nombre Nombre del producto.
     * @param precio Precio unitario.
     * @param existencias Cantidad disponible en inventario.
     */
    public Producto(int codigo, String nombre, double precio, int existencias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }

    /**
     * Valida que el producto tenga nombre, precio y existencias coherentes.
     * @return true si es válido.
     */
    @Override
    public boolean esValido() {
        return nombre != null && !nombre.isEmpty() && precio > 0 && existencias >= 0;
    }

    /**
     * Muestra por consola un resumen del producto.
     */
    @Override
    public void mostrarResumen() {
        System.out.printf("Producto{codigo=%d, nombre=%s, precio=%.2f, stock=%d}\n", codigo, nombre, precio, existencias);
    }

    /**
     * Simula guardar el producto en base de datos.
     */
    @Override
    public void guardarRegistro() {
        System.out.println("[DB] Guardando producto " + nombre + " (simulado).");
    }

    /**
     * Simula actualizar metadatos o sincronizar con persistencia.
     */
    @Override
    public void actualizarDatos() {
        System.out.println("[Producto] Actualizando registro de " + nombre + " (simulado).");
    }

    /* Métodos auxiliares para uso interno (no forman parte de los 4 obligatorios) */

    /**
     * Devuelve el precio unitario.
     * @return precio.
     */
    public double getPrecio() { return precio; }

    /**
     * Devuelve el nombre del producto.
     * @return nombre.
     */
    public String getNombre() { return nombre; }

    /**
     * Verifica si hay suficiente stock de una cantidad solicitada.
     * @param cantidad Cantidad requerida.
     * @return true si hay stock suficiente.
     */
    public boolean hayStock(int cantidad) { return cantidad <= existencias; }

    /**
     * Reduce las existencias del producto. Lanza IllegalArgumentException si no hay stock.
     * @param cantidad Cantidad a reducir.
     */
    public void reducirStock(int cantidad) {
        if (!hayStock(cantidad)) throw new IllegalArgumentException("Stock insuficiente: " + nombre);
        existencias -= cantidad;
    }

    /**
     * Reponer existencias (uso auxiliar).
     * @param cantidad unidades a añadir.
     */
    void reponerStock(int cantidad) { if (cantidad>0) existencias += cantidad; }
}
