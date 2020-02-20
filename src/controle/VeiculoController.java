package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.VeiculoDAO;
import modelo.Veiculo;

@ManagedBean
@SessionScoped
public class VeiculoController {

	private Veiculo veiculo;
	private List<Veiculo> veiculos;
	private VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
	

	public VeiculoController() {
		veiculo = new Veiculo();
		exibeLista();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public void salvaVeiculo() {
		veiculoDAO.create(veiculo);
		limpaVeiculo();
		exibeLista();
	}

	public void atualizaVeiculo() {
		veiculoDAO.update(veiculo);
		limpaVeiculo();
		exibeLista();
	}

	public void pesquisaVeiculo() {
		veiculo = veiculoDAO.findById(veiculo.getId());
	}

	public void exibeLista() {
		veiculos = veiculoDAO.findAll();
	
	}

	public void limpaVeiculo() {
		veiculo.setId(0);
		veiculo.setModelo("");
		veiculo.setMarca("");
		veiculo.setMotorizacao("");
		veiculo.setSituacao("");
		veiculo.setDiaria(0.0);
		veiculo.setAno(0);
		veiculo.setQuantidade(0);
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}