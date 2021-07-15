package br.com.coder.testesjavase.reflection;

import br.com.coder.testesjavase.reflection.ReflectionUtils;
import java.util.ArrayList;

import org.junit.Test;

public class ReflectionUtilsTest {

	@Test
	public void test() {
		Class tipoGenerico = ReflectionUtils.tipoGenerico(new ArrayList<Pessoa>().getClass());
		System.out.println(tipoGenerico == Pessoa.class);
	}

}
