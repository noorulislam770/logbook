/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package logbook;

import java.util.Scanner;

/**
 *
 * @author nooru
 */
public class Coffee {
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        System.out.println("Inam And Students Coffee ");
        
        System.out.println("Enter The Month To Start Log For");
        int month = in.nextInt();
        System.out.println("Enter the Year '0' for this year");
        int year = in.nextInt();
        
        Logbook log = new Logbook(month,year);
        
        while (true){
            System.out.println("Select a operation");
            System.out.println("Enter :"
                    + "\n\t1 To add a new Entry  "
                    + "\n\t2 To check sales for one day "
                    + "\n\t3 To display full log chart "
                    + "\n\t0 To Exit The Program   ");
            
            int option = in.nextInt();
            if (option == 1){
                System.out.println("Enter a date");
                int date = in.nextInt();
                System.out.println("Enter the sales");
                int value = in.nextInt();
                log.putEntry(date,value);
                System.out.println("Entry Inserted Successfully.");
            }
            
            else if (option == 2){
                System.out.println("Enter The Day you want to read sales for");
                int day = in.nextInt();
                int value  = log.getEntry(day);
                System.out.println("Sales for day " + day + " = " + value);
            }
            else if (option == 3 ){
                log.displayChart();
            }
            else if (option ==0 ){
                break;
            }
        }
        in.close();
        // System.out.println();
    }
}
