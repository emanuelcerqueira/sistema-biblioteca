package model;

public class Editora {
	
	private String nome;
	private int id;
	
	public Editora(String nome, int id) {
		this.setNome(nome);
		this.setId(id);
	}
	
	public Editora() {
		
	}

	public Editora(int id) {
		this.setId(id);
	}
	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	public void imprimirDados() {
		System.out.println("Nome "+this.getNome());
		System.out.println("ID: "+this.getId());
	}
	
	public void atualizarDados(String nome) {
		this.setNome(nome);
	}
	
	
}
