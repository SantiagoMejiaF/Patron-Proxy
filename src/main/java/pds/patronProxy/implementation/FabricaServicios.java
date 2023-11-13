package pds.patronProxy.implementation;

import pds.patronProxy.service.ProxyAutenticacion;

public class FabricaServicios {

    public static IProcesos CrearEjecucionProceso(boolean auditable) {
        if (auditable) {
            return new ProxyProcesos();
        } else {
            return new ProxyAutenticacion();
        }
    }
}