package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Editora;

public class EditoraController {
	
	private List<Editora> listaEditora = new ArrayList<Editora>(); 

	int id = 0;
	
	public List<Editora> getListaEditora() {
		return listaEditora;
	}

	private boolean addEditora(Editora editora) {
		try {
			listaEditora.add(editora);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean delEditora(long id) {
		
		boolean removido = false;
		
		for (Editora editora : listaEditora) {
			if (editora.getId() == id) {
				listaEditora.remove(editora);
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
	
	private List<Editora> ListEditora() {
		if (listaEditora.isEmpty()) {
			System.out.println("Nao ha editoras registradas.\n");
		}
		else{
			System.out.println("Exite(m) "+this.listaEditora.size()+" registro(s) de editora(s): ");
		}
		return listaEditora;
	}
	
	private boolean editAutor(Editora editora1) {
		
		boolean editado = false;
		
		for (Editora editora : listaEditora) {
			if(editora1.getId() == editora.getId()){
				listaEditora.set(listaEditora.indexOf(editora), editora1);
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

	public void adiconarEditora() {
		
		id++;
		
		System.out.println("Digite o nome da editora: ");
		String nome =  new Scanner(System.in).nextLine();
		
		Editora editora =  new Editora(nome, id);
		
		this.addEditora(editora);
		System.out.println("O ID da editora "+nome+" : "+id);
		System.out.println("Editora adicionada com sucesso.\n");
	}
	
	public void deletarEditora() {
		
		if (listaEditora.size() == 0) {
			System.out.println("Existe somente um autor registrado. Deseja remover 'S' para sim 'N' para nao");
			char op =  new Scanner(System.in).next().charAt(0);
			
			switch (op) {
			case 's': case 'S':
				listaEditora.clear();
				System.out.println("Editora apagada com sucesso.\n");
				break;
			case 'n': case 'N':
				System.out.println("Exclusao cancelada.\n");
				break;
			default: System.out.println("Opcao invalida.");
				break;
			}
		}else{
			System.out.println("Digite o ID da editora que deseja apagar: ");
			int id =  new Scanner(System.in).nextInt();
			
			boolean apagado = this.delEditora(id);
			
			if (apagado) {
				System.out.println("Editora apagado com sucesso.\n");
			}
			else{
				System.out.println("O ID digitado nao se encontra nos registros.\n");
			}
		}	
	}

	public void listarEditora() {
		for (Editora editora : ListEditora()) {
			System.out.println("=========== Editora "+(listaEditora.indexOf(editora)+1)+"===========");
			editora.imprimirDados();
			System.out.println("========================================\n");
		}
	}
	
	public void editarEditora() {
		System.out.println("Digite o ID da editora que deseja editar: ");
		int id =  new Scanner(System.in).nextInt();
		
		Editora editora = new Editora(id);
		
		
		boolean editavel = this.editAutor(editora);
		
		if (editavel) {
			System.out.println("Digite o nome editado da editora ");
			String nome =  new Scanner(System.in).next();
		
			editora.atualizarDados(nome);
			System.out.println("Editora editada com sucesso.");
		}
		else{
			System.out.println("O ID digitado nao se encontra nos registros.\n");
		}
	}
}

