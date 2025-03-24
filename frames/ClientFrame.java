package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.ClientRepo;
import repositories.UserRepo;

public class ClientFrame extends JFrame implements ActionListener{

     // Take the User info
     User u;
    // Create the mainMenuBar:
    JMenuBar mainMenuBar;

    // Create JMenus
    JMenu ticketServiceMenu, flightAeroplaneMenu, updateSelfInfoMenu , exitMenu;

    // Ticket Service menu items
    JMenuItem buyTicketItem, makePaymentItem, viewSelfTicketList, viewSelfPaymentList;

    // Flight and Aeroplane Service menu items
    JMenuItem viewFlightList, viewAeroplaneList;

    // Self Service menu items
    JMenuItem updatePasswordItem, updateProfileItem;

    // logout menu items
    JMenuItem logoutItem , backToHomeItem;

    ImageIcon imageIcon = new ImageIcon("Icons\\adminPageImage.jpg");

    // Create a Font for all the menuItems
    Font font = new Font("Mv Boli", Font.BOLD, 15);

    public ClientFrame(User user) {

      this.u = user;
    //---------------------------------------------------------------------------
       // Create all the items of ticketServiceMenu
       buyTicketItem = new JMenuItem("Buy Ticket");
       buyTicketItem.setForeground(Color.BLUE);
       buyTicketItem.setFont(font);
       buyTicketItem.addActionListener(this);

       makePaymentItem = new JMenuItem("Make Payment");
       makePaymentItem.setForeground(Color.BLUE);
       makePaymentItem.setFont(font);
       makePaymentItem.addActionListener(this);

       viewSelfTicketList = new JMenuItem("View Bought Ticket List");
       viewSelfTicketList.setForeground(Color.BLUE);
       viewSelfTicketList.setFont(font);
       viewSelfTicketList.addActionListener(this);

       viewSelfPaymentList = new JMenuItem("View Self Payment History");
       viewSelfPaymentList.setForeground(Color.BLUE);
       viewSelfPaymentList.setFont(font);
       viewSelfPaymentList.addActionListener(this);

       // Creating the menu
       ticketServiceMenu = new JMenu("Ticket Services");
       ticketServiceMenu.setForeground(Color.RED);

       // Adding all the items
       ticketServiceMenu.add(buyTicketItem);
       ticketServiceMenu.add(makePaymentItem);
       ticketServiceMenu.addSeparator(); 
       ticketServiceMenu.add(viewSelfTicketList);
       ticketServiceMenu.add(viewSelfPaymentList);
    //-----------------------------------------------------------------
      // Create all items for flightAeroplaneMenu
      viewFlightList = new JMenuItem("View Flight List");
      viewFlightList.setForeground(Color.BLUE);
      viewFlightList.setFont(font);
      viewFlightList.addActionListener(this);


      viewAeroplaneList = new JMenuItem("View Areoplane List");
      viewAeroplaneList.setForeground(Color.BLUE);
      viewAeroplaneList.setFont(font);
      viewAeroplaneList.addActionListener(this);

      // Creating the flightAeroplaneMenu 
      flightAeroplaneMenu = new JMenu("View Aeroplane List");
      flightAeroplaneMenu.setForeground(Color.RED);

      flightAeroplaneMenu.add(viewFlightList);
      flightAeroplaneMenu.add(viewAeroplaneList);
    //-----------------------------------------------------------------
      // Creating all the items for the updateSelfInfoMenu
      updateProfileItem = new JMenuItem("Update Profile Info");
      updateProfileItem.setForeground(Color.BLUE);
      updateProfileItem.setFont(font);
      updateProfileItem.addActionListener(this);


      updatePasswordItem = new JMenuItem("Update Self Password");
      updatePasswordItem.setForeground(Color.BLUE);
      updatePasswordItem.setFont(font);
      updatePasswordItem.addActionListener(this);

      // Creating the updateSelfInfoMenu
      updateSelfInfoMenu = new JMenu("Update Self Info");
      updateSelfInfoMenu.setForeground(Color.RED);

      updateSelfInfoMenu.add(updateProfileItem);
      updateSelfInfoMenu.add(updatePasswordItem);
    //-----------------------------------------------------------------

        // Create all the exitMenu
        logoutItem = new JMenuItem("Log Out");
        logoutItem.setForeground(Color.RED);
        logoutItem.setFont(font);
        logoutItem.addActionListener(this);

        backToHomeItem = new JMenuItem("Back To Home Page");
        backToHomeItem.setForeground(Color.BLUE);
        backToHomeItem.setFont(font);
        backToHomeItem.addActionListener(this);

        exitMenu = new JMenu("EXIT");
        exitMenu.setForeground(Color.RED);
        exitMenu.setFont(font);

        exitMenu.add(logoutItem);
        exitMenu.add(backToHomeItem);

    //-----------------------------------------------------------------
       // Creating the mainMenuBar
       mainMenuBar = new JMenuBar();
       mainMenuBar.setAlignmentX(0);
       mainMenuBar.setAlignmentY(20);
    //-----------------------------------------------------------------
       // Adding All the JMenu to the main Menu
       mainMenuBar.add(ticketServiceMenu);
       mainMenuBar.add(flightAeroplaneMenu);
       mainMenuBar.add(updateSelfInfoMenu);
       mainMenuBar.add(exitMenu);
    //-----------------------------------------------------------------
        // Creating the label to add the image in the frame
        JLabel label = new JLabel();
        label.setBounds(0,30 , 1000 , 720);
        label.setIcon(imageIcon); 

    //------------------------------------------------------------------
      // Creating the Frame
      this.setSize(1000 , 750);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(null);
      this.setResizable(false);

      // Adding the mainMenu to the Frame
      this.setJMenuBar(mainMenuBar);
      
    //-------------------------------------------------------------------
      // add the label here

      this.add(label);


      this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
          if(e.getSource() == buyTicketItem){
             
               // Send him to the ticket frame
               this.setVisible(false);
               TicketTime tt = new TicketTime(this.u);
               tt.setVisible(true);
          }
          if(e.getSource() == makePaymentItem){
            
          }
          if(e.getSource() == viewSelfTicketList){
            
          }
          if(e.getSource() == viewSelfPaymentList){
            
          }
    //--------------------------------------------------------------------
          if(e.getSource() == viewFlightList){
              FlightListFrame flf = new FlightListFrame(this.u);
              this.setVisible(false);
              flf.setVisible(true);    
          }
          if(e.getSource() == viewAeroplaneList){
            AeroplaneListFrame alf = new AeroplaneListFrame(this.u);
            this.setVisible(false);
            alf.setVisible(true);
          }
    //--------------------------------------------------------------------      
          if(e.getSource() == updateProfileItem){
            //Fist Find the Client
            ClientRepo cr = new ClientRepo();
            Client c = cr.searchClientByClientId(u.getUserId());
             ClientProfileUpdate cpf = new ClientProfileUpdate(u, c);

             this.setVisible(false);
             cpf.setVisible(true);
          }
          if(e.getSource() == updatePasswordItem){
             
          }
    //-------------------------------------------------------------------- 
          if(e.getSource() == backToHomeItem){
            Login l = new Login();
            this.setVisible(false);
            l.setVisible(true);
          }
          if(e.getSource() == logoutItem){
              Login l = new Login();
              this.setVisible(false);
              l.setVisible(true);
          }
    }
}
