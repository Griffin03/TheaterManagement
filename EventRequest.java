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
public class EventRequest {
    private int erID;
    private String name;
    private String startTime;
    private String endTime;
    private String description;
    private static int ERIDCounter = 1;

    public EventRequest() {
        erID = 0;
        name = "";
        startTime = "";
        endTime = "";
        description = "";
    }
    
    public EventRequest( int id, String n, String start, String end, String desc) {
        erID = id;
        if (erID == 0) {
            setErID(ERIDCounter++);
        }
        setName(n);
        setStartTime(start);
        setEndTime(end);
        setDescription(desc);
    }
    
    /**
     * @return the erID
     */
    public int getErID() {
        return erID;
    }

    /**
     * @param erID the erID to set
     */
    public void setErID(int erID) {
        if(erID >= ERIDCounter) {
            ERIDCounter = (erID + 1);
        }
        this.erID = erID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void display() {
        System.out.println("Event Request id: " + getErID() + "     Event Name: " + getName());
        System.out.println("Start Time: " + getStartTime() + "      End Time: " + getEndTime());
        System.out.println("Description: " + getDescription());
        System.out.println("");
    }    
    
    public void startUp(Scanner reader) {
        
        int iEID;
        String iName;
        String iDesc;
        String start;
        String end;
        
        iEID = reader.nextInt();
        setErID(iEID);
        reader.nextLine();
        
        iName = reader.nextLine();
        setName(iName);
        
        iDesc = reader.nextLine();
        setDescription(iDesc);
        
        start = reader.next();
        setStartTime(start);
        reader.nextLine();
        
        end = reader.next();
        setEndTime(end);
        reader.nextLine();
    }
    
    public void shutDown(PrintWriter writer) {
        writer.println(getErID());
        writer.println(getName());
        writer.println(getDescription());
        writer.println(getStartTime());
        writer.println(getEndTime());
    }
}
