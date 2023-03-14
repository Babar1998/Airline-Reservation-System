package Admin;


import org.jdatepicker.JDatePicker;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


class Addflight implements ActionListener{
    TextField t1,t2,t3,t5,t6;
    Label l1,l2,l3,l4,l5,l6;
    Button b1,b2,b3;
    JComboBox cb1,cb2;
    JFrame frame;
    Font f,f1;
    Container c;
    JDatePicker date;

    Addflight()
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(600,200,700,700);
        frame.setTitle("Add Flight");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
   
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,17);
       
        String[] flight = {"PAKISTAN" , "UNIED ARAB EMIRATE" , "UNITED KINGDOM" , "UNITED STATE" ,"CHINA" , "AUSTRALIA" , "CANADA" , "INDIA"};
        //Initialize all Labels
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
      
        //initialize all Button
        b1 = new Button("Submit");
        b1.setFont(f);
        b2 = new Button("Reset");
        b2.setFont(f);
        b3 = new Button("Close");
        b3.setFont(f);

        //initialize all textfield
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
        
        //set the Location of all Labels
        l1.setBounds(100, 100, 200, 40);
        l2.setBounds(100, 150, 200, 40);
        l3.setBounds(100, 200, 200, 40);
        l4.setBounds(100, 250, 200, 40);
        l5.setBounds(100, 300, 200, 40);
        l6.setBounds(100, 350, 200, 40);
       
        //Set the Location of all textfield
        t1.setBounds(300, 105, 250, 25);
        cb1.setBounds(300, 155, 250, 25);
        cb2.setBounds(300, 205, 250, 25);
        date.setBounds(300, 255, 250, 25);
        t5.setBounds(300, 305, 250, 25);
        t6.setBounds(300, 355, 250, 25);
        
        //Set the Location of all Button
        b1.setBounds(300,450,100,40);
        b2.setBounds(450,450,100,40);
        b3.setBounds(100,600,100,40);

        //Add all Label
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);
       
        //Add all textfield
        c.add(t1);
        c.add(cb1);
        c.add(cb2);
        c.add(date);
        c.add(t5);
        c.add(t6);
        
        //Add all button
        c.add(b1);
        c.add(b2);
        c.add(b3);
        
        //Registered all Buttton
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1)
        { 
            //Check the Pattern of all field
            if (Pattern.matches("[a-zA-Z]*[ ]+[0-9]*",t1.getText())&&Pattern.matches("[0-9]+[0-9]*",t6.getText()))
            {
                Home.database c1 = new Home.database();
                //get the text of all field
                String id = new String(t1.getText());
                String dept = cb1.getSelectedItem().toString();
                String arri = cb2.getSelectedItem().toString();
                String ftime = new String(t5.getText());
                String charges = new String(t6.getText());
                
               

                try
                {
                    GregorianCalendar selectedDate = (GregorianCalendar) date.getModel().getValue();
                    java.sql.Date fdate = new java.sql.Date(selectedDate.getTimeInMillis());
                    //Add Flight info into Database
                    String q = "INSERT INTO ActiveFlight (id ,departure ,arrival ,fdate ,ftime  ,charges)"
                            + " VALUES ('"+id+"','"+dept+"','"+arri+"','"+fdate.toString()+"','"+ftime+"','"+charges+"')";
                    int value = c1.s.executeUpdate(q);

                    if(value==1)
                    {
                        JOptionPane.showMessageDialog(null, "Successfully add flight");
                        t1.setText("");
                        t5.setText("");
                        t6.setText("");  
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid data enter");
                    }
                }
                catch(Exception ev)
                {
                    
                    JOptionPane.showMessageDialog(null, "Enter Correct input or change Flight No");
                }
                finally
                {
                    try 
                    {
                        //Close the Connection
                        c1.c.close();
                    } 
                    catch (SQLException ex) 
                    {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Database cannot connect");
                    }
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Please Enter Correct Input");
            
           
        }
        if (ae.getSource() == b2)
        {
            //Reset the all field
            t1.setText(" ");
            t5.setText(" ");
            t6.setText(" ");  
        }
        if (ae.getSource() == b3)
        {
            //Close Frame
            frame.dispose();
        }
        
    }
    public static void main(String[] args) {
        new Addflight();
    }
    
}
