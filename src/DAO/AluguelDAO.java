package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import modelo.Aluguel;

public class AluguelDAO {
	
	private static AluguelDAO instance;
	
	private AluguelDAO() {
	}
	
	public static AluguelDAO getInstance() {
		if (instance == null) {
			instance = new AluguelDAO();
		}

		return instance;
	} 

 
	public void create(Aluguel c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO aluguel (id, documento, qtdDias, valor, situacao)VALUES(?,?,?, ?, ?)";

		try {

			stmt = con.prepareStatement(sql);
					
			stmt.setInt(1, c.getIdVeiculo());
			stmt.setString(2, c.getDocumento());
			stmt.setString(3, c.getQtdDias());
			stmt.setString(4, c.getValor());
			stmt.setString(5, c.getSituacao());
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Aluguel> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Aluguel> alugueis = new ArrayList<>();
		String sql = "SELECT * FROM aluguel";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Aluguel aluguel = new Aluguel();

				aluguel.setIdVeiculo(rs.getInt("id"));
				aluguel.setDocumento(rs.getString("documento"));
				aluguel.setQtdDias(rs.getString("qtdDias"));
				aluguel.setValor(rs.getString("valor"));
				aluguel.setSituacao(rs.getString("situacao"));
				alugueis.add(aluguel);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return alugueis;

	}
	
	
	public Aluguel pesquisaAluguel(int idVeiculo, String documento) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Aluguel aluguel = new Aluguel();
		String sql = "SELECT id, documento, qtdDias, valor, situacao FROM aluguel WHERE id = ? and documento = ?";

		try {
			stmt = con.prepareStatement(sql);
			String id = Integer.toString(idVeiculo);
			stmt.setString(1, id);
			stmt.setString(2, documento);
			rs = stmt.executeQuery();

			while (rs.next()) {

				//Aluguel aluguel = new Aluguel();

				aluguel.setIdVeiculo(rs.getInt("id"));
				aluguel.setDocumento(rs.getString("documento"));
				aluguel.setQtdDias(rs.getString("qtdDias"));
				aluguel.setValor(rs.getString("valor"));
				aluguel.setSituacao(rs.getString("situacao"));
				
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return aluguel;

	}
	
	public List<Aluguel> carregaCarro(Integer id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Aluguel> aluguel = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT  id, modelo, motorizacao, diaria, ano FROM veiculo WHERE id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Aluguel alugueis = new Aluguel();

				alugueis.setIdVeiculo(rs.getInt("id"));
				alugueis.setModelo(rs.getString("modelo"));
				alugueis.setMotorizacao(rs.getString("motorizacao"));
				alugueis.setDiaria(rs.getDouble("diaria"));
				alugueis.setAno(rs.getInt("ano"));

				aluguel.add(alugueis);
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return aluguel;

	}

	public void update(Aluguel c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE aluguel SET qtdDias = ?,valor = ?, situacao = ? WHERE id = ? and documento = ?";

		try {

			stmt = con.prepareStatement(sql);
			
			
			
			stmt.setString(1, c.getQtdDias());
			stmt.setString(2, c.getValor());
			stmt.setString(3, c.getSituacao());
			stmt.setInt(4, c.getIdVeiculo());
			stmt.setString(5, c.getDocumento());
			
			stmt.executeUpdate();

			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

}