package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import interfaces.*;
import repositories.*;


public class ForgetPasswordFrame extends JFrame implements ActionListener{

  
    // All the labels
    JLabel mainLabel , showTextLabel , securityAnsLabel , newPasswordLabel , retypePasswordLabel , userIdLabel;

    // All the passwordField
    JPasswordField securityField , newPasswordField , retypePasswordField , userIdField;

    // All the buttons
    JButton updateButton , cancelButton;
    // Creating 2 fonts
    Font font = new Font("MV Boli" , Font.BOLD , 16); 
    Font font2 = new Font("Arial", Font.BOLD, 20);

   // Class Constructor
   public ForgetPasswordFrame(){

    // to show the frame at a good position of the screen
    this.setBounds(350, 100, 580, 500);
   //------------------------------------------------------------------------------------------------    
       ImageIcon imageIcon = new ImageIcon("Icons\\updatePasswordImage.jpg");
//------------------------------------------------------------------------------------------------        
       //Create the mainLabel
       mainLabel = new JLabel();
       mainLabel.setIcon(imageIcon);
       mainLabel.setBounds(0,0,500,500);
//------------------------------------------------------------------------------------------------
       // Creating the showTextlabel
       showTextLabel = new JLabel("Update Your Password Here");
       showTextLabel.setBounds(20 , 10 , 400 ,50);
       showTextLabel.setFont(new Font("Arial", Font.BOLD, 24));
       showTextLabel.setForeground(Color.RED);
       mainLabel.add(showTextLabel);
//------------------------------------------------------------------------------------------------
       newPasswordLabel = new JLabel("New Password");
       newPasswordLabel.setBounds(20 , 70 , 200 , 30);
       newPasswordLabel.setForeground(Color.WHITE);
       newPasswordLabel.setFont(font2);
       mainLabel.add(newPasswordLabel);


       newPasswordField = new JPasswordField();
       newPasswordField.setBounds(230 , 70 , 200 , 30);
       newPasswordField.setForeground(Color.BLUE);
       newPasswordField.setFont(font);
       
       mainLabel.add(newPasswordField);
//------------------------------------------------------------------------------------------------
       // Create label and field for retype password
       retypePasswordLabel = new JLabel("ReType New Password");
       retypePasswordLabel.setBounds(20 , 120 , 200 , 30);
       retypePasswordLabel.setForeground(Color.WHITE);
       retypePasswordLabel.setFont(font2);
       mainLabel.add(retypePasswordLabel);
       
       
       retypePasswordField = new JPasswordField();
       retypePasswordField.setBounds(230 , 120 , 200 , 30);
       retypePasswordField.setForeground(Color.BLUE);
       retypePasswordField.setFont(font);
       mainLabel.add(retypePasswordField);
//------------------------------------------------------------------------------------------------
       // Create the security ans label and field
       securityAnsLabel = new JLabel("Enter the Security ans");
       securityAnsLabel.setBounds(20 , 180 , 200 , 30);
       securityAnsLabel.setForeground(Color.WHITE);
       securityAnsLabel.setFont(new Font("Arial", Font.BOLD, 16));
       
       mainLabel.add(securityAnsLabel);


       securityField = new JPasswordField();
       securityField.setBounds(230 , 180 , 200 , 30);
       securityField.setForeground(Color.BLUE);
       securityField.setFont(font);

       mainLabel.add(securityField);

//------------------------------------------------------------------------------------------------
    // Add enter userId here
       userIdLabel = new JLabel("Enter User Id:");
       userIdLabel.setBounds(20 , 230 , 200 , 30);
       userIdLabel.setForeground(Color.white);
       userIdLabel.setFont(new Font("Arial" , Font.BOLD , 18));
       mainLabel.add(userIdLabel);

       userIdField = new JPasswordField();
       userIdField.setBounds(230 , 230 , 200 , 30);
       userIdField.setForeground(Color.BLUE);
       userIdField.setFont(font);
       mainLabel.add(userIdField);
//------------------------------------------------------------------------------------------------
       // Create two buttons
       updateButton = new JButton("Update");
       updateButton.setBounds(50 , 350 , 200 , 30);
       updateButton.setForeground(Color.WHITE);
       updateButton.setBackground(Color.BLUE);
       updateButton.setFocusable(false);
       updateButton.addActionListener(this);

       mainLabel.add(updateButton);

       cancelButton = new JButton("Cancel");
       cancelButton.setBounds(270 , 350 , 200 , 30);
       cancelButton.setForeground(Color.WHITE);
       cancelButton.setBackground(Color.RED);
       cancelButton.setFocusable(false);
       cancelButton.addActionListener(this);

       mainLabel.add(cancelButton);

//------------------------------------------------------------------------------------------------       
       // Create the frame
       this.setBounds(300 , 200 , 500 , 500);
      // this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//------------------------------------------------------------------------------------------------
       // Add main label here
       this.add(mainLabel);

       this.setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {

       if (e.getSource() == updateButton) {
           String userId = new String(userIdField.getPassword());
           String newPass = new String(newPasswordField.getPassword());
           String reTypePass = new String(retypePasswordField.getPassword());
           String securityAns = new String(securityField.getPassword());
   
           // Prevent empty field input
           if (userId.isEmpty() || newPass.isEmpty() || reTypePass.isEmpty() || securityAns.isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
               return; // Exit the method if any field is empty
           }
           // Check if passwords match
           if (!newPass.equals(reTypePass))
           {
               JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
               return; // Exit the method if passwords do not match
           }
   
           // Create a UserRepo instance and search for the user by userId
           UserRepo urp = new UserRepo();
           User user = urp.searchUserByUserId(userId);
           int role = user.getRole();
           if (user != null){ // That Mean Valid User
             
              if (user.getSecurityAns().equals(securityAns)) 
              {
                   // Update the user's password
                   user.setPassword(newPass); // Use newPass instead of passPF.getText()
                   urp.updateUser(user);

                   // Change the password in the Specific file also

                   
                   if(role == 1){
                     AuthorityRepo ar = new AuthorityRepo();
                     Authority a = ar.searchAuthorityByUserId(userId);
                     a.setPassword(newPass);
                     boolean isUpdated = ar.updateAuthority(a);

                     if(isUpdated){
                       JOptionPane.showMessageDialog(this, "Password changed successfully");
                     }
                     else{
                       JOptionPane.showMessageDialog(this, "Password changed Falied");
                     }
                   }
                   else if(role == 2){
                      EmployeeRepo er = new EmployeeRepo();
                      Employee employee = er.searchEmployeeById(userId);
                      employee.setPassword(newPass);
                      boolean isUpdated = er.updateEmployee(employee);
                      if(isUpdated){
                            JOptionPane.showMessageDialog(this, "Password changed successfully");
                     }
                     else{
                       JOptionPane.showMessageDialog(this, "Password changed Falied");
                     }
                   }
                   else{
                       ClientRepo cRepo = new ClientRepo();
                       Client client = cRepo.searchClientByClientId(userId);
                       client.setPassword(newPass);
                       boolean isUpdated = cRepo.updateSelfProfile(client);

                       if(isUpdated){
                         JOptionPane.showMessageDialog(this, "Password changed successfully");
                       }
                       else{
                         JOptionPane.showMessageDialog(this, "Password changed Falied");
                       }
                   }

              }
              else{
                   JOptionPane.showMessageDialog(this, "Wrong security answer", "Error", JOptionPane.ERROR_MESSAGE);
              }
           } 
           else{
              JOptionPane.showMessageDialog(this, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
           }
       }
   
       if (e.getSource() == cancelButton) {
           // Back to login page
           this.setVisible(false);
           new Login().setVisible(true);
       }
   }
   

}