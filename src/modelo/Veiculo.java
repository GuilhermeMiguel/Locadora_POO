package modelo;

public class Veiculo {

	public Veiculo() {

	}

	public Veiculo(int id, String modelo, String marca, String motorizacao, String situacao, Double diaria, int ano, int quantidade) {
		super();
		Id = id;
		Modelo = modelo;
		Marca = marca;
		Motorizacao = motorizacao;
		Situacao = situacao;
		Diaria = diaria;
		Ano = ano;
		Quantidade = quantidade;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getMotorizacao() {
		return Motorizacao;
	}

	public void setMotorizacao(String motorizacao) {
		Motorizacao = motorizacao;
	}

	public String getSituacao() {
		return Situacao;
	}

	public void setSituacao(String situacao) {
		Situacao = situacao;
	}

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		Ano = ano;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public Double getDiaria() {
		return Diaria;
	}

	public void setDiaria(Double diaria) {
		Diaria = diaria;
	}

	private int Id;
	private String Modelo;
	private String Marca;
	private String Motorizacao;
	private String Situacao;
	private Double Diaria;
	private int Ano;
	private int Quantidade;

}
