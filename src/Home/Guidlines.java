package Home;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Guidlines {
    
    JFrame frame;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Font f;
    Container c;
    
    public Guidlines()
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(400,100,1050,930);
        frame.setTitle("Guidlines");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
  
        f = new Font("TimesRoman",Font.BOLD,17);
        
        JLabel backimg = new JLabel();
        ImageIcon image=new ImageIcon(this.getClass().getResource("guidepics.jpg"));
        Image imga = image.getImage().getScaledInstance(1050, 500, Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(imga);
        backimg.setIcon(img1);
        backimg.setBounds(0, 0, 1050, 500);
        c.add(backimg);
        
        l1 = new JLabel("Updates on Travel Advisories and Requirements due to COVID-19 outbreak");
        l1.setForeground(Color.GREEN);
        l1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        l2 = new JLabel("Last updated: Dec 9, 2021 ");
        l2.setForeground(Color.WHITE);
        l2.setFont(f);
        l3 = new JLabel("Dear Valued Customers,");
        l3.setForeground(Color.WHITE);
        l3.setFont(f);
        l4 = new JLabel("Due to the situation of the COVID-19 (novel coronavirus) outbreak globally, our regular international flight operations");
        l4.setForeground(Color.WHITE);
        l4.setFont(f);
        l5 = new JLabel("have been affected. We are working closely with authorities and we aim to gradually return to regular flight operations");
        l5.setForeground(Color.WHITE);
        l5.setFont(f);
        l6 = new JLabel("as soon as circumstances allow.");
        l6.setForeground(Color.WHITE);
        l6.setFont(f);
        l7 = new JLabel("It is mandatory to provide personal contact information at the time of booking for all flights. Travel requirements and");
        l7.setForeground(Color.WHITE);
        l7.setFont(f);
        l8 = new JLabel("restrictions to your destination countries will be updated here. ");
        l8.setForeground(Color.WHITE);
        l8.setFont(f);
        l9 = new JLabel("Effective December 6, 2021, Only fully vaccinated passengers of age 18 years and above will be allowed to");
        l9.setForeground(Color.RED);
        l9.setFont(f);
        l10 = new JLabel("undertake Domestic/International travel on Inbound/Outbound travel to/from UAE");
        l10.setForeground(Color.RED);
        l10.setFont(f);
        
        l1.setBounds(50, 530, 900, 40);
        l2.setBounds(50, 570, 300, 30);
        l3.setBounds(50, 600, 300, 30);
        l4.setBounds(50, 630, 920, 30);
        l5.setBounds(50, 660, 930, 30);
        l6.setBounds(50, 690, 300, 30);
        l7.setBounds(50, 720, 930, 30);
        l8.setBounds(50, 750, 500, 30);
        l9.setBounds(50, 780, 930, 30);
        l10.setBounds(50, 810, 800, 30);
        
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);
        c.add(l7);
        c.add(l8);
        c.add(l9);
        c.add(l10);
        
        frame.setVisible(true);
        
    }
    
}
