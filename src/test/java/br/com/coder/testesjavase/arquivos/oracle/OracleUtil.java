package br.com.coder.testesjavase.arquivos.oracle;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

public class OracleUtil extends TestCase {
	
	public static String toDate(Date date){
		String format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
		return "to_date('"+format+"','DD/MM/YYYY HH24:MI:SS')";
	}

}
