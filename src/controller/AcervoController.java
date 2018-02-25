package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Acervo;
import model.Autor;
import model.Editora;
import model.Livro;
import model.OutrasMidias;

public class AcervoController {
	
	
	private List <Acervo> listaAcervo = new ArrayList<Acervo>();
	
	public List<Acervo> getListaAcervo() {
		return listaAcervo;
	}

	//adicona uma midia ao acervo
	private boolean addAcervo(Acervo acervo) {
		try {
			this.listaAcervo.add(acervo);
			return true;
		} catch (Exception e) {
			return false;
		}		
		
	}
	
	//deleta uma midia ao acervo
	private boolean delAcervo(long codigo) {
		
		boolean removeu=false;
		
		for (Acervo acervo : this.listaAcervo) {
				
			if(acervo.getCodigo() == codigo){
					
				this.listaAcervo.remove(acervo);
				removeu = true;
				break;
			}
		}	

		
		if(removeu){
			return true;
		}else{
			return false;	
		}
		
	}
	
	//lista as midias cadastradas no acervo
	private List<Acervo> Listacervo() {
		if (this.listaAcervo.isEmpty()) {
			System.out.println("Nao ha midas cadastradas no acervo.");
		}
		else{
			System.out.println("Existem "+this.listaAcervo.size()+" midias cadastradas no acervo.");
		}
		return this.listaAcervo;
	}
	
	//edita uma midia no acervo
	private boolean editAcervo(Acervo acervo) {

		boolean editou = false;

		for (Acervo acervo1 : this.getListaAcervo()) {
			if (acervo1.getCodigo() == acervo.getCodigo()) {
				
				this.listaAcervo.set(listaAcervo.indexOf(acervo1), acervo);				
				editou = true;
				break;
			}
		}
		if (editou) {
			return true;
		}
		else{
			return false;
		}
	}
	
	//Procura uma midia pelo o autor.
	private boolean findbyAutor(int id) {
		
		boolean encontrado = false;
		
		for (Acervo acervo : listaAcervo) {
			if (acervo.getAutor().getId() == id) {
				String autor = acervo.getAutor().getNome()+" "+acervo.getAutor().getSobrenome();
				System.out.println("Livros/midias do autor "+autor+":");
				break;
			}
		}
		
		for (Acervo acervo : listaAcervo) {
			if (acervo.getAutor().getId() == id) {
				System.out.println("=======================================");
				acervo.imprimirDados();
				System.out.println("=======================================\n");
				encontrado = true;
			}
		}
		if (encontrado) {
			return true;
		}
		else{
			System.out.println("Nao foi encontrado nenhum livro/midia do autor.\n");
			return false;		
		}
	}
	
	//adiciona um exemplar a uma midia
	private boolean addExemplar(long id) {
		
		boolean adicionado = false;
		
		for (Acervo acervo : listaAcervo) {
			if (acervo.getCodigo() == id) {
				acervo.adicionarExemplar();
				adicionado = true;
				break;
			}
		}
		
		if (adicionado) {
			return true;
		}
		else{
			return false;
		}
	}

	public  void adicionarAcervo(AutorController repAutor, EditoraController repEditora) {
		int op; 
		
		System.out.println("=============== BIBLIOTECA > ACERVO > REGISTRAR ===============");
		System.out.println("Digite 1 para registrar um livro");
		System.out.println("Digite 2 para registrar uma outra midia.");
		System.out.println("Digite 0 para voltar ao menu Acervo.");
		System.out.println("===============================================================");
		op =  new Scanner(System.in).nextInt();
		
		switch (op) {
		
		case 0:
			System.out.println("Voltando para o menu acervo...\n");
			break;
		
		case 1:
			
			System.out.println("Digite o ISBN-13 do novo livro(somente numeros): ");
			long isbn =  new Scanner(System.in).nextLong();
			
			System.out.println("Digite o titulo do novo livro: ");
			String titulo =  new Scanner(System.in).nextLine();
			
			System.out.println("Digite o ID do autor do novo livro.");
			int idAutor =  new Scanner(System.in).nextInt();
			
			boolean encontrado = false;
			
			Autor autorEncontrado = null;
			
			for (Autor autor : repAutor.getListaAutor()) {
				if (autor.getId() == idAutor) {
					autorEncontrado = autor;
					encontrado = true;
					break;
				}
			}
			
			if (!encontrado) {
				System.out.println("O autor nao foi encontrado.\n");
				break;
			}
			
			System.out.println("Digite o ID da editora: ");
			int idEditora =  new Scanner(System.in).nextInt();
			
			encontrado = false;
			Editora editoraEncontrada = null;
			
			for (Editora editora : repEditora.getListaEditora()) {
				if (editora.getId() == idEditora) {
					editoraEncontrada = editora;
					encontrado = true;
					break;
				}
			}
			
			if (!encontrado) {
				System.out.println("A editora nao foi encontrado.\n");
				break;
			}

			
			System.out.println("Digite o numero da edicao do novo livro: ");
			int edicao =  new Scanner(System.in).nextInt();
			
			System.out.println("Digite o volume do livro: ");
			int volume =  new Scanner(System.in).nextInt();
			
			System.out.println("Digite a area do novo livro: ");
			String area =  new Scanner(System.in).nextLine();
			
			System.out.println("Digite o ano do novo livro: ");
			int ano =  new Scanner(System.in).nextInt();
			
			System.out.println("Digite o numero de paginas do novo livro: ");
			int numPag =  new Scanner(System.in).nextInt();

			System.out.println("Digite o numero de exemplares do livro: ");
			int numExemplares =  new Scanner(System.in).nextInt();
			
			if (numExemplares <= 0) {
				System.out.println("Numero de exempalres invalido.");
				return;
			}
			
			Livro livro = new Livro(titulo, numExemplares, ano, autorEncontrado, area, editoraEncontrada, isbn, edicao, volume, numPag);
			this.addAcervo(livro);
			System.out.println("Livro salvo com sucesso!\n");
			break;

		case 2:

			System.out.println("Digite o codigo de 6 numeros de identificacao da midia: ");
			long id =  new Scanner(System.in).nextLong();
			
			 new Scanner(System.in).nextLine();
			
			System.out.println("Digite o tipo de midia: ");
			String tipo =  new Scanner(System.in).nextLine();
			
			System.out.println("Digite o titulo da nova midia: ");
			String titulo1 =  new Scanner(System.in).nextLine();
			
			System.out.println("Digite o ID do autor do novo livro.");
			int idAutor1 =  new Scanner(System.in).nextInt();
			
			boolean encontrado1 = false;
			
			Autor autorEncontrado1 = null;
			
			for (Autor autor1 : repAutor.getListaAutor()) {
				if (autor1.getId() == idAutor1) {
					autorEncontrado1 = autor1;
					encontrado1 = true;
					break;
				}
			}
			
			if (!encontrado1) {
				System.out.println("O autor nao foi encontrado.\n");
				break;
			}

			
			System.out.println("Digite o ano da nova midia: ");
			int ano1 =  new Scanner(System.in).nextInt();

			System.out.println("Digite uma descricao para a midia");
			String descricao =  new Scanner(System.in).nextLine();
			
			System.out.println("Digite o numero de exemplares da midia: ");
			int numExemplares1 =  new Scanner(System.in).nextInt();
			
			OutrasMidias midia = new OutrasMidias(titulo1, numExemplares1, ano1, autorEncontrado1, id, tipo, descricao);
			this.addAcervo(midia);
			System.out.println("Midia adicionada com sucesso.\n");
			break;
		
		default:
			System.out.println(op+" nao eh uma opcao valida.");
			break;
		}
	}
	
	public  void listarAcervo() {
		List <Acervo> listaAcervo = new ArrayList<Acervo>();
		listaAcervo = this.Listacervo();
		
		for (Acervo acervo : listaAcervo) {
			System.out.println("--------------- Item "+(listaAcervo.indexOf(acervo)+1)+" ---------------");
			acervo.imprimirDados();
			System.out.println("-----------------------------------\n");
		}
	}
	
	public  void editarAcervo(AutorController repAutor, EditoraController repEditora) {
		
		System.out.println("Digite o isbn/id do livro/midia que deseja editar: ");
		long codigo =  new Scanner(System.in).nextLong();
		String tipo = null;
		boolean editavel = false;
		
		for (Acervo acervo : this.getListaAcervo()) {
			if (acervo.getCodigo() == codigo) {
				tipo = acervo.getTipo();
				editavel = true;
			}
		}
		
		if (editavel) {
			
			if (tipo.equals("livro")) {
				System.out.println("Digite o titulo  livro: ");
				String titulo =  new Scanner(System.in).nextLine();
								
				System.out.println("Digite o ID do autor do novo livro.");
				int idAutor =  new Scanner(System.in).nextInt();
				
				boolean encontrado = false;
				
				Autor autorEncontrado = null;
				
				for (Autor autor : repAutor.getListaAutor()) {
					if (autor.getId() == idAutor) {
						autorEncontrado = autor;
						encontrado = true;
						break;
					}
				}
				
				if (!encontrado) {
					System.out.println("O autor nao foi encontrado.\n");
					return;
				}
				
				
				
				System.out.println("Digite o ID da editora: ");
				int idEditora =  new Scanner(System.in).nextInt();
		
				encontrado = false;
				Editora editoraEncontrada = null;
				
				for (Editora editora : repEditora.getListaEditora()) {
					if (editora.getId() == idEditora) {
						editoraEncontrada = editora;
						encontrado = true;
						break;
					}
				}
				
				if (!encontrado) {
					System.out.println("A editora nao foi encontrado.\n");
					return;
				}
				
				System.out.println("Digite o numero da edicao do livro: ");
				int edicao =  new Scanner(System.in).nextInt();
				
				System.out.println("Digite o volume dolivro: ");
				int volume =  new Scanner(System.in).nextInt();
				
				System.out.println("Digite a area do livro: ");
				String area =  new Scanner(System.in).nextLine();
				
				System.out.println("Digite o ano do livro: ");
				int ano =  new Scanner(System.in).nextInt();
				
				System.out.println("Digite o numero de paginas do livro: ");
				int numPag =  new Scanner(System.in).nextInt();

				
				Livro livro = new Livro(codigo);
				livro.atualizarDados(titulo, ano, autorEncontrado, area, editoraEncontrada,edicao, volume, numPag);
				
				this.editAcervo(livro);
				System.out.println("Livro editado com sucesso.\n");

			}
			else{
				
				System.out.println("Digite o tipo de midia: ");
				String tipo2 =  new Scanner(System.in).nextLine();
				
				System.out.println("Digite o titulo da midia: ");
				String titulo1 =  new Scanner(System.in).nextLine();
				
				System.out.println("Digite o ID do autor do novo livro.");
				int idAutor =  new Scanner(System.in).nextInt();
				
				boolean encontrado = false;
				
				Autor autorEncontrado = null;
				
				for (Autor autor : repAutor.getListaAutor()) {
					if (autor.getId() == idAutor) {
						autorEncontrado = autor;
						encontrado = true;
						break;
					}
				}
				
				if (!encontrado) {
					System.out.println("O autor nao foi encontrado.\n");
					return;
				}
				
				System.out.println("Digite o ano da nova midia: ");
				int ano1 =  new Scanner(System.in).nextInt();

				System.out.println("Digite uma descricao para a midia");
				String descricao =  new Scanner(System.in).nextLine();
								
				OutrasMidias midia = new OutrasMidias();
				midia.atualizarDados(titulo1, ano1, autorEncontrado, tipo2, descricao);
				this.editAcervo(midia);
				System.out.println("Midia editada com sucesso.\n");

			}

		}
		else{
			System.out.println("O isbn/id digitado eh invalido.\n");
		}		
	}
	
	public void acharMidiaPorAutor() {
		
		System.out.println("Digite o ID do autor do(s) livro(s) que você deseja achar: ");
		int id = new Scanner(System.in).nextInt();
		
		this.findbyAutor(id);
	}
	
	public void removerAcervo() {
	
		if (listaAcervo.size() == 1) {
			System.out.println("Existem somente 1 item registrado no acervo. Deseja apagar 'S' para sim 'N' para nao.");
			char op =  new Scanner(System.in).next().charAt(0);
			
			switch (op) {
			case 's': case 'S':
				System.out.println("Removido com sucesso.\n");
				listaAcervo.clear();
				break;

			case 'n': case 'N':
				System.out.println("Exclusao cancelada.\n");
				break;
				
			default:
				break;
			}
		}
		
		System.out.println("Digite o isbn/id do livro/midia que deseja excluir: ");
		long codigo =  new Scanner(System.in).nextLong();
		
	
		boolean removido = this.delAcervo(codigo); 
		if (removido) {
			System.out.println("Removido com sucesso.\n");
		}
		else{
			System.out.println("O isbn/id do livro/midia nao se encontra nos registros.\n");
		}
	}
	
	public void adicionarExemplar() {
		System.out.println("Digite o isbn/codigo do livro/midia que deseja adicionar um exemplar: ");
		long id = new Scanner(System.in).nextLong();
		boolean adicionado = this.addExemplar(id);
		
		if (adicionado) {
			System.out.println("Exemplar adicionado com sucesso.\n");
		}
		else{
			System.out.println("O isbn/id do livro/midia nao se encontra nos registros.\n");
		}
	}

}
