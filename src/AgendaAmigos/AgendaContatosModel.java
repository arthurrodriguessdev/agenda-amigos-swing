package AgendaAmigos;

import java.util.*;
import java.util.List;

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
		int indiceAmigoLista = buscarIndiceAmigo(idExcluir);
		if(indiceAmigoLista != -1){
			this.listaAmigos.remove(indiceAmigoLista);
		}
	}

	// Recebe uma string e retorna a lista com os resultados equivalentes
	public List<Amigo> buscar(String nome){
		return this.listaAmigos.stream().filter(
			a -> a.getNome().contains(nome)
		).toList();
	}

	public Amigo alterar(int id, String nome, String email, String telefone, String apelido){
		int indiceAmigoLista = buscarIndiceAmigo(id);
		if(indiceAmigoLista != -1){
			this.listaAmigos.get(indiceAmigoLista).setApelido(apelido);
			this.listaAmigos.get(indiceAmigoLista).setCelular(telefone);
			this.listaAmigos.get(indiceAmigoLista).setEmail(email);
			this.listaAmigos.get(indiceAmigoLista).setNome(nome);
			return this.listaAmigos.get(indiceAmigoLista);
		}
		
		return null;
	}

	// Recebe um ID, percorre a lista e retorna a posição do amigo
	public int buscarIndiceAmigo(int id){
		for(int i = 0; i < listaAmigos.size(); i++) {
			if(this.listaAmigos.get(i).getId() == id) {
				return i;
			}
		}

		return -1;
	}
	
	public List<Amigo> getListaAmigos(){
		return this.listaAmigos;
	}
}
