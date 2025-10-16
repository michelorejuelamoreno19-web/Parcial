import java.util.ArrayList;
import java.util.List;

/**
 * Impresion
 *
 * Agrupa fotos y calcula el costo de impresión según modo, formato y copias.
 * Implementa InterfazDeImpresion.
 */
public class Impresion implements InterfazDeImpresion {
    private String modoColor;
    private String formato;
    private int copias;
    private List<Foto> fotos = new ArrayList<>();

    /**
     * Crea un trabajo de impresión.
     * @param modoColor "Color" o "B/N".
     * @param formato Formato físico (ej. "10x15").
     * @param copias Número de copias por foto.
     */
    public Impresion(String modoColor, String formato, int copias) {
        this.modoColor = modoColor;
        this.formato = formato;
        this.copias = copias;
    }

    /**
     * Valida que exista al menos una foto y copias positivas.
     * @return true si la impresión está configurada.
     */
    @Override
    public boolean esValido() {
        return copias > 0 && !fotos.isEmpty();
    }

    /**
     * Muestra resumen del trabajo de impresión.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Impresion{" + modoColor + ", " + formato + ", copias=" + copias + ", fotos=" + fotos.size() + "}");
    }

    /**
     * Simula guardar el trabajo de impresión.
     */
    @Override
    public void guardarRegistro() {
        System.out.println("[DB] Impresión guardada (simulado).");
    }

    /**
     * Simula actualización del registro de impresión.
     */
    @Override
    public void actualizarDatos() {
        System.out.println("[Impresion] Actualizando registro de impresión (simulado).");
    }

    /* Métodos auxiliares para manejar las fotos (no cuentan entre los 4 públicos) */

    /**
     * Agrega una foto al trabajo de impresión.
     * @param f Foto a añadir.
     */
    public void agregarFoto(Foto f) { if (f != null) fotos.add(f); }

    /**
     * Calcula el costo aproximado de la impresión.
     * @return costo total.
     */
    public double calcularCosto() {
        double base = 0.30;
        if ("Color".equalsIgnoreCase(modoColor)) base += 0.10;
        if ("10x15".equalsIgnoreCase(formato)) base += 0.15;
        return base * copias * Math.max(1, fotos.size());
    }
}
