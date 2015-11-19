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
public class Client extends User {
    private ArrayList<EventRequest> er = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();
    
    Client() {
        super();
    }
    
    Client(final String n, final String p) {
        super(n, p, 0);
    }
    
    @Override
    public void addEventRequest(EventRequest e) {
        er.add(e);
    }
    
    @Override
    public void addEvent(Event e) {
        events.add(e);
    }
    
    public void populate() {
        super.setFirstName("Emily");
        super.setLastName("Gallaher");
    }
    
    @Override
    public void shutDown(PrintWriter writer) {
        writer.println(this.getClass());
        writer.println(getuID());
        writer.println(getUserName());
        writer.println(getFirstName());
        writer.println(getLastName());
        writer.println(getPassword());
        
        writer.println(er.size());
        for(int i = 0; i < er.size(); ++i) {
            EventRequest e = er.get(i);
            writer.println(e.getErID());
        }
        
        writer.println(events.size());
        for(int i = 0; i < events.size(); ++i) {
            Event e = events.get(i);
            writer.println(e.getEID());
        }
    }
}
