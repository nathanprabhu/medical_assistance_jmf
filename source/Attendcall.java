import javax.swing.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Attendcall extends JFrame 
 {
    private JLabel jbp,jsugar,jbpno,jsugarno;
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
	String bp="";
	String sugar="";
	public Attendcall(String name){
 		super();
		this.name=name;
		db=new Database();
		try{
			 con=db.getConnection();
					stmt=con.createStatement();
					rs=stmt.executeQuery("select *  from patientstatus where docname='"+name+"' and status='on'");
					if(rs.next()){
                      bp=rs.getString("bp");
					  sugar=rs.getString("sugar");
					}
		}catch(Exception e){e.printStackTrace();}
		initializeComponent();
		setResizable(false);
 		this.setVisible(true);
       jbpno.setText(bp);
        jsugarno.setText(sugar);
 	}
 	private void initializeComponent(){
 	
		JLabel bgr;
		bgr = new JLabel();
		tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();
 		jbp = new JLabel("Heart Bit   :");
        jbpno= new JLabel(bp);
		jsugar= new JLabel("Temp  :");
		jsugarno= new JLabel(sugar);
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

		jButton1.setText("Medicine Availablity");
 		jButton1.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
			    dispose();
				new MedicineAvailability(name);
				/*try{
				 String  str = "VLC";
				  str = sendRequest(str);
				  //StringTokenizer st = new StringTokenizer(str,"$");
				  //String ip = (String)st.nextToken();
				  if(str.intern() == "OK"){
				  String ip = "127.0.0.1";
				  String msg = "//"+ip+"\\VLC\\vlc.exe";
				// String msg = "\\VLC\\vlc.exe";
				  FileOutputStream fout = new FileOutputStream("vlc.bat");
				  fout.write(msg.getBytes());
				  fout.close();
				  String r = sendRequestTrustedParty("Message From User : VLC PLAYER......");
				    if(r.intern() =="SENT"){
					System.out.println("Message sent to the Trusted Party.........");
				    }
				  CallVLC cl = new CallVLC();
				  System.out.println("Vlc Player started.....");


				  	
				  }

				}catch(Exception ex){
					ex.printStackTrace();
					System.out.println(ex);
				}*/
				
			}
   		});

// Hospital
		
		jButton2.setText("Issue of Medicine");
 		jButton2.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
				dispose();
				new IssuseMedicine(name);
				/*try{
					dispose();
				  String str =  JOptionPane.showInputDialog(MainMenu.this,"Enter the Specialist:");
				  str = "hospital$"+str;
				  str = sendRequest(str);

				  HospitalInformation hi = new HospitalInformation(str);


				}catch(Exception ex){
					ex.printStackTrace();
					System.out.println(ex);
				}*/
			}
		});

    	jButton4.setText("Back");
 		jButton4.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
				try{
					dispose();
					new DoctorMenu(name);
					//con=db.getConnection();
					//stmt=con.createStatement();
					//stmt.executeUpdate("update doc_registeration set status='out' where doc_name='"+name+"'");
              
				//System.exit(0);
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

		jButton5.setText("Print Prescription");
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
				}*/
			}
		});



	
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
		addComponent(contentPane,jbp,35,200,75,30);
        addComponent(contentPane,jbpno,100,200,75,30);
		addComponent(contentPane,jsugar,200,200,75,30);
        addComponent(contentPane,jsugarno,255,200,75,30);
		addComponent(contentPane,jButton5,75,250,200,30);
		addComponent(contentPane,jButton4,75,300,200,30);
       // addComponent(contentPane,jButton4,75,300,200,30);
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


