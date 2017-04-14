package br.com.alura.threads;

public class TarefaImprimeNumero implements Runnable {

	private int ini;
	private int fim;

	public TarefaImprimeNumero(int ini, int fim) {
		this.setIni(ini);	
		this.setFim(fim);
	}

	@Override
	public void run() {
		Thread threadAtual = Thread.currentThread();
		long id = threadAtual.getId();
		
		for (int i = ini; i < fim; i++) {
			System.out.println(id + " " +i);
		}

	}

	public int getIni() {
		return ini;
	}

	public void setIni(int ini) {
		this.ini = ini;
	}

	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}



	

}
