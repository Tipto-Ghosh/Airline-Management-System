package interfaces;

import java.lang.*;
import entities.*;

public interface IPaymentRepo {
    
    Payment searchPaymentByPaymentId(String paymentId);
    Payment[] searchPaymentByTicketId(String ticketId);
    Payment[] seacrchPaymentByUserId(String clientId);
    Payment[] getPaymentList();
    
    boolean addPayment(Payment payment);
    boolean removePaymentByPaymentId(String paymentId);
    boolean updatePayment(Payment p);

}