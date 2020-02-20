package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionFactory;
import modelo.Usuario;

public class UsuarioDAO {
	
	private static UsuarioDAO instance;
	
	//String admEmail, admSenha;
	
	private UsuarioDAO() {
	}
	
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		
		return instance; 
	}
 
	public void create(Usuario c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO usuario (documento, nome, dataNascimento, senha, email, telefone_01, telefone_02, logradouro, numero, cep, bairro, cidade, estado, sexo)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			stmt = con.prepareStatement(sql);
					

			stmt.setString(1, c.getDocumento());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getDataNascimento());
			stmt.setString(4, c.getSenha());
			stmt.setString(5, c.getEmail());
			stmt.setString(6, c.getTelefone_01());
			stmt.setString(7, c.getTelefone_02());
			stmt.setString(8, c.getLogradouro());
			stmt.setString(9, c.getNumero());
			stmt.setString(10, c.getCep());
			stmt.setString(11, c.getBairro());
			stmt.setString(12, c.getCidade());
			stmt.setString(13, c.getEstado());
			stmt.setString(14, c.getSexo());
			
			stmt.executeUpdate();

			System.out.println("Salvo com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public Usuario findById(String documento) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Usuario usuario = new Usuario();
		
		String sql = "SELECT documento, nome, dataNascimento, senha, email, telefone_01, telefone_02, logradouro, numero, cep, bairro, cidade, estado, sexo FROM usuario WHERE documento = ? ";

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, documento);
		    rs = stmt.executeQuery();
			while (rs.next()) {
				usuario.setDocumento(rs.getString("documento"));
				usuario.setNome(rs.getString("nome"));
				usuario.setDataNascimento(rs.getString("dataNascimento"));
				usuario.setSenha(rs.getString("senha"));				
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone_01(rs.getString("telefone_01"));
				usuario.setTelefone_02(rs.getString("telefone_02"));
				usuario.setLogradouro(rs.getString("logradouro"));
				usuario.setNumero(rs.getString("numero"));
				usuario.setCep(rs.getString("cep"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setCidade(rs.getString("cidade"));
				usuario.setEstado(rs.getString("estado"));
				usuario.setSexo(rs.getString("sexo"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return usuario;
	}
	
	
	public boolean existe(String email, String senha) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean resultado = false;
		Usuario usuario = new Usuario();
		
		String sql = "SELECT email, senha FROM usuario WHERE email = ? and senha = ? ";

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, senha);
		    rs = stmt.executeQuery();
			while (rs.next()) {
				
				usuario.setSenha(rs.getString("senha"));				
				usuario.setEmail(rs.getString("email"));
				resultado = true;
				
			}

		} catch (SQLException ex) {
			System.out.println("Erro" + ex);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return resultado;
	}

	
	public void update(Usuario c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE usuario SET nome = ? , dataNascimento = ? , senha = ?, email = ?, telefone_01 = ?, telefone_02 = ?, logradouro = ?, numero = ?, cep = ? , bairro = ?, cidade = ?, estado = ?, sexo = ?  WHERE documento = ?";

		try {

			stmt = con.prepareStatement(sql);
					
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getDataNascimento());
			stmt.setString(3, c.getSenha());
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getTelefone_01());
			stmt.setString(6, c.getTelefone_02());
			stmt.setString(7, c.getLogradouro());
			stmt.setString(8, c.getNumero());
			stmt.setString(9, c.getCep());
			stmt.setString(10, c.getBairro());
			stmt.setString(11, c.getCidade());
			stmt.setString(12, c.getEstado());
			stmt.setString(13, c.getSexo());
			stmt.setString(14, c.getDocumento());
			stmt.executeUpdate();

			System.out.println("Atualizado com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(Usuario c) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM usuario WHERE documento = ?";

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getDocumento());
			stmt.executeUpdate();

			System.out.println("Excluido com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro ao excluir: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}