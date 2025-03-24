package repositories;

import java.lang.*;
import entities.*;
import interfaces.*;
import java.io.*;

public class TicketRepo implements ITicketRepo {
    private static final int maxTickets = 100;
    private static final String FILE_PATH = "repositories/data/ticket.txt";

    public Ticket[] getTicketList() {
        FileIO f = new FileIO();
        String[] info = f.readFile(FILE_PATH);
        Ticket[] ticketList = new Ticket[maxTickets];
        Ticket ticketTemplate = new Ticket();

        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && !info[i].isEmpty()) {
                ticketList[i] = ticketTemplate.fromString(info[i]);
            }
        }
        return ticketList;
    }

    public void write(Ticket[] ticketList) {
        String[] info = new String[maxTickets];

        for (int i = 0; i < maxTickets; i++) {
            if (ticketList[i] != null) {
                info[i] = ticketList[i].toStringTicket();
            }
        }

        FileIO f = new FileIO();
        f.writeFile(info, FILE_PATH);
    }

    public boolean addTicket(Ticket t) {
        Ticket[] ticketList = this.getTicketList();
        boolean flag = false;

        for (int i = 0; i < ticketList.length; i++) {
            if (ticketList[i] == null) {
                ticketList[i] = t;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(ticketList);
            System.out.println("Ticket added successfully.");
        } else {
            System.out.println("Failed to add ticket. No space available.");
        }

        return flag;
    }

    public boolean removeTicketByTicketId(String id) {
        Ticket[] ticketList = this.getTicketList();
        boolean flag = false;

        for (int i = 0; i < ticketList.length; i++) {
            if (ticketList[i] != null && ticketList[i].getTicketId().equals(id)) {
                ticketList[i] = null;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(ticketList);
            System.out.println("Ticket removed successfully.");
        } else {
            System.out.println("Ticket not found.");
        }

        return flag;
    }

    public Ticket searchTicketByTicketId(String ticketId) {
        Ticket[] ticketList = this.getTicketList();

        for (Ticket ticket : ticketList) {
            if (ticket != null && ticket.getTicketId().equals(ticketId)) {
                return ticket;
            }
        }
        System.out.println("Ticket not found.");
        return null;
    }

    public Ticket[] searchTicketByAeroplaneId(String aeroplaneId) {
        Ticket[] ticketList = this.getTicketList();
        Ticket[] bookedTicket = new Ticket[maxTickets];
        int j = 0;

        for (Ticket ticket : ticketList) {
            if (ticket != null && ticket.getAeroplaneId().equals(aeroplaneId)) {
                bookedTicket[j] = ticket;
                j++;
            }
        }

        if (j == 0) {
            System.out.println("No tickets found for the given aeroplane ID.");
        }

        return bookedTicket;
    }

    public Ticket[] searchTicketByFlightId(String flightId) {
        Ticket[] ticketList = this.getTicketList();
        Ticket[] list = new Ticket[maxTickets];
        int j = 0;

        for (Ticket ticket : ticketList) {
            if (ticket != null && ticket.getFlightId().equals(flightId)) {
                list[j] = ticket;
                j++;
            }
        }

        if (j == 0) {
            System.out.println("No tickets found for the given flight ID.");
        }

        return list;
    }

    public Ticket[] searchTicketByClientId(String clientId) {
        Ticket[] ticketList = this.getTicketList();
        Ticket[] list = new Ticket[maxTickets];
        int j = 0;

        for (Ticket ticket : ticketList) {
            if (ticket != null && ticket.getClientId().equals(clientId)) {
                list[j] = ticket;
                j++;
            }
        }

        return list;
    }

    public boolean updateTicket(Ticket t) {
        Ticket[] ticketList = this.getTicketList();
        boolean flag = false;

        for (int i = 0; i < ticketList.length; i++) {
            if (ticketList[i] != null && ticketList[i].getTicketId().equals(t.getTicketId())) {
                ticketList[i] = t;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(ticketList);
            System.out.println("Ticket updated successfully.");
        } else {
            System.out.println("Ticket not found.");
        }

        return flag;
    }
}
