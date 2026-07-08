public class Cliente {
    private String dniRuc;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    public Cliente(String dniRuc, String nombres, String apellidos, String telefono, String correo) {
        this.dniRuc = normalizar(dniRuc);
        this.nombres = normalizar(nombres);
        this.apellidos = normalizar(apellidos);
        this.telefono = normalizar(telefono);
        this.correo = normalizar(correo);
    }

    private String normalizar(String valor) {
        if (valor == null) {
            return "";
        }

        return valor.trim();
    }

    public String getDniRuc() {
        return dniRuc;
    }

    public void setDniRuc(String dniRuc) {
        this.dniRuc = normalizar(dniRuc);
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = normalizar(nombres);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = normalizar(apellidos);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = normalizar(telefono);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = normalizar(correo);
    }

    public String mostrarDatos() {
        return "DNI/RUC: " + dniRuc +
               "\nNombres: " + nombres +
               "\nApellidos: " + apellidos +
               "\nTelefono: " + telefono +
               "\nCorreo: " + correo;
    }
}
