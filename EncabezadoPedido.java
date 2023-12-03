import java.util.Date;
import java.util.List;

public class EncabezadoPedido {
    private String estado;
    private Proveedor proveedor;
    private DetallePedido detallePedido;
    private Fecha fechaPedido;
    private int contadorPedidos;
    private int codigoPedido;
    private boolean estadoEnviado;

    public EncabezadoPedido(String estado, Proveedor proveedor, DetallePedido detallePedido) {
        this.estado = estado;
        this.proveedor = proveedor;
        this.detallePedido = detallePedido;
        this.fechaPedido = new Fecha();
    }

    public String getEstado() {
        return estado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public Fecha getFechaPedido() {
        return fechaPedido;
    }

    private int generarCodigoPedidoUnico() {
        return contadorPedidos++;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }



    public void setEstado(String estado) {
        this.estado = estado;
    }


    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void actualizarEstadoEnviado(boolean estadoEnviado) {
        this.estadoEnviado = estadoEnviado;

        if (estadoEnviado) {
            System.out.println("El pedido ha sido enviado. Se ha actualizado el stock satisfactoriamente.");
        }
    }

    @Override
    public String toString() {
        return "EncabezadoPedido [codigoPedido=" + codigoPedido + ", estado=" + estado +
                ", proveedor=" + proveedor + "]";
    }

}
