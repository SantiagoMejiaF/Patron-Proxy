package pds.patronProxy.service;

import pds.patronProxy.implementation.IProcesos;
import pds.patronProxy.implementation.ProcesosImpl;
import pds.patronProxy.security.Seguridad;

public class ProxyNoAuditable implements IProcesos {

    @Override
    public void EjecutarProcesos(int IdProceso, String usuario, String password) throws Exception {
        ProcesosImpl ejecutorProcess = new ProcesosImpl();
        Seguridad securityService = new Seguridad();
        if (!securityService.Autorizacion(usuario, password)) {
            ejecutorProcess.EjecutarProcesos(IdProceso, usuario, password);
            System.out.println("----------------------------------- AUTENTICACIÓN FALLIDA -----------------------------------");
            System.out.println("Email: " + usuario);
            System.out.println("Password: " + password);
            System.out.println("Proceso ejecutado desde el Proxy No Auditable");
            System.out.println("---------------------------------------------------------------------------------------------");
            throw new Exception("Usuario no registrado en la base de datos o credenciales incorrectas");
        }

        ejecutorProcess.EjecutarProcesos(IdProceso, usuario, password);
        System.out.println("----------------------------------- AUTENTICACIÓN EXITOSA -----------------------------------");
        System.out.println("Email: " + usuario);
        System.out.println("Password: " + password);
        System.out.println("Proceso ejecutado desde el Proxy No Auditable");
        System.out.println("---------------------------------------------------------------------------------------------");
    }}