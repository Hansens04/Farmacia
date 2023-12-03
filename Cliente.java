import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static List<String> cedulasUnicas = new ArrayList<>();
    private static List<String> telefonosUnicos = new ArrayList<>();

    private String nombre;
    private String cedula;
    private String telefono;
    private String direccion;
    private List<EncabezadoFactura> encabezadoFacturas = new ArrayList<>();

    public Cliente(String nombre, String cedula, String telefono, String direccion) {
        validarCedulaUnica(cedula);
        validarTelefonoUnico(telefono);

        cedulasUnicas.add(cedula);
        telefonosUnicos.add(telefono);

        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public static class CedulaDuplicadaException extends RuntimeException {
        public CedulaDuplicadaException(String mensaje) {
            super(mensaje);
        }
    }

    public static class TelefonoDuplicadoException extends RuntimeException {
        public TelefonoDuplicadoException(String mensaje) {
            super(mensaje);
        }
    }

    private static void validarCedulaUnica(String cedula) {
        if (cedulasUnicas.contains(cedula)) {
            throw new CedulaDuplicadaException("La cédula ya existe. Debe ser única.");
        }
    }

    private static void validarTelefonoUnico(String telefono) {
        if (telefonosUnicos.contains(telefono)) {
            throw new TelefonoDuplicadoException("El número de teléfono ya existe. Debe ser único.");
        }
    }
    public void modificarCliente(String nuevoNombre, String nuevaCedula, String nuevoTelefono, String nuevaDireccion) {
        // Validar que la nueva cédula y el nuevo teléfono no estén duplicados
        if (!cedula.equals(nuevaCedula) && cedulasUnicas.contains(nuevaCedula)) {
            throw new CedulaDuplicadaException("La nueva cédula ya existe. Debe ser única.");
        }

        if (!telefono.equals(nuevoTelefono) && telefonosUnicos.contains(nuevoTelefono)) {
            throw new TelefonoDuplicadoException("El nuevo número de teléfono ya existe. Debe ser único.");
        }

        // Actualizar la información del cliente
        this.nombre = nuevoNombre;
        this.cedula = nuevaCedula;
        this.telefono = nuevoTelefono;
        this.direccion = nuevaDireccion;

        // Actualizar la lista de cédulas y teléfonos únicos
        cedulasUnicas.remove(cedula);
        cedulasUnicas.add(nuevaCedula);

        telefonosUnicos.remove(telefono);
        telefonosUnicos.add(nuevoTelefono);
    }
}
