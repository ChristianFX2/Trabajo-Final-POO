public abstract class Empleado {
    protected String dni;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String password;
    protected String rol;

    public Empleado(String dni, String nombres, String apellidos, String usuario, String password, String rol) {
        this.dni = normalizar(dni);
        this.nombres = normalizar(nombres);
        this.apellidos = normalizar(apellidos);
        this.usuario = normalizar(usuario);
        this.password = normalizar(password);
        this.rol = normalizar(rol);
    }

    protected String normalizar(String valor) {
        if (valor == null) {
            return "";
        }

        return valor.trim();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = normalizar(dni);
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = normalizar(usuario);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = normalizar(password);
    }

    public String getRol() {
        return rol;
    }

    public boolean validarLogin(String usuario, String password) {
        return this.usuario.equals(normalizar(usuario)) && this.password.equals(normalizar(password));
    }

    public abstract void mostrarMenu();

    public String mostrarDatos() {
        return "DNI: " + dni +
               "\nNombres: " + nombres +
               "\nApellidos: " + apellidos +
               "\nUsuario: " + usuario +
               "\nRol: " + rol;
    }
}
