package repositories;

import entities.Client;
import interfaces.IClientRepo;
import java.io.File;
import java.io.IOException;

public class ClientRepo implements IClientRepo {
    private static final int maxClient = 100;
    private static final String FILE_PATH = "repositories/data/client.txt";

    // Method to write the client list to the file
    public void write(Client[] list){
        String[] info = new String[maxClient];
        int count = 0;

        for (Client client : list) {
            if (client != null){
                info[count] = client.toStringClient();
                count++;
            }
        }

        FileIO f = new FileIO();
        f.writeFile(info, FILE_PATH);
    }

    // Method to get the list of all clients from the file
    public Client[] getClientList(){
        FileIO f = new FileIO();
        String[] data = f.readFile(FILE_PATH);
        Client[] list = new Client[maxClient];

        if (data != null){
            int i = 0;
            for (String str : data) {
                if (str != null && !str.trim().isEmpty()) {
                    Client client = new Client().formClient(str);
                    if (client != null) {
                        list[i] = client;
                        i++;
                    }
                }
            }
        }
        return list;
    }

    // Method to add a client to the list and write to the file
    public boolean addClient(Client c){
        Client[] list = this.getClientList();
        boolean flag = false;

        for (int i = 0; i < list.length; i++){
            if (list[i] == null){
                list[i] = c;
                flag = true;
                break;
            }
        }

        if (flag){
            this.write(list);
        } else {
            System.err.println("Error: Client list is full. Cannot add more clients.");
        }

        return flag;
    }

    // Method to remove a client by client ID
    public boolean removeClientByClientId(String id){
        Client[] list = this.getClientList();
        boolean flag = false;

        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getUserId().equals(id)) {
                list[i] = null;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(list);
        } else {
            System.err.println("Error: Client not found with userId: " + id);
        }

        return flag;
    }

    // Method to update a client's profile
    public boolean updateSelfProfile(Client c){
        Client[] list = this.getClientList();
        boolean flag = false;

        // for (Client client : list){
        //     if (client != null && client.getUserId().equals(c.getUserId())){
        //         client = c;
        //         flag = true;
        //         break;
        //     }
        // }
        for (int i = 0; i < list.length; i++){
            if (list[i] != null && list[i].getUserId().equals(c.getUserId())) {
                list[i] = c;
                flag = true;
                break;
            }
        }

        if (flag){
            this.write(list);
        } else {
            System.err.println("Error: Client not found with userId: " + c.getUserId());
        }

        return flag;
    }

    // Method to search for a client by client ID
    public Client searchClientByClientId(String id){
        Client[] list = this.getClientList();

        for (Client client : list) {
            if (client != null && client.getUserId().equals(id)) {
                return client;
            }
        }

        return null;
    }
}
