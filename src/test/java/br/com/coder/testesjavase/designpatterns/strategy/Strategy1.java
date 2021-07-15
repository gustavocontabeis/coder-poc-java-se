package br.com.coder.testesjavase.designpatterns.strategy;

import java.math.BigDecimal;

public class Strategy1 implements Strategy {

	@Override
	public BigDecimal getValor() {
		return BigDecimal.ONE;
	}

}
