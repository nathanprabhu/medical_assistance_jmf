import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class CheckMedicineStocks  extends JFrame{
  
   // JFrame frame = new JFrame();
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Connection con;
	Statement stmt;
	ResultSet rs;
	Vector coldata;
	Vector rowdata=new Vector();
	JButton back,close;

	Database db;
    public CheckMedicineStocks(){
    try{
   db=new Database();
   con=db.getConnection();
   stmt=con.createStatement();
   rs=stmt.executeQuery("select * from medicinetbl ");
   while(rs.next()){
    coldata=new Vector();
     coldata.addElement(rs.getString("name"));
	 coldata.addElement(rs.getString("quantity"));
	 coldata.addElement(rs.getString("expiredate"));
	 coldata.addElement(rs.getString("tray1"));
	 coldata.addElement(rs.getString("tray2"));
     	 coldata.addElement(rs.getString("tray3"));
     rowdata.addElement(coldata);
   }
    
    
    Vector<String> columnNames = new Vector<String>();
    columnNames.addElement("Medicine Name");
    columnNames.addElement("Quantity");
    columnNames.addElement("Expire Date");
	 columnNames.addElement("Tray1");
	  columnNames.addElement("Tray2");
	   columnNames.addElement("Tray3");

    JTable table = new JTable(rowdata, columnNames);
   back=new JButton("Back");
   back.setBounds(270,276,80,20);
  back.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
            dispose();
            new AdminMenu();
			}
  });

   this.add(back);
   close=new JButton("close");
   close.setBounds(350,276,80,20);
   close.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
				System.exit(0);

			}
  });
  
addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
							System.exit(0);
				}
			}
		);

   this.add(close);
    JScrollPane scrollPane = new JScrollPane(table);
    this.add(scrollPane, BorderLayout.CENTER);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("CheckMedicineStocks");
    this.setSize(500, 350);
	this.setLocation(300,300);
    this.setVisible(true);
	}catch(Exception e){}
	}
	public static void main(String ar[]){
		try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		  // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		  				new CheckMedicineStocks();
		}
		catch (Exception e) {System.out.println("UL-GE");}

		
	}
 
}