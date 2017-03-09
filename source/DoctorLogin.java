import javax.swing.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 
import java.sql.*;

class DoctorLogin extends JFrame{  
	
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 
 	private JTextField jTextField1; 
 	private JPasswordField jTextField2; 
 	private JButton jButton1; 
 	private JButton jButton2; 
 	private JPanel contentPane;  	
	Toolkit tk;
	Dimension d;
	String n="",tno,uname,pin;
    Database db;	
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
 	public DoctorLogin(){
		
 		super(); 
 		initializeComponent();
		db=new Database();
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
 		jTextField2 = new JPasswordField(); 
 		jButton1 = new JButton(); 
 		jButton2 = new JButton(); 
		bgr.setText("Doctor Login");
		bgr.setFont(new Font("monotype corsiva",2,20));
		contentPane = (JPanel)this.getContentPane(); 	
 		jLabel1.setText("UserName : ");  		
 		jLabel2.setText("  Password : ");  		
 		
 		jButton1.setText("SignIn"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e){ 
				try{
					String s1=jTextField1.getText();
					String s2=jTextField2.getText();

				    con=db.getConnection();
					st=con.createStatement();
					if(s1!=null && s2!=null){
					rs=st.executeQuery("select * from doc_registeration where doc_name='"+s1+"' and pass='"+s2+"'");
					if(rs.next()){
						st.executeUpdate("update doc_registeration set status='login' where doc_name='"+s1+"' and pass='"+s2+"'");
                       dispose();
						new DoctorMenu(s1);
					}else{
						JOptionPane.showMessageDialog(null,"please enter the correct User Name and password");
					}
					}
					/*Socket socket = new Socket("localhost",111);// Main Server IP Address
					DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
					String detail = "LOG$"+s1+"$"+s2;
					dout.writeUTF(detail);
					DataInputStream din = new DataInputStream(socket.getInputStream());
					String result = din.readUTF();
					if(result.intern() == "LOGIN"){
						String r = sendRequestTrustedParty("Message From User : User Logged in......");
				    if(r.intern() =="SENT"){
					System.out.println("Message sent to the Trusted Party.........");
				    }
					   dispose();
     				   new MainMenu();
					  
					}else{
						JOptionPane.showMessageDialog(null,"InValid Login");
					}*/
					}catch (Exception ex){ex.printStackTrace();System.out.println("ERROR : "+ex);}
 			} 
   		});  		
 
		jButton2.setText("Cancel"); 
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e){ 
				dispose();
				//new DoctorRegisteration();
				//jTextField1.setText("");
				//jTextField2.setText("");
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
 		addComponent(contentPane, jButton1,60,120,83,28); 
 		addComponent(contentPane, jButton2, 160,120,83,28);  		

		this.setTitle("Dector Login ..."); 
		int x = (d.height/2) - 100;
		int y = (d.width/2) - 100;
 		this.setLocation(new Point(y,x)); 
 		this.setSize(new Dimension(300,200)); 
 	}   

	
					
					
	private void addComponent(Container container,Component c,int x,int y,int width,int height){ 
 		c.setBounds(x,y,width,height); 
 		container.add(c); 
 	}   
 	
   
 	
	public static void main(String[] args){
		try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		  // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		  			new DoctorLogin();
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