package br.com.coder.testesjavase.threads;

public class SimpleTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Tarefa simples. Executando...");
    }

}
