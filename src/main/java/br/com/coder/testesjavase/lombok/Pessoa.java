package br.com.coder.testesjavase.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {
	
	private Long id;
	private String nome;
	private float altura;
	private char sexo;
	
}
