package pds.patronProxy;

import pds.patronProxy.implementation.FabricaServicios;
import pds.patronProxy.implementation.IProcesos;

public class PatronProxyMain {

    public static void main(String[] args) {

        String usuario = "fbolano";
        String password = "8877";
        int proceso = 1;

        // Obtener un proxy auditable
        IProcesos ProcesoActivoAuditable = FabricaServicios.CrearEjecucionProceso(true);
        try {
            ProcesoActivoAuditable.EjecutarProcesos(proceso, usuario, password);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Obtener un proxy no auditable
        IProcesos ProcesoActivoNoAuditable = FabricaServicios.CrearEjecucionProceso(false);
        try {
            ProcesoActivoNoAuditable.EjecutarProcesos(proceso, usuario, password);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}