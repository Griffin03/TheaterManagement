/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TheaterManagement;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;
/**
 *
 * @author Griffin2013
 */
public class Ticket {
    private int tid;
    private double price;
    private static int TIDCounter = 1;
    private boolean owned;
    private User owner;
    
    // default constructor
    public Ticket() {
        setTID(0);
        setPrice(0);
        setOwned(false);
    }
    
    //  Constructor
    public Ticket(int id, double p, int owner) {
        setTID(id);
        if (id == 0) {
            setTID(TIDCounter++);
        }
        setPrice(p);
        if(owner > 0) {
            owned = false;
        }
    }
    
    //  *****   Sets and Gets   *****
    
    public void setTID(int id) {
        tid = id;
    }
    
    public int getTID() {
        return tid;
    }
    
    public void setPrice(double p) {
        price = p;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setOwned(boolean b) {
        owned = b;
    }
    
    public boolean getOwned() {
        return owned;
    }
    
    public void setOwner(User u) {
        owner = u;
    }
    
    public User getOwner() {
        return owner;
    }
    
    public String getFormattedPrice() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        return currency.format(price);
    }
    
    public void display() {
        
        if(owned == true) {
            System.out.println("Ticket ID: " + getTID() + "     Ticket price: " + getFormattedPrice());
            System.out.println("Owned by: " + getOwner().getFirstName() + " " + 
                getOwner().getLastName());
            System.out.println();
        }
        else {
            System.out.println("Ticket ID: " + getTID() + "     Ticket price: " + getFormattedPrice());
            System.out.println();
        }
    }
    
    public void refundTicket() {
            if(owned == false)
                System.out.println("Ticket ID: " + getTID() + "     "
                + getFormattedPrice() + " has been refunded to the user.");
    }
    
    public void removeOwner() {
        setOwned(false);
    }
    
    public void startUp(Scanner reader) {
        int iID;
        double iPrice;
        
        iID = reader.nextInt();
        setTID(iID);
        reader.nextLine();
        
        iPrice = reader.nextDouble();
        setPrice(iPrice);
        reader.nextLine();
    }
    
    public final void shutDown(PrintWriter writer) {
        writer.println(getTID());
        writer.println(getPrice());
    }
    
}
