package pds.patronProxy.security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Seguridad {

    private static final String DB_HOST = "monorail.proxy.rlwy.net";
    private static final String DB_PORT = "32207";
    private static final String DB_NAME = "railway";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "3FCa*16661D*b21af--c54Ag*a4Aeccg";

    public boolean Autorizacion(String email, String password) {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME,
                DB_USER,
                DB_PASSWORD)
        ){
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