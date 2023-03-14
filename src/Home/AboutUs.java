package Home;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutUs {
    JFrame frame;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Font f,f1;
    Container c;

    public AboutUs() {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(150,100,1620,930);
        frame.setTitle("About Us");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
  
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,25);
        //About Image
        l1 = new JLabel();
        l1.setIcon(new ImageIcon(this.getClass().getResource("about.png")));
        l1.setBounds(0, 0, 1600, 500);
        c.add(l1);
        //Mission Statement
        l2 = new JLabel("Mission");
        l3 = new JLabel("From our leading community initiatives to providing aid in times of crisis, our mission is to make a real change to");
        l4 = new JLabel("the world we live in. Across the globe, we are committed to improving the wellbeing of people everywhere.");
        
        l2.setFont(f1);
        l3.setFont(f);
        l4.setFont(f);
        
        l2.setBounds(750, 520, 150, 40);
        l3.setBounds(300, 550, 1200, 100);
        l4.setBounds(330, 580, 1100, 100);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        //Vission Statement
        l5 = new JLabel("Vission");
        l6 = new JLabel("Etihad Airways' vision is to be the best airline in the world, . The airline seeks to reflect its values ");
        l7 = new JLabel("of Arabian hospitality and warmth- world class business and leisure destination.");
        
        l5.setFont(f1);
        l6.setFont(f);
        l7.setFont(f);
        
        l5.setBounds(750, 640, 150, 40);
        l6.setBounds(300, 670, 1000, 100);
        l7.setBounds(350, 700, 1000, 100);
        c.add(l5);
        c.add(l6);
        c.add(l7);
        
        
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
       new AboutUs();
    }
    
}
