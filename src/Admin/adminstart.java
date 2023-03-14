package Admin;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JFrame;




public class adminstart implements ActionListener
{
    String username,password,name,email;
    JLabel l1,l2;
    JFrame frame;
    JButton b1,b2,b3,b4,b5,b6;
    MenuBar mb1;
    Menu m1,m2,m3,m4;
    MenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15,mi16,mi17;
    Font f,f1;
    JPanel left, center;
    Container c;
    byte[] image = null;

    public adminstart()
    {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1900,1080);
        frame.setTitle("Admin Module");
        c = frame.getContentPane();
        
        c.setLayout(new BorderLayout());
        
       
        try 
        {
            Home.database c1 = new Home.database();
            username = Admin.login.usertxt.getText();
            String q = "Select password,profile,name,email from Admin where username='"+username+"'";
            ResultSet rs = c1.s.executeQuery(q);
            if (rs.next()) 
            {
                password = rs.getString(1);
                image = rs.getBytes(2);
                name = rs.getString(3);
                email = rs.getString(4);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Admin User detail access error");
        }
       
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.PLAIN,20);
        //MenuBar
        mb1 = new MenuBar();
        frame.setMenuBar(mb1);
        //First Menu
        m1 = new Menu("Manage Account");
        m1.setFont(f);
        //Menu Item
        mi1 = new MenuItem("Change Password");
        mi1.setFont(f1);
        mi2 = new MenuItem("Change Name");
        mi2.setFont(f1);
        mi3 = new MenuItem("Change Email");
        mi3.setFont(f1);
        mi4 = new MenuItem("Delete Account");
        mi4.setFont(f1);
       
    
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi4);
        //Second Menu
        m2 = new Menu("Ticket");
        m2.setFont(f);
        //Menu Item
        mi5 = new MenuItem("Book Ticket");
        mi5.setFont(f1);
        mi6 = new MenuItem("Update Ticket");
        mi6.setFont(f1);
        mi7 = new MenuItem("Ticket Enquiry");
        mi7.setFont(f1);
        mi8 = new MenuItem("Cancel Ticket");
        mi8.setFont(f1);
        
        m2.add(mi5);
        m2.add(mi6);
        m2.add(mi7);
        m2.add(mi8);
        //Third Menu
        m3 = new Menu("Flight");
        m3.setFont(f);
        //Menu Item
        mi9 = new MenuItem("Add Flight");
        mi9.setFont(f1);
        mi10 = new MenuItem("Update Flight");
        mi10.setFont(f1);
        mi11 = new MenuItem("Flight Enquiry");
        mi11.setFont(f1);
        mi12 = new MenuItem("Cancel Flight");
        mi12.setFont(f1);
        
        m3.add(mi9);
        m3.add(mi10);
        m3.add(mi11);
        m3.add(mi12);
        //Forth Menu
        m4 = new Menu("Report");
        m4.setFont(f);
        //Menu Item
        mi13 = new MenuItem("Confirm Flight");
        mi13.setFont(f1);
        mi14 = new MenuItem("Waiting Flight");
        mi14.setFont(f1);
        mi15 = new MenuItem("Daily Report");
        mi15.setFont(f1);
        mi16 = new MenuItem("Messages");
        mi16.setFont(f1);
        mi17 = new MenuItem("Passenger Detail");
        mi17.setFont(f1);
        
        m4.add(mi13);
        m4.add(mi14);
        m4.add(mi15);
        m4.add(mi16);
        m4.add(mi17);
        //Add all Menu into MenuBar
        mb1.add(m1);
        mb1.add(m2);
        mb1.add(m3);
        mb1.add(m4);
        //Registered all Menu Item
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);
        mi7.addActionListener(this);
        mi8.addActionListener(this);
        mi9.addActionListener(this);
        mi10.addActionListener(this);
        mi11.addActionListener(this);
        mi12.addActionListener(this);
        mi13.addActionListener(this);
        mi14.addActionListener(this);
        mi15.addActionListener(this);
        mi16.addActionListener(this);
        mi17.addActionListener(this);
        
        //Left Panel
        left = new JPanel();
        left.setLayout(null);
        left.setBackground(Color.BLUE);
        left.setPreferredSize(new Dimension(300, 0));
        
        Font f2 = new Font("Timeroman", Font.BOLD,25);
        //Profile Image
        l1 = new JLabel();
        Image img = Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icon=new ImageIcon(img);
        Image icon2 = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon3=new ImageIcon(icon2);
        l1.setIcon(icon3);
        l1.setBounds(90, 30, 100, 100);
        left.add(l1);
        
       
        l2 = new JLabel(name);
        l2.setFont(f2);
        l2.setForeground(Color.WHITE);
        l2.setBounds(80, 120, 200, 40);
        left.add(l2);
        
        b1 = new JButton("View Proflie");
        b1.setFont(f1);
        b1.setBounds(70, 200, 150, 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        left.add(b1);
        
        b2 = new JButton("Create New Admin");
        b2.setFont(f1);
        b2.setBounds(50, 350, 200, 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        left.add(b2);
        
        b3 = new JButton("Logout");
        b3.setFont(f1);
        b3.setBounds(70, 850, 100, 40);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        left.add(b3);
        //Registered all Button
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        c.add(left , BorderLayout.WEST);
        //Center Panel
        center = new JPanel();
        center.setLayout(null);
        center.setPreferredSize(new Dimension(300, 0));
        //Main Image
        JLabel label = new JLabel();
        ImageIcon image=new ImageIcon(this.getClass().getResource("adminfont.jpg"));
        Image imga = image.getImage().getScaledInstance(1600, 1080, Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(imga);
        label.setIcon(img1);
        label.setBounds(0, 0, 1600, 1080);
        center.add(label);
        
        c.add(center , BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==b1)
        {
            ViewProfile vp = new ViewProfile(this);
        }
        
        if (ae.getSource()==b2)
        {
            NewAdmin ad = new NewAdmin();
            
        }
       
        if (ae.getSource() == b3)
        {
            JOptionPane.showMessageDialog(null, "Logout");
            Home.Main m = new Home.Main();
            frame.dispose();   
        }
        
        if (ae.getSource()== mi1) 
        {
            Changepassword cp = new Changepassword();
        }
        
        if (ae.getSource()== mi2) 
        {
            Changename cn = new Changename(this);
        }
        
        if (ae.getSource()==mi3)
        {
            Changeemail ce = new Changeemail();
        }

        if (ae.getSource()==mi4)
        {
            Home.database c1= new Home.database();
            try
            {
                //Delete Account
                String q1 = "Delete From Admin where username='"+username+"' ;";
                int value = c1.s.executeUpdate(q1);
                if (value==1)
                {
                    JOptionPane.showMessageDialog(null, "Delete Account Successfully");
                    new login();
                    frame.dispose();
                }
                else  
                    JOptionPane.showMessageDialog(null, "Account Can't Delete");
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Account Can't Delete");
            }
         }
        
        if (ae.getSource()== mi5) 
        {
            User.BookTicket ct = new User.BookTicket();
        }
        
         if (ae.getSource()== mi6) 
        {
           UpdateTicket up =new UpdateTicket();
        }
         
        if (ae.getSource()== mi7) 
        {
            User.TicketEnquiry te = new User.TicketEnquiry();
        }
          
        if (ae.getSource() == mi8) 
        {
            User.CancelTiket ca = new User.CancelTiket();
        }
           
        if (ae.getSource() == mi9) 
        {
            Addflight a = new Addflight();
        }
        
             
        if (ae.getSource() == mi10) 
        {
            UpdateFlight up = new UpdateFlight();
        }
        
        if (ae.getSource() == mi11) 
        {
            User.FlightEnquiry ch = new User.FlightEnquiry();
        }
        
             
        if (ae.getSource() == mi12) 
        {
            CancelFlight cf = new CancelFlight();
        }
        
        if (ae.getSource()==mi13)
        {
            ConfirmFlight cf = new ConfirmFlight();
        }
        
        if (ae.getSource()==mi14)
        {
             WaitingFlight wf = new WaitingFlight();
        }
        
        if (ae.getSource()==mi15)
        {
            DailyReport dp =new DailyReport();
        }
        
        if (ae.getSource()==mi16)
        {
            new Messages();
        }

        if (ae.getSource()==mi17)
        {
            new  FlightPassenger();
        }
       
    }

  

    
    public static void main(String[] args) {
        new adminstart();
    }

   
    
}
