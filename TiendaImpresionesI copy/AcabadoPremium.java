// AcabadoPremium.java
// Decorador concreto: acabado premium (mejora del producto)
public class AcabadoPremium extends ProductoDecorador {
    private double costoAdicional;

    public AcabadoPremium(Producto producto, double costoAdicional) {
        super(producto);
        this.costoAdicional = costoAdicional;
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + acabado premium";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + costoAdicional;
    }
}

