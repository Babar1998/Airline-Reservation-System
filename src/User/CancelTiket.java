package User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CancelTiket extends JFrame implements ActionListener {
    TextField t1,t2,t3,t4,t5,t6;
    Label l1,l2,l3,l4,l5,l6,l7;
    Button b1,b2,b3,b4;
    JFrame frame;
    Font f,f1;
    Container c;

    public CancelTiket()
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(600, 200, 800, 700);
        frame.setTitle("Cancel Ticket");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
        c.setLayout(null);
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,15);
        //Initialize all Label
        l7 = new Label("Search By Ticket No");
        l7.setFont(f);

        l1 = new Label("Ticket No");
        l1.setFont(f);
        l2 = new Label("Name");
        l2.setFont(f);
        l3 = new Label("Departure");
        l3.setFont(f);
        l4 = new Label("Arrival");
        l4.setFont(f);
        l5 = new Label("Traval Date");
        l5.setFont(f);
        l6 = new Label("Return Amount");
        l6.setFont(f);
        //Initialize all Button
        b1 = new Button("Submit");
        b1.setFont(f);
        b2 = new Button("Reset");
        b2.setFont(f);
        b3 = new Button("Close");
        b3.setFont(f);
        b4 = new Button("Search");
        b4.setFont(f);
        //Initialize all TextField
        t1 = new TextField();
        t1.setFont(f1);
        t2 = new TextField();
        t2.setFont(f1);
        t2.setEditable(false);
        t3 = new TextField();
        t3.setFont(f1);
        t3.setEditable(false);
        t4 = new TextField();
        t4.setFont(f1);
        t4.setEditable(false);
        t5 = new TextField();
        t5.setFont(f1);
        t5.setEditable(false);
        t6 = new TextField();
        t6.setFont(f1);
        t6.setEditable(false);
        //Set Location of all Label
        l1.setBounds(100, 100, 200, 40);
        l2.setBounds(100, 150, 200, 40);
        l3.setBounds(100, 200, 200, 40);
        l4.setBounds(100, 250, 200, 40);
        l5.setBounds(100, 300, 200, 40);
        l6.setBounds(100, 350, 200, 40);
        l7.setBounds(300, 35, 200, 40);
        //Set Location of all Textfield
        t1.setBounds(300, 105, 250, 25);
        t2.setBounds(300, 155, 250, 25);
        t3.setBounds(300, 205, 250, 25);
        t4.setBounds(300, 255, 250, 25);
        t5.setBounds(300, 305, 250, 25);
        t6.setBounds(300, 355, 250, 25);
        //Set Location of allButton
        b1.setBounds(300,450,100,40);
        b2.setBounds(450,450,100,40);
        b3.setBounds(100,600,100,40);
        b4.setBounds(600,100,100,35);
        //Add all Label
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);
        c.add(l7);
        //Add all Textfield
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(t4);
        c.add(t5);
        c.add(t6);
        //Add all button
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        //Registered all Button
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        frame.setVisible(true);
         
    }

    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==b1) {
             Home.database c1 = new Home.database();
            
            try 
            {
                //Delete specific Ticket from Database
                int ticket_id = Integer.parseInt(t1.getText());
                String s ="Delete from Ticket where t_id="+ticket_id;
                int value = c1.s.executeUpdate(s);
                if (value==1) {
                    JOptionPane.showMessageDialog(null, "cancel Successfully");   
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "this ticket No can not in the record");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                }
                
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Enter correct Input");
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
            //Reset Textfield
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
        }
        if (ae.getSource() == b3)
        {
            //Close Frame
            frame.dispose();
        }
        
        if (ae.getSource()==b4) {
            
             Home.database c1 = new Home.database();
            try 
            {
                //Search Ticket record from Database 
                int ticket_id = Integer.parseInt(t1.getText());
                String s ="SELECT Passenger.pass_name,ActiveFlight.departure,ActiveFlight.arrival,"
                        + "ActiveFlight.fdate,ActiveFlight.charges FROM (ticket INNER JOIN passenger"
                        + " ON Ticket.pass_id=Passenger.pass_id) INNER JOIN ActiveFlight"
                        + " ON Ticket.f_id=ActiveFlight.id where t_id="+ticket_id;
                ResultSet rs = c1.s.executeQuery(s);   
                
                if (rs.next()) {
                   
                   t2.setText(rs.getString(1));
                   t3.setText(rs.getString(2));
                   t4.setText(rs.getString(3));
                   t5.setText(rs.getString(4));
                   
                   double return_amount= rs.getInt(5);
                   return_amount = return_amount * 0.9;
                   t6.setText(String.valueOf(return_amount));
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "this ticket No can not in the record");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                }
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Enter Correct input");
            }
            finally
            {
                //Close Connection
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

    }
    public static void main(String[] args) {
        new CancelTiket();
    }

}
