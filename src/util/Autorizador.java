package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import modelo.Usuario;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void afterPhase(PhaseEvent event) {
		
		FacesContext context = event.getFacesContext();
		
		
		String nomePagina = context.getViewRoot().getViewId();
		
		System.out.println(nomePagina);
		
		List<String> telas = Arrays.asList("/telaInicia.xhtml", "/index.xhtml", "/cadastroa.xhtml", "/sedan.xhtml"
				+ "/suv.xhtml", "/esporte.xhtml", "/cadastro.xhtml", "/login.xhtml");
		
		telas = telas.stream().filter(x -> x.equals(nomePagina)).collect(Collectors.toList());
		
		if(telas.size() > 0) {
			return;
		} 
		
		Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if(usuarioLogado != null) {
			return; //continua normalmente a execução
		}
		
		//redirecionamento para a página de login.xhtml caso o usuário não esteja logado
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/login?faces-redirect=true");
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
