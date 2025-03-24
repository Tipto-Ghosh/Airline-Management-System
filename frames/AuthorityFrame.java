package frames;

import java.lang.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;
import interfaces.*;

public class AuthorityFrame extends JFrame implements ActionListener{
     
    // Take the user info here
    User user;
    // JMenuBar for adding all the menues
    // Creating Menu bar
    JMenuBar mainMenuBar;
   
    // All the menu options
    JMenu addMenu , updateMenu , removeMenu , viewPersonDetailsMenu ,updateSelfMenu, viewFlightMenu , exitMenu;

    // All the menuItems:[All adding items]
    JMenuItem addNewEmployeeItem , addNewClientItem , addNewAuthorItem;
    
    // All the menuItems:{updateSekfMenu}
    JMenuItem updateAuthorItem , updateSelfPasswordItem , updateSelfInfoItem;
    
    // All the menuItems of updateMenu
    JMenuItem updateEmployeeItem , updateClientItem ;

    // Creating All the items of viewDetailsMenu
    JMenuItem viewEmployeeItem , viewClientItem , viewAuthorityItem ;
    
    // All the items for viewFlightMenu 
    JMenuItem viewFlightListItem , viewTicketListItem , viewAeroplaneListItem;

    // All the items for remove menu
    JMenuItem removeEmployeeItem , removeClienItem , removeAuthorityItem;

    // ExitItem
    JMenuItem exitItem;
     
     // Creating The main page Image:
     ImageIcon image = new ImageIcon("Icons\\adminPageImage.jpg");
     Image editMainImage = image.getImage().getScaledInstance(1000 , 850 , Image.SCALE_DEFAULT);
     ImageIcon mainImageIcon = new ImageIcon(editMainImage);
     

    public AuthorityFrame(User u){
    
    // ----------------------------------------------------------------------------------------
        // Creating all the menuItem of the addMenu[addNewAuthor]
        addNewAuthorItem = new JMenuItem("Add New Author");
        addNewAuthorItem.setForeground(Color.BLUE);
        addNewAuthorItem.addActionListener(this);

         // Creating all the menuItem of the addMenu[addNewEmployee]
         addNewEmployeeItem = new JMenuItem("Add New Employee");
         addNewEmployeeItem.setForeground(Color.BLUE);
         addNewEmployeeItem.addActionListener(this);

         // Creating all the menuItem of the addMenu[addNewClient]
         addNewClientItem = new JMenuItem("Add New Client");
         addNewClientItem.setForeground(Color.BLUE);
         addNewClientItem.addActionListener(this);

        // Creating addMenu
        addMenu = new JMenu("Add Info");
        addMenu.setForeground(Color.RED);
        addMenu.add(addNewAuthorItem);
        addMenu.add(addNewEmployeeItem);
        addMenu.add(addNewClientItem);
    // ------------------------------------------------------------------------------------------
        
        // Creating all the menuItem of the updateMenu[updateEmployeeItem]
        updateEmployeeItem = new JMenuItem("Update Employee Info");
        updateEmployeeItem.setForeground(Color.BLUE);
        updateEmployeeItem.addActionListener(this);
        
        updateAuthorItem = new JMenuItem("Update Author Info");
        updateAuthorItem.setForeground(Color.BLUE);
        updateAuthorItem.addActionListener(this);

        // Creating all the menuItem of the updateMenu[updateClienItem]
        updateClientItem  = new JMenuItem("Update Client Info");
        updateClientItem.setForeground(Color.BLUE);
        updateClientItem.addActionListener(this);

        // Creating updateInfoMenu
        updateMenu = new JMenu("Update Info");
        updateMenu.setForeground(Color.RED);

        updateMenu.add(updateEmployeeItem);
        updateMenu.add(updateClientItem);
        updateMenu.add(updateAuthorItem);
        
    // -------------------------------------------------------------------------------------------
     
       // Creating all the menuItem of the updateMenu[updateAuthorItem]
       updateAuthorItem = new JMenuItem("Update Author Info");
       updateAuthorItem.setForeground(Color.BLUE);
       updateAuthorItem.addActionListener(this);


       updateSelfInfoItem = new JMenuItem("Update Self Info");
       updateSelfInfoItem.setForeground(Color.BLUE);
       updateSelfInfoItem.addActionListener(this);

       updateSelfPasswordItem = new JMenuItem("Update Self Password");
       updateSelfPasswordItem.setForeground(Color.BLUE);
       updateSelfPasswordItem.addActionListener(this);

       // Creating updateSelfMenu
       updateSelfMenu = new JMenu("Update Author");
       updateSelfMenu.setForeground(Color.RED);

       updateSelfMenu.add(updateAuthorItem);
       updateSelfMenu.add(updateSelfInfoItem);
       updateSelfMenu.add(updateSelfPasswordItem);
    // -------------------------------------------------------------------------------------------
       
       // Creating All the items of viewDetailsMenu
      viewAuthorityItem = new JMenuItem("View Authority List");
      viewAuthorityItem.setForeground(Color.BLUE);
      viewAuthorityItem.addActionListener(this);

      viewClientItem = new JMenuItem("View Client List");
      viewClientItem.setForeground(Color.BLUE);
      viewClientItem.addActionListener(this);

      viewEmployeeItem = new JMenuItem("View Employee Details");
      viewEmployeeItem.setForeground(Color.BLUE);
      viewEmployeeItem.addActionListener(this);
          
       
      viewPersonDetailsMenu = new JMenu("View Details");
      viewPersonDetailsMenu.add(viewAuthorityItem);
      viewPersonDetailsMenu.add(viewEmployeeItem);
      viewPersonDetailsMenu.add(viewClientItem);

    // -------------------------------------------------------------------------------------------
       viewFlightListItem = new JMenuItem("View Flight List"); 
       viewFlightListItem.setForeground(Color.BLUE); 
       viewFlightListItem.addActionListener(this);
      
       viewTicketListItem = new JMenuItem("View Ticket List");
       viewTicketListItem.setForeground(Color.BLUE);
       viewTicketListItem.addActionListener(this);

       viewAeroplaneListItem = new JMenuItem("View Aerplane List");
       viewAeroplaneListItem.setForeground(Color.BLUE);
       viewAeroplaneListItem.addActionListener(this);

       // Creating viewFlightMenu
       viewFlightMenu = new JMenu("View Flight Info");
       viewFlightMenu.setForeground(Color.RED);
       viewFlightMenu.add(viewFlightListItem);
       viewFlightMenu.add(viewTicketListItem);
       viewFlightMenu.add(viewAeroplaneListItem);
    // -------------------------------------------------------------------------------------------
         // Creating all the items of removeMenu
         removeAuthorityItem = new JMenuItem("Remove Author");
         removeAuthorityItem.setForeground(Color.BLUE);
         removeAuthorityItem.addActionListener(this);

         removeEmployeeItem = new JMenuItem("Remove Employee");
         removeEmployeeItem.setForeground(Color.BLUE);
         removeEmployeeItem.addActionListener(this);

         removeClienItem = new JMenuItem("Remove Client");
         removeClienItem.setForeground(Color.BLUE);
         removeClienItem.addActionListener(this);

         removeMenu = new JMenu("Kick(off)");
         removeMenu.setForeground(Color.RED);

         removeMenu.add(removeAuthorityItem);
         removeMenu.add(removeEmployeeItem);
         removeMenu.add(removeClienItem);
    // -------------------------------------------------------------------------------------------
       exitItem = new JMenuItem("Exit");
       exitItem.setForeground(Color.RED);
       exitItem.addActionListener(this);
       
       exitMenu = new JMenu("Exit");
       exitMenu.setForeground(Color.RED);
       exitMenu.add(exitItem);

    // -------------------------------------------------------------------------------------------
       // Creating a MenuBar to add new Information menu , Deatils Menu , applyDettails
       mainMenuBar = new JMenuBar();
       mainMenuBar.setAlignmentX(0);
       mainMenuBar.setAlignmentY(20);

       // Adding all the Menu to the menuBar
       mainMenuBar.add(addMenu);
       mainMenuBar.add(updateMenu);
       mainMenuBar.add(viewPersonDetailsMenu);
       mainMenuBar.add(viewFlightMenu);
       mainMenuBar.add(removeMenu);
       mainMenuBar.add(exitMenu);

    // -------------------------------------------------------------------------------------------
       //Create a Label to add the Image in the Frame
       JLabel label = new JLabel();
       label.setBounds(0,30 , 1000 , 720);
       label.setIcon(mainImageIcon);

    // -------------------------------------------------------------------------------------------   

       //Creating The Frame:
       this.setSize(1000 , 750);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(null);
       this.setResizable(false);
       
       // Save the user here
       this.user = u;
       // Adding Thhings in the Frame
       this.add(label);
       this.setJMenuBar(mainMenuBar);

       this.setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == addNewClientItem){
            this.setVisible(false);
            AddClientByEmployeeFrame ac = new AddClientByEmployeeFrame(this.user); 
            ac.setVisible(true);
        }
        if(e.getSource() == addNewEmployeeItem){
         this.setVisible(false);
          AddEmployeeFrame ae = new AddEmployeeFrame(this.user);
          ae.setVisible(true);
        }
        if(e.getSource() == addNewAuthorItem){
          this.setVisible(false); 
          AddAuthorityFrame aaf = new AddAuthorityFrame(user);
          aaf.setVisible(true); 
        }
     // ----------------------------------------------------------------------
     // All the actions of updateMenu
        if(e.getSource() == updateAuthorItem){
         
        }
        if(e.getSource() == updateSelfPasswordItem){

        }
        if(e.getSource() == updateSelfInfoItem){
          // For updating self Authority We need to find the Author
          AuthorityRepo ar = new AuthorityRepo();
          Authority selfInfo = ar.searchAuthorityByUserId(this.user.getUserId());
          UserRepo urepo = new UserRepo();
          User user = urepo.searchUserByUserId(this.user.getUserId());
           
          // Now send it to the UpdateSelfProfileAuthor
          this.setVisible(false);

          AuthorityProfileUpdate apu = new AuthorityProfileUpdate(user, selfInfo);
          apu.setVisible(true);
           
        }
        if(e.getSource() == updateEmployeeItem){
         
        }
        if(e.getSource() == updateClientItem){
         
        }

        // -------------------------------------------------------------
        // All the actions of viewPersonDetails Menu
        if(e.getSource() == viewEmployeeItem){
         
        }
        if(e.getSource() == viewClientItem){
         
        }
        if(e.getSource() == viewAuthorityItem){
           AuthorityListFrame alf = new AuthorityListFrame(this.user);
           this.setVisible(false);
           alf.setVisible(true);
        }

    // ---------------------------------------------------------------------------
    // All the Actions of viewFlightInfo Menu
        if(e.getSource() == viewAeroplaneListItem){
           AeroplaneListFrame alf = new AeroplaneListFrame(this.user);
           this.setVisible(false);
           alf.setVisible(true);
        }
        if(e.getSource() == viewFlightListItem){
           FlightListFrame flf = new FlightListFrame(this.user);
           this.setVisible(false);
           flf.setVisible(true);
        }
      
    // ----------------------------------------------------------------------------
    // All the Actions of RemoveInfo Menu
        if(e.getSource() == removeEmployeeItem){
         
        }
        if(e.getSource() == removeClienItem){
         
        }
        if(e.getSource() == removeAuthorityItem){
           
        }     
    // --------------------------------------------------------
     if(e.getSource() == exitItem){
      this.setVisible(false);
      Login l = new Login();
     }
    }
}