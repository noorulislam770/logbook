/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package logbook;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author nooru
 */
public class Logbook {


    private int month;
    private int year;
    private int[] entries;

    public GregorianCalendar logCalendar;
    
    
    public Logbook(int month,int year){
        
        if (month < 1 || month > 12){
            this.month = 1;
            System.out.println("Invalid Month Defaulted To 1");
            
        }
        else {
            this.month = month;
        }
        if (year < 0 || year > 9999){
            this.year = 2020;
            System.out.println("Invalid Year Defaulted to 2020");
        }
        else{
            this.year = year;
        }
        
        this.logCalendar = new GregorianCalendar(year,month,1);
        System.out.println("entreis lenght " + this.entries.length);
        this.entries = new int[dayssInMonth()];
        
    }
    

    public int dayssInMonth(){
        int days = logCalendar.getActualMaximum(logCalendar.DAY_OF_MONTH);
        return days;
    }

    
    public void putEntry(int day, int value){
        if (day > this.entries.length + 1){
            System.out.println("You are Going beyond day limit " + this.entries.length + " days in this month");
        }
        else{
            this.entries[day] = value;
        }
    }
    
    
    private boolean leapYear(){
        return logCalendar.isLeapYear(this.year);
    }

    
    public int getEntry(int day){
        return this.entries[day];
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getYear() {
        return year;
    }
    
    public int daysInMonth(){
        return this.logCalendar.getActualMaximum(this.month);
    }
        
     public void displayChart(){
         System.out.println("this method will display charts");
     }
}
