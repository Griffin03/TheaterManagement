package TheaterManagement;

import java.io.IOException;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Griffin2013
 */
public class main {
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        Validator v = new Validator();
        Theater th = new Theater("TMS", null);
        String choice = "";
        User u = null;
        String uname = "";
        String pword = "";
        
        // Creating Test Users
        th.createUsers();
        
        // Login
        do {
            System.out.print("Username: ");
            uname = sc.next();
            sc.nextLine();
            System.out.println("");
            System.out.print("Password: ");
            pword = sc.next();
            sc.nextLine();
            u = th.findUser(uname);
        }while(u==null);
        CurrentUser CU = new CurrentUser();
        CU.setCurrentUser(u);
        
        Theater t = new Theater("TMS", CU);
        t.createUsers();
        
        boolean quit = false;
        
        if (u instanceof Employee) {
        
            do {
                displayEmployeeMenu();
                choice = v.getEmpChoice(sc, "Choice: ");

                switch (choice) {
                    case "a":
                    case "A":
                        t.displayTheaterInfo();
                        break;
                    case "b":
                    case "B":
                        t.browseEvents();
                        break;
                    case "c":
                    case "C":
                        t.buyTicket();
                        break;
                    case "d":
                    case "D":
                        t.sellTicket();
                        break;
                    case "e":
                    case "E":
                        t.requestEvent();
                        break;
                    case "f":
                    case "F":
                        t.approveEvent();
                        break;
                    case "g":
                    case "G":
                        break;
                    case "q":
                    case "Q":
                    {
                        System.out.println("Quitting Application...");
                        quit = true;
                        t.shutDown();
                        break;
                    }
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }  
            }while (quit == false);
        }
        
        if(u instanceof Client) {
            
            do {
                displayClientMenu();
                choice = v.getClientChoice(sc, "Choice: ");
            
                switch (choice) {

                    case "A":
                    case "a":
                        t.requestEvent();
                        break;
                    case "B":
                    case "b":
                        t.displayTheaterInfo();
                        break;
                    case "Q":
                    case "q":
                        {
                            System.out.println("Quitting Application...");
                            quit = true;
                            t.shutDown();
                            break;
                        }
                    default: 
                        System.out.println("Invalid choice.");
                        break;
                }
            }while (quit == false);
        }
        
        if(u instanceof Customer) {
            
            do {
                displayCustomerMenu();
                choice = v.getCustomerChoice(sc, "Choice: ");
                
                switch (choice) {
                    case "a":
                    case "A":
                        t.browseEvents();
                        break;
                    case "b":
                    case "B":
                        t.buyTicket();
                        break;
                    case "c":
                    case "C":
                        t.sellTicket();
                        break;
                    case "d":
                    case "D":
                        t.displayTheaterInfo();
                        break;
                    case "Q":
                    case "q":
                        {
                            System.out.println("Quitting Application...");
                            quit = true;
                            t.shutDown();
                            break;
                        }
                    default: 
                        System.out.println("Invalid choice.");
                        break;
                }
            }while(quit == false);
        }
    }
    
    public static void displayEmployeeMenu() {
        System.out.println("Welcome to the Theater Management System");
        System.out.println("");
        System.out.println("");
        System.out.println("*****    Main Menu    *****");
        System.out.println("");
        System.out.println("A)  View Theater Information");
        System.out.println("B)  View Events and Tickets");
        System.out.println("C)  Buy a Ticket");
        System.out.println("D)  Sell a Ticket");
        System.out.println("E)  Request an Event");
        System.out.println("F)  Approve an Event");
        System.out.println("Q)  Quit Application");
        System.out.println("");
    }
    
    public static void displayClientMenu() {
        System.out.println("Welcome to the Theater Management System");
        System.out.println("");
        System.out.println("");
        System.out.println("A) Request an Event");
        System.out.println("B) Get venue information");
        System.out.println("Q) Quit the program");
        System.out.println("");
    }
    
    public static void displayCustomerMenu() {
        System.out.println("Welcome to the Theater Management System");
        System.out.println("");
        System.out.println("");
        System.out.println("A) Browse Events and Tickets");
        System.out.println("B) Buy a ticket");
        System.out.println("C) Sell a ticket");
        System.out.println("D) Get venue information");
        System.out.println("Q) Quit the program");
        System.out.println("");
    }
}
