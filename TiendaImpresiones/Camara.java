/**
 * Subclase Camara de Producto.
 * 4 atributos y 4 métodos (implementa los de la interfaz).
 */
public class Camara extends Producto {
    private String marca;
    private String modelo;
    private double megapixeles;
    private String serial;

    public Camara(int numero, double precio, int stock,
                  String marca, String modelo, double megapixeles, String serial) {
        super(numero, "Camara", precio, stock);
        this.marca = marca;
        this.modelo = modelo;
        this.megapixeles = megapixeles;
        this.serial = serial;
    }

    @Override
    public void ensamblar() {
        System.out.println("🔧 Ensamblando cámara " + marca + " " + modelo);
    }

    @Override
    public void verificar() {
        System.out.println("✅ Verificando cámara " + marca + " (" + megapixeles + " MP)");
    }

    @Override
    public void entregar() {
        System.out.println("📦 Entregando cámara S/N:" + serial);
    }

    @Override
    public String resumen() {
        return "Camara " + marca + " " + modelo + " - " + megapixeles + "MP $" + precio;
    }
}
