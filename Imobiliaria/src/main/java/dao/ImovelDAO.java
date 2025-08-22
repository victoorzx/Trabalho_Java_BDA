package dao;

import model.Imovel;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO {

    public void inserir(Imovel imovel) {
        String sql = "INSERT INTO Imovel (Endereco, Tipo, Quartos, Banheiros, VagasGaragem, Area, Disponivel) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, imovel.getEndereco());
            stmt.setString(2, imovel.getTipo());
            stmt.setInt(3, imovel.getQuartos());
            stmt.setInt(4, imovel.getBanheiros());
            stmt.setInt(5, imovel.getVagasGaragem());
            stmt.setDouble(6, imovel.getArea());
            stmt.setBoolean(7, imovel.isDisponivel());
            stmt.executeUpdate();

            System.out.println("✅ Imóvel inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir imóvel: " + e.getMessage());
        }
    }

    public List<Imovel> listar() {
        List<Imovel> imoveis = new ArrayList<>();
        String sql = "SELECT * FROM Imovel";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Imovel i = new Imovel();
                i.setImovelId(rs.getInt("ImovelId"));
                i.setEndereco(rs.getString("Endereco"));
                i.setTipo(rs.getString("Tipo"));
                i.setQuartos(rs.getInt("Quartos"));
                i.setBanheiros(rs.getInt("Banheiros"));
                i.setVagasGaragem(rs.getInt("VagasGaragem"));
                i.setArea(rs.getDouble("Area"));
                i.setDisponivel(rs.getBoolean("Disponivel"));
                imoveis.add(i);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar imóveis: " + e.getMessage());
        }

        return imoveis;
    }
}
