package repositories;

import entities.*;
import java.io.*;
import interfaces.*;

public class FlightRepo implements IFlightRepo {

    private static final int maxFlight = 100;
    private static final String FILE_PATH = "repositories/data/flight.txt";

    private void write(Flight[] flightList) {
        String[] info = new String[maxFlight];

        for (int i = 0; i < maxFlight; i++) {
            if (flightList[i] != null) {
                info[i] = flightList[i].toStringFlight();
            }
        }

        FileIO f = new FileIO();
        f.writeFile(info, FILE_PATH);
    }

    public Flight[] getFlightList() {
        FileIO f = new FileIO();
        String[] info = f.readFile(FILE_PATH);

        Flight[] list = new Flight[maxFlight];
        Flight flightTemplate = new Flight();

        for (int i = 0; i < info.length; i++) {
            if (info[i] != null && !info[i].isEmpty()) {
                list[i] = flightTemplate.fromString(info[i]);
            }
        }

        return list;
    }

    public boolean addFlight(Flight flight) {
        Flight[] list = this.getFlightList();
        boolean flag = false;

        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = flight;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(list);
        }

        return flag;
    }

    public boolean updateFlight(Flight flight) {
        Flight[] list = this.getFlightList();
        boolean flag = false;

        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getFlightId().equals(flight.getFlightId())) {
                list[i] = flight;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(list);
        }

        return flag;
    }

    public boolean removeFlightById(String flightId) {
        Flight[] list = this.getFlightList();
        boolean flag = false;

        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getFlightId().equals(flightId)) {
                list[i] = null;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(list);
        }

        return flag;
    }

    public Flight searchFlightByFlightId(String flightId) {
        Flight[] list = this.getFlightList();

        for (Flight flight : list) {
            if (flight != null && flight.getFlightId().equals(flightId)) {
                return flight;
            }
        }
        return null;
    }

    public Flight[] getFlightsByDestination(String from, String to) {
        Flight[] list = this.getFlightList();
        Flight[] desiredList = new Flight[maxFlight];
        int j = 0;

        for (Flight flight : list) {
            if (flight != null && flight.getFromLocation().equals(from) && flight.getToLocation().equals(to)) {
                desiredList[j] = flight;
                j++;
            }
        }

        return desiredList;
    }
}
