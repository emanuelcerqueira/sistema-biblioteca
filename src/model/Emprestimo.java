package model;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Emprestimo {
	
	private Usuario usuario;
	private Acervo acervo;
	private Date dataEmprestimo;
	private Calendar dataDevolucao = null;
	private Date PrevDevolucao ;
	private int codEmprestimo, maxDias;
	private double multa, taxaDias;
	
	
	public Emprestimo(Usuario usuario, Acervo acervo, int maxDias, double tDias) {
		dataEmprestimo = new Date(); //Coloca a data atual do sistema como data do emprestimo
		Calendar a = Calendar.getInstance();					
		a.add(Calendar.DATE, maxDias);
		PrevDevolucao = a.getTime();		
		codEmprestimo = 0;
		this.setTaxaDias(tDias);
		this.setUsuario(usuario); // Usuario que realizou emprestimo
		this.setAcervo(acervo);   // midia a ser emprestada
	}
	
	public Emprestimo() {
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	private void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Acervo getAcervo() {
		return acervo;
	}

	private void setAcervo(Acervo acervo) {
		this.acervo = acervo;
	}
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public int getCodEmprestimo() {
		return codEmprestimo;
	}

	public void setCodEmprestimo(int codEmprestimo) {
		this.codEmprestimo = codEmprestimo;
	}

	public Date getPrevDevolucao() {
		return PrevDevolucao;
	}

	public void setPrevDevolucao(Date prevDevolucao) {
		PrevDevolucao = prevDevolucao;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	private void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public int getMaxDias() {
		return maxDias;
	}

	public double getTaxaDias() {
		return taxaDias;
	}

	private void setMaxDias(int maxDias) {
		this.maxDias = maxDias;
	}

	private void setTaxaDias(double taxaDias) {
		this.taxaDias = taxaDias;
	}

}
