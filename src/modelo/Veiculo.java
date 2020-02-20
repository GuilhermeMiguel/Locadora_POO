package modelo;

import lombok.Data;

@Data
public class Veiculo {
	private int Id;
	private String Modelo;
	private String Marca;
	private String Motorizacao;
	private String Situacao;
	private Double Diaria;
	private int Ano;
	private int Quantidade;

}
 