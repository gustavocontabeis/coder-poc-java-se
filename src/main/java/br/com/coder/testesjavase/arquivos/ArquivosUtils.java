package br.com.coder.testesjavase.arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArquivosUtils {
	
	public static void serializarObjeto(Object obj, File file){
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oo = new ObjectOutputStream(fos);
			oo.writeObject(obj);
			oo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object descerializarObjeto(File file){
		Object obj = null;
		try {
			FileInputStream fos = new FileInputStream(file);
			ObjectInputStream oo = new ObjectInputStream(fos);
			obj = oo.readObject();
			oo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


}
