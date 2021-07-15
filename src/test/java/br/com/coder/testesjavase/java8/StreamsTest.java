package br.com.coder.testesjavase.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author gustavo
 */
public class StreamsTest {
	
	private List<Pessoa> pessoas;
	private List<Integer> numeros;
	private List<String> nomes;
	
	@Before
	public void setup(){
		 pessoas = Arrays.asList(
	        		new Pessoa(1, "Lautenir", 66, 'M'),
	        		new Pessoa(2, "Romilda", 65, 'F'),
	        		new Pessoa(3, "Giana", 42, 'F'),
	        		new Pessoa(4, "Gustavo", 38, 'M'),
	        		new Pessoa(5, "Leonardo", 27, 'M'),
	        		new Pessoa(6, "Arthur", 15, 'M'));
		 
		 numeros = Arrays.asList(9,5,6,3,7,4,1,5,2,8);
		 
		 nomes = Arrays.asList("Lautenir", "Romilda", "Giana", "Gustavo", "Leonardo", "Arthur");

	}
    
    @Test
    public void testOrdenaLista(){
        
        nomes.stream().forEach(System.out::println);
        
        System.out.println("---- java 7 comparator ------------");
        
        nomes.sort(new Comparator<String>(){
            @Override
            public int compare(String t1, String t2) {
                return t2.compareTo(t1);
            }
        });
        
        nomes.stream().forEach(System.out::println);

        System.out.println("---- java 8 comparator ------------");
        
        /* Interface funcional */
        Comparator<String> comparator = (t1, t2)->t1.compareTo(t2);
        
        nomes.sort(comparator);
        
        nomes.stream().forEach(System.out::println);
        
        System.out.println("---- java 8 comparator inline ------------");
        
        nomes.sort((o1, o2) -> o2.compareTo(o1));
        
        nomes.stream().forEach(System.out::println);
    }
    
    @Test
    public void testMax(){
    	
    	/* max lenght os string */
    	int max = nomes
    			.stream()
    			.mapToInt(String::length)
    			.max()
    			.getAsInt();
    	
    	System.out.println(max);
    	
    	/* max of int */
    	max = numeros
    			.stream()
    			.max((a,b)->Integer.compare(a,b))
    			.get();
    	
    	System.out.println(max);
    	
    	/* maior idade de uma lista de pessoas */
    	Pessoa maiorIdade = pessoas
    			.stream()
    			.max((a,b)->Integer.compare(a.getId(), b.getId()))
    			.get();
    	
    	System.out.println(maiorIdade);
    	
    }
    
	@Test
	public void testForEach(){
		
		System.out.println("-----------------");
		numeros.forEach(obj->System.out.println(obj+"!"));
		
		System.out.println("-----------------");
		nomes.forEach(obj->System.out.println(obj+"!"));
		
		System.out.println("-----------------");
		pessoas.stream().forEach(obj->System.out.println(obj));
		
	}
	
}

class Pessoa{
	private int id;
	private String nome;
	private int idade;
	private char sexo;
	public Pessoa(int id, String nome, int idade, char sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + "]";
	}
	
}