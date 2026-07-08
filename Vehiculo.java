public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private String tipo;
    private Cliente cliente;

    public Vehiculo(String placa, String marca, String modelo, int anio, String tipo, Cliente cliente) {
        this.placa = normalizar(placa).toUpperCase();
        this.marca = normalizar(marca);
        this.modelo = normalizar(modelo);
        this.anio = Math.max(1900, anio);
        this.tipo = normalizar(tipo);
        this.cliente = cliente;
    }

    private String normalizar(String valor) {
        if (valor == null) {
            return "";
        }

        return valor.trim();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = normalizar(placa).toUpperCase();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = normalizar(marca);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = normalizar(modelo);
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = Math.max(1900, anio);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = normalizar(tipo);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String mostrarDatos() {
        String datosCliente = "Sin cliente";
        if (cliente != null) {
            datosCliente = cliente.getNombres() + " " + cliente.getApellidos();
        }

        return "Placa: " + placa +
               "\nMarca: " + marca +
               "\nModelo: " + modelo +
               "\nAnio: " + anio +
               "\nTipo: " + tipo +
               "\nCliente: " + datosCliente;
    }
}
