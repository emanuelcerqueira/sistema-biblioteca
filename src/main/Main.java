package main;

import java.text.ParseException;
import java.util.Scanner;

import controller.*;

public class Main {

	private static UsuarioController repUser = new UsuarioController();
	private static AcervoController repAcervo = new AcervoController();
	private static EmprestimoController repEmp = new EmprestimoController();
	private static AutorController repAutor = new AutorController();
	private static EditoraController repEditora = new EditoraController();
	
	public static void main(String[] args) throws ParseException {
		
		Scanner input = new Scanner(System.in);		
		
		System.out.println("================ CONFIGURANDO BIBLIOTECA ===============");
		System.out.println("Digite quantos dias o usuario pode ficar com emprestimo: ");
		int dias = input.nextInt();
		System.out.println("Digite a taxa diaria por dias excedidos da data de devolucao: ");
		double tMulta = input.nextDouble();
		System.out.println("Biblioteca configurada com sucesso.\n");
		
		
		int op1, op2, op3, op4, op5, op = 0;
		boolean x = true;
		
		do{
			if(x){				
				//menu principal
				System.out.println("=============== BIBLIOTECA ===============");
				System.out.println("Digite 1 para registrar, editar, excluir ou listar usuarios: ");
				System.out.println("Digite 2 para registrar, editar, excluir ou listar editoras.");
				System.out.println("Digite 3 para registrar, editar, excluir ou listar autores.");
				System.out.println("Digite 4 para registrar, editar, excluir ou listar livros ou outras midias: ");
				System.out.println("Digite 5 para realizar e listar emprestimos e devolucoes.");
				System.out.println("Digite 0 para sair do sistema.");
				System.out.println("===========================================");
				op = input.nextInt();
				System.out.println();	

			}

			switch (op) {

			case 0:
				break;					
				
			case 1:
	
				x = false;
				
				System.out.println("=============== BIBLIOTECA > USUARIO ===============");
				System.out.println("Digite 1 para registrar um novo usuario: ");
				System.out.println("Digite 2 para listar todos usuarios registrados: ");
				System.out.println("Digite 3 para editar um registro de usuario.");
				System.out.println("Digite 4 para apagar um usuario registrado.");
				System.out.println("Digite 0 para volta ao menu principal.");
				System.out.println("===========================================");
				op1 = input.nextInt();
				
				input.nextLine();
				
				switch (op1) {
				
				case 0:
					System.out.println("Voltando ao menu principal...\n");	
					x = true;
					break;
				
				case 1: repUser.adicinarUsuario();
					break;
					
				case 2: repUser.listarUsuarios();
					break;
					
				case 3: repUser.editarUsuario();					
					break;
		
				case 4: repUser.apagarUsuario();
					break;	
				
				default: System.out.println(op1+ " nao eh uma opcao valida.\n");
					break;
				}

				break;
			
			case 2:
				
				x = false;
	
				System.out.println("=============== BIBLIOTECA > EDITORA ===============");
				System.out.println("Digite 1 para registrar uma novo editora: ");
				System.out.println("Digite 2 para listar todas editoras registradas: ");
				System.out.println("Digite 3 para editar um registro de editora.");
				System.out.println("Digite 4 para apagar uma editora registrada.");
				System.out.println("Digite 0 para volta ao menu principal.");
				System.out.println("===========================================");
				op5 = input.nextInt();
	
				
				switch (op5) {
				
				case 0:
					x = true;
					System.out.println("Voltando ao menu principal...\n");	
					break;
				
				case 1: repEditora.adiconarEditora();
					break;
					
				case 2: repEditora.listarEditora();
					break;
				
				case 3: repEditora.editarEditora();
					break;

				case 4: repEditora.deletarEditora();
					break;

				default: System.out.println(op5+ " nao eh uma opcao valida.\n");
					break;
				}
				
				break;
				
			case 3:
				
				x = false;
				
				System.out.println("=============== BIBLIOTECA > AUTOR ===============");
				System.out.println("Digite 1 para registrar um novo autor: ");
				System.out.println("Digite 2 para listar todos autores registrados: ");
				System.out.println("Digite 3 para editar um registro de autor.");
				System.out.println("Digite 4 para apagar um autor registrado.");
				System.out.println("Digite 0 para volta ao menu principal.");
				System.out.println("===========================================");
				op4 = input.nextInt();

				
				switch (op4) {
				
				case 0:
					System.out.println("Voltando ao menu principal...\n");	
					x = true;
					break;

				
				case 1: repAutor.adicionarAutor();
					break;
				
				case 2: repAutor.listaAutor();
					break;
				
				case 3: repAutor.editarAutor();
					break;
					
				case 4: repAutor.removerAutor();
					break;

				default: System.out.println(op4+ " nao eh uma opcao valida.\n");
					break;
				}
				
				break;
				
			case 4:
				
				x = false;
				
				System.out.println("=============== BIBLIOTECA > ACERVO ===============");
				System.out.println("Digite 1 para registrar um novo livro ou midia: ");
				System.out.println("Digite 2 para listar o conteudo do acervo: ");
				System.out.println("Digite 3 para editar um item no acervo.");
				System.out.println("Digite 4 para pesquisar um livro ou midia por autor.");
				System.out.println("Digite 5 para apagar um item no acervo.");
				System.out.println("Digite 6 para adicionar um exemplar de uma mida registrada: ");
				System.out.println("Digite 0 para volta ao menu principal.");
				System.out.println("===================================================");
				
				op2 = input.nextInt();

				switch (op2) {
				case 0:
					System.out.println("Voltando ao menu principal...\n");
					x = true;
					break;
				
				case 1: repAcervo.adicionarAcervo(repAutor, repEditora);
					break;
					
				case 2: repAcervo.listarAcervo();
					break;
				
				case 3: repAcervo.editarAcervo(repAutor, repEditora);
					break;
				
				case 4: repAcervo.acharMidiaPorAutor();
					break;
					
				case 5: repAcervo.removerAcervo();
					break;
				
				case 6: repAcervo.adicionarExemplar();
					break;
					
				default: System.out.println(op2+ " nao eh uma opcao valida.\n");
					break;
				}
				break;
				
			
			case 5:
				
				x = false;
				
				System.out.println("=============== BIBLIOTECA > EMPRESTIMO ===============");
				System.out.println("Digite 1 para realizar emprestimos: ");
				System.out.println("Digite 2 para listar os emprestimos em aberto: ");
				System.out.println("Digite 3 para realizar devolucoes:");
				System.out.println("Digite 4 para listar devolucoes: ");
				System.out.println("Digite 0 para voltar para o menu principal: ");
				System.out.println("=======================================================");
				
				op3 = input.nextInt();
				
				switch (op3) {
				
				case 0:
					System.out.println("Voltando ao menu principal...\n");
					x = true;
					break;
				
				case 1: repEmp.realizarEmprestimo(repAcervo, repUser, dias, tMulta);				
					break;
				
				case 2: repEmp.listarEmprestimos();
					break;
				
				case 3: repEmp.realizarDevolucao();
					break;
				
				case 4: repEmp.listarDevolucoes();
					break;

				default: System.out.println(op3+ " nao eh uma opcao valida.\n");
					break;
				}
				
				break;
				
			default: System.out.println(op+ " nao eh uma opcao valida.\n");
				break;
			}
			
		
		}while(op != 0);
		
		System.out.println("-------------SISTEMA FINALIZADO -------------");

		input.close();
	}	

}