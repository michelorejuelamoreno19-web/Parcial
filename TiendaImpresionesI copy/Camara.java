// Camara.java
// Una cámara también puede venderse como producto (por ejemplo: cámaras en tienda)
public class Camara extends ProductoBase {
    private String modelo;
    private String tipo; // ejemplo "digital", "reflex"

    public Camara(int id, String nombre, double precioBase, String modelo, String tipo) {
        super(id, nombre, precioBase);
        this.modelo = modelo;
        this.tipo = tipo;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " [" + tipo + " - " + modelo + "]";
    }

    // precio base ya definido en precioBase
}
