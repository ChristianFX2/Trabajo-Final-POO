import java.util.Scanner;

public class Login {
    private static Scanner scanner = new Scanner(System.in);
    private static SistemaTaller sistema = new SistemaTaller();

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println(" SISTEMA DE TALLER MECANICO");
        System.out.println("====================================");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nUsuarios de prueba: admin / 123, asesor / 123, mecanico / 123");
            String usuario = leerTexto("Usuario: ");
            String password = leerTexto("Password: ");

            Empleado empleado = sistema.login(usuario, password);
            if (empleado == null) {
                System.out.println("Credenciales incorrectas.");
            } else {
                System.out.println("\nBienvenido, " + empleado.getNombres() + " (" + empleado.getRol() + ")");
                abrirMenuPorRol(empleado);
            }

            continuar = leerSiNo("Desea iniciar sesion nuevamente? (S/N): ");
        }

        System.out.println("Sistema finalizado.");
    }

    private static void abrirMenuPorRol(Empleado empleado) {
        if (empleado instanceof Administrador) {
            menuAdministrador();
        } else if (empleado instanceof AsesorServicio) {
            menuAsesor();
        } else if (empleado instanceof Mecanico) {
            menuMecanico();
        }
    }

    private static void menuAdministrador() {
        int opcion;
        do {
            System.out.println("\n=== MENU ADMINISTRADOR ===");
            System.out.println("1. Listar empleados");
            System.out.println("2. Listar bahias");
            System.out.println("3. Listar servicios");
            System.out.println("4. Listar repuestos");
            System.out.println("5. Reporte de bahias");
            System.out.println("6. Reporte de ingresos");
            System.out.println("0. Cerrar sesion");
            opcion = leerEntero("Opcion: ");

            if (opcion == 1) {
                System.out.println(sistema.listarEmpleados());
            } else if (opcion == 2) {
                System.out.println(sistema.listarBahias());
            } else if (opcion == 3) {
                System.out.println(sistema.listarServicios());
            } else if (opcion == 4) {
                System.out.println(sistema.listarRepuestos());
            } else if (opcion == 5) {
                Reporte reporte = new Reporte();
                System.out.println(reporte.reporteBahias(sistema.getBahias(), sistema.getCantidadBahias()));
            } else if (opcion == 6) {
                Reporte reporte = new Reporte();
                System.out.println(reporte.reporteIngresos(sistema.getFacturas(), sistema.getCantidadFacturas()));
            } else if (opcion != 0) {
                System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void menuAsesor() {
        int opcion;
        do {
            System.out.println("\n=== MENU ASESOR DE SERVICIO ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar vehiculo");
            System.out.println("3. Crear cita");
            System.out.println("4. Crear orden de trabajo");
            System.out.println("5. Registrar entrega");
            System.out.println("6. Generar factura");
            System.out.println("7. Listar clientes");
            System.out.println("8. Listar vehiculos");
            System.out.println("9. Listar citas");
            System.out.println("10. Listar ordenes");
            System.out.println("11. Listar facturas");
            System.out.println("0. Cerrar sesion");
            opcion = leerEntero("Opcion: ");

            if (opcion == 1) {
                registrarCliente();
            } else if (opcion == 2) {
                registrarVehiculo();
            } else if (opcion == 3) {
                crearCita();
            } else if (opcion == 4) {
                crearOrden();
            } else if (opcion == 5) {
                registrarEntrega();
            } else if (opcion == 6) {
                generarFactura();
            } else if (opcion == 7) {
                System.out.println(sistema.listarClientes());
            } else if (opcion == 8) {
                System.out.println(sistema.listarVehiculos());
            } else if (opcion == 9) {
                System.out.println(sistema.listarCitas());
            } else if (opcion == 10) {
                System.out.println(sistema.listarOrdenes());
            } else if (opcion == 11) {
                System.out.println(sistema.listarFacturas());
            } else if (opcion != 0) {
                System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void menuMecanico() {
        int opcion;
        do {
            System.out.println("\n=== MENU MECANICO ===");
            System.out.println("1. Listar ordenes");
            System.out.println("2. Registrar servicio adicional");
            System.out.println("3. Registrar repuesto usado");
            System.out.println("0. Cerrar sesion");
            opcion = leerEntero("Opcion: ");

            if (opcion == 1) {
                System.out.println(sistema.listarOrdenes());
            } else if (opcion == 2) {
                registrarServicioAdicional();
            } else if (opcion == 3) {
                registrarRepuestoUsado();
            } else if (opcion != 0) {
                System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void registrarCliente() {
        String dniRuc = leerTexto("DNI/RUC: ");
        String nombres = leerTexto("Nombres: ");
        String apellidos = leerTexto("Apellidos: ");
        String telefono = leerTexto("Telefono: ");
        String correo = leerTexto("Correo: ");

        if (sistema.agregarCliente(new Cliente(dniRuc, nombres, apellidos, telefono, correo))) {
            System.out.println("Cliente registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el cliente. Revise si ya existe o si no hay espacio.");
        }
    }

    private static void registrarVehiculo() {
        String dniRuc = leerTexto("DNI/RUC del cliente: ");
        Cliente cliente = sistema.buscarClientePorDni(dniRuc);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        String placa = leerTexto("Placa: ");
        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        int anio = leerEntero("Anio: ");
        String tipo = leerTexto("Tipo: ");

        if (sistema.agregarVehiculo(new Vehiculo(placa, marca, modelo, anio, tipo, cliente))) {
            System.out.println("Vehiculo registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el vehiculo. Revise si la placa ya existe.");
        }
    }

    private static void crearCita() {
        System.out.println(sistema.listarServicios());
        int codigo = leerEntero("Codigo de cita: ");
        String placa = leerTexto("Placa del vehiculo: ");
        String servicio = leerTexto("Nombre del servicio: ");
        String fecha = leerTexto("Fecha de cita: ");

        Cita cita = sistema.crearCita(codigo, placa, servicio, fecha);
        if (cita == null) {
            System.out.println("No se pudo crear la cita. Revise placa, servicio o codigo duplicado.");
        } else {
            System.out.println("Cita creada correctamente.");
            System.out.println(cita.mostrarDatos());
        }
    }

    private static void crearOrden() {
        System.out.println(sistema.listarCitas());
        int codigoOrden = leerEntero("Codigo de orden: ");
        int codigoCita = leerEntero("Codigo de cita: ");
        String tipoBahia = leerTexto("Tipo de bahia preferida: ");
        String fechaIngreso = leerTexto("Fecha de ingreso: ");

        OrdenTrabajo orden = sistema.crearOrdenDesdeCita(codigoOrden, codigoCita, tipoBahia, fechaIngreso);
        if (orden == null) {
            System.out.println("No se pudo crear la orden. Revise cita, bahia disponible o codigo duplicado.");
        } else {
            System.out.println("Orden creada correctamente.");
            System.out.println(orden.mostrarDatos());
        }
    }

    private static void registrarEntrega() {
        int codigoOrden = leerEntero("Codigo de orden: ");
        OrdenTrabajo orden = sistema.buscarOrdenPorCodigo(codigoOrden);
        if (orden == null) {
            System.out.println("Orden no encontrada.");
            return;
        }

        String fechaEntrega = leerTexto("Fecha de entrega: ");
        if (orden.registrarEntrega(fechaEntrega)) {
            System.out.println("Entrega registrada correctamente.");
        } else {
            System.out.println("La orden ya estaba finalizada.");
        }
    }

    private static void generarFactura() {
        int numero = leerEntero("Numero de factura: ");
        int codigoOrden = leerEntero("Codigo de orden: ");
        String fecha = leerTexto("Fecha de factura: ");

        Factura factura = sistema.generarFactura(numero, codigoOrden, fecha);
        if (factura == null) {
            System.out.println("No se pudo generar la factura. Revise orden o numero duplicado.");
        } else {
            System.out.println("Factura generada correctamente.");
            System.out.println(factura.mostrarDetalleFactura());
        }
    }

    private static void registrarServicioAdicional() {
        int codigoOrden = leerEntero("Codigo de orden: ");
        String descripcion = leerTexto("Descripcion del servicio: ");
        int cantidad = leerEntero("Cantidad: ");
        double precio = leerDecimal("Precio unitario: ");

        if (sistema.registrarConsumoServicio(codigoOrden, descripcion, cantidad, precio)) {
            System.out.println("Servicio adicional registrado.");
        } else {
            System.out.println("No se pudo registrar el servicio adicional.");
        }
    }

    private static void registrarRepuestoUsado() {
        System.out.println(sistema.listarRepuestos());
        int codigoOrden = leerEntero("Codigo de orden: ");
        String repuesto = leerTexto("Nombre del repuesto: ");
        int cantidad = leerEntero("Cantidad: ");

        if (sistema.registrarConsumoRepuesto(codigoOrden, repuesto, cantidad)) {
            System.out.println("Repuesto registrado y stock actualizado.");
        } else {
            System.out.println("No se pudo registrar el repuesto. Revise orden, repuesto o stock.");
        }
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(mensaje));
            } catch (NumberFormatException error) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    private static double leerDecimal(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(leerTexto(mensaje));
            } catch (NumberFormatException error) {
                System.out.println("Ingrese un numero decimal valido.");
            }
        }
    }

    private static boolean leerSiNo(String mensaje) {
        String respuesta = leerTexto(mensaje);
        return respuesta.equalsIgnoreCase("S") || respuesta.equalsIgnoreCase("SI");
    }
}
