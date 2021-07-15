package br.com.coder.testesjavase.java8.optional;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OptionalTest {

	private List<Pessoa> pessoas;
	private List<Integer> numeros;
	private List<String> nomes;

	@Before
	public void setup() {
		pessoas = Arrays.asList(new Pessoa(1, "Lautenir", 66, 'M'), 
				new Pessoa(2, "Romilda", 65, 'F'),
				new Pessoa(3, "Giana", 42, 'F'), new Pessoa(4, "Gustavo", 38, 'M'), new Pessoa(5, "Leonardo", 27, 'M'),
				new Pessoa(6, "Arthur", 15, 'M'));

		numeros = Arrays.asList(9, 5, 6, 3, 7, 4, 1, 5, 2, 8);

		nomes = Arrays.asList("Lautenir", "Romilda", "Giana", "Gustavo", "Leonardo", "Arthur");

	}

	@Test
	public void testPrimeiroDaLista() {
		Pessoa lautenir = pessoas.get(0);
		Pessoa orElse = pessoas.stream().findFirst().get();
		assertSame(orElse, lautenir);
	}

	@Test
	public void testFindOrElse() {
		Pessoa gustavo = pessoas.get(3);
		pessoas = new ArrayList<Pessoa>();
		Pessoa orElse = pessoas.stream().findFirst().orElse(gustavo);
		assertSame(orElse, gustavo);
	}

	@Test
	public void testFilter() {
		
		Optional<Pessoa> findFirst = pessoas.stream().findFirst();
		Optional<Pessoa> filter = findFirst.filter(p->"Lautenir".equals(p.getNome()));
		filter.ifPresent(x->executarAcao(x));
	}
	
	private Pessoa executarAcao(Pessoa pessoa) {
		return pessoa;
	}

	private Optional<List<Pessoa>> getpessoas(){
		return Optional.of(pessoas);
	}

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Pessoa {
	private int id;
	private String nome;
	private int idade;
	private char sexo;
}