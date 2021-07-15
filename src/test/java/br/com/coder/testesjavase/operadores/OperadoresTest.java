package br.com.coder.testesjavase.operadores;


import org.junit.Test;

import junit.framework.TestCase;

public class OperadoresTest extends TestCase {

	@Test
	public void test() {
		System.out.println( true ^ false );
		System.out.println( false ^ true );
		System.out.println( true ^ true );
		System.out.println( false ^ false );
	}

}
