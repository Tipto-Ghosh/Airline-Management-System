package repositories;

import java.lang.*;
import entities.*;
import interfaces.*;
import java.io.*;

public class AeroplaneRepo implements IAeroplaneRepo {
    private static final int maxPlane = 100;
    private static final String FILE_PATH = "repositories/data/aeroplane.txt";

    public Aeroplane[] getAllAeroplaneList() {
        FileIO f = new FileIO();
        String[] data = f.readFile(FILE_PATH);
        Aeroplane aeroplaneTemplate = new Aeroplane();
        Aeroplane[] aeroplaneList = new Aeroplane[maxPlane];

        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && !data[i].isEmpty()) {
                aeroplaneList[i] = aeroplaneTemplate.formAeroplane(data[i]);
            }
        }
        return aeroplaneList;
    }

    public void write(Aeroplane[] aeroplaneList) {
        String[] aeroInfo = new String[maxPlane];

        for (int i = 0; i < maxPlane; i++) {
            if (aeroplaneList[i] != null) {
                aeroInfo[i] = aeroplaneList[i].toStringAeroplane();
            }
        }

        FileIO f = new FileIO();
        f.writeFile(aeroInfo, FILE_PATH);
    }

    public boolean addAeroplane(Aeroplane a) {
        Aeroplane[] aeroplaneList = this.getAllAeroplaneList();
        boolean flag = false;

        for (int i = 0; i < aeroplaneList.length; i++) {
            if (aeroplaneList[i] == null) {
                aeroplaneList[i] = a;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(aeroplaneList);
            System.out.println("Aeroplane added successfully.");
        } else {
            System.out.println("Failed to add aeroplane. No space available.");
        }

        return flag;
    }

    public boolean removeAeroplaneByAeroplaneId(String aeroplaneId) {
        Aeroplane[] aeroplaneList = this.getAllAeroplaneList();
        boolean flag = false;

        for (int i = 0; i < aeroplaneList.length; i++) {
            if (aeroplaneList[i] != null && aeroplaneList[i].getAeroplaneId().equals(aeroplaneId)){
                aeroplaneList[i] = null;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(aeroplaneList);
            System.out.println("Aeroplane removed successfully.");
        } else {
            System.out.println("Aeroplane not found.");
        }

        return flag;
    }

    public boolean updateAeroplaneInfo(Aeroplane a){
        Aeroplane[] aeroplaneList = this.getAllAeroplaneList();
        boolean flag = false;

        for (int i = 0; i < aeroplaneList.length; i++) {
            if (aeroplaneList[i] != null && aeroplaneList[i].getAeroplaneId().equals(a.getAeroplaneId())){
                aeroplaneList[i] = a;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(aeroplaneList);
            System.out.println("Aeroplane information updated successfully.");
        } else {
            System.out.println("Aeroplane not found.");
        }

        return flag;
    }

    public Aeroplane searchAeroplaneByAeroplaneId(String aeroplaneId) {
        Aeroplane[] aeroplaneList = this.getAllAeroplaneList();

        for (Aeroplane aeroplane : aeroplaneList) {
            if (aeroplane != null && aeroplane.getAeroplaneId().equals(aeroplaneId)){
                return aeroplane;
            }
        }

        
        return null;
    }
}
