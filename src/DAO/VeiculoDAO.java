package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import modelo.Veiculo;

public class VeiculoDAO {

	private static VeiculoDAO instance;

	private VeiculoDAO() {
	}

	public static VeiculoDAO getInstance() {
		if (instance == null) {
			instance = new VeiculoDAO();
		}

		return instance;
	}

	public void create(Veiculo c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(
					"INSERT INTO veiculo (id, modelo, marca, motorizacao, diaria, situacao, ano, quantidade)VALUES(?,?,?,?,?,?,?,?)");

			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getModelo());
			stmt.setString(3, c.getMarca());
			stmt.setString(4, c.getMotorizacao());
			stmt.setDouble(5, c.getDiaria());
			stmt.setString(6, c.getSituacao());
			stmt.setInt(7, c.getAno());
			stmt.setInt(8, c.getQuantidade());
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public Veiculo findById(Integer id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Veiculo veiculo = new Veiculo();

		String sql = "SELECT id, modelo, marca, motorizacao, diaria, situacao, ano, quantidade FROM veiculo WHERE id = ? ";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				veiculo.setId(rs.getInt("id"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setMotorizacao(rs.getString("motorizacao"));
				veiculo.setSituacao(rs.getString("situacao"));
				veiculo.setDiaria(rs.getDouble("diaria"));
				veiculo.setAno(rs.getInt("ano"));
				veiculo.setQuantidade(rs.getInt("quantidade"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return veiculo;

	}

	public List<Veiculo> findAll() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Veiculo> veiculos = new ArrayList<>();

		String sql = "SELECT * FROM veiculo ";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Veiculo veiculo = new Veiculo();

				veiculo.setId(rs.getInt("id"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setMotorizacao(rs.getString("motorizacao"));
				veiculo.setSituacao(rs.getString("situacao"));
				veiculo.setDiaria(rs.getDouble("diaria"));
				veiculo.setAno(rs.getInt("ano"));
				veiculo.setQuantidade(rs.getInt("quantidade"));

				veiculos.add(veiculo);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return veiculos;

	}

	public void update(Veiculo c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(
					"UPDATE veiculo SET modelo = ? ,marca = ? ,motorizacao = ?, situacao = ? ,diaria = ?,ano = ?,quantidade = ? WHERE id = ?");

			stmt.setString(1, c.getModelo());
			stmt.setString(2, c.getMarca());
			stmt.setString(3, c.getMotorizacao());
			stmt.setString(4, c.getSituacao());
			stmt.setDouble(5, c.getDiaria());
			stmt.setInt(6, c.getAno());
			stmt.setInt(7, c.getQuantidade());
			stmt.setInt(8, c.getId());
			stmt.executeUpdate();

			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

}