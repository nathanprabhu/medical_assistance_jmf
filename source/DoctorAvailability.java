
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

public class DoctorAvailability extends JFrame
{
	public JLabel lTitle;
	public JLabel lred;
	public JLabel lgreen;
	public JLabel lrtamil;
	public JLabel lrenglish;
	public JLabel lrhindi;
	public JLabel lrtelugu;
	public JLabel lgtamil;
	public JLabel lgenglish;
	public JLabel lghindi;
	public JLabel lgtelugu;

  public   JScrollPane jsrtamil,jsrenglish,jsrhindi,jsrtelugu,jsgtamil,jsgenglish,jsghindi,jsgtelugu;
  public  JTextArea tr_tamil;
public	JTextArea tr_engligh;
public	JTextArea tr_hindi;
public	JTextArea tr_telugu;
public	JTextArea tg_tamil;
public	JTextArea tg_engligh;
public	JTextArea tg_hindi;
public	JTextArea tg_telugu;
    Database db;
   Connection con;
   Statement st;
   ResultSet rs;
	public JButton bback;
	
  
	// DBConnect db;
	 InetAddress ip2;
	//String server=net.orgin();
	public Container cont=null;

	public DoctorAvailability()
	{
		super("Doctor Availability");

		cont=getContentPane();
        db=new Database();
		lTitle=new JLabel("Doctor Availability");
		lTitle.setFont(new Font("Verdana",Font.BOLD,20));
        lTitle.setBounds(80, 10, 300, 30);
        lTitle.setForeground(Color.black);
        cont.add(lTitle);
        
		lred=new JLabel(new ImageIcon("red.jpg"));
		lred.setBounds(20,50,100,30);
		cont.add(lred);
        
		lrtamil=new JLabel("Tamil");
        lrtamil.setBounds(20,80,100,30);
		cont.add(lrtamil);
       
       tr_tamil=new JTextArea();
       jsrtamil=new JScrollPane(tr_tamil,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsrtamil.setBounds(20,110,100,40);
        cont.add(jsrtamil);

		lrenglish=new JLabel("English");
        lrenglish.setBounds(20,150,100,30);
		cont.add(lrenglish);
       
      tr_engligh=new JTextArea();
       jsrenglish=new JScrollPane(tr_engligh,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsrenglish.setBounds(20,170,100,40);
        cont.add(jsrenglish);

		lrhindi=new JLabel("Hindi");
        lrhindi.setBounds(20,210,100,30);
		cont.add(lrhindi);
       
      tr_hindi=new JTextArea();
       jsrhindi=new JScrollPane(tr_hindi,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsrhindi.setBounds(20,230,100,40);
        cont.add(jsrhindi);

		
		lrtelugu=new JLabel("Telugu");
        lrtelugu.setBounds(20,270,100,30);
		cont.add(lrtelugu);
        
        tr_telugu=new JTextArea();
       jsrtelugu=new JScrollPane(tr_telugu,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsrtelugu.setBounds(20,290,100,40);
        cont.add(jsrtelugu);

		lgreen=new JLabel(new ImageIcon("green.jpg"));
		
		lgreen.setBounds(220,50,100,30);
		
		cont.add(lgreen);

		lgtamil=new JLabel("Tamil");
        lgtamil.setBounds(220,80,100,30);
		cont.add(lgtamil);
       
       tg_tamil=new JTextArea();
       jsgtamil=new JScrollPane(tg_tamil,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsgtamil.setBounds(220,110,100,40);
        cont.add(jsgtamil);

		lgenglish=new JLabel("English");
        lgenglish.setBounds(220,150,100,30);
		cont.add(lgenglish);
       
     tg_engligh=new JTextArea();
       jsgenglish=new JScrollPane(tg_engligh,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsgenglish.setBounds(220,170,100,40);
        cont.add(jsgenglish);

		lghindi=new JLabel("Hindi");
        lghindi.setBounds(220,210,100,30);
		cont.add(lghindi);
       
      tg_hindi=new JTextArea();
       jsghindi=new JScrollPane(tg_hindi,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsghindi.setBounds(220,230,100,40);
        cont.add(jsghindi);

		
		lgtelugu=new JLabel("Telugu");
        lgtelugu.setBounds(220,270,100,30);
		cont.add(lgtelugu);
        
        tg_telugu=new JTextArea();
       jsgtelugu=new JScrollPane(tg_telugu,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsgtelugu.setBounds(220,290,100,40);
        cont.add(jsgtelugu);
       addDoctorAvailability();

		
		bback=new JButton("back");
       bback.setBounds(120,340,170,30);
	 bback.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
				new AdminMenu();
			}
		});
		cont.add(bback);



       //cont.setBackground(new Color(152,152,152));
	}
	public void addDoctorAvailability(){
		try{
      con=db.getConnection();
	  st=con.createStatement();
	  rs=st.executeQuery("select * from  doc_registeration");
	  while(rs.next()){
		  String status=rs.getString("status");
		//  System.out.println(status);
	     if(status.equals("out"))
		 {
			 System.out.println(status);
			 String language=rs.getString("language");
			 if(language.equals("Tamil")){
				 tr_tamil.append(rs.getString("doc_name")+"\n");
			 }
			  if(language.equals("English")){
				tr_engligh.append(rs.getString("doc_name")+"\n");
			 }
			  if(language.equals("Hindi")){
				 tr_hindi.append(rs.getString("doc_name")+"\n");
			 } 
			 if(language.equals("Telugu")){
				 tr_telugu.append(rs.getString("doc_name")+"\n");
			 }
		 }
		 else if(status.equals("login"))
		 {
			 System.out.println("login"+status);
			 String language=rs.getString("language");
			 if(language.equals("Tamil")){
				 tg_tamil.append(rs.getString("doc_name")+"\n");
			 }
			  if(language.equals("English")){
				 tg_engligh.append(rs.getString("doc_name")+"\n");
			 }
			  if(language.equals("Hindi")){
				 tg_hindi.append(rs.getString("doc_name")+"\n");
			 } 
			 if(language.equals("Telugu")){
				 tg_telugu.append(rs.getString("doc_name")+"\n");
			 }
		 }
	  }
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void main(String arg[])throws Exception
	{
		   DoctorAvailability doctoravailability=new DoctorAvailability();

			doctoravailability.setLayout(null);
			doctoravailability.setSize(400,400);
			doctoravailability.setLocation(350,180);
			doctoravailability.setVisible(true);
			doctoravailability.setResizable(false);// Disable the Max Button

	}


};