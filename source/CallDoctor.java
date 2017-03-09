import javax.swing.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 
import java.sql.*;
import javax.swing.Timer;
class CallDoctor extends JFrame{  
	
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 
 	private JTextField jTextField1; 
 	private JTextField jTextField2; 
 	private JButton jButton1; 
 	private JButton jButton2; 
	private JButton jButton3;
 	private JPanel contentPane;  	
	Toolkit tk;
	Dimension d;
	String n="",tno,uname,pin;
    Database db;	
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	String docname="";
	 static int btick=0;
   static int bsec=0;
   static int bminite=0;
   Timer t,t1;
 	public CallDoctor( String doctorname){
		
 		super(); 
		docname=doctorname;
 		initializeComponent();
		db=new Database();
		//  t1=new Timer(100,new b());
		  //t1.start();
		try{
			 con=db.getConnection();
					 st=con.createStatement();
					 rs=st.executeQuery("select * from patientinfo");
					if(rs.next()){
                    jTextField1.setText(rs.getString("heartbit"));
		             jTextField2.setText(rs.getString("temp"));
					}

		}catch(Exception e){}
		setResizable(false);
	 
 		this.setVisible(true); 
		

 	}   
 	private void initializeComponent(){ 
		
		JLabel bgr; 
		bgr = new JLabel();                   
		tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();

 		jLabel1 = new JLabel(); 
 		jLabel2 = new JLabel(); 

 		jTextField1 = new JTextField(); 
 		jTextField2 = new JTextField(); 
 		jButton1 = new JButton(); 
 		jButton2 = new JButton(); 
		jButton3 =new JButton();
		bgr.setText("Call Doctor");
		bgr.setFont(new Font("monotype corsiva",2,20));
		contentPane = (JPanel)this.getContentPane(); 	
 		jLabel1.setText("Heart Bit : ");  		
 		jLabel2.setText("Temp: ");
		//jTextField1.setText("130");
	//	jTextField2.setText("120");
 		
 		jButton1.setText("Call "); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e){ 
				try{
					if(docname!=null || jTextField1.getText()!=null || jTextField2.getText()!=null){
					st.executeUpdate("insert into patientstatus values('"+docname+"','"+jTextField1.getText()+"','"+jTextField2.getText()+"','on')");
					new Makecall();
                    }else{
						JOptionPane.showMessageDialog(null,"please doctor name or Bp or Sugar");
					}
			            
					}catch (Exception ex){ex.printStackTrace();System.out.println("ERROR : "+ex);}
 			} 
   		});  		
 
		jButton2.setText("End Call"); 
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e){ 
				
				dispose();
				  PatientMenu patientMenu=new PatientMenu();
				  patientMenu.setLayout(null);
			patientMenu.setSize(300,450);
			patientMenu.setLocation(350,180);
			patientMenu.setVisible(true);
			patientMenu.setResizable(false);
			} 
   		});  
		jButton3.setText("Refersh"); 
 		jButton3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e){ 
				try{
					rs=st.executeQuery("select * from patientinfo");
					if(rs.next()){
                    jTextField1.setText(rs.getString("heartbit"));
		             jTextField2.setText(rs.getString("temp"));
					}
				}catch(Exception ex){ex.printStackTrace();}
				
			} 
   		});  	
		addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
							System.exit(0);
				}
			}
		);

		contentPane.setLayout(null);
		addComponent(contentPane, bgr,105,0,100,50); 
 		addComponent(contentPane, jLabel1, 45,50,80,18); 
 		addComponent(contentPane, jLabel2, 42,80,80,18); 
		addComponent(contentPane, jTextField1, 140,50,100,21); 
 		addComponent(contentPane, jTextField2, 140,80,100,22); 
 		addComponent(contentPane, jButton1,20,120,83,28); 
 		addComponent(contentPane, jButton2, 110,120,83,28);  		
        addComponent(contentPane, jButton3, 200,120,83,28);  
		this.setTitle("Call Doctor ..."); 
		int x = (d.height/2) - 100;
		int y = (d.width/2) - 100;
 		this.setLocation(new Point(y,x)); 
 		this.setSize(new Dimension(300,200)); 
 	}   

	
	/*class b implements ActionListener
		{
	   
				
        public void actionPerformed(ActionEvent ae)
		{
			System.out.println("send1");
			/*if(btick==30){
             String location=db1.getBestlocation(changeNetworkname);
			 db.insertinVisitedtable(changeNetworkname,l_movelable.getText(),location);
             if(!location.equals("") || location !=null){
			JOptionPane.showMessageDialog(null,location);
			 }
              btick=0;
			}
			if(bminite==11){

			}*/
         //  btick=btick+1;
		 //  bminite=btick/60;
		   
		  // l_timer.setText(" "+ ++k);
		  // ++kk;
			
	/*	}
		
		}	*/			
					
	private void addComponent(Container container,Component c,int x,int y,int width,int height){ 
 		c.setBounds(x,y,width,height); 
 		container.add(c); 
 	}   
 	
   
 	
	public static void main(String[] args){
		try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		  // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		  			new CallDoctor("callno");
		}
		catch (Exception e) {System.out.println("UL-GE");}

 	}  

	/*private String sendRequestTrustedParty(String msg){
	try{
		 Socket socket = new Socket("localhost",222);
		 DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		 dout.writeUTF(msg);
		 return "SENT";
	}catch(Exception ex){
		ex.printStackTrace();
		System.out.println(ex);
	}
	return null;
}*/

 } 