package br.com.coder.testesjavase.colecoes.queue;

import java.util.Stack;

import junit.framework.TestCase;

public class TestStack extends TestCase {
	
	public void testLinkedList(){
		
		Stack<Integer> q = new Stack<>();
		
		for (int i = 1; i <= 5; i++) {
			q.push(i);
		}
		System.out.println(q);
		
		//pop - Retira de cima da pilha.
		System.out.println("-------- pop ----------");
		System.out.println(q.size());
		System.out.println(q.pop());
		System.out.println(q.size());
		System.out.println(q);
		
		//peek - Exibe o ítem de cima da pilha. Não o retira.
		System.out.println("-------- peek ----------");
		System.out.println(q.size());
		System.out.println(q.peek());
		System.out.println(q.size());
		System.out.println(q);
		
		//search - Busca o ítem na pilha. Não o retira.
		System.out.println("-------- search ----------");
		System.out.println(q.size());
		System.out.println(q.search(1));
		System.out.println(q.size());
		System.out.println(q);
		
		
	}

}
