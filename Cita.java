public class Cita {
    private int codigo;
    private Vehiculo vehiculo;
    private Servicio servicio;
    private String fecha;
    private String estado;

    public Cita(int codigo, Vehiculo vehiculo, Servicio servicio, String fecha) {
        this.codigo = codigo;
        this.vehiculo = vehiculo;
        this.servicio = servicio;
        this.fecha = normalizar(fecha);
        this.estado = "Pendiente";
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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = normalizar(fecha);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String nuevoEstado = normalizar(estado);
        if (!nuevoEstado.isEmpty()) {
            this.estado = nuevoEstado;
        }
    }

    public void confirmar() {
        estado = "Confirmada";
    }

    public void cancelar() {
        estado = "Cancelada";
    }

    public boolean puedeAtenderse() {
        return vehiculo != null && servicio != null && !estado.equals("Cancelada") && !estado.equals("Atendida");
    }

    public String mostrarDatos() {
        String placa = "Sin vehiculo";
        String cliente = "Sin cliente";
        String nombreServicio = "Sin servicio";

        if (vehiculo != null) {
            placa = vehiculo.getPlaca();
            if (vehiculo.getCliente() != null) {
                cliente = vehiculo.getCliente().getNombres() + " " + vehiculo.getCliente().getApellidos();
            }
        }

        if (servicio != null) {
            nombreServicio = servicio.getNombre();
        }

        return "Codigo de cita: " + codigo +
               "\nVehiculo: " + placa +
               "\nCliente: " + cliente +
               "\nServicio: " + nombreServicio +
               "\nFecha: " + fecha +
               "\nEstado: " + estado;
    }
}
