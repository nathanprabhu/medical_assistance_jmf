
import java.io.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.*;
import java.net.*;
import java.awt.event.*;
import java.util.regex.*;
import java.sql.*;
import java.util.Date;
import java.text.*;

public class PatientMenu extends JFrame
{
	public JLabel lTitle;
	public JLabel lname;
	public JLabel lpass;
	public JLabel lip;
	public JLabel ldob;
	public JLabel lport;
	public JLabel laddr;

	Connection con;
	Statement st;
	ResultSet rs;
    
	public JButton bcall;
	public JButton bfirst;
	public JButton bnearby;
	public JButton bmoreinfo;
	public JButton blogout;
    Socket socket;
	ObjectInputStream osi;
	ObjectOutputStream oso;
	JTextArea t;
	 JFrame f;
	 Vector<Integer> firstaidquantity=new Vector<Integer>();
	 Vector<String> name=new Vector<String>();
	 String encrypt1="";
	 String decrypt1="";
	 Vector v=new Vector();
	// DBConnect db;
	 InetAddress ip2;
	//String server=net.orgin();
	public Container cont=null;
   Database db;
	public PatientMenu()
	{
		super("Patient Menu");

		cont=getContentPane();
		try{
       db=new Database();
	   con=db.getConnection();
	   st=con.createStatement();
		}catch(Exception e){}
		lTitle=new JLabel("Patient Menu");
		lTitle.setFont(new Font("Verdana",Font.BOLD,24));
        lTitle.setBounds(80, 10, 200, 30);
        lTitle.setForeground(Color.black);
        cont.add(lTitle);
       
		bcall=new JButton(new ImageIcon("call.jpg"));
       bcall.setBounds(60,70,170,30);
	   bcall.setText("Call a Doctor");
	 bcall.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
				new Patientcontect();
			}
		});
		cont.add(bcall);


		bfirst=new JButton(new ImageIcon("images.jpg"));
      bfirst.setBounds(60,140,170,30);
      bfirst.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
               try{
				    f=new JFrame("FirstAID");
					 JPanel p=new JPanel();
					 JLabel l=new JLabel("First Aid Medicine");
					 l.setBounds(10,10,100,20);
					 p.add(l);
				  Vector firstaid=new Vector();
				   t=new JTextArea();
				   JButton sub=new JButton("Submit");
				   JButton can=new JButton("Cancel");
				   sub.setBounds(10,70,80,30);
                    can.setBounds(100,70,80,30);
				  JScrollPane s= new JScrollPane(t,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		          s.setBounds(10,40,180,30);
					       
					   
				
				 
				   firstaid.clear();
				  rs=st.executeQuery("select * from firstaid_tbl where expiredate >='"+getDate()+"'");
				  while(rs.next()){
					  name.add(rs.getString("medicinename"));
				   	t.append(rs.getString("medicinename")+"\n");
					firstaidquantity.add(rs.getInt("quantity"));

				  }
				  p.add(s);
				  p.add(sub);
				  p.add(can);	  
					  f.add(p);
				  	f.setSize(200,200);
					f.setLocation(100,100);
				   f.setVisible(true);
				   
				  /* for(int i=0; i<name.size();i++){
					   int firstaidquant=firstaidquantity.get(i);
					   firstaidquant=firstaidquant-1;
					   System.out.println(firstaidquant);
                       String finaldata=String.valueOf(firstaidquant); 
					   st.executeUpdate("update firstaid_tbl set quantity='"+finaldata+"' where medicinename='"+name.get(i)+"'");

				   }*/
				   sub.addActionListener(new ActionListener()
		        {
			public void actionPerformed(ActionEvent ae)
			{
				try{
				       String selectmediciename=t.getSelectedText();
					    for(int i=0; i<name.size();i++){
							String medicinename=name.get(i);
							//JOptionPane.showMessageDialog(null,medicinename);
							if(medicinename.equals(selectmediciename)){
								int firstaidquant=firstaidquantity.get(i);
					   firstaidquant=firstaidquant-1;
					   System.out.println(firstaidquant);
                       String finaldata=String.valueOf(firstaidquant); 
				  st.executeUpdate("update firstaid_tbl set quantity='"+finaldata+"' where medicinename='"+selectmediciename+"'");
						JOptionPane.showMessageDialog(null," Medicine Deliver");
						break;
						}
						}
				}catch(Exception ex){ex.printStackTrace();}
				  //JOptionPane.showMessageDialog(null," Medicine Deliver");
			}
		});
		can.addActionListener(new ActionListener()
		        {
			public void actionPerformed(ActionEvent ae)
			{
				 f.setVisible(false);
			}
		});
			   }catch(Exception e){e.printStackTrace();}
				  
				 
			}
		});
		cont.add(bfirst);

		bnearby=new JButton(new ImageIcon("images (3).jpg"));
      bnearby.setBounds(60,210,170,30);
        bnearby.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try{
			   	 JFrame f=new JFrame("Hospital NearBy");
					 JPanel p=new JPanel();
					 JLabel l=new JLabel("Hospital NearBy");
					 l.setBounds(10,10,100,20);
					 p.add(l);
				  Vector firstaid=new Vector();
				   JTextArea nearby=new JTextArea();
				  
				  JScrollPane scrol= new JScrollPane(nearby,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		          scrol.setBounds(50,40,100,30);
					       
					   
				
				  //Vector<Integer> firstaidquantity=new Vector<Integer>();
				  //Vector<String> name=new Vector<String>();
				   firstaid.clear();
				  rs=st.executeQuery("select * from nearbyhospatal ");
				  while(rs.next()){
					  //name.add(rs.getString("medicinename"));
				   	nearby.append("     "+rs.getString("hospatalname")+"      "+"\n");
					//firstaidquantity.add(rs.getInt(""));

				  }
				  p.add(scrol);
					  
					  f.add(p);
				  	f.setSize(200,200);
					f.setLocation(100,100);
				   f.setVisible(true);
				}catch(Exception e){}
			}
		});
		cont.add(bnearby);

		bmoreinfo=new JButton(new ImageIcon("images (4).jpg"));
      bmoreinfo.setBounds(60,280,170,30);
	  bmoreinfo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				
			}
		});
		cont.add(bmoreinfo);

		blogout=new JButton(new ImageIcon("log.jpg"));
      blogout.setBounds(60,350,170,30);
	  blogout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
		cont.add(blogout);
		

     //  cont.setBackground(new Color(152,152,152));
	}


	public static void main(String arg[])throws Exception
	{
		   try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		  // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		
		   PatientMenu patientMenu=new PatientMenu();

			patientMenu.setLayout(null);
			patientMenu.setSize(300,450);
			patientMenu.setLocation(350,180);
			patientMenu.setVisible(true);
			patientMenu.setResizable(false);// Disable the Max Button

		}
		catch (Exception e) {System.out.println("UL-GE");}

     }
	 public static String getDate(){
		Date date=new Date();
		SimpleDateFormat sb=new SimpleDateFormat("yyyy-MM-dd");
		return sb.format(date);
	}


};