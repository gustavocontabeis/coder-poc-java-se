package br.com.coder.testesjavase.colecoes.array;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * LinkedList � ima cole��o q permite iguais bom para inderir e retirar coisas;
 * @author gustavosilva
 *
 */
public class LinkedListTest extends TestCase {
	
	@Test
	public void testAdd(){
		
		LinkedList<String>list = new LinkedList<String>();
		
		/* insere primeiro, ultimo... */
		list.addLast("A");
		list.addFirst("B");
		list.addFirst("C");
		
		assertTrue(list.size()==3);
		
		assertEquals(list.get(0), "C");
		assertEquals(list.get(1), "B");
		assertEquals(list.get(2), "A");
		
		for(String s : list)
			System.out.print(s+", ");
		System.out.println();
	}

	@Test
	public void testPeek(){
		
		LinkedList<String>list = new LinkedList<String>();
		
		/* insere primeiro, ultimo... */
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertTrue(list.size()==3);
		
		/* peek pega o primeiro mas nao exclui */
		String peek = list.peek();
		System.out.println(peek);
		
		assertTrue(list.size()==3);
		
		for(String s : list)
			System.out.print(s+", ");
		System.out.println();
	}

	@Test
	public void testPool(){
		
		LinkedList<String>list = new LinkedList<String>();
		
		/* insere primeiro, ultimo... */
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertTrue(list.size()==3);
		
		/* pool pega o primeiro e retira da lista */
		String poll = list.poll();
		System.out.println(poll);
		
		assertTrue(list.size()==2);
		
		for(String s : list)
			System.out.print(s+", ");
		System.out.println();
		
		
	}
	
	
	public void testPerformance(){
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int tamanho = 500;
		long[] tempo = new long[7]; 
		tempo[0] = System.currentTimeMillis();
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				ll.add(i);
			}
		}
		tempo[1] = System.currentTimeMillis();
		for(Integer a : ll){}
		tempo[2] = System.currentTimeMillis();
		while(!ll.isEmpty())
			ll.poll();
		tempo[3] = System.currentTimeMillis();
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				al.add(i);
			}
		}
		tempo[4] = System.currentTimeMillis();
		for(Integer a : ll){}
		tempo[5] = System.currentTimeMillis();
		while(!al.isEmpty())
			al.remove(0);
		tempo[6] = System.currentTimeMillis();
		System.out.println("LinkedList demorou para popular "   + new SimpleDateFormat("mm:ss-SSSS").format(new Date(tempo[1]-tempo[0])));
		System.out.println("LinkedList demorou para percorrer " + new SimpleDateFormat("mm:ss-SSSS").format(new Date(tempo[2]-tempo[1])));
		System.out.println("LinkedList demorou para excluir "   + new SimpleDateFormat("mm:ss-SSSS").format(new Date(tempo[3]-tempo[2])));
		System.out.println("ArrayList demorou para popular "    + new SimpleDateFormat("mm:ss-SSSS").format(new Date(tempo[4]-tempo[3])));
		System.out.println("ArrayList demorou para percorrer "  + new SimpleDateFormat("mm:ss-SSSS").format(new Date(tempo[5]-tempo[4])));
		System.out.println("ArrayList demorou para excluir "    + new SimpleDateFormat("mm:ss-SSSS").format(new Date(tempo[6]-tempo[5])));
		
	}

}
