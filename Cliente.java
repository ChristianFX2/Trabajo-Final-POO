public class Cliente {
    private String dniRuc;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    public Cliente(String dniRuc, String nombres, String apellidos, String telefono, String correo) {
        this.dniRuc = dniRuc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getDniRuc() {
        return dniRuc;
    }

    public void setDniRuc(String dniRuc) {
        this.dniRuc = dniRuc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String mostrarDatos() {
        return "DNI/RUC: " + dniRuc +
               "\nNombres: " + nombres +
               "\nApellidos: " + apellidos +
               "\nTelefono: " + telefono +
               "\nCorreo: " + correo;
    }
}