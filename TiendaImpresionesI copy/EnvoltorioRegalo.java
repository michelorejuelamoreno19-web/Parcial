// EnvoltorioRegalo.java
// Decorador opcional: envoltorio para regalo
public class EnvoltorioRegalo extends ProductoDecorador {
    private double costoEnvoltorio;

    public EnvoltorioRegalo(Producto producto, double costoEnvoltorio) {
        super(producto);
        this.costoEnvoltorio = costoEnvoltorio;
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + envoltorio regalo";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + costoEnvoltorio;
    }
}

