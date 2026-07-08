public class Factura {
    private int numero;
    private OrdenTrabajo ordenTrabajo;
    private String fecha;
    private double totalServicios;
    private double totalRepuestos;
    private double totalPagar;

    public Factura(int numero, OrdenTrabajo ordenTrabajo, String fecha) {
        this.numero = numero;
        this.ordenTrabajo = ordenTrabajo;
        this.fecha = normalizar(fecha);
        calcularFactura();
    }

    private String normalizar(String valor) {
        if (valor == null) {
            return "";
        }

        return valor.trim();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
        calcularFactura();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = normalizar(fecha);
    }

    public double getTotalServicios() {
        calcularFactura();
        return totalServicios;
    }

    public double getTotalRepuestos() {
        calcularFactura();
        return totalRepuestos;
    }

    public double getTotalPagar() {
        calcularFactura();
        return totalPagar;
    }

    public void calcularFactura() {
        totalServicios = 0;
        totalRepuestos = 0;

        if (ordenTrabajo == null) {
            totalPagar = 0;
            return;
        }

        totalServicios = ordenTrabajo.calcularTotalServiciosBase();
        Consumo[] consumos = ordenTrabajo.getConsumos();

        for (int i = 0; i < ordenTrabajo.getCantidadConsumos(); i++) {
            if (consumos[i].getTipo().equals(Consumo.TIPO_SERVICIO)) {
                totalServicios = totalServicios + consumos[i].calcularSubtotal();
            } else if (consumos[i].getTipo().equals(Consumo.TIPO_REPUESTO)) {
                totalRepuestos = totalRepuestos + consumos[i].calcularSubtotal();
            }
        }

        totalPagar = totalServicios + totalRepuestos;
    }

    public String mostrarDetalleFactura() {
        calcularFactura();

        String cliente = "Sin cliente";
        String placa = "Sin vehiculo";
        String servicio = "Sin servicio";

        if (ordenTrabajo != null && ordenTrabajo.getCita() != null) {
            Cita cita = ordenTrabajo.getCita();
            if (cita.getVehiculo() != null) {
                placa = cita.getVehiculo().getPlaca();
                if (cita.getVehiculo().getCliente() != null) {
                    cliente = cita.getVehiculo().getCliente().getNombres() + " " +
                              cita.getVehiculo().getCliente().getApellidos();
                }
            }
            if (cita.getServicio() != null) {
                servicio = cita.getServicio().getNombre();
            }
        }

        return "========== FACTURA ==========" +
               "\nNumero: " + numero +
               "\nFecha: " + fecha +
               "\nCliente: " + cliente +
               "\nVehiculo: " + placa +
               "\nServicio principal: " + servicio +
               "\n\n--- CONSUMOS ---\n" +
               (ordenTrabajo == null ? "No hay orden asociada." : ordenTrabajo.mostrarConsumos()) +
               "\n--- TOTALES ---" +
               "\nTotal servicios: S/ " + totalServicios +
               "\nTotal repuestos: S/ " + totalRepuestos +
               "\nTOTAL A PAGAR: S/ " + totalPagar;
    }
}
