public class Mecanico extends Empleado {

    public Mecanico(String dni, String nombres, String apellidos, String usuario, String password) {
        super(dni, nombres, apellidos, usuario, password, "Mecanico");
    }

    @Override
    public void mostrarMenu() {
        System.out.println("=== MENU MECANICO ===");
        System.out.println("1. Ver ordenes de trabajo");
        System.out.println("2. Registrar consumo de servicios");
        System.out.println("3. Registrar consumo de repuestos");
    }

    public void registrarConsumo() {
        System.out.println("El mecanico puede registrar consumos.");
    }
}