package modelo;

import lombok.Data;

@Data
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
	
}
 