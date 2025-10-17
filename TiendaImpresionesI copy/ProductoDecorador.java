public abstract class ProductoDecorador implements Producto {
    protected Producto producto;  // El producto que estamos decorando
    public ProductoDecorador(Producto producto) { this.producto = producto; }
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

