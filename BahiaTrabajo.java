public class BahiaTrabajo {
    private int numero;
    private int capacidad;
    private String tipo;
    private String estado;

    public BahiaTrabajo(int numero, int capacidad, String tipo) {
        this.numero = numero;
        this.capacidad = Math.max(1, capacidad);
        this.tipo = normalizar(tipo);
        this.estado = "Libre";
    }

    private String normalizar(String valor) {
        if (valor == null) {
            return "";
        }

        return valor.trim();
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
        this.capacidad = Math.max(1, capacidad);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = normalizar(tipo);
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

    public boolean estaLibre() {
        return estado.equals("Libre");
    }

    public boolean ocupar() {
        if (!estaLibre()) {
            return false;
        }

        estado = "Ocupada";
        return true;
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
