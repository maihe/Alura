package br.com.alura.threads;

public class Secundaria {

	public static void main(String[] args) {
		int total = 1000;

	    Thread thread1 = new Thread(new TarefaImprimeNumero(0,total/2-1));
	    Thread thread2 = new Thread(new TarefaImprimeNumero(total/2,total));

	    thread1.start();
	    thread2.start();

	}

}
