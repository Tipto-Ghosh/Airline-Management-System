package interfaces;

import java.lang.*;
import entities.*;

public interface IClientRepo {
    
    Client[] getClientList();
    boolean addClient(Client c);
    boolean updateSelfProfile(Client c);
    boolean removeClientByClientId(String id);
    Client searchClientByClientId(String id);
    
}