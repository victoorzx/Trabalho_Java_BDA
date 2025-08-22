package main;

import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Conexão com o SQL Server estabelecida com sucesso!");
            } else {
                System.out.println("❌ Falha ao conectar.");
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
