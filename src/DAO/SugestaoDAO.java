package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;
import modelo.Sugestao;

public class SugestaoDAO {
	
	private static SugestaoDAO instance;

	private SugestaoDAO() {
	}

	public static SugestaoDAO getInstance() {
		if (instance == null) {
			instance = new SugestaoDAO();
		}

		return instance;
	}

	public void create(Sugestao c) {
		

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO sugestao (nome, email, telefone_01, telefone_02, assunto, texto)VALUES(?,?,?,?,?,?)";
		
		try {
			
			stmt = con.prepareStatement(sql);

			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getTelefone_01());
			stmt.setString(4, c.getTelefone_02());
			stmt.setString(5, c.getAssunto());
			stmt.setString(6, c.getTexto());
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}