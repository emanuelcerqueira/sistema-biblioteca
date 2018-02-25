package model;

public class OutrasMidias extends Acervo {
	
	private long id;
	private String descricao;
	
	public OutrasMidias(String titulo, int numExemplares, int ano,
			Autor autor, long id, String tipo, String descricao) {
		super(tipo, titulo, id, numExemplares, ano, autor);
		this.setId(id);
		this.setDescricao(descricao);

	}
	
	public OutrasMidias() {
		
	}

	public long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	private void setId(long id) {
		this.id = id;
	}

	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void atualizarDados(String titulo, int ano,
			Autor autor, String tipo, String descricao) {
		this.setTitulo(titulo);
		this.setAno(ano);
		this.setAutor(autor);
		this.setTipo(tipo);
		this.setDescricao(descricao);

	}
	
	@Override
	public void imprimirDados() {
		System.out.println("Titulo: "+this.getTitulo());
		System.out.println("Autor: "+this.getAutor().getNome()+" "+this.getAutor().getSobrenome());
		System.out.println("id: "+this.getId());
		System.out.println("Tipo: "+this.getTipo());
		System.out.println("Descricao: "+this.getDescricao());
		System.out.println("Ano: "+this.getAno());
		System.out.println("Numero de exemplares: "+this.getNumExemplares());
		System.out.println("Exemplares disponiveis: "+this.getNumDisponivel());

	}
	
	public void exibir() {
		System.out.println(this.getTipo()+": "+this.getAutor().getSobrenome().toUpperCase()+", "
				+this.getAutor().getNome()+ ". "+this.getTitulo());
	}
	
	
}
