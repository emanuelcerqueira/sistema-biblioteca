package model;

public class Livro extends Acervo {
	
	private String area;
	private long isbn;
	private int edicao, volume, numPag;
	private Editora editora;
	
	
	public Livro(String titulo, int numExemplares, int ano,
			Autor autor, String area, Editora editora, long isbn, int edicao,
			int volume, int numPag) {
		super("livro", titulo, isbn, numExemplares, ano, autor);
		this.setArea(area);
		this.setEditora(editora);
		this.setIsbn(isbn);
		this.setEdicao(edicao);
		this.setVolume(volume);
		this.setNumPag(numPag);
	}
	public Livro(long isbn) {
		this.setIsbn(isbn);
		this.setCodigo(isbn);
	}
	public Livro() {
		
	}

	public String getArea() {
		return area;
	}
	
	public long getIsbn() {
		return isbn;
	}
	public int getEdicao() {
		return edicao;
	}
	public int getVolume() {
		return volume;
	}
	public int getNumPag() {
		return numPag;
	}

	private void setArea(String area) {
		this.area = area;
	}
	private void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	private void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	private void setVolume(int volume) {
		this.volume = volume;
	}
	private void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	
	public Editora getEditora() {
		return editora;
	}
	private void setEditora(Editora editora) {
		this.editora = editora;
	}
	public void atualizarDados(String titulo, int ano,
			Autor autor, String area, Editora editora, int edicao,
			int volume, int numPag) {
		this.setTitulo(titulo);
		this.setAno(ano);
		this.setAutor(autor);
		this.setArea(area);
		this.setEditora(editora);
		this.setEdicao(edicao);
		this.setVolume(volume);
		this.setNumPag(numPag);
	}
	
	@Override
	public void imprimirDados() {
		System.out.println("Titulo: "+this.getTitulo());
		System.out.println("Autor: "+this.getAutor().getNome()+" "+this.getAutor().getSobrenome());
		System.out.println("Tipo: "+this.getTipo());
		System.out.println("ISBN: "+this.getIsbn());
		System.out.println("Editora: "+this.getEditora().getNome());
		System.out.println("Ano: "+this.getAno());
		System.out.println("Numero da edicao: "+this.getEdicao());
		System.out.println("Volume: "+this.getVolume());
		System.out.println("Area/genero: "+this.getArea());
		System.out.println("Numero de paginas: "+this.getNumPag());
		System.out.println("Numero de exemplares: "+this.getNumExemplares());
		System.out.println("Exemplares disponiveis: "+this.getNumDisponivel());

	}
	
	@Override
	public void exibir(){
		System.out.println("Livro: "+this.getAutor().getSobrenome().toUpperCase()+", "
				+this.getAutor().getNome()+ ". "+this.getTitulo()+": "+this.getEditora().getNome()
				+ ", "+this.getEdicao()+ "ed. "+this.getNumPag()+"p.");
	}
}
