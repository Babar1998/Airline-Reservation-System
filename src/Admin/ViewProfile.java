package Admin;

import org.jdatepicker.JDatePicker;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewProfile implements ActionListener{
    
    String username,password,name,email,gender;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2;
    JButton b1,b2;
    Font f,f1;
    JFrame frame;
    Container c;
    byte[] image = null;
    File file;
    adminstart ad;
    JDatePicker date;
    public ViewProfile(adminstart ad) 
    {
        this.ad =ad;
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(400,100,1000,700);
        frame.setTitle("View Profile");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);

        f = new Font("TimesRoman",Font.BOLD,27);
        f1 = new Font("TimesRoman",Font.BOLD,20);
        
        
        try 
        {
            //Access Admin User detail from Database
            Home.database c1 = new Home.database();
            username = login.usertxt.getText();
             String q = "Select * from Admin where username='"+username+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) 
                {
                    password = rs.getString(2); 
                    image = rs.getBytes(3);
                    name = rs.getString(4); 
                    email = rs.getString(5); 
                    gender = rs.getString(6); 
                }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Some error in Admin User detail");
        }
        //Set profile Image
        l1 = new JLabel();
        Image img = Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icon=new ImageIcon(img);
        Image icon2 = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon3=new ImageIcon(icon2);
        l1.setIcon(icon3);
        l1.setBounds(450, 30, 100, 100);
        c.add(l1);
        
        
        l2 = new JLabel(username);
        l2.setFont(f1);
        l2.setForeground(Color.WHITE);
        l2.setBounds(430, 180, 200, 30);
        c.add(l2);
        
        l3 = new JLabel("Password : ");
        l3.setFont(f);
        l3.setForeground(Color.WHITE);
        l3.setBounds(50, 250, 200, 30);
        c.add(l3);
        l4 = new JLabel(password);
        l4.setFont(f1);
        l4.setForeground(Color.WHITE);
        l4.setBounds(220, 250, 200, 30);
        c.add(l4);
        
        l5 = new JLabel("Name : ");
        l5.setFont(f);
        l5.setForeground(Color.WHITE);
        l5.setBounds(590, 250, 120, 30);
        c.add(l5);
        l6 = new JLabel(name);
        l6.setFont(f1);
        l6.setForeground(Color.WHITE);
        l6.setBounds(720, 250, 200, 30);
        c.add(l6);
        
        l7 = new JLabel("Email : ");
        l7.setFont(f);
        l7.setForeground(Color.WHITE);
        l7.setBounds(50, 400, 120, 30);
        c.add(l7);
        l8 = new JLabel(email);
        l8.setFont(f1);
        l8.setForeground(Color.WHITE);
        l8.setBounds(220, 400, 500, 30);
        c.add(l8);
        
        l9 = new JLabel("Gender : ");
        l9.setFont(f);
        l9.setForeground(Color.WHITE);
        l9.setBounds(590, 400, 130, 30);
        c.add(l9);
        l10 = new JLabel(gender);
        l10.setFont(f1);
        l10.setForeground(Color.WHITE);
        l10.setBounds(720, 400, 150, 30);
        c.add(l10);
        
        b1 = new JButton("OK");
        b1.setFont(f1);
        b1.setBounds(420, 550, 120, 40);
        b2 = new JButton("Edit");
        b2.setFont(f1);
        b2.setBounds(450, 150, 90, 25);
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
            frame.dispose();
        }
        if (e.getSource()==b2)
        {
            try 
            {
                //Edit Profile Image
                JFileChooser picchooser = new JFileChooser();
                picchooser.showOpenDialog(null);
                File pic=picchooser.getSelectedFile();
                String path = pic.getAbsolutePath();
                file=new File(path.replace('\\','/'));
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql:///AirlineSystem","root","");
                FileInputStream fis=new FileInputStream(file);
                PreparedStatement ps=con.prepareStatement("UPDATE Admin SET profile=? Where username=?");
                ps.setBinaryStream(1, fis, (long)file.length());
                ps.setString(2, username);
                int value = ps.executeUpdate();
                ps.close();
                fis.close();
                con.close();
                if (value==1)
                {
                    JOptionPane.showMessageDialog(null, "Update Sucessfully");
                    Home.database c1 = new Home.database();
                    String q1 = "Select profile from Admin Where username='"+username+"';";
                    ResultSet rs = c1.s.executeQuery(q1);
                    if (rs.next())
                    {
                        
                        byte[] image1 = rs.getBytes(1);
                        Image img = Toolkit.getDefaultToolkit().createImage(image1);
                        ImageIcon icon=new ImageIcon(img);
                        Image icon2 = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                       ImageIcon icon3=new ImageIcon(icon2);
                        l1.setIcon(icon3);
                        ad.l1.setIcon(icon3);
                    }
                    
                }
                else
                     JOptionPane.showMessageDialog(null, "Image can't Update");
                 
            } 
            catch (Exception ev) 
            {
               
                JOptionPane.showMessageDialog(null, "Please Enter correct input for image");
            }
        }
        
    }
    
    public static void main(String[] args) {
        
    }

}
