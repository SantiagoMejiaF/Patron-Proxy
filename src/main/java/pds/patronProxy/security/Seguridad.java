package pds.patronProxy.security;

import pds.patronProxy.configuration.ConfiguracionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Seguridad {

    public boolean Autorizacion(String email, String password) {
        try (Connection connection = DriverManager.getConnection(ConfiguracionDB.URL_CONEXION,
                ConfiguracionDB.USUARIO, ConfiguracionDB.CONTRASENA)) {
            String consulta = "SELECT * FROM usuarios WHERE email = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}