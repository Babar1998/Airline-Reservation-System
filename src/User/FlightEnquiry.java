package User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class FlightEnquiry extends JFrame implements ActionListener{

    Button b1,b2;
     Label l1,l2,l3,l4,l5;
    JFrame frame;
    Font f,f1;
    JComboBox cb1,cb2;
    JPanel uper,bottom,center;
    JTable table;
    String[][] data;
    Container c;
    DefaultTableModel model = new DefaultTableModel();
   
    public FlightEnquiry()
    {
        frame = new JFrame();
        frame.setLayout(null);
	frame.setBounds(600, 200, 800, 700);
        frame.setTitle("Flight Enquiry");
        c = frame.getContentPane();
        c.setLayout(new BorderLayout());
        f = new Font("TimesRoman",Font.BOLD,20);
        //North Panel for search Flight
        uper = new JPanel();
        uper.setLayout(null);
        uper.setBackground(new Color(0, 163, 204));
        uper.setPreferredSize(new Dimension(0, 150));

        l1 = new Label("Departure");
        l1.setFont(f);
        l2 = new Label("Arrival");
        l2.setFont(f);
        
        b1 = new Button("Search");
        b1.setFont(f);
        
        String[] flight = {"PAKISTAN" , "UNIED ARAB EMIRATE" , "UNITED KINGDOM" , "UNITED STATE" ,"CHINA" , "AUSTRALIA" , "CANADA" , "INDIA"};
        f1 = new Font("TimesRoman",Font.BOLD,15);
        cb1 = new JComboBox(flight);
        cb1.setFont(f1);
        cb2 = new JComboBox(flight);
        cb2.setFont(f1);
        
        l1.setBounds(50, 75, 100, 30);
        l2.setBounds(350, 75, 100, 30);
        cb1.setBounds(170, 75, 150, 30);
        cb2.setBounds(430, 75, 150, 30);
        b1.setBounds(650, 75, 100, 30);
        
        uper.add(cb1);
        uper.add(cb2);
        uper.add(l1);
        uper.add(l2);
        uper.add(b1);
        c.add(uper , BorderLayout.NORTH);
        
        //Center Panel for Table
        center = new JPanel();
        center.setLayout(null);
        center.setBackground(new Color(0, 163, 204));
        center.setPreferredSize(new Dimension(0, 300));
        //Set Table for Flight detail
        table = new JTable(model);
        table.setBounds(50, 50, 700, 300);
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
               
        c.add(center, BorderLayout.CENTER);
        //SOuth Panel for close Button
        bottom = new JPanel();
        bottom.setLayout(null);
        bottom.setBackground(new Color(0, 163, 204));
        bottom.setPreferredSize(new Dimension(0, 100));
        
        b2 = new Button("Close");
        b2.setFont(f);
        b2.setBounds(100,20,100,40);
        bottom.add(b2);
        c.add(bottom, BorderLayout.SOUTH);
        
        //Registered all Button
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==b1) 
        {
            Home.database c1= new Home.database();
            try
            {
                model.setRowCount(0);
                String departure = cb1.getSelectedItem().toString();
                String arrival = cb2.getSelectedItem().toString();
                //Access Flight detail fromm Database
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
                    //Put Flights Data into Table
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
                 
            }
        }
        if (e.getSource() == b2)
        {
            //Close Frame
           frame.dispose();
        }
     }
     public static void main(String[] args) {
        new FlightEnquiry();
    }

}
