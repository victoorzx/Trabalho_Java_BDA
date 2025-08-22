package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL =  "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=ImobiliariaDB;encrypt=false;trustServerCertificate=true";
    private static final String USER = "ImobiliariaUser";
    private static final String PASSWORD = "SenhaForte123!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
