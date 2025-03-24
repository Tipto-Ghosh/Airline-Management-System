package entities;

import java.lang.*;

public class Aeroplane {
    private String aeroplaneId;
    private String aeroplaneName;
    private String category;
    private int totalSeats;
    private int pricePerSeat;
    private int availableSeats;
    private int bookedSeat;

    public Aeroplane(){

    }

    public Aeroplane(String aeroplaneId, String aeroplaneName, String category, int totalSeats, int pricePerSeat, int availableSeats, int bookedSeat){
        this.aeroplaneId = aeroplaneId;
        this.aeroplaneName = aeroplaneName;
        this.category = category;
        this.totalSeats = totalSeats;
        this.pricePerSeat = pricePerSeat;
        this.availableSeats = availableSeats;
        this.bookedSeat = bookedSeat;
    }

    public void setAeroplaneId(String aeroplaneId){
        this.aeroplaneId = aeroplaneId;
    }

    public void setAeroplaneName(String aeroplaneName){
        this.aeroplaneName = aeroplaneName;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setTotalSeats(int totalSeats){
        this.totalSeats = totalSeats;
    }

    public void setPricePerSeat(int price){
        this.pricePerSeat = price;
    }

    public void setAvailableSeats(int seats){
        this.availableSeats = seats;
    }

    public void setBookedSeats(int seats){
        this.bookedSeat = seats;
    }

    public String getAeroplaneId(){
        return this.aeroplaneId;
    }

    public String getAeroplaneName(){
        return this.aeroplaneName;
    }

    public String getCategory(){
        return this.category;
    }

    public int getTotalSeats(){
        return this.totalSeats;
    }

    public int getPricePerSeat(){
        return this.pricePerSeat;
    }

    public int getAvailableSeats(){
        return this.availableSeats;
    }

    public int getBookedSeats(){
        return this.bookedSeat;
    }

    public String toStringAeroplane() {
        String info = this.aeroplaneId + "," + this.aeroplaneName + "," + this.category + "," + this.totalSeats + "," + this.pricePerSeat + "," + this.availableSeats + "," + this.bookedSeat;
      return info; 
    }

    public Aeroplane formAeroplane(String str) {
        String[] info = str.split(",");
        Aeroplane a = new Aeroplane(info[0], info[1], info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4]), Integer.parseInt(info[5]), Integer.parseInt(info[6]));
        return a;
    }
}
