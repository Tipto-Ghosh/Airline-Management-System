package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repositories.*;
import entities.*;
import interfaces.*;

public class EmployeeFrame extends JFrame implements ActionListener {

    // Store user info
    User user;

    // Create the main menu bar
    JMenuBar mainMenuBar;

    // Create all the JMenus of the main menu bar
    JMenu ticketServiceMenu, paymentServiceMenu, aeroplaneServiceMenu, flightServiceMenu, updateSelfMenu, clientServiceMenu, exitMenu; 

    // Menu items for ticketServiceMenu
    JMenuItem sellTicketItem, returnTicketItem, viewTicketItem; 

    // Menu items for paymentServiceMenu
    JMenuItem paymentForTicketItem, viewPaymentList;

    // Menu items for aeroplaneServiceMenu
    JMenuItem addAeroplaneItem, removeAeroplaneItem, updateAeroplaneItem, viewAeroplaneListItem;

    // Menu items for flightServiceMenu
    JMenuItem addFlightItem, removeFlightItem, updateFlightItem, viewFlightListItem;

    // Menu items for updateSelfMenu
    JMenuItem updateSelfProfileItem, updateSelfPasswordItem;

    // Menu items for clientServiceMenu
    JMenuItem addClientItem, updateClientItem, removeClientItem, viewClientListItem;

    // Menu item for exitMenu
    JMenuItem exitItem; 

    // Create the picture
    ImageIcon image = new ImageIcon("Icons\\employeeImage.jpg");

    // Create a Font for all the menu items
    Font font = new Font("Mv Boli", Font.BOLD, 15);

    // Constructor of the frame
    public EmployeeFrame(User user) {
        // Save the user info
        this.user = user;

        // Initialize all the menu items for ticketServiceMenu
        sellTicketItem = new JMenuItem("Sell Ticket");
        sellTicketItem.setForeground(Color.BLUE);
        sellTicketItem.setFont(font);
        sellTicketItem.addActionListener(this);

        returnTicketItem = new JMenuItem("Return Tickets");
        returnTicketItem.setForeground(Color.BLUE);
        returnTicketItem.setFont(font);
        returnTicketItem.addActionListener(this);
        
        viewTicketItem = new JMenuItem("View Ticket List");
        viewTicketItem.setForeground(Color.BLUE);
        viewTicketItem.setFont(font);
        viewTicketItem.addActionListener(this);

        ticketServiceMenu = new JMenu("Ticket Services");
        ticketServiceMenu.setForeground(Color.RED);
        ticketServiceMenu.add(sellTicketItem);
        ticketServiceMenu.add(returnTicketItem);
        ticketServiceMenu.add(viewTicketItem);
     
        // Initialize all the items for paymentServiceMenu
        paymentForTicketItem = new JMenuItem("Take Payment for Ticket");
        paymentForTicketItem.setForeground(Color.BLUE);
        paymentForTicketItem.setFont(font);
        paymentForTicketItem.addActionListener(this);

        viewPaymentList = new JMenuItem("View Payment List");
        viewPaymentList.setForeground(Color.BLUE);
        viewPaymentList.setFont(font);
        viewPaymentList.addActionListener(this);

        paymentServiceMenu = new JMenu("Payment Service");
        paymentServiceMenu.setForeground(Color.RED);
        paymentServiceMenu.add(paymentForTicketItem);
        paymentServiceMenu.add(viewPaymentList);

        // Initialize all the items for aeroplaneServiceMenu
        addAeroplaneItem = new JMenuItem("Add New Aeroplane");
        addAeroplaneItem.setForeground(Color.BLUE);
        addAeroplaneItem.setFont(font);
        addAeroplaneItem.addActionListener(this);

        updateAeroplaneItem = new JMenuItem("Update Aeroplane Info");
        updateAeroplaneItem.setForeground(Color.BLUE);
        updateAeroplaneItem.setFont(font);
        updateAeroplaneItem.addActionListener(this);

        removeAeroplaneItem = new JMenuItem("Remove Aeroplane");
        removeAeroplaneItem.setFont(font);
        removeAeroplaneItem.setForeground(Color.BLUE);
        removeAeroplaneItem.addActionListener(this);

        viewAeroplaneListItem = new JMenuItem("View Aeroplane List");
        viewAeroplaneListItem.setForeground(Color.BLUE);
        viewAeroplaneListItem.setFont(font);
        viewAeroplaneListItem.addActionListener(this);

        aeroplaneServiceMenu = new JMenu("Aeroplane Services");
        aeroplaneServiceMenu.setForeground(Color.RED);
        aeroplaneServiceMenu.add(addAeroplaneItem);
        aeroplaneServiceMenu.add(removeAeroplaneItem);
        aeroplaneServiceMenu.add(updateAeroplaneItem);
        aeroplaneServiceMenu.add(viewAeroplaneListItem);

        // Initialize all the items for flightServiceMenu
        addFlightItem = new JMenuItem("Add New Flight");
        addFlightItem.setForeground(Color.BLUE);
        addFlightItem.setFont(font);
        addFlightItem.addActionListener(this);

        updateFlightItem = new JMenuItem("Update Flight Info");
        updateFlightItem.setForeground(Color.BLUE);
        updateFlightItem.setFont(font);
        updateFlightItem.addActionListener(this);

        removeFlightItem = new JMenuItem("Remove Flight");
        removeFlightItem.setForeground(Color.BLUE);
        removeFlightItem.setFont(font);
        removeFlightItem.addActionListener(this);

        viewFlightListItem = new JMenuItem("View Flight List");
        viewFlightListItem.setForeground(Color.BLUE);
        viewFlightListItem.setFont(font);
        viewFlightListItem.addActionListener(this);

        flightServiceMenu = new JMenu("Flight Services");
        flightServiceMenu.setForeground(Color.RED);
        flightServiceMenu.add(addFlightItem);
        flightServiceMenu.add(updateFlightItem);
        flightServiceMenu.add(removeFlightItem);
        flightServiceMenu.add(viewFlightListItem);

        // Initialize all the items for clientServiceMenu
        addClientItem = new JMenuItem("Add New Client");
        addClientItem.setForeground(Color.BLUE);
        addClientItem.setFont(font);
        addClientItem.addActionListener(this);

        updateClientItem = new JMenuItem("Update Client Info");
        updateClientItem.setForeground(Color.BLUE);
        updateClientItem.setFont(font);
        updateClientItem.addActionListener(this);

        removeClientItem = new JMenuItem("Remove Client");
        removeClientItem.setForeground(Color.BLUE);
        removeClientItem.setFont(font);
        removeClientItem.addActionListener(this);

        viewClientListItem = new JMenuItem("View Client Lists");
        viewClientListItem.setForeground(Color.BLUE);
        viewClientListItem.setFont(font);
        viewClientListItem.addActionListener(this);

        clientServiceMenu = new JMenu("Client Services");
        clientServiceMenu.setForeground(Color.RED);
        clientServiceMenu.add(addClientItem);
        clientServiceMenu.add(updateClientItem);
        clientServiceMenu.add(removeClientItem);
        clientServiceMenu.add(viewClientListItem);

        // Initialize all the items for updateSelfMenu
        updateSelfProfileItem = new JMenuItem("Update Self Info");
        updateSelfProfileItem.setForeground(Color.BLUE);
        updateSelfProfileItem.setFont(font);
        updateSelfProfileItem.addActionListener(this);

        updateSelfPasswordItem = new JMenuItem("Update Self Password");
        updateSelfPasswordItem.setForeground(Color.BLUE);
        updateSelfPasswordItem.setFont(font);
        updateSelfPasswordItem.addActionListener(this);

        updateSelfMenu = new JMenu("Update Self Info");
        updateSelfMenu.setForeground(Color.RED);
        updateSelfMenu.add(updateSelfProfileItem);
        updateSelfMenu.add(updateSelfPasswordItem);

        // Initialize the exit menu item
        exitItem = new JMenuItem("EXIT");
        exitItem.setForeground(Color.RED);
        exitItem.setFont(font);
        exitItem.addActionListener(this);

        exitMenu = new JMenu("Exit");
        exitMenu.setForeground(Color.RED);
        exitMenu.add(exitItem);

        // Create the main menu bar and add all the JMenus
        mainMenuBar = new JMenuBar();
        mainMenuBar.add(ticketServiceMenu);
        mainMenuBar.add(paymentServiceMenu);
        mainMenuBar.add(aeroplaneServiceMenu);
        mainMenuBar.add(flightServiceMenu);
        mainMenuBar.add(clientServiceMenu);
        mainMenuBar.add(updateSelfMenu);
        mainMenuBar.add(exitMenu);

        // Create the label to add the image in the frame
        JLabel label = new JLabel();
        label.setBounds(0, 30, 1000, 720);
        label.setIcon(image); 

        // Configure the frame
     
        
        this.setSize(1000 , 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setJMenuBar(mainMenuBar);
        this.add(label);
        this.setVisible(true);
    } 

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == sellTicketItem){
            TicketTime tt = new TicketTime(this.user);
            this.setVisible(false);
            tt.setVisible(true);
        }

        if(e.getSource() == returnTicketItem){
            
        }

        if(e.getSource() == viewTicketItem){
          
        }

        if(e.getSource() == paymentForTicketItem){
            
        }

        if(e.getSource() == viewPaymentList){
            
        }

        if(e.getSource() == addAeroplaneItem){
            AddAeroplaneFrame aaf = new AddAeroplaneFrame(this.user);
            this.setVisible(false);
            aaf.setVisible(true);
        }

        if(e.getSource() == removeAeroplaneItem){
           
            // Ony for testing-------------------------------------------------------
            // RemoveFlightFrame rff = new RemoveFlightFrame(this.user);
            // this.setVisible(false);
            // rff.setVisible(true);
        }

        if(e.getSource() == updateAeroplaneItem){
          
        }

        if(e.getSource() == viewAeroplaneListItem){
           
            AeroplaneListFrame alf = new AeroplaneListFrame(this.user);
            this.setVisible(false);
            alf.setVisible(true);
        }

        if(e.getSource() == addFlightItem){
            AddFlightFrame aff = new AddFlightFrame(this.user);
            this.setVisible(false);
            aff.setVisible(true);
        }

        if(e.getSource() == removeFlightItem){
            RemoveFlightFrame rff = new RemoveFlightFrame(this.user);
            this.setVisible(false);
            rff.setVisible(true);
        }

        if(e.getSource() == updateFlightItem){
            
        }

        if(e.getSource() == viewFlightListItem){
           FlightListFrame flf = new FlightListFrame(this.user);
           this.setVisible(false);
           flf.setVisible(true);
        }

        if(e.getSource() == addClientItem){
            AddClientByEmployeeFrame ac = new AddClientByEmployeeFrame(user);
            this.setVisible(false);
            ac.setVisible(true);
        }

        if(e.getSource() == updateClientItem){
            
        }

        if(e.getSource() == removeClientItem){
            
        }

        if(e.getSource() == viewClientListItem){
            
        }

        if(e.getSource() == updateSelfProfileItem){
            this.setVisible(false);
            EmployeeRepo eRepo = new EmployeeRepo();
            Employee employee = eRepo.searchEmployeeById(user.getUserId());
            EmployeeProfileUpdate epf = new EmployeeProfileUpdate(this.user, employee);
            epf.setVisible(true); 
        }

        if(e.getSource() == updateSelfPasswordItem){
            // Handle update self password action
        }

        if(e.getSource() == exitItem){
            this.setVisible(false);
            Login l = new Login();
            l.setVisible(true);
        }
    }
}
