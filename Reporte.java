public class Reporte {

    public String reporteBahias(BahiaTrabajo[] bahias, int cantidadBahias) {
        String texto = "===== REPORTE DE OCUPACION DE BAHIAS =====\n";

        for (int i = 0; i < cantidadBahias; i++) {
            if (bahias[i] != null) {
                texto = texto + "\nBahia " + bahias[i].getNumero();
                texto = texto + "\nTipo: " + bahias[i].getTipo();
                texto = texto + "\nEstado: " + bahias[i].getEstado();
                texto = texto + "\n";
            }
        }

        if (cantidadBahias == 0) {
            texto = texto + "No hay bahias registradas.";
        }

        return texto;
    }

    public String reporteIngresos(Factura[] facturas, int cantidadFacturas) {
        String texto = "===== REPORTE DE INGRESOS =====\n";

        double totalServicios = 0;
        double totalRepuestos = 0;
        double totalGeneral = 0;

        for (int i = 0; i < cantidadFacturas; i++) {
            if (facturas[i] != null) {
                totalServicios = totalServicios + facturas[i].getTotalServicios();
                totalRepuestos = totalRepuestos + facturas[i].getTotalRepuestos();
                totalGeneral = totalGeneral + facturas[i].getTotalPagar();

                texto = texto + "\nFactura Nro: " + facturas[i].getNumero();
                texto = texto + "\nFecha: " + facturas[i].getFecha();
                texto = texto + "\nTotal servicios: S/ " + facturas[i].getTotalServicios();
                texto = texto + "\nTotal repuestos: S/ " + facturas[i].getTotalRepuestos();
                texto = texto + "\nTotal: S/ " + facturas[i].getTotalPagar();
                texto = texto + "\n";
            }
        }

        texto = texto + "\n--- RESUMEN ---";
        texto = texto + "\nTotal servicios: S/ " + totalServicios;
        texto = texto + "\nTotal repuestos: S/ " + totalRepuestos;
        texto = texto + "\nTotal general: S/ " + totalGeneral;

        if (cantidadFacturas == 0) {
            texto = texto + "\nNo hay facturas registradas.";
        }

        return texto;
    }
}
