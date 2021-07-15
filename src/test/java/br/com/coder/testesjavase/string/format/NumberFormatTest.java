package br.com.coder.testesjavase.string.format;

import java.text.NumberFormat;
import java.util.Date;

import junit.framework.TestCase;

public class NumberFormatTest extends TestCase {

	public void testeFormat() {

		NumberFormat numberInstance = NumberFormat.getNumberInstance();
		numberInstance.setGroupingUsed(true);
		numberInstance.setMinimumFractionDigits(2);
		numberInstance.setMaximumFractionDigits(2);

		System.out.println(numberInstance.format(1));
		System.out.println(numberInstance.format(1000));
		System.out.println(numberInstance.format(1.123));
		System.out.println(numberInstance.format(1234567.8901));


	}

}
