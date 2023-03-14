package Home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContactUs implements ActionListener{

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16;
    JTextField t1, t2, t3;
    JButton b1, b2;
    JFrame frame;
    JPanel uper, left, right,bottom,center;
    Font f, f1, f2, f3;
    Container c;

    public ContactUs() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(270, 100, 1400, 930);
        frame.setTitle("Contact US");
        c = frame.getContentPane();
       
        c.setLayout(new BorderLayout());
        //Uper panel
        uper = new JPanel();
        uper.setLayout(null);
        uper.setBackground(new Color(153, 204, 255));
        uper.setPreferredSize(new Dimension(0, 300));
        f = new Font("TimesRoman", Font.BOLD, 20);
        f1 = new Font("TimesRoman", Font.BOLD, 25);
        f2 = new Font("TimesRoman", Font.PLAIN, 20);
        f3 = new Font("TimesRoman", Font.BOLD, 30);

        l1 = new JLabel("Contact Us");
        l1.setFont(f3);
        l1.setBounds(600, 50, 250, 50);
        l2 = new JLabel("We would love to repond to your queries and help you succeed");
        l2.setFont(f2);
        l2.setBounds(400, 100, 650, 50);
        l3 = new JLabel("Feel free to get in touch with us");
        l3.setFont(f2);
        l3.setBounds(550, 150, 450, 50);
        uper.add(l1);
        uper.add(l2);
        uper.add(l3);
        
        c.add(uper , BorderLayout.NORTH);
        //East panel for Message
        right = new JPanel();
        right.setLayout(null);
        right.setBackground(new Color(153, 204, 255));
        right.setPreferredSize(new Dimension(700, 0));

        l5 = new JLabel("Send Message");
        l5.setFont(f1);
        l5.setBounds(300, 0, 200, 40);
        l6 = new JLabel("Full Name");
        l6.setFont(f);
        l6.setForeground(Color.BLUE);
        l6.setBounds(300, 75, 200, 40);
        l7 = new JLabel("Email");
        l7.setFont(f);
        l7.setForeground(Color.BLUE);
        l7.setBounds(300, 185, 200, 40);
        l8 = new JLabel("Message");
        l8.setFont(f);
        l8.setForeground(Color.BLUE);
        l8.setBounds(300, 275, 200, 40);
        
        t1 = new JTextField();
        t1.setFont(f2);
        t1.setBounds(300, 130, 300, 30);
        t2 = new JTextField();
        t2.setFont(f2);
        t2.setBounds(300, 235, 300, 30);
        t3 = new JTextField();
        t3.setFont(f2);
        t3.setBounds(300, 320, 300, 80);
        
        right.add(l5);
        right.add(l6);
        right.add(l7);
        right.add(l8);
        right.add(t1);
        right.add(t2);
        right.add(t3);
        
        c.add(right , BorderLayout.EAST);
        
        //Center Panel for contact detail
        center = new JPanel();
        center.setLayout(null);
        center.setBackground(new Color(0, 184, 230));
        center.setPreferredSize(new Dimension(710, 0));

        l9 = new JLabel("Reach Us");
        l9.setFont(f1);
        l9.setForeground(Color.BLACK);
        l9.setBounds(50, 40, 150, 50);
        l10 = new JLabel("Email");
        l10.setFont(f);
        l10.setForeground(Color.BLACK);
        l10.setBounds(50, 130, 100, 40);
        l11 = new JLabel("tanveerhabtani308@gmail.com");
        l11.setFont(f);
        l11.setForeground(Color.BLACK);
        l11.setBounds(200, 170, 300, 40);
        l12 = new JLabel("Phone");
        l12.setFont(f);
        l12.setForeground(Color.BLACK);
        l12.setBounds(50, 230, 100, 40);
        l13 = new JLabel("+923316460611");
        l13.setFont(f);
        l13.setForeground(Color.BLACK);
        l13.setBounds(200, 270, 300, 40);
        l14 = new JLabel("Address");
        l14.setFont(f);
        l14.setForeground(Color.BLACK);
        l14.setBounds(50, 350, 100, 40);
        l15 = new JLabel("Bhubtian Chowk , Raiwind Raod ,");
        l15.setFont(f);
        l15.setForeground(Color.BLACK);
        l15.setBounds(200, 390, 350, 40);
        l16 = new JLabel("Lahore , Pakistan");
        l16.setFont(f);
        l16.setForeground(Color.BLACK);
        l16.setBounds(200, 450, 250, 40);

        center.add(l9);
        center.add(l10);
        center.add(l11);
        center.add(l12);
        center.add(l13);
        center.add(l14);
        center.add(l15);
        center.add(l16);
        
        c.add(center , BorderLayout.CENTER);
        //South Panel
        bottom = new JPanel();
        bottom.setLayout(null);
        bottom.setBackground(new Color(153, 204, 255));
        bottom.setPreferredSize(new Dimension(0, 100));
        
        b1 = new JButton("Send");
        b1.setFont(f);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(1010, 0, 100, 40);
        bottom.add(b1);
        b1.addActionListener(this);
        c.add(bottom , BorderLayout.SOUTH);
        //West Panel
        left = new JPanel();
        left.setLayout(null);
        left.setBackground(new Color(153, 204, 255));
        left.setPreferredSize(new Dimension(150,0));
        c.add(left , BorderLayout.WEST);
        
        
        
        frame.setVisible(true);
    }

     @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if (e.getSource()==b1)
        {
            if (Pattern.matches("[a-zA-Z]+[a-zA-Z. ]*", t1.getText())&& 
                    Pattern.matches("[a-zA-Z0-9]+[a-zA-Z0-9.]*@gmail.com", t2.getText())) 
            {
                try 
                {
                    database c1 = new database();
                    String name= t1.getText();
                    String email = t2.getText();
                    String msg= t3.getText();
                    String q1 ="Insert into Messages (name,email,msg,mdate)"
                            + " Values ('"+name+"','"+email+"','"+msg+"','"+java.time.LocalDate.now()+"');";
                    
                    int value = c1.s.executeUpdate(q1);
                    if (value==1) 
                    {
                        JOptionPane.showMessageDialog(null, "Message send");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Message can't Send");
                } 
                catch (Exception ev)
                {
                    JOptionPane.showMessageDialog(null, "Please enter Correct input");
                }
                
            }
            else
                JOptionPane.showMessageDialog(null, "Please enter Correct Name and Email");
        }
    }
    
    public static void main(String[] args) {
        new ContactUs();

    }


}
