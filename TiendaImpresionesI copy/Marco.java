// Marco.java
// Decorador concreto: añade un marco al producto
public class Marco extends ProductoDecorador {
    private double costoMarco;

    public Marco(Producto producto, double costoMarco) {
        super(producto);
        this.costoMarco = costoMarco;
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + marco";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + costoMarco;
    }
}

