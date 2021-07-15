package br.com.coder.testesjavase.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleTaskTest {

    public SimpleTaskTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRunnable() {
        // Step1 : Create a Runnable
        Runnable simpleTask = new SimpleTask();
        // Step 2: Configure Executor
        // Uses FixedThreadPool executor
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(simpleTask);
        executor.shutdown();
    }

    /**
     * Callable pode retornar um objeto. 
     * Esse objeto estará encapsulado dentro de um objeto Future.
     */
    @Test
    public void testCallable() {
        Callable callableTask = new CallableTask();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Pessoa> future = executor.submit(callableTask);
        boolean listen = true;
        while (listen) {
            if (future.isDone()) {
                Pessoa result;
                try {
                    result = future.get();
                    listen = false;
                    System.out.println(result);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
