package br.com.coder.testesjavase.java8.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class LambdaTest {
	
	/*
	 * Interfaces funcionais
	 * 
	 * */
	@Test
	public void testSemLambda(){
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread!");
			}
		}).start();		
	}
	
	@Test
	public void testComLambda(){
		new Thread(()->System.out.println("Thread!")).start();
	}
	
	@Test
	public void testlength(){
		
		List<String> nomes = Arrays.asList("Lautenir", "Romilda", "Giana");
		
		nomes.forEach(obj->System.out.println(obj.length()));
		
		nomes.sort(Comparator.comparing(String::length));
		
		System.out.println("-----");
		
		nomes.forEach(obj->System.out.println(obj.length()));
		
	}

	@Test
	public void testStreams() {
		
		List<String> nomes = Arrays.asList("Lautenir", "Romilda", "Giana", "Gustavo", "Leonardo");
		/*
		 * Agora as interfaces como List possuem intefaces funcionais. 
		 * Interface funcional é uma interface que tem um único método concreto com modificador default. 
		 * Este método é executado a cada iteração.
		 * */
		
        List<String> result = nomes.stream()
                .filter(line -> line.contains("o"))
                .collect(Collectors.toList());

        System.out.println("----------------------");
        result.forEach(s->System.out.println(s.substring(2, 5)));
        System.out.println("----------------------");
        result.forEach(System.out::println);
        
        List<Pessoa> pessoas = Arrays.asList(
        		new Pessoa(1, "Lautenir", 66, 'M'),
        		new Pessoa(1, "Romilda", 65, 'F'),
        		new Pessoa(1, "Giana", 42, 'F'),
        		new Pessoa(1, "Gustavo", 38, 'M'),
        		new Pessoa(1, "Leonardo", 27, 'M'),
        		new Pessoa(1, "Arthur", 15, 'M'));
        
        System.out.println("------ filter ----------------");
        
        List<Pessoa> pessoasComO = pessoas.stream().filter(obj->obj.sexo == 'F').collect(Collectors.toList());
        pessoasComO.forEach(obj->System.out.println(obj.nome));
        
        System.out.println("---------- Max ------------");
        
        //Pessoa de mais idade
        
        Pessoa maiorIdade = pessoas.stream().max((o1,o2) -> Integer.compare(o1.idade, o2.idade)).get();
        System.out.println(maiorIdade.nome);
        
        
	}
	
	class Pessoa{
		int id;
		String nome;
		int idade;
		char sexo;
		public Pessoa(int id, String nome, int idade, char sexo) {
			super();
			this.id = id;
			this.nome = nome;
			this.idade = idade;
			this.sexo = sexo;
		}
	}
}
