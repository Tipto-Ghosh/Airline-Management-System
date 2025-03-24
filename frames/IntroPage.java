package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;


public class IntroPage extends JFrame{
    
    ImageIcon introImage;
    JLabel label;

    public IntroPage(){
      introImage = new ImageIcon("Icons//welcomePage.jpg");
      Image introImage1 = introImage.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
      ImageIcon introImageIcon = new ImageIcon(introImage1);

      label = new JLabel(introImageIcon); //Adding ImageIcon to the label

      // adding label to the frame
      this.add(label);
	  this.setTitle("Welcome To Java AirLine!!!!!!!");
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      
      introAnimation();
      // After shwoing animation the page will stay 5 seconds and then login option will visible
      try{
        Thread.sleep(2000);
        this.setVisible(false);

        Login l = new Login(); // Show the login page
      }
      catch(Exception e){
         e.printStackTrace();
      }
    }
    

    private void introAnimation(){
        
      // Make the Intro Page[Smaller to larger]
      int x = 1;
      int i = 2; 
      while(i <= 600){
        this.setLocation(600 - (i + x)/2 , 350 - (i/2));
        this.setSize(i + 3*x , i + x/2);

        try{
            Thread.sleep(10);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        i += 4;
        x ++;
      }
    }
}