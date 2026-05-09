package AgendaAmigos;

import java.util.*;

public class AgendaContatosModel {
	private List<Amigo> listaAmigos;
	
	public AgendaContatosModel() {
		this.listaAmigos = new ArrayList<>();
	}
	
	public Amigo incluir(String nome, String email, String celular, String apelido) {
		Amigo amigo = new Amigo(nome, email, apelido, celular); 
		listaAmigos.add(amigo);
		return amigo;
	}
	
	public void excluir(int idExcluir) {
		for(int i = 0; i < listaAmigos.size(); i++) {
			if(this.listaAmigos.get(i).getId() == idExcluir) {
				this.listaAmigos.remove(i);
			}
		}
		
	}
}
