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
public class TheaterInformation {

    private String name;
    private String address;
    private String city;
    private String state;
    private int zip;
    
    public TheaterInformation() {
        name = "St. Louis Theater";
        address = "123 Theater Drive";
        city = "St. Louis";
        state = "MO";
        zip = 63123;
    }
    
    public void displayTheaterInfo() {
        System.out.println(name);
        System.out.println(address);
        System.out.println(city + ", " + state + " " + zip);
        System.out.println("");
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String addr) {
        address = addr;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
    
    public void startUp(Scanner reader) {
        String iName;
        iName = reader.nextLine();
        setName(iName);
        
        String iAddress;
        iAddress = reader.nextLine();
        setAddress(iAddress);
        
        String icity;
        icity = reader.nextLine();
        setCity(icity);
        
        String istate;
        istate = reader.nextLine();
        setState(istate);
        
        int izip;
        izip = reader.nextInt();
        setZip(izip);
        reader.nextLine();
    }
    
    public void shutDown(PrintWriter writer) {
        writer.println(getName());
        writer.println(getAddress());
        writer.println(getCity());
        writer.println(getState());
        writer.println(getZip());
    }
}