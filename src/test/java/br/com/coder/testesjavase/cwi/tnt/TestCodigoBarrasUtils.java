package br.com.coder.testesjavase.cwi.tnt;

import javax.swing.JOptionPane;

import junit.framework.TestCase;

/**
 * @author JonasFE
 *
 */
public class TestCodigoBarrasUtils extends TestCase {
	
	public static boolean validateDv(String valor){
		String codigo = valor.substring(0, valor.length()-1);
    	String dv = valor.substring(valor.length()-1, valor.length());

    	int multiplicador = 2;
    	int soma = 0;
    	for (int i = codigo.length()-1; i >= 0 ; i--) {
    		soma += new Integer(codigo.substring(i, i+1)) * multiplicador;
    		multiplicador = multiplicador==9? 2 : multiplicador+1;
		}
    	
    	int resto = soma % 11;
    	int digitoCalculado = (resto==0 || resto==1) ? 0 : 11 - resto;
    	
    	if(digitoCalculado == new Integer(dv).intValue()){
    		return true;
    	} else {
    		return false;
    	}
	}
	
	public void testRetornarDigitoVerificador(){
		String nr = JOptionPane.showInputDialog("Codigo de barras sem o dígito verificador.").trim();
		
		if(nr.length()>8)
			nr = nr.substring(0, 8); 
		
		for (int i = 0; i < 10; i++) {
			String codigoDeBarraComDigitoVerificador = nr+String.valueOf(i);
			if(validateDv(codigoDeBarraComDigitoVerificador)){
				System.out.println(codigoDeBarraComDigitoVerificador);
				JOptionPane.showInputDialog("Codigo de barras com o dígito verificador.", codigoDeBarraComDigitoVerificador);
				break;
			}
		}
	}

}
