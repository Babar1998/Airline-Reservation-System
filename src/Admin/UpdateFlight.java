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
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdatepicker.JDatePicker;


public class UpdateFlight implements ActionListener{
    TextField t1,t2,t3,t4,t5,t6;
    Label l1,l2,l3,l4,l5,l6,l7;
    Button b1,b2,b3,b4;
    JComboBox cb1,cb2;
    JFrame frame;
    Font f,f1;
    Container c;
    JDatePicker date;
    

    UpdateFlight()
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(600,200,750,700);
        frame.setTitle("Update Flight");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
        c.setLayout(null);
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,15);
        
        String[] flight = {"PAKISTAN" , "UNIED ARAB EMIRATE" , "UNITED KINGDOM" , "UNITED STATE" ,"CHINA" , "AUSTRALIA" , "CANADA" , "INDIA"};
  
        l7 = new Label("Search By Flight No");
        l7.setFont(f);
        //Initialized all Label
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
      
        //Initialized all Button
        b1 = new Button("Search");
        b1.setFont(f);
        b2 = new Button("Update");
        b2.setFont(f);
        b3 = new Button("Reset");
        b3.setFont(f);
        b4 = new Button("Close");
        b4.setFont(f);
        //Initialized all textfield
        t1 = new TextField();
        t1.setFont(f1);
        cb1 = new JComboBox(flight);
        cb1.setFont(f1);
        cb2 = new JComboBox(flight);
        cb2.setFont(f1);
        date = new JDatePicker();
        t5 = new TextField();
        t5.setFont(f1);
        t6 = new TextField();
        t6.setFont(f1);
        
        //Set Location of all Label
        l1.setBounds(100, 100, 200, 40);
        l2.setBounds(100, 150, 200, 40);
        l3.setBounds(100, 200, 200, 40);
        l4.setBounds(100, 250, 200, 40);
        l5.setBounds(100, 300, 200, 40);
        l6.setBounds(100, 350, 200, 40);
        l7.setBounds(200, 35, 300, 40);
       
        //Set Location of all Textfield
        t1.setBounds(300, 105, 250, 25);
        cb1.setBounds(300, 155, 250, 25);
        cb2.setBounds(300, 205, 250, 25);
        date.setBounds(300, 255, 250, 25);
        t5.setBounds(300, 305, 250, 25);
        t6.setBounds(300, 355, 250, 25);
        

        b1.setBounds(600,100,100,35);
        b2.setBounds(300,450,100,40);
        b3.setBounds(450,450,100,40);
        b4.setBounds(100,600,100,40);

        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);
        c.add(l7);
       

        c.add(t1);
        c.add(cb1);
        c.add(cb2);
        c.add(date);
        c.add(t5);
        c.add(t6);
        

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
        if (ae.getSource() == b1)
        {
            Home.database c1 = new Home.database();
            t5.setText("");
            t6.setText("");
            String id = t1.getText();
            try
            {
                //Access Detail from Database
                String q = "SELECT * FROM ActiveFlight WHERE id='"+id+"';";
                ResultSet rs = c1.s.executeQuery(q);
                 
                if(rs.next())
                {
                    cb1.setSelectedItem(rs.getString(2));
                    cb2.setSelectedItem(rs.getString(3));
                    String d = rs.getString(4);
                    String[] fdate = d.split("-");
                    date.getModel().setDate(Integer.parseInt(fdate[0]),Integer.parseInt(fdate[1])-1,Integer.parseInt(fdate[2]));
                    date.getModel().setSelected(true);
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
            //Match Pattern of all Field
            if (Pattern.matches("[a-zA-Z]*[ ]+[0-9]*",t1.getText())&&Pattern.matches("[0-9]*",t6.getText()))
            {
                Home.database c1 = new Home.database();
                String id = t1.getText();
                String departure = cb1.getSelectedItem().toString();
                String arrival = cb2.getSelectedItem().toString();
                GregorianCalendar selectedDate = (GregorianCalendar) date.getModel().getValue();
                java.sql.Date fdate = new java.sql.Date(selectedDate.getTimeInMillis());
                String ftime = t5.getText();
                int charges = Integer.parseInt(t6.getText());
                 try{
                        //Upadate Flight data in Database
                        String q = "UPDATE ActiveFlight SET departure='"+departure+"', arrival='"+arrival+
                               "', fdate='"+fdate+"', ftime='"+ftime+"' ,charges="+charges+
                               " WHERE id='"+id+"';";
                    int value = c1.s.executeUpdate(q);

                    if(value==1)
                    {
                       JOptionPane.showMessageDialog(null, "Succesfully Update Flight");
                      frame.dispose();
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
            else
                  JOptionPane.showMessageDialog(null, "Enter correct input");
        }
        
        if (ae.getSource() == b3)
        {
            t1.setText("");
            t5.setText("");
            t6.setText("");
        }
        if (ae.getSource() == b4)
        {
            frame.dispose();
        }
        
    }
    public static void main(String[] args) {
        new UpdateFlight();
    }
    
}

