package br.com.coder.testesjavase.datas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
    public void testSomeMethod() {
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        int ano = 2017;
        int mes = Calendar.FEBRUARY;
        int ultimoDiaMes = ultimoDiaMes(ano, mes);
        
        List<Date> datas = new ArrayList<>();
        for (int i = 0; i < ultimoDiaMes; i++) {
            Calendar cal = new GregorianCalendar(ano, mes, i+1);
            Date time = cal.getTime();
            System.out.println(df.format(time)+" - "+getDiaSemana(time)+" - "+cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)+"ª semana");
            datas.add(time);
        }
        
        Object[][] semanas = montarCalendario(datas);
        imprimeCalendario(semanas);
        
        System.out.println("------------------------------------------------");
        
        datas = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            Calendar cal = new GregorianCalendar(2001, Calendar.JANUARY, i+1);
            Date time = cal.getTime();
            System.out.println(time+" - "+cal.get(Calendar.DAY_OF_WEEK)+"ª feira - "+cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)+"ª semana");
            datas.add(time);
        }
        
        Object[][] semanas2 = montarCalendario(datas);
        imprimeCalendario(semanas2);
        
        System.out.println("------------------------------------------------");
        
    }

    private void imprimeCalendario(Object[][] semanas) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Object[] semana : semanas) {
            for (Object obj : semana) {
                if(obj instanceof Date){
                    Date data = (Date) obj;
                    System.out.printf("%10s\t", data!=null?df.format(data):"");
                }else{
                    System.out.printf("%10s\t",obj!=null?obj:"");
                }
            }
            System.out.println("");
        }
    }

    private Object[][] montarCalendario(List<Date> datas) {
        Calendar cal = Calendar.getInstance();
        Object[][] semanas = new Object[7][7];
        
        semanas[0] = new Object[]{ "Dom", "Seg", "Ter", "Qua", "Quin", "Sex", "Sab" };

        boolean init = false;
        int x = 0;
        for (int iSemana = 1; iSemana < semanas.length; iSemana++) {
            for (int iDiaSemana = 0; iDiaSemana < 7; iDiaSemana++) {
                if(x == datas.size()){
                    break;
                }
                Date data = datas.get(x);
                cal.setTime(data);
                if(!init && cal.get(Calendar.DAY_OF_WEEK) == (iDiaSemana+1)){
                    init = true;
                }
                if(init){
                    semanas[iSemana][iDiaSemana] = data;
                    x++;
                }
            }
        }
        return semanas;
    }

    private int ultimoDiaMes(int ano, int mes) {
        Calendar c = new GregorianCalendar(ano, mes, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    private String getDiaSemana(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        int get = c.get(Calendar.DAY_OF_WEEK);
        switch(get){
            case 1:
                return "Domingo  ";
            case 7:
                return "Sábado   ";
            default:
                return get+" ª feira";
        }
    }
    
}
