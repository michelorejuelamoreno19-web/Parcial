/**
 * InterfazDeImpresion
 *
 * Interfaz que define el contrato mínimo que deben implementar
 * las entidades del dominio relacionadas con impresión/pedidos.
 * Contiene 4 métodos obligatorios: validación, resumen, persistencia
 * y actualización.
 */
public interface InterfazDeImpresion {
    /**
     * Valida la integridad mínima del objeto.
     * @return true si el objeto está en estado válido, false en caso contrario.
     */
    boolean esValido();

    /**
     * Muestra un resumen legible del objeto en consola (uso demostrativo).
     */
    void mostrarResumen();

    /**
     * Simula la persistencia/registro del objeto (por ejemplo en BD).
     */
    void guardarRegistro();

    /**
     * Simula la actualización o recálculo de datos relevantes del objeto.
     */
    void actualizarDatos();
}

