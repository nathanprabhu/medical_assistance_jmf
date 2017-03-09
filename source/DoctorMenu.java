import javax.swing.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class DoctorMenu extends JFrame 
 {
    private JLabel jLabel1;
 	private JTextField jTextField1;
	Toolkit tk;
	Dimension d;
 	private JButton jButton1;
 	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	Statement stmt;
	Connection con;
	ResultSet rs;
	String name=null;
    Database db;
 	private JPanel contentPane;
	
	public DoctorMenu(String name){
 		super();
		this.name=name;
		db=new Database();
		try{
			 con=db.getConnection();
					stmt=con.createStatement();
		}catch(Exception e){}
		initializeComponent();
		setResizable(false);
 		this.setVisible(true);

 	}
 	private void initializeComponent(){
 	
		JLabel bgr;
		bgr = new JLabel();
		tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();
 		jLabel1 = new JLabel();
 		jTextField1 = new JTextField();
		jButton1 = new JButton();
 		jButton2 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();

		jButton5 = new JButton();

		bgr.setText("Doctor Menu");
		bgr.setFont(new Font("monotype corsiva",2,30));			
		contentPane = (JPanel)this.getContentPane();

		
		// Cloud Computing

		jButton1.setText("Attend Call");
 		jButton1.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
                try{
                    rs=stmt.executeQuery("select * from patientstatus where docname='"+name+"' and status='on'");
					if(rs.next()){
			         dispose();
			     	new Attendcall(name);
					new Makecall();
					}else {
						JOptionPane.showMessageDialog(null,"No Patient Available");
					}
				}catch(Exception ex){}
			
			}
   		});

// Hospital
		
		jButton2.setText("End Call");
 		jButton2.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
				
				 try{
                  int i=stmt.executeUpdate("delete from patientstatus where docname='"+name+"' and status='on'");
					if(i>0){
			         JOptionPane.showMessageDialog(null,"Call End");
					}else {
						JOptionPane.showMessageDialog(null,"No Call End ");
					}
				}catch(Exception ex){}
			}
		});

    	jButton4.setText("Logout");
 		jButton4.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
				try{
					con=db.getConnection();
					stmt=con.createStatement();
					stmt.executeUpdate("update doc_registeration set status='out' where doc_name='"+name+"'");
              
				System.exit(0);
				}catch(Exception e1){
					e1.printStackTrace();
				}

				/*try{
					dispose();
					 String str =  JOptionPane.showInputDialog(MainMenu.this,"Enter Bank Name:");
				    // JOptionPane.showMessageDialog(MainMenu.this,"Entered String is ..."+str);
					 str = "bank$"+str;
				     str = sendRequest(str);
					 AccDetails accDetails = new AccDetails(str);
				}catch(Exception ex){
					ex.printStackTrace();
					System.out.println(ex);
				}*/
			}
		});

	/*	jButton5.setText("Student Information");
 		jButton5.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
				/*try{
					dispose();
					 String str =  JOptionPane.showInputDialog(MainMenu.this,"Enter Student Id:");
				     JOptionPane.showMessageDialog(MainMenu.this,"Entered String is ..."+str);
					  str = "student$"+str;
				      str = sendRequest(str);
					  StudentInforamtion ss = new StudentInforamtion(str);
				}catch(Exception ex){
					ex.printStackTrace();
					System.out.println(ex);
				}
			}
		});*/



	
		addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
							System.exit(0);
				}
			}
		);


	/*	jButton3.setText("Logout");
 		jButton3.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e){
 				System.exit(0);

 			}

 		});*/
		contentPane.setLayout(null);
    	addComponent(contentPane, bgr,10,30,300,30);
 		addComponent(contentPane, jButton1,75,100,200,30);
 		addComponent(contentPane, jButton2, 75,150,200,30);
		addComponent(contentPane,jButton4,75,200,200,30);
	//	addComponent(contentPane,jButton5,75,250,200,30);
		//addComponent(contentPane, jButton3,75,300,200,30);

		this.setTitle("Doctor Menu");
		int x = (d.height/2) - 200;
		int y = (d.width/2) - 250;
 		this.setLocation(new Point(y, x));
 		this.setSize(new Dimension(300, 400));
 	}
 	private void addComponent(Container container,Component c,int x,int y,int width,int height){
 		c.setBounds(x,y,width,height);
 		container.add(c);
 	}


 	private void jButton1_actionPerformed(ActionEvent e){
 		//System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
 	}

 	private void jButton2_actionPerformed(ActionEvent e){
 		//System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
 	}



  /** This method is used to send the request to the next Machine where lowest cpu usage machine
  *
  */

	/*private String sendRequest(String s){
		String res = "";
		try {
			Socket socket = new Socket("localhost",111); // Request will send to the main server
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());			
			dout.writeUTF(s);
			System.out.println("Sent the request to server getting VLC");
			DataInputStream din = new DataInputStream(socket.getInputStream());
			res = din.readUTF();
			System.out.println("Reply string from server...."+res);
		}catch(Exception e){e.printStackTrace();}
		return res;
			
		
	}

	private String sendRequestTrustedParty(String msg){
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


