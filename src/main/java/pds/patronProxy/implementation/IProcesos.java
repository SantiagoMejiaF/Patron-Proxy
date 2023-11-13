package pds.patronProxy.implementation;

public interface IProcesos {

    public void EjecutarProcesos(int IdProceso, String Usuario, String Password)
            throws Exception;
}