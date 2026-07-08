public abstract class Empleado {
    protected String dni;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String password;
    protected String rol;

    public Empleado(String dni, String nombres, String apellidos, String usuario, String password, String rol) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public boolean validarLogin(String usuario, String password) {
        return this.usuario.equals(usuario) && this.password.equals(password);
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