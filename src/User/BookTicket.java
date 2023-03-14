package User;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class BookTicket extends JFrame implements ActionListener {
    TextField t1,t2,t3,t4,t5,t6;
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    Button b1,b2,b3,b4,b5;
    JRadioButton rb1,rb2;
    ButtonGroup b;
    JComboBox cb1,cb2,cb3,cb4;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    Font f,f1;
    JFrame frame;
    JPanel uper,bottom,center,right;
    Container c;

  
   public BookTicket() {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(150, 100, 1600, 800);
        frame.setTitle("Book Ticket");
        c = frame.getContentPane();
        c.setLayout(new BorderLayout());
        //Set Seats , Class type 
        String[] seat = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","22","23","24","25"};
        String[] clas = {"Business" , "First class" , "Economy"};
        //North Panel for search Flight 
        uper = new JPanel();
        uper.setLayout(null);
        uper.setBackground(new Color(0, 163, 204));
        uper.setPreferredSize(new Dimension(0, 200));

        String[] data = new String[6];
        data[1] = "kleruifg";
        
        f = new Font("TimeRoman",Font.BOLD,20);
        l1 = new Label("Departure");
        l1.setFont(f);
        l2 = new Label("Arrival");
        l2.setFont(f);
        l11 = new Label("Flight select from Table");
        l11.setFont(new Font(Font.SANS_SERIF,Font.BOLD,28));
        //set country
        String[] flight = {"PAKISTAN" , "UNIED ARAB EMIRATE" , "UNITED KINGDOM" , "UNITED STATE" ,"CHINA" , "AUSTRALIA" , "CANADA" , "INDIA"};
        f1 = new Font("TimesRoman",Font.BOLD,15);
        cb1 = new JComboBox(flight);
        cb1.setFont(f1);
        cb2 = new JComboBox(flight);
        cb2.setFont(f1);
        
        b1 = new Button("Search");
        b1.setFont(f);
        b1.setBounds(650, 75, 100, 30);
        
        l1.setBounds(50, 75, 100, 30);
        l2.setBounds(350, 75, 100, 30);
        cb1.setBounds(170, 75, 150, 30);
        cb2.setBounds(430, 75, 150, 30);
        l11.setBounds(200,130, 400, 70);

        uper.add(cb1);
        uper.add(cb2);
        uper.add(l1);
        uper.add(l2);
        uper.add(b1);
        uper.add(l11);
        c.add(uper , BorderLayout.NORTH);
        
        //Center Panel for Table and Select flight
        center = new JPanel();
        center.setLayout(null);
        center.setBackground(new Color(0, 163, 204));
        center.setPreferredSize(new Dimension(0, 300));
        //Set Table for Flight detail
        table = new JTable(model);
        String[] columns = {"Flight_id","departure","arrival","Date","Time","Charges"};
        for( int i=0; i< 6;i++){
            model.addColumn(columns[i]);
        }
        table.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(table.getRowHeight() + 20);
        table.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(50, 0, 700, 300);
        
        center.add(scroll); 
        //ListSelectionListener for Flight select from table
        table.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) 
            {
                int rownum = table.getSelectedRow();
                if(table.getSelectedRow()!= -1)
                {
                    //get values of Flight
                    String flight_id = model.getValueAt(rownum,0).toString();
                    String charges = model.getValueAt(rownum, 5).toString();
                    t1.setText(flight_id);
                    t5.setText(charges);
                }
            }
        });
        
               
        c.add(center, BorderLayout.CENTER);
        
        right = new JPanel();
        right.setLayout(null);
        right.setBackground(new Color(0, 163, 204));
        right.setPreferredSize(new Dimension(600, 0));
        //Initialize all East Panel Label
        l3 = new Label("Flight No");
        l3.setFont(f);
        l4 = new Label("Name");
        l4.setFont(f);
        l5 = new Label("Age");
        l5.setFont(f);
        l6 = new Label("Gender");
        l6.setFont(f);
        l7 = new Label("Email");
        l7.setFont(f);
        l8 = new Label("Flight Charges");
        l8.setFont(f); 
        l9= new Label("Class Type");
        l9.setFont(f);
        l10 = new Label("Seat No");
        l10.setFont(f);
       //Initialize all East Panel Textfield
        t1 = new TextField();
        t1.setFont(f1);
        t1.setEditable(false);
        t2= new TextField();
        t2.setFont(f1);
        t3 = new TextField();
        t3.setFont(f1);
        t4 = new TextField();
        t4.setFont(f1);
        t5 = new TextField();
        t5.setFont(f1);
        t5.setEditable(false);
        cb3 = new JComboBox(clas);
        cb3.setFont(f1);
        cb4 = new JComboBox(seat);
        cb4.setFont(f1);
        //Radio Button East Panel
        rb1 = new JRadioButton("Male" , true);
        rb2 = new JRadioButton("Female" , false);
        rb1.setActionCommand("Male");
        rb2.setActionCommand("Female");
        b = new ButtonGroup();
        b.add(rb1);
        b.add(rb2);
        //Set Location of all Label
        l3.setBounds(30, 0, 100, 40);
        l4.setBounds(30, 50, 100, 40);
        l5.setBounds(30, 100, 100, 40);
        l6.setBounds(30, 150, 100, 40);
        l7.setBounds(30, 200, 100, 40);
        l8.setBounds(30, 250, 150, 40);
        l9.setBounds(30, 300, 150, 40);
        l10.setBounds(30, 350, 100, 40);

        //Set Location of all Button
        t1.setBounds(200, 5, 250, 25);
        t2.setBounds(200, 55, 250, 25);
        t3.setBounds(200, 105, 250, 25);
        rb1.setBounds(200, 155, 125, 25);
        rb2.setBounds(325, 155, 125, 25);
        t4.setBounds(200, 205, 250, 25);
        t5.setBounds(200, 255, 250, 25);
        cb3.setBounds(200,305, 250, 25);
        cb4.setBounds(200, 355, 250, 25);
        //Add all East Panel Label
        right.add(l3);
        right.add(l4);
        right.add(l5);
        right.add(l6);
        right.add(l7);
        right.add(l8);
        right.add(l9);
        right.add(l10);
        //Add all East Panel Textfield
        right.add(t1);
        right.add(t2);
        right.add(t3);
        right.add(rb1);
        right.add(rb2);
        right.add(t4);
        right.add(t5);
        right.add(cb3);
        right.add(cb4);
        c.add(right , BorderLayout.EAST);
        
        //South Panel
        bottom = new JPanel();
        bottom.setLayout(null);
        bottom.setBackground(new Color(0, 163, 204));
        bottom.setPreferredSize(new Dimension(0, 120));
        b2 = new Button("Submit");
        b2.setFont(f);
        b3 = new Button("Reset");
        b3.setFont(f);
        b4 = new Button("Close");
        b4.setFont(f);

        b2.setBounds(1100,0,100,40);
        b3.setBounds(1300,0,100,40);
        b4.setBounds(100,0,100,40);
       
        bottom.add(b2);
        bottom.add(b3);
        bottom.add(b4);
        c.add(bottom , BorderLayout.SOUTH);
       
        //Registered all Button
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
       
        
        frame.setVisible(true);
    
    }

   public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==b1) 
        {
             Home.database c1= new Home.database();
             try
             {
                //Access detail of Flight 
                model.setRowCount(0);
                String departure = cb1.getSelectedItem().toString();
                String arrival = cb2.getSelectedItem().toString();

                String q1 = "Select * from ActiveFlight Where departure='"+departure+"' and arrival='"+arrival+"'";
                ResultSet rs = c1.s.executeQuery(q1);
                int i=0;
                while (rs.next()) 
                {
                  i++;
                }
                 String[][] data = new String[i][6];
                rs.beforeFirst();
                int j=0;
                while (rs.next())
                {
                    //Put flight data into Table
                    data[j][0]=rs.getString(1);
                    data[j][1]=rs.getString(2);
                    data[j][2]=rs.getString(3);
                    data[j][3]=rs.getString(4);
                    data[j][4]=rs.getString(5);
                    data[j][5]=rs.getString(6);
                    model.addRow(data[j]);
                }

            } 
            catch (Exception ev) 
            {
                ev.printStackTrace();
                JOptionPane.showMessageDialog(null, "Please Enter correct input");
            }
        }
       if (e.getSource() == b2)
        {
            if (Pattern.matches("[a-zA-Z]*[ ]+[0-9]*", t1.getText())&&Pattern.matches("[a-zA-Z]+[a-zA-Z. ]*", t2.getText())
                    &&Pattern.matches("[0-9]+[0-9]", t3.getText())&&Pattern.matches("[a-zA-Z0-9]+[a-zA-Z0-9]*@gmail.com", t4.getText()))
            {
                payment p = new payment(this);
            }
            else
                JOptionPane.showMessageDialog(null, "Please Enter Correct input");
                   
        }
       
        if (e.getSource() == b3)
        {
            //Reset Textfield
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            
                       
        }
        if (e.getSource()==b4) 
        {
            //Close Frame
            frame.dispose();
        } 
    }

  
    
   
    public static void main(String[] args) 
    {
        BookTicket cl = new BookTicket(); 
    }

}
