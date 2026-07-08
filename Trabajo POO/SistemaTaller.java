public class SistemaTaller {
    private Empleado[] empleados;
    private Cliente[] clientes;
    private Vehiculo[] vehiculos;
    private BahiaTrabajo[] bahias;
    private Servicio[] servicios;
    private Repuesto[] repuestos;
    private Cita[] citas;
    private OrdenTrabajo[] ordenes;
    private Factura[] facturas;

    private int cantidadEmpleados;
    private int cantidadClientes;
    private int cantidadVehiculos;
    private int cantidadBahias;
    private int cantidadServicios;
    private int cantidadRepuestos;
    private int cantidadCitas;
    private int cantidadOrdenes;
    private int cantidadFacturas;

    public SistemaTaller() {
        empleados = new Empleado[50];
        clientes = new Cliente[50];
        vehiculos = new Vehiculo[50];
        bahias = new BahiaTrabajo[20];
        servicios = new Servicio[30];
        repuestos = new Repuesto[50];
        citas = new Cita[50];
        ordenes = new OrdenTrabajo[50];
        facturas = new Factura[50];

        cantidadEmpleados = 0;
        cantidadClientes = 0;
        cantidadVehiculos = 0;
        cantidadBahias = 0;
        cantidadServicios = 0;
        cantidadRepuestos = 0;
        cantidadCitas = 0;
        cantidadOrdenes = 0;
        cantidadFacturas = 0;

        cargarDatosIniciales();
    }

    public void cargarDatosIniciales() {
        agregarEmpleado(new Administrador("11111111", "Carlos", "Ramirez", "admin", "123"));
        agregarEmpleado(new AsesorServicio("22222222", "Maria", "Lopez", "asesor", "123"));
        agregarEmpleado(new Mecanico("33333333", "Jose", "Torres", "mecanico", "123"));

        agregarBahia(new BahiaTrabajo(1, 1, "Mecanica General"));
        agregarBahia(new BahiaTrabajo(2, 1, "Electricidad"));
        agregarBahia(new BahiaTrabajo(3, 1, "Planchado y Pintura"));

        agregarServicio(new Servicio("Cambio de aceite", 80));
        agregarServicio(new Servicio("Alineacion y balanceo", 120));
        agregarServicio(new Servicio("Diagnostico electronico", 150));

        agregarRepuesto(new Repuesto("Aceite", 35, 20));
        agregarRepuesto(new Repuesto("Filtro de aire", 45, 10));
        agregarRepuesto(new Repuesto("Pastillas de freno", 90, 15));
    }

    public boolean agregarEmpleado(Empleado empleado) {
        if (cantidadEmpleados < empleados.length) {
            empleados[cantidadEmpleados] = empleado;
            cantidadEmpleados++;
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarCliente(Cliente cliente) {
        if (cantidadClientes < clientes.length) {
            clientes[cantidadClientes] = cliente;
            cantidadClientes++;
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarVehiculo(Vehiculo vehiculo) {
        if (cantidadVehiculos < vehiculos.length) {
            vehiculos[cantidadVehiculos] = vehiculo;
            cantidadVehiculos++;
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarBahia(BahiaTrabajo bahia) {
        if (cantidadBahias < bahias.length) {
            bahias[cantidadBahias] = bahia;
            cantidadBahias++;
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarServicio(Servicio servicio) {
        if (cantidadServicios < servicios.length) {
            servicios[cantidadServicios] = servicio;
            cantidadServicios++;
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarRepuesto(Repuesto repuesto) {
        if (cantidadRepuestos < repuestos.length) {
            repuestos[cantidadRepuestos] = repuesto;
            cantidadRepuestos++;
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarCita(Cita cita) {
        if (cantidadCitas < citas.length) {
            citas[cantidadCitas] = cita;
            cantidadCitas++;
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarOrden(OrdenTrabajo orden) {
        if (cantidadOrdenes < ordenes.length) {
            ordenes[cantidadOrdenes] = orden;
            cantidadOrdenes++;
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarFactura(Factura factura) {
        if (cantidadFacturas < facturas.length) {
            facturas[cantidadFacturas] = factura;
            cantidadFacturas++;
            return true;
        } else {
            return false;
        }
    }

    public Empleado login(String usuario, String password) {
        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i].validarLogin(usuario, password)) {
                return empleados[i];
            }
        }

        return null;
    }

    public Cliente buscarClientePorDni(String dniRuc) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i].getDniRuc().equals(dniRuc)) {
                return clientes[i];
            }
        }

        return null;
    }

    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (int i = 0; i < cantidadVehiculos; i++) {
            if (vehiculos[i].getPlaca().equals(placa)) {
                return vehiculos[i];
            }
        }

        return null;
    }

    public BahiaTrabajo buscarBahiaLibrePorTipo(String tipo) {
        for (int i = 0; i < cantidadBahias; i++) {
            if (bahias[i].getTipo().equals(tipo) && bahias[i].estaLibre()) {
                return bahias[i];
            }
        }

        return null;
    }

    public Servicio buscarServicioPorNombre(String nombre) {
        for (int i = 0; i < cantidadServicios; i++) {
            if (servicios[i].getNombre().equals(nombre)) {
                return servicios[i];
            }
        }

        return null;
    }

    public Repuesto buscarRepuestoPorNombre(String nombre) {
        for (int i = 0; i < cantidadRepuestos; i++) {
            if (repuestos[i].getNombre().equals(nombre)) {
                return repuestos[i];
            }
        }

        return null;
    }

    public Cita buscarCitaPorCodigo(int codigo) {
        for (int i = 0; i < cantidadCitas; i++) {
            if (citas[i].getCodigo() == codigo) {
                return citas[i];
            }
        }

        return null;
    }

    public OrdenTrabajo buscarOrdenPorCodigo(int codigo) {
        for (int i = 0; i < cantidadOrdenes; i++) {
            if (ordenes[i].getCodigo() == codigo) {
                return ordenes[i];
            }
        }

        return null;
    }

    public String listarEmpleados() {
        String texto = "===== LISTA DE EMPLEADOS =====\n";

        for (int i = 0; i < cantidadEmpleados; i++) {
            texto = texto + "\nEmpleado " + (i + 1) + "\n";
            texto = texto + empleados[i].mostrarDatos() + "\n";
        }

        if (cantidadEmpleados == 0) {
            texto = texto + "No hay empleados registrados.";
        }

        return texto;
    }

    public String listarClientes() {
        String texto = "===== LISTA DE CLIENTES =====\n";

        for (int i = 0; i < cantidadClientes; i++) {
            texto = texto + "\nCliente " + (i + 1) + "\n";
            texto = texto + clientes[i].mostrarDatos() + "\n";
        }

        if (cantidadClientes == 0) {
            texto = texto + "No hay clientes registrados.";
        }

        return texto;
    }

    public String listarVehiculos() {
        String texto = "===== LISTA DE VEHICULOS =====\n";

        for (int i = 0; i < cantidadVehiculos; i++) {
            texto = texto + "\nVehiculo " + (i + 1) + "\n";
            texto = texto + vehiculos[i].mostrarDatos() + "\n";
        }

        if (cantidadVehiculos == 0) {
            texto = texto + "No hay vehiculos registrados.";
        }

        return texto;
    }

    public String listarBahias() {
        String texto = "===== LISTA DE BAHIAS =====\n";

        for (int i = 0; i < cantidadBahias; i++) {
            texto = texto + "\nBahia " + (i + 1) + "\n";
            texto = texto + bahias[i].mostrarDatos() + "\n";
        }

        if (cantidadBahias == 0) {
            texto = texto + "No hay bahias registradas.";
        }

        return texto;
    }

    public String listarServicios() {
        String texto = "===== LISTA DE SERVICIOS =====\n";

        for (int i = 0; i < cantidadServicios; i++) {
            texto = texto + "\nServicio " + (i + 1) + "\n";
            texto = texto + servicios[i].mostrarDatos() + "\n";
        }

        if (cantidadServicios == 0) {
            texto = texto + "No hay servicios registrados.";
        }

        return texto;
    }

    public String listarRepuestos() {
        String texto = "===== LISTA DE REPUESTOS =====\n";

        for (int i = 0; i < cantidadRepuestos; i++) {
            texto = texto + "\nRepuesto " + (i + 1) + "\n";
            texto = texto + repuestos[i].mostrarDatos() + "\n";
        }

        if (cantidadRepuestos == 0) {
            texto = texto + "No hay repuestos registrados.";
        }

        return texto;
    }

    public String listarCitas() {
        String texto = "===== LISTA DE CITAS =====\n";

        for (int i = 0; i < cantidadCitas; i++) {
            texto = texto + "\nCita " + (i + 1) + "\n";
            texto = texto + citas[i].mostrarDatos() + "\n";
        }

        if (cantidadCitas == 0) {
            texto = texto + "No hay citas registradas.";
        }

        return texto;
    }

    public String listarOrdenes() {
        String texto = "===== LISTA DE ORDENES DE TRABAJO =====\n";

        for (int i = 0; i < cantidadOrdenes; i++) {
            texto = texto + "\nOrden " + (i + 1) + "\n";
            texto = texto + ordenes[i].mostrarDatos() + "\n";
        }

        if (cantidadOrdenes == 0) {
            texto = texto + "No hay ordenes registradas.";
        }

        return texto;
    }

    public String listarFacturas() {
        String texto = "===== LISTA DE FACTURAS =====\n";

        for (int i = 0; i < cantidadFacturas; i++) {
            texto = texto + "\nFactura " + (i + 1) + "\n";
            texto = texto + facturas[i].mostrarDetalleFactura() + "\n";
        }

        if (cantidadFacturas == 0) {
            texto = texto + "No hay facturas registradas.";
        }

        return texto;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public BahiaTrabajo[] getBahias() {
        return bahias;
    }

    public Servicio[] getServicios() {
        return servicios;
    }

    public Repuesto[] getRepuestos() {
        return repuestos;
    }

    public Cita[] getCitas() {
        return citas;
    }

    public OrdenTrabajo[] getOrdenes() {
        return ordenes;
    }

    public Factura[] getFacturas() {
        return facturas;
    }

    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public int getCantidadClientes() {
        return cantidadClientes;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public int getCantidadBahias() {
        return cantidadBahias;
    }

    public int getCantidadServicios() {
        return cantidadServicios;
    }

    public int getCantidadRepuestos() {
        return cantidadRepuestos;
    }

    public int getCantidadCitas() {
        return cantidadCitas;
    }

    public int getCantidadOrdenes() {
        return cantidadOrdenes;
    }

    public int getCantidadFacturas() {
        return cantidadFacturas;
    }
}