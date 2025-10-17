// ProductoBase.java
public abstract class ProductoBase implements Producto {
    protected int id;
    protected String nombre;
    protected double precioBase;

    public ProductoBase(int id, String nombre, double precioBase) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    @Override
    public String getDescripcion() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precioBase;
    }

    // getters / setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
}

