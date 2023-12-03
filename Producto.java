import java.util.ArrayList;
import java.util.List;

public class Producto {
    static List<Producto> listaProductos = new ArrayList<>();
    private String codigoProducto;
    private String nombre;
    private int stockActual;
    private int cantidadMinima;
    private double precio;
    private String descripcion;

    public Producto(String codigoProducto, String nombre, int stockActual, int cantidadMinima, double precio, String descripcion) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.stockActual = stockActual;
        this.cantidadMinima = cantidadMinima;
        this.precio = precio;
        this.descripcion = descripcion;
        listaProductos.add(this);
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public static void ingresarProducto(Producto nuevoProducto) {
        if (!listaProductos.contains(nuevoProducto)) {
            listaProductos.add(nuevoProducto);
        }
    }

    public static void modificarProducto(Producto productoExistente, Producto nuevoProducto) {
        if (listaProductos.contains(productoExistente)) {
            int index = listaProductos.indexOf(productoExistente);

            // Actualizar todos los datos del producto existente con los del nuevo producto
            listaProductos.set(index, new Producto(
                    nuevoProducto.getCodigoProducto(),
                    nuevoProducto.getNombre(),
                    nuevoProducto.getStockActual(),
                    nuevoProducto.getCantidadMinima(),
                    nuevoProducto.getPrecio(),
                    nuevoProducto.getDescripcion()
            ));
        } else {
            System.out.println("Error: El producto no existe en la lista.");
        }
    }


    @Override
    public String toString() {
        return "Producto [codigoProducto=" + codigoProducto + ", nombre=" + nombre +
                ", stockActual=" + stockActual + ", cantidadMinima=" + cantidadMinima +
                ", precio=" + precio + ", descripcion=" + descripcion + "]";
    }
}
