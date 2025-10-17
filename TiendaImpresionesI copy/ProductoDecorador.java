// ProductoDecorador.java
// Decorador abstracto que envuelve cualquier Producto
public abstract class ProductoDecorador implements Producto {
    protected Producto producto;

    public ProductoDecorador(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio();
    }
}

class Marco extends ProductoDecorador {
    public Marco(Producto producto) { super(producto); }
    public String getDescripcion() { return producto.getDescripcion() + " con marco"; }
    public double getPrecio() { return producto.getPrecio() + 2.0; }
}

class AcabadoPremium extends ProductoDecorador {
    public AcabadoPremium(Producto producto) { super(producto); }
    public String getDescripcion() { return producto.getDescripcion() + " con acabado premium"; }
    public double getPrecio() { return producto.getPrecio() + 3.0; }
}

