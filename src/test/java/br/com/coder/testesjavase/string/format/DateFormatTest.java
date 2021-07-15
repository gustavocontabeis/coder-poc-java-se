package br.com.coder.testesjavase.string.format;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;

public class DateFormatTest extends TestCase {
	
	@Test
	public void testPadrao(){
		int[] a = {DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL};
		for (int i = 0; i < a.length; i++)
			System.out.println(DateFormat.getDateInstance(i).format(new Date()));
		for (int i = 0; i < a.length; i++)
			System.out.println(DateFormat.getTimeInstance(i).format(new Date()));
	}

}
