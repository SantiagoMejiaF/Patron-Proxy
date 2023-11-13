package pds.patronProxy.implementation;

public class ProcesosImpl implements IProcesos {

    @Override
    public void EjecutarProcesos(int IdProceso, String Usuario, String Password) throws Exception {

        System.out.println("Proceso " + IdProceso + " en acción"  + "\n");

        System.out.println(
                "Datos de Autenticacion "+ "\n" +
                "Email: " + Usuario + "\n" +
                "Password: " + Password + "\n"
        );
        System.out.println("Proceso " + IdProceso + " finalizado" + "\n");
    }
}