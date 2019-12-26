package modelo;

public class Sugestao {
	private String Nome;
	private String Email;
	private String Telefone_01;
	private String Telefone_02;
	private String Assunto;
	private String Texto;


	public Sugestao () {
		
	}

	public Sugestao(String nome, String email, String telefone_01, String telefone_02, String assunto, String texto) {
		this.Nome = nome;
		this.Email = email;
		this.Telefone_01 = telefone_01;
		this.Telefone_02 = telefone_02;
		this.Assunto = assunto;
		this.Texto = texto;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone_01() {
		return Telefone_01;
	}

	public void setTelefone_01(String telefone_01) {
		Telefone_01 = telefone_01;
	}

	public String getTelefone_02() {
		return Telefone_02;
	}

	public void setTelefone_02(String telefone_02) {
		Telefone_02 = telefone_02;
	}

	public String getAssunto() {
		return Assunto;
	}

	public void setAssunto(String assunto) {
		Assunto = assunto;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}
}
