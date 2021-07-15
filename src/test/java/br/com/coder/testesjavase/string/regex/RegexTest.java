package br.com.coder.testesjavase.string.regex;

import junit.framework.TestCase;

import org.junit.Test;

public class RegexTest extends TestCase {
	
	/*
		 .	Any character (may or may not match line terminators)
		\d	A digit: [0-9]
		\D	A non-digit: [^0-9]
		\s	A whitespace character: [ \t\n\x0B\f\r]
		\S	A non-whitespace character: [^\s]
		\w	A word character: [a-zA-Z_0-9]
		\W	A non-word character: [^\w]
	  
	 */

	@Test
	public void testEspaco() {
		assertTrue( " ".matches("\\s") );
		assertTrue( "        ".matches("\\s*?") );
	}

	@Test
	public void testCaracteres() {
		assertTrue("a".matches("[abc]"));
		assertTrue("b".matches("[abc]"));
		assertTrue("c".matches("[abc]"));
		assertFalse("e".matches("[abc]")); 
		assertTrue("by".matches("[abc][xyz]"));
	}
	
	@Test
	public void testSplit(){
		String[] split = "901.687.800-97".split("[\\.\\-]");
		assertTrue(split.length == 4);
		for(String s : split)
			System.out.println(s);
	}
}
