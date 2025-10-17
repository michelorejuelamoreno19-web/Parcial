/**
 * Clase Foto. Está separada de Producto y puede usarse en Impresion.
 */
public class Foto {
    private int numero;
    private String tipo;
    private double precio;
    private int stock;

    public Foto(int numero, String tipo, double precio, int stock) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos pedidos (getTipo, getPrecio, ensamblar, resumen)
    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }

    // Simula preparar la foto antes de imprimir
    public void ensamblar() {
        System.out.println("Foto #" + numero + " ensamblada (tipo: " + tipo + ")");
    }

    public String resumen() {
        return "Foto #" + numero + " - " + tipo + " $" + precio + " (stock: " + stock + ")";
    }
}
