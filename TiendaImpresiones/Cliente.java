/**
 * Cliente
 *
 * Representa un cliente que realiza pedidos. Implementa InterfazDeImpresion
 * por lo que obliga a implementar los cuatro métodos: validar, mostrar,
 * guardar y actualizar.
 */
public class Cliente implements InterfazDeImpresion {
    private String cedula;
    private String nombre;
    private String telefono;
    private String direccion;

    public Cliente(String cedula, String nombre, String telefono, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
        System.out.println("-----------------------------"); // separador visual
    }
    /**
     * Valida que el cliente tenga identificación y nombre no vacíos.
     * @return true si es válido, false en caso contrario.
     */
    @Override
    public boolean esValido() {
        return cedula != null && !cedula.isEmpty() && nombre != null && !nombre.isEmpty();
    }

    /**
     * Simula persistir el registro del cliente.
     */
    @Override
    public void guardarRegistro() {
        System.out.println("[DB] Guardando cliente " + nombre + " (simulado).");
    }

    /**
     * Simula una operación de actualización sobre los datos del cliente.
     */
    @Override
    public void actualizarDatos() {
        System.out.println("[Cliente] Actualizando datos de " + nombre + " (simulado).");
    }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }

    /* Métodos auxiliares (package-private / privados) que NO se consideran como
       parte de los 4 métodos obligatorios de la interfaz. Se incluyen para
       uso interno en otras clases (por ejemplo Pedido). */

    String obtenerCedula() { return cedula; }
    String obtenerNombre() { return nombre; }
}
