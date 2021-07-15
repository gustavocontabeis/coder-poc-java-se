package br.com.coder.testesjavase.arquivos;

import br.com.coder.testesjavase.arquivos.Arquivos;
import static org.junit.Assert.assertNotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

public class ArquivosTest {

    Arquivos arquivos;

    @org.junit.Before
    public void inicio() {
        arquivos = new Arquivos();
    }

    @Test
    public void testConverterArrayBytes() throws IOException {
        File file = new File("Imagem01.jpg");
        byte[] converterArrayBytes = arquivos.converterArrayBytes(file);
        assertNotNull(converterArrayBytes);
    }

    @Test
    public void testSerializarObjeto() throws IOException {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa(1L, "Gustavo", new GregorianCalendar(1978, Calendar.AUGUST, 26).getTime()));
        pessoas.add(new Pessoa(2L, "Giana", new GregorianCalendar(1978, Calendar.OCTOBER, 31).getTime()));
        pessoas.add(new Pessoa(3L, "leo", new GregorianCalendar(1978, Calendar.MARCH, 1).getTime()));
        pessoas.add(new Pessoa(4L, "pai", new GregorianCalendar(1978, Calendar.FEBRUARY, 22).getTime()));
        pessoas.add(new Pessoa(5L, "mae", new GregorianCalendar(1978, Calendar.OCTOBER, 9).getTime()));
        new Arquivos().serializarObjeto(pessoas, new File(buscarUnidade("\\objeto.ser")));
    }

    @Test
    public void testDesSerializarObjeto() throws IOException, ClassNotFoundException {
        Object obj = new Arquivos().descerializarObjeto(new File(buscarUnidade("\\objeto.ser")));
        List<Pessoa> pessoas = (List<Pessoa>) obj;
        for (Pessoa pessoa : pessoas) {
            System.out.print(pessoa.getId() + " - ");
            System.out.print(pessoa.getNome() + " - ");
            System.out.println(pessoa.getNascimento());
        }
    }

    private String buscarUnidade(String url) throws FileNotFoundException {
        if (File.pathSeparatorChar == '\\') {
            for (int i = 'A'; i <= 'Z'; i++) {
                char unidade = (char) i;
                String path = unidade + ":" + url;
                File file = new File(path);
                if (file.exists()) {
                    return path;
                }
            }
        } else if (File.pathSeparatorChar == '/') {
            throw new FileNotFoundException("Systema UNIX ainda n�o implementado");
        }
        throw new FileNotFoundException(url + " n�o existe em nenhuma unidade");
    }

    @Test
    public void testSalvarArquivo() {

    }

    @Test
    public void testArvore() {
        List<File> buscarArvore = new Arquivos().buscarArvore(new File("."));
        for (File file : buscarArvore) {
            System.out.println(file.getAbsolutePath());
        }
    }

}
