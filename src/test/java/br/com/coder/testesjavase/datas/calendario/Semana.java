package br.com.coder.testesjavase.datas.calendario;

import java.util.ArrayList;
import java.util.List;

public class Semana {

    private int nrSemana;
    private List<Data> datas = new ArrayList<>();
    
	public Semana(int nrSemana) {
		this.nrSemana = nrSemana;
	}

	public int getNrSemana() {
		return nrSemana;
	}

	public void setNrSemana(int nrSemana) {
		this.nrSemana = nrSemana;
	}

	public List<Data> getDatas() {
		return datas;
	}

	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}
	
}
