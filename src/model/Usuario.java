package model;

public class Usuario {
	
	private String nome;
	private int senha;
	private long matricula;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, int senha, long matricula) {
		this.setNome(nome);
		this.setSenha(senha);
		this.setMatricula(matricula);
	}

	public String getNome() {
		return nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	public long getMatricula() {
		return matricula;
	}
	private void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public int getSenha() {
		return senha;
	}
	private void setSenha(int senha) {
		this.senha = senha;
	}
	
	public void imprimirDados() {
		System.out.println("Matricula: "+this.getMatricula());
		System.out.println("Nome: "+this.getNome());
		System.out.println("Senha: "+this.getSenha());
	}

	public void atualizarDados(String nome, int senha) {
		this.setNome(nome);
		this.setSenha(senha);
		
	}
}