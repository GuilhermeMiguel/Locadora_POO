package util;

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
		
		if("/telaInicia.xhtml".equals(nomePagina)) {
			return;
		}
		
		if("/index.xhtml".equals(nomePagina)) {
			return;
		}
		
		if("/cadastroa.xhtml".equals(nomePagina)) {
			return;
		}
		
		if("/sedan.xhtml".equals(nomePagina)) {
			return;
		}
		
		if("/suv.xhtml".equals(nomePagina)) {
			return;
		}
		
		if("/esporte.xhtml".equals(nomePagina)) {
			return;
		}
		
		if("/cadastro.xhtml".equals(nomePagina)) {
			return;
		}
		
		if("/login.xhtml".equals(nomePagina)) {
			return; //continua normalmente a execu��o
		}
		
		Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if(usuarioLogado != null) {
			return; //continua normalmente a execu��o
		}
		
		//redirecionamento para a p�gina de login.xhtml caso o usu�rio n�o esteja logado
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
