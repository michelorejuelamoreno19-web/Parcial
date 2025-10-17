// Foto.java
// Una foto es un producto. Opcionalmente podemos guardar la cámara que la tomó.
public class Foto extends ProductoBase {
    private String resolucion;   // ejemplo "10x15"
    private Camara camara;       // cámara que tomó la foto (puede ser null)

    public Foto(int id, String nombre, double precioBase, String resolucion, Camara camara) {
        super(id, nombre, precioBase);
        this.resolucion = resolucion;
        this.camara = camara;
    }

    @Override
    public String getDescripcion() {
        String camInfo = (camara != null) ? " (tomada con: " + camara.getDescripcion() + ")" : "";
        return super.getDescripcion() + " [Foto " + resolucion + "]" + camInfo;
    }

    // Si quieres, puedes ajustar el precio según resolución u otros factores:
    @Override
    public double getPrecio() {
        // Ejemplo: fotos grandes +2.0
        if ("20x30".equalsIgnoreCase(resolucion)) return precioBase + 2.0;
        return precioBase;
    }
}
