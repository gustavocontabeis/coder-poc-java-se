package br.com.coder.testesjavase.designpatterns.strategy;

import java.io.IOException;

import org.junit.Test;

public class StrategyTest {

    @org.junit.Before
    public void inicio() {
    }

    @Test
    public void testStrategy() throws IOException {
    	
    	Strategy strategy = StrategyEnum.OPCAO1.getStrategy();
    	
    	System.out.println(strategy.getValor().intValue());
    	
    }

}
