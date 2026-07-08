public class Administrador extends Empleado {

    public Administrador(String dni, String nombres, String apellidos, String usuario, String password, String rol) {
        super(dni, nombres, apellidos, usuario, password, rol);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("=== MENU ADMINISTRADOR ===");
        System.out.println("1. Gestionar empleados");
        System.out.println("2. Gestionar bahias de trabajo");
        System.out.println("3. Gestionar servicios");
        System.out.println("4. Ver reportes");
    }

    public void registrarEmpleado() {
        System.out.println("El administrador puede registrar empleados.");
    }

    public void registrarBahia() {
        System.out.println("El administrador puede registrar bahias de trabajo.");
    }

    public void registrarServicio() {
        System.out.println("El administrador puede registrar servicios.");
    }
}