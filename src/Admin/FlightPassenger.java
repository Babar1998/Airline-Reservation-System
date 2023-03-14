package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.JDatePicker;

public class FlightPassenger implements ActionListener{
    
    JLabel l1;
    JButton b1,b2;
    JTextField t1;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JPanel uper,bottom,center;
    JFrame frame;
    Container c;
    JDatePicker date;

    public FlightPassenger() 
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(480,180,1000,630);
        frame.setTitle("Passenger Detail");
        c = frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(new BorderLayout());
        //North Panel
        uper = new JPanel();
        uper.setLayout(null);
        uper.setBackground(Color.LIGHT_GRAY);
        uper.setPreferredSize(new Dimension(0, 100));
        
        l1 = new JLabel("Enter Flight No");
        l1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        l1.setBounds(250, 30, 200, 40);
        uper.add(l1);
        //Enter Flight No from user
        t1 = new JTextField();
        t1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,17));
        t1.setBounds(450, 30, 150, 40);
        uper.add(t1);
        b1=new JButton("Search");
        b1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        b1.setBounds(680, 30, 100, 40);
        uper.add(b1);
        
        b1.addActionListener(this);
        c.add(uper, BorderLayout.NORTH);
        //Center Panel
        center = new JPanel();
        center.setLayout(null);
        center.setBackground(Color.LIGHT_GRAY);
        
        //Set Table Formate through DefaultTableModel and JScrollPane
        table = new JTable(model);
        String[] columns = {"Ticket No","Flight No","Pass_id","Name","Email","Seat No","Class Type","Res Date"};
        for( int i=0; i< 8;i++){
            model.addColumn(columns[i]);
        }
        table.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(table.getRowHeight() + 20);
        table.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 980, 500);
        
        center.add(scroll);
        
        c.add(center, BorderLayout.CENTER);
        
        
        //South Panel
        bottom = new JPanel();
        bottom.setLayout(null);
        bottom.setBackground(Color.LIGHT_GRAY);
        bottom.setPreferredSize(new Dimension(0, 80));
        b2 = new JButton("OK");
        b2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        b2.setBounds(450, 20, 100, 40);
        bottom.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //Close Frame
                frame.dispose();
            }
        });
        c.add(bottom, BorderLayout.SOUTH);
        frame.setVisible(true);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) 
    {
         
        
        if (e.getSource()==b1)
        {
            Home.database c1= new Home.database();
             try
             {
                model.setRowCount(0);
                //Access Result From Database
                
                String flight_id = t1.getText();
                String s ="SELECT Ticket.t_id,Ticket.f_id,Ticket.pass_id,Passenger.pass_name,"
                        + "passenger.pass_email,Ticket.seat_no,Ticket.class_type,Ticket.res_date FROM (ticket INNER JOIN passenger"
                        + " ON Ticket.pass_id=Passenger.pass_id) where f_id='"+flight_id+"';";
                ResultSet rs = c1.s.executeQuery(s);
                if (!rs.next())
                {
                    JOptionPane.showMessageDialog(null, "No Passenger in this flight");
                }
                rs.beforeFirst();
                int i=0;
                while (rs.next()) 
                {
                  i++;
                }
                String[][] data = new String[i][8];
                rs.beforeFirst();
                int j=0;
                //Set Data into Table
                while (rs.next())
                {                     
                    data[j][0]=rs.getString(1);
                    data[j][1]=rs.getString(2);
                    data[j][2]=rs.getString(3);
                    data[j][3]=rs.getString(4);
                    data[j][4]=rs.getString(5);
                    data[j][5]=rs.getString(6);
                    data[j][6]=rs.getString(7);
                    data[j][7]=rs.getString(8);
                    model.addRow(data[j]);
                    j++;
                }
               
             } 
             catch (SQLException ev) 
             {
                 
                JOptionPane.showMessageDialog(null, "Enter Correct input");
             }
        }
    }
    
    public static void main(String[] args) {
        new FlightPassenger();
    }
    
    
}
