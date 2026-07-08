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
        if (cita == null || !cita.puedeAtenderse()) {
            throw new IllegalArgumentException("La cita no existe o no puede atenderse.");
        }

        if (bahia == null || !bahia.estaLibre()) {
            throw new IllegalArgumentException("No hay una bahia libre para la orden.");
        }

        if (mecanico == null) {
            throw new IllegalArgumentException("Debe asignarse un mecanico.");
        }

        this.codigo = codigo;
        this.cita = cita;
        this.bahia = bahia;
        this.mecanico = mecanico;
        this.fechaIngreso = normalizar(fechaIngreso);
        this.fechaEntrega = "";
        this.estado = "Activa";
        this.consumos = new Consumo[20];
        this.cantidadConsumos = 0;

        this.bahia.ocupar();
        this.cita.setEstado("Atendida");
    }

    private String normalizar(String valor) {
        if (valor == null) {
            return "";
        }

        return valor.trim();
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
        this.fechaIngreso = normalizar(fechaIngreso);
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = normalizar(fechaEntrega);
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

    public boolean agregarConsumo(Consumo consumo) {
        if (consumo == null || estado.equals("Finalizada") || cantidadConsumos >= consumos.length) {
            return false;
        }

        consumos[cantidadConsumos] = consumo;
        cantidadConsumos++;
        return true;
    }

    public double calcularTotalConsumos() {
        double total = 0;

        for (int i = 0; i < cantidadConsumos; i++) {
            total = total + consumos[i].calcularSubtotal();
        }

        return total;
    }

    public double calcularTotalServiciosBase() {
        if (cita == null || cita.getServicio() == null) {
            return 0;
        }

        return cita.getServicio().getPrecio();
    }

    public double calcularTotalOrden() {
        return calcularTotalServiciosBase() + calcularTotalConsumos();
    }

    public boolean registrarEntrega(String fechaEntrega) {
        if (estado.equals("Finalizada")) {
            return false;
        }

        this.fechaEntrega = normalizar(fechaEntrega);
        this.estado = "Finalizada";
        if (this.bahia != null) {
            this.bahia.liberar();
        }
        return true;
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
        String cliente = "Sin cliente";
        String placa = "Sin vehiculo";
        String servicio = "Sin servicio";

        if (cita != null) {
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

        return "Codigo de orden: " + codigo +
               "\nCliente: " + cliente +
               "\nVehiculo: " + placa +
               "\nServicio principal: " + servicio +
               "\nBahia: " + (bahia == null ? "Sin bahia" : bahia.getNumero()) +
               "\nMecanico: " + (mecanico == null ? "Sin mecanico" : mecanico.getNombres() + " " + mecanico.getApellidos()) +
               "\nFecha ingreso: " + fechaIngreso +
               "\nFecha entrega: " + fechaEntrega +
               "\nEstado: " + estado +
               "\nTotal servicios base: S/ " + calcularTotalServiciosBase() +
               "\nTotal consumos: S/ " + calcularTotalConsumos() +
               "\nTotal orden: S/ " + calcularTotalOrden();
    }
}
