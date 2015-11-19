/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TheaterManagement;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Griffin2013
 */
public class Theater {
    
    private TheaterInformation ti;
    private Exchange exchange;
    private CurrentUser cu;
    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<EventRequest> eventRequest = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    
    public Theater(String name, CurrentUser CU) {
        exchange = new Exchange();
        ti = new TheaterInformation();
        cu = CU;
        
        try{
            Scanner sc = new Scanner(new File("file.txt"));
            startUp(sc);
        } catch (FileNotFoundException e) {
            System.out.println("'file.txt' was not found.");
        }       
    }
    
    public void displayTheaterInfo() {
        ti.displayTheaterInfo();
    }
    
    public final void browseEvents() {
        System.out.println("*****    Browsing Events     *****");
        System.out.println();
        
        Scanner sc = new Scanner(System.in);
        Validator v = new Validator();
        Event e;
        int choice = 0;
        
        if(events.size() > 0) {
            listEvents();
            System.out.println();
            System.out.println();
            
            choice = v.getEvent(sc, "Choose the event that you wish to view by event ID: ", events);
            e = events.get(choice);
            e.browseTickets();
        }
    }
    
    public final void listEvents() {
        
        Event e;
        for(int i = 0; i < events.size(); ++i) {
            e = events.get(i);
            e.display();
        }
    }
    
    public final void listEventRequests() {
        
        EventRequest e;
        for(int i = 0; i < eventRequest.size(); ++i) {
            e = eventRequest.get(i);
            e.display();
        }
    }
    
    public final Event findEvent(int eid) {
        Event e = events.get(eid);
        
        return e;
    }
    
    public final void buyTicket() {
        Ticket t;
        Event e;
        Scanner sc = new Scanner(System.in);
        Validator v =  new Validator();
        int choice = 0;
        
        if (events.size() > 0) {
            listEvents();
            
            System.out.println();
            System.out.println();
            choice = v.getEvent(sc, "Choose the event you wish to buy tickets for by event ID:  ", events);
            e = events.get(choice);
            t = e.buyTicket();
            
            t.setOwner(cu.getCurrentUser());
            t.setOwned(true);
            cu.getCurrentUser().addTicket(t);
            System.out.println("Thank you for your purchase of: ");
            t.display();
            System.out.println("");
        }
        else
            System.out.println("There are no events listed in the system.");
    }
    
    public void sellTicket() {
        int choice = 0;
        Scanner sc =  new Scanner(System.in);
        
        if (cu != null) {
            Ticket t;
            
            if(cu.getCurrentUser().checkTickets()) {
                cu.getCurrentUser().displayTickets();
                System.out.println("Which ticket would you like to sell by ID? ");
                choice = sc.nextInt();
                sc.nextLine();
                
                t = cu.getCurrentUser().findTicket(choice);
                
                if(t != null) {
                    double sellPrice = 0;
                    
                    System.out.print("How much would you like to sell the ticket for? $");
                    sellPrice = sc.nextDouble();
                    sc.nextLine();
                    
                    exchange.sellTicket(t, sellPrice);
                }
                else
                    System.out.println("That ticket was not found in the system.");
            }
            else
                System.out.println("This user does not own any tickets.");
        }
    }
    
    public void requestEvent() {
        Scanner sc = new Scanner(System.in);
        Validator v = new Validator();
        int id = 0;
        String name = "";
        String start = "";
        String end = "";
        String description = "";
        
        System.out.println("");
        System.out.println("*****   Populating an Event Request    *****");
        System.out.println("");
        System.out.print("Enter a name for the event: ");
        name = sc.nextLine();
        start = v.getTime(sc,"Enter a start time for the event (hh:mm): ");
        end = v.getTime(sc, "Enter an end time for the event (hh:mm): ");
        System.out.print("Enter a description of the event: ");
        description = sc.nextLine();
        
        EventRequest e = new EventRequest(id, name, start, end, description);
        eventRequest.add(e);
        
        System.out.println("");
        System.out.println("Your request has been saved to the system.");
        System.out.println("");
    }
    
    public void approveEvent() {
        EventRequest er;
        int choice = 0;
        double price = 0;
        Validator v = new Validator();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("*****   Booking an Event    *****");
        System.out.println("");
        
        if(eventRequest.size() > 0) {
            listEventRequests();
            System.out.println("");
            choice = v.getRequest(sc, "Choose the event request that you would like to approve by ID: ", eventRequest);
            er = eventRequest.get(choice);
            
            int numSeats = 0;
            numSeats = v.getNum(sc, "Enter how many tickets you would like to create for this event: ");
            Event e = new Event(0, er.getName(), numSeats, er.getStartTime(), er.getEndTime(), er.getDescription());
            events.add(e);
            price = v.getPrice(sc, "How much would you like each ticket to cost: $");
            e.createTickets(price);
            
            eventRequest.remove(er);
        }
        else
            System.out.println("There were no event requests found in the system.");
    }
    
    public User findUser(String u) {
        User foundUser = null;
        boolean found = false;
        
        if(!users.isEmpty()) {
            User user;
            
            for(int i = 0; i < users.size(); ++i) {
                user = users.get(i);
                if(u.equals(user.getUserName())) {
                    foundUser = user;
                    found = true;
                }
            }
        }
        if(found) {
            return foundUser;
        }
        else
            return null;
    }
    
    public final EventRequest findEventRequest(int erid) {
        EventRequest foundRequest = null;
        boolean found = false;
        EventRequest er;
        
        for(int i = 0; i < eventRequest.size(); ++i) {
            er = eventRequest.get(i);
            if(erid == er.getErID()) {
                foundRequest = er;
                found = true;
            }
        }
        if(found) {
            return foundRequest;
        }
        else
            return null;
    }
    
    public void createUsers() {
        // Creating Test Users
        Customer cust = new Customer("customer", "cust");
        cust.populate();
        users.add(cust);
        Employee admin = new Employee("admin", "admin");
        admin.populate();
        users.add(admin);
        Client client = new Client("client","client");
        client.populate();
        users.add(client);
    }
    
    public void startUp(Scanner reader) {
        ti.startUp(reader);
        int numEventRequests = 0;
        numEventRequests = reader.nextInt();
        reader.nextLine();
        
        for(int i = 0; i < numEventRequests; ++i) {
            EventRequest er = new EventRequest();
            er.startUp(reader);
            eventRequest.add(er);
        }
        
        int numEvents = 0;
        numEvents = reader.nextInt();
        reader.nextLine();
        
        for(int i = 0; i < numEvents; ++i) {
            Event e = new Event();
            e.startUp(reader);
            events.add(e);
        }
        
        int numUsers = 0;
        numUsers = reader.nextInt();
        reader.nextLine();
        for(int i = 0; i < numUsers; ++i) {
            String userType = "";
            userType = reader.next();
            reader.nextLine();
            User u = new User();
            
            if (userType.equals("Client")) {
                u = new Client();
                u.startUp(reader);
                int numClientEventRequests = 0;
                numClientEventRequests = reader.nextInt();
                reader.nextLine();
                for(int y = 0; y < numClientEventRequests; ++y) {
                    int eventRequestID = 0;
                    eventRequestID = reader.nextInt();
                    reader.nextLine();
                    EventRequest clientER = findEventRequest(eventRequestID);
                    u.addEventRequest(clientER);
                }
                
                int numClientEvents = 0;
                numClientEvents = reader.nextInt();
                reader.nextLine();
                for(int y = 0; y < numClientEvents; ++y) {
                    int eventID = 0;
                    eventID = reader.nextInt();
                    reader.nextLine();
                    Event clientEvent = findEvent(eventID);
                    u.addEvent(clientEvent);
                }
            }
            
            if(userType.equals("Employee")) {
                u = new Employee();
                u.startUp(reader);
                int numEmployeeEvents = 0;
                numEmployeeEvents = reader.nextInt();
                reader.nextLine();
                
                for(int y = 0; y < numEmployeeEvents; ++y) {
                    int eventID = 0;
                    eventID = reader.nextInt();
                    reader.nextLine();
                    Event empEvent = findEvent(eventID);
                    u.addEvent(empEvent);
                }
            }
            
            if(userType.equals("Customer")) {
                u = new Customer();
                u.startUp(reader);
                int numCustTickets = 0;
                numCustTickets = reader.nextInt();
                reader.nextLine();
                
                for(int y = 0; y < numCustTickets; ++y) {
                    
                    for(int x = 0; x < events.size(); ++x) {
                        int ticketID = 0;
                        ticketID = reader.nextInt();
                        reader.nextLine();
                        Ticket custTicket = events.get(x).findTicket(ticketID);
                        u.addTicket(custTicket);
                    }
                }
            }
            
            users.add(u);
        }
    }
    
    
    public void shutDown() throws IOException{
        PrintWriter writer = new PrintWriter("file.txt");
        
        ti.shutDown(writer);
        
        writer.println(eventRequest.size());
        for(int i = 0; i < eventRequest.size(); ++i) {
            EventRequest er = eventRequest.get(i);
            er.shutDown(writer);
        }
        
        writer.println(events.size());
        for(int i = 0; i < events.size(); ++i) {
            Event e = events.get(i);
            e.shutDown(writer);
        }
        
        writer.println(users.size());
        for(int i = 0; i < users.size(); ++i) {
            User u = users.get(i);
            u.shutDown(writer);
        }
        
        writer.close();
    }
}
