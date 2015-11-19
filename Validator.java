/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TheaterManagement;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author Griffin2013
 */
public class Validator {
    
    public String getEmpChoice(Scanner sc, String prompt) {
        boolean isValid = false;
        String s = "";
        
        while (isValid == false) {
            System.out.print(prompt);
            s = sc.next();
            sc.nextLine();
            
            if (s.equalsIgnoreCase("a") || s.equalsIgnoreCase("b") || 
                    s.equalsIgnoreCase("c") || s.equalsIgnoreCase("q") || s.equalsIgnoreCase("d")
                    || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("f")) {
                isValid = true;
            }
            else
                System.out.println("Entry is invalid, please try again.");
        }
        return s;
    }
    
    public String getClientChoice(Scanner sc, String prompt) {
        boolean isValid = false;
        String s = "";
        
        while (isValid == false) {
            System.out.print(prompt);
            s = sc.next();
            sc.nextLine();
            
            if (s.equalsIgnoreCase("a") || s.equalsIgnoreCase("b") || 
                    s.equalsIgnoreCase("q")) {
                isValid = true;
            }
            else
                System.out.println("Entry is invalid, please try again.");
        }
        return s;
    }
    
    public String getCustomerChoice(Scanner sc, String prompt) {
        boolean isValid = false;
        String s = "";
        
        while (isValid == false) {
            System.out.print(prompt);
            s = sc.next();
            sc.nextLine();
            
            if (s.equalsIgnoreCase("a") || s.equalsIgnoreCase("b") || 
                    s.equalsIgnoreCase("c") || s.equalsIgnoreCase("q") || s.equalsIgnoreCase("d")) {
                isValid = true;
            }
            else
                System.out.println("Entry is invalid, please try again.");
        }
        return s;
    }
    
    public int getEvent(Scanner sc, String prompt, ArrayList<Event> events) {
        boolean isValid = false;
        int choice = 0;
        int index = 0;
        Event e;
        
        while (isValid == false) {
            System.out.print(prompt);
            
            choice = sc.nextInt();
            sc.nextLine();
            index = (choice - 1);
            if(choice <= events.size() && choice > 0) {
                e = events.get((index));

                e.display();

                if (events.get(index).getEID() == e.getEID()) {
                    isValid = true;
                }
                else
                    System.out.println("Event ID " + choice + " was not found in the system.  Please try again.");
            }
            else
                System.out.println("Event ID " + choice + " was not found in the system.  Please try again.");
        }
                
        return index;
    }
    
    public int getRequest(Scanner sc, String prompt, ArrayList<EventRequest> eventRequests) {
        boolean isValid = false;
        int choice = 0;
        int index = 0;
        EventRequest er;
        
        while (isValid == false) {
            System.out.print(prompt);
            choice = sc.nextInt();
            sc.nextLine();
            index = (choice - 1);
            if (choice <= eventRequests.size() && choice > 0) {
                er = eventRequests.get(index);

                er.display();

                if (eventRequests.get(index).getErID() == er.getErID()) {
                    isValid = true;
                }
                else
                    System.out.println("Event Request ID " + choice + " was not found in the system.  Please try again.");
            }
            else
                System.out.println("Event Request ID " + choice + " was not found in the system.  Please try again.");
        }
        
        return index;
    }
    
    public int getTicket(Scanner sc, String prompt, ArrayList<Ticket> tickets) {
        boolean isValid = false;
        int choice = 0;
        int index = 0;
        Ticket t;
        
        while (isValid == false) {
            System.out.print(prompt);
            choice = sc.nextInt();
            sc.nextLine();
            index = (choice - 1);
            
            if (choice <= tickets.size() && choice > 0) {
                t = tickets.get(index);
                if(tickets.contains(t)){
                    isValid = true;
                }
            }
            else
                System.out.println("Ticekt ID: " + choice + " was not found in the system. Please try again.");
        }
        
        return index;
    }
    
    public String getTime(Scanner sc, String prompt) {
        SimpleDateFormat formated = new SimpleDateFormat("hh:mm");
        boolean isValid = false;
        String time = "";
        
        do {
            System.out.print(prompt);
            time = sc.next();
            try {
                Date date =  new SimpleDateFormat("hh:mm").parse(time);
                time = formated.format(date);
                isValid = true;
            }
            catch (Exception e) {
                System.out.println("Please enter a valid time.");
                isValid = false;
            }
        }while(isValid == false);
        
        sc.nextLine();
        
        return time;
    }
    
    public int getNum(Scanner sc, String prompt) {
        boolean isValid = false;
        int choice = 0;
        
        while (isValid == false) {
            System.out.print(prompt);
            choice = sc.nextInt();
            sc.nextLine();
            
            if(choice > 0)
                isValid = true;
            else
                System.out.println("Please enter a value larger than zero.");
        }
        return choice;
    }
    
    public double getPrice(Scanner sc, String prompt) {
        boolean isValid = false;
        double choice = 0;
        
        while (isValid == false) {
            System.out.print(prompt);
            choice = sc.nextDouble();
            sc.nextLine();
            
            if(choice > 0)
                isValid = true;
            else
                System.out.println("Please enter a value larger than zero.");
        }
        return choice;
    }
}


