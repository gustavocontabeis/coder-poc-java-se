package br.com.coder.testesjavase.designpatterns.strategy;

import java.math.BigDecimal;

public class Strategy3 implements Strategy {

	@Override
	public BigDecimal getValor() {
		return new BigDecimal(3);
	}

}
