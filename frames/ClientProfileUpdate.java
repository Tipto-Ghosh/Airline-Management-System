package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import interfaces.*;
import repositories.*;

public class ClientProfileUpdate extends JFrame implements ActionListener {

    private User user;
    private Client client;

    // Labels for displaying text
    private JLabel mainLabel, clientIdLabel, nameLabel, genderLabel, ageLabel, emailLabel, phoneNoLabel, addressLabel, membershipTypeLabel;
    private JTextField clientIdField, nameField, ageField, emailField, phoneNoField, addressField;
    private JComboBox<String> genderComboBox, membershipTypeComboBox;

    // Buttons
    private JButton updateButton, backButton;

    // Fonts
    private Font font = new Font("MV Boli", Font.BOLD, 16);
    private Font font2 = new Font("Arial", Font.BOLD, 16);

    public ClientProfileUpdate(User u , Client c){
          
        this.user = u;
        this.client = c;
      //----------------------------------------------------------------------------  
        // Create the mainLabel
        mainLabel = new JLabel();
        mainLabel.setBounds(0, 0, 900, 600);
        mainLabel.setLayout(null);
//----------------------------------------------------------------------------
        // Create label for "Update Client Information"
        JLabel welcomeLabel = new JLabel("Update Client Information");
        welcomeLabel.setBounds(50, 30, 400, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.BLACK);
        mainLabel.add(welcomeLabel);
//----------------------------------------------------------------------------

        // Client ID label and field
        clientIdLabel = new JLabel("Client ID:");
        clientIdLabel.setBounds(200, 100, 200, 30);
        clientIdLabel.setFont(font2);
        mainLabel.add(clientIdLabel);

        clientIdField = new JTextField(this.user.getUserId()); // Sample client ID
        clientIdField.setFont(font);
        clientIdField.setForeground(Color.BLUE);
        clientIdField.setEditable(false);
        clientIdField.setBounds(350, 100, 200, 30);
        mainLabel.add(clientIdField);
//----------------------------------------------------------------------------
        // Name label and field
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 150, 100, 30);
        nameLabel.setFont(font2);
        nameLabel.setForeground(Color.BLACK);
        mainLabel.add(nameLabel);

        nameField = new JTextField(this.client.getName()); // Sample name
        nameField.setFont(font);
        nameField.setEditable(false);
        nameField.setForeground(Color.BLUE);
        nameField.setBounds(200, 150, 200, 30);
        mainLabel.add(nameField);
//----------------------------------------------------------------------------
        // Age label and field
        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 200, 150, 30);
        ageLabel.setFont(font2);
        ageLabel.setForeground(Color.BLACK);
        mainLabel.add(ageLabel);

        ageField = new JTextField(String.valueOf(this.client.getAge())); // Sample age
        ageField.setFont(font);
        ageField.setForeground(Color.BLUE);
        ageField.setBounds(200, 200, 200, 30);
        mainLabel.add(ageField);
//----------------------------------------------------------------------------
        // Gender combo box
        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(450, 150, 100, 30);
        genderLabel.setFont(font2);
        genderLabel.setForeground(Color.BLACK);
        mainLabel.add(genderLabel);

        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setSelectedItem(this.client.getGender());
        genderComboBox.setBounds(600, 150, 200, 30);
        mainLabel.add(genderComboBox);
//----------------------------------------------------------------------------
        // Email label and field
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(450, 200, 100, 30);
        emailLabel.setFont(font2);
        emailLabel.setForeground(Color.BLACK);
        mainLabel.add(emailLabel);

        emailField = new JTextField(this.client.getEmail()); // Sample email
        emailField.setFont(font);
        emailField.setForeground(Color.BLUE);
        emailField.setBounds(600, 200, 200, 30);
        mainLabel.add(emailField);
//----------------------------------------------------------------------------
        // Phone number label and field
        phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setBounds(50, 250, 100, 30);
        phoneNoLabel.setFont(font2);
        phoneNoLabel.setForeground(Color.BLACK);
        mainLabel.add(phoneNoLabel);

        phoneNoField = new JTextField(this.client.getPhoneNo()); 
        phoneNoField.setFont(font);
        phoneNoField.setForeground(Color.BLUE);
        phoneNoField.setBounds(200, 250, 200, 30);
        mainLabel.add(phoneNoField);
//----------------------------------------------------------------------------
        // Address label and field
        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(450, 250, 100, 30);
        addressLabel.setFont(font2);
        addressLabel.setForeground(Color.BLACK);
        mainLabel.add(addressLabel);

        addressField = new JTextField(this.client.getAddress()); 
        addressField.setFont(font);
        addressField.setForeground(Color.BLUE);
        addressField.setBounds(600, 250, 200, 30);
        mainLabel.add(addressField);
//----------------------------------------------------------------------------
        // Membership type label and combo box
        membershipTypeLabel = new JLabel("Membership Type:");
        membershipTypeLabel.setBounds(50, 300, 150, 30);
        membershipTypeLabel.setFont(font2);
        membershipTypeLabel.setForeground(Color.BLACK);
        mainLabel.add(membershipTypeLabel);

        String[] membershipTypes = {"Basic", "Premium", "VIP"};
        membershipTypeComboBox = new JComboBox<>(membershipTypes);
        membershipTypeComboBox.setBounds(200, 300, 200, 30);
        membershipTypeComboBox.setSelectedItem(this.client.getGender());
        mainLabel.add(membershipTypeComboBox);
//----------------------------------------------------------------------------
                

//----------------------------------------------------------------------------
        // Update and Back buttons
        updateButton = new JButton("Update");
        updateButton.setBounds(250, 400, 150, 40);
        updateButton.setBackground(Color.BLUE);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusable(false);
        updateButton.addActionListener(this);
        mainLabel.add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(450, 400, 150, 40);
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        mainLabel.add(backButton);
//----------------------------------------------------------------------------
        // Adding all the things in the frame
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(mainLabel);

        // make it visible
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateButton) {
            if (!(ageField.getText().isEmpty() || emailField.getText().isEmpty() || addressField.getText().isEmpty())) {
                this.client.setEmail(emailField.getText());
                this.client.setAddress(addressField.getText());
                this.client.setPhoneNo(phoneNoField.getText());
                
                // Update the user info 
                this.user.setEmail(emailField.getText());
                this.user.setAddress(addressField.getText());
                this.user.setPhoneNo(phoneNoField.getText());

                try {
                    Integer ageCheck = Integer.parseInt(ageField.getText());
                    if (ageCheck > 150 || ageCheck < 0) {
                        JOptionPane.showMessageDialog(null, "Age should be greater than zero and less than 150", "Invalid Age", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        this.client.setAge(ageCheck);
                        this.user.setAge(ageCheck);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid Age Format", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
    
                try {
                    
                    if (genderComboBox.getSelectedItem() != null) {
                        this.client.setGender((String)genderComboBox.getSelectedItem());
                        this.user.setGender((String)genderComboBox.getSelectedItem());
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
    
                // Now update the info
                UserRepo ur = new UserRepo();
                ur.updateUser(user);
                ClientRepo cRepo = new ClientRepo();
                boolean add = cRepo.updateSelfProfile(client);
                if (add) {
                    JOptionPane.showMessageDialog(this, "Your Info updated Successfully");
                    ClientFrame cf = new ClientFrame(this.user);
                    this.setVisible(false);
                    cf.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Your Info updated Failed");
                    this.setVisible(false);
                    this.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Fill All the Fields");
            }
        }
    
        if (ae.getSource() == backButton) {
            ClientFrame cf = new ClientFrame(this.user);
            this.setVisible(false);
            cf.setVisible(true);
        }
    }
    
}
