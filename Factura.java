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
        this.fecha = fecha;
        calcularFactura();
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
        this.fecha = fecha;
    }

    public double getTotalServicios() {
        return totalServicios;
    }

    public double getTotalRepuestos() {
        return totalRepuestos;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void calcularFactura() {
        totalServicios = ordenTrabajo.calcularTotalServiciosBase();
        totalRepuestos = 0;

        Consumo[] consumos = ordenTrabajo.getConsumos();

        for (int i = 0; i < ordenTrabajo.getCantidadConsumos(); i++) {
            if (consumos[i].getTipo().equals("Servicio")) {
                totalServicios = totalServicios + consumos[i].calcularSubtotal();
            } else if (consumos[i].getTipo().equals("Repuesto")) {
                totalRepuestos = totalRepuestos + consumos[i].calcularSubtotal();
            }
        }

        totalPagar = totalServicios + totalRepuestos;
    }

    public String mostrarDetalleFactura() {
        calcularFactura();

        return "========== FACTURA ==========" +
               "\nNumero: " + numero +
               "\nFecha: " + fecha +
               "\nCliente: " + ordenTrabajo.getCita().getVehiculo().getCliente().getNombres() + " " +
                            ordenTrabajo.getCita().getVehiculo().getCliente().getApellidos() +
               "\nVehiculo: " + ordenTrabajo.getCita().getVehiculo().getPlaca() +
               "\nServicio principal: " + ordenTrabajo.getCita().getServicio().getNombre() +
               "\n\n--- CONSUMOS ---\n" +
               ordenTrabajo.mostrarConsumos() +
               "\n--- TOTALES ---" +
               "\nTotal servicios: S/ " + totalServicios +
               "\nTotal repuestos: S/ " + totalRepuestos +
               "\nTOTAL A PAGAR: S/ " + totalPagar;
    }
}