public class Consumo{
public class Consumo {
    private String tipo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public Consumo(String tipo, String descripcion, int cantidad, double precioUnitario) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
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

public double calcularSubtotal() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calcularSubtotal'");
}