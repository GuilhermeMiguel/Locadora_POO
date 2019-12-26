package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.UsuarioDAO;
import modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioController {

	private Usuario usuario;
	private UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();

	public UsuarioController() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void salvaUsuario() {
		usuarioDAO.create(usuario);
		limpaUsuario();
	}

	public void atualizaUsuario() {
		usuarioDAO.update(usuario);
		limpaUsuario();
	}

	public void pesquisaUsuario() {
		usuario = usuarioDAO.findById(usuario.getDocumento());
	}

	public void apagarUsuario() {
		usuarioDAO.delete(usuario);
		limpaUsuario();
	}

	public void limpaUsuario() {
		usuario.setDocumento("");
		usuario.setNome("");
		usuario.setDataNascimento("");
		usuario.setEmail("");
		usuario.setSenha("");
		usuario.setTelefone_01("");
		usuario.setTelefone_02("");
		usuario.setLogradouro("");
		usuario.setNumero("");
		usuario.setCep("");
		usuario.setBairro("");
		usuario.setCidade("");
		usuario.setEstado("");
		usuario.setSexo("");
	}
}

