package interfaces;

import java.lang.*;

import entities.*;

public interface IFlightRepo {
   
   boolean addFlight(Flight flight);
   boolean updateFlight(Flight flight);
   boolean removeFlightById(String flightId);
   Flight[] getFlightList();
   Flight searchFlightByFlightId(String flightId);

} 