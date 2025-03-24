package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.*;
import interfaces.*;
import repositories.*;

public class Login extends JFrame implements ActionListener{
    
 // declare all the frame , panel , labels and others
 JLabel label1 , label2 , label3 , label4 , label5 , label6 , label7;
 JTextField userNameField,passwordField;
 JButton loginButton , signUpButton , forgetPasswordButton;


 public Login(){
    this.setBounds(350, 100, 580, 500);
    this.setLayout(null);
    this.setTitle("LogIn Account");
    this.setBackground(Color.WHITE);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Create the image to add:
    ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/front.jpg"));
    Image logInImage = image1.getImage().getScaledInstance(580, 500, Image.SCALE_SMOOTH);
    ImageIcon loginImageIcon = new ImageIcon(logInImage);

    // Create the Label to add the pic and buttons
    label1 = new JLabel();
    label1.setBounds(0,0,580,500);
    label1.setLayout(null);
    label1.setIcon(loginImageIcon);

    
    
    // create another label for add textField and password and buttons
    label2 = new JLabel("UserName");
    label2.setBounds(120, 120 , 150 , 30);
    label2.setForeground(Color.BLACK);
    label2.setFont(new Font("Arial" , Font.BOLD , 20));


    // add userName textField in label1
    userNameField = new JTextField();
    userNameField.setBounds(320 , 120 , 150 , 30);
    // add userName field to the userName label[]
     label1.add(userNameField);


    // adding Label2 to label
    label1.add(label2);

    // create a label to show password text
    label4 = new JLabel("Password");
    label4.setBounds(120, 170 , 150 , 30);
    label4.setForeground(Color.BLACK);
    label4.setFont(new Font("Arial" , Font.BOLD , 20));

    // create passwordField and it to the label4
    passwordField = new JTextField();
    passwordField.setBounds(320 , 170 , 150 , 30);

    // adding password field to the label4
    label1.add(passwordField);

    // adding label4 to label1 
    label1.add(label4);
    



    label3 = new JLabel("Login Account");
    label3.setBounds(190 , 30 , 500 , 50);
    label3.setForeground(Color.BLACK);
    label3.setFont(new Font("Arial" , Font.BOLD , 30));

    //-------------------------------------------------------------
    label5 = new JLabel("If you don't have any Account! Then press SignUp to Create New Account");
    label5.setBounds(90 , 270 , 550 , 40);
    label5.setForeground(Color.RED);
    
    label1.add(label5);
    //-------------------------------------------------------------
      // Forget password label and button
      label6 = new JLabel("If You Forget Your Password! Then press Forget Password");
      label6.setForeground(Color.RED);
      label6.setBounds(90 , 330 , 550 , 30);
      label1.add(label6);

      forgetPasswordButton = new JButton("Forget Password");
      forgetPasswordButton.setBounds(200 , 360 , 150 , 40);
      forgetPasswordButton.setBackground(Color.BLACK);
      forgetPasswordButton.setForeground(Color.WHITE);
      forgetPasswordButton.setFocusable(false);
      forgetPasswordButton.addActionListener(this);
      label1.add(forgetPasswordButton);

    //-------------------------------------------------------------

    // adding label3 to label1
    label1.add(label3);

    // creating the login button
    loginButton = new JButton("Login");
    loginButton.setBackground(Color.BLACK);
    loginButton.setForeground(Color.WHITE);
    loginButton.setFocusable(false);
    loginButton.setBounds(120 , 220 , 150 , 40);
    loginButton.addActionListener(this);

    // add the login button in label1
    label1.add(loginButton);

    // creating the signUp button
    signUpButton = new JButton("SignUp");
    signUpButton.setBackground(Color.BLACK);
    signUpButton.setForeground(Color.WHITE);
    signUpButton.setBounds(320 , 220 , 150 , 40);
    signUpButton.setFocusable(false);
    signUpButton.addActionListener(this);

    // add the button in label1
    label1.add(signUpButton);
   


     // give the size and position of the frame
     this.setSize(580, 500);

    // adding label1 to the frame
    this.add(label1);

     this.setVisible(true);


 }

   
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == loginButton){
            
            String id , pass;

            // Check empty Field
            if((userNameField.getText().isEmpty()) || (passwordField.getText().isEmpty())){ // if any of 2 is empty
                JOptionPane.showMessageDialog(this , "Fill All the Fields" , "Empty Field" , JOptionPane.ERROR_MESSAGE);
            }
            else{ // If not empty
               id = userNameField.getText();
               pass = passwordField.getText();
               
               // Now check Validity of user
                UserRepo urp = new UserRepo();
			       User user = urp.searchUserByUserId(id); // If null invalid else valid
             
               if(user != null){
                   System.out.println(user.getRole());
                // Check for Authority
                 if(user.getUserId().equals(id) && user.getPassword().equals(pass) && user.getRole() == 1){
                    this.setVisible(false);
                    AuthorityFrame af = new AuthorityFrame(user);
                    af.setVisible(true);  
                 }
                // Check for Employee
                  else if(user.getUserId().equals(id) && user.getPassword().equals(pass) && user.getRole() == 2){
                    this.setVisible(false);
                   EmployeeFrame ep = new EmployeeFrame(user);
                   ep.setVisible(true);
                 }
                // Check for Client
                  else if(user.getUserId().equals(id) && user.getPassword().equals(pass) && user.getRole() == 3){
                    this.setVisible(false);
                    ClientFrame cf = new ClientFrame(user);
                    cf.setVisible(true);
                 }
                 else{
                    JOptionPane.showMessageDialog(this , "Wrong user or Password" , "Invalid User or Password" , JOptionPane.ERROR_MESSAGE);
                 }
               }
               else{
                  JOptionPane.showMessageDialog(this , "Wrong user or Password" , "Invalid User or Password" , JOptionPane.ERROR_MESSAGE);
               }
         
            }
        }
        if(e.getSource() == signUpButton){
           this.setVisible(false);
           SignUpFrame sf = new SignUpFrame();
        }
        if(e.getSource() == forgetPasswordButton){	
			this.setVisible(false);
            // Open the ForgetPasswordFrame
            ForgetPasswordFrame fpf = new ForgetPasswordFrame();
            fpf.setVisible(true);
		}
    }
    
}
