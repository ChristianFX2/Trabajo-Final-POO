public class Repuesto {
    private String nombre;
    private double precioUnitario;
    private int stock;

    public Repuesto(String nombre, double precioUnitario, int stock) {
        this.nombre = normalizar(nombre);
        this.precioUnitario = Math.max(0, precioUnitario);
        this.stock = Math.max(0, stock);
    }

    private String normalizar(String valor) {
        if (valor == null) {
            return "";
        }

        return valor.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = normalizar(nombre);
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = Math.max(0, precioUnitario);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = Math.max(0, stock);
    }

    public boolean hayStock(int cantidad) {
        return cantidad > 0 && stock >= cantidad;
    }

    public boolean disminuirStock(int cantidad) {
        if (!hayStock(cantidad)) {
            return false;
        }

        stock = stock - cantidad;
        return true;
    }

    public String mostrarDatos() {
        return "Repuesto: " + nombre +
               "\nPrecio unitario: S/ " + precioUnitario +
               "\nStock: " + stock;
    }
}
