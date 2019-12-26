package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import DAO.SugestaoDAO;
import modelo.Sugestao;

@ManagedBean
@RequestScoped
public class SugestaoController {

	private Sugestao sugestao;
	private SugestaoDAO sugestaoDAO = SugestaoDAO.getInstance();

	public SugestaoController() {
		sugestao = new Sugestao();
	}

	public Sugestao getSugestao() {
		return sugestao;
	}

	public void setSugestao(Sugestao sugestao) {
		this.sugestao = sugestao;
	}

	public void salvaSugestao() {
		sugestaoDAO.create(sugestao);
		limpaSugestao();
	}
	
	public void limpaSugestao() {
		sugestao.setNome("");
		sugestao.setEmail("");
		sugestao.setTelefone_01("");
		sugestao.setTelefone_02("");
		sugestao.setAssunto("");
		sugestao.setTexto("");
	}
}