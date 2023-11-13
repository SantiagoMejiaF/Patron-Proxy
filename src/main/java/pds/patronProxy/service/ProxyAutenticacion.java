package pds.patronProxy.service;

import pds.patronProxy.implementation.IProcesos;
import pds.patronProxy.implementation.ProcesoDefecto;

public class ProxyAutenticacion implements IProcesos {

    @Override
    public void EjecutarProcesos(int IdProceso, String Usuario, String Password) throws Exception {
        Seguridad securityService = new Seguridad();
        if (!securityService.Autorizacion(Usuario, Password)) {
            throw new Exception("El usuario '" + Usuario + "' no tiene privilegios para ejecutar el proceso");
        }

        ProcesoDefecto ejecutorProcess = new ProcesoDefecto();
        ejecutorProcess.EjecutarProcesos(IdProceso, Usuario, Password);
    }
}