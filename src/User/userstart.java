package User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userstart extends JFrame implements ActionListener {

    JFrame frame;
    JLabel l1,l2,l3,l4;
    JButton b1, b2, b3, b4, b5;
    Font f;
    Container c;

    public userstart() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1900, 1080);
        frame.setTitle("User Module");
        c = frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(null);
        c.setLayout(null);
        f = new Font("TimesRoman", Font.BOLD, 20);

        b1 = new JButton();
        ImageIcon icon=new ImageIcon(this.getClass().getResource("bookticket.png"));
        java.awt.Image icon1 = icon.getImage().getScaledInstance(280, 200, java.awt.Image.SCALE_DEFAULT);
        ImageIcon icon2=new ImageIcon(icon1);
        b1.setIcon(icon2);
        b2 = new JButton();
        ImageIcon icon3=new ImageIcon(this.getClass().getResource("flightenquiry.png"));
        java.awt.Image icon4 = icon3.getImage().getScaledInstance(280, 200, java.awt.Image.SCALE_DEFAULT);
        ImageIcon icon5=new ImageIcon(icon4);
        b2.setIcon(icon5);
       
        b3 = new JButton();
        ImageIcon icon6=new ImageIcon(this.getClass().getResource("cancelticket.jfif"));
        java.awt.Image icon7 = icon6.getImage().getScaledInstance(280, 200, java.awt.Image.SCALE_DEFAULT);
        ImageIcon icon8=new ImageIcon(icon7);
        b3.setIcon(icon8);
        
        b4 = new JButton();
        ImageIcon icon9=new ImageIcon(this.getClass().getResource("checkticket.png"));
        java.awt.Image icon10 = icon9.getImage().getScaledInstance(280, 200, java.awt.Image.SCALE_DEFAULT);
        ImageIcon icon11=new ImageIcon(icon10);
        b4.setIcon(icon11);
        b5 = new JButton("BACK");
        b5.setFont(f);
      
        
        l1 = new JLabel("Book Ticket");
        l1.setFont(f);
        l2 = new JLabel("Flight Enquiry");
        l2.setFont(f);
        l3 = new JLabel("Cancel Ticket");
        l3.setFont(f);
        l4 = new JLabel("Ticket Enquiry");
        l4.setFont(f);

        b1.setBounds(200, 400, 280, 200);
        b2.setBounds(600, 400, 280, 200);
        b3.setBounds(1000, 400, 280, 200);
        b4.setBounds(1400, 400, 280, 200);
        b5.setBounds(50, 900, 200, 50);
        
        l1.setBounds(270, 620, 150, 30);
        l2.setBounds(670, 620, 150, 30);
        l3.setBounds(1070, 620, 150, 30);
        l4.setBounds(1470, 620, 150, 30);

        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        
        JLabel backimg1 = new JLabel();
        ImageIcon image=new ImageIcon(this.getClass().getResource("backimg1.png"));
        Image imga = image.getImage().getScaledInstance(1900, 500, Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(imga);
        backimg1.setIcon(img1);
        backimg1.setBounds(0, 0, 1900, 500);
        c.add(backimg1);
        
        JLabel backimg2 = new JLabel();
        ImageIcon image1=new ImageIcon(this.getClass().getResource("backimg2.png"));
        Image imga1 = image1.getImage().getScaledInstance(1900, 600, Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(imga1);
        backimg2.setIcon(img2);
        backimg2.setBounds(0, 500, 1900, 600);
        c.add(backimg2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            BookTicket bt = new BookTicket();
        }

        if (ae.getSource() == b2) {
            FlightEnquiry ch = new FlightEnquiry();
        }

        if (ae.getSource() == b3) {
            CancelTiket ca = new CancelTiket();
        }

        if (ae.getSource() == b4) {
            TicketEnquiry te = new TicketEnquiry();

            te.setTitle("Check Ticket");
            te.setResizable(false);

        }

        if (ae.getSource() == b5) {
            Home.Main m = new Home.Main();
            frame.dispose();
        }

    }

    public static void main(String[] args) {
        userstart f = new userstart();

    }

}
