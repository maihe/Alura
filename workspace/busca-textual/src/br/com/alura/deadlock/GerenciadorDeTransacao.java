package br.com.alura.deadlock;

public class GerenciadorDeTransacao {

	public void begin() {

		System.out.println("Come�ando a transa��o");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
