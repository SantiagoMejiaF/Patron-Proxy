package pds.patronProxy.implementation;

import pds.patronProxy.service.Auditoria;
import pds.patronProxy.service.Seguridad;

public class ProxyProcesos implements IProcesos {

    @Override
    public void EjecutarProcesos(int IdProceso, String Usuario, String Password) throws Exception {
        Seguridad securityService = new Seguridad();
        if(!securityService.Autorizacion(Usuario, Password)){
            throw new Exception("El usuario '"+Usuario
                    +"' no tiene privilegios para ejecutar el proceso");
        }

        ProcesoDefecto ejecutorProcess = new ProcesoDefecto();
        ejecutorProcess.EjecutarProcesos(IdProceso, Usuario, Password);

        Auditoria audit = new Auditoria();
        audit.AuditoriaServicioUsado(Usuario, ProcesoDefecto.class.getName());
    }
}