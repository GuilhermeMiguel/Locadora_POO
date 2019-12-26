package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import DAO.UsuarioDAO;
import modelo.Usuario;


@ManagedBean
@SessionScoped
public class LoginController {
	private Usuario usuario;
	private UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();

	public LoginController() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() {
		System.out.println("Fazendo Login do usuário " + usuario.getEmail());
		
		
		boolean existe = usuarioDAO.existe(usuario.getEmail(), usuario.getSenha());
		
		if (usuario.getEmail().equals("adm@portoseguro.com.br") && usuario.getSenha().equals("000")) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "adm.xhtml";
		}
		else {
		if(existe == true) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			
			
			return "telaInicia.xhtml";
		}
	}
		
		return "login.xhtml";
	}
	
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado"); //remove a referência do login 
		return "telaInicia?faces-redirect=true";
	}
}
		
		
