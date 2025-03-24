package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class AddAuthorityFrame extends JFrame implements ActionListener{
     
    // All the necessary components
   private JButton saveButton, closeButton;
   private JTextField userIdField, nameField, ageField, phoneField, emailField, addressField, passwordField , securityAnsField;
   private JComboBox<String> genderComboBox , membershipTypeComboBox;
   private JLabel l1, l2, l3, l4, l5, l6, l7, l8, membershipTypeLabel, l10 , passwordLabel , securityAnsLabel;

   // Get the User
   private User user;
   private Authority authority;
    
    // Here we go for the Constructor
     
    public AddAuthorityFrame(User user){
        this.user = user;

        this.setTitle("Add New Author Details");
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the image to add:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/addPassenger.png"));
        Image image = i1.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);

        // Creating label to add the image
        l1 = new JLabel();
        l1.setBounds(0, 0, 900, 600);
        l1.setLayout(null);

        // Adding image
        l1.setIcon(imageIcon);

        // Column 1: User Details
        // Create label to write "Client id" text
        l2 = new JLabel("Author Id:");
        l2.setBounds(50, 100, 100, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        // Create a textField for UserName
        userIdField = new JTextField();
        userIdField.setBounds(200, 100, 200, 30);
        l1.add(userIdField);

        // Create label to write "Name" text
        l3 = new JLabel("Name:");
        l3.setBounds(50, 150, 100, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 16));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        // Create a textField for Name
        nameField = new JTextField();
        nameField.setBounds(200, 150, 200, 30);
        l1.add(nameField);

        // Create label to write "Date of Birth" text
        l4 = new JLabel("Enter Age:");
        l4.setBounds(50, 200, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 16));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        // Create a textField for Date of Birth
        ageField = new JTextField();
        ageField.setBounds(200, 200, 200, 30);
        l1.add(ageField);

        // Create label to write "Gender" text
        l5 = new JLabel("Gender:");
        l5.setBounds(50, 250, 100, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 16));
        l5.setForeground(Color.BLACK);
        l1.add(l5);

        // Create a combo box for Gender
        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(200, 250, 200, 30);
        l1.add(genderComboBox);

        // Column 2: Contact Details
        // Create label to write "Phone" text
        l6 = new JLabel("Phone:");
        l6.setBounds(450, 100, 100, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 16));
        l6.setForeground(Color.BLACK);
        l1.add(l6);

        // Create a textField for Phone
        phoneField = new JTextField();
        phoneField.setBounds(600, 100, 200, 30);
        l1.add(phoneField);

        // Create label to write "Email" text
        l7 = new JLabel("Email:");
        l7.setBounds(450, 150, 100, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 16));
        l7.setForeground(Color.BLACK);
        l1.add(l7);

        // Create a textField for Email
        emailField = new JTextField();
        emailField.setBounds(600, 150, 200, 30);
        l1.add(emailField);

        // Create label to write "Address" text
        l8 = new JLabel("Address:");
        l8.setBounds(450, 200, 100, 30);
        l8.setFont(new Font("Arial", Font.BOLD, 16));
        l8.setForeground(Color.BLACK);
        l1.add(l8);
        


        // create security ans and passeword
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(450 , 250 , 100 , 30);
        passwordLabel.setFont(new Font("Arial" , Font.BOLD , 16));
        passwordLabel.setForeground(Color.BLACK);
        l1.add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(600 , 250 , 200 , 30);
        l1.add(passwordField);

        // Create securityAns
        securityAnsLabel = new JLabel("Security Ans");
        securityAnsLabel.setBounds(450 , 300 , 100 , 30);
        securityAnsLabel.setForeground(Color.BLACK);
        securityAnsLabel.setFont(new Font("Arial" , Font.BOLD , 16));
        l1.add(securityAnsLabel);

        securityAnsField = new JTextField();
        securityAnsField.setBounds(600 , 300 , 200 , 30);
        l1.add(securityAnsField);



        // Create a textField for Address
        addressField = new JTextField();
        addressField.setBounds(600, 200, 200, 30);
        l1.add(addressField);

         // Membership type label and combo box
         membershipTypeLabel = new JLabel("Authority Type:");
         membershipTypeLabel.setBounds(50, 300, 150, 30);
        // membershipTypeLabel.setFont(font2);
         membershipTypeLabel.setForeground(Color.BLACK);
         l1.add(membershipTypeLabel);
 
         String[] membershipTypes = {"Founder", "Co-Founder", "Operation Lead"};
         membershipTypeComboBox = new JComboBox<>(membershipTypes);
         membershipTypeComboBox.setBounds(200, 300, 200, 30);
         l1.add(membershipTypeComboBox);

        // Create label to write "Welcome to Biman Bangladesh" text
        JLabel welcomeLabel = new JLabel("Welcome to Biman Bangladesh");
        welcomeLabel.setBounds(50, 30, 400, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.BLACK);
        l1.add(welcomeLabel);




        // create to btton one for save and second for close
        saveButton = new JButton("Save");
        saveButton.setBounds(250 , 350 , 150 , 40);
        saveButton.setBackground(Color.BLUE);
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        l1.add(saveButton);

        closeButton = new JButton("Close");
        closeButton.setBounds(450 , 350 , 150 , 40);
        closeButton.setBackground(Color.RED);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);
        l1.add(closeButton);


        this.add(l1);
        this.setBounds(0, 0, 900, 600);
        this.setVisible(true);

    }


    public void actionPerformed(ActionEvent e){
          
        if (e.getSource() == saveButton) {
            // get all the data from the text field
            String userId, name, gender, email, phone, address, securityAns, password, membership;
            int age;
    
            // Check no fields are empty
            if (!(userIdField.getText().isEmpty() || nameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty() || addressField.getText().isEmpty() || passwordField.getText().isEmpty() ||securityAnsField.getText().isEmpty() || ageField.getText().isEmpty()))
            {
    
                // Now check userId is taken or not
                userId = userIdField.getText();
                UserRepo ur = new UserRepo();
                User u = ur.searchUserByUserId(userId);
    
                if (u == null){
    
                    try{
                        name = nameField.getText();
                        email = emailField.getText();
                        phone = phoneField.getText();
                        address = addressField.getText();
                        securityAns = securityAnsField.getText();
                        password = passwordField.getText();
    
    
                        age = Integer.parseInt(ageField.getText());
                        if (age > 150 || age < 0){
                            JOptionPane.showMessageDialog(null, "Age should be greater than zero and less than 150", "Invalid Age", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
    
                        String genderCheck = (String) genderComboBox.getSelectedItem();
                        if (genderCheck != null) {
                            gender = genderCheck;
                        } else {
                            gender = "Male";
                        }

                        String checkMembership = (String) membershipTypeComboBox.getSelectedItem();
                        if (checkMembership != null) {
                            membership = checkMembership;
                        } else {
                            membership = "Operation Lead";
                        }
                        
                        // We got all the data now add to user.txt and authority.txt
                        Authority a = new Authority(userId, name, email, phone, gender, age, address, 1, securityAns, password, membership);
                        ur.addUser(a);

                        AuthorityRepo ar = new AuthorityRepo();
                        boolean isAdded = ar.addAuthority(a);

    
                        if (isAdded) {
                            JOptionPane.showMessageDialog(null, "Authority Saved Successfully", "Authority Saving Info", JOptionPane.INFORMATION_MESSAGE);
                            this.setVisible(false);
                            this.setVisible(true);
                            this.resetFields();

                        } else {
                            JOptionPane.showMessageDialog(null, "Authority Saved Failed", "Authority Saving Info", JOptionPane.ERROR_MESSAGE);
                            this.setVisible(false);
                            this.setVisible(true);
                        }
                    } catch (NumberFormatException ageEx) {
                        JOptionPane.showMessageDialog(null, "Age should be a valid number", "Invalid Age", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User Id is Already Taken By others.\n Please Try Another One", "Invalid Client Id", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fill All the fields", "Fill All the fields", JOptionPane.ERROR_MESSAGE);
            }
        }


        // If Close button pressed then go back to the authority frame
        if(e.getSource() == closeButton){
            this.setVisible(false);
            AuthorityFrame af = new AuthorityFrame(this.user);
            af.setVisible(true);
        }
    }

    // Method to reset all text fields
    private void resetFields() {
        userIdField.setText("");
        nameField.setText("");
        ageField.setText("");
        phoneField.setText("");
        emailField.setText("");
        addressField.setText("");
        securityAnsField.setText("");
        passwordField.setText("");
        genderComboBox.setSelectedIndex(0);
        membershipTypeComboBox.setSelectedIndex(0);
    }

}