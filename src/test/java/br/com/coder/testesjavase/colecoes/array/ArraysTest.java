package br.com.coder.testesjavase.colecoes.array;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class ArraysTest extends TestCase{
	
	public void converterParaListTest(){
		
		List<String> asList = Arrays.asList(new String[]{"PDF", "Enviar e-mail"});

		assertTrue(asList != null);
		assertTrue(asList.size() == 2);
		
		System.out.println(asList);
	}

}
