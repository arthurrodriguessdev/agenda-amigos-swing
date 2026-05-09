package AgendaAmigos;

import java.util.*;

public class AgendaContatosController {
	private AgendaContatosView view;
	private AgendaContatosModel model;
	
	public AgendaContatosController(AgendaContatosView view, AgendaContatosModel model) {
		this.view = view;
		this.model = model;
		configurarEventos();
	}
	
	public void configurarEventos() {
		view.getBtnIncluir().addActionListener(e ->habilitarIncluir());
		view.getBtnAlterar().addActionListener(e -> alterar());
		view.getBtnExcluir().addActionListener(e -> habilitarExcluir());
		view.getBtnBuscar().addActionListener(e -> buscar());
	}
	
	public void habilitarIncluir() {
		DialogIncluirPessoa dialog = new DialogIncluirPessoa(this.getModel(), this);
		dialog.setVisible(true);
	}
	
	public void habilitarExcluir() {
		DialogExcluirPessoa dialogExcluir = new DialogExcluirPessoa();
		dialogExcluir.setVisible(true);
	}
	
	public void incluir(String nome, String email, String telefone, String apelido) {
		
		Amigo novoAmigo = model.incluir(nome, email, telefone, apelido);
		view.atualizarIncluirLista(novoAmigo);
	}
	
	
	public void excluir() {
		
	}
	
	public void alterar() {
		
	}
	
	public void buscar() {
		
	}

	public AgendaContatosView getView() {
		return view;
	}

	public void setView(AgendaContatosView view) {
		this.view = view;
	}

	public AgendaContatosModel getModel() {
		return model;
	}

	public void setModel(AgendaContatosModel model) {
		this.model = model;
	}
}
