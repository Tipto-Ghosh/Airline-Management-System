package interfaces;

import java.lang.*;
import entities.*;

public interface IAeroplaneRepo {
    boolean addAeroplane(Aeroplane a);
    boolean removeAeroplaneByAeroplaneId(String aeroplaneId);
    boolean updateAeroplaneInfo(Aeroplane a);
    Aeroplane searchAeroplaneByAeroplaneId(String aeroplaneId);
    Aeroplane[] getAllAeroplaneList();
}