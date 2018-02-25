package model;

public class Autor {
	
	private String nome, sobrenome;
	private int id;


	public Autor(String nome, String sobrenome) {
		this.setNome(nome);
		this.setSobrenome(sobrenome);
	}
	
	public Autor(int id){
		this.setId(id);
	}
	

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	private void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void atualizaAutor(String nome, String sobrenome) {
		this.setNome(nome);
		this.setSobrenome(sobrenome);
	}
	
	public void imprimirDados() {
		System.out.println("Nome: "+this.getNome());
		System.out.println("Sobrenome: "+this.getSobrenome());
		System.out.println("ID: "+this.getId());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
