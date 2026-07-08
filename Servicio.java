public class Servicio {
    private String nombre;
    private double precio;

    public Servicio(String nombre, double precio) {
        this.nombre = normalizar(nombre);
        this.precio = Math.max(0, precio);
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = Math.max(0, precio);
    }

    public String mostrarDatos() {
        return "Servicio: " + nombre +
               "\nPrecio: S/ " + precio;
    }
}
