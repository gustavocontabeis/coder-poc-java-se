package br.com.coder.testesjavase.colecoes.array;
import java.util.Arrays;

import junit.framework.TestCase;


public class AdicionarArrayTest extends TestCase {
	
	public void adicionarTest() {
		
		/* Adicionando �tens num Array */
		
		String[] nomes = {"Lautenir", "Romilda", "Giana", "Gustavo", "Leonardo"};
		String[] nomesNovo = adicionar(nomes, "Arthur");
		
		assertTrue(nomes.length == 5);
		assertTrue(nomesNovo.length == 6);
		for (String string : nomesNovo) {
			System.out.println(string);
		}
		
	}
	
	public static String[] adicionar(String[] meuOriginal, String novoItem){
		String[] nomesNovo = Arrays.copyOf(meuOriginal, meuOriginal.length+1);
		nomesNovo[nomesNovo.length-1] = novoItem;
		return nomesNovo;
	}
}
