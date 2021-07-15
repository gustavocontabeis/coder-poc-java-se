/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coder.testesjavase.colecoes.array;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author f768557 <gustavo.silva@to-brasil.com>
 */
public class BinarySearchTest {

    @Test
    public void hello() {

        //Método de merda.
        //Não intuitivo. vá se foder!
        int[] a = {0, 1, 2, 3, 4, 5};
        //Arrays.sort(a);
        System.out.println("-> " +  Arrays.binarySearch(a, 5));
    }
}
