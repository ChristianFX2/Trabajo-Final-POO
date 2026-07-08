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
        this.fecha = fecha;
        this.estado = "Pendiente";
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
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void confirmar() {
        estado = "Confirmada";
    }

    public void cancelar() {
        estado = "Cancelada";
    }

    public String mostrarDatos() {
        return "Codigo de cita: " + codigo +
               "\nVehiculo: " + vehiculo.getPlaca() +
               "\nCliente: " + vehiculo.getCliente().getNombres() + " " + vehiculo.getCliente().getApellidos() +
               "\nServicio: " + servicio.getNombre() +
               "\nFecha: " + fecha +
               "\nEstado: " + estado;
    }
}