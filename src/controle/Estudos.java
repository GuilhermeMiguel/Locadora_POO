package controle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Estudos {

	public static void main(String[] args) {
		String nomePagina = "/telaInicia.xhtml";
		
		List<String> telas = Arrays.asList("/telaInicia.xhtml", "/index.xhtml", "/cadastroa.xhtml", "/sedan.xhtml"
				+ "/suv.xhtml", "/esporte.xhtml", "/cadastro.xhtml", "/login.xhtml");
		
		telas = telas.stream().filter(x -> x.equals(nomePagina)).collect(Collectors.toList());
		
		if(telas.size() > 0) {
			System.out.println("Encontou o nome da pagina");
		}		
	} 
}
