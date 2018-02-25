package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Autor;

public class AutorController {
	
	private List<Autor> listaAutor = new ArrayList<Autor>();
	int id = 0;
	
	public List<Autor> getListaAutor() {
		return listaAutor;
	}
	
	// adicona um autor a lista
	private boolean addAutor(Autor autor){
		try {
			listaAutor.add(autor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean delAutor(long id) {
		
		boolean removido = false;
		
		for (Autor autor : listaAutor) {
			if (autor.getId() == id) {
				listaAutor.remove(autor);
				removido = true;
				break;
			}
		}
		if (removido) {
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean editAutor(Autor autor1) {
		
		boolean editado = false;
		
		for (Autor autor : listaAutor) {
			if(autor1.getId() == autor.getId()){
				listaAutor.set(listaAutor.indexOf(autor), autor1);
				editado = true;
				break;
			}
		}
		
		if (editado) {
			return true;
		}
		else{
			return false;
		}
				
	}
	
	
	private List<Autor> listAutores() {	
		if (listaAutor.isEmpty()) {
			System.out.println("Nao ha autores registrados.\n");
		}else{
			System.out.println("Exite(m) "+this.listaAutor.size()+" registro(s) de autor(es): ");	
		}
		return listaAutor;	
	}

		
	public void adicionarAutor() {
	
		id++;
		
		System.out.println("Digite o primeiro nome do novo autor: ");
		String nome =  new Scanner(System.in).nextLine();
		
		System.out.println("Digite o sobrenome do novo autor: ");
		String sobrenome =  new Scanner(System.in).nextLine();
		
		Autor autor = new Autor(nome, sobrenome);
		autor.setId(id);
		
		System.out.println();
		this.addAutor(autor);
		System.out.println("ID do autor "+nome.toUpperCase()+" "+sobrenome.toUpperCase() +": "+id);
		System.out.println("Autor salvo com sucesso.\n");
	
	}
	
	public void removerAutor() {
	
		if (listaAutor.size() == 1) {
			System.out.println("Existe somente um autor registrado. Deseja remover 'S' para sim 'N' para nao");
			char op =  new Scanner(System.in).next().charAt(0);
		
			switch (op) {
			case 's': case 'S':
				listaAutor.clear();
				System.out.println("Autor deletado com sucesso.\n");
				break;
			case 'n': case 'N':
				System.out.println("Cancelando exclusao.\n");
				break;

			default: System.out.println("Opcao invalida.\n");
				break;
			}
			
			
		}else{
			System.out.println("Digite o ID do autor que deseja remover: ");
			int id =  new Scanner(System.in).nextInt();
			
			boolean removido = this.delAutor(id);

			if (removido) {
				System.out.println("Autor removido com sucesso.\n");
			}
			else{
				System.out.println("O ID digitado nao se encontra nos registros.");
			}
		}			
	}
	
	public void listaAutor() {
		for (Autor autor : this.listAutores()) {
			System.out.println("==================== Autor "+(listaAutor.indexOf(autor)+1)+"====================");
			autor.imprimirDados();
			System.out.println("============================================\n");
		}
	}

	public void editarAutor() {
		System.out.println("Digite o ID do autor que deseja editar: ");
		int id =  new Scanner(System.in).nextInt();
		
		Autor autor = new Autor(id);
		boolean editavel = this.editAutor(autor);
		
		if (editavel) {
			
			System.out.println("Digite o primeiro nome editado:");
			String nome =  new Scanner(System.in).next();
			
			System.out.println("Digite o sobrenome editado:");
			String sobrenome =  new Scanner(System.in).next();
			
			autor.atualizaAutor(nome, sobrenome);
			this.editAutor(autor);
			System.out.println("Usuario editado com sucesso.\n");
		}
		else{
			System.out.println("O ID digitado nao se encontra nos registros.\n");
		}
	}
}
