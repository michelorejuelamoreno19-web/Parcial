/**
 * Foto
 *
 * Representa una imagen/fotografía que puede imprimirse.
 * Implementa InterfazDeImpresion para validación y operaciones básicas.
 */
public class Foto implements InterfazDeImpresion {
    private String archivo;
    private String resolucion;
    private int pesoKb;
    private String formato;

    /**
     * Constructor de Foto.
     * @param archivo Nombre de archivo (ej. "imagen.jpg").
     * @param resolucion Texto que describe la resolución (ej. "1080p").
     * @param pesoKb Tamaño aproximado en KB.
     * @param formato Formato de archivo (ej. "jpg").
     */
    public Foto(String archivo, String resolucion, int pesoKb, String formato) {
        this.archivo = archivo;
        this.resolucion = resolucion;
        this.pesoKb = pesoKb;
        this.formato = formato;
    }

    /**
     * Valida que el archivo exista nominalmente y tenga peso positivo.
     * @return true si la foto parece válida.
     */
    @Override
    public boolean esValido() {
        return archivo != null && archivo.endsWith(".jpg") && pesoKb > 0;
    }

    /**
     * Muestra metadatos de la foto en consola.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Foto{" + archivo + ", " + resolucion + ", " + pesoKb + "KB, formato=" + formato + "}");
    }

    /**
     * Simula guardado de la foto en sistema de archivos.
     */
    @Override
    public void guardarRegistro() {
        System.out.println("[FS] Guardando foto " + archivo + " (simulado).");
    }

    /**
     * Simula actualización de metadatos de la foto.
     */
    @Override
    public void actualizarDatos() {
        System.out.println("[Foto] Actualizando metadatos de " + archivo + " (simulado).");
    }

    /* Métodos auxiliares opcionales */

    /**
     * Reduce el tamaño de la foto devolviendo una nueva instancia con peso menor.
     * @param nuevoKb Nuevo tamaño máximo en KB.
     * @return nueva Foto con tamaño ajustado.
     */
    public Foto reducirTamano(int nuevoKb) {
        int finalKb = Math.min(nuevoKb, pesoKb);
        return new Foto(archivo, resolucion, finalKb, formato);
    }
}
