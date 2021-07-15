package br.com.coder.testesjavase.arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	
	private List<File>arquivos;
	
	public static byte[] converterArrayBytes(File file) throws IOException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InputStream is = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		while( is.read(buffer) != -1 ){
			bos.write(buffer, 0, buffer.length);
		}
		byte[] byteArray = bos.toByteArray();
		is.close();
		bos.close();
		return byteArray;
	}
	
	
	public static String lerArquivoTxt(File file) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) 
				sb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	public static void salvarArquivo(String txt, File file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(txt);
		bw.flush();
		bw.close();
	}

	public static void salvarArquivo(byte[] dados, File file) throws IOException{
		ByteArrayInputStream bais = new ByteArrayInputStream(dados);
		OutputStream os = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		while( bais.read(buffer) != -1 ){
			os.write(buffer, 0, buffer.length);
		}
		os.close();
		bais.close();
	}
	
	public static void serializarObjeto(Object obj, File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oo = new ObjectOutputStream(fos);
		oo.writeObject(obj);
		oo.close();
		fos.close();
	}
	
	public static Object descerializarObjeto(File file) throws IOException, ClassNotFoundException{
		FileInputStream fos = new FileInputStream(file);
		ObjectInputStream oo = new ObjectInputStream(fos);
		Object obj = oo.readObject();
		oo.close();
		return obj;
	}
	
	public static void criarNovoArquivo(String nome, byte[] dados) throws IOException{
		File file = new File(nome);
		if(!file.exists())
			file.createNewFile();
	}
	
	public List<File>buscarArvore(File root){
		arquivos = new ArrayList<File>();
		File[] listFiles = root.listFiles();
		for (File file : listFiles) {
			arquivos.add(file);
			System.out.println(file.getAbsolutePath() + " " + (file.isDirectory()?"+":""));
			if(file.isDirectory()){
				listarPastas1(file);
			}
		}
		return arquivos;
	}

	private void listarPastas1(File raiz) {
		File[] listFiles = raiz.listFiles();
		for (File arquivo : listFiles) {
			arquivos.add(arquivo);
			System.out.println(arquivo.getAbsolutePath() + " " + (arquivo.isDirectory()?"+":""));
			if(arquivo.isDirectory()){
				listarPastas1(arquivo);
			}
		}
	}

	private void listarPastas2(File raiz) {
		File[] listFiles = raiz.listFiles();
		for (File arquivo : listFiles) {
			arquivos.add(arquivo);
			System.out.println(arquivo.getAbsolutePath() + " " + (arquivo.isDirectory()?"+":""));
			if(arquivo.isDirectory()){
				listarPastas1(arquivo);
			}
		}
	}
}
