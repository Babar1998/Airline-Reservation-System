package Admin;


import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class UpdateTicket implements ActionListener{

    TextField t1, t2, t3, t4, t5, t6;
    Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    Button b1, b2, b3, b4, b5;
    JRadioButton rb1, rb2;
    JComboBox cb1, cb2, cb3, cb4;
    Font f, f1;
    JFrame frame;
    Container c;

    public UpdateTicket() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(450, 100, 800, 700);
        frame.setTitle("Update Ticket");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);

        f = new Font("TimeRoman", Font.BOLD, 20);
        f1 = new Font("TimeRoman", Font.PLAIN, 18);
        //Save Seats No into String
        String[] seat = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "22", "23", "24", "25"};
        String[] clas = {"Business", "First class", "Economy"};

        l1 = new Label("Ticket No");
        l1.setFont(f);
        l2 = new Label("Flight No");
        l2.setFont(f);
        l3 = new Label("Name");
        l3.setFont(f);
        l4 = new Label("Class Type");
        l4.setFont(f);
        l5 = new Label("Seat No");
        l5.setFont(f);

        t1 = new TextField();
        t1.setFont(f1);
        t2 = new TextField();
        t2.setFont(f1);
        t3 = new TextField();
        t3.setEditable(false);
        t3.setFont(f1);
        cb1 = new JComboBox(clas);
        cb1.setFont(f1);
        cb2 = new JComboBox(seat);
        cb2.setFont(f1);

        b1 = new Button("Search");
        b1.setFont(f);
        b2 = new Button("Submit");
        b2.setFont(f);
        b3 = new Button("Reset");
        b3.setFont(f);
        b4 = new Button("Close");
        b4.setFont(f);

        l1.setBounds(175, 100, 100, 40);
        l2.setBounds(175, 150, 100, 40);
        l3.setBounds(175, 200, 100, 40);
        l4.setBounds(175, 250, 120, 40);
        l5.setBounds(175, 300, 100, 40);

        t1.setBounds(350, 105, 250, 25);
        t2.setBounds(350, 155, 250, 25);
        t3.setBounds(350, 205, 250, 25);
        cb1.setBounds(350, 255, 250, 25);
        cb2.setBounds(350, 305, 250, 25);
        

        b1.setBounds(650, 100, 100, 30);
        b2.setBounds(350, 400, 100, 40);
        b3.setBounds(500, 400, 100, 40);
        b4.setBounds(70, 550, 100, 40);

        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        

        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(cb1);
        c.add(cb2);
       

        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b4.addActionListener(this);
        
        frame.setVisible(true);
    }
    
      @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==b1)
        {
            t2.setText("");
            t3.setText("");
            Home.database c1 = new Home.database();
            try 
            {
                //Access TIcket Data from Database
                int ticket_id = Integer.parseInt(t1.getText());
                String s ="SELECT Ticket.f_id,Passenger.pass_name,"
                        + "Ticket.class_type,Ticket.seat_no FROM (ticket INNER JOIN passenger"
                        + " ON Ticket.pass_id=Passenger.pass_id) INNER JOIN ActiveFlight"
                        + " ON Ticket.f_id=ActiveFlight.id where t_id="+ticket_id;
                ResultSet rs = c1.s.executeQuery(s);
                
                if (rs.next()) {
                    
                   t2.setText(rs.getString(1));
                   t3.setText(rs.getString(2));
                   cb1.setSelectedItem(rs.getString(3));
                   cb2.setSelectedItem(rs.getString(4));
                  
                }
                else
                    JOptionPane.showMessageDialog(null, "This ticket can not reserved");
            }
             catch (Exception ev) 
            {
                JOptionPane.showMessageDialog(null, "Enter Correct input");
            }
            
        }
        
        if (e.getSource()==b2)
        {
            //Match the Pattern of textfield
            if (Pattern.matches("[0-9]+[0-9]*", t1.getText())&&Pattern.matches("[a-zA-Z0-9]+[a-zA-Z0-9]*", t2.getText())
                    &&Pattern.matches("[a-zA-Z]+[a-zA-Z. ]*",t3.getText())) 
            {
                Home.database c1 = new Home.database();
                try 
                {
                   int ticket_id = Integer.parseInt(t1.getText());
                   String flight_id = t2.getText();
                   String class_type = cb1.getSelectedItem().toString();
                   int seat_no = Integer.parseInt(cb2.getSelectedItem().toString());
                   //Update Ticket Data
                   String q = "UPDATE Ticket SET f_id='"+flight_id+"', class_type='"+class_type+
                               "', seat_no="+seat_no+" WHERE t_id="+ticket_id+";";
                   int value = c1.s.executeUpdate(q);
                   if (value==1)
                   {
                       JOptionPane.showMessageDialog(null, "Update successfully");
                       frame.dispose();
                   }
                   else
                       JOptionPane.showMessageDialog(null, "this ticket can not reserved");
                } 
                catch (Exception ev) 
                {
                  
                    JOptionPane.showMessageDialog(null, "Enter Correct input");
                }
            }
        }
        if (e.getSource()==b3)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
        if (e.getSource()==b4) 
        {
            frame.dispose();
        }
       
    }

    public static void main(String[] args) {
        new UpdateTicket();
    }

  

}
