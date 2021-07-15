package br.com.coder.testesjavase.colecoes.queue;

import java.util.LinkedList;
import java.util.Queue;

import junit.framework.TestCase;

public class TestQueue extends TestCase {
	
	public void testLinkedList(){
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= 5; i++) {
			q.add(i);
		}
		
		//NAO ORDENA
		//Collections.sort(q); erro
		
		//element - Pega de cima da fila. Não retira da fila
		System.out.println("-------- element ----------");
		System.out.println(q.size());
		System.out.println(q.element());
		System.out.println(q.size());
		System.out.println(q);
		
		//peek - Pega do início da fila. Não retira da file
		System.out.println("-------- peek ----------");
		System.out.println(q.size());
		System.out.println(q.peek());
		System.out.println(q.size());
		System.out.println(q);
		
		//poll - Retira do início da fila
		System.out.println("-------- pool ----------");
		System.out.println(q.size());
		System.out.println(q.poll());
		System.out.println(q.size());
		System.out.println(q);
		
		//remove - Retira do início da fila. Não retorna o objeto. Retorna booleano.
		System.out.println("-------- remove ----------");
		System.out.println(q.size());
		System.out.println(q.remove());
		System.out.println(q.size());
		System.out.println(q);
		
		
	}

}
