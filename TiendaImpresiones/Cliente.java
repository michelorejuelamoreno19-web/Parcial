/**
 * Clase Cliente con 4 atributos y 4 métodos.
 */
public class Cliente {
    private String nombre;
    private String cedula;
    private double saldo;
    private String email;

    public Cliente(String nombre, String cedula, double saldo, String email) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.saldo = saldo;
        this.email = email;
    }

    public boolean pagar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("💳 Pago de $" + monto + " realizado. Saldo: $" + saldo);
            return true;
        } else {
            System.out.println("❌ Saldo insuficiente. Saldo actual: $" + saldo);
            return false;
        }
    }

    public void cargarSaldo(double monto) {
        saldo += monto;
        System.out.println("Saldo cargado: $" + monto + ". Nuevo saldo: $" + saldo);
    }

    public double getSaldo() { return saldo; }

    public String resumen() {
        return nombre + " (" + cedula + ") - " + email + " - saldo: $" + saldo;
    }
}
