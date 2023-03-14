package Home;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;   

public class Main extends JFrame implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6;
    JFrame frame;
    JLabel l1,l2,l3,l4,l5;
    Font f,f1;
    Container c;
   public Main()
    {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(20,20,1900,1000);
        frame.setTitle("Airline System");
        c = frame.getContentPane();
        c.setLayout(null);
        f = new Font(Font.SANS_SERIF,Font.BOLD,30);
        f1 = new Font(Font.SANS_SERIF,Font.BOLD,85);
        
        //get time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String ctime = dtf.format(now.plusHours(2));
        
        database c1 = new database();
        try
        {
            //Find Flight whose time is over
            String q1 = "Select * from ActiveFlight Where fdate<='"+java.time.LocalDate.now()+"';";
//                    +"' AND ftime<='"+ctime+"' ;";
            ResultSet rs = c1.s.executeQuery(q1);
            int i=0;
            while (rs.next()) 
            {
                System.out.println(rs.getString(1));
                i++;
            }

            String[] flight_id = new String[i];
            String[][] data = new String[i][7];
            rs.beforeFirst();
            int j=0;

            while (rs.next())
            {                     
                //Count total reserve Ticket in each flight 
                database c2= new database();
                String q2 = "Select count(*) from Ticket Where f_id='"+rs.getString(1)+"'";
                ResultSet rs1 = c2.s.executeQuery(q2);
                rs1.next();
                //insert data into Confirm flight table
                database c3= new database();
                String q3 = "insert into ConfirmFlight ( id , departure , arrival , fdate ,"
                        + " ftime , charges , res_seat ) "
                        +" Values ('"+rs.getString(1)+"','"+rs.getString(2)+"','"+rs.getString(3)+"','"
                        +rs.getString(4)+"','"+rs.getString(5)+"',"+rs.getInt(6)+","+rs1.getInt(1)+");";
                int value = c3.s.executeUpdate(q3);
                if (value==1) 
                {
                    //Delete from Active Flight
                     database c4= new database();
                    String q4 = "DELETE FROM ActiveFlight WHERE id='"+rs.getString(1)+"';";
                    int val = c4.s.executeUpdate(q4);
                }

                j++;
            }
               
        }
        catch (SQLException ev) 
        {
            ev.printStackTrace();
            JOptionPane.showMessageDialog(null, "Some error in Flight record");
        }
       
        l4 =new JLabel("WELLCOME TO ETIHAD");
        l5 = new JLabel("AIRWAYS");
        l4.setFont(f1);
        l4.setForeground(Color.BLUE);
        l5.setFont(f1);
        l5.setForeground(Color.BLUE);
        l4.setBounds(500, 20, 1000, 100);
        l5.setBounds(750, 120, 1000, 100);
        c.add(l4);
        c.add(l5);

        b1 = new JButton("Contact Us");
        b1.setBackground(Color.ORANGE);
        b1.setFont(f);
        b1.setBounds(0,600, 475,40);

        b2 = new JButton("About Us");
        b2.setBackground(Color.ORANGE);
        b2.setFont(f);
        b2.setBounds(475,600, 475,40);

        b3 = new JButton("Guidlines");
        b3.setBackground(Color.ORANGE);
        b3.setFont(f);
        b3.setBounds(950,600, 475,40);

        b4 = new JButton("Services");
        b4.setBackground(Color.ORANGE);

        b4.setFont(f);
        b4.setBounds(1425,600, 475,40);

        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);

        //Image Icon for Admin and User
        b5 = new JButton("");
        b5.setIcon(new ImageIcon(this.getClass().getResource("admin.png")));
        b5.setBounds(640, 700, 200, 200);
        b6 = new JButton("");
        b6.setIcon(new ImageIcon(this.getClass().getResource("user.png")));
        b6.setBounds(1040, 700, 200, 200);
        c.add(b5);
        c.add(b6);

        l2 = new JLabel("Admin");
        l2.setFont(f);
        l2.setForeground(Color.ORANGE);
        l2.setBounds(710, 900, 100, 40);
        l3 = new JLabel("User");
        l3.setFont(f);
        l3.setForeground(Color.ORANGE);
        l3.setBounds(1110, 900, 100, 40);
        c.add(l2);
        c.add(l3);

        //Background Image
        JLabel label = new JLabel();
        ImageIcon image=new ImageIcon(this.getClass().getResource("Airway.png"));
        java.awt.Image imga = image.getImage().getScaledInstance(1900, 1000, java.awt.Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(imga);
        label.setIcon(img1);
        label.setBounds(0, 0, 1900, 1000);

        frame.add(label);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==b1) 
        {
            ContactUs cu = new ContactUs();
        }
         
        if (e.getSource()==b2) 
        {
            AboutUs ab = new AboutUs();
        }
        
        if (e.getSource()==b3)
        {
            new Guidlines();
        }
        
        if (e.getSource()==b4)
        {
            new Services();
        }
        
        if (e.getSource()==b6) {
            new User.userstart();
            frame.dispose();
            
        }
        if (e.getSource()==b5) {
            new Admin.login();
            frame.dispose();
            
            
        }
        
    }
    
    public static void main(String[] args) {
        Main m = new Main();
    }
    
}
