package Home;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Services {
    
    JFrame frame;
    JLabel l1,l2,l3,l4,l5;
    Font f;
    Container c;
    
    public Services()
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(150,100,1620,930);
        frame.setTitle("Services");
        c = frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(null);
  
        f = new Font("TimesRoman",Font.BOLD,30);
       
        l1 = new JLabel("Etihad Airways Customer Service");
        l1.setForeground(Color.GREEN);
        l2 = new JLabel("Experience the hospitality of Etihad Airways while flying. The ideal trip starts with a trouble-free");
        l2.setForeground(Color.WHITE);
        l3 = new JLabel("flight booking experience. So, here at Etihad Airways Customer Service, we provide you that ");
        l3.setForeground(Color.WHITE);
        l4 = new JLabel("awesome experience with heavy discounts and great offers to avail on your flight tickets. There ");
        l4.setForeground(Color.WHITE);
        l5 = new JLabel("is no better choice than EA Customer Service for instant booking of air tickets at minimal prices.");
        l5.setForeground(Color.WHITE);
        l1.setFont(new Font("TimesRoman",Font.BOLD,50));
        l2.setFont(f);
        l3.setFont(new Font("TimesRoman",Font.BOLD,31));
        l4.setFont(f);
        l5.setFont(f);
        
        l1.setBounds(400, 50, 900, 100);
        l2.setBounds(130, 590, 1400, 100);
        l3.setBounds(130, 650, 1400, 100);
        l4.setBounds(130, 710, 1400, 100);
        l5.setBounds(130, 770, 1400, 100);
        
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        
        
        
        JLabel backimg = new JLabel();
        ImageIcon image=new ImageIcon(this.getClass().getResource("service.jpg"));
        Image imga = image.getImage().getScaledInstance(1600, 1080, Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(imga);
        backimg.setIcon(img1);
        backimg.setBounds(0, 0, 1600, 900);
        c.add(backimg);
        
        frame.setVisible(true);
        
    }

}
