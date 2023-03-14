package Admin;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CancelFlight implements ActionListener{
    TextField t1,t2,t3,t4,t5,t6;
    Label l1,l2,l3,l4,l5,l6,l7;
    Button b1,b2,b3,b4;
    JFrame frame;
    Font f,f1;
    Container c;

    CancelFlight()
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(600,200,750,700);
        frame.setTitle("Cancel Flight");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
        c.setLayout(null);
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,15);
        //Initialize all Label
        l7 = new Label("Search By Flight No");
        l7.setFont(f);

        l1 = new Label("Flight No");
        l1.setFont(f);
        l2 = new Label("Departure");
        l2.setFont(f);
        l3 = new Label("Arrival");
        l3.setFont(f);
        l4 = new Label("Date");
        l4.setFont(f);
        l5 = new Label("Time");
        l5.setFont(f);
        l6 = new Label("Charges");
        l6.setFont(f);
      
        //Initialize all Button
        b1 = new Button("Search");
        b1.setFont(f);
        b2 = new Button("Cancel");
        b2.setFont(f);
        b3 = new Button("Reset");
        b3.setFont(f);
        b4 = new Button("Close");
        b4.setFont(f);
        //Initialize all Textfield
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
        
        //Set the Location of all Label
        l1.setBounds(100, 100, 200, 40);
        l2.setBounds(100, 150, 200, 40);
        l3.setBounds(100, 200, 200, 40);
        l4.setBounds(100, 250, 200, 40);
        l5.setBounds(100, 300, 200, 40);
        l6.setBounds(100, 350, 200, 40);
        l7.setBounds(200, 35, 300, 40);
       
        //Set the Location of all Textield
        t1.setBounds(300, 105, 250, 25);
        t2.setBounds(300, 155, 250, 25);
        t3.setBounds(300, 205, 250, 25);
        t4.setBounds(300, 255, 250, 25);
        t5.setBounds(300, 305, 250, 25);
        t6.setBounds(300, 355, 250, 25);
        
        //Set the Location of all Button
        b1.setBounds(600,100,100,35);
        b2.setBounds(300,450,100,40);
        b3.setBounds(450,450,100,40);
        b4.setBounds(100,600,100,40);

        //Add all Label
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);
        c.add(l7);
       
        //Add all textfield
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(t4);
        c.add(t5);
        c.add(t6);
        
        //Add all Button
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);

        //Registered all button
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1)
        { 
            //Search Flight from DataBase
            Home.database c1 = new Home.database();
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
           String id = t1.getText();
            try
            {
                
                String q = "SELECT * FROM ActiveFlight WHERE id='"+id+"';";
                ResultSet rs = c1.s.executeQuery(q);
                 
                if(rs.next())
                {
                    t2.setText(rs.getString(2));
                    t3.setText(rs.getString(3));
                    t4.setText(rs.getString(4));
                    t5.setText(rs.getString(5));
                    t6.setText(rs.getString(6));
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Flight not availabe");
                }
            }
            catch(Exception ev)
            {
             JOptionPane.showMessageDialog(null, "Enter correct input");
            }
            finally
            {
                try 
                {
                    c1.c.close();
                } 
                catch (SQLException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Database cannot connect");
                }
            }
            
        }
         if (ae.getSource() == b2)
        {
            //Delete Flight From Database
            Home.database c1 = new Home.database();
            String id = t1.getText();
            try
            {
                
                String q = "DELETE FROM ActiveFlight WHERE id='"+id+"';";
                int value = c1.s.executeUpdate(q);
                 
                if(value==1)
                {
                   JOptionPane.showMessageDialog(null, "Succesfully Delete Flight");
                   t1.setText("");
                   t2.setText("");
                   t3.setText("");
                   t4.setText("");
                   t5.setText("");
                   t6.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Flight No not availabe");
                }
            }
            catch(Exception ev)
            {
             JOptionPane.showMessageDialog(null, "Enter correct input");
            }
            finally
            {
                try 
                {
                    c1.c.close();
                } 
                catch (SQLException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Database cannot connect");
                }
        }
        }
        if (ae.getSource() == b3)
        {
            //Reset all textField
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            
        }
        if (ae.getSource() == b4)
        {
           //Close Frame
            frame.dispose();
        }
        
    }
    public static void main(String[] args) {
        new CancelFlight();
    }
    
}

