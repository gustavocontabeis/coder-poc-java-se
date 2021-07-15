package br.com.coder.testesjavase.threads;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Pessoa> {

    @Override
    public Pessoa call() throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        Pessoa pessoa = new Pessoa();
        pessoa.setId(currentTimeMillis);
        pessoa.setNome("nome " + currentTimeMillis);
        pessoa.setEmail("email " + currentTimeMillis);
        return pessoa;
    }

}
