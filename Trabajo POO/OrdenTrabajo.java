public class OrdenTrabajo {
    private int codigo;
    private Cita cita;
    private BahiaTrabajo bahia;
    private Mecanico mecanico;
    private String fechaIngreso;
    private String fechaEntrega;
    private String estado;

    private Consumo[] consumos;
    private int cantidadConsumos;

    public OrdenTrabajo(int codigo, Cita cita, BahiaTrabajo bahia, Mecanico mecanico, String fechaIngreso) {
        this.codigo = codigo;
        this.cita = cita;
        this.bahia = bahia;
        this.mecanico = mecanico;
        this.fechaIngreso = fechaIngreso;
        this.fechaEntrega = "";
        this.estado = "Activa";

        this.consumos = new Consumo[20];
        this.cantidadConsumos = 0;

        this.bahia.ocupar();
        this.cita.setEstado("Atendida");
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public BahiaTrabajo getBahia() {
        return bahia;
    }

    public void setBahia(BahiaTrabajo bahia) {
        this.bahia = bahia;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public Consumo[] getConsumos() {
        return consumos;
    }

    public int getCantidadConsumos() {
        return cantidadConsumos;
    }

    public void agregarConsumo(Consumo consumo) {
        if (cantidadConsumos < consumos.length) {
            consumos[cantidadConsumos] = consumo;
            cantidadConsumos++;
            System.out.println("Consumo agregado correctamente.");
        } else {
            System.out.println("No se pueden agregar mas consumos.");
        }
    }

    public double calcularTotalConsumos() {
        double total = 0;

        for (int i = 0; i < cantidadConsumos; i++) {
            total = total + consumos[i].calcularSubtotal();
        }

        return total;
    }

    public double calcularTotalServiciosBase() {
        return cita.getServicio().getPrecio();
    }

    public double calcularTotalOrden() {
        return calcularTotalServiciosBase() + calcularTotalConsumos();
    }

    public void registrarEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        this.estado = "Finalizada";
        this.bahia.liberar();
    }

    public String mostrarConsumos() {
        String texto = "";

        for (int i = 0; i < cantidadConsumos; i++) {
            texto = texto + "\n--- Consumo " + (i + 1) + " ---\n";
            texto = texto + consumos[i].mostrarDatos() + "\n";
        }

        if (cantidadConsumos == 0) {
            texto = "No hay consumos registrados.";
        }

        return texto;
    }

    public String mostrarDatos() {
        return "Codigo de orden: " + codigo +
               "\nCliente: " + cita.getVehiculo().getCliente().getNombres() + " " + cita.getVehiculo().getCliente().getApellidos() +
               "\nVehiculo: " + cita.getVehiculo().getPlaca() +
               "\nServicio principal: " + cita.getServicio().getNombre() +
               "\nBahia: " + bahia.getNumero() +
               "\nMecanico: " + mecanico.getNombres() + " " + mecanico.getApellidos() +
               "\nFecha ingreso: " + fechaIngreso +
               "\nFecha entrega: " + fechaEntrega +
               "\nEstado: " + estado +
               "\nTotal servicios base: S/ " + calcularTotalServiciosBase() +
               "\nTotal consumos: S/ " + calcularTotalConsumos() +
               "\nTotal orden: S/ " + calcularTotalOrden();
    }
}