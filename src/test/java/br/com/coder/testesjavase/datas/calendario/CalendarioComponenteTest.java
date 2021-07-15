package br.com.coder.testesjavase.datas.calendario;

import java.net.InterfaceAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

import org.junit.Test;

public class CalendarioComponenteTest {

	@Test
	public void testCalendario() {

		Locale ptBR = new Locale("pt", "BR");
		DateFormat dfMesAno = new SimpleDateFormat("MM/yyyy");

		Calendar de = new GregorianCalendar(2017, Calendar.MARCH, 1);

		Calendar ate = new GregorianCalendar();
		ate.setTimeInMillis(de.getTimeInMillis());
		ate.add(Calendar.MONTH, 1);
		ate.add(Calendar.DAY_OF_MONTH, -1);

//		System.out.println(dfMesAno.format(de.getTime()));

		// Monta uma fila de datas do mês
		Queue<Calendar> datasMes = new LinkedList<>();
		while (de.before(ate) || de.equals(ate)) {
			Calendar c = new GregorianCalendar();
			c.setTime(de.getTime());
			datasMes.add(c);
			de.add(Calendar.DAY_OF_MONTH, 1);
		}

		for (int iSemana = de.get(Calendar.WEEK_OF_MONTH); iSemana <= ate.get(Calendar.WEEK_OF_MONTH); iSemana++) {
			// System.out.println("Semana -> " + iSemana);

			for (int iDiaSemana = Calendar.SUNDAY; iDiaSemana <= Calendar.SATURDAY; iDiaSemana++) {
				// System.out.print(iDiaSemana + "-");

				// Procura a data pela semana e dia da semana
				Calendar dia = null;
				Iterator<Calendar> iterator = datasMes.iterator();
				ok: while (iterator.hasNext()) {
					Calendar find = (Calendar) iterator.next();
					if (find.get(Calendar.WEEK_OF_MONTH) == iSemana) {
						if (find.get(Calendar.DAY_OF_WEEK) == iDiaSemana) {
							dia = find;
							iterator.remove();
							break ok;
						}
					}
				}
				//System.out.printf(" %3s | ", (dia != null ? dia.get(Calendar.DAY_OF_MONTH) : "  "));
			}
			//System.out.println();
		}
		
		
		System.out.println("==========================================================================================");
		System.out.println("================================ componente calendario ===================================");
		System.out.println("==========================================================================================");
		
		
		AoCalcularData<String> calc = new AoCalcularData<String>(){
			public String aqui(Calendar data){
				if(data !=null){
					return "dia "+data.get(Calendar.DAY_OF_MONTH)+" "+new Date();
				}else{
					return "";
				}
			}
		}; 
		
		Calendario calendario = new Calendario(2017, Calendar.APRIL);
		List<Semana> semanas = calendario.getSemanas();
		for (Semana semana : semanas) {
			List<Data> datas = semana.getDatas();
			for (Data data : datas) {
				data.setAoCalcularData(calc);
				Object objeto = data.getObjeto();
				System.out.printf("%4s %s | ", data.getData()!=null?data.getData().get(Calendar.DAY_OF_MONTH):"", objeto);
			}
			System.out.println();
		}
		
	}
	
}

interface AoCalcularData <T>{
	public T aqui(Calendar data);
}