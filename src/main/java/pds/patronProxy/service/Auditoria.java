package pds.patronProxy.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Auditoria {

    public void AuditoriaServicioUsado(String user, String servicio, boolean exitoso, String resultado) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String estado = exitoso ? "Exitoso" : "Error";

        System.out.println("------------------------------------------- AUDITORIA --------------------------------------" + "\n" +
                "Usuario: " + user + "\n" +
                "Servicio: " + servicio + "\n" +
                "Estado: " + estado + "\n" +
                "Fecha: " + formatter.format(new Date()) + "\n" +
                "Resultado: " + resultado + "\n" +
                "---------------------------------------------------------------------------------------------" + "\n" );
    }
}