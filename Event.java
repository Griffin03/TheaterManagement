/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TheaterManagement;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author Griffin2013
 */
public class Event {
    private int eid;
    private String name;
    private int numSeats;
    private String startTime;
    private String endTime;
    private String description;
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private static int IDCounter = 1;
    
    //default constructor
    public Event() {
        setEID(0);
        setName("");
        setNumSeats(0);
        setStartTime("");
        setEndTime ("");
        setDescription("");
    }
    
    //constructor
    public Event(int id, String n, int numS, String start, String end, String desc) {
        if(id == 0)
        {
            setEID(IDCounter++);
        }
        setName(n);
        setNumSeats(numS);
        setStartTime(start);
        setEndTime (end);
        setDescription(desc);        
    }
    
    @Override
    public boolean equals(Object r) {
        if (!(r instanceof Event)) {
            return false;
        }
        if (r == this) {
            return true;
        }
        return this.name.equals(((Event)r).name);
    }
    
    @Override
    public int hashCode() {
        return name.length();
    }
    
    // *****    Sets and Gets   *****
    
    public void setEID(int num) {
        if(num >= IDCounter)
            IDCounter = (num + 1);
        eid = num;
    }
    
    public int getEID() {
        return eid;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public String getName() {
        return name;
    }
    
    public void setNumSeats(int num) {
        numSeats = num;
    }
    
    public int getNumSeats() {
        return numSeats;
    }
    
    public void setStartTime(String time) {
        startTime = time;
    }
    
    public String getStartTime() {
        return startTime;
    }
    
    public void setEndTime(String time) {
        endTime = time;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
    public void setDescription(String desc) {
        description = desc;
    }
    
    public String getDescription() {
        return description;
    }
    
    //  *****   Other Methods   *****
    
    public final void listAvailableTickets() {
        Ticket t;
        
        for(int i = 0; i < tickets.size(); ++i) {
            t = tickets.get(i);
            if( t.getOwned() == false) {
                t.display();
            }
        }
    }
    
    public final void listAllTickets() {
        Ticket t;
        
        for( int i = 0; i < tickets.size(); ++i) {
            t = tickets.get(i);
            t.display();
        }
    }
    
    public void display() {
        if(tickets.size() > 0) {
            System.out.println("Event ID: " + getEID() + "      Event Name: " +getName());
            System.out.println("Number of Tickets: " + tickets.size());
            System.out.println("Description: " + getDescription());
            System.out.println();
            System.out.println();
        }
    }
    
    public Ticket buyTicket() {
        Ticket t;
        Scanner sc = new Scanner(System.in);
        Validator v = new Validator();
        int choice = 0;
        
        listAvailableTickets();
        System.out.println();
        System.out.println();
        choice = v.getTicket(sc, "Choose the ticket that you wish to purchase by ticket ID: ", tickets);
        t = tickets.get(choice);
        
        return t;
    }
    
    
    public final void browseTickets() {
        System.out.println("*****    Browsing Tickets    *****");
        System.out.println();
        System.out.println();
        
        Scanner sc = new Scanner(System.in);
        Validator v = new Validator();
        int choice = 0;
        Ticket t;
        
        if(tickets.size() > 0) {
            listAllTickets();
            System.out.println();
            System.out.println();
            
            choice = v.getTicket(sc, "Choose the ticket that you wish to view by ticket ID: ", tickets);
            
            t = tickets.get(choice);
            t.display();
        }
    }
    
    public void createTickets(double p) {
        for(int i = 0; i < getNumSeats(); ++i) {
            Ticket t = new Ticket(0, p, 0);
            tickets.add(t);
        }
    }
    
    public Ticket findTicket(int id) {
        Ticket t = tickets.get(id);
        return t;        
    }
    
    public void startUp(Scanner reader) {
        int iEID;
        String iName;
        String iDesc;
        String start;
        String end;
        
        iEID = reader.nextInt();
        setEID(iEID);
        reader.nextLine();
        
        iName = reader.nextLine();
        setName(iName);
        
        iDesc = reader.nextLine();
        setDescription(iDesc);
        
        start = reader.nextLine();
        setStartTime(start);
        
        end = reader.nextLine();
        setEndTime(end);
        
        int numTickets;
        numTickets = reader.nextInt();
        reader.nextLine();
        for(int i = 0; i < numTickets; ++i) {
            Ticket t = new Ticket();
            t.startUp(reader);
            tickets.add(t);
        }
    }
    
    public void shutDown(PrintWriter writer) {
        writer.println(getEID());
        writer.println(getName());
        writer.println(getDescription());
        writer.println(getStartTime());
        writer.println(getEndTime());
        writer.println(tickets.size());
        for(int i = 0; i < tickets.size(); ++i) {
            Ticket t = tickets.get(i);
            t.shutDown(writer);
        }
    }
}


