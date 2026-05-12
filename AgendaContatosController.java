// package AgendaAmigos;

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
		view.getBtnAlterar().addActionListener(e -> habilitarAlterar());
		view.getBtnExcluir().addActionListener(e -> habilitarExcluir());
		view.getBtnBuscar().addActionListener(e -> buscar());
	}
	
	// Eventos dos botões: habilitar dialogs
	public void habilitarIncluir(){
		DialogIncluirPessoa dialog = new DialogIncluirPessoa(this);
		dialog.setVisible(true);
	}
	
	public void habilitarExcluir(){
		DialogExcluirPessoa dialogExcluir = new DialogExcluirPessoa(this);
		dialogExcluir.setVisible(true);
	}

	public void habilitarAlterar(){
		DialogAlterarPessoa dialogAlterar = new DialogAlterarPessoa(this);
		dialogAlterar.setVisible(true);
	}
	
	// Operações propriamente ditas: incluir, excluir, alterar e buscar
	public void incluir(int id, String nome, String email, String telefone, String apelido){
		Amigo novoAmigo = model.incluir(nome, email, telefone, apelido);
		view.atualizarIncluirLista(novoAmigo);
	}
	
	public void excluir(int idAmigo) {
		model.excluir(idAmigo);
		view.atualizarExcluirLista(idAmigo);
	}

	public void alterar(String nome, String email, String telefone, String apelido){

	}
	
	
	public void alterar() {
		
	}
	
	// Chama o buscar da model e já passa como parâmetro para atualizar a tabela
	public void buscar() {
		view.atualizarTabelaBusca(model.buscar(view.getInputBusca().getText()));
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
