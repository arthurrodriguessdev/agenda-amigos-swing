package AgendaAmigos;

import java.io.*;
import java.util.*;

public class PersistenciaContato {
	public PersistenciaContato() {
		
	}
	
	public void salvarArquivo(List<Amigo>listaAmigos){
		try {
			File arquivo = new File("listaAmigos.csv");
			FileWriter escritor = new FileWriter(arquivo);
			
			for(int i = 0; i < listaAmigos.size(); i++) {
				String linha = String.format("%s;%s;%s;%s;%s\n", 
						listaAmigos.get(i).getId(),
						listaAmigos.get(i).getNome(),
						listaAmigos.get(i).getApelido(),
						listaAmigos.get(i).getEmail(),
						listaAmigos.get(i).getCelular()
				);
				
				escritor.write(linha);
				System.out.println(arquivo.getAbsolutePath());
			}
			
			escritor.close();
	
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Amigo> importarDadosArquivo(List<Amigo>listaAmigos) {
		try {
			File arquivo = new File("listaAmigos.csv");
			Scanner leitor = new Scanner(arquivo);
			
			while(leitor.hasNextLine()) {
				String linhaLida = leitor.nextLine();
				String[] dadosSeparados = linhaLida.split(";");
				
				listaAmigos.add(new Amigo(
						dadosSeparados[1],
						dadosSeparados[2],
						dadosSeparados[3],
						dadosSeparados[4]
						
				));
			}
			
			leitor.close();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return listaAmigos;
	}
}
