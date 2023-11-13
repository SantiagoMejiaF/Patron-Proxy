package pds.patronProxy.implementation;

public class ProcesoDefecto implements IProcesos {

    @Override
    public void EjecutarProcesos(int IdProceso, String Usuario, String Password) throws Exception {
        System.out.println("proceso " + IdProceso + " en acciòn");
        System.out.println("proceso " + IdProceso + " finalizado");
    }
}