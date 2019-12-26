package modelo;

public class Aluguel {
	
	private int idVeiculo;
	private String Documento;
	private String qtdDias;
	private String Valor;
	private String Situacao;
	private String Modelo;
	private String Motorizacao;
	private int Ano;
	private Double Diaria;
	
	
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String documento) {
		Documento = documento;
	}
	public String getQtdDias() {
		return qtdDias;
	}
	public void setQtdDias(String qtdDias) {
		this.qtdDias = qtdDias;
	}
	public String getValor() {
		return Valor;
	}
	public void setValor(String valor) {
		Valor = valor;
	}
	public String getSituacao() {
		return Situacao;
	}
	public void setSituacao(String situacao) {
		Situacao = situacao;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getMotorizacao() {
		return Motorizacao;
	}
	public void setMotorizacao(String motorizacao) {
		Motorizacao = motorizacao;
	}
	public int getAno() {
		return Ano;
	}
	public void setAno(int ano) {
		Ano = ano;
	}
	public Double getDiaria() {
		return Diaria;
	}
	public void setDiaria(Double diaria) {
		Diaria = diaria;
	}
}
