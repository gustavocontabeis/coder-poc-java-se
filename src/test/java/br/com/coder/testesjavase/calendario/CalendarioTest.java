package br.com.coder.testesjavase.calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caixa
 */
public class CalendarioTest {

    public CalendarioTest() {
    }

    @Test
    public void testMontarCalendario() {
        
        List<Date>listMes = montaListaMes(2017, Calendar.FEBRUARY);

        Calendar cal = new GregorianCalendar(2017, Calendar.FEBRUARY, 1);

        Date first = cal.getTime();

        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        int daysBefore = firstDayOfWeek - Calendar.SUNDAY;

        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);

        Date last = cal.getTime();

        int daysLast = Calendar.SATURDAY - cal.get(Calendar.DAY_OF_WEEK);

        int semanasNoMes = cal.get(Calendar.WEEK_OF_MONTH);
        Date[][] calendario = new Date[semanasNoMes][7];

        Iterator<Date> iterator = listMes.iterator();
        for (int iSemanaNoMes = 0; iSemanaNoMes < calendario.length; iSemanaNoMes++) {
            for (int iDiaSemana = 1; iDiaSemana <= 7; iDiaSemana++) {
                //Primeira semana
                if (iSemanaNoMes == 0 && (iDiaSemana < firstDayOfWeek)) {
                    continue;
                }
                //Última semana
                if(!iterator.hasNext()){
                    break;
                }
                Date next = iterator.next();
                System.out.println(next);
                calendario[iSemanaNoMes][iDiaSemana-1] = next;
            }
        }
        System.out.println("------------------------------------");
        
         for (int i = 0; i < calendario.length; i++) {
             for (int j = 0; j < 6; j++) {
                 System.out.print(calendario[i][j]+", ");
             }
             System.out.println("");
        }

    }

    private List<Date> montaListaMes(int year, int month) {
        
        List<Date> list = new ArrayList<>();
        Calendar cal = new GregorianCalendar(year, month, 1);
        
        while(cal.get(Calendar.MONTH) == month){
            list.add(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        return list;
    }
        

}
