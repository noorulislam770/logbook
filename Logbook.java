/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package logbook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        
        this.logCalendar = new GregorianCalendar(this.year,this.month - 1,1);
        this.entries = new int[daysInMonth()];
        System.out.println("entreis lenght " + this.entries.length);
        
    }
    

    // public int dayssInMonth(){
    //     int days = logCalendar.getActualMaximum(logCalendar.DAY_OF_MONTH);
    //     return days;
    // }

    
    public void putEntry(int day, int value){
        if (day - 1 > this.entries.length ){
            System.out.println("You are Going beyond day limit " + this.entries.length + " days in this month");
        }
        else{
            System.out.println(day + " "  + value);
            this.entries[day - 1 ] = value;
        }
    }
    
    
    public boolean leapYear(){
        return logCalendar.isLeapYear(this.year);
    }

    
    public int getEntry(int day){
        return this.entries[day - 1];
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getYear() {
        return year;
    }
    
    public int daysInMonth(){
        return this.logCalendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    }
        
    public void displayChart(){
        System.out.println("\n\t\t This Months Log\n");
        System.out.println("\t------------------------------------------------------------");
        System.out.println("\tSunday\t \t Monday \t Tuesday\t Wednesday \tThrusday \t Friday \t Saturday ");
        String firstDay = getFirstDateOfCurrentMonth();
        // System.out.println("first Day " + firstDay);
        
        int tempNum = 0;

        switch (firstDay) {
            case "Saturday":
                tempNum = 6;    
                break;
            case "Sunday":
                tempNum = 0;    
                break;
            case "Monday":
                tempNum = 1;    
                break;
            case "Tuesday":
                tempNum = 2;    
                break;
            case "Wednesday":
                tempNum = 3;    
                break;
            case "Thursday":
                tempNum = 4;    
                break;
        
            case "Friday":
                tempNum = 5;    
                break;
        
            default:
                break;
        }

        int dayCounter = 1;
        System.out.print("\t");
        for (int i = 1; i <= 6;i ++){
            if (tempNum == i){
                String tempText = "            \t";
                tempText = tempText.repeat(i);
                System.out.print(tempText);
            }
        }
        
        dayCounter = tempNum + 1;
        // System.out.println("\nday counter " + dayCounter);
        // System.out.println("Temp counter " + tempNum);
        int loopC = 0;
        for (int num:entries){
            
            if (dayCounter % 7 == 0 ){
                String text;
                if (loopC == 0){
                     text =  (dayCounter - tempNum +1) + " " + num;
                    
                }
                else{
                     text = "\t " + (dayCounter - tempNum +1) + " " + num;

                }
                int textLen = text.length();
                if (textLen< 10){
                    String spcs = " ";
                    spcs = spcs.repeat(10-textLen);
                    text = text + spcs ;
                }
                System.out.print(text);
                
                System.out.println("\t");
            }
            else{

            
                String text;
                if (loopC == 0){
                     text =  (dayCounter - tempNum +1) + " " + num;
                    
                }else{
                     text = "\t " + (dayCounter - tempNum +1) + " " + num;

                }
                int textLen = text.length();
                if (textLen< 10){
                    String spcs = " ";
                    spcs = spcs.repeat(10-textLen);
                    text = text + spcs ;
                }
                System.out.print(text);

            }

            dayCounter ++;
            loopC++;
        }
        System.out.println("");
    }

    private String getFirstDateOfCurrentMonth() {
        logCalendar.set(Calendar.DAY_OF_MONTH,1);
        DateFormat dateFormat =new SimpleDateFormat("EEEEEEEE");
        String formattedDate = dateFormat.format(logCalendar.getTime());
        return formattedDate;
    }
}
