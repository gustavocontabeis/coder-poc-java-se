package br.com.coder.testesjavase.datas.calendario;

import java.util.Calendar;

public class Data <T> {
    
	private int diaSemana;
    private Calendar data;
    private T objeto;
    private AoCalcularData<T> aoCalcularData;

    public Data(int diaSemana) {
        this.diaSemana = diaSemana;
    }

	public Data(int diaSemana, Calendar data) {
		this.diaSemana = diaSemana;
		this.data = data;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public T getObjeto() {
		if(objeto == null 
				|| (aoCalcularData != null && this.data !=null)){
			return aoCalcularData.aqui(this.data);
		}
		return null;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	public AoCalcularData<T> getAoCalcularData() {
		return aoCalcularData;
	}

	public void setAoCalcularData(AoCalcularData<T> aoCalcularData) {
		this.aoCalcularData = aoCalcularData;
	}
	
}
