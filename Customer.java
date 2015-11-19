/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TheaterManagement;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Griffin2013
 */
public class Customer extends User {
    private ArrayList<Ticket> tickets = new ArrayList<>();
    
    Customer() {
        super();
    }
    
    Customer(final String n, final String p){
        super(n, p, 0);
    }
    
    public final void displayTickets() {
        Ticket t;
        for( int i = 0; i < tickets.size(); ++i) {
            t = tickets.get(i);
            t.display();
        }
    }
    
    @Override
    public boolean checkTickets() {
        if(tickets.size() > 0)
            return true;
        else
            return false;
    }
    
    @Override
    public Ticket findTicket(int tid) {
        Ticket t;
        int i = 0;
        boolean found = false;
        
        while(i < tickets.size() && !found) {
            t = tickets.get(i);
            if (t.getTID() ==  tid) {
                found = true;
            }
            else
                ++i;
        }
        
        if(found)
            t = tickets.get(i);
        else
            t = null;
        
        return t;
    }
    
    @Override
    public void addTicket(Ticket t) {
        tickets.add(t);
        t.setOwned(true);
    }
    
    public boolean removeTicket(Ticket t) {
        boolean removed = false;
        removed = tickets.remove(t);
        
        if(removed = false)
            System.out.println("The ticket was not found in the system");
        
        return removed;
    }
    public void populate() {
        super.setFirstName("Joe");
        super.setLastName("Nash");
    }
    
    @Override
    public void shutDown(PrintWriter writer) {
        writer.println(this.getClass());
        writer.println(getuID());
        writer.println(getUserName());
        writer.println(getFirstName());
        writer.println(getLastName());
        writer.println(getPassword());
        
        writer.println(tickets.size());
        for(int i = 0; i < tickets.size(); ++i) {
            Ticket t = tickets.get(i);
            writer.println(t.getTID());
        }
    } 
}
