package Admin;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class NewAdmin implements ActionListener{
    
    TextField t1,t2,t3,t4;
    Label l1,l2,l3,l4,l5,l6,profile;
    JLabel imageLabel;
    Button b1,b2,b3,profilebutton;
    JRadioButton rb1,rb2;
    ButtonGroup b;
    Font f,f1;
    JFrame frame;
    Container c;
    File file=null;

    public NewAdmin() 
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(680, 220, 700, 800);
        frame.setTitle("New Admin");
        c = frame.getContentPane();
        c.setBackground(new Color(0, 163, 204));
        c.setLayout(null);
        
        f = new Font("TimesRoman",Font.BOLD,20);
        f1 = new Font("TimesRoman",Font.BOLD,17);
        //Initialize All Label
        imageLabel = new JLabel();
        profile = new Label("Profile");
        profile.setFont(f);
        l1 = new Label("Username");
        l1.setFont(f);
        l2 = new Label("Password");
        l2.setFont(f);
        l3 = new Label("Name");
        l3.setFont(f);
        l4 = new Label("Email");
        l4.setFont(f);
        l5 = new Label("Gender");
        l5.setFont(f);
        //Initialize all Button
        profilebutton = new Button("Upload");
        profilebutton.setFont(f);
        b1 = new Button("Submit");
        b1.setFont(f);
        b2 = new Button("Reset");
        b2.setFont(f);
        b3 = new Button("Close");
        b3.setFont(f);
        //Intialize All textfield
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        //Initizlize JRadioButton
        rb1 = new JRadioButton("Male" , true);
        rb1.setFont(f1);
        rb2 = new JRadioButton("Female" , false);
        rb2.setFont(f1);
        rb1.setActionCommand("Male");
        rb2.setActionCommand("Female");
        b = new ButtonGroup();
        b.add(rb1);
        b.add(rb2);
        //Set Location of all Label
        imageLabel.setBounds(350,20, 150, 150);
        profile.setBounds(100, 200, 200, 40);
        l1.setBounds(100, 250, 200, 40);
        l2.setBounds(100, 300, 200, 40);
        l3.setBounds(100, 350, 200, 40);
        l4.setBounds(100, 400, 200, 40);
        l5.setBounds(100, 450, 200, 40);   

        //Set Location of all TextField
        t1.setBounds(300, 255, 250, 25);
        t2.setBounds(300, 305, 250, 25);
        t3.setBounds(300, 355, 250, 25);
        t4.setBounds(300, 405, 250, 25);
        rb1.setBounds(300, 455, 125, 25);
        rb2.setBounds(425, 455, 125, 25);
        //Set Location of all Button
        profilebutton.setBounds(375, 200, 100, 30);
        b1.setBounds(300,550,100,40);
        b2.setBounds(450,550,100,40);
        b3.setBounds(100,650,100,40);
        //Add Label into Container
        c.add(imageLabel);
        c.add(profile);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5); 
        
        //Add Textfield into Container
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(t4);
        c.add(rb1);
        c.add(rb2);
        
        //Add Button into Container
        c.add(profilebutton);
        c.add(b1);
        c.add(b2);
        c.add(b3);
       
        //Registered All Button
        profilebutton.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        frame.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==profilebutton)
        {
            try 
            {
                //Choose Image From User
                JFileChooser picchooser = new JFileChooser();
                picchooser.showOpenDialog(null);
                File pic=picchooser.getSelectedFile();
                String path = pic.getAbsolutePath();
                file=new File(path.replace('\\','/'));
                Image img = Toolkit.getDefaultToolkit().createImage(path);
                ImageIcon icon=new ImageIcon(img);
                Image icon2 = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                ImageIcon icon3=new ImageIcon(icon2);
                imageLabel.setIcon(icon3);
              
            } 
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(null, "Enter proper input for Image");
            }
        }
        
        if (e.getSource()==b1) 
        {
            if (file==null) 
            {
                JOptionPane.showMessageDialog(null, "please Choose our profile");
            }
            else
            {
                
                //Match Pattern and save into Database
                if (Pattern.matches("[a-zA-Z]+[a-zA-Z. ]*", t3.getText())&&
                        Pattern.matches("[a-zA-Z0-9]*@gmail.com",t4.getText())) 
                {

                    Home.database c1 = new Home.database();
                    String username = new String(t1.getText());
                    String password = new String(t2.getText());
                    String name = new String(t3.getText());
                    String email = new String(t4.getText());
                    String gender = b.getSelection().getActionCommand();
                    if (username.isEmpty()||password.isEmpty()||name.isEmpty()||email.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "Please Enter data on on all field");
                    }
                    else
                    {
                        try
                        {
                            //Database Connection
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql:///AirlineSystem","root","");
                            FileInputStream fis=new FileInputStream(file);
                            PreparedStatement ps=con.prepareStatement("INSERT INTO Admin (username ,password "
                                    + ",profile ,name ,email ,gender ) values(?,?,?,?,?,?)");
                            ps.setString(1, username);
                            ps.setString(2, password);
                            //Save in Binary File
                            ps.setBinaryStream(3,fis,(long)file.length());
                            ps.setString(4, name);
                            ps.setString(5, email);
                            ps.setString(6, gender);
                           int value = ps.executeUpdate();

                            ps.close();
                            fis.close();
                            con.close();



                            if(value==1)
                            {
                                JOptionPane.showMessageDialog(null, "Add New Admin User Successfully");
                                frame.dispose();

                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Invalid data enter");
                            }
                        }
                        catch(Exception ev)
                        {
                            JOptionPane.showMessageDialog(null, "Please change User Name");
                        }

                    }
                }
        
                else  
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Input");
            }
            
        }
        
        if (e.getSource()==b2) 
        {
            file=null;
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }
        
        if (e.getSource()==b3) 
        {
            frame.dispose();
        }
      
    }
    public static void main(String[] args) {
        new NewAdmin();
    }
       
}
