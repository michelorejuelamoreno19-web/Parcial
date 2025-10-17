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



