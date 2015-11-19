/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TheaterManagement;

import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Griffin2013
 */
public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private int uID;
    private String password;
    protected static int idCounter = 1;
    
    User() {
        setUserName("");
        setPassword("");
        setFirstName("");
        setLastName("");
        setuID(0);
    }
    
    User(final String n, final String p, int id) {
        setUserName(n);
        setPassword(p);
        uID = id;
        if (uID == 0) {
            setuID(idCounter++);
        }
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        if(this.uID > idCounter) {
            idCounter = this.uID++;
        }
        this.uID = uID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void display() {
        System.out.println("");
        
        System.out.println(this.getClass());
        System.out.println("ID: " + getuID());
        System.out.println("Username: " + getUserName());
        System.out.println("First name: " + getFirstName());
        System.out.println("Last name: " + getLastName());
        System.out.println("");
    }
    
    public void addEventRequest(EventRequest er) {
        
    }
    
    public void addEvent(Event e){
        
    }
    
    public boolean checkTickets() {
        return false;
    }
    
    public void displayTickets() {
        
    }
    
    public Ticket findTicket(int choice) {
        return null;
    }
    
    public void addTicket(Ticket t) {
        
    }
    
    public void startUp(Scanner reader) {
        String iUsername;
        String iFirstName;
        String iLastName;
        String iPassword;
        int iUserID;
        
        iUserID = reader.nextInt();
        setuID(iUserID);
        reader.nextLine();
        
        iUsername = reader.next();
        setUserName(iUsername);
        reader.nextLine();
        
        iFirstName = reader.next();
        setFirstName(iFirstName);
        reader.nextLine();
        
        iLastName = reader.next();
        setLastName(iLastName);
        reader.nextLine();
        
        iPassword = reader.next();
        setLastName(iLastName);
        reader.nextLine();
        
    }
    
    public void shutDown(PrintWriter writer) {
        
    }
}
