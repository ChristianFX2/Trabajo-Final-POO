public class BahiaTrabajo {
    private int numero;
    private int capacidad;
    private String tipo;
    private String estado;

    public BahiaTrabajo(int numero, int capacidad, String tipo) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.estado = "Libre";
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean estaLibre() {
        return estado.equals("Libre");
    }

    public void ocupar() {
        estado = "Ocupada";
    }

    public void liberar() {
        estado = "Libre";
    }

    public void mantenimiento() {
        estado = "En mantenimiento";
    }

    public String mostrarDatos() {
        return "Numero: " + numero +
               "\nCapacidad: " + capacidad +
               "\nTipo: " + tipo +
               "\nEstado: " + estado;
    }
}