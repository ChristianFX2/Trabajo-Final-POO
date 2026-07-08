public class AsesorServicio extends Empleado {

    public AsesorServicio(String dni, String nombres, String apellidos, String usuario, String password) {
        super(dni, nombres, apellidos, usuario, password, "Asesor de Servicio");
    }

    @Override
    public void mostrarMenu() {
        System.out.println("=== MENU ASESOR DE SERVICIO ===");
        System.out.println("1. Gestionar clientes");
        System.out.println("2. Gestionar vehiculos");
        System.out.println("3. Crear citas");
        System.out.println("4. Registrar recepcion del vehiculo");
        System.out.println("5. Registrar entrega del vehiculo");
    }

    public void registrarCliente() {
        System.out.println("El asesor puede registrar clientes.");
    }

    public void registrarVehiculo() {
        System.out.println("El asesor puede registrar vehiculos.");
    }

    public void crearCita() {
        System.out.println("El asesor puede crear citas.");
    }
}