import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<String> productos;
    private List<Proveedor> listaProveedores;

    public Proveedor(int id, String nombre, String direccion, String telefono, List<Proveedor> listaProveedores) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaProveedores = listaProveedores;
        this.productos = new ArrayList<>();
    }

    public  List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void agregarProducto(String nombre, String descripcion, double precio) {
        String producto = "Nombre: " + nombre + ", Descripción: " + descripcion + ", Precio: " + precio;
        productos.add(producto);
    }

    @Override
    public String toString() {
        return "Proveedor [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion +
                ", telefono=" + telefono + ", productos=" + productos + "]";
    }

    public void ingresarProveedor(Proveedor nuevoProveedor) {
        // Implementa la lógica para ingresar un proveedor
        // Asegúrate de que la lista no sea null antes de agregar el nuevo proveedor
        if (listaProveedores != null) {
            listaProveedores.add(nuevoProveedor);
        } else {
            // Podrías imprimir un mensaje de error o lanzar una excepción según tus requisitos
            System.out.println("Error: La lista de proveedores no ha sido inicializada correctamente.");
        }
    }
}
