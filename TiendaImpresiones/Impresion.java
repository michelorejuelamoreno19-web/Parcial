import java.util.ArrayList;

/**
 * Subclase Impresion de Producto.
 * Composición: contiene una lista de Foto.
 */
public class Impresion extends Producto {
    private String color;
    private String formato;
    private int resolucion;
    private int cantidad; // unidades a imprimir

    private ArrayList<Foto> fotos; // composición

    public Impresion(   int numero, double precio, int stock,
                     String color, String formato, int resolucion, int cantidad) {
        super(numero, "Impresion", precio, stock);
        this.color = color;
        this.formato = formato;
        this.resolucion = resolucion;
        this.cantidad = cantidad;
        this.fotos = new ArrayList<>();
    }

    // Composición: agregar foto
    public void agregarFoto(Foto f) {
        fotos.add(f);
        System.out.println("Foto agregada a impresion: " + f.getTipo());
    }

    @Override
    public void ensamblar() {
        System.out.println("🖨️ Preparando impresora (formato: " + formato + ", color: " + color + ")");
    }

    @Override
    public void verificar() {
        System.out.println("🔍 Verificando impresión a " + resolucion + " DPI. Fotos: " + fotos.size());
    }

    @Override
    public void entregar() {
        System.out.println("📦 Entregando " + cantidad + " impresiones (" + formato + ")");
    }

    @Override
    public String resumen() {
        return "Impresion " + formato + " - " + color + " DPI:" + resolucion + " $" + precio;
    }
}
