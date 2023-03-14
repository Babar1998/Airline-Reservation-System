package Admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Changepassword implements ActionListener{
    
    String username,password;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;
    Font f,f1;
    JFrame frame;
    Container c;

    public Changepassword() 
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(700,300,700,400);
        frame.setTitle("Change Password");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
        c.setLayout(null);
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,17);
        
        try 
        {
            //Access Old Password
            Home.database c1 = new Home.database();
            username = login.usertxt.getText();
             String q = "Select password from Admin where username='"+username+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) 
                {
                    password = rs.getString(1);  
                }
        } 
        catch (Exception e) 
        {
            
        }
        l1 = new JLabel("Old Password");
        l1.setFont(f);
        l1.setBounds(100, 100, 150, 30);
        l2 = new JLabel("Enter New Password");
        l2.setFont(f);
        l2.setBounds(100, 200, 200, 30);
        c.add(l1);
        c.add(l2);
        
        t1 =new JTextField();
        t1.setFont(f1);
        t2 = new JTextField();
        t2.setFont(f1);
        t1.setBounds(350, 100, 200, 30);
        t2.setBounds(350, 200, 200, 30);
        c.add(t1);
        c.add(t2);
        
        b1 = new JButton("Change");
        b1.setFont(f);
        b1.setBounds(400, 300, 120, 40);
        b2 =new JButton("Close");
        b2.setFont(f);
        b2.setBounds(100, 300, 100, 40);
        
        c.add(b1);
        c.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        frame.setVisible(true);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==b1)
        {
            String oldpassword = t1.getText();
            String newpassword = t2.getText();
            //Match Old Password
            if (oldpassword.equals(password)) 
            {  
                if (newpassword.isEmpty()) 
                { 
                    JOptionPane.showMessageDialog(null, "Please Enter new Password");
                }
                else
                {
                    try
                    {
                        Home.database c1 = new Home.database();
                        //Update Password in Database
                        String q = "UPDATE Admin SET Password='"+newpassword+"' WHERE username='"+username+"'";
                        int value = c1.s.executeUpdate(q);
                        if (value==1) 
                        {
                             JOptionPane.showMessageDialog(null, "Update Password Successfully");
                             frame.dispose();
                        }
                        else
                        {
                             JOptionPane.showMessageDialog(null, "Password can not Update");
                        }
                    } 
                    catch (Exception ev) 
                    {
                        ev.printStackTrace();
                         JOptionPane.showMessageDialog(null, "Incorrect Input");
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Your old password is incorrect");
            }
                
        }
        
        if (e.getSource()==b2)
        {
            //Close Frame
            frame.dispose();
        }
    }
    
    public static void main(String[] args) 
    {
        new Changepassword();
    }
    
}
