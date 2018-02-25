package controller;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import model.*;

public class EmprestimoController {

	private List<Emprestimo> listaEmprestimos = new ArrayList<Emprestimo>();
	private List<Emprestimo> listaDevolucoes = new ArrayList<Emprestimo>();
	
	int codEmprestimo = 0;
	
	public List<Emprestimo> getListaEmprestimos() {
		return listaEmprestimos;
	}

	public List<Emprestimo> getListaDevolucoes() {
		return listaDevolucoes;
	}

	//realiza um empresitmo
	private boolean emprestar(Emprestimo emprestimo) {
		
		 try {
			 this.listaEmprestimos.add(emprestimo);
			 return true;
		} catch (Exception e) {
			return false;
		}
		 
	 }
	//realiza uma devolucao
	private boolean devolver(Emprestimo emprestimo) {
		try {
			this.listaDevolucoes.add(emprestimo);
			this.listaEmprestimos.remove(emprestimo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//lista os emprestimos em aberto
	private List<Emprestimo> listEmprestimos() {
		
		if (listaEmprestimos.isEmpty()) {
			System.out.println("Nao ha emprestimos em aberto registrados.\n");
		}
		
		return listaEmprestimos;
	}
	
	//lista todas as devolucoes realizadas
	private List<Emprestimo> listDevolucoes() {
		if (listaDevolucoes.isEmpty()) {
			System.out.println("Nao ha devolucoes registradas.");
		}
		return listaDevolucoes;
	}
	
	public void realizarEmprestimo(AcervoController repAcervo, UsuarioController repUser, int dias, double tDias) {
		
		Usuario user = null;
		Acervo acer = null;
		boolean userEncontrado = false;
		boolean acervoEncontrado = false;
		
		
		System.out.println("Digite a matricula do usuario que deseja realizar emprestimo: ");
		long matricula =  new Scanner(System.in).nextLong();

		System.out.println("Digite a senha do usuario que deseja realizar emprestimo: ");
		int senha =  new Scanner(System.in).nextInt();

	
		for (Usuario usuario : repUser.getListaUsuarios()) {
			if ((usuario.getMatricula() == matricula) && (usuario.getSenha() == senha)) {
				userEncontrado = true;
				user = usuario;
			}
		}

		if (userEncontrado) {
			System.out.println("Usuario encontrado.");
		}
		else{
			System.out.println("Usuario ou senha invalido.");
			return;
		}
		
		System.out.println("Digite o isbn/id do livro/midia que deseja realizar emprestimo.");
		long cod =  new Scanner(System.in).nextLong();
		
		for (Acervo acervo : repAcervo.getListaAcervo()) {
			if (acervo.getCodigo() ==  cod) {
				acervoEncontrado = true;
				acer = acervo;
			}
		}
		
		if (acervoEncontrado) {
			System.out.println("Midia encontrada.");
			
			if (acer.getNumDisponivel() == 0) {
				System.out.println("Nao ha exemplares disponiveis da midia encontrada.\n");
				return;
			}
			else{
				for (Acervo acervo : repAcervo.getListaAcervo()) {
					if (acervo.getCodigo() ==  cod) {
						acervo.tirarDisponivel();
					}
				}
			}
		}
		else{
			System.out.println("Midia invalida!\n");
			return;
		}
		
		if (acervoEncontrado && userEncontrado) {
			
			codEmprestimo++;
			Emprestimo emprestimo = new Emprestimo(user, acer, dias, tDias);
			emprestimo.setCodEmprestimo(codEmprestimo);
			this.emprestar(emprestimo);
			this.exibirEmprestimo();
		}
	}
	
	public void listarEmprestimos() {
		
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Emprestimo emprestimo : this.listEmprestimos()) {
			System.out.println("============= Emprestimo "+(listaEmprestimos.indexOf(emprestimo)+1)+"=============");
			emprestimo.getDataEmprestimo();
			System.out.println("Data do emprestimo: "+dataFormatada.format(emprestimo.getDataEmprestimo().getTime()));
			System.out.println("Usuario: "+emprestimo.getUsuario().getNome());
			emprestimo.getAcervo().exibir();
			System.out.println("Codigo do emprestimo: "+emprestimo.getCodEmprestimo());
			System.out.println("======================================\n");
		}
		
	}
	
	public void realizarDevolucao() throws ParseException {
		
		boolean devolvido = false;
		
		System.out.println("Digite o codigo do emprestimo que deseja devolver.");
		int codigo =  new Scanner(System.in).nextInt();
		
		for (Emprestimo emprestimo : listaEmprestimos) {
			if (emprestimo.getCodEmprestimo() == codigo) {
				emprestimo.setDataDevolucao(Calendar.getInstance());
				double tMulta = emprestimo.getTaxaDias();
				System.out.println(tMulta);
				this.devolver(emprestimo);
				devolvido = true;
				if (devolvido) {
					emprestimo.getAcervo().adicionarDisponivel();
				}
				break;
			}
		}
		
		if (devolvido) {	
			exibirDevolucao(codigo);			
		}else{
			System.out.println("O codigo do emprestimo digitado nao se encontra nos registros.");
		}
	}
	
	public void listarDevolucoes() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Emprestimo emprestimo : this.listDevolucoes()) {
			System.out.println("============= Devolucao "+(listaDevolucoes.indexOf(emprestimo)+1)+" =============");
			emprestimo.getDataEmprestimo();
			System.out.println("Data do emprestimo: "+dataFormatada.format(emprestimo.getDataEmprestimo().getTime()));
			System.out.println("Data de devolucao: "+dataFormatada.format(emprestimo.getDataDevolucao().getTime()));
			System.out.println("Usuario: "+emprestimo.getUsuario().getNome());
			emprestimo.getAcervo().exibir();
			System.out.println("Multa paga: R$"+emprestimo.getMulta());
			System.out.println("Codigo do emprestimo: "+emprestimo.getCodEmprestimo());
			System.out.println("======================================\n");

		}
	}
	  
	public void exibirEmprestimo(){
		
		
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Emprestimo emprestimo : listaEmprestimos) {
			System.out.println("============= Emprestimo "+(listaEmprestimos.indexOf(emprestimo)+1)+"=============");
			emprestimo.getDataEmprestimo();
			System.out.println("Data do emprestimo: "+dataFormatada.format(emprestimo.getDataEmprestimo().getTime()));
			System.out.println("Usuario: "+emprestimo.getUsuario().getNome());
			emprestimo.getAcervo().exibir();
			System.out.println("Codigo do emprestimo: "+emprestimo.getCodEmprestimo());
			System.out.println("O material devera ser devolvido no dia "+dataFormatada.format(emprestimo.getPrevDevolucao()));
			System.out.println("Emprestimo realizado com sucesso.");
			System.out.println("======================================\n");
		
		
	}
	
	}
	
	public void exibirDevolucao(int codigo) throws ParseException{
			
			SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Emprestimo emprestimo : listaDevolucoes) {
			
			if(emprestimo.getCodEmprestimo() == codigo){
				
			System.out.println("============= Devolucao "+(listaEmprestimos.indexOf(emprestimo)+1)+"=============");
			emprestimo.getDataEmprestimo();
			System.out.println("Data da devolucao "+dataFormatada.format(emprestimo.getDataDevolucao().getTime()));
			System.out.println("Usuario: "+emprestimo.getUsuario().getNome());
			emprestimo.getAcervo().exibir();
			System.out.println("Codigo do emprestimo: "+emprestimo.getCodEmprestimo());			
			double tMulta = emprestimo.getTaxaDias();	
			calcularMulta(codigo,tMulta);			
			System.out.println("Devolucao realizada com sucesso.");
			System.out.println("======================================\n");
	
			}
	}
		
	}

 		public void calcularMulta(int codigo, double tMulta) throws ParseException {
		
 			
 		for(Emprestimo emprestimo : listaDevolucoes){	
 		if(emprestimo.getCodEmprestimo() == codigo){	
 			
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		
		String dataDevolucao = df.format(emprestimo.getDataDevolucao().getTime());
		String dataPrevDev = df.format(emprestimo.getPrevDevolucao().getTime());
		
		java.util.Date d1 = df.parse(dataDevolucao);
		java.util.Date d2 = df.parse(dataPrevDev);
		
		long dt = (d1.getTime() - d2.getTime()) + 3600000;
		long totalDias = (dt/86400000L);
	
		if(totalDias >= 1 ){
			System.out.println("Dias excedidos: "+totalDias);	
			
			double multa = totalDias*tMulta;
			emprestimo.setMulta(multa);
			
			System.out.println("Valor da Multa R$ "+emprestimo.getMulta());
			
			
		}
 			}
 				}

 					}
}