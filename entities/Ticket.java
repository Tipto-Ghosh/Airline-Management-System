package entities;

import java.lang.*;

public class Ticket {
   private String ticketId, aeroplaneId, flightId, clientId;
   private int numberOfTicket, totalAmount;

   public Ticket() {}

   public Ticket(String ticketId, String aeroplaneId, String flightId, String clientId, int numberOfTicket, int totalAmount) {
       this.ticketId = ticketId;
       this.aeroplaneId = aeroplaneId;
       this.flightId = flightId;
       this.clientId = clientId;
       this.numberOfTicket = numberOfTicket;
       this.totalAmount = totalAmount;
   }

   public void setTicketId(String ticketId) {
       this.ticketId = ticketId;
   }

   public void setAeroplaneId(String aeroplaneId) {
       this.aeroplaneId = aeroplaneId;
   }

   public void setFlightId(String flightId) {
       this.flightId = flightId;
   }

   public void setClientId(String clientId) {
       this.clientId = clientId;
   }

   public void setNumberOfTicket(int numberOfTicket) {
       this.numberOfTicket = numberOfTicket;
   }

   public void setTotalAmount(int amount) {
       this.totalAmount = amount;
   }

   public String getTicketId() {
       return this.ticketId;
   }

   public String getAeroplaneId() {
       return this.aeroplaneId;
   }

   public String getFlightId() {
       return this.flightId;
   }

   public String getClientId() {
       return this.clientId;
   }

   public int getNumberOfTicket() {
       return this.numberOfTicket;
   }

   public int getTotalAmount() {
       return this.totalAmount;
   }

   public String toStringTicket() {
     String info = this.ticketId + "," + this.aeroplaneId + "," + this.flightId + "," + this.clientId + "," + this.numberOfTicket + "," + this.totalAmount;  
     return info;
   }

   public Ticket fromString(String str) {
       String[] info = str.split(",");
       

       Ticket t = new Ticket();
       t.setAeroplaneId(info[0]);
       t.setAeroplaneId(info[1]);
       t.setFlightId(info[2]);
       t.setClientId(info[3]);
       t.setNumberOfTicket(Integer.parseInt(info[4]));
       t.setTotalAmount(Integer.parseInt(info[5]));

     return t;  
   }
}
