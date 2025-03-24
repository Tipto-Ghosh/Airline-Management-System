package entities;

import java.lang.*;

public class Payment {
    private String paymentId;
    private String ticketId;
    private String clientId;
    private String date;
    private int amount;

    public Payment(){

    }

    public Payment(String paymentId, String ticketId, String clientId, String date, int amount){
        this.paymentId = paymentId;
        this.ticketId = ticketId;
        this.clientId = clientId;
        this.date = date;
        this.amount = amount;
    }

    public void setPaymentId(String paymentId){
        this.paymentId = paymentId;
    }

    public void setTicketId(String ticketId){
        this.ticketId = ticketId;
    }

    public void setClientId(String clientId){
        this.clientId = clientId;
    }

    public void setPaymentDate(String date){
        this.date = date;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public String getPaymentId(){
        return this.paymentId;
    }

    public String getTicketId(){
        return this.ticketId;
    }

    public String getClientId(){
        return this.clientId;
    }

    public String getPaymentDate(){
        return this.date;
    }

    public int getAmount(){
        return this.amount;
    }

    public String toStringPayment(){
        String info = this.paymentId + "," + this.ticketId + "," + this.clientId + "," + this.amount + "," + this.date;
      return info;  
    }

    public Payment fromString(String str) {
        String[] info = str.split(",");
        Payment p = new Payment(info[0], info[1], info[2], info[4], Integer.parseInt(info[3]));
        return p;
    }
}
