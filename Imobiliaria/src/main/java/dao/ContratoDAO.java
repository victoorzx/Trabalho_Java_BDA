package dao;

import model.Contrato;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {

    // Inserir contrato
    public void inserir(Contrato contrato) {
        String sql = "INSERT INTO Contrato (ClienteId, ImovelId, ValorMensal, DataInicio, DataFim) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contrato.getClienteId());
            stmt.setInt(2, contrato.getImovelId());
            stmt.setDouble(3, contrato.getValorMensal());
            stmt.setDate(4, Date.valueOf(contrato.getDataInicio()));
            stmt.setDate(5, Date.valueOf(contrato.getDataFim()));

            stmt.executeUpdate();
            System.out.println("✅ Contrato inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir contrato: " + e.getMessage());
        }
    }

    // Listar todos os contratos
    public List<Contrato> listar() {
        List<Contrato> contratos = new ArrayList<>();
        String sql = "SELECT * FROM Contrato";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato();
                c.setContratoId(rs.getInt("ContratoId"));
                c.setClienteId(rs.getInt("ClienteId"));
                c.setImovelId(rs.getInt("ImovelId"));
                c.setValorMensal(rs.getDouble("ValorMensal"));
                c.setDataInicio(rs.getDate("DataInicio").toLocalDate());
                c.setDataFim(rs.getDate("DataFim").toLocalDate());
                contratos.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar contratos: " + e.getMessage());
        }

        return contratos;
    }

    // Clientes com mais contratos
    public List<String> clientesComMaisContratos() {
        List<String> resultados = new ArrayList<>();
        String sql = "SELECT c.Nome, COUNT(ct.ContratoId) AS TotalContratos " +
                "FROM Cliente c " +
                "JOIN Contrato ct ON c.ClienteId = ct.ClienteId " +
                "GROUP BY c.Nome " +
                "ORDER BY TotalContratos DESC;";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultados.add(String.format("%-20s | %d contrato(s)",
                        rs.getString("Nome"),
                        rs.getInt("TotalContratos")));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar clientes com mais contratos: " + e.getMessage());
        }

        return resultados;
    }


    // Contratos expirando nos próximos 30 dias
    public List<String> contratosExpirando30Dias() {
        List<String> resultados = new ArrayList<>();
        String sql = "SELECT ct.ContratoId, c.Nome AS Cliente, i.Endereco AS Imovel, ct.ValorMensal, ct.DataInicio, ct.DataFim " +
                "FROM Contrato ct " +
                "JOIN Cliente c ON ct.ClienteId = c.ClienteId " +
                "JOIN Imovel i ON ct.ImovelId = i.ImovelId " +
                "WHERE ct.DataFim BETWEEN GETDATE() AND DATEADD(DAY, 30, GETDATE()) " +
                "ORDER BY ct.DataFim ASC;";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultados.add(String.format("%-5d | %-20s | %-30s | R$ %-8.2f | %s -> %s",
                        rs.getInt("ContratoId"),
                        rs.getString("Cliente"),
                        rs.getString("Imovel"),
                        rs.getDouble("ValorMensal"),
                        rs.getDate("DataInicio"),
                        rs.getDate("DataFim")));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar contratos expirando: " + e.getMessage());
        }

        return resultados;
    }

}
