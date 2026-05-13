package AgendaAmigos;

public class Amigo {
	private static int idIndex = 1;
	private int id;
	private String nome;
	private String apelido;
	private String email;
	private String celular;
	
	public Amigo(String nome, String apelido, String email, String celular) {
		this.id = gerarId();
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.celular = celular;
	}
	
	public int gerarId() {
		return idIndex++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getIdIndex() {
		return idIndex;
	}

	public static void setIdIndex(int idIndex) {
		Amigo.idIndex = idIndex;
	}
}
