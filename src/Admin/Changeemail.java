package Admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Changeemail implements ActionListener{
    String username,email;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;
    Font f,f1;
    JFrame frame;
    Container c;
    public Changeemail() 
    {
       
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(700,300,700,400);
        frame.setTitle("Change Email");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
    
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,17);
        
        try 
        {
            //access the Old Email
            username = login.usertxt.getText();
            Home.database c1 = new Home.database();
             String q = "Select email from Admin where username='"+username+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) 
                {
                    email = rs.getString(1);  
                }
        } 
        catch (Exception e) 
        {
            
        }
        l1 = new JLabel("Old Email");
        l1.setFont(f);
        l1.setBounds(100, 100, 150, 30);
        l2 = new JLabel("Enter New Email");
        l2.setFont(f);
        l2.setBounds(100, 200, 200, 30);
        c.add(l1);
        c.add(l2);
        
        t1 =new JTextField(email);
        t1.setFont(f1);
        t1.setEditable(false);
        t2 = new JTextField();
        t2.setFont(f1);
        t1.setBounds(300, 100, 300, 30);
        t2.setBounds(300, 200, 300, 30);
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
            //Match the Pattern of textfield
            if (Pattern.matches("[a-zA-z0-9]+[a-zA-Z0-9]*@gmail.com", t2.getText())) 
            {

                String newemail = t2.getText();
                
                try
                {

                    Home.database c1 = new Home.database();
                    //Update the Email in Database
                    String q = "UPDATE Admin SET email='"+newemail+"' WHERE username='"+username+"'";
                    int value = c1.s.executeUpdate(q);
                    if (value==1) 
                    {
                         JOptionPane.showMessageDialog(null, "Update Email Successfully");
                         frame.dispose();
                    }
                    else
                    {
                         JOptionPane.showMessageDialog(null, "Email can not Update");
                    }
                } 
                catch (Exception ev) 
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Input");
                }
                
            }
            else
                JOptionPane.showMessageDialog(null, "Enter Correct Email");
                 
        }
    }
    public static void main(String[] args) {
        new Changeemail();
    }

    
}
