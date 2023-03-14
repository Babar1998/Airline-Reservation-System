package User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketEnquiry extends JFrame implements ActionListener {
    TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Button b1,b2,b3,b4;
    JFrame frame;
    Font f,f1;
    Container c;

    public TicketEnquiry()
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(600, 200, 800, 700);
        frame.setTitle("Ticket Enquiry");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
        c.setLayout(null);
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,15);
        //Initialize all Label 
        l10 = new Label("Search By Ticket No");
        l10.setFont(f);

        l1 = new Label("Ticket No");
        l1.setFont(f);
        l2 = new Label("Name");
        l2.setFont(f);
        l3 = new Label("Departure");
        l3.setFont(f);
        l4 = new Label("Arrival");
        l4.setFont(f);
        l5 = new Label("Travel Date");
        l5.setFont(f);
        l6 = new Label("Time");
        l6.setFont(f);
        l7 = new Label("Res Date");
        l7.setFont(f);
        l8 = new Label("Class Type");
        l8.setFont(f);
        l9 = new Label("Seat No");
        l9.setFont(f);
        //Initialize all Butoon
        b1 = new Button("Search");
        b1.setFont(f);
        b2 = new Button("Close");
        b2.setFont(f);
       
        //Initialize all Textfield
        t1 = new TextField();
        t1.setFont(f1);
        t2 = new TextField();
        t2.setEditable(false);
        t2.setFont(f1);
        t3 = new TextField();
        t3.setEditable(false);
        t3.setFont(f1);
        t4 = new TextField();
        t4.setEditable(false);
        t4.setFont(f1);
        t5 = new TextField();
        t5.setEditable(false);
        t5.setFont(f1);
        t6 = new TextField();
        t6.setEditable(false);
        t6.setFont(f1);
        t7 = new TextField();
        t7.setEditable(false);
        t7.setFont(f1);
        t8 = new TextField();
        t8.setEditable(false);
        t8.setFont(f1);
        t9 = new TextField();
        t9.setEditable(false);
        t9.setFont(f1);
        //set Location of all Label
        l1.setBounds(100, 100, 200, 40);
        l2.setBounds(100, 150, 200, 40);
        l3.setBounds(100, 200, 200, 40);
        l4.setBounds(100, 250, 200, 40);
        l5.setBounds(100, 300, 200, 40);
        l6.setBounds(100, 350, 200, 40);
        l7.setBounds(100, 400, 200, 40);
        l8.setBounds(100, 450, 200, 40);
        l9.setBounds(100, 500, 200, 40);
        l10.setBounds(200, 30, 200, 40);
        //Set Location of all Textfield
        t1.setBounds(300, 105, 250, 25);
        t2.setBounds(300, 155, 250, 25);
        t3.setBounds(300, 205, 250, 25);
        t4.setBounds(300, 255, 250, 25);
        t5.setBounds(300, 305, 250, 25);
        t6.setBounds(300, 355, 250, 25);
        t7.setBounds(300, 405, 250, 25);
        t8.setBounds(300, 455, 250, 25);
        t9.setBounds(300, 505, 250, 25);

        //Set location of all Button
        b1.setBounds(600,105,100,40);
        b2.setBounds(100,600,100,40);
       
        //Add all Label
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
        //Add all Textfield
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(t4);
        c.add(t5);
        c.add(t6);
        c.add(t7);
        c.add(t8);
        c.add(t9);
        //Add Button
        c.add(b1);
        c.add(b2);
        //Registered Button
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        frame.setVisible(true);
         
    }

    public void actionPerformed(ActionEvent ae) {
                 
        if (ae.getSource() == b1)
        {
            
            Home.database c1 = new Home.database();
            try 
            {
                //Access specific Ticket record from Database
                int ticket_id = Integer.parseInt(t1.getText());
                String s ="SELECT Passenger.pass_name,ActiveFlight.departure,ActiveFlight.arrival,"
                        + "ActiveFlight.fdate,ActiveFlight.ftime,Ticket.res_date,"
                        + "Ticket.class_type,Ticket.seat_no FROM (ticket INNER JOIN passenger"
                        + " ON Ticket.pass_id=Passenger.pass_id) INNER JOIN ActiveFlight"
                        + " ON Ticket.f_id=ActiveFlight.id where t_id="+ticket_id;
                ResultSet rs = c1.s.executeQuery(s);
                
                if (rs.next()) {
                    
                   t2.setText(rs.getString(1));
                   t3.setText(rs.getString(2));
                   t4.setText(rs.getString(3));
                   t5.setText(rs.getString(4));
                   t6.setText(rs.getString(5));
                   t7.setText(rs.getString(6));
                   t8.setText(rs.getString(7));
                   t9.setText(rs.getString(8));
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This ticket can not reserved");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                    
                }
                    
            }
             catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Enter Correct input");
            }
            finally
            {
                try 
                {
                    c1.s.close();
                } 
                catch (SQLException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Database Connection cannot close");
                }
            }
        }
        
         if (ae.getSource() == b2)
        {
            //Close Frame
            frame.dispose();
        }


    }
    public static void main(String[] args) {
        new TicketEnquiry();
    }



}
