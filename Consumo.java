public class Consumo {
    public static final String TIPO_SERVICIO = "Servicio";
    public static final String TIPO_REPUESTO = "Repuesto";

    private String tipo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public Consumo(String tipo, String descripcion, int cantidad, double precioUnitario) {
        this.tipo = normalizarTipo(tipo);
        this.descripcion = normalizar(descripcion);
        this.cantidad = Math.max(1, cantidad);
        this.precioUnitario = Math.max(0, precioUnitario);
    }

    private String normalizar(String valor) {
        if (valor == null) {
            return "";
        }

        return valor.trim();
    }

    private String normalizarTipo(String tipo) {
        String valor = normalizar(tipo);
        if (valor.equalsIgnoreCase(TIPO_REPUESTO)) {
            return TIPO_REPUESTO;
        }

        return TIPO_SERVICIO;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = normalizarTipo(tipo);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = normalizar(descripcion);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = Math.max(1, cantidad);
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = Math.max(0, precioUnitario);
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    public String mostrarDatos() {
        return "Tipo: " + tipo +
               "\nDescripcion: " + descripcion +
               "\nCantidad: " + cantidad +
               "\nPrecio unitario: S/ " + precioUnitario +
               "\nSubtotal: S/ " + calcularSubtotal();
    }
}
