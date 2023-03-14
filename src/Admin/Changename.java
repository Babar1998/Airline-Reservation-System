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

public class Changename implements ActionListener{
    String username,name;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;
    Font f,f1;
    JFrame frame;
    Container c;
    adminstart ad;
    public Changename(adminstart ad) 
    {
        this.ad =ad;
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(700,300,700,400);
        frame.setTitle("Change Name");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
        c.setLayout(null);
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,17);
        username = login.usertxt.getText();
        try 
        {
            //Access the Old Name
            Home.database c1 = new Home.database();
             String q = "Select name from Admin where username='"+username+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) 
                {
                    name = rs.getString(1);  
                }
        } 
        catch (Exception e) 
        {
            
        }
        l1 = new JLabel("Old Name");
        l1.setFont(f);
        l1.setBounds(100, 100, 150, 30);
        l2 = new JLabel("Enter New Name");
        l2.setFont(f);
        l2.setBounds(100, 200, 200, 30);
        c.add(l1);
        c.add(l2);
        
        t1 =new JTextField(name);
        t1.setFont(f1);
        t1.setEditable(false);
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
            //Check the Pattern of Textfield
            if (Pattern.matches("[a-zA-Z. ]*", t2.getText())) 
            {

                String newname = t2.getText();
                if (newname.isEmpty()) 
                {  
                    JOptionPane.showMessageDialog(null, "Please Enter new Name");
                }
                else
                {
                    try
                    {
                        Home.database c1 = new Home.database();
                        //Update the Name in Database
                        String q = "UPDATE Admin SET name='"+newname+"' WHERE username='"+username+"'";
                        int value = c1.s.executeUpdate(q);
                        if (value==1) 
                        {
                             JOptionPane.showMessageDialog(null, "Update name Successfully");
                             ad.l2.setText(newname);
                             frame.dispose();
                        }
                        else
                        {
                             JOptionPane.showMessageDialog(null, "Name can not Update");
                        }
                    } 
                    catch (Exception ev) 
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect Input");
                    }
                }

            }
        
        else
            JOptionPane.showMessageDialog(null, "Please Enter Correct Input");
    
        }
       
        if (e.getSource()==b2) 
        {
            frame.dispose();
        }
    }
       

}
