package br.com.coder.testesjavase.string.format;

import java.util.Date;

import junit.framework.TestCase;

public class FormatTest extends TestCase {
	
	public void testeFormat(){
		/*
		 * Sintaxe:
		 * 
		 * String e numeros
		 * %[argument_index$][flags][width][.precision]conversion
		 * 
		 * Datas e tempo
		 * %[argument_index$][flags][width]conversion
     
		 * '-' Resultado deve ser justivafado � esquerda
		 * */
		
		System.out.println("-> Indices"); 
		System.out.printf("%5$d, %4$d, %3$d, %2$d, %1$d", 1,2,3,4,5);
		System.out.println();
		
		//Tipos
		System.out.println("-> Tipos");
		System.out.printf("%d %c %s", 1, 'a', "b");
		System.out.println();
		
		//Alinhamento
		System.out.println("-> Alinhamento");
		System.out.printf("%5d", 6);
		System.out.println();
		System.out.printf("%-5d", 6);
		System.out.println();
		System.out.printf("%05d", 6);
		System.out.println();
		System.out.printf("|%20s|", "Gustavo");
		System.out.println();
		System.out.printf("|%-20s|", "Gustavo");
		System.out.println();
		
		//Datas
		System.out.printf("%1$td/%1$tm/%1$tY \n", new Date());
		
		//float
		System.out.println("-> float");
		System.out.printf("%017.2f", 123.456f);

	}

}
