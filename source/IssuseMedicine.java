import java.awt.BorderLayout;
import java.util.Vector;
import java.util.Date;
import java.text.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Rectangle;
import java.awt.Point;
public class IssuseMedicine  extends JFrame{
  
   // JFrame frame = new JFrame();
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Connection con;
	Statement stmt;
	ResultSet rs;
	Vector coldata;
	Vector rowdata=new Vector();
	JButton back,ok,select;
    String name=null;
	JTable table;
	Database db;
	SimpleWrite sb;
	int count=0;
	Boolean[] d = new Boolean[100];
	String[] a = new String[100];
	String[] b = new String[100];
	String[] c = new String[100];
	Vector selectrow=new Vector();
    Vector<String> columnNames,columnNames1;
    public IssuseMedicine(String nname){
		super("ISSUSE MEDICINE");
    try{
		 sb=new SimpleWrite();
		name=nname;
   db=new Database();
   con=db.getConnection();
   stmt=con.createStatement();
   rs=stmt.executeQuery("select * from medicinetbl where expiredate >='"+getDate()+"' and quantity >0");
   while(rs.next()){
    coldata=new Vector();
	 coldata.addElement(false);
     coldata.addElement(rs.getString("name"));
	 coldata.addElement(rs.getString("quantity"));
	 coldata.addElement(rs.getString("expiredate"));
	
	 
     rowdata.addElement(coldata);
   }
    
    
    columnNames = new Vector<String>();
	columnNames.addElement("Checked");
    columnNames.addElement("Medicine Name");
    columnNames.addElement("Quantity");
    columnNames.addElement("Expire Date");
	    TableModel model = new DefaultTableModel(rowdata, columnNames) {

       // private static final long serialVersionUID = 1L;

       // @Override
       public Class<?> getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    };
    table = new JTable(model);
   back=new JButton("Back");
   back.setBounds(200,276,80,20);
  back.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
            dispose();
            new DoctorMenu(name);
			}
  });

   this.add(back);
   ok=new JButton("OK");
   ok.setBounds(300,276,80,20);
   ok.addActionListener(new ActionListener() {
    
 			public void actionPerformed(ActionEvent e){
				//System.exit(0);
              Vector data=new Vector();
			  data.clear();
				// int n = table.getSelectedRowCount();
			     int n1=table.getColumnCount();
				 System.out.println(selectrow.size());
			     Object obj1[][] = new Object[selectrow.size()][n1];
			      for(int i=0; i<selectrow.size();i++){
					 // for(int r=0; r<selectrow.size();r++){

				       for(int ii=0;ii<n1;ii++){
						   int row=(Integer)selectrow.elementAt(i);
					       obj1[i][ii] = GetData(table, row, ii);

                          scrollToVisible(table, row, ii);
				        //System.out.print(obj1[row][ii]+"\t");
						 //data.add((String)obj1[row][ii]);
				   }
					 // }
			}

            Vector col;

			for(int j=0;j<selectrow.size();j++){
				col=new Vector();
				//d[j]=(String)obj1[j][1];
				a[j] = (String)obj1[j][1];
				b[j] = (String)obj1[j][2];
				
				c[j] = (String)obj1[j][3];
				System.out.println( (String)obj1[j][2]);
                
				try{
					int quantity=0;
					rs=stmt.executeQuery("select quantity from medicinetbl where name='"+a[j]+"'");
					if(rs.next()){
					quantity=rs.getInt("quantity");
					}
					System.out.println(quantity);
					int selectquantiy=Integer.parseInt(b[j]);
                  int netquantity=quantity-selectquantiy;
				  System.out.println("NetQuantity"+netquantity);
				   b[j]=String.valueOf(netquantity);
					stmt.executeUpdate("Update medicinetbl set quantity='"+b[j]+"' where name='"+a[j]+"'");
				}catch(Exception ee){ee.printStackTrace();}
				col.add((String)obj1[j][1]);
				col.add((String)obj1[j][2]);
				col.add((String)obj1[j][3]);
				data.add(col);
				
			}
             //print(data,columnNames);
			 selectrow.clear();
			     columnNames1 = new Vector<String>();
	
	sb.writeData("E");
    columnNames1.addElement("Medicine Name");
    columnNames1.addElement("Quantity");
    columnNames1.addElement("Expire Date");
			 new PrintTable(data,columnNames1);

			}
  });
  this.add(ok);
  select=new JButton("SelectRow");
  select.setBounds(400,276,80,20);
   select.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
         //   dispose();
		 count++;
		 selectrow.add(table.getSelectedRow());
           if(count==1){
           sb.writeData("A");
            
			}else if(count==2){
              sb.writeData("B");
			}else if(count==3){
			  sb.writeData("C");
			}else if(count==4){
			  sb.writeData("D");
			}else{
				sb.writeData("D");
				count=0;
			}
			}
  });
 this.add(select);
addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
							System.exit(0);
				}
			}
		);

   
    JScrollPane scrollPane = new JScrollPane(table);
    this.add(scrollPane, BorderLayout.CENTER);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 350);
	this.setLocation(300,300);
    this.setVisible(true);
	}catch(Exception e){}
	}
	public static void main(String ar[]){
		try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		  // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		  				//new MedicineAvailability();
		}
		catch (Exception e) {System.out.println("UL-GE");}

		
	}
	public static String getDate(){
		Date date=new Date();
		SimpleDateFormat sb=new SimpleDateFormat("yyyy-MM-dd");
		return sb.format(date);
	}
 public static Object GetData(JTable table, int row_index, int col_index){
		return table.getModel().getValueAt(row_index, col_index);
	}
public static void scrollToVisible(JTable table, int rowIndex, int vColIndex) {
        if (!(table.getParent() instanceof JViewport)) {
            return;
        }
        JViewport viewport = (JViewport)table.getParent();

        // This rectangle is relative to the table where the
        // northwest corner of cell (0,0) is always (0,0).
        Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);

        // The location of the viewport relative to the table
        Point pt = viewport.getViewPosition();

        // Translate the cell location so that it is relative
        // to the view, assuming the northwest corner of the
        // view is (0,0)
        rect.setLocation(rect.x-pt.x, rect.y-pt.y);

        table.scrollRectToVisible(rect);

        // Scroll the area into view
        //viewport.scrollRectToVisible(rect);
    }
	
 
}