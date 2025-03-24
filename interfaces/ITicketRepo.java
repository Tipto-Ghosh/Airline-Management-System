package interfaces;

import java.lang.*;
import entities.*;

public interface ITicketRepo {

    Ticket searchTicketByTicketId(String ticketId);
    
    Ticket[] searchTicketByAeroplaneId(String aeroplaneId);
    Ticket[] searchTicketByFlightId(String flightId);
    Ticket[] searchTicketByClientId(String clientId);
    
    boolean addTicket(Ticket t);
    boolean removeTicketByTicketId(String ticketId);
    boolean updateTicket(Ticket t);

    Ticket[] getTicketList();
}