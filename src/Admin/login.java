package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login implements ActionListener
{
    JLabel user;
    JLabel pass;
    static JTextField usertxt;
    static JPasswordField passtxt;
    JButton btn,btn1;
    JFrame frame;
    Container c;
   
    public login()
    {
       
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(600, 300, 700, 400);
        frame.setTitle("Login");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
        
        user = new JLabel("Username");
        pass = new JLabel("Password");
        usertxt = new JTextField();
        usertxt.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        passtxt = new JPasswordField();
        passtxt.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        btn = new JButton("Signin");
        btn1 = new JButton("BACK");
        
        user.setBounds(100,50,150,40);
        pass.setBounds(100,100,150,40);
        usertxt.setBounds(250,60,250,25);
        passtxt.setBounds(250,110,250,25);
        btn.setBounds(300,200,90,30);
        btn1.setBounds(100,300,100,30);
        Font f = new Font("Ariel",Font.BOLD,20);
        Font f1= new Font("Ariel",Font.BOLD,15);
        user.setFont(f);
        pass.setFont(f);
        btn.setFont(f1);
        btn1.setFont(f1);
       
        c.add(user);
        c.add(pass);
        c.add(usertxt);
        c.add(passtxt);
        c.add(btn);
        c.add(btn1);
        
        btn.addActionListener(this);
        btn1.addActionListener(this);
        
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btn) 
        {
            String username = usertxt.getText();
            String password = String.valueOf(passtxt.getPassword());
            Home.database c1 = new Home.database();
            try 
            {
                //Search Password from Database 
                String q = "Select password from Admin where username='"+username+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) 
                {
                    //Match password
                    if (rs.getString(1).equals(password)) 
                    {
                        JOptionPane.showMessageDialog(null, "Login successful");
                        adminstart a = new adminstart();
                        frame.dispose();
                       
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Wrong password");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Username");
                }
                
            } 
            catch (Exception ev)
            {
                ev.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
            
        }
         if (e.getSource()==btn1) 
        {
            Home.Main m = new Home.Main();
            frame.dispose();
        }
       
    }

    
}
