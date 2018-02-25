package model;

public abstract class Acervo {
	
	protected String titulo, tipo;
	protected Autor autor;
	protected long codigo;
	protected int numExemplares, numDisponivel, ano;
	
	public Acervo(String tipo, String titulo, long codigo, int numExemplares, int ano, Autor autor) {
		this.setTipo(tipo);
		this.setTitulo(titulo);
		this.setCodigo(codigo);
		this.setNumExemplares(numExemplares);
		this.setNumDisponivel(numExemplares);
		this.setAno(ano);
		this.setAutor(autor);
	}
	public Acervo() {
		
	}

	
	public String getTitulo() {
		return titulo;
	}
	public long getCodigo() {
		return codigo;
	}
	public int getNumExemplares() {
		return numExemplares;
	}
	public int getNumDisponivel() {
		return numDisponivel;
	}
	public int getAno() {
		return ano;
	}
	public Autor getAutor() {
		return autor;
	}
	public String getTipo() {
		return tipo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	protected void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	protected void setNumExemplares(int numExemplares) {
		this.numExemplares = numExemplares;
	}
	protected void setNumDisponivel(int numDisponivel) {
		this.numDisponivel = numDisponivel;
	}
	protected void setAno(int ano) {
		this.ano = ano;
	}
	protected void setAutor(Autor autor) {
		this.autor = autor;
	}
	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void adicionarExemplar() {
		this.setNumExemplares(this.getNumExemplares() + 1);
		this.setNumDisponivel(this.getNumDisponivel() + 1);
	}
	
	public void tirarDisponivel() {
		if (this.getNumDisponivel() == 0) {
			return;
		}else{
			this.setNumDisponivel(this.getNumDisponivel() - 1);	
		}
	}
	
	public void adicionarDisponivel() {
		this.setNumDisponivel(this.getNumDisponivel() + 1);
	}
	
	public abstract void imprimirDados();
	
	public abstract void exibir();
}
