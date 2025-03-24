package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.*;
import repositories.*;
import interfaces.*;

public class AddEmployeeFrame extends JFrame implements ActionListener{
      
    User user;

    // All the labels for shwoinh the text
    JLabel  mainLabel , userIdLabel , nameLabel , genderLabel , ageLabel , emailLabel , phoneNoLabel , addressLabel , securityAnsLabel , passwordLabel , salaryLabel , designationLabel;
    JTextField usernameField , userIdField , genderField , ageField , emailField , phoneNoField , addressField ,securityAnsField , passwordField , salaryField;
    
    // two buttons
    JButton submitButton , backButton;

    // ComboBox to submit Gender
    JComboBox<String> genderComboBox , designationComboBox;

    // Make a font
    Font font = new Font("MV Boli" , Font.BOLD , 16); 
    Font font2 = new Font("Arial", Font.BOLD, 16);

    public AddEmployeeFrame(User user){
        
        // Create the image to add:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/addPassenger.png"));
        Image image = i1.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
    
        // Create the mainLabel and add the image
        mainLabel = new JLabel();
        mainLabel.setBounds(0, 0, 900, 600);
        mainLabel.setLayout(null);
        mainLabel.setIcon(imageIcon);
    
        // Create label to write "Welcome to Biman Bangladesh" text
        JLabel welcomeLabel = new JLabel("Give New Employee Info");
        welcomeLabel.setBounds(50, 30, 400, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.BLACK);
        mainLabel.add(welcomeLabel); 
    
        // Creating the userIdLabel:
        userIdLabel = new JLabel("User Id:");
        userIdLabel.setBounds(50, 100, 200, 30);
        userIdLabel.setFont(font2);
        mainLabel.add(userIdLabel); 
    
        // Create the userIdField:
        userIdField = new JTextField();
        userIdField.setFont(font);
        userIdField.setBounds(200, 100, 200, 30);
        userIdField.setForeground(Color.BLUE);
        mainLabel.add(userIdField);
    
        // Create label to write "Name" text
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 150, 100, 30);
        nameLabel.setFont(font2);
        nameLabel.setForeground(Color.BLACK);
        mainLabel.add(nameLabel);
    
        // Create a textField for Name
        usernameField = new JTextField();
        usernameField.setBounds(200, 150, 200, 30);
        usernameField.setForeground(Color.BLUE);
        usernameField.setFont(font);
        mainLabel.add(usernameField);
    
        // Create the label and field for age
        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 200, 150, 30);
        ageLabel.setFont(font2);
        ageLabel.setForeground(Color.BLACK);
        mainLabel.add(ageLabel);
       
        ageField = new JTextField();
        ageField.setBounds(200, 200, 200, 30);
        ageField.setForeground(Color.BLUE);
        ageField.setFont(font);
        mainLabel.add(ageField);
    
        // Creating genderLabel
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50 , 250 , 150 , 30);
        genderLabel.setForeground(Color.BLACK);
        genderLabel.setFont(font2);
        mainLabel.add(genderLabel);
    
        // Creating the genderComboBox
        String[] gender = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(gender);
        genderComboBox.setBounds(200, 250, 200, 30);
        mainLabel.add(genderComboBox);
        
        // Create the label for phone no
        phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setBounds(450, 100, 100, 30);
        phoneNoLabel.setForeground(Color.BLACK);
        phoneNoLabel.setFont(font2);
        mainLabel.add(phoneNoLabel);
    
        phoneNoField = new JTextField();
        phoneNoField.setBounds(600, 100, 200, 30);
        phoneNoField.setFont(font);
        phoneNoField.setForeground(Color.BLUE);
        mainLabel.add(phoneNoField);
    
        // Creating the Label and field to submit the email
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(450, 150, 100, 30);
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setFont(font2);
        mainLabel.add(emailLabel);
    
        emailField = new JTextField();
        emailField.setBounds(600, 150, 200, 30);
        emailField.setForeground(Color.BLUE);
        emailField.setFont(font);
        mainLabel.add(emailField);
    
        // Create label and field to change the address
        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(450, 200, 100, 30);
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setFont(font2);
        mainLabel.add(addressLabel);
    
        addressField = new JTextField();
        addressField.setBounds(600, 200, 200, 30);
        addressField.setForeground(Color.BLUE);
        addressField.setFont(font);
        mainLabel.add(addressField);
    
        // Password label and field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(450, 250, 150, 30);
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(font2);
        mainLabel.add(passwordLabel);
    
        passwordField = new JTextField();
        passwordField.setBounds(600, 250, 200, 30);
        passwordField.setForeground(Color.BLUE);
        passwordField.setFont(font);
        mainLabel.add(passwordField);
    
        // Security answer label and field
        securityAnsLabel = new JLabel("Security Ans:");
        securityAnsLabel.setBounds(450, 300, 150, 30);
        securityAnsLabel.setForeground(Color.BLACK);
        securityAnsLabel.setFont(font2);
        mainLabel.add(securityAnsLabel);
    
        securityAnsField = new JTextField();
        securityAnsField.setBounds(600, 300, 200, 30);
        securityAnsField.setForeground(Color.BLUE);
        securityAnsField.setFont(font);
        mainLabel.add(securityAnsField);
    
                // Create label for salary
        salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(450, 350, 100, 30);
        salaryLabel.setForeground(Color.BLACK);
        salaryLabel.setFont(font2);
        mainLabel.add(salaryLabel);
    
        // Create salaryField
        salaryField = new JTextField();
        salaryField.setBounds(600, 350, 200, 30);
        salaryField.setForeground(Color.BLUE);
        salaryField.setFont(font);
        mainLabel.add(salaryField);
    
        // Create label for designation
        
        designationLabel = new JLabel("Designation:");
        designationLabel.setBounds(50, 300, 150, 30);
        designationLabel.setForeground(Color.BLACK);
        designationLabel.setFont(font2);
        mainLabel.add(designationLabel);
    
        // Create designationField
        String[] des = {"Executive Level" , "Management Level" , "Technical Level" , "Support Stuff"};
        designationComboBox = new JComboBox<>(des);
        designationComboBox.setBounds(200, 300, 200, 30);
        mainLabel.add(designationComboBox);
    
        
        // Create the buttons
        submitButton = new JButton("Submit");
        submitButton.setBounds(250, 400, 150, 40);
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        mainLabel.add(submitButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(450, 400, 150, 40);
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        mainLabel.add(backButton);
    
        // Create the Frame:
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    
        // Add the mainLabel
        this.add(mainLabel);
        this.user = user;
        // Make the frame visible
        this.setVisible(true);
    
        }
    
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == submitButton){
                            // get all the data from the text field
            String userId, name, gender, email, phone, address, securityAns, password, designamtion;
            int age , salary;
    
            // Check no fields are empty
            if (!(userIdField.getText().isEmpty() || usernameField.getText().isEmpty() || emailField.getText().isEmpty() ||
                    phoneNoField.getText().isEmpty() || addressField.getText().isEmpty() || passwordField.getText().isEmpty() ||
                    securityAnsField.getText().isEmpty() || ageField.getText().isEmpty() || salaryField.getText().isEmpty())){
    
                // Now check userId is taken or not
                userId = userIdField.getText();
                UserRepo ur = new UserRepo();
                User u = ur.searchUserByUserId(userId);
    
                if (u == null) {
    
                    try {
                        name = usernameField.getText();
                        email = emailField.getText();
                        phone = phoneNoField.getText();
                        address = addressField.getText();
                        securityAns = securityAnsField.getText();
                        password = passwordField.getText();
    
    
                        age = Integer.parseInt(ageField.getText());
                        if (age > 150 || age < 0) {
                            JOptionPane.showMessageDialog(null, "Age should be greater than zero and less than 150", "Invalid Age", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        salary = Integer.parseInt(salaryField.getText());
                        if ( salary < 0) {
                            JOptionPane.showMessageDialog(null, "Enter Valid Salary", "Invalid Salary", JOptionPane.ERROR_MESSAGE);
                            return;
                        }


                        String genderCheck = (String) genderComboBox.getSelectedItem();
                        if (genderCheck != null) {
                            gender = genderCheck;
                        } else {
                            gender = "Male";
                        }

                        String checkDes = (String) designationComboBox.getSelectedItem();
                        if (checkDes != null) {
                            designamtion = checkDes;
                        } else {
                            designamtion = "Technical Level";
                        }

    
                        // All info got
                        Employee employee = new Employee(userId, name, email, phone, gender, age, address, 2, securityAns, password, designamtion , salary);
                        // Now send client to write info into user.txt and client.txt
                        ur.addUser(employee);
    
                        EmployeeRepo eRepo = new EmployeeRepo();
                        boolean isAdded = eRepo.addEmployee(employee);
    
                        if (isAdded) {
                            JOptionPane.showMessageDialog(null, "Employee Saved Successfully", "Employee Saving Info", JOptionPane.INFORMATION_MESSAGE);
                            this.setVisible(false);
                            this.setVisible(true);
                            this.resetFields();

                        } else {
                            JOptionPane.showMessageDialog(null, "Employee Saved Failed", "Employee Saving Info", JOptionPane.ERROR_MESSAGE);
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
             
            if(e.getSource() == backButton){
                this.setVisible(false);
                AuthorityFrame af = new AuthorityFrame(this.user);
            }
        }


        // Method to reset all text fields
    private void resetFields() {
        userIdField.setText("");
        usernameField.setText("");
        ageField.setText("");
        phoneNoField.setText("");
        emailField.setText("");
        addressField.setText("");
        securityAnsField.setText("");
        passwordField.setText("");
        genderComboBox.setSelectedIndex(0);
        designationComboBox.setSelectedIndex(0);
        salaryField.setText("");
        
    }
}