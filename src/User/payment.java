package User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class payment implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6;
    JTextField tf1,tf2,tf3,tf4;
    JButton b1;
    JComboBox jcb1;
    JFrame frame;
    Font f,f1,f2;
    Container c;
    BookTicket CB;
    public payment(BookTicket CB) {
        this.CB = CB;
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(500, 200, 900, 600);
        frame.setTitle("Payment");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
        
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,15);
        //Initialize all Label
        l6 = new JLabel();
        l6.setIcon(new ImageIcon(this.getClass().getResource("pay.png")));
        l6.setBounds(500, 90, 300, 250);
        c.add(l6);
        
        l1 = new JLabel("Credit Card No");
        l1.setFont(f);
        l2 = new JLabel("CVV Code");
        l2.setFont(f);
        l3 = new JLabel("Expiry Year");
        l3.setFont(f);
        l4 = new JLabel("Card Type");
        l4.setFont(f);
        l5 = new JLabel("Flight Charges");
        l5.setFont(f);
        
        //Initaliaze all Text field
        tf1 = new JTextField();
        tf1.setFont(f1);
        tf2 = new JTextField();
        tf2.setFont(f1);
        tf3 = new JTextField();
        tf3.setFont(f1);
        tf4 = new JTextField();
        tf4.setFont(f1);
        tf4.setText(CB.t5.getText());
        tf4.setEditable(false);
        
        String[] cardtype = {"VISA CARD" , "MASTER CARD" , "MAESTRO CARD"};
        jcb1 = new JComboBox(cardtype);
        jcb1.setFont(f1);
        
        b1 = new JButton("PAY");
        b1.setFont(f);
        b1.setBounds(200, 400, 100, 40);
        c.add(b1);
        //Set Location of all Label
        l1.setBounds(50, 100, 200, 30);
        l2.setBounds(50, 150, 200, 30);
        l3.setBounds(50, 200, 200, 30);
        l4.setBounds(50, 250, 200, 30);
        l5.setBounds(50, 300, 200, 30);
        //set Location of all Textfield
        tf1.setBounds(250, 100, 200, 30);
        tf2.setBounds(250, 150, 200, 30);
        tf3.setBounds(250, 200, 200, 30);
        jcb1.setBounds(250, 250, 200, 30);
        tf4.setBounds(250, 300, 200, 30);
        //Add all Label
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        //Add all Textfield
        c.add(tf1);
        c.add(tf2);
        c.add(tf3);
        c.add(jcb1);
        c.add(tf4);
        
        b1.addActionListener(this);
        
        frame.setVisible(true);
        
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==b1)
        {
            if (Pattern.matches("[0-9]+[0-9]*", tf1.getText())
                    && Pattern.matches("[0-9]+[0-9]*", tf2.getText())
                    && Pattern.matches("[0-9]+[0-9]*", tf3.getText())) 
            {
                if (Integer.parseInt(tf3.getText())>=2021 && Integer.parseInt(tf3.getText())<=2030) 
                {
                    
                

                    String flight_id = CB.t1.getText();
                    String name = CB.t2.getText();
                    int age = Integer.parseInt(CB.t3.getText());
                    String gender = CB.b.getSelection().getActionCommand();
                    String email = CB.t4.getText();
                    String class_type = CB.cb3.getSelectedItem().toString();
                    int seat_no =Integer.parseInt(CB.cb4.getSelectedItem().toString());

                    Home.database c1 = new Home.database();
                    try
                    {
                        //Insert Passenger Detail
                        String q1 = "Insert into passenger(pass_name,pass_age,pass_gender,pass_email)"
                                 + " Values ('"+name+"' ,"+age+" ,'"+gender+"' , '"+email+"')";
                        int value = c1.s.executeUpdate(q1);
                        //get Passenger id
                        String q2= "Select max(pass_id) from passenger";
                        ResultSet rs1 = c1.s.executeQuery(q2);
                        rs1.next();
                        int pass_id= Integer.parseInt(rs1.getString(1));
                        //Book Ticket
                        String q3 = "Insert into Ticket(pass_id,f_id,seat_no,class_type,res_date)"
                               + " Values("+pass_id+",'"+flight_id+"',"+seat_no+",'"+class_type+"','"
                               +java.time.LocalDate.now()+"')";
                       int val = c1.s.executeUpdate(q3);
                       //get Ticket No
                       String q4="Select max(t_id) from Ticket";
                       ResultSet rs2 = c1.s.executeQuery(q4);

                        if (rs2.next()) 
                        {
                            JOptionPane.showMessageDialog(null, "Payed Successfully");
                            JOptionPane.showMessageDialog(null, "Your Ticket No is: "+rs2.getString(1));
                            frame.dispose();
                            CB.frame.dispose();
                        }
                    }
                    catch (Exception ev) 
                    {
                        //If any error delete Passenger detail
                        String q5= "Select max(pass_id) from passenger";
                        try 
                        {
                            ResultSet rs3 = c1.s.executeQuery(q5);
                            rs3.next();
                            String q6 = "DELETE FROM Passenger WHERE pass_id="+rs3.getInt(1)+";";
                            int val = c1.s.executeUpdate(q6);
                        }
                        catch (SQLException ex) 
                        {
                        }

                        JOptionPane.showMessageDialog(null, "this seat Already reserved");
                        frame.dispose();
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
                else
                    JOptionPane.showMessageDialog(null, "Please enter correct year");
            
            }
            else
                JOptionPane.showMessageDialog(null, "Enter correct input");
        }
    }

}
