package br.com.coder.testesjavase.caracteres;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class CaracteresTest extends TestCase{

	@Test
	public void test() {
		for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
			char a = (char) i;
			String log = i + " - " + String.valueOf(a);
			System.out.println(log);
		}
	}

}
