public class App {
    public static void main(String[] args) {
        SistemaTaller sistema = new SistemaTaller();

        System.out.println("Sistema iniciado correctamente.\n");
        System.out.println(sistema.listarEmpleados());
        System.out.println(sistema.listarBahias());
        System.out.println(sistema.listarServicios());
    }
}