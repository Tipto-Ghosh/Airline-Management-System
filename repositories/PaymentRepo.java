package repositories;

import java.lang.*;
import entities.*;
import interfaces.*;
import java.io.*;

public class PaymentRepo implements IPaymentRepo {
    private static final int maxPayment = 100;
    private static final String FILE_PATH = "repositories/data/payment.txt";

    public void write(Payment[] paymentList){
        String[] list = new String[maxPayment];

        for (int i = 0; i < maxPayment; i++){
            if (paymentList[i] != null){
                list[i] = paymentList[i].toStringPayment();
            }
        }

        FileIO fio = new FileIO();
        fio.writeFile(list, FILE_PATH);
    }

    public Payment[] getPaymentList(){
        FileIO f = new FileIO();
        String[] info = f.readFile(FILE_PATH);

        Payment p = new Payment();
        Payment[] list = new Payment[maxPayment];

        for (int i = 0; i < info.length; i++){
            if (info[i] != null && !info[i].isEmpty()) {
                list[i] = p.fromString(info[i]);
            }
        }

        return list;
    }

    public boolean addPayment(Payment payment) {
        Payment[] list = this.getPaymentList();
        boolean flag = false;

        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = payment;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(list);
            System.out.println("Payment added successfully.");
        } else {
            System.out.println("Failed to add payment. No space available.");
        }

        return flag;
    }

    public boolean removePaymentByPaymentId(String paymentId) {
        Payment[] list = this.getPaymentList();
        boolean flag = false;

        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getPaymentId().equals(paymentId)) {
                list[i] = null;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(list);
            System.out.println("Payment removed successfully.");
        } else {
            System.out.println("Payment not found.");
        }

        return flag;
    }

    public boolean updatePayment(Payment p) {
        Payment[] list = this.getPaymentList();
        boolean flag = false;

        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getPaymentId().equals(p.getPaymentId())) {
                list[i] = p;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.write(list);
            System.out.println("Payment updated successfully.");
        } else {
            System.out.println("Payment not found.");
        }

        return flag;
    }

    public Payment searchPaymentByPaymentId(String paymentId) {
        Payment[] list = this.getPaymentList();

        for (Payment payment : list) {
            if (payment != null && payment.getPaymentId().equals(paymentId)) {
                return payment;
            }
        }

        System.out.println("Payment not found.");
        return null;
    }

    public Payment[] searchPaymentByTicketId(String ticketId) {
        Payment[] list = this.getPaymentList();
        Payment[] sendList = new Payment[maxPayment];
        int j = 0;

        for (Payment payment : list) {
            if (payment != null && payment.getTicketId().equals(ticketId)) {
                sendList[j] = payment;
                j++;
            }
        }

        return sendList;
    }

    public Payment[] searchPaymentByUserId(String clientId) {
        Payment[] list = this.getPaymentList();
        Payment[] sendList = new Payment[maxPayment];
        int j = 0;

        for (Payment payment : list) {
            if (payment != null && payment.getClientId().equals(clientId)) {
                sendList[j] = payment;
                j++;
            }
        }

        return sendList;
    }

   
    public Payment[] seacrchPaymentByUserId(String clientId) {
        Payment[] paymentList = this.getPaymentList(); // Got all the List
        Payment[] sendList = new Payment[100];
        int i = 0;
        for(Payment ele : paymentList){
           if(ele != null){
            if(ele.getClientId().equals(clientId)){
                sendList[i] = ele;
                i++;
            }
           }
        }
        return sendList;
    }
}
