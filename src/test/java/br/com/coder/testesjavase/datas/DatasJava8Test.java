package br.com.coder.testesjavase.datas;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import junit.framework.TestCase;

public class DatasJava8Test extends TestCase {

    @Test
    public void testLocalDate() {
    	LocalDate localDate = LocalDate.now();
    	System.out.println(localDate);
    	System.out.println("Dia da semana: " + localDate.getDayOfWeek().name());
    	System.out.println("Dia da semana: " + localDate.getDayOfWeek().ordinal());
    	System.out.println("Mes: " + localDate.getMonthValue());
    	System.out.println("Mes: " + localDate.getMonth().name());
    	System.out.println("Ano: " + localDate.getYear());
    }

    @Test
    public void testConverterDateParaLocalDate() {
        LocalDate localDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
    }

    @Test
    public void testConverterDateParaLocalDateTime() {
        LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);
    }

    @Test
    public void testConverterLocalDateParaDate() {
        LocalDate of = LocalDate.of(2018, 6, 28);
        System.out.println("LocalDate = " + of);
		Date date1 = Date.from(of.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("Date      = " + date1);
    }

    @Test
    public void testConverterLocalDateTimeParaDate() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime = " + now);
		Date date1 = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("Date          = " + date1);
    }

    @Test
	public void testConverterLocalDateTimeParaInstant() {
		Instant de = LocalDateTime.of(1978, 8, 26, 9, 45).atZone(ZoneId.systemDefault()).toInstant();
		System.out.println(de);
	}

	@Test
    public void testFormatar() {
    	
    	LocalDate hoje = LocalDate.now();
    	DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	DateTimeFormatter formatadorTraco = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    	System.out.println("Data com /: " + hoje.format(formatadorBarra));
    	System.out.println("Data com -: " + hoje.format(formatadorTraco));   
    }

    @Test
    public void testInstantes() {
    	
    	LocalDateTime deLocalDateTime = LocalDateTime.of(1978, 8, 26, 9, 45);
    	LocalDateTime ateLocalDateTime = LocalDateTime.now();
    	
    	LocalDate deLocalDate = LocalDate.from(deLocalDateTime);
    	LocalDate ateLocalDate = LocalDate.from(LocalDateTime.now());
    	
    	Period period = Period.between(deLocalDate, ateLocalDate);
    	
    	System.out.println(period.toString()
    			.replace("Y", "Anos")
    			.replace("M", "Meses")
    			.replace("D", "Dias"));
    	
    	Instant iInicial = LocalDateTime.of(1978, 8, 26, 9, 45).atZone(ZoneId.systemDefault()).toInstant();
    	Instant iFinal = Instant.now();

    	
    	
    	Duration duracao = Duration.between(iInicial, iFinal);

    	System.out.println("Duração em nanos segundos: " + duracao.toNanos());
    	System.out.println("Duração em minutos: " + duracao.toMinutes());
    	System.out.println("Duração em horas: " + duracao.toHours());
    	System.out.println("Duração em milisegundos: " + duracao.toMillis());
    	System.out.println("Duração em dias: " + duracao.toDays());
    	System.out.println("xxx: " + humanReadableFormat(duracao));
    	
    }
    
    public static String humanReadableFormat(Duration duration) {
        return duration.toString()
                .substring(2)
                .replaceAll("(\\d[HMS])(?!$)", "$1 ")
                .toLowerCase();
    }
    



    @Test
    public void testPeriodoData() {
    	
    	LocalDate localDateDe = LocalDate.of(1978, 8, 26);
    	LocalDate localDateAte = LocalDate.now();

    	System.out.println(localDateDe.isAfter(localDateAte));
    	System.out.println(localDateDe.isBefore(localDateAte));
    	System.out.println(localDateDe.isEqual(localDateAte));

    	Period periodo = Period.between(localDateDe, localDateAte);
    	
    	System.out.println(periodo.getYears() + " Anos " + periodo.getMonths() + " Meses " + periodo.getDays() + " Dias");
    	System.out.println("Horas: " + periodo.get(ChronoUnit.HOURS));
    	System.out.println("Apenas meses: " + periodo.toTotalMonths());
    	
    	System.out.println(periodo.toString()
    			.replace("Y", "Anos")
    			.replace("M", "Meses")
    			.replace("D", "Dias"));
    }
    
    @Test
    public void testPeriodoTempo() {
    	
    	Period preciseBirthdayPeriod = Period.between(LocalDate.of(1978, 1, 26), LocalDate.now());
    	int preciseDaysOld = preciseBirthdayPeriod.getDays();
    	System.out.println(preciseDaysOld); // 13
    	
    	
    	Instant de = LocalDateTime.of(1978, 8, 26, 9, 45).atZone(ZoneId.systemDefault()).toInstant();
		Instant ate = Instant.now();
		
		Duration duration = Duration.between(de, ate);
    	System.out.println(duration);
    	System.out.println("Duração em nanos segundos: " + duration.toNanos());
    	System.out.println("Duração em minutos: " + duration.toMinutes());
    	System.out.println("Duração em horas: " + duration.toHours());
    	System.out.println("Duração em milisegundos: " + duration.toMillis());
    	System.out.println("Duração em dias: " + duration.toDays());
    }
    
    @Test
    public void testPeriodoDataTempo() {
    	
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Date d1 = new GregorianCalendar(1978, Calendar.APRIL, 26, 9, 45).getTime();
		Date d2 = new Date();
		
		Map<TimeUnit, Long> computeDiff = computeDiff(d1, d2);
		for (Entry<TimeUnit, Long> item : computeDiff.entrySet()) {
			if(item.getKey() == TimeUnit.DAYS) {
				System.out.println("YEARS "+(item.getValue()/365));
				long years = item.getValue()%365;
				System.out.println("YEARS-meses "+years);
				double months = item.getValue()/30;
				System.out.println("MONTHS "+months);
				
			}
			System.out.println(item.getKey()+" "+item.getValue());
		}

		try {
		
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			double diffMonths = diffDays / 30;
			double diffYears = diffDays / 365;
			

			System.out.print(diffYears + " years, ");
			System.out.print(diffMonths + " monts, ");
			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
    	
    }
    
    public static Map<TimeUnit,Long> computeDiff(Date date1, Date date2) {

        long diffInMillies = date2.getTime() - date1.getTime();

        //create the list
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        //create the result map of TimeUnit and difference
        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for ( TimeUnit unit : units ) {

            //calculate difference in millisecond 
            long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;

            //put the result in the map
            result.put(unit,diff);
        }

        return result;
    }

    @Test
    public void testDiferencasEntreFusosHorarios() {
    	
    	LocalDateTime hora = LocalDateTime.of(2016, Month.APRIL, 4, 22, 30);

    	ZoneId fusoHorarioDeSaoPaulo = ZoneId.of("America/Sao_Paulo");
    	ZonedDateTime horaSaoPaulo = ZonedDateTime.of(hora, fusoHorarioDeSaoPaulo);
    	System.out.println(horaSaoPaulo);

    	ZoneId fusoHorarioDeParis = ZoneId.of("Europe/Paris");
    	ZonedDateTime horaParis = ZonedDateTime.of(hora, fusoHorarioDeParis);
    	System.out.println(horaParis);

    	Duration diferencaDeHoras = Duration.between(horaSaoPaulo, horaParis);
    	System.out.println(diferencaDeHoras.getSeconds() / 60 / 60);
    
    }
    
    @Test
    public void testXXX() {
    	
//		Date d1 = new GregorianCalendar(1978, Calendar.AUGUST, 26, 0, 0, 0).getTime();
//		Date d2 = new Date();
		
		Date d1 = new GregorianCalendar(2000, Calendar.JANUARY, 1, 0, 0, 0).getTime();
		Date d2 = new GregorianCalendar(2001, Calendar.MARCH, 10, 12, 8, 0).getTime();
		
		long diff = d2.getTime() - d1.getTime();
		
		long dias = diff/(1000*60*60*24);
		long anos = dias/365;
		System.out.println("Anos: "+anos);
		long diasSaldo = dias%365;
		System.out.println("Dias de Saldo: "+ diasSaldo);
		long meses = diasSaldo/30;
		System.out.println("Meses: "+meses);
		diasSaldo = diasSaldo%30;
		System.out.println("Dias: "+ diasSaldo);
    	
    }
    
}
