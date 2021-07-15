package br.com.coder.testesjavase.arquivos.freespace;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.logging.Level;
import org.junit.Test;

/**
 *
 * @author f768557 <gustavo.silva@to-brasil.com>
 */
public class FreeSpaceTest {

    @Test
    public void test() throws Exception {
        
        
        
        long gb = 1000000000L;
        NumberFormat nf = NumberFormat.getNumberInstance();
        
        System.out.println(":::::::::::::::::::::::");
        for (Path root : FileSystems.getDefault().getRootDirectories()) {
            System.out.println(root + ":");
            FileStore store = Files.getFileStore(root);
            System.out.println("Disponível: " + nf.format(store.getUsableSpace()/gb) + ", total: " + nf.format(store.getTotalSpace()/gb));
        }
        
        System.out.println(":::::::::::::::::::::::");
        Path root = Paths.get("/home/gustavo");
        System.out.println(root + ":");
        FileStore store = Files.getFileStore(root);
        System.out.println("Disponível: " + nf.format(store.getUsableSpace()/gb) + ", total: " + nf.format(store.getTotalSpace()/gb));
        
        System.out.println(":::::::::::::::::::::::");
        File file = new File("/home/gustavo/Programas");
        System.out.println(root + ":");
        System.out.println("Disponível: " + nf.format(file.length()) + ", total: " + nf.format(store.getTotalSpace()/gb));
        
        
    }

}
