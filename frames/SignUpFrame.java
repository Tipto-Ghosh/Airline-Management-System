package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class SignUpFrame extends JFrame implements ActionListener{

    JButton createButton, closeButton;
    JTextField userId, name, age, phone, email, addressField, passwordField, securityAnsField;
    JComboBox<String> genderComboBox, membershipTypeComboBox;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, membershipTypeLabel, l10, passwordLabel, securityAnsLabel;

   public SignUpFrame(){
    this.setTitle("Create Your Account");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the image to add:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/addPassenger.png"));
        Image image = i1.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);

        // Creating label to add the image
        l1 = new JLabel();
        l1.setBounds(0, 0, 900, 600);
        l1.setLayout(null);
        l1.setIcon(imageIcon);

        // Column 1: User Details
        l2 = new JLabel("Client Id:");
        l2.setBounds(50, 100, 100, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        l1.add(l2);

        userId = new JTextField();
        userId.setBounds(200, 100, 200, 30);
        l1.add(userId);

        l3 = new JLabel("Name:");
        l3.setBounds(50, 150, 100, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 16));
        l1.add(l3);

        name = new JTextField();
        name.setBounds(200, 150, 200, 30);
        l1.add(name);

        l4 = new JLabel("Enter Age:");
        l4.setBounds(50, 200, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 16));
        l1.add(l4);

        age = new JTextField();
        age.setBounds(200, 200, 200, 30);
        l1.add(age);

        l5 = new JLabel("Gender:");
        l5.setBounds(50, 250, 100, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 16));
        l1.add(l5);

        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(200, 250, 200, 30);
        l1.add(genderComboBox);

        // Column 2: Contact Details
        l6 = new JLabel("Phone:");
        l6.setBounds(450, 100, 100, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 16));
        l1.add(l6);

        phone = new JTextField();
        phone.setBounds(600, 100, 200, 30);
        l1.add(phone);

        l7 = new JLabel("Email:");
        l7.setBounds(450, 150, 100, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 16));
        l1.add(l7);

        email = new JTextField();
        email.setBounds(600, 150, 200, 30);
        l1.add(email);

        l8 = new JLabel("Address:");
        l8.setBounds(450, 200, 100, 30);
        l8.setFont(new Font("Arial", Font.BOLD, 16));
        l1.add(l8);

        addressField = new JTextField();
        addressField.setBounds(600, 200, 200, 30);
        l1.add(addressField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(450, 250, 100, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        l1.add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(600, 250, 200, 30);
        l1.add(passwordField);

        securityAnsLabel = new JLabel("SecurityAns:");
        securityAnsLabel.setBounds(450, 300, 150, 30);
        securityAnsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        l1.add(securityAnsLabel);

        securityAnsField = new JTextField();
        securityAnsField.setBounds(600, 300, 200, 30);
        l1.add(securityAnsField);

        membershipTypeLabel = new JLabel("Membership Type:");
        membershipTypeLabel.setBounds(50, 300, 150, 30);
        l1.add(membershipTypeLabel);

        String[] membershipTypes = {"Basic", "Premium", "VIP"};
        membershipTypeComboBox = new JComboBox<>(membershipTypes);
        membershipTypeComboBox.setBounds(200, 300, 200, 30);
        l1.add(membershipTypeComboBox);

        JLabel welcomeLabel = new JLabel("Welcome to Biman Bangladesh");
        welcomeLabel.setBounds(50, 30, 400, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        l1.add(welcomeLabel);

        createButton = new JButton("Create");
        createButton.setBounds(250, 350, 150, 40);
        createButton.setBackground(Color.BLUE);
        createButton.setForeground(Color.WHITE);
        createButton.setFocusable(false);
        createButton.addActionListener(this);
        l1.add(createButton);

        closeButton = new JButton("Close");
        closeButton.setBounds(450, 350, 150, 40);
        closeButton.setBackground(Color.RED);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);
        l1.add(closeButton);

        this.add(l1);
        this.setBounds(100, 0, 900, 600);
        this.setVisible(true);
   }    

   

   public void actionPerformed(ActionEvent e) {

    if (e.getSource() == createButton) {
        String userIdText, nameText, genderText, membershipTypeText, phoneText, emailText, addressText, passwordText, securityAnsText;
        int ageNum;

        if (!userId.getText().isEmpty() && !name.getText().isEmpty() && !phone.getText().isEmpty() && !email.getText().isEmpty()
                && !addressField.getText().isEmpty() && !passwordField.getText().isEmpty() && !securityAnsField.getText().isEmpty() && !age.getText().isEmpty()) {

            try {
                userIdText = userId.getText();
                nameText = name.getText();
                phoneText = phone.getText();
                emailText = email.getText();
                addressText = addressField.getText();
                passwordText = passwordField.getText();
                securityAnsText = securityAnsField.getText();
                genderText = (String) genderComboBox.getSelectedItem();
                membershipTypeText = (String) membershipTypeComboBox.getSelectedItem();
                ageNum = Integer.parseInt(age.getText());

                UserRepo ur = new UserRepo();
                User user = ur.searchUserByUserId(userIdText);

                if (user == null){
                    Client c = new Client(userIdText, nameText, emailText, phoneText, genderText, ageNum, addressText, 3, securityAnsText, passwordText, membershipTypeText);
                    ur.addUser(c);
                    ClientRepo cr = new ClientRepo();
                    boolean isValid = cr.addClient(c);
                    System.out.println(isValid);
                    if (isValid) {
                        JOptionPane.showMessageDialog(this, "Account created successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to create account.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "User ID already exists. Please choose another ID.");
                }
            } catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(this, "Please enter a valid age.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while creating the account.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        }
    }

    if (e.getSource() == closeButton) {
        this.setVisible(false);
        new Login();
    }
}
}
