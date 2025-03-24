package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import interfaces.*;
import repositories.*;

public class AuthorityProfileUpdate extends JFrame implements ActionListener{

    // Take a Author Info
   private User user;
   private  Authority authority;
    
    // All the labels for shwoinh the text
    private JLabel  mainLabel , userIdLabel , nameLabel , genderLabel , ageLabel , emailLabel , phoneNoLabel , addressLabel , securityAnsLabel,membershipTypeLabel;
    private JTextField usernameField , userIdField , ageField , emailField , phoneNoField , addressField ,securityAnsField;
    private JComboBox<String> genderComboBox , membershipTypeComboBox;
    // two buttons
    private JButton updateButton , backButton;


    // Make a font
    private Font font = new Font("MV Boli" , Font.BOLD , 16); 
    private Font font2 = new Font("Arial", Font.BOLD, 16);
    
    public  AuthorityProfileUpdate(User u , Authority a){

        this.user = u;
        this.authority = a;

    // --------------------------------------------------
       // Create the image to add:
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/addPassenger.png"));
       Image image = i1.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
       ImageIcon imageIcon = new ImageIcon(image);
    //---------------------------------------------------
       // Ceate the mainLabel and add the image
       mainLabel = new JLabel();
       mainLabel.setBounds(0, 0, 900, 600);
       mainLabel.setLayout(null);
       
       // Add the image here
       mainLabel.setIcon(imageIcon);
    //---------------------------------------------------
       // Create label to write "Welcome to Biman Bangladesh" text
       JLabel welcomeLabel = new JLabel("Update Self Information");
       welcomeLabel.setBounds(50, 30, 400, 30);
       welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
       welcomeLabel.setForeground(Color.BLACK);
       mainLabel.add(welcomeLabel); 
    //---------------------------------------------------
       // Creating the userIdLabel:
       userIdLabel = new JLabel("User Id:");
       userIdLabel.setBounds(50 , 100 , 200 , 30);
       userIdLabel.setFont(font2);
       mainLabel.add(userIdLabel); 

       // Create the userIdField:
       userIdField = new JTextField(this.user.getUserId());
       userIdField.setFont(font);
       userIdField.setBounds(200 , 100 , 200 , 30);
       userIdField.setForeground(Color.BLUE);
       userIdField.setEditable(false);
       mainLabel.add(userIdField);
    //---------------------------------------------------
       // Create label to write "Name" text
       nameLabel = new JLabel("Name:");
       nameLabel.setBounds(50, 150, 100, 30);
       nameLabel.setFont(font2);
       nameLabel.setForeground(Color.BLACK);
       mainLabel.add(nameLabel);

       // Create a textField for Name
       usernameField = new JTextField(this.authority.getName());
       usernameField.setEditable(false);
       usernameField.setBounds(200, 150, 200, 30);
       usernameField.setForeground(Color.BLUE);
       usernameField.setFont(font);
       mainLabel.add(usernameField);
    //--------------------------------------------------- 
       // Create the label and field for age
       ageLabel = new JLabel("Age:");
       ageLabel.setBounds(50 , 200 , 150 , 30);
       ageLabel.setFont(font2);
       ageLabel.setForeground(Color.BLACK);
       mainLabel.add(ageLabel);
       
       ageField = new JTextField(this.authority.getAge());
       ageField.setBounds(200 , 200 , 200 , 30);
       ageField.setForeground(Color.BLUE);
       ageField.setFont(font);
       mainLabel.add(ageField);
    //---------------------------------------------------
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50 , 250 , 150 , 30);
        genderLabel.setFont(font2);
        genderLabel.setBackground(Color.BLACK);
        mainLabel.add(genderLabel);
        
        // Creating the genderCombo
        String[] gender = {"Male" , "Female" , "Other"};
        genderComboBox = new JComboBox<>(gender);
        genderComboBox.setSelectedItem(this.authority.getGender());
        genderComboBox.setBounds(200, 250, 200, 30);
        mainLabel.add(genderComboBox);
        
    //---------------------------------------------------
        // Create the label for phone no
        phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setBounds(450 , 100 , 100 , 30);
        phoneNoLabel.setForeground(Color.BLACK);
        phoneNoLabel.setFont(font2);
        mainLabel.add(phoneNoLabel);


        phoneNoField = new JTextField(this.authority.getPhoneNo());
        phoneNoField.setBounds(600 , 100 , 200 , 30);
        phoneNoField.setFont(font);
        phoneNoField.setForeground(Color.BLUE);
        mainLabel.add(phoneNoField);
    //---------------------------------------------------
        // Creating the Label and field to update the email
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(450 , 150 , 100 , 30);
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setFont(font2);
        mainLabel.add(emailLabel);


        emailField = new JTextField(this.authority.getEmail());
        emailField.setBounds(600 , 150 , 200 , 30);
        emailField.setForeground(Color.BLUE);
        emailField.setFont(font);
        mainLabel.add(emailField);

    //---------------------------------------------------
        // Create label and field to chage the address
        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(450 , 200 , 100 , 30);
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setFont(font2);
        mainLabel.add(addressLabel);

        addressField = new JTextField(this.authority.getAddress());
        addressField.setBounds(600 , 200 , 200 , 30);
        addressField.setForeground(Color.BLUE);
        addressField.setFont(font);
        mainLabel.add(addressField);
    //---------------------------------------------------


       // Membership type label and combo box
       membershipTypeLabel = new JLabel("Authority Type:");
       membershipTypeLabel.setBounds(50, 300, 150, 30);
      // membershipTypeLabel.setFont(font2);
       membershipTypeLabel.setForeground(Color.BLACK);
       mainLabel.add(membershipTypeLabel);

       String[] membershipTypes = {"Founder", "Co-Founder", "Operation Lead"};
       membershipTypeComboBox = new JComboBox<>(membershipTypes);
       membershipTypeComboBox.setSelectedItem(this.authority.getAuthorityType());
       membershipTypeComboBox.setBounds(200, 300, 200, 30);
       mainLabel.add(membershipTypeComboBox);





        // security ans label and field
        securityAnsLabel = new JLabel("Security Ans:");
        securityAnsLabel.setBounds(450 , 250 , 150 , 30);
        securityAnsLabel.setForeground(Color.BLACK);
        securityAnsLabel.setFont(font2);
        mainLabel.add(securityAnsLabel);

        securityAnsField = new JTextField(this.authority.getSecurityAns());
        securityAnsField.setEditable(false);
        securityAnsField.setBounds(600 , 250 , 200 , 30);
        securityAnsField.setForeground(Color.BLUE);
        securityAnsField.setFont(font);
        mainLabel.add(securityAnsField);
    //---------------------------------------------------
        // Create the 2 buttons
        updateButton = new JButton("Update");
        updateButton.setBounds(250 , 350 , 150 , 40);
        updateButton.setBackground(Color.BLUE);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusable(false);
        updateButton.addActionListener(this);
        mainLabel.add(updateButton);
        
        
        backButton = new JButton("Back");
        backButton.setBounds(450 , 350 , 150 , 40);
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        mainLabel.add(backButton);

    //---------------------------------------------------
        // Create the Frame:
        this.setSize(900 , 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // Add all the mainLabel here
        this.add(mainLabel);
        
        this.setVisible(true);
    }




    public void actionPerformed(ActionEvent ae){
         
          if(ae.getSource() == updateButton){    
            // Check no fields are empty
            if (!(emailField.getText().isEmpty() ||phoneNoField.getText().isEmpty() || addressField.getText().isEmpty() || ageField.getText().isEmpty())) {
    
                 authority.setEmail(emailField.getText());
                 authority.setPhoneNo(phoneNoField.getText());
                 authority.setAddress(addressField.getText());
                 
                 try{
                    Integer ageCheck = Integer.parseInt(ageField.getText());
                    if (ageCheck > 150 || ageCheck < 0) {
                        JOptionPane.showMessageDialog(null, "Age should be greater than zero and less than 150", "Invalid Age", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else{
                        authority.setAge(ageCheck);
                    }
                 }catch(Exception e){
                    e.printStackTrace();
                 }

                 //doing update operation by AUthrityRepo's object authority.
                 AuthorityRepo arp = new AuthorityRepo();
                 arp.updateAuthority(authority);
                 JOptionPane.showMessageDialog(this,"Authority updated Successfully");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Fill All the fields", "Fill All the fields", JOptionPane.ERROR_MESSAGE);
            }
         
          }
          if(ae.getSource() == backButton){
             AuthorityFrame af = new AuthorityFrame(this.user);
             this.setVisible(false);
			 af.setVisible(true);
          }
    }
}