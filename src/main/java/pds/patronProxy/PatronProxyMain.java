package pds.patronProxy;

import pds.patronProxy.service.FabricaServicios;
import pds.patronProxy.implementation.IProcesos;

public class PatronProxyMain {

    public static void main(String[] args) {

        String email = "santiagomejia2000@hotmail.com";
        String password = "123456";

        String email2 = "erickruiz1452@hotmail.com";
        String password2 = "123456";

        String email3 = "admin@hotmail.com";
        String password3 = "12345";


        // Obtener un proxy auditable
        IProcesos ProcesoActivoAuditable = FabricaServicios.CrearEjecucionProceso(true);
        try {
            ProcesoActivoAuditable.EjecutarProcesos(1, email, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Obtener un proxy no auditable
        IProcesos ProcesoActivoNoAuditable = FabricaServicios.CrearEjecucionProceso(false);
        try {
            ProcesoActivoNoAuditable.EjecutarProcesos(2, email2, password2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}