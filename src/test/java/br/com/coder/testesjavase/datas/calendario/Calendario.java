package br.com.coder.testesjavase.datas.calendario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

public class Calendario {

	private Locale ptBR = new Locale("pt", "BR");
	private DateFormat dfMesAno = new SimpleDateFormat("MM/yyyy");
	private Queue<Calendar> datasMes;
	private Calendar de, ate;
	
	
    private List<Semana> semanas = new ArrayList<>();

    public List<Semana> getSemanas() {
        return semanas;
    }

    /**
     * @param ano
     * @param mes - 0-11 (Utilizando Calendar)
     */
    public Calendario(int ano, int mes) {
    	
    	//Monta a data inicial
    	de = new GregorianCalendar(ano, mes, 1);
    	
		//Monta a data final
		ate = new GregorianCalendar();
		ate.setTimeInMillis(de.getTimeInMillis());
		ate.add(Calendar.MONTH, 1);
		ate.add(Calendar.DAY_OF_MONTH, -1);

		//System.out.println(dfMesAno.format(de.getTime()));

		//Monta uma fila de datas do mês
		datasMes = new LinkedList<>();
		while (de.before(ate) || de.equals(ate)) {
			Calendar c = new GregorianCalendar();
			c.setTime(de.getTime());
			datasMes.add(c);
			de.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		for (int iSemana = de.get(Calendar.WEEK_OF_MONTH); iSemana <= ate.get(Calendar.WEEK_OF_MONTH); iSemana++) {
			// System.out.println("Semana -> " + iSemana);
			Semana semana = new Semana(iSemana);
			semanas.add(semana);
			
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
				
				Data data = new Data<String>(iDiaSemana, dia);
				semana.getDatas().add(data);
				
			}
			//System.out.println();
		}
    }

}
