package br.com.coder.testesjavase.designpatterns.strategy;

public enum StrategyEnum {

	OPCAO1(){
		@Override
		Strategy getStrategy() {
			return new Strategy1();
		}
	},
	OPCAO2(){
		@Override
		Strategy getStrategy() {
			return new Strategy2();
		}
	},
	OPCAO3(){
		@Override
		Strategy getStrategy() {
			return new Strategy3();
		}
	};
	
	abstract Strategy getStrategy();

}
