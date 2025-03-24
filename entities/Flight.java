package entities;

import java.lang.*;

public class Flight {
    private String flightId, aeroPlaneId, fromLocation, toLocation, date;
    private int durationInMinutes;

    public Flight() {}

    public Flight(String flightId, String aeroPlaneId, String fromLocation, String toLocation, String date, int durationInMinutes) {
        this.flightId = flightId;
        this.aeroPlaneId = aeroPlaneId;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.date = date;
        this.durationInMinutes = durationInMinutes;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setAeroplaneId(String aeroplaneId) {
        this.aeroPlaneId = aeroplaneId;
    }

    public void setFromLocation(String location) {
        this.fromLocation = location;
    }

    public void setToLocation(String location) {
        this.toLocation = location;
    }

    public void setDateOfFlight(String date) {
        this.date = date;
    }

    public void setDurationInMinute(int duration) {
        this.durationInMinutes = duration;
    }

    public String getFlightId() {
        return this.flightId;
    }

    public String getAeroplaneId() {
        return this.aeroPlaneId;
    }

    public String getFromLocation() {
        return this.fromLocation;
    }

    public String getToLocation() {
        return this.toLocation;
    }

    public String getDateOfFlight() {
        return this.date;
    }

    public int getDurationInMinute() {
        return this.durationInMinutes;
    }

    public String toStringFlight() {
        return this.flightId + "," + this.aeroPlaneId + "," + this.fromLocation + "," + this.toLocation + "," + this.date + "," + this.durationInMinutes + "\n";
    }

    public Flight fromString(String str) {
        String[] info = str.split(",");

        Flight f = new Flight();
       
        f.setFlightId(info[0]);
        f.setAeroplaneId(info[1]);
        f.setFromLocation(info[2]);
        f.setToLocation(info[3]);
        f.setDateOfFlight(info[4]);
        f.setDurationInMinute(Integer.parseInt(info[5]));


        return f;
    }
}
