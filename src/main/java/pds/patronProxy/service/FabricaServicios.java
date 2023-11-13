package pds.patronProxy.service;

import pds.patronProxy.implementation.IProcesos;

public class FabricaServicios {

    public static IProcesos CrearEjecucionProceso(boolean auditable) {
        if (auditable) {
            return new ProxyAuditable();
        } else {
            return new ProxyNoAuditable();
        }
    }
}