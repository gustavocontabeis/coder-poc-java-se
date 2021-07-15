package br.com.coder.testesjavase.datas;

import java.util.Calendar;
import java.util.Date;

public class DatasUtil {

	public static long intervaloEmMinutos(Date de, Date ate) {
			Calendar instance = Calendar.getInstance();
			instance.setTime(ate);
			instance.set(Calendar.SECOND, 0);
			instance.set(Calendar.MILLISECOND, 0);
			long dif = instance.getTime().getTime() - de.getTime();
			long minutos = (dif / (1000*60) );
			return minutos;
		}

	public static long intervaloEmDias(Date de, Date ate) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(ate);
		instance.set(Calendar.HOUR_OF_DAY, 24);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);
		long dif = instance.getTime().getTime() - de.getTime();
		long dias = (dif / (1000*60*60*24) );
		return dias;
	}

	public static long intervaloEmMeses(Date de, Date ate) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(ate);
		instance.set(Calendar.HOUR_OF_DAY, 24);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);
		long dif = instance.getTime().getTime() - de.getTime();
		long dias = (dif / (1000*60*60*24) );
		long meses = dias/30;
		return meses;
	}

	public static long intervaloEmAnos(Date de, Date ate) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(ate);
		instance.set(Calendar.HOUR_OF_DAY, 24);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);
		long dif = instance.getTime().getTime() - de.getTime();
		long dias = (dif / (1000*60*60*24) );
		long meses = dias/30;
		long anos = meses/12;
		return anos;
	}

}
