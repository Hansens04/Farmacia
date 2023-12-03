import java.text.SimpleDateFormat;

public class EncabezadoFactura {
    private static int contadorFacturas = 100;

    private Cliente cliente;
    private int numeroFactura;
    private Fecha fechaCompra;
    private DetalleFactura detalleFactura;


    public EncabezadoFactura(Cliente cliente) {
        this.cliente = cliente;
        this.numeroFactura = generarNumeroFactura();
        this.fechaCompra = new Fecha();
        validarFecha();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public DetalleFactura getDetalleFactura(){
        return detalleFactura;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Fecha getFechaCompra() {
        return fechaCompra;
    }

    private int generarNumeroFactura() {
        return contadorFacturas++;
    }

    private void validarFecha() {
        if (!ValidadorFecha.esFechaValida(fechaCompra)) {
            throw new FechaInvalidaException("La fecha de compra no es válida.");
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return "EncabezadoFactura{" +
                "cliente=" + cliente +
                ", numeroFactura=" + numeroFactura +
                ", fechaCompra=" + dateFormat.format(fechaCompra) +
                '}';
    }

    // Excepción personalizada para fecha inválida
    public static class FechaInvalidaException extends RuntimeException {
        public FechaInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    // Supongamos que tienes una clase ValidadorFecha con un método estático esFechaValida
    public static class ValidadorFecha {
        public static boolean esFechaValida(Fecha fecha) {
            // Implementación real de la validación de fecha según tus necesidades
            // Retorna true si la fecha es válida, de lo contrario, retorna false
            return true;
        }
    }
}
