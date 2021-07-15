package br.com.coder.testesjavase.datas;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.Test;

import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

public class DatasTest extends TestCase {

    @Test
    public void testIntervaloEmMinutos() {
        Calendar c1 = new GregorianCalendar(2000, Calendar.JANUARY, 1, 1, 1, 0);
        Calendar c2 = new GregorianCalendar(2000, Calendar.JANUARY, 1, 1, 10, 0);
        long minutos = DatasUtil.intervaloEmMinutos(c1.getTime(), c2.getTime());
        System.out.println(minutos + " minutos");
    }

    @Test
    public void testIntervaloEmDias() {
        Calendar c1 = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        Calendar c2 = new GregorianCalendar(2000, Calendar.JANUARY, 10);
        long dias = DatasUtil.intervaloEmDias(c1.getTime(), c2.getTime());
        System.out.println(dias + " dias");
    }

    @Test
    public void testIntervaloEmMeses() {
        Calendar c1 = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        Calendar c2 = new GregorianCalendar(2000, Calendar.DECEMBER, 31);
        long meses = DatasUtil.intervaloEmMeses(c1.getTime(), c2.getTime());
        System.out.println(meses + " meses");
    }

    @Test
    public void testIntervaloEmAnos() {
        Calendar c1 = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        Calendar c2 = new GregorianCalendar(2010, Calendar.JANUARY, 1);
        long anos = DatasUtil.intervaloEmAnos(c1.getTime(), c2.getTime());
        System.out.println(anos + " anos");
    }

    @Test
    public void testCompararDatas() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSSS");

        Date dt1 = new GregorianCalendar(1978, Calendar.AUGUST, 26, 5, 6, 7).getTime();
        Date dt2 = new GregorianCalendar(1978, Calendar.AUGUST, 26, 8, 9, 10).getTime();
        System.out.println(df.format(dt1));
        System.out.println(df.format(dt2));
        System.out.println(dt1.before(dt2));

        dt1 = truncarData(dt1);
        dt2 = truncarData(dt2);
        System.out.println(df.format(dt1));
        System.out.println(df.format(dt2));
        System.out.println(dt1.before(dt2));

    }

    private Date truncarData(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        for (int i : new int[]{Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND}) {
            c.set(i, 0);
        }
        return c.getTime();
    }

    @Test
    public void testTimestamp2() throws ParseException {
        String pattern = "dd/MM/yyyy HH:mm:ss.SSSS";
        DateFormat df = new SimpleDateFormat(pattern);
        System.out.println(
                df.parse("20/02/2016 23:04:15.0187").getTime() < df.parse("20/02/2016 23:10:00.0000").getTime());
    }
    
    @Test
    public void testTimestamp() {
        
        
        final Date date = new Date(Long.MIN_VALUE);

        String pattern = "dd/MM/yyyy HH:mm:ss.SSSS";
        DateFormat df = new SimpleDateFormat(pattern);

        long longI = 1456020255187L;
        long longF = 1456017000000L;

        Timestamp iTm = new Timestamp(longI);
        Timestamp fTm = new Timestamp(longF);
        Date iDt = new Date(1456020255187L); //20/02/2016 23:04:15.0187
        Date fDt = new Date(1456017000000L); //20/02/2016 23:10:00.0000
        assertTrue(iDt.before(fDt));//ERRO!
        
        Calendar cal0 = Calendar.getInstance();
        cal0.setTime(iDt);
        cal0.set(Calendar.MILLISECOND, 0);
        
        iDt = cal0.getTime();
        
        cal0.setTime(fDt);
        cal0.set(Calendar.MILLISECOND, 0);
        fDt = cal0.getTime();
        
        System.out.println(iDt.getTime() < fDt.getTime());

        System.out.println(df.format(iTm));
        System.out.println(df.format(fTm));
        System.out.println(df.format(iDt));
        System.out.println(df.format(fDt));

        System.out.println(iTm.before(fTm));
        System.out.println(iDt.before(fDt));
        
        System.out.println(iTm.getTime());
        System.out.println(fDt.getTime());
        
        Calendar cal = new GregorianCalendar(2016, Calendar.FEBRUARY, 20, 23, 4, 15);
        cal.set(Calendar.MILLISECOND, 187);
        System.out.println(cal.getTimeInMillis());

        Calendar cal2 = new GregorianCalendar(2016, Calendar.FEBRUARY, 20, 23, 10, 0);
        System.out.println(cal2.getTimeInMillis());
        cal2.setTimeInMillis(longF);
        System.out.println(df.format(cal2.getTime()));

    }

    @Test
    public void testXXX(){
        String PATTERN = "dd/MM/yyyy HH:mm:sss";
        System.out.println(new DateTime().toString(PATTERN));
        System.out.println(new DateTime().minusMinutes(10).toString(PATTERN));
    }

    @Test
    public void testFormao(){
        SimpleDateFormat df = new SimpleDateFormat("MMMM/yyyy", new Locale("pt", "BR"));
        System.out.println(df.format(new Date()));
    }
}
