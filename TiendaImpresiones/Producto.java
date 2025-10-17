/**
 * Clase abstracta Producto (padre) que implementa la interfaz OperacionesProducto.
 */
public abstract class Producto implements OperacionesProducto {
    protected int numero;
    protected String tipo;
    protected double precio;
    protected int stock;

    public Producto(int numero, String tipo, double precio, int stock) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters (2 de los métodos pedidos)
    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }

    // Métodos abstractos obligatorios por la interfaz
    @Override public abstract void ensamblar();
    @Override public abstract void verificar();
    @Override public abstract void entregar();
    @Override public abstract String resumen();
}
