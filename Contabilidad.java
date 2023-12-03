import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Contabilidad {
    private List<EncabezadoPedido> pedidos;
    private List<EncabezadoFactura> facturas;

    public Contabilidad() {
        this.pedidos = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public void darPedido(EncabezadoPedido pedido) {
        pedidos.add(pedido);
    }

    public void darFactura(EncabezadoFactura factura) {
        facturas.add(factura);
    }

    public double calcularIngresosMensuales() {
        Calendar calendar = Calendar.getInstance();
        int mesActual = calendar.get(Calendar.MONTH) + 1;
        double ingresosMensuales = 0.0;

        for (EncabezadoFactura factura : facturas) {
            Fecha fechaFactura = factura.getFechaCompra(); // Se usa tu clase Fecha
            Calendar fechaCalendar = new GregorianCalendar(
                    fechaFactura.darAnio(), fechaFactura.darMes() - 1, fechaFactura.darDia()
            );

            if (fechaCalendar.get(Calendar.MONTH) + 1 == mesActual) {
                ingresosMensuales += factura.getDetalleFactura().getTotal();
            }
        }

        return ingresosMensuales;
    }

    public double calcularEgresosMensuales() {
        Calendar calendar = Calendar.getInstance();
        int mesActual = calendar.get(Calendar.MONTH) + 1;
        double egresosMensuales = 0.0;

        for (EncabezadoPedido pedido : pedidos) {
            Fecha fechaPedido = pedido.getFechaPedido(); // Se usa tu clase Fecha
            Calendar fechaCalendar = new GregorianCalendar(
                    fechaPedido.darAnio(), fechaPedido.darMes() - 1, fechaPedido.darDia()
            );

            if (fechaCalendar.get(Calendar.MONTH) + 1 == mesActual) {
                egresosMensuales += pedido.getDetallePedido().calcularTotal();
            }
        }

        return egresosMensuales;
    }

    public double getTotal() {
        double ingresos = calcularIngresosMensuales();
        double egresos = calcularEgresosMensuales();
        return ingresos - egresos;
    }

    public void visualizarPatrimonio() {
        double ingresosMensuales = calcularIngresosMensuales();
        double egresosMensuales = calcularEgresosMensuales();
        double patrimonio = ingresosMensuales - egresosMensuales;

        if (patrimonio > 0) {
            System.out.println("Superávit: " + patrimonio);
        } else if (patrimonio < 0) {
            System.out.println("Déficit: " + patrimonio);
        } else {
            System.out.println("Equilibrio: " + patrimonio);
        }
    }

    public void visualizarIngresos() {
        Fecha fechaActual = Fecha.darFechaActual(); // Utiliza tu método para obtener la fecha actual

        int mesActual = fechaActual.darMes();

        System.out.println("Facturas del mes:");

        for (EncabezadoFactura factura : facturas) {
            Fecha fechaFactura = factura.getFechaCompra();

            if (fechaFactura.darMes() == mesActual) {
                System.out.println(factura);
            }
        }
    }

    public void visualizarEgresos() {
        Fecha fechaActual = Fecha.darFechaActual(); // Utiliza tu método para obtener la fecha actual

        int mesActual = fechaActual.darMes();

        System.out.println("Pedidos del mes:");

        for (EncabezadoPedido pedido : pedidos) {
            Fecha fechaPedido = pedido.getFechaPedido();

            if (fechaPedido.darMes() == mesActual) {
                System.out.println(pedido);
            }
        }
    }



}
