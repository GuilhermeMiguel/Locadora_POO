package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.AluguelDAO;
import lombok.Data;
import modelo.Aluguel;

@Data
@ManagedBean
@SessionScoped
public class AluguelController {
	private List<Aluguel> alugueis;
    private Aluguel aluguel;
    private AluguelDAO aluguelDAO = AluguelDAO.getInstance();
    Double diaria;

       
    public AluguelController () {
            aluguel = new Aluguel();
            exibeLista();
    }

    public void salvaAluguel() {
    	calculaValor();
    	aluguelDAO.create(aluguel);
    	exibeLista();
    }
    
	public void atualizaAluguel() {
		aluguelDAO.update(aluguel);
		 exibeLista();
	}
	
	public List<Aluguel> pesquisaVeiculo(int id) {
		return aluguelDAO.carregaCarro(id);
	}
	
	public void pesquisaAluguel() {
		aluguel = aluguelDAO.pesquisaAluguel(aluguel.getIdVeiculo(), aluguel.getDocumento());
	}
	
	public String reservaEtios() {
		int id = 11;
		List<Aluguel> veiculo = pesquisaVeiculo(id);
		aluguel.setIdVeiculo(id);
		aluguel.setModelo(veiculo.get(0).getModelo());
		aluguel.setMotorizacao(veiculo.get(0).getMotorizacao());
		aluguel.setAno(veiculo.get(0).getAno());
		aluguel.setValor(veiculo.get(0).getValor());
		aluguel.setSituacao("Pendente");
		diaria = veiculo.get(0).getDiaria();
		return "reserva.xhtml";
	}
	
	public String reservaVoyage() {
		int id = 12;
		List<Aluguel> veiculo = pesquisaVeiculo(id);
		aluguel.setIdVeiculo(id);
		aluguel.setModelo(veiculo.get(0).getModelo());
		aluguel.setMotorizacao(veiculo.get(0).getMotorizacao());
		aluguel.setAno(veiculo.get(0).getAno());
		aluguel.setSituacao("Pendente");
		diaria = veiculo.get(0).getDiaria();
		
		return "reserva.xhtml";
	}
	
	public String reservaVersa() {
		int id = 13;
		List<Aluguel> veiculo = pesquisaVeiculo(id);
		aluguel.setIdVeiculo(id);
		aluguel.setModelo(veiculo.get(0).getModelo());
		aluguel.setMotorizacao(veiculo.get(0).getMotorizacao());
		aluguel.setAno(veiculo.get(0).getAno());
		diaria = veiculo.get(0).getDiaria();
		aluguel.setSituacao("Pendente");
		return "reserva.xhtml";
	}
	
	public String reservaHB20() {
		int id = 21;
		List<Aluguel> veiculo = pesquisaVeiculo(id);
		aluguel.setIdVeiculo(id);
		aluguel.setModelo(veiculo.get(0).getModelo());
		aluguel.setMotorizacao(veiculo.get(0).getMotorizacao());
		aluguel.setAno(veiculo.get(0).getAno());
		diaria = veiculo.get(0).getDiaria();
		aluguel.setSituacao("Pendente");
		return "reserva.xhtml";
	}
	
	public String reservaPolo() {
		int id = 22;
		List<Aluguel> veiculo = pesquisaVeiculo(id);
		aluguel.setIdVeiculo(id);
		aluguel.setModelo(veiculo.get(0).getModelo());
		aluguel.setMotorizacao(veiculo.get(0).getMotorizacao());
		aluguel.setAno(veiculo.get(0).getAno());
		diaria = veiculo.get(0).getDiaria();
		aluguel.setSituacao("Pendente");
		return "reserva.xhtml";
	}
	
	public String reservaKa() {
		int id = 23;
		List<Aluguel> veiculo = pesquisaVeiculo(id);
		aluguel.setIdVeiculo(id);
		aluguel.setModelo(veiculo.get(0).getModelo());
		aluguel.setMotorizacao(veiculo.get(0).getMotorizacao());
		aluguel.setAno(veiculo.get(0).getAno());
		diaria = veiculo.get(0).getDiaria();
		aluguel.setSituacao("Pendente");
		return "reserva.xhtml";
	}
	
	public String reservaEcoSport() {
		int id = 31;
		List<Aluguel> veiculo = pesquisaVeiculo(id);
		aluguel.setIdVeiculo(id);
		aluguel.setModelo(veiculo.get(0).getModelo());
		aluguel.setMotorizacao(veiculo.get(0).getMotorizacao());
		aluguel.setAno(veiculo.get(0).getAno());
		diaria = veiculo.get(0).getDiaria();
		aluguel.setSituacao("Pendente");
		return "reserva.xhtml";
	}
	
	public String reservaKicks() {
		int id = 32;
		List<Aluguel> veiculo = pesquisaVeiculo(id);
		aluguel.setIdVeiculo(id);
		aluguel.setModelo(veiculo.get(0).getModelo());
		aluguel.setMotorizacao(veiculo.get(0).getMotorizacao());
		aluguel.setAno(veiculo.get(0).getAno());
		diaria = veiculo.get(0).getDiaria();
		aluguel.setSituacao("Pendente");
		return "reserva.xhtml";
	}
	
	public String reservaDuster() {
		int id = 33;
		List<Aluguel> veiculo = pesquisaVeiculo(id);
		aluguel.setIdVeiculo(id);
		aluguel.setModelo(veiculo.get(0).getModelo());
		aluguel.setMotorizacao(veiculo.get(0).getMotorizacao());
		aluguel.setAno(veiculo.get(0).getAno());
		diaria = veiculo.get(0).getDiaria();
		aluguel.setSituacao("Pendente");
		return "reserva.xhtml";
	}
	
	
	public void limpaAluguel() {
		aluguel.setIdVeiculo(0);
		aluguel.setDocumento("");
		aluguel.setQtdDias("");
		aluguel.setSituacao("");;
		aluguel.setValor("");
		aluguel.setDiaria(0.0);
	
	}

	public void calculaValor() {
		
		Double total = diaria * Double.parseDouble(aluguel.getQtdDias());
		aluguel.setValor(String.valueOf(total));
	}
	
	public void exibeLista() {
		alugueis = aluguelDAO.read();
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
}