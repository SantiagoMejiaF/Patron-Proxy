package pds.patronProxy.service;

import pds.patronProxy.implementation.IProcesos;
import pds.patronProxy.implementation.ProcesosImpl;
import pds.patronProxy.security.Seguridad;

public class ProxyAuditable implements IProcesos {

    @Override
    public void EjecutarProcesos(int IdProceso, String usuario, String password) throws Exception {
        ProcesosImpl ejecutorProcess = new ProcesosImpl();
        Seguridad securityService = new Seguridad();

        if(!securityService.Autorizacion(usuario, password)) {
            ejecutorProcess.EjecutarProcesos(IdProceso, usuario, password);
            Auditoria audit = new Auditoria();

            audit.AuditoriaServicioUsado(
                    usuario,
                    ProxyAuditable.class.getName(),
                    false,
                    "Autenticación fallida utilizando el Proxy Auditable"
            );
        }else {
            ejecutorProcess.EjecutarProcesos(IdProceso, usuario, password);
            Auditoria audit = new Auditoria();
            audit.AuditoriaServicioUsado(
                    usuario,
                    ProxyAuditable.class.getName(),
                    true,
                    "Autenticación exitosa utilizando el Proxy Auditable"
            );
        }
    }
}