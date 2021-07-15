package br.com.coder.testesjavase.colecoes.list.ordenar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class OrdenarTest extends TestCase {

    @Test
    public void testTrocarPosicao() {
        System.out.println("\ntestTrocarPosicao()");
        List<String> nomes = new ArrayList<String>();
        nomes.add("nome-1");
        nomes.add("nome-2");
        nomes.add("nome-3");
        nomes.add("nome-4");
        nomes.add("nome-5");

        String string1 = nomes.get(4);
        String string2 = nomes.get(0);
        nomes.set(4, string2);
        nomes.set(0, string1);

        for (String str : nomes) {
            System.out.println(str);
        }

    }

    @Test
    public void testNullSafe() {
        System.out.println("\ntestNullSafe()");
        List<Pessoa> list = new ArrayList<>();
        list.add(new Pessoa(1, "Lautenir"));
        list.add(new Pessoa(2, "Romilda"));
        list.add(new Pessoa(3, "Giana"));
        list.add(new Pessoa(4, "Gustavo"));
        list.add(new Pessoa(5, "Leonardo"));
        list.add(new Pessoa(null, "Zé Ninguém"));
        
        Collections.sort(list);
        
        for (Pessoa pessoa : list) {
            System.out.println(pessoa);
        }
    }

    @Test
    public void testManyFields() {
        System.out.println("\ntestManyFields()");
        List<Pessoa> list = new ArrayList<>();
        list.add(new Pessoa(1, "Nome 3"));
        list.add(new Pessoa(1, "Nome"));
        list.add(new Pessoa(1, "Nome 2"));
        list.add(new Pessoa(1, "Nome"));
        list.add(new Pessoa(2, "Nome 2"));
        list.add(new Pessoa(2, "Nome"));
        list.add(new Pessoa(2, null));
        list.add(new Pessoa(null, "Nome"));
        
        Collections.sort(list);
        
        for (Pessoa pessoa : list) {
            System.out.println(pessoa);
        }
    }

}
