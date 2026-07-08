public class Repuesto {
    private String nombre;
    private double precioUnitario;
    private int stock;

    public Repuesto(String nombre, double precioUnitario, int stock) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }

    public void disminuirStock(int cantidad) {
        if (hayStock(cantidad)) {
            stock = stock - cantidad;
        } else {
            System.out.println("No hay stock suficiente.");
        }
    }

    public String mostrarDatos() {
        return "Repuesto: " + nombre +
               "\nPrecio unitario: S/ " + precioUnitario +
               "\nStock: " + stock;
    }
}