/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author meucomputador
 */
public class Data implements Serializable {
    
    private Calendar dataAluguel;
    private Calendar dataMaximaDev;
    
    public Data(int dia, int mes, int ano) {
        dataAluguel = new GregorianCalendar(ano,mes-1,dia);
        dataMaximaDev = new GregorianCalendar(ano,mes-1,dia);
        dataMaximaDev.add(Calendar.DAY_OF_YEAR, 14);
    }
    
    public String getDataDevolucao() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        return sdf.format(dataMaximaDev.getTime());
    }
    
    public String getDataAluguel() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        return sdf.format(dataAluguel.getTime());
    }
    
    public int getMulta(Calendar dataDev) {
        Date date1 = dataAluguel.getTime();
        Date date2 = dataDev.getTime();
        long diff = date2.getTime() - date1.getTime();
        long dias = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println(dias);
        if(dias <= 14) {
            return 0;
        } else {
            return (int) (dias-14);
        }
    }
    
}
