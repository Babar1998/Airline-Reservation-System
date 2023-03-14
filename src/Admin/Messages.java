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
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.JDatePicker;

public class Messages implements ActionListener{
    
    JButton b1,b2,b3;
    JTextField t1;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JPanel uper,bottom,center;
    JFrame frame;
    Container c;
    JDatePicker date;
    String mdate;
    String id=null;

    public Messages() 
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(550,180,800,630);
        frame.setTitle("Daily Report");
        c = frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(new BorderLayout());
        //North Panel
        uper = new JPanel();
        uper.setLayout(null);
        uper.setBackground(Color.LIGHT_GRAY);
        uper.setPreferredSize(new Dimension(0, 100));
        //Select Date through Calender From User
        date = new JDatePicker();
        date.setBounds(200, 40, 250, 70);
        uper.add(date);
        b1=new JButton("Search");
        b1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        b1.setBounds(500, 30, 100, 40);
        uper.add(b1);
        
        b1.addActionListener(this);
        c.add(uper, BorderLayout.NORTH);
        //Center Panel
        center = new JPanel();
        center.setLayout(null);
        center.setBackground(Color.LIGHT_GRAY);
        
        //Set Table Formate through DefaultTableModel and JScrollPane
        table = new JTable(model);
        String[] columns = {"Msg No","Name","Email","Message","Date"};
        for( int i=0; i< 5;i++){
            model.addColumn(columns[i]);
        }
        table.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(table.getRowHeight() + 20);
        table.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 780, 500);
        
        center.add(scroll);
        
        table.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) 
            {
                int rownum = table.getSelectedRow();
                if(table.getSelectedRow()!= -1)
                {
                    //get values of Flight
                    id = model.getValueAt(rownum,0).toString();
                    
                    
                }
            }
        });
        c.add(center, BorderLayout.CENTER);
        
        
        //South Panel
        bottom = new JPanel();
        bottom.setLayout(null);
        bottom.setBackground(Color.LIGHT_GRAY);
        bottom.setPreferredSize(new Dimension(0, 80));
        b2 = new JButton("Close");
        b2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        b2.setBounds(100, 20, 100, 40);
        bottom.add(b2);
        b3 = new JButton("Delete");
        b3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        b3.setBounds(600, 20, 100, 40);
        bottom.add(b3);
        b3.addActionListener(this);
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
            GregorianCalendar selectedDate = (GregorianCalendar) date.getModel().getValue();
            mdate = new java.sql.Date(selectedDate.getTimeInMillis()).toString();
            Search();
        }
        
        if (e.getSource()==b3)
        {
            if (id==null)
            {
                JOptionPane.showMessageDialog(null, "Please select message from table");
            }
            else
            {
                try 
                {
                    Home.database c1 = new Home.database();
                    String q1="DELETE FROM Messages WHERE m_id="+id+";";
                    int value= c1.s.executeUpdate(q1);
                    if (value==1)
                    {
                        JOptionPane.showMessageDialog(null, "Delete successfully");
                        id=null;
                        Search();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Message can't Delete");
                } 
                catch (Exception ev) 
                {
                    JOptionPane.showMessageDialog(null, "Please enter correct input");
                }
                
                
            }
        }
    }
    
    void Search()
    {
         Home.database c1= new Home.database();
             try
             {
                model.setRowCount(0);
                //Access Result From Database
               
                String q1 = "Select * from Messages Where mdate='"+mdate+"' ;";
                ResultSet rs = c1.s.executeQuery(q1);
                int i=0;
                
                if (!rs.next()) 
                {
                    JOptionPane.showMessageDialog(null, "No Messages on this date");
                } 
                rs.beforeFirst();
                while (rs.next()) 
                {
                  i++;
                }
                String[][] data = new String[i][5];
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
                    model.addRow(data[j]);
                    j++;
                }

                } 
                catch (SQLException ev) 
                {
                    JOptionPane.showMessageDialog(null, "Enter Correct input");
                }
    }
    
    public static void main(String[] args) {
        new Messages();
    }
    
}
