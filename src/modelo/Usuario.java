package modelo;

public class Usuario {

	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String documento) {
		Documento = documento;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
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
	public String getLogradouro() {
		return Logradouro;
	}
	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	private String Documento;
	private String Nome;
	private String dataNascimento;
	private String Email;
	private String Senha;
	private String Telefone_01;
	private String Telefone_02;
	private String Logradouro;
	private String Numero;
	private String Cep;
	private String Bairro;
	private String Cidade;
	private String Estado;
	private String Sexo;

}
