// Impresion.java
public class Impresion extends ProductoBase {
    private String tipoPapel; // "mate", "brillo", etc.
    private String tamano;    // "10x15", "20x30"

    public Impresion(int id, String nombre, double precioBase, String tipoPapel, String tamano) {
        super(id, nombre, precioBase);
        this.tipoPapel = tipoPapel;
        this.tamano = tamano;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " [Impresión: " + tamano + ", papel: " + tipoPapel + "]";
    }

    @Override
    public double getPrecio() {
        // Ejemplo: impresiones grandes cobran más
        if ("20x30".equalsIgnoreCase(tamano)) return precioBase + 5.0;
        return precioBase;
    }
}
