package br.com.fiap.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
	

	public static void main(String args[]) throws ParseException {
	SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");  
    Calendar cal = Calendar.getInstance();  
      
    String dataDoDia = sd.format(new Date());  
    Date data; 
    data = sd.parse(dataDoDia);         
    cal.setTime(data);  
      
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));  
        final Date primeiroDia = new Date(cal.getTimeInMillis());  
        String primeiro = sd.format(primeiroDia);  
        System.out.println("Primeiro dia Mes Atual: " + primeiro);  
  
        cal.set(Calendar.DAY_OF_MONTH , cal.getActualMaximum(Calendar.DAY_OF_MONTH));  
        final Date ultimoDia = new Date(cal.getTimeInMillis());  
        String ultimo = sd.format(ultimoDia);  
        System.out.println("Ultimo dia Mes Atual: " + ultimo);  
        
        System.out.println("Quanto ta valendo a data" + cal.get(Calendar.MONTH));    
        System.out.println("Quanto ta valendo a data" + cal.get(Calendar.DAY_OF_MONTH)); 
        
	}
	
	

}
