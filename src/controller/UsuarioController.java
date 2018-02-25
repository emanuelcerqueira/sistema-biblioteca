package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Usuario;

public class UsuarioController{

	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	//adicona um usuario
	private boolean addUsuario(Usuario usuario) {
		
		try {
			this.listaUsuarios.add(usuario);
			return true;
		} catch (Exception e) {
			return false;	
		}
		
	}

	//deleta um usuario
	private boolean delUsuario(long matricula) {
		boolean removeu=false;
		
		for (Usuario usuario : this.listaUsuarios) {		
			if(usuario.getMatricula() == matricula){					
				this.listaUsuarios.remove(usuario);
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
	
	//lista os usuarios
	private List<Usuario> listUsuario() {
		if(this.listaUsuarios.isEmpty()){
			System.out.println("Nao ha usuarios cadastrados.\n");
		}
		else{
			System.out.println("Exite(m) "+this.listaUsuarios.size()+" registro(s) de usuario(s): ");
		}
		return this.listaUsuarios;
	}
	
	//edita um usuario
	private boolean editUsuario(Usuario usuario) {
		
		boolean editou = false;
		
		for (Usuario usuario1 : this.listaUsuarios) {
			
			if (usuario1.getMatricula() == usuario.getMatricula()) {
				
				this.listaUsuarios.set(this.listaUsuarios.indexOf(usuario1), usuario);
				editou = true;
			}
		}
		if (editou) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public void adicinarUsuario() {
		
		System.out.println("Digite a matricula do novo usuario (somente numeros): ");
		long matricula =  new Scanner(System.in).nextLong();
		
		System.out.println("Digite o nome do novo usuario: ");
		String nome =  new Scanner(System.in).nextLine();

		System.out.println("Digite a senha do novo usuario (somente numeros): ");
		int senha =  new Scanner(System.in).nextInt();

		Usuario usuario = new Usuario(nome, senha, matricula); 
		
		boolean salvo = this.addUsuario(usuario);
		
		if(salvo){
			System.out.println("Usuario salvo com sucesso.\n");
		}
		else{
			System.out.println("ERRO! O usuario nao foi salvo.\n");
		}

	}
	
	public void listarUsuarios() {


		for (Usuario usuario : this.listUsuario()) {
			System.out.println("--------------- Usuario "+(this.getListaUsuarios().indexOf(usuario)+1)+" ---------------");
			usuario.imprimirDados();
			System.out.println("-----------------------------------\n");
		}

	}
	

	
	public void editarUsuario() {
		System.out.println("Digite a matricula do usuario que deseja editar (somente numeros): ");
		long matricula =  new Scanner(System.in).nextLong();
		
		Usuario usuario = new Usuario(null, 0, matricula);
		boolean editavel = this.editUsuario(usuario);
		
		if (editavel) {
			System.out.println("Digite o nome do usuario editado: ");
			String nome =  new Scanner(System.in).nextLine();

			System.out.println("Digite a senha do usuario editado (somente numeros): ");
			int senha =  new Scanner(System.in).nextInt();
			
			usuario.atualizarDados(nome, senha);
			
			this.editUsuario(usuario);
			System.out.println("Usuario editado com sucesso.\n");
			
		}
		else{
			System.out.println("A matricula digita nao se encontra nos registros.\n");
		}

	}
	
	public void apagarUsuario(){
		
		if (listaUsuarios.size() == 1) {
			System.out.println("Existe somente um usuario registrado. Deseja remover 'S' para sim 'N' para nao");
			char op =  new Scanner(System.in).next().charAt(0);
		
			switch (op) {
			case 's': case 'S':
				listaUsuarios.clear();
				System.out.println("Usuario deletado com sucesso.\n");
				break;
			case 'n': case 'N':
				System.out.println("Cancelando exclusao.\n");
				break;

			default: System.out.println("Opcao invalida");
				break;
			}
			
			
		}else{
			System.out.println("Digite o numero da matricula do usuario que deseja deletar: ");
			long matricula =  new Scanner(System.in).nextLong();
			
			boolean deletado = this.delUsuario(matricula);
			
			if (deletado){
				System.out.println("Usuario deletado com sucesso.\n");
			}
			else{
				System.out.println("ERRO! A matricula digitada nao existe nos registros.\n");
			}

		}
	}
	
}