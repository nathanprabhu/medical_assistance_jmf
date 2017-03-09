import javax.swing.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Makecall extends JFrame 
 {
    private JLabel jLabel1;
 	private JTextField jTextField1;
	Toolkit tk;
	Dimension d;
	private JButton jButton0;
 	private JButton jButton1;
 	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	String name=null;

 	private JPanel contentPane;
	
	public Makecall(){
 		super();
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
        jButton0 = new JButton();
		jButton1 = new JButton();
 		jButton2 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();

		jButton5 = new JButton();

		bgr.setText("Vedio & Audio Chatting");
		bgr.setFont(new Font("monotype corsiva",2,30));			
		contentPane = (JPanel)this.getContentPane();

		
		// Cloud Computing
		jButton0.setText("SEND VOICE");
 		jButton0.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
				try{
				Runtime run=Runtime.getRuntime();
				Process process=null;

		        process=run.exec("cmd /c start server.bat");
				}catch(Exception ex){}
				/*dispose();
				dispose();
				new DoctorRegisteration();*/
				
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
		
		jButton1.setText("SEND VEDIO");
 		jButton1.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
				try{
				Runtime run=Runtime.getRuntime();
				Process process=null;

		        process=run.exec("cmd /c start server.bat");
				}catch(Exception ex){}
				/*dispose();
				 DoctorAvailability doctoravailability=new DoctorAvailability();

			doctoravailability.setLayout(null);
			doctoravailability.setSize(400,400);
			doctoravailability.setLocation(350,180);
			doctoravailability.setVisible(true);
			doctoravailability.setResizable(false);*/
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

		
		jButton2.setText("RECEIVE VOICE");
 		jButton2.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
             try{
				Runtime run=Runtime.getRuntime();
				Process process=null;

		        process=run.exec("cmd /c start client.bat");
             }catch(Exception ex){}
				//dispose();
				//new AddMedicine();
				
			
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

    	jButton4.setText("RECEIVE VEDIO");
 		jButton4.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
				try{
				Runtime run=Runtime.getRuntime();
				Process process=null;

		        process=run.exec("cmd /c start client.bat");
				}catch(Exception ex){}

                //dispose();
				//new AdminMedicineAvailability();
				//new CheckexpireDate();
			/*	try{
					/*dispose();
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


		jButton5.setText("Log out");
 		jButton5.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
					dispose();
				//try{
					//dispose();
					//new CheckexpireDate();
					/* String str =  JOptionPane.showInputDialog(MainMenu.this,"Enter Student Id:");
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


		/*jButton3.setText("Logout");
 		jButton3.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e){
 				System.exit(0);

 			}

 		});*/
		contentPane.setLayout(null);
    	addComponent(contentPane, bgr,10,20,300,30);
        addComponent(contentPane, jButton0,75,60,200,30);
 		addComponent(contentPane, jButton1,75,100,200,30);
 		addComponent(contentPane, jButton2, 75,150,200,30);
		addComponent(contentPane,jButton4,75,200,200,30);
		//addComponent(contentPane,jButton5,75,250,200,30);
		//addComponent(contentPane, jButton3,75,300,200,30);

		this.setTitle("Admin Menu");
		int x = (d.height/2) - 200;
		int y = (d.width/2) - 250;
 		this.setLocation(new Point(y, x));
 		this.setSize(new Dimension(300, 350));
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
			
		
	}*/

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
public static void main(String ar[]){
 new Makecall();
}
 }


