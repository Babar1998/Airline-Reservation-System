package Admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WaitingFlight {
    
    JButton b1;
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JFrame frame;
    Container c;

    public WaitingFlight() 
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(550,180,800,630);
        frame.setTitle("Waiting Flight");
        c = frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(null);
        //Set Table for Flight Detail
        table = new JTable(model);
        String[] columns = {"Flight_id","departure","arrival","Date","Time","Charges","Res_seat"};
        for( int i=0; i< 7;i++){
            model.addColumn(columns[i]);
        }
        table.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(table.getRowHeight() + 20);
        table.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 780, 500);
        
        c.add(scroll);
        
        Home.database c1= new Home.database();
             try
             {
                 //Flight data access from Database
                model.setRowCount(0);
                String q1 = "Select * from ActiveFlight ;";
                ResultSet rs = c1.s.executeQuery(q1);
                int i=0;

                while (rs.next()) 
                {
                  i++;
                }
                String[] flight_id = new String[i];
                String[][] data = new String[i][7];
                rs.beforeFirst();
                int j=0;
                //Set Flight detail into table
                while (rs.next())
                {                     
                    data[j][0]=rs.getString(1);
                    flight_id[j]=rs.getString(1);
                    data[j][1]=rs.getString(2);
                    data[j][2]=rs.getString(3);
                    data[j][3]=rs.getString(4);
                    data[j][4]=rs.getString(5);
                    data[j][5]=rs.getString(6);
                    
                    Home.database c2= new Home.database();
                    String q2 = "Select count(*) from Ticket Where f_id='"+flight_id[j]+"'";
                    ResultSet rs1 = c2.s.executeQuery(q2);
                    rs1.next();
                    data[j][6]=rs1.getString(1);
                    model.addRow(data[j]);
                    j++;
                }
               
             } 
             catch (SQLException ev) 
             {
                 ev.printStackTrace();
             }
        
        b1 = new JButton("OK");
        b1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        b1.setBounds(350, 530, 100, 40);
        c.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //Close Frame
                frame.dispose();
            }
        });
        
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new WaitingFlight();
    }
    
}
