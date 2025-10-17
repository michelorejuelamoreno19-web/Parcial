/**
 * Factory (Factory Method simplificado).
 * Tiene el método fábrica crearProducto(tipo: String): Producto
 * además de métodos auxiliares: mostrarTipos, crearCamaraDefecto, crearImpresionDefecto.
 */
public class Factory {

    /**
     * Método fábrica: devuelve Producto según tipo.
     * Tipos reconocidos: "camara", "impresion".
     */
    public static Producto crearProducto(String tipo) {
        if (tipo == null) return null;
        switch (tipo.toLowerCase()) {
            case "camara":
                return crearCamaraDefecto();
            case "impresion":
                return crearImpresionDefecto();
            default:
                System.out.println("Tipo no reconocido: " + tipo);
                return null;
        }
    }

    // Muestra las opciones disponibles
    public static void mostrarTipos() {
        System.out.println("Tipos disponibles: camara, impresion");
    }

    // Creadores por defecto (métodos auxiliares solicitados)
    public static Camara crearCamaraDefecto() {
        return new Camara(1, 1200.0, 5, "Canon", "R8", 24.2, "CN-0001");
    }

    public static Impresion crearImpresionDefecto() {
        return new Impresion(2, 3.5, 100, "Color", "A4", 600, 50);
    }
}

